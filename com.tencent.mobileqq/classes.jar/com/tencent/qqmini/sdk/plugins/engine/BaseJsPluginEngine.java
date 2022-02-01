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
  private static final String CM_AVATAR_TYPE_2D = "2D";
  private static final String CM_AVATAR_TYPE_3D = "3D";
  private static final String CM_KEY_AVATAR_TYPE = "avatarType";
  private static final String CM_SCOPE_PERMISSION_2D = "scope.cmshowInfo2d";
  private static final String CM_SCOPE_PERMISSION_3D = "scope.cmshowInfo3d";
  public static final String EMPTY_PARAM_LIST_HINT = "msgTypeList can't be empty";
  public static final int ERROR_APP_IN_BACKGROUND = 10005;
  public static final int ERROR_APP_IS_BANNED = 20005;
  public static final int ERROR_EMPTY_PARAM_LIST = 10001;
  public static final int ERROR_INVALID_TEMPLATE_ID = 10004;
  public static final int ERROR_MAIN_SWITCH_OFF = 20004;
  public static final int ERROR_REQUEST_LIST_FAIL = 10002;
  public static final int ERROR_REQUEST_SUBSCRIBE_FAIL = 10003;
  private static final String EVENT_AUTHORIZE = "authorize";
  private static final String EVENT_GET_PHONE_NUMBER = "getPhoneNumber";
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
  private static final String SCOPE_EXPAND_USER_INFO = "scope.expandUserInfo";
  private static final String SCOPE_USER_INFO = "scope.userInfo";
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
    Object localObject3 = PermissionManager.g().getScopePermission(paramString2);
    Object localObject4 = "";
    Object localObject1;
    String str1;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = ((PermissionInfo)localObject3).name;
      str1 = ((PermissionInfo)localObject3).description;
      localObject2 = ((PermissionInfo)localObject3).rejectDescription;
      localObject3 = ((PermissionInfo)localObject3).reportSubAction;
    }
    else
    {
      str1 = "";
      localObject1 = str1;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    localObject4 = this.mMiniAppContext.getContext();
    ApkgInfo localApkgInfo = getApkgInfo();
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (localApkgInfo != null)
    {
      String str2 = localApkgInfo.iconUrl;
      String str3 = localApkgInfo.apkgName;
      if ((!"scope.userInfo".equals(paramString2)) && (!"scope.expandUserInfo".equals(paramString2)))
      {
        showDefaultAuthDialog(paramString1, (String)localObject1, str1, (String)localObject2, (String)localObject3, (Context)localObject4, localMiniAppProxy, str2, str3);
        return;
      }
      showScopeUserInfoAuthDialog((String)localObject1, str1, (String)localObject2, (String)localObject3, (Context)localObject4, localApkgInfo, localChannelProxy, localMiniAppProxy, str2, str3);
    }
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
    String str1 = "";
    String str2;
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("scope").getString(0);
      str1 = paramString;
      str2 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        paramString = paramString.trim();
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      str2 = str1;
    }
    return str2;
  }
  
  private int getAuthDialogType(String paramString1, String paramString2)
  {
    if ("getPhoneNumber".equals(paramString1)) {
      return 2;
    }
    if ("subscribeOnceAppMsg".equals(paramString1)) {
      return 3;
    }
    if ("requestSubscribeSystemMessage".equals(paramString1)) {
      return 4;
    }
    if ((!"scope.userInfo".equals(paramString2)) && (!"scope.expandUserInfo".equals(paramString2))) {
      return 1;
    }
    return 5;
  }
  
  private static String getCMShowInfoScopeName(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    String str2 = null;
    String str1;
    if (!bool)
    {
      try
      {
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("scope");
        bool = TextUtils.isEmpty(paramString);
        if (bool) {
          paramString = null;
        }
        try
        {
          str2 = ((JSONObject)localObject).optString("avatarType");
          if ("2D".equals(str2))
          {
            localObject = "scope.cmshowInfo2d";
          }
          else
          {
            localObject = paramString;
            if ("3D".equals(str2)) {
              localObject = "scope.cmshowInfo3d";
            }
          }
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        paramString = str2;
      }
      str1 = paramString;
    }
    else
    {
      return str1;
    }
    return str1;
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
    String str = extractApiNameInJsonParams(paramString2);
    if (TextUtils.isEmpty(str))
    {
      localObject = paramString1;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    Object localObject = PermissionManager.g().getScopePermissionByEvent((String)localObject);
    if (("operateWXData".equals(paramString1)) && (TextUtils.isEmpty(str))) {
      return handleOperateWXDataScopeName(paramString2, (String)localObject);
    }
    if ("getCMShowInfo".equalsIgnoreCase(paramString1)) {
      localObject = getCMShowInfoScopeName(paramString2);
    }
    return localObject;
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
    if (paramString2 != null) {
      try
      {
        localObject1 = new JSONObject(paramString2).optJSONObject("data").optJSONObject("data").optString("miniprogram_appid");
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        localObject1 = localObject2;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = getAppId();
    }
    return MiniAppEnv.g().getAuthSate((String)localObject1).getPermissionAuthFlag(paramString1);
  }
  
  public static String getScopePluginSetauthName(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scope.plugin.setauth.");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleAuthRefuse, scopeName:");
    ((StringBuilder)localObject).append(paramMessage);
    QMLog.e("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramMessage)) && (!paramMessage.equals("setting.appMsgSubscribed")))
    {
      if (paramMessage.equals("scope.camera")) {
        this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onCameraNeedAuthCancel", null, 0));
      }
      localObject = this.curScopeEvent;
      if ((localObject != null) && (paramMessage.equals(getRequestScopePermission(((RequestEvent)localObject).event, this.curScopeEvent.jsonParams)))) {
        this.curScopeEvent.fail("auth deny");
      }
      while (paramIterator.hasNext())
      {
        localObject = (RequestEvent)paramIterator.next();
        if (paramMessage.equals(getRequestScopePermission(((RequestEvent)localObject).event, ((RequestEvent)localObject).jsonParams)))
        {
          paramIterator.remove();
          ((RequestEvent)localObject).fail("auth deny");
        }
      }
    }
  }
  
  private String handleAuthorizeEvent(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = getAppId();
      AuthState localAuthState = MiniAppEnv.g().getAuthSate((String)localObject);
      String str = extractScopeNameInJsonParams(paramRequestEvent.jsonParams);
      if ((localAuthState != null) && (isScopePermissionValid(str)))
      {
        boolean bool = localAuthState.isSynchronized();
        if ((str.startsWith("setting")) && (!bool))
        {
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList((String)localObject, new BaseJsPluginEngine.6(this, localAuthState, str, (String)localObject, paramRequestEvent));
        }
        else
        {
          bool = localAuthState.isPermissionGranted(str);
          if (AuthFilterList.isAppInWhiteList((String)localObject)) {
            bool = true;
          }
          if (bool) {
            paramRequestEvent.ok();
          } else {
            sendShowAuthDialogMessage(paramRequestEvent, str);
          }
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleAuthorizeEvent, authState is null or scope invalid, scope = ");
        ((StringBuilder)localObject).append(str);
        QMLog.w("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject).toString());
        paramRequestEvent.fail();
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", localThrowable.getMessage(), localThrowable);
      paramRequestEvent.fail();
    }
    return "";
  }
  
  private void handleNextScopeReq()
  {
    this.curScopeEvent = null;
    RequestEvent localRequestEvent = (RequestEvent)this.scopePermissionQueue.poll();
    if (localRequestEvent != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNextScopeReq, event : ");
      localStringBuilder.append(localRequestEvent.event);
      localStringBuilder.append("; jsonParams : ");
      localStringBuilder.append(localRequestEvent.jsonParams);
      QMLog.e("JsPluginEngine[AuthGuard]", localStringBuilder.toString());
      sendShowAuthDialogMessage(localRequestEvent);
    }
  }
  
  private void handleOnceSubscribeResponse(RequestEvent paramRequestEvent, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        String str = paramJSONObject.optString("settingItem");
        Object localObject1 = paramJSONObject.opt("originalData");
        Object localObject2 = new INTERFACE.StGetUserSettingRsp();
        if ((localObject1 instanceof byte[]))
        {
          localObject1 = (byte[])localObject1;
          ((INTERFACE.StGetUserSettingRsp)localObject2).mergeFrom((byte[])localObject1);
          localObject2 = ((INTERFACE.StGetUserSettingRsp)localObject2).setting.subItems.get();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          ArrayList localArrayList3 = new ArrayList();
          i = 0;
          if (i < ((List)localObject2).size())
          {
            localObject3 = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
            if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 0)
            {
              localArrayList1.add(localObject3);
              break label341;
            }
            if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 1)
            {
              localArrayList2.add(localObject3);
              break label341;
            }
            if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() != 2) {
              break label341;
            }
            localArrayList3.add(localObject3);
            break label341;
          }
          Object localObject3 = MiniAppEnv.g().getAuthSate(getAppId());
          recordIfNeedMaintain(str, localArrayList2, localArrayList3, (AuthState)localObject3);
          if ((localArrayList1.size() > 0) && (localArrayList1.size() <= 3))
          {
            if (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo()))
            {
              grantOnceSubscribeApiPermissionSilent(str, paramRequestEvent, (byte[])localObject1);
              return;
            }
            showOnceSubMsgReqDialog(str, paramRequestEvent, (byte[])localObject1);
            return;
          }
          if (("setting.onceMsgSubscribed".equals(str)) && (localArrayList2.size() > 0))
          {
            updateOnceMsgSubscribedItem(paramRequestEvent, str, (List)localObject2, localArrayList2, (AuthState)localObject3);
            return;
          }
          onceSubMsgCallbackSuc(paramRequestEvent, (List)localObject2);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "handleOnceSubscribeResponse get an Error:", localThrowable);
      }
      onceSubMsgCallbackFail(paramRequestEvent, paramJSONObject);
      return;
      label341:
      i += 1;
    }
  }
  
  private static String handleOperateWXDataScopeName(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1).optJSONObject("data");
      localObject = paramString1.optString("api_name");
      if (("webapi_plugin_login".equals(localObject)) || ("webapi_plugin_getuserinfo".equals(localObject)))
      {
        localObject = paramString1.optJSONObject("data").optString("miniprogram_appid");
        paramString1 = paramString1.optString("plugin_appid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)))
        {
          paramString1 = getScopePluginSetauthName((String)localObject, paramString1);
          return paramString1;
        }
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleOperateWXDataScopeName ");
      ((StringBuilder)localObject).append(paramString1.getMessage());
      QMLog.e("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject).toString(), paramString1);
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
    int i = paramList1.size();
    INTERFACE.StSubscribeMessage localStSubscribeMessage1;
    if (i != 1)
    {
      INTERFACE.StSubscribeMessage localStSubscribeMessage2;
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramList1.get(0);
        localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramList1.get(1);
        INTERFACE.StSubscribeMessage localStSubscribeMessage3 = (INTERFACE.StSubscribeMessage)paramList1.get(2);
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
        if (!judgeOnceSubMsgState(paramBoolean1, paramBoolean4, localStSubscribeMessage3))
        {
          paramList1.remove(localStSubscribeMessage3);
          paramList2.add(localStSubscribeMessage3);
        }
      }
      else
      {
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramList1.get(0);
        localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramList1.get(1);
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
      }
    }
    else
    {
      localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramList1.get(0);
      if (!judgeOnceSubMsgState(paramBoolean1, paramBoolean2, localStSubscribeMessage1))
      {
        paramList1.remove(localStSubscribeMessage1);
        paramList2.add(localStSubscribeMessage1);
      }
    }
  }
  
  private void handleSubMsgDialogDismiss(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, INTERFACE.StGetUserSettingRsp paramStGetUserSettingRsp)
  {
    Object localObject1 = paramStGetUserSettingRsp.setting.subItems.get();
    paramStGetUserSettingRsp = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(i);
      if (((INTERFACE.StSubscribeMessage)localObject2).authState.get() == 0) {
        paramStGetUserSettingRsp.add(localObject2);
      } else if (((INTERFACE.StSubscribeMessage)localObject2).authState.get() == 1) {
        localArrayList1.add(localObject2);
      }
      i += 1;
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
    else if (paramBoolean6)
    {
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
      else
      {
        ((AsyncResult)localObject1).onReceiveResult(true, null);
      }
      if ("setting.sysMsgSubscribed".equals(paramString)) {
        ((AuthState)localObject2).updateIsSysSubMsgMaintain(true);
      }
    }
    else
    {
      ((AsyncResult)localObject1).onReceiveResult(true, null);
    }
  }
  
  private void initAuthDialog(Bundle paramBundle, Activity paramActivity, int paramInt)
  {
    AuthDialog localAuthDialog = this.authDialog;
    if ((localAuthDialog == null) || (localAuthDialog.getAuthDialogType() != paramInt))
    {
      this.authDialog = new AuthDialog(paramActivity, this.mMiniAppContext, paramInt);
      if ((paramInt != 3) && (paramInt != 4)) {
        this.authDialog.setOnDismissListener(this.dismissListener);
      } else {
        this.authDialog.setOnDismissListener(this.onceSubDismissListener);
      }
    }
    this.authDialog.bindData(paramBundle);
  }
  
  private boolean isGrantedAuthorize(String paramString1, String paramString2, String paramString3, AuthState paramAuthState, String paramString4)
  {
    if (((AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())) || (AuthFilterList.isAppInWhiteList(paramString3))) && (paramAuthState.getAuthFlag(paramString4) == 1))
    {
      setScopePermissionAuthState(paramString4, true);
      bool2 = true;
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (isOpenDataEvent(paramString1, paramString2)) {
        bool1 = true;
      }
    }
    boolean bool2 = bool1;
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
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (shouldAskEveryTime(paramString4)) {
        bool2 = false;
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (isMakeReuqestFirstEvent(paramString1)) {
        bool1 = true;
      }
    }
    if (!bool1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkRequestScopePermission granted=");
      paramString2.append(bool1);
      paramString2.append(",eventName=");
      paramString2.append(paramString1);
      QMLog.e("JsPluginEngine[AuthGuard]", paramString2.toString());
    }
    return bool1;
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
            return true;
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      label107:
      break label107;
    }
    return false;
  }
  
  private static boolean isScopePermissionValid(String paramString)
  {
    return PermissionManager.g().isScopePermissionValid(paramString);
  }
  
  private boolean judgeOnceSubMsgState(boolean paramBoolean1, boolean paramBoolean2, INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        paramStSubscribeMessage.authState.set(1);
        return true;
      }
      paramStSubscribeMessage.authState.set(2);
      return true;
    }
    if (paramBoolean2)
    {
      paramStSubscribeMessage.authState.set(0);
      return true;
    }
    return false;
  }
  
  private boolean needShowAuthDialog(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    boolean bool2;
    if ((paramBoolean) && (!shouldAskEveryTime(paramString1))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    boolean bool1 = bool2;
    try
    {
      if ("operateWXData".equals(paramString2))
      {
        paramString2 = new JSONObject(paramString3).optJSONObject("data");
        paramString3 = paramString2.optString("api_name");
        if ((!"webapi_getuserinfo".equals(paramString3)) && (!"getSubjectalterInfo".equals(paramString3)) && (!"webapi_wxa_subscribe_biz".endsWith(paramString3)))
        {
          if (("webapi_plugin_login".equals(paramString3)) || ("webapi_plugin_getuserinfo".equals(paramString3))) {
            break label190;
          }
          bool1 = bool2;
          if ("webapi_plugin_setauth".equals(paramString3)) {
            break label190;
          }
        }
        else
        {
          bool1 = paramString2.optBoolean("from_component");
        }
      }
    }
    catch (Throwable paramString2)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", Log.getStackTraceString(paramString2));
      bool1 = bool2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramBoolean)
      {
        if ((!bool1) && (!shouldAskEveryTimeWhenRejected(paramString1))) {
          return false;
        }
        bool2 = true;
      }
      return bool2;
      label190:
      bool1 = false;
    }
  }
  
  private void notifyScopePermissionQueue(Message paramMessage)
  {
    Object localObject = this.scopePermissionQueue.iterator();
    if ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 2))
    {
      localObject = this.curScopeEvent;
      if ((localObject != null) && ("authorize".equals(((RequestEvent)localObject).event)) && (paramMessage.arg1 == 1))
      {
        this.curScopeEvent.ok();
        QMLog.e("JsPluginEngine[AuthGuard]", "notifyScopePermissionQueue AUTH_FLAG_GRANT && EVENT_AUTHORIZE");
        handleNextScopeReq();
      }
    }
    else
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "notifyScopePermissionQueue AUTH_FLAG_CANCEL / AUTH_FLAG_REFUSE");
      handleAuthRefuse(paramMessage, (Iterator)localObject);
    }
    paramMessage = this.curScopeEvent;
    if ((paramMessage != null) && ("subscribeAppMsg".equals(paramMessage.event)))
    {
      reqGrantSubscribeApiPermission(this.curScopeEvent);
    }
    else
    {
      paramMessage = this.curScopeEvent;
      if ((paramMessage != null) && (!"getPhoneNumber".equals(paramMessage.event))) {
        dispatchRequestEvent(this.curScopeEvent);
      }
    }
    handleNextScopeReq();
  }
  
  private void recordIfNeedMaintain(String paramString, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, AuthState paramAuthState)
  {
    if ((paramList1.size() > 0) || (paramList2.size() > 0))
    {
      if ("setting.sysMsgSubscribed".equals(paramString))
      {
        paramAuthState.updateIsSysSubMsgMaintain(true);
        return;
      }
      if ("setting.onceMsgSubscribed".equals(paramString)) {
        paramAuthState.updateIsOnceSubMsgMaintain(true);
      }
    }
  }
  
  private void removeAllMessage()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
  }
  
  private void reqGrantOnceSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("tmplIds");
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          if (((JSONArray)localObject).length() > 3)
          {
            onceSubMsgCallbackFail(paramRequestEvent, "Templates count out of max bounds", 20003);
            return;
          }
          if (((JSONArray)localObject).length() == 0)
          {
            onceSubMsgCallbackFail(paramRequestEvent, "TmplIds can't be empty", 10001);
            return;
            if (i < ((JSONArray)localObject).length())
            {
              localArrayList.add(((JSONArray)localObject).getString(i));
              i += 1;
              continue;
            }
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.onceMsgSubscribed", localArrayList, new BaseJsPluginEngine.9(this, paramRequestEvent));
          }
        }
        else
        {
          QMLog.e("JsPluginEngine[AuthGuard]", "reqGrantOnceSubscribeApiPermission: tmplIdJsonArr is null!");
          onceSubMsgCallbackFail(paramRequestEvent, "TmplIds can't be empty", 10001);
          return;
        }
      }
      catch (Exception paramRequestEvent)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reqGrantOnceSubscribeApiPermission get an Exception:");
        ((StringBuilder)localObject).append(paramRequestEvent);
        QMLog.e("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
    }
  }
  
  private String reqGrantSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    Object localObject2 = MiniAppEnv.g().getAuthSate(getAppId());
    Object localObject1 = getRequestScopePermission(paramRequestEvent.event, paramRequestEvent.jsonParams);
    Object localObject3;
    if (QMLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("reqGrantSubscribeApiPermission scopePermission=");
      ((StringBuilder)localObject3).append((String)localObject1);
      QMLog.d("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject3).toString());
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
      localObject2 = this.authDialog;
      if ((localObject2 == null) || (!((AuthDialog)localObject2).isShowing()))
      {
        localObject2 = this.mHandler.obtainMessage(2);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("key_event_name", paramRequestEvent.event);
        ((Bundle)localObject3).putString("key_params", paramRequestEvent.jsonParams);
        ((Bundle)localObject3).putString("key_scope_name", (String)localObject1);
        ((Bundle)localObject3).putInt("key_callback_id", paramRequestEvent.callbackId);
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).sendToTarget();
        return "";
      }
    }
    else
    {
      if (((AuthState)localObject2).isPermissionGranted((String)localObject1))
      {
        this.isFirstTimeRequestAuth = false;
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 1);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        paramRequestEvent.ok((JSONObject)localObject1);
        return "";
      }
      localObject1 = new JSONObject();
      try
      {
        if (this.isFirstTimeRequestAuth) {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 0);
        } else {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", -1);
        }
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      paramRequestEvent.fail((JSONObject)localObject1, "no permission");
      this.isFirstTimeRequestAuth = false;
    }
    return "";
  }
  
  private void reqGrantSystemSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reqGrantSystemSubscribeApiPermission jsonParams: ");
    ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
    QMLog.i("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("msgTypeList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() <= 3))
      {
        if (((JSONArray)localObject1).length() == 0)
        {
          onceSubMsgCallbackFail(paramRequestEvent, "msgTypeList can't be empty", 10001);
          return;
        }
        localObject2 = new ArrayList();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          ((ArrayList)localObject2).add(((JSONArray)localObject1).getString(i));
          i += 1;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.sysMsgSubscribed", (ArrayList)localObject2, new BaseJsPluginEngine.7(this, paramRequestEvent));
        return;
      }
      onceSubMsgCallbackFail(paramRequestEvent, "Invalid template id", 10004);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reqGrantSystemSubscribeApiPermission get an Exception:");
      ((StringBuilder)localObject2).append(localException);
      QMLog.e("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject2).toString());
      onceSubMsgCallbackFail(paramRequestEvent, "Invalid template id", 10004);
    }
  }
  
  private void sendShowAuthDialogMessage(RequestEvent paramRequestEvent)
  {
    sendShowAuthDialogMessage(paramRequestEvent, extractScopeNameInJsonParams(paramRequestEvent.jsonParams));
  }
  
  private void sendShowAuthDialogMessage(RequestEvent paramRequestEvent, String paramString)
  {
    Object localObject = this.authDialog;
    if (((localObject == null) || (!((AuthDialog)localObject).isShowing())) && (this.curScopeEvent == null))
    {
      this.curScopeEvent = paramRequestEvent;
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_event_name", paramRequestEvent.event);
      ((Bundle)localObject).putString("key_params", paramRequestEvent.jsonParams);
      ((Bundle)localObject).putString("key_scope_name", paramString);
      ((Bundle)localObject).putInt("key_callback_id", paramRequestEvent.callbackId);
      ((Bundle)localObject).putString("key_appid", getAppId());
      paramRequestEvent = this.mHandler.obtainMessage(2);
      paramRequestEvent.setData((Bundle)localObject);
      paramRequestEvent.sendToTarget();
      return;
    }
    if (paramRequestEvent != null)
    {
      paramString = new StringBuilder();
      paramString.append("sendShowAuthDialogMessage scopePermissionQueue.offer, event : ");
      paramString.append(paramRequestEvent.event);
      paramString.append("; jsonParams : ");
      paramString.append(paramRequestEvent.jsonParams);
      QMLog.d("JsPluginEngine[AuthGuard]", paramString.toString());
      this.scopePermissionQueue.offer(paramRequestEvent);
    }
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
  
  private boolean shouldAskEveryTimeWhenRejected(String paramString)
  {
    String str = getAppId();
    return MiniAppEnv.g().getAuthSate(str).shouldAskEveryTimeWhenRejected(paramString);
  }
  
  private void showAuthDialog(Bundle paramBundle)
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      String str1 = paramBundle.getString("key_event_name", "");
      String str2 = paramBundle.getString("key_params", "");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAuthDialog, event: ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(";params : ");
      ((StringBuilder)localObject).append(str2);
      QMLog.d("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject).toString());
      localObject = paramBundle.getString("key_scope_name", "");
      initAuthDialog(paramBundle, localActivity, getAuthDialogType(str1, (String)localObject));
      if (localObject != null) {
        doShowAuthDialog(str2, (String)localObject);
      }
      return;
    }
    QMLog.w("JsPluginEngine[AuthGuard]", "showAuthDialog(). Do nothing, activity is null or finishing");
  }
  
  private void showDefaultAuthDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Context paramContext, MiniAppProxy paramMiniAppProxy, String paramString6, String paramString7)
  {
    if (this.authDialog != null)
    {
      AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = null;
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
        QMLog.e("JsPluginEngine[AuthGuard]", "get phoneNumberList error,", paramString1);
        paramString1 = localAuthDialogResBuilder;
      }
      localAuthDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
      localAuthDialogResBuilder.setMiniAppIconUrl(paramMiniAppProxy.getDrawable(paramContext, paramString6, 0, 0, null)).setMiniAppName(paramString7).setAuthTitle(paramString2).setAuthDesc(paramString3).setReportSubAction(paramString5).setMiniAppInfo(this.mMiniAppContext.getMiniAppInfo()).setLeftBtnText(paramString4).setLeftBtnClickListener(new BaseJsPluginEngine.12(this)).setRightBtnText("允许").setRightBtnClickListener(new BaseJsPluginEngine.11(this));
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localAuthDialogResBuilder.setPhoneNumberList(paramString1);
      }
      this.authDialog.setCanceledOnTouchOutside(false);
      this.authDialog.show(localAuthDialogResBuilder);
    }
  }
  
  private void showOnceSubMsgReqDialog(String paramString, RequestEvent paramRequestEvent, byte[] paramArrayOfByte)
  {
    Object localObject = this.authDialog;
    if ((localObject == null) || (!((AuthDialog)localObject).isShowing()))
    {
      this.onceSubMsgReq = paramRequestEvent;
      localObject = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramRequestEvent.event);
      localBundle.putString("key_setting_item", paramString);
      localBundle.putString("key_params", paramRequestEvent.jsonParams);
      localBundle.putString("key_appid", getAppId());
      localBundle.putByteArray("key_once_sub_rsp_data", paramArrayOfByte);
      ((Message)localObject).setData(localBundle);
      ((Message)localObject).sendToTarget();
    }
  }
  
  private void showRequestPermissionDialog(RequestEvent paramRequestEvent, String paramString)
  {
    String str1 = paramRequestEvent.event;
    String str2 = paramRequestEvent.jsonParams;
    boolean bool3 = isOpenDataEvent(str1, str2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (getScopePermissionAuthFlag(paramString) == 4) {
        bool1 = true;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNativeRequest hasRefused=");
    localStringBuilder.append(bool1);
    QMLog.d("JsPluginEngine[AuthGuard]", localStringBuilder.toString());
    if (needShowAuthDialog(paramString, str1, str2, bool1))
    {
      sendShowAuthDialogMessage(paramRequestEvent, paramString);
      return;
    }
    QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest callbackJsEventFail");
    paramRequestEvent.fail("auth deny");
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  private void showScopeUserInfoAuthDialog(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext, ApkgInfo paramApkgInfo, ChannelProxy paramChannelProxy, MiniAppProxy paramMiniAppProxy, String paramString5, String paramString6)
  {
    paramChannelProxy.getUserInfo(paramApkgInfo.appId, false, "en", new BaseJsPluginEngine.13(this, paramMiniAppProxy, paramContext, paramString5, paramString6, paramString1, paramString2, paramString4, paramString3));
  }
  
  private void updateOnceMsgSubscribedItem(RequestEvent paramRequestEvent, String paramString, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, AuthState paramAuthState)
  {
    paramAuthState.updateOnceSubMsgSetting(paramString, true, paramList2, new BaseJsPluginEngine.10(this, paramRequestEvent, paramList1));
  }
  
  public String checkAuthorization(RequestEvent paramRequestEvent)
  {
    String str2 = paramRequestEvent.event;
    Object localObject = paramRequestEvent.jsonParams;
    String str1;
    if (AuthFilterList.isEventInSecondaryApiList(str2)) {
      str1 = extractApiNameInJsonParams((String)localObject);
    } else {
      str1 = "";
    }
    if (!AuthFilterList.isEventNameRight(this.mMiniAppContext.getMiniAppInfo(), str2, str1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("eventname : ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("; apiName : ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" request failed.");
      QMLog.e("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject).toString());
      if (str2.endsWith("Sync")) {
        return ApiUtil.wrapCallbackFail(str2, null, "no permission").toString();
      }
      paramRequestEvent.fail("no permission");
      return "";
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      str1 = getRequestSystemPermission(str2, (String)localObject);
      if (!StringUtil.isEmpty(str1))
      {
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        if (localActivity == null)
        {
          paramRequestEvent = new StringBuilder();
          paramRequestEvent.append("Activity is null. Ignore event ");
          paramRequestEvent.append(str2);
          QMLog.w("JsPluginEngine[AuthGuard]", paramRequestEvent.toString());
          return "";
        }
        int i;
        if (localActivity.checkSelfPermission(str1) == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          handleRequestSystemPermission(paramRequestEvent, str2, (String)localObject, str1, localActivity);
          return "";
        }
        return checkRequestScopePermission(paramRequestEvent);
      }
      return checkRequestScopePermission(paramRequestEvent);
    }
    return checkRequestScopePermission(paramRequestEvent);
  }
  
  protected abstract String dispatchRequestEvent(RequestEvent paramRequestEvent);
  
  protected ApkgInfo getApkgInfo()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if ((localIMiniAppContext != null) && (localIMiniAppContext.getMiniAppInfo() != null)) {
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
    this.onceSubMsgReq = paramRequestEvent;
    paramRequestEvent = new INTERFACE.StGetUserSettingRsp();
    if (paramArrayOfByte != null) {
      try
      {
        paramRequestEvent.mergeFrom(paramArrayOfByte);
      }
      catch (Throwable paramArrayOfByte)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", paramArrayOfByte);
      }
    }
    handleSubMsgDialogDismiss(paramString, false, true, true, true, true, false, paramRequestEvent);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, IJsService paramIJsService, int paramInt)
  {
    if (this.mMiniAppContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNativeRequest: eventName:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("  callbackId:");
    localStringBuilder.append(paramInt);
    QMLog.d("JsPluginEngine[AuthGuard]", localStringBuilder.toString());
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
    AuthDialog localAuthDialog = this.authDialog;
    if (localAuthDialog != null)
    {
      localAuthDialog.setOnDismissListener(null);
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
    AuthDialog localAuthDialog = this.authDialog;
    if ((localAuthDialog != null) && (localAuthDialog.isShowing())) {
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
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackFail get a JSONException:", localJSONException);
    }
    if (paramRequestEvent != null) {
      paramRequestEvent.fail(localJSONObject, paramString);
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
    label102:
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          localObject = (INTERFACE.StSubscribeMessage)paramList.get(i);
          String str = ((INTERFACE.StSubscribeMessage)localObject).templateId.get();
          if (((INTERFACE.StSubscribeMessage)localObject).authState.get() != 1) {
            break label102;
          }
          localObject = "accept";
          localJSONObject.put(str, localObject);
          i += 1;
        }
        Object localObject = "reject";
      }
      catch (Exception paramList)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackSuc get a Exception:", paramList);
        if (paramRequestEvent != null) {
          paramRequestEvent.ok(localJSONObject);
        }
        return;
      }
    }
  }
  
  public void onceSubMsgCallbackSuc(RequestEvent paramRequestEvent, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, List<INTERFACE.StSubscribeMessage> paramList3, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    int k = 0;
    int i = 0;
    if (paramBoolean)
    {
      try
      {
        while (i < paramList1.size())
        {
          paramList2 = (INTERFACE.StSubscribeMessage)paramList1.get(i);
          paramList3 = paramList2.templateId.get();
          if (paramList2.authState.get() != 1) {
            break label318;
          }
          paramList2 = "accept";
          localJSONObject.put(paramList3, paramList2);
          i += 1;
        }
        label88:
        if (i >= paramList1.size()) {
          break label340;
        }
        localObject = (INTERFACE.StSubscribeMessage)paramList1.get(i);
        if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 1) {
          localJSONObject.put(((INTERFACE.StSubscribeMessage)localObject).templateId.get(), "accept");
        } else if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 2) {
          localJSONObject.put(((INTERFACE.StSubscribeMessage)localObject).templateId.get(), "reject");
        }
      }
      catch (Exception paramList1)
      {
        Object localObject;
        label176:
        int j;
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackSuc get a Exception:", paramList1);
        if (paramRequestEvent == null) {
          break label317;
        }
        paramRequestEvent.ok(localJSONObject);
        return;
      }
      j = k;
      if (i < paramList2.size())
      {
        paramList1 = (INTERFACE.StSubscribeMessage)paramList2.get(i);
        localObject = paramList1.templateId.get();
        if (paramList1.authState.get() != 2) {
          break label346;
        }
        paramList1 = "reject";
      }
    }
    for (;;)
    {
      localJSONObject.put((String)localObject, paramList1);
      i += 1;
      break label176;
      while (j < paramList3.size())
      {
        localJSONObject.put(((INTERFACE.StSubscribeMessage)paramList3.get(j)).templateId.get(), "reject");
        j += 1;
      }
      label317:
      label318:
      paramList2 = "reject";
      break;
      i = 0;
      break label88;
      i += 1;
      break label88;
      label340:
      i = 0;
      break label176;
      label346:
      paramList1 = "accept";
    }
  }
  
  public void showRequestPermissionDialog(RequestEvent paramRequestEvent, PhoneNumberAction.PhoneNumberActionCallback paramPhoneNumberActionCallback)
  {
    this.mPhoneNumberActionCallbackMap.put(Integer.valueOf(paramRequestEvent.callbackId), paramPhoneNumberActionCallback);
    showRequestPermissionDialog(paramRequestEvent, getRequestScopePermission(paramRequestEvent.event, paramRequestEvent.jsonParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */