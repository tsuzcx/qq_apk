package com.tencent.qqmini.sdk.plugins.engine;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import com.tencent.qqmini.sdk.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent.Builder;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import com.tencent.qqmini.sdk.widget.AuthDialog.AuthDialogResBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseJsPluginEngine
  implements IJsPluginEngine
{
  public static final String APP_IN_BACKGROUND_HINT = "Cannot show subscribe message UI";
  public static final String APP_IS_BANNED_HINT = "This mini program was banned from subscribing messages";
  public static final String EMPTY_PARAM_LIST_HINT = "msgTypeList can't be empty";
  public static final int ERROR_APP_IN_BACKGROUND = 10005;
  public static final int ERROR_APP_IS_BANNED = 20005;
  public static final int ERROR_EMPTY_PARAM_LIST = 10001;
  public static final int ERROR_INVALID_TEMPLATE_ID = 10004;
  public static final int ERROR_MAIN_SWITCH_OFF = 20004;
  public static final int ERROR_REQUEST_LIST_FAIL = 10002;
  public static final int ERROR_REQUEST_SUBSCRIBE_FAIL = 10003;
  private static final String EVENT_AUTHORIZE = "authorize";
  private static final String EVENT_OPERATE_WXDATA = "operateWXData";
  private static final String EVENT_SUBSCRIBE_APP_MSG = "subscribeAppMsg";
  private static final String EVENT_SUBSCRIBE_ONCE_APP_MSG = "subscribeOnceAppMsg";
  private static final String EVENT_SUBSCRIBE_SYS_MSG = "requestSubscribeSystemMessage";
  public static final String INVALID_TEMPLATE_ID_HINT = "Invalid template id";
  public static final String KEY_APPID = "key_appid";
  private static final String KEY_CALLBACK_ID = "key_callback_id";
  private static final String KEY_EVENT_NAME = "key_event_name";
  public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
  private static final String KEY_PARAMS = "key_params";
  private static final String KEY_SCOPE_NAME = "key_scope_name";
  private static final String KEY_SETTING_ITEM = "key_setting_item";
  public static final String MAIN_SWITCH_OFF_HINT = "The main switch is switched off";
  public static final String REQUEST_LIST_FAIL_HINT = "Request list fail";
  public static final String REQUEST_SUBSCRIBE_FAIL_HINT = "Request subscribe fail";
  public static final String SETTING_APP_MSG_SUBSCRIBED = "setting.appMsgSubscribed";
  public static final String SETTING_APP_ONCE_MSG_SUBSCRIBED = "setting.onceMsgSubscribed";
  public static final String SETTING_SYS_MSG_SUBSCRIBED = "setting.sysMsgSubscribed";
  private static final int SUBSCRIBE_CODE_FAIL_OTHER = -2;
  private static final int SUBSCRIBE_CODE_REJECT = -1;
  private static final int SUBSCRIBE_CODE_REJECT_FIRST = 0;
  private static final int SUBSCRIBE_CODE_SUC = 1;
  private static final String TAG = "JsPluginEngine[AuthGuard]";
  private static final int WHAT_NOTIFY_SCOPE_PERMISSION_QUEUE = 1;
  private static final int WHAT_SHOW_AUTH_DIALOG = 2;
  AuthDialog authDialog;
  private RequestEvent curScopeEvent;
  private DialogInterface.OnDismissListener dismissListener = new BaseJsPluginEngine.3(this);
  private boolean isFirstTimeRequestAuth;
  private Handler mHandler = new Handler(Looper.getMainLooper(), new BaseJsPluginEngine.4(this));
  protected IMiniAppContext mMiniAppContext;
  private Map<Integer, PhoneNumberAction.PhoneNumberActionCallback> mPhoneNumberActionCallbackMap = new ConcurrentHashMap();
  DialogInterface.OnDismissListener onceSubDismissListener = new BaseJsPluginEngine.1(this);
  private RequestEvent onceSubMsgReq;
  ConcurrentLinkedQueue<RequestEvent> scopePermissionQueue = new ConcurrentLinkedQueue();
  
  public BaseJsPluginEngine(Context paramContext)
  {
    initPermissionParser(paramContext);
  }
  
  private String checkRequestScopePermission(RequestEvent paramRequestEvent)
  {
    String str1 = paramRequestEvent.event;
    String str2 = paramRequestEvent.jsonParams;
    if ("subscribeAppMsg".equals(str1)) {
      return reqGrantSubscribeApiPermission(paramRequestEvent);
    }
    if ("subscribeOnceAppMsg".equals(str1))
    {
      reqGrantOnceSubscribeApiPermission(paramRequestEvent);
      return "";
    }
    if ("requestSubscribeSystemMessage".equals(str1))
    {
      reqGrantSystemSubscribeApiPermission(paramRequestEvent);
      return "";
    }
    String str3 = getAppId();
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(str3);
    String str4 = getRequestScopePermission(str1, str2);
    if (isGrantedAuthorize(str1, str2, str3, localAuthState, str4))
    {
      if ("authorize".equals(paramRequestEvent.event)) {
        return handleAuthorizeEvent(paramRequestEvent);
      }
      return dispatchRequestEvent(paramRequestEvent);
    }
    showRequestPermissionDialog(paramRequestEvent, str4);
    return "";
  }
  
  private RequestEvent createRequestEvent(String paramString1, String paramString2, IJsService paramIJsService, int paramInt)
  {
    return new RequestEvent.Builder().setEvent(paramString1).setJsonParams(paramString2).setJsService(paramIJsService).setCallbackId(paramInt).build();
  }
  
  private void doShowAuthDialog(String paramString1, String paramString2)
  {
    Object localObject = PermissionManager.g().getScopePermission(paramString2);
    String str1 = "";
    String str2 = "";
    String str4 = "";
    String str3 = "";
    if (localObject != null)
    {
      str1 = ((PermissionInfo)localObject).name;
      str2 = ((PermissionInfo)localObject).description;
      str4 = ((PermissionInfo)localObject).rejectDescription;
      str3 = ((PermissionInfo)localObject).reportSubAction;
    }
    localObject = this.mMiniAppContext.getContext();
    ApkgInfo localApkgInfo = getApkgInfo();
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    String str5;
    String str6;
    if (localApkgInfo != null)
    {
      str5 = localApkgInfo.iconUrl;
      str6 = localApkgInfo.apkgName;
      if ("scope.userInfo".equals(paramString2)) {
        showScopeUserInfoAuthDialog(str1, str2, str3, (Context)localObject, localApkgInfo, localChannelProxy, localMiniAppProxy, str5, str6);
      }
    }
    else
    {
      return;
    }
    showDefaultAuthDialog(paramString1, str1, str2, str4, str3, (Context)localObject, localMiniAppProxy, str5, str6);
  }
  
  private static String extractApiNameInJsonParams(String paramString)
  {
    String str1 = "";
    try
    {
      paramString = new JSONObject(paramString).optString("api_name");
      String str2 = paramString;
      str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        str2 = paramString.trim();
      }
      return str2;
    }
    catch (Throwable paramString) {}
    return str1;
  }
  
  private static String extractScopeNameInJsonParams(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("scope").getString(0);
      String str = paramString;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          str = paramString.trim();
        }
        return str;
      }
      catch (Throwable localThrowable2)
      {
        break label39;
      }
      localThrowable1 = localThrowable1;
      paramString = "";
    }
    label39:
    return paramString;
  }
  
  private int getAuthDialogType(String paramString)
  {
    int i = 1;
    if ("getPhoneNumber".equals(paramString)) {
      i = 2;
    }
    do
    {
      return i;
      if ("subscribeOnceAppMsg".equals(paramString)) {
        return 3;
      }
    } while (!"requestSubscribeSystemMessage".equals(paramString));
    return 4;
  }
  
  private static String getRequestScopePermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      localObject = extractScopeNameInJsonParams(paramString2);
      if (isScopePermissionValid((String)localObject)) {
        return localObject;
      }
    }
    String str2 = extractApiNameInJsonParams(paramString2);
    if (TextUtils.isEmpty(str2)) {}
    for (Object localObject = paramString1;; localObject = paramString1 + "." + str2)
    {
      String str1 = PermissionManager.g().getScopePermissionByEvent((String)localObject);
      localObject = str1;
      if (!"operateWXData".equals(paramString1)) {
        break;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      return handleOperateWXDataScopeName(paramString2, str1);
    }
  }
  
  private static String getRequestSystemPermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      paramString1 = extractScopeNameInJsonParams(paramString2);
      paramString1 = PermissionManager.g().getEventByScopePermission(paramString1);
      return PermissionManager.g().getEventRequestSystemPermission(paramString1);
    }
    return PermissionManager.g().getEventRequestSystemPermission(paramString1);
  }
  
  private int getScopePermissionAuthFlag(String paramString)
  {
    return getScopePermissionAuthFlag(paramString, null);
  }
  
  private int getScopePermissionAuthFlag(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return 1;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString2 != null) {}
    try
    {
      localObject1 = new JSONObject(paramString2).optJSONObject("data").optJSONObject("data").optString("miniprogram_appid");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return MiniAppEnv.g().getAuthSate((String)localObject1).getPermissionAuthFlag(paramString1);
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        localObject1 = localObject2;
        continue;
        localObject1 = getAppId();
      }
    }
  }
  
  public static String getScopePluginSetauthName(String paramString1, String paramString2)
  {
    return "scope.plugin.setauth." + paramString1 + "." + paramString2;
  }
  
  @NotNull
  private AsyncResult getUpdateOnceSubMsgListener(boolean paramBoolean1, boolean paramBoolean2, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, List<INTERFACE.StSubscribeMessage> paramList3)
  {
    return new BaseJsPluginEngine.2(this, paramBoolean1, paramList1, paramList2, paramList3, paramBoolean2);
  }
  
  private void grantSubscribePermissionSilent(AuthState paramAuthState, String paramString, RequestEvent paramRequestEvent)
  {
    paramAuthState.setAuthState(paramString, true, new BaseJsPluginEngine.8(this, paramRequestEvent));
  }
  
  private void handleAuthRefuse(Message paramMessage, Iterator<RequestEvent> paramIterator)
  {
    paramMessage = (String)paramMessage.obj;
    QMLog.e("JsPluginEngine[AuthGuard]", "handleAuthRefuse, scopeName:" + paramMessage);
    if ((!TextUtils.isEmpty(paramMessage)) && (!paramMessage.equals("setting.appMsgSubscribed")))
    {
      if (paramMessage.equals("scope.camera")) {
        this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onCameraNeedAuthCancel", null, 0));
      }
      if ((this.curScopeEvent != null) && (paramMessage.equals(getRequestScopePermission(this.curScopeEvent.event, this.curScopeEvent.jsonParams)))) {
        this.curScopeEvent.fail("auth deny");
      }
      while (paramIterator.hasNext())
      {
        RequestEvent localRequestEvent = (RequestEvent)paramIterator.next();
        if (paramMessage.equals(getRequestScopePermission(localRequestEvent.event, localRequestEvent.jsonParams)))
        {
          paramIterator.remove();
          localRequestEvent.fail("auth deny");
        }
      }
    }
  }
  
  private String handleAuthorizeEvent(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        str1 = getAppId();
        localAuthState = MiniAppEnv.g().getAuthSate(str1);
        str2 = extractScopeNameInJsonParams(paramRequestEvent.jsonParams);
        if ((localAuthState == null) || (!isScopePermissionValid(str2))) {
          continue;
        }
        bool = localAuthState.isSynchronized();
        if ((!str2.startsWith("setting")) || (bool)) {
          continue;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(str1, new BaseJsPluginEngine.6(this, localAuthState, str2, str1, paramRequestEvent));
      }
      catch (Throwable localThrowable)
      {
        String str1;
        AuthState localAuthState;
        String str2;
        boolean bool;
        QMLog.e("JsPluginEngine[AuthGuard]", localThrowable.getMessage(), localThrowable);
        paramRequestEvent.fail();
        continue;
        sendShowAuthDialogMessage(paramRequestEvent, str2);
        continue;
        QMLog.w("JsPluginEngine[AuthGuard]", "handleAuthorizeEvent, authState is null or scope invalid, scope = " + str2);
        paramRequestEvent.fail();
        continue;
      }
      return "";
      bool = localAuthState.isPermissionGranted(str2);
      if (AuthFilterList.isAppInWhiteList(str1)) {
        bool = true;
      }
      if (!bool) {
        continue;
      }
      paramRequestEvent.ok();
    }
  }
  
  private void handleNextScopeReq()
  {
    this.curScopeEvent = null;
    RequestEvent localRequestEvent = (RequestEvent)this.scopePermissionQueue.poll();
    if (localRequestEvent != null)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "handleNextScopeReq, event : " + localRequestEvent.event + "; jsonParams : " + localRequestEvent.jsonParams);
      sendShowAuthDialogMessage(localRequestEvent);
    }
  }
  
  private void handleOnceSubscribeResponse(RequestEvent paramRequestEvent, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      int i;
      Object localObject3;
      try
      {
        String str = paramJSONObject.optString("settingItem");
        localObject1 = paramJSONObject.opt("originalData");
        localObject2 = new INTERFACE.StGetUserSettingRsp();
        if ((localObject1 instanceof byte[]))
        {
          localObject1 = (byte[])localObject1;
          ((INTERFACE.StGetUserSettingRsp)localObject2).mergeFrom((byte[])localObject1);
          localObject2 = ((INTERFACE.StGetUserSettingRsp)localObject2).setting.subItems.get();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          i = 0;
          if (i >= ((List)localObject2).size()) {
            break label219;
          }
          localObject3 = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
          if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 0) {
            localArrayList1.add(localObject3);
          } else if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 1) {
            localArrayList2.add(localObject3);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "handleOnceSubscribeResponse get an Error:", localThrowable);
      }
      onceSubMsgCallbackFail(paramRequestEvent, paramJSONObject);
      return;
      if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 2)
      {
        localArrayList3.add(localObject3);
        break label341;
        label219:
        localObject3 = MiniAppEnv.g().getAuthSate(getAppId());
        recordIfNeedMaintain(localThrowable, localArrayList2, localArrayList3, (AuthState)localObject3);
        if ((localArrayList1.size() > 0) && (localArrayList1.size() <= 3))
        {
          if (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo()))
          {
            grantOnceSubscribeApiPermissionSilent(localThrowable, paramRequestEvent, (byte[])localObject1);
            return;
          }
          showOnceSubMsgReqDialog(localThrowable, paramRequestEvent, (byte[])localObject1);
          return;
        }
        if (("setting.onceMsgSubscribed".equals(localThrowable)) && (localArrayList2.size() > 0))
        {
          updateOnceMsgSubscribedItem(paramRequestEvent, localThrowable, (List)localObject2, localArrayList2, (AuthState)localObject3);
          return;
        }
        onceSubMsgCallbackSuc(paramRequestEvent, (List)localObject2);
        return;
      }
      label341:
      i += 1;
    }
  }
  
  private static String handleOperateWXDataScopeName(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new JSONObject(paramString1).optJSONObject("data");
      String str = ((JSONObject)localObject).optString("api_name");
      if (!"webapi_plugin_login".equals(str))
      {
        paramString1 = paramString2;
        if (!"webapi_plugin_getuserinfo".equals(str)) {}
      }
      else
      {
        str = ((JSONObject)localObject).optJSONObject("data").optString("miniprogram_appid");
        localObject = ((JSONObject)localObject).optString("plugin_appid");
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(str))
        {
          paramString1 = paramString2;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramString1 = getScopePluginSetauthName(str, (String)localObject);
          }
        }
      }
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      QMLog.e("JsPluginEngine[AuthGuard]", "handleOperateWXDataScopeName " + paramString1.getMessage(), paramString1);
    }
    return paramString2;
  }
  
  private void handleRequestSystemPermission(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3, Activity paramActivity)
  {
    ActivityResultManager.g().addRequestPermissionResultListener(new BaseJsPluginEngine.5(this, paramString3, paramString1, paramString2, paramRequestEvent));
    paramActivity.requestPermissions(new String[] { paramString3 }, 9527);
  }
  
  private void handleSubMsgAuthListData(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2)
  {
    switch (paramList1.size())
    {
    }
    INTERFACE.StSubscribeMessage localStSubscribeMessage3;
    do
    {
      do
      {
        do
        {
          return;
          localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramList1.get(0);
        } while (judgeOnceSubMsgState(paramBoolean1, paramBoolean2, localStSubscribeMessage1));
        paramList1.remove(localStSubscribeMessage1);
        paramList2.add(localStSubscribeMessage1);
        return;
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramList1.get(0);
        localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramList1.get(1);
        if (!judgeOnceSubMsgState(paramBoolean1, paramBoolean2, localStSubscribeMessage1))
        {
          paramList1.remove(localStSubscribeMessage1);
          paramList2.add(localStSubscribeMessage1);
        }
      } while (judgeOnceSubMsgState(paramBoolean1, paramBoolean3, localStSubscribeMessage2));
      paramList1.remove(localStSubscribeMessage2);
      paramList2.add(localStSubscribeMessage2);
      return;
      INTERFACE.StSubscribeMessage localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramList1.get(0);
      INTERFACE.StSubscribeMessage localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramList1.get(1);
      localStSubscribeMessage3 = (INTERFACE.StSubscribeMessage)paramList1.get(2);
      if (!judgeOnceSubMsgState(paramBoolean1, paramBoolean2, localStSubscribeMessage1))
      {
        paramList1.remove(localStSubscribeMessage1);
        paramList2.add(localStSubscribeMessage1);
      }
      if (!judgeOnceSubMsgState(paramBoolean1, paramBoolean3, localStSubscribeMessage2))
      {
        paramList1.remove(localStSubscribeMessage2);
        paramList2.add(localStSubscribeMessage2);
      }
    } while (judgeOnceSubMsgState(paramBoolean1, paramBoolean4, localStSubscribeMessage3));
    paramList1.remove(localStSubscribeMessage3);
    paramList2.add(localStSubscribeMessage3);
  }
  
  private void handleSubMsgDialogDismiss(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, INTERFACE.StGetUserSettingRsp paramStGetUserSettingRsp)
  {
    Object localObject1 = paramStGetUserSettingRsp.setting.subItems.get();
    paramStGetUserSettingRsp = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(i);
      if (((INTERFACE.StSubscribeMessage)localObject2).authState.get() == 0) {
        paramStGetUserSettingRsp.add(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((INTERFACE.StSubscribeMessage)localObject2).authState.get() == 1) {
          localArrayList1.add(localObject2);
        }
      }
    }
    localObject1 = getUpdateOnceSubMsgListener(paramBoolean5, paramBoolean6, (List)localObject1, paramStGetUserSettingRsp, localArrayList2);
    Object localObject2 = MiniAppEnv.g().getAuthSate(getAppId());
    if (paramBoolean5)
    {
      handleSubMsgAuthListData(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramStGetUserSettingRsp, localArrayList2);
      localArrayList2 = new ArrayList();
      localArrayList2.addAll(paramStGetUserSettingRsp);
      localArrayList2.addAll(localArrayList1);
      ((AuthState)localObject2).updateOnceSubMsgSetting(paramString, true, localArrayList2, (AsyncResult)localObject1);
      if ((localArrayList2.size() > 0) && ("setting.sysMsgSubscribed".equals(paramString))) {
        ((AuthState)localObject2).updateIsSysSubMsgMaintain(true);
      }
    }
    for (;;)
    {
      return;
      if (!paramBoolean6) {
        break;
      }
      if (paramBoolean1)
      {
        i = 0;
        while (i < paramStGetUserSettingRsp.size())
        {
          ((INTERFACE.StSubscribeMessage)paramStGetUserSettingRsp.get(i)).authState.set(2);
          i += 1;
        }
        ((AuthState)localObject2).updateOnceSubMsgSetting(paramString, false, paramStGetUserSettingRsp, (AsyncResult)localObject1);
      }
      while ("setting.sysMsgSubscribed".equals(paramString))
      {
        ((AuthState)localObject2).updateIsSysSubMsgMaintain(true);
        return;
        ((AsyncResult)localObject1).onReceiveResult(true, null);
      }
    }
    ((AsyncResult)localObject1).onReceiveResult(true, null);
  }
  
  private void initAuthDialog(Bundle paramBundle, Activity paramActivity, int paramInt)
  {
    if ((this.authDialog == null) || (this.authDialog.getAuthDialogType() != paramInt))
    {
      this.authDialog = new AuthDialog(paramActivity, paramInt);
      if ((paramInt != 3) && (paramInt != 4)) {
        break label61;
      }
      this.authDialog.setOnDismissListener(this.onceSubDismissListener);
    }
    for (;;)
    {
      this.authDialog.bindData(paramBundle);
      return;
      label61:
      this.authDialog.setOnDismissListener(this.dismissListener);
    }
  }
  
  private boolean isGrantedAuthorize(String paramString1, String paramString2, String paramString3, AuthState paramAuthState, String paramString4)
  {
    boolean bool4 = false;
    boolean bool3 = true;
    if (((AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())) || (AuthFilterList.isAppInWhiteList(paramString3))) && (paramAuthState.getAuthFlag(paramString4) == 1)) {
      setScopePermissionAuthState(paramString4, true);
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (isOpenDataEvent(paramString1, paramString2)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramString4 == null) {
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (getScopePermissionAuthFlag(paramString4, paramString2) == 2) {
          bool1 = true;
        }
      }
      if ((bool1) && (shouldAskEveryTime(paramString4))) {
        bool1 = bool4;
      }
      for (;;)
      {
        if ((!bool1) && (isMakeReuqestFirstEvent(paramString1))) {
          bool1 = bool3;
        }
        for (;;)
        {
          if (!bool1) {
            QMLog.e("JsPluginEngine[AuthGuard]", "checkRequestScopePermission granted=" + bool1 + ",eventName=" + paramString1);
          }
          return bool1;
        }
      }
    }
  }
  
  private boolean isMakeReuqestFirstEvent(String paramString)
  {
    return "getPhoneNumber".equals(paramString);
  }
  
  private static boolean isOpenDataApi(String paramString)
  {
    return ("webapi_getuserinfo_opendata".equals(paramString)) || ("webapi_getadvert".equals(paramString)) || ("webapi_getwerunstep_history".equals(paramString)) || ("advert_tap".equals(paramString)) || ("getBlockAd".equals(paramString)) || ("webapi_getnavigatewxaappinfo".equals(paramString)) || ("webapi_plugin_setauth".equals(paramString));
  }
  
  private static boolean isOpenDataEvent(String paramString1, String paramString2)
  {
    if ("operateWXData".equals(paramString1)) {}
    try
    {
      paramString2 = new JSONObject(paramString2).optJSONObject("data");
      paramString1 = paramString2.optString("api_name");
      if (isOpenDataApi(paramString1)) {
        return true;
      }
      if (("webapi_plugin_login".equals(paramString1)) || ("webapi_plugin_getuserinfo".equals(paramString1)))
      {
        paramString1 = paramString2.optJSONObject("data").optString("miniprogram_appid");
        paramString2 = paramString2.optString("plugin_appid");
        String str = AuthState.getAllowPluginScopeName();
        if (str != null)
        {
          boolean bool = str.equals(getScopePluginSetauthName(paramString1, paramString2));
          if (bool) {
            break label111;
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      label105:
      break label105;
    }
    return false;
    label111:
    return true;
  }
  
  private static boolean isScopePermissionValid(String paramString)
  {
    return PermissionManager.g().isScopePermissionValid(paramString);
  }
  
  private boolean judgeOnceSubMsgState(boolean paramBoolean1, boolean paramBoolean2, INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    boolean bool = false;
    if (paramBoolean1) {
      if (paramBoolean2) {
        paramStSubscribeMessage.authState.set(1);
      }
    }
    for (;;)
    {
      paramBoolean1 = true;
      do
      {
        return paramBoolean1;
        paramStSubscribeMessage.authState.set(2);
        break;
        paramBoolean1 = bool;
      } while (!paramBoolean2);
      paramStSubscribeMessage.authState.set(0);
    }
  }
  
  private boolean needShowAuthDialog(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!paramBoolean) || (shouldAskEveryTime(paramString1))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      try
      {
        if ("operateWXData".equals(paramString2))
        {
          paramString1 = new JSONObject(paramString3).optJSONObject("data");
          paramString2 = paramString1.optString("api_name");
          if (("webapi_getuserinfo".equals(paramString2)) || ("getSubjectalterInfo".equals(paramString2)) || ("webapi_wxa_subscribe_biz".endsWith(paramString2))) {
            return paramString1.optBoolean("from_component");
          }
          if ((!"webapi_plugin_login".equals(paramString2)) && (!"webapi_plugin_getuserinfo".equals(paramString2)))
          {
            boolean bool = "webapi_plugin_setauth".equals(paramString2);
            if (!bool) {}
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable paramString1)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", Log.getStackTraceString(paramString1));
      }
      return paramBoolean;
    }
  }
  
  private void notifyScopePermissionQueue(Message paramMessage)
  {
    Iterator localIterator = this.scopePermissionQueue.iterator();
    if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "notifyScopePermissionQueue AUTH_FLAG_CANCEL / AUTH_FLAG_REFUSE");
      handleAuthRefuse(paramMessage, localIterator);
      if ((this.curScopeEvent == null) || (!"subscribeAppMsg".equals(this.curScopeEvent.event))) {
        break label125;
      }
      reqGrantSubscribeApiPermission(this.curScopeEvent);
    }
    for (;;)
    {
      handleNextScopeReq();
      return;
      if ((this.curScopeEvent == null) || (!"authorize".equals(this.curScopeEvent.event)) || (paramMessage.arg1 != 1)) {
        break;
      }
      this.curScopeEvent.ok();
      QMLog.e("JsPluginEngine[AuthGuard]", "notifyScopePermissionQueue AUTH_FLAG_GRANT && EVENT_AUTHORIZE");
      handleNextScopeReq();
      return;
      label125:
      if (this.curScopeEvent != null) {
        dispatchRequestEvent(this.curScopeEvent);
      }
    }
  }
  
  private void recordIfNeedMaintain(String paramString, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, AuthState paramAuthState)
  {
    if ((paramList1.size() > 0) || (paramList2.size() > 0))
    {
      if (!"setting.sysMsgSubscribed".equals(paramString)) {
        break label34;
      }
      paramAuthState.updateIsSysSubMsgMaintain(true);
    }
    label34:
    while (!"setting.onceMsgSubscribed".equals(paramString)) {
      return;
    }
    paramAuthState.updateIsOnceSubMsgMaintain(true);
  }
  
  private void removeAllMessage()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
  }
  
  private void reqGrantOnceSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    JSONArray localJSONArray;
    ArrayList localArrayList;
    try
    {
      localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("tmplIds");
      if (localJSONArray == null) {
        break label159;
      }
      localArrayList = new ArrayList();
      if (localJSONArray.length() > 3)
      {
        onceSubMsgCallbackFail(paramRequestEvent, "Templates count out of max bounds", 20003);
        return;
      }
      if (localJSONArray.length() == 0)
      {
        onceSubMsgCallbackFail(paramRequestEvent, "TmplIds can't be empty", 10001);
        return;
      }
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "reqGrantOnceSubscribeApiPermission get an Exception:" + paramRequestEvent);
      return;
    }
    int i = 0;
    while (i < localJSONArray.length())
    {
      localArrayList.add(localJSONArray.getString(i));
      i += 1;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.onceMsgSubscribed", localArrayList, new BaseJsPluginEngine.9(this, paramRequestEvent));
    return;
    label159:
    QMLog.e("JsPluginEngine[AuthGuard]", "reqGrantOnceSubscribeApiPermission: tmplIdJsonArr is null!");
    onceSubMsgCallbackFail(paramRequestEvent, "TmplIds can't be empty", 10001);
  }
  
  private String reqGrantSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    Object localObject2 = MiniAppEnv.g().getAuthSate(getAppId());
    Object localObject1 = getRequestScopePermission(paramRequestEvent.event, paramRequestEvent.jsonParams);
    if (QMLog.isColorLevel()) {
      QMLog.d("JsPluginEngine[AuthGuard]", "reqGrantSubscribeApiPermission scopePermission=" + (String)localObject1);
    }
    if ((!QUAUtil.isQQApp()) && (!QUAUtil.isDemoApp()))
    {
      QMLog.w("JsPluginEngine[AuthGuard]", "Invalid SDK host, reject all subscribeAppMsg");
      ((AuthState)localObject2).setAuthState((String)localObject1, false);
      paramRequestEvent.fail("Invalid SDK host, no permission");
      return "";
    }
    if (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo()))
    {
      grantSubscribePermissionSilent((AuthState)localObject2, (String)localObject1, paramRequestEvent);
      return "";
    }
    if (((AuthState)localObject2).getAuthFlag((String)localObject1) == 1)
    {
      this.isFirstTimeRequestAuth = true;
      if ((this.authDialog == null) || (!this.authDialog.isShowing()))
      {
        localObject2 = this.mHandler.obtainMessage(2);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_event_name", paramRequestEvent.event);
        localBundle.putString("key_params", paramRequestEvent.jsonParams);
        localBundle.putString("key_scope_name", (String)localObject1);
        localBundle.putInt("key_callback_id", paramRequestEvent.callbackId);
        ((Message)localObject2).setData(localBundle);
        ((Message)localObject2).sendToTarget();
      }
    }
    for (;;)
    {
      return "";
      if (((AuthState)localObject2).isPermissionGranted((String)localObject1))
      {
        this.isFirstTimeRequestAuth = false;
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 1);
          paramRequestEvent.ok((JSONObject)localObject1);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      }
      localObject1 = new JSONObject();
      try
      {
        if (this.isFirstTimeRequestAuth) {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 0);
        }
        for (;;)
        {
          paramRequestEvent.fail((JSONObject)localObject1, "no permission");
          this.isFirstTimeRequestAuth = false;
          break;
          ((JSONObject)localObject1).put("subscribeAppMsgCode", -1);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  private void reqGrantSystemSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "reqGrantSystemSubscribeApiPermission jsonParams: " + paramRequestEvent.jsonParams);
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("msgTypeList");
      if ((localJSONArray == null) || (localJSONArray.length() > 3))
      {
        onceSubMsgCallbackFail(paramRequestEvent, "Invalid template id", 10004);
        return;
      }
      if (localJSONArray.length() == 0)
      {
        onceSubMsgCallbackFail(paramRequestEvent, "msgTypeList can't be empty", 10001);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "reqGrantSystemSubscribeApiPermission get an Exception:" + localException);
      onceSubMsgCallbackFail(paramRequestEvent, "Invalid template id", 10004);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localException.length())
    {
      localArrayList.add(localException.getString(i));
      i += 1;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.sysMsgSubscribed", localArrayList, new BaseJsPluginEngine.7(this, paramRequestEvent));
  }
  
  private void sendShowAuthDialogMessage(RequestEvent paramRequestEvent)
  {
    sendShowAuthDialogMessage(paramRequestEvent, extractScopeNameInJsonParams(paramRequestEvent.jsonParams), true);
  }
  
  private void sendShowAuthDialogMessage(RequestEvent paramRequestEvent, String paramString)
  {
    sendShowAuthDialogMessage(paramRequestEvent, paramString, true);
  }
  
  private void sendShowAuthDialogMessage(RequestEvent paramRequestEvent, String paramString, boolean paramBoolean)
  {
    if (((this.authDialog == null) || (!this.authDialog.isShowing())) && (this.curScopeEvent == null))
    {
      this.curScopeEvent = paramRequestEvent;
      localBundle = new Bundle();
      localBundle.putString("key_event_name", paramRequestEvent.event);
      localBundle.putString("key_params", paramRequestEvent.jsonParams);
      localBundle.putString("key_scope_name", paramString);
      localBundle.putInt("key_callback_id", paramRequestEvent.callbackId);
      localBundle.putString("key_appid", getAppId());
      paramRequestEvent = this.mHandler.obtainMessage(2);
      paramRequestEvent.setData(localBundle);
      paramRequestEvent.sendToTarget();
    }
    while ((!paramBoolean) || (paramRequestEvent == null))
    {
      Bundle localBundle;
      return;
    }
    QMLog.d("JsPluginEngine[AuthGuard]", "sendShowAuthDialogMessage scopePermissionQueue.offer, event : " + paramRequestEvent.event + "; jsonParams : " + paramRequestEvent.jsonParams);
    this.scopePermissionQueue.offer(paramRequestEvent);
  }
  
  private void setScopePermissionAuthState(String paramString, boolean paramBoolean)
  {
    String str = getAppId();
    MiniAppEnv.g().getAuthSate(str).setAuthState(paramString, paramBoolean);
  }
  
  private boolean shouldAskEveryTime(String paramString)
  {
    String str = getAppId();
    return MiniAppEnv.g().getAuthSate(str).shouldAskEveryTime(paramString);
  }
  
  private void showAuthDialog(Bundle paramBundle)
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      QMLog.w("JsPluginEngine[AuthGuard]", "showAuthDialog(). Do nothing, activity is null or finishing");
    }
    String str1;
    do
    {
      return;
      String str2 = paramBundle.getString("key_event_name", "");
      str1 = paramBundle.getString("key_params", "");
      QMLog.d("JsPluginEngine[AuthGuard]", "showAuthDialog, event: " + str2 + ";params : " + str1);
      initAuthDialog(paramBundle, localActivity, getAuthDialogType(str2));
      paramBundle = paramBundle.getString("key_scope_name", "");
    } while (paramBundle == null);
    doShowAuthDialog(str1, paramBundle);
  }
  
  private void showDefaultAuthDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Context paramContext, MiniAppProxy paramMiniAppProxy, String paramString6, String paramString7)
  {
    if (this.authDialog != null) {
      localAuthDialogResBuilder = null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1).optJSONObject("getPhoneNumber");
      paramString1 = localAuthDialogResBuilder;
      if (localJSONObject != null)
      {
        paramString1 = localAuthDialogResBuilder;
        if (localJSONObject.has("phoneLists")) {
          paramString1 = localJSONObject.optJSONArray("phoneLists");
        }
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "get phoneNumberList error,", paramString1);
        paramString1 = null;
      }
    }
    AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
    localAuthDialogResBuilder.setMiniAppIconUrl(paramMiniAppProxy.getDrawable(paramContext, paramString6, 0, 0, null)).setMiniAppName(paramString7).setAuthTitle(paramString2).setAuthDesc(paramString3).setReportSubAction(paramString5).setMiniAppInfo(this.mMiniAppContext.getMiniAppInfo()).setLeftBtnText(paramString4).setLeftBtnClickListener(new BaseJsPluginEngine.12(this)).setRightBtnText("允许").setRightBtnClickListener(new BaseJsPluginEngine.11(this));
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localAuthDialogResBuilder.setPhoneNumberList(paramString1);
    }
    this.authDialog.setCanceledOnTouchOutside(false);
    this.authDialog.show(localAuthDialogResBuilder);
  }
  
  private void showOnceSubMsgReqDialog(String paramString, RequestEvent paramRequestEvent, byte[] paramArrayOfByte)
  {
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      this.onceSubMsgReq = paramRequestEvent;
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramRequestEvent.event);
      localBundle.putString("key_setting_item", paramString);
      localBundle.putString("key_params", paramRequestEvent.jsonParams);
      localBundle.putString("key_appid", getAppId());
      localBundle.putByteArray("key_once_sub_rsp_data", paramArrayOfByte);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  private void showRequestPermissionDialog(RequestEvent paramRequestEvent, String paramString)
  {
    showRequestPermissionDialog(paramRequestEvent, paramString, true);
  }
  
  private void showRequestPermissionDialog(RequestEvent paramRequestEvent, String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    String str1 = paramRequestEvent.event;
    String str2 = paramRequestEvent.jsonParams;
    boolean bool1 = bool2;
    if (!isOpenDataEvent(str1, str2))
    {
      bool1 = bool2;
      if (getScopePermissionAuthFlag(paramString) == 4) {
        bool1 = true;
      }
    }
    QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest hasRefused=" + bool1);
    if (needShowAuthDialog(paramString, str1, str2, bool1))
    {
      sendShowAuthDialogMessage(paramRequestEvent, paramString, paramBoolean);
      return;
    }
    QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest callbackJsEventFail");
    paramRequestEvent.fail("auth deny");
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  private void showScopeUserInfoAuthDialog(String paramString1, String paramString2, String paramString3, Context paramContext, ApkgInfo paramApkgInfo, ChannelProxy paramChannelProxy, MiniAppProxy paramMiniAppProxy, String paramString4, String paramString5)
  {
    paramChannelProxy.getUserInfo(paramApkgInfo.appId, false, "en", new BaseJsPluginEngine.13(this, paramMiniAppProxy, paramContext, paramString4, paramString5, paramString1, paramString2, paramString3));
  }
  
  private void updateOnceMsgSubscribedItem(RequestEvent paramRequestEvent, String paramString, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, AuthState paramAuthState)
  {
    paramAuthState.updateOnceSubMsgSetting(paramString, true, paramList2, new BaseJsPluginEngine.10(this, paramRequestEvent, paramList1));
  }
  
  public String checkAuthorization(RequestEvent paramRequestEvent)
  {
    String str2 = paramRequestEvent.event;
    String str3 = paramRequestEvent.jsonParams;
    String str1;
    if (AuthFilterList.isEventInSecondaryApiList(str2)) {
      str1 = extractApiNameInJsonParams(str3);
    }
    while (!AuthFilterList.isEventNameRight(str2, str1))
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "eventname : " + str2 + "; apiName : " + str1 + " request failed.");
      if (str2.endsWith("Sync"))
      {
        return ApiUtil.wrapCallbackFail(str2, null, "no permission").toString();
        str1 = "";
      }
      else
      {
        paramRequestEvent.fail("no permission");
        return "";
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      str1 = getRequestSystemPermission(str2, str3);
      if (!StringUtil.isEmpty(str1))
      {
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        if (localActivity == null)
        {
          QMLog.w("JsPluginEngine[AuthGuard]", "Activity is null. Ignore event " + str2);
          return "";
        }
        if (localActivity.checkSelfPermission(str1) == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          handleRequestSystemPermission(paramRequestEvent, str2, str3, str1, localActivity);
          return "";
        }
        return checkRequestScopePermission(paramRequestEvent);
      }
      return checkRequestScopePermission(paramRequestEvent);
    }
    return checkRequestScopePermission(paramRequestEvent);
  }
  
  abstract String dispatchRequestEvent(RequestEvent paramRequestEvent);
  
  protected ApkgInfo getApkgInfo()
  {
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null)) {
      return (ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo;
    }
    return null;
  }
  
  protected String getAppId()
  {
    if (getApkgInfo() != null) {
      return getApkgInfo().appId;
    }
    return null;
  }
  
  protected void grantOnceSubscribeApiPermissionSilent(String paramString, RequestEvent paramRequestEvent, byte[] paramArrayOfByte)
  {
    paramRequestEvent = new INTERFACE.StGetUserSettingRsp();
    if (paramArrayOfByte != null) {}
    try
    {
      paramRequestEvent.mergeFrom(paramArrayOfByte);
      handleSubMsgDialogDismiss(paramString, false, true, true, true, true, false, paramRequestEvent);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", paramArrayOfByte);
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, IJsService paramIJsService, int paramInt)
  {
    if (this.mMiniAppContext == null) {
      return "";
    }
    QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest: eventName:" + paramString1 + "  callbackId:" + paramInt);
    return checkAuthorization(createRequestEvent(paramString1, paramString2, paramIJsService, paramInt));
  }
  
  public void initPermissionParser(Context paramContext)
  {
    LocalPermissionParser localLocalPermissionParser = new LocalPermissionParser(paramContext);
    paramContext = new RemotePermissionParser(paramContext);
    PermissionManager.g().startParse(new PermissionParser[] { localLocalPermissionParser, paramContext });
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onCreate");
    this.mMiniAppContext = paramIMiniAppContext;
    paramIMiniAppContext = this.mMiniAppContext.getMiniAppInfo();
    if (paramIMiniAppContext != null)
    {
      AuthFilterList.updateEventRemoteList(paramIMiniAppContext.blackList, paramIMiniAppContext.whiteList);
      AuthFilterList.updateEventSecondaryApiList(paramIMiniAppContext.secondApiRightInfoList);
    }
  }
  
  public void onDestroy()
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onDestroy");
    AuthFilterList.reset();
    this.scopePermissionQueue.clear();
    if (this.authDialog != null)
    {
      this.authDialog.setOnDismissListener(null);
      this.authDialog.dismiss();
      this.authDialog = null;
    }
  }
  
  public void onPause()
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onPause");
    removeAllMessage();
  }
  
  public void onResume()
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onResume");
    if ((this.authDialog != null) && (this.authDialog.isShowing())) {
      return;
    }
    QMLog.i("JsPluginEngine[AuthGuard]", "onResume - WHAT_NOTIFY_SCOPE_PERMISSION_QUEUE");
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void onceSubMsgCallbackFail(RequestEvent paramRequestEvent, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      if (paramRequestEvent != null) {
        paramRequestEvent.fail(localJSONObject, paramString);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackFail get a JSONException:", localJSONException);
      }
    }
  }
  
  public void onceSubMsgCallbackFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.fail(paramJSONObject, null);
    }
  }
  
  public void onceSubMsgCallbackSuc(RequestEvent paramRequestEvent, List<INTERFACE.StSubscribeMessage> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    try
    {
      if (i < paramList.size())
      {
        Object localObject = (INTERFACE.StSubscribeMessage)paramList.get(i);
        String str = ((INTERFACE.StSubscribeMessage)localObject).templateId.get();
        if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 1) {}
        for (localObject = "accept";; localObject = "reject")
        {
          localJSONObject.put(str, localObject);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackSuc get a Exception:", paramList);
      if (paramRequestEvent != null) {
        paramRequestEvent.ok(localJSONObject);
      }
    }
  }
  
  public void onceSubMsgCallbackSuc(RequestEvent paramRequestEvent, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, List<INTERFACE.StSubscribeMessage> paramList3, boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    label85:
    Object localObject;
    label183:
    label195:
    label198:
    int j;
    if (paramBoolean)
    {
      try
      {
        while (i < paramList1.size())
        {
          paramList2 = (INTERFACE.StSubscribeMessage)paramList1.get(i);
          paramList3 = paramList2.templateId.get();
          if (paramList2.authState.get() != 1) {
            break label315;
          }
          paramList2 = "accept";
          localJSONObject.put(paramList3, paramList2);
          i += 1;
          continue;
          if (i >= paramList1.size()) {
            break label195;
          }
          localObject = (INTERFACE.StSubscribeMessage)paramList1.get(i);
          if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 1) {
            localJSONObject.put(((INTERFACE.StSubscribeMessage)localObject).templateId.get(), "accept");
          } else if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 2) {
            localJSONObject.put(((INTERFACE.StSubscribeMessage)localObject).templateId.get(), "reject");
          }
        }
      }
      catch (Exception paramList1)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackSuc get a Exception:", paramList1);
      }
      if (paramRequestEvent != null) {
        paramRequestEvent.ok(localJSONObject);
      }
      return;
      i = 0;
      j = k;
      if (i < paramList2.size())
      {
        paramList1 = (INTERFACE.StSubscribeMessage)paramList2.get(i);
        localObject = paramList1.templateId.get();
        if (paramList1.authState.get() != 2) {
          break label337;
        }
      }
    }
    label315:
    label337:
    for (paramList1 = "reject";; paramList1 = "accept")
    {
      localJSONObject.put((String)localObject, paramList1);
      i += 1;
      break label198;
      while (j < paramList3.size())
      {
        localJSONObject.put(((INTERFACE.StSubscribeMessage)paramList3.get(j)).templateId.get(), "reject");
        j += 1;
      }
      break label183;
      paramList2 = "reject";
      break;
      i = 0;
      break label85;
      i += 1;
      break label85;
    }
  }
  
  public void showRequestPermissionDialog(RequestEvent paramRequestEvent, PhoneNumberAction.PhoneNumberActionCallback paramPhoneNumberActionCallback)
  {
    this.mPhoneNumberActionCallbackMap.put(Integer.valueOf(paramRequestEvent.callbackId), paramPhoneNumberActionCallback);
    showRequestPermissionDialog(paramRequestEvent, getRequestScopePermission(paramRequestEvent.event, paramRequestEvent.jsonParams), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */