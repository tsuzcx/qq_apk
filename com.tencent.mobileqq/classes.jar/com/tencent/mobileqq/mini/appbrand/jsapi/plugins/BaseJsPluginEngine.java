package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import amtj;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.SecondApiRightInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.mobileqq.mini.widget.AuthDialog.AuthDialogResBuilder;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseJsPluginEngine<ActivityContext extends BaseActivity>
  implements Handler.Callback
{
  public static final int API_BLACK = 0;
  public static final int API_WHITE = 1;
  public static final String APP_IN_BACKGROUND_HINT = "Cannot show subscribe message UI";
  public static final String APP_IS_BANNED_HINT = "This mini program was banned from subscribing messages";
  public static final int AUTH_IGNORE = 3;
  public static final int AUTH_REFUSE = 2;
  public static final int AUTH_SUCC = 1;
  private static final String CONFIG_SPLIT = ",";
  public static final String EMPTY_PARAM_LIST_HINT = "msgTypeList can't be empty";
  public static final int ERROR_APP_IN_BACKGROUND = 10005;
  public static final int ERROR_APP_IS_BANNED = 20005;
  public static final int ERROR_EMPTY_PARAM_LIST = 10001;
  public static final int ERROR_INVALID_TEMPLATE_ID = 10004;
  public static final int ERROR_MAIN_SWITCH_OFF = 20004;
  public static final int ERROR_REQUEST_LIST_FAIL = 10002;
  public static final int ERROR_REQUEST_SUBSCRIBE_FAIL = 10003;
  public static final String INVALID_TEMPLATE_ID_HINT = "Invalid template id";
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
  public static final String MAIN_SWITCH_OFF_HINT = "The main switch is switched off";
  public static final String REQUEST_LIST_FAIL_HINT = "Request list fail";
  public static final String REQUEST_SUBSCRIBE_FAIL_HINT = "Request subscribe fail";
  public static final String TAG = "BaseJsPluginEngine";
  private static ArrayList<String> authWhiteList;
  private static volatile int curInputId = -1;
  private static String mCurWhiteListConfig;
  private final String KEY_CALLBACK_ID = "key_callback_id";
  private final String KEY_EVENT_NAME = "key_event_name";
  private final String KEY_JOB_INFO = "key_job_info";
  private final String KEY_PARAMS = "key_params";
  private final String KEY_SETTING_ITEM = "key_setting_item";
  private final int ONCE_SUBSCRIBE_CODE_OTHER = -2;
  private final int ONCE_SUBSCRIBE_CODE_PASS = -1;
  private final int ONCE_SUBSCRIBE_CODE_REJECT = 0;
  private final int ONCE_SUBSCRIBE_CODE_SUC = 1;
  private final int SUBSCRIBE_CODE_FAIL_OTHER = -2;
  private final int SUBSCRIBE_CODE_REJECT = -1;
  private final int SUBSCRIBE_CODE_REJECT_FIRST = 0;
  private final int SUBSCRIBE_CODE_SUC = 1;
  private final int WHAT_NOTIFY_QUEUE = 1;
  private final int WHAT_NOTIFY_SYS_QUEUE = 4;
  private final int WHAT_SHOW_AUTH_DIALOG = 2;
  private final int WHAT_SHOW_AUTH_DIALOG_BY_AUTHORIZE = 5;
  private final int WHAT_SHOW_SYS_AUTH_DIALOG = 3;
  public ActivityContext activityContext;
  public BaseAppBrandRuntime appBrandRuntime;
  AuthDialog authDialog;
  public AuthorizeCenter authorizeCenter;
  private boolean checkStoragePermission;
  private List<String> defaultBlackList;
  DialogInterface.OnDismissListener dismissListener;
  private HashMap<String, Integer> firstApiMap;
  private boolean isCreated;
  private boolean isDestory;
  private boolean isFirstTimeRequestAuth;
  private boolean isPause;
  private boolean isSubAuthIgnore;
  public ConcurrentLinkedQueue<BaseJsPluginEngine.NativeJobInfo> jobQueue;
  private final HashMap<String, IJsPlugin> mPluginEventMap = new HashMap();
  protected final ArrayList<IJsPlugin> mPluginList = new ArrayList();
  private Map<Integer, BaseJsPluginEngine.ReqGantApiPermissionCallback> mReqGantApiPermissionCallbackMap = new ConcurrentHashMap();
  private int onceSubCallbackId = -1;
  DialogInterface.OnDismissListener onceSubDismissListener;
  private JsRuntime onceSubWebView;
  private HashMap<String, HashMap<String, Integer>> secondApiMap;
  private HashMap<String, HashMap<String, Integer>> secondApiRightMap = new HashMap();
  public ConcurrentLinkedQueue<BaseJsPluginEngine.NativeJobInfo> sysPermissionQueue;
  public Handler uiHandler;
  
  public BaseJsPluginEngine()
  {
    this(null);
  }
  
  public BaseJsPluginEngine(BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappcheckstoragepermission", 0) == 1) {}
    for (;;)
    {
      this.checkStoragePermission = bool;
      this.onceSubDismissListener = new BaseJsPluginEngine.10(this);
      this.dismissListener = new BaseJsPluginEngine.11(this);
      this.appBrandRuntime = paramBaseAppBrandRuntime;
      this.jobQueue = new ConcurrentLinkedQueue();
      this.sysPermissionQueue = new ConcurrentLinkedQueue();
      this.uiHandler = new Handler(Looper.getMainLooper(), this);
      return;
      bool = false;
    }
  }
  
  public static void assertInMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (arrayOfStackTraceElement != null)
      {
        localObject1 = localObject2;
        if (arrayOfStackTraceElement.length >= 4) {
          localObject1 = arrayOfStackTraceElement[3].toString();
        }
      }
      throw new IllegalStateException("Call the method must be in main thread: " + (String)localObject1);
    }
  }
  
  private String grantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    IJsPlugin localIJsPlugin = getEventHandler(paramString1);
    if (localIJsPlugin != null)
    {
      reportApiInvoke(paramString1);
      return localIJsPlugin.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    QLog.w("BaseJsPluginEngine", 2, "handleNativeRequest fail,event not support! eventName=" + paramString1 + "，jsonParams=" + paramString2 + ",webview=" + paramJsRuntime + ",callbackId=" + paramInt);
    callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
    return "";
  }
  
  private String handleNativeRequestInner(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    int i = this.authorizeCenter.getAuthFlag(paramString1, paramString2);
    if (paramString1.equals("subscribeAppMsg"))
    {
      reqGrantSubscribeApiPermission(paramString2, paramJsRuntime, paramInt);
      paramJsRuntime = "";
      return paramJsRuntime;
    }
    if (paramString1.equals("subscribeOnceAppMsg"))
    {
      reqGrantOnceSubscribeApiPermission(paramString1, paramString2, paramJsRuntime, paramInt);
      return "";
    }
    if (paramString1.equals("requestSubscribeSystemMessage"))
    {
      reqSubscribeSystemMessagePermission(paramString1, paramString2, paramJsRuntime, paramInt);
      return "";
    }
    String str;
    if (i == 1) {
      if (!apiAuthoritySilent())
      {
        if (this.appBrandRuntime != null)
        {
          str = this.appBrandRuntime.appId;
          label110:
          if (!isAuthWhiteAppId(str)) {
            break label298;
          }
        }
      }
      else
      {
        str = AuthorizeCenter.getScopeName(paramString1, paramString2);
        if (!TextUtils.isEmpty(str))
        {
          this.authorizeCenter.setAuthorize(str, true);
          QLog.i("BaseJsPluginEngine", 1, "apiAuthoritySilent setAuthorize : " + str);
        }
        i = 2;
      }
    }
    label298:
    label341:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest authFlag=" + i + ",eventName=" + paramString1 + ",callbackId=" + paramInt);
      }
      if ((i == 2) || ("getPhoneNumber".equals(paramString1)))
      {
        str = grantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt);
        paramJsRuntime = str;
        if (this.jobQueue.size() <= 0) {
          break;
        }
        paramJsRuntime = str;
        if (!AuthorizeCenter.isInScopeList(paramString1, paramString2)) {
          break;
        }
        this.uiHandler.obtainMessage(1).sendToTarget();
        return str;
        str = null;
        break label110;
        if (paramBoolean)
        {
          i = 2;
          continue;
        }
        if (!this.authorizeCenter.shouldAskEveryTime(paramString1, paramString2)) {
          break label341;
        }
        i = 1;
        continue;
      }
      reqGrantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt, true);
      return "";
    }
  }
  
  private void handleOnceSubscribeResponse(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    for (;;)
    {
      String str;
      Object localObject1;
      Object localObject2;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      int i;
      INTERFACE.StSubscribeMessage localStSubscribeMessage;
      try
      {
        str = paramJSONObject.optString("settingItem");
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
            break label225;
          }
          localStSubscribeMessage = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
          if (localStSubscribeMessage.authState.get() == 0) {
            localArrayList1.add(localStSubscribeMessage);
          } else if (localStSubscribeMessage.authState.get() == 1) {
            localArrayList2.add(localStSubscribeMessage);
          }
        }
      }
      catch (Throwable paramString2)
      {
        QLog.e("BaseJsPluginEngine", 2, "handleOnceSubscribeResponse get an Error:", paramString2);
      }
      onceSubMsgCallbackFail(paramString1, paramJsRuntime, paramJSONObject, paramInt);
      return;
      if (localStSubscribeMessage.authState.get() == 2)
      {
        localArrayList3.add(localStSubscribeMessage);
        break label380;
        label225:
        if ((localArrayList2.size() > 0) || (localArrayList3.size() > 0))
        {
          if (!"setting.sysMsgSubscribed".equals(str)) {
            break label299;
          }
          this.authorizeCenter.updateIsSysSubMsgMaintain(true);
        }
        while ((localArrayList1.size() > 0) && (localArrayList1.size() <= 3))
        {
          showOnceSubMsgReqDialog(paramString1, str, paramString2, paramJsRuntime, paramInt, (byte[])localObject1);
          return;
          label299:
          if ("setting.onceMsgSubscribed".equals(str)) {
            this.authorizeCenter.updateIsOnceSubMsgMaintain(true);
          }
        }
        if (("setting.onceMsgSubscribed".equals(str)) && (localArrayList2.size() > 0))
        {
          this.authorizeCenter.updateOnceSubMsgSetting(str, true, localArrayList2, new BaseJsPluginEngine.5(this, paramString1, paramJsRuntime, (List)localObject2, paramInt));
          return;
        }
        onceSubMsgCallbackSuc(paramString1, paramJsRuntime, (List)localObject2, paramInt);
        return;
      }
      label380:
      i += 1;
    }
  }
  
  public static void initAuthWhiteList()
  {
    try
    {
      if (authWhiteList == null)
      {
        String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppAuthWhiteList", "1108292102");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QLog.i("BaseJsPluginEngine", 1, "Default white appid:" + str1);
          authWhiteList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(",");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  authWhiteList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("BaseJsPluginEngine", 1, "initAuthWhiteList error,", localThrowable);
            mCurWhiteListConfig = str1;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void initDefaultBlackMap()
  {
    if (this.defaultBlackList == null) {
      this.defaultBlackList = new ArrayList();
    }
    this.defaultBlackList.add("requestPayment");
    this.defaultBlackList.add("requestMidasPayment");
    this.defaultBlackList.add("requestWxPayment");
    this.defaultBlackList.add("requestPaymentToBank");
    this.defaultBlackList.add("reportSubmitForm");
    this.defaultBlackList.add("insertHTMLWebView");
    this.defaultBlackList.add("updateHTMLWebView");
    this.defaultBlackList.add("removeHTMLWebView");
    this.defaultBlackList.add("onWebInvokeAppService");
    this.defaultBlackList.add("insertLivePusher");
    this.defaultBlackList.add("updateLivePusher");
    this.defaultBlackList.add("removeLivePusher");
    this.defaultBlackList.add("operateLivePusher");
    this.defaultBlackList.add("onLivePusherEvent");
    this.defaultBlackList.add("onLivePusherNetStatus");
    this.defaultBlackList.add("insertLivePlayer");
    this.defaultBlackList.add("updateLivePlayer");
    this.defaultBlackList.add("removeLivePlayer");
    this.defaultBlackList.add("operateLivePlayer");
    this.defaultBlackList.add("onLivePlayerEvent");
    this.defaultBlackList.add("onLivePlayerFullScreenChange");
    this.defaultBlackList.add("onLivePlayerNetStatus");
    this.defaultBlackList.add("insertXWebLivePlayer");
    this.defaultBlackList.add("updateXWebLivePlayer");
    this.defaultBlackList.add("removeXWebLivePlayer");
    this.defaultBlackList.add("operateXWebLivePlayer");
    this.defaultBlackList.add("insertXWebLivePusher");
    this.defaultBlackList.add("updateXWebLivePusher");
    this.defaultBlackList.add("removeXWebLivePusher");
    this.defaultBlackList.add("operateXWebLivePusher");
    this.defaultBlackList.add("shareAppPictureMessage");
    this.defaultBlackList.add("shareAppPictureMessageDirectly");
    this.defaultBlackList.add("getPhoneNumber");
    this.defaultBlackList.add("wnsRequest");
    this.defaultBlackList.add("getQua");
    this.defaultBlackList.add("notifyNative");
    this.defaultBlackList.add("openUrl");
    this.defaultBlackList.add("getUserInfoExtra");
    this.defaultBlackList.add("openScheme");
    this.defaultBlackList.add("Personalize");
    this.defaultBlackList.add("invokeNativePlugin");
    if (this.secondApiMap == null) {
      this.secondApiMap = new HashMap();
    }
    this.secondApiMap.put("openScheme", new HashMap());
    this.secondApiMap.put("Personalize", new HashMap());
    this.secondApiMap.put("invokeNativePlugin", new HashMap());
    this.defaultBlackList.add("startDownloadAppTask");
    this.defaultBlackList.add("cancelDownloadAppTask");
    this.defaultBlackList.add("queryDownloadAppTask");
    this.defaultBlackList.add("queryAppInfo");
    this.defaultBlackList.add("installApp");
    this.defaultBlackList.add("startApp");
    this.defaultBlackList.add("showMiniAIOEntrance");
    this.defaultBlackList.add("hideMiniAIOEntrance");
    this.defaultBlackList.add("getGroupInfoExtra");
    this.defaultBlackList.add("wnsGroupRequest");
    this.defaultBlackList.add("insertBookshelf");
    this.defaultBlackList.add("queryBookshelf");
    this.defaultBlackList.add("updateBookshelfReadTime");
    this.defaultBlackList.add("navigateToBookshelf");
  }
  
  public static boolean isAuthWhiteAppId(String paramString)
  {
    if ((authWhiteList != null) && (authWhiteList.size() > 0) && (!TextUtils.isEmpty(paramString))) {
      return authWhiteList.contains(paramString);
    }
    return false;
  }
  
  private boolean isEventNameRight(String paramString1, String paramString2)
  {
    if ((this.firstApiMap != null) && (this.firstApiMap.containsKey(paramString1)))
    {
      if (((Integer)this.firstApiMap.get(paramString1)).intValue() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, first level blacklist : " + paramString1);
        }
        return false;
      }
      if (((Integer)this.firstApiMap.get(paramString1)).intValue() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "true, first level whitelist: " + paramString1);
        }
        return true;
      }
    }
    if (this.secondApiRightMap.containsKey(paramString1))
    {
      if ((this.secondApiRightMap.get(paramString1) != null) && (((HashMap)this.secondApiRightMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((HashMap)this.secondApiRightMap.get(paramString1)).get(paramString2)).intValue() == -1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, second level blacklist: " + paramString1 + " " + paramString2);
        }
        return false;
      }
      if ((this.secondApiRightMap.get(paramString1) != null) && (((HashMap)this.secondApiRightMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((HashMap)this.secondApiRightMap.get(paramString1)).get(paramString2)).intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "true, network second level whitelist: " + paramString1 + " " + paramString2);
        }
        return true;
      }
      if ((this.secondApiMap != null) && (this.secondApiMap.containsKey(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, second level blacklist or not config: " + paramString1 + " " + paramString2);
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "true, default second level whitelist: " + paramString1 + " " + paramString2);
      }
      return true;
    }
    if ((this.defaultBlackList != null) && (this.defaultBlackList.contains(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, local blacklist : " + paramString1);
      }
      return false;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("BaseJsPluginEngine_isEventNameRight", 1, "true, permissible api : " + paramString1);
    }
    return true;
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
  
  private void removeAllMessage()
  {
    this.uiHandler.removeMessages(1);
    this.uiHandler.removeMessages(2);
    this.uiHandler.removeMessages(3);
    this.uiHandler.removeMessages(4);
  }
  
  private void reportApiInvoke(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new BaseJsPluginEngine.6(this, paramString));
  }
  
  private void reqGrantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    boolean bool1;
    label82:
    boolean bool2;
    if (this.authorizeCenter.getAuthFlag(paramString1, paramString2) == 4)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest hasRefused=" + bool1 + ",isPause=" + this.isPause);
      }
      if ((bool1) && (!this.authorizeCenter.shouldAskEveryTime(paramString1, paramString2))) {
        break label303;
      }
      bool1 = true;
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        if ("operateWXData".equals(paramString1))
        {
          localObject = new JSONObject(paramString2).optJSONObject("data");
          str = ((JSONObject)localObject).optString("api_name");
          if ((!"webapi_getuserinfo".equals(str)) && (!"getSubjectalterInfo".equals(str)) && (!"webapi_wxa_subscribe_biz".endsWith(str))) {
            continue;
          }
          bool2 = ((JSONObject)localObject).optBoolean("from_component");
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        label303:
        boolean bool3;
        QZLog.e("BaseJsPluginEngine", 2, new Object[] { Log.getStackTraceString(localThrowable) });
        bool2 = bool1;
        continue;
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest callbackJsEventFail");
        callbackJsEventFail(paramJsRuntime, paramString1, null, "auth deny", paramInt);
        this.uiHandler.obtainMessage(1).sendToTarget();
      }
      if (!bool2) {
        continue;
      }
      if (paramBoolean)
      {
        paramJsRuntime = new BaseJsPluginEngine.NativeJobInfo(this, paramString1, paramString2, paramJsRuntime, paramInt);
        this.jobQueue.offer(paramJsRuntime);
      }
      if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
      {
        paramJsRuntime = this.uiHandler.obtainMessage(2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_event_name", paramString1);
        ((Bundle)localObject).putString("key_params", paramString2);
        ((Bundle)localObject).putInt("key_callback_id", paramInt);
        if (this.appBrandRuntime != null) {
          ((Bundle)localObject).putString("key_app_id", this.appBrandRuntime.appId);
        }
        paramJsRuntime.setData((Bundle)localObject);
        paramJsRuntime.sendToTarget();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label82;
      if ((!"webapi_plugin_setauth".equals(str)) && (!"webapi_plugin_login".equals(str)))
      {
        bool3 = "webapi_plugin_getuserinfo".equals(str);
        bool2 = bool1;
        if (!bool3) {}
      }
      else
      {
        bool2 = false;
      }
    }
  }
  
  private void reqGrantOnceSubscribeApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    JSONArray localJSONArray;
    ArrayList localArrayList;
    try
    {
      localJSONArray = new JSONObject(paramString2).optJSONArray("tmplIds");
      if (localJSONArray == null) {
        break label179;
      }
      localArrayList = new ArrayList();
      if (localJSONArray.length() > 3)
      {
        subscribeMsgCallbackFail(paramJsRuntime, "subscribeOnceAppMsg", "Templates count out of max bounds", 20003, paramInt);
        return;
      }
      if (localJSONArray.length() == 0)
      {
        subscribeMsgCallbackFail(paramJsRuntime, "subscribeOnceAppMsg", "TmplIds can't be empty", 10001, paramInt);
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("BaseJsPluginEngine", 1, "reqGrantOnceSubscribeApiPermission get an Exception:" + paramString1);
      return;
    }
    int i = 0;
    while (i < localJSONArray.length())
    {
      localArrayList.add(localJSONArray.getString(i));
      i += 1;
    }
    MiniAppCmdUtil.getInstance().getUserSetting(this.appBrandRuntime.appId, "", "setting.onceMsgSubscribed", localArrayList, new BaseJsPluginEngine.4(this, paramString1, paramString2, paramJsRuntime, paramInt));
    return;
    label179:
    QLog.e("BaseJsPluginEngine", 1, "reqGrantOnceSubscribeApiPermission: tmplIdJsonArr is null!");
    subscribeMsgCallbackFail(paramJsRuntime, "subscribeOnceAppMsg", "TmplIds can't be empty", 10001, paramInt);
  }
  
  private void reqGrantSubscribeApiPermission(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    int i = this.authorizeCenter.getAuthFlag("subscribeAppMsg", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("BaseJsPluginEngine", 2, "reqGrantSubscribeApiPermission authFlag=" + i + ",isPause=" + this.isPause);
    }
    try
    {
      Object localObject = new BaseJsPluginEngine.3(this, paramJsRuntime, paramInt);
      if ((i == 1) && (!this.isSubAuthIgnore))
      {
        this.isFirstTimeRequestAuth = true;
        localObject = new BaseJsPluginEngine.NativeJobInfo(this, "subscribeAppMsg", paramString, paramJsRuntime, paramInt);
        this.jobQueue.offer(localObject);
        if ((this.isPause) || ((this.authDialog != null) && (this.authDialog.isShowing()))) {
          return;
        }
        localObject = this.uiHandler.obtainMessage(2);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_event_name", "subscribeAppMsg");
        localBundle.putString("key_params", paramString);
        ((Message)localObject).setData(localBundle);
        ((Message)localObject).sendToTarget();
        return;
      }
      if (i == 2)
      {
        this.isFirstTimeRequestAuth = false;
        this.authorizeCenter.setAuthorize(AuthorizeCenter.getScopeName("subscribeAppMsg", paramString), true, (MiniAppCmdInterface)localObject);
        return;
      }
    }
    catch (JSONException paramString)
    {
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", null, amtj.a(2131700157), paramInt);
      return;
    }
    if ((i == 4) || (this.isSubAuthIgnore))
    {
      if (this.isSubAuthIgnore)
      {
        paramString = new JSONObject();
        paramString.put("SubscribeAppMsgCode", -2);
        callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", paramString, "user pass auth", paramInt);
        this.isSubAuthIgnore = false;
        return;
      }
      if (this.isFirstTimeRequestAuth)
      {
        paramString = new JSONObject();
        paramString.put("SubscribeAppMsgCode", 0);
        callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", paramString, "no permission", paramInt);
        this.isFirstTimeRequestAuth = false;
        return;
      }
      paramString = new JSONObject();
      paramString.put("SubscribeAppMsgCode", -1);
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", paramString, "no permission", paramInt);
    }
  }
  
  private void reqSubscribeSystemMessagePermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("BaseJsPluginEngine", 1, "reqSubscribeSystemMessagePermission jsonParams: " + paramString2);
    try
    {
      localObject2 = new JSONObject(paramString2).optJSONArray("msgTypeList");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() > 3))
      {
        subscribeMsgCallbackFail(paramJsRuntime, "requestSubscribeSystemMessage", "Invalid template id", 10004, paramInt);
        return;
      }
      if (((JSONArray)localObject2).length() == 0)
      {
        subscribeMsgCallbackFail(paramJsRuntime, "requestSubscribeSystemMessage", "msgTypeList can't be empty", 10001, paramInt);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      subscribeMsgCallbackFail(paramJsRuntime, "requestSubscribeSystemMessage", "Invalid template id", 10004, paramInt);
      QLog.e("BaseJsPluginEngine", 1, "reqSubscribeSystemMessagePermission parse params exception", paramString1);
      return;
    }
    int j = 0;
    Object localObject1 = new HashMap();
    int i = 0;
    while (i < ((JSONArray)localObject2).length())
    {
      localObject3 = ((JSONArray)localObject2).get(i).toString();
      j = 1;
      ((Map)localObject1).put(localObject3, Integer.valueOf(1));
      i += 1;
    }
    if (j != 0)
    {
      if (this.isPause)
      {
        subscribeMsgCallbackFail(paramJsRuntime, "requestSubscribeSystemMessage", "Cannot show subscribe message UI", 10005, paramInt);
        return;
      }
      localObject1 = new ArrayList(((Map)localObject1).keySet());
      MiniAppCmdUtil.getInstance().getUserSetting(this.appBrandRuntime.appId, "", "setting.sysMsgSubscribed", (ArrayList)localObject1, new BaseJsPluginEngine.2(this, paramString1, paramString2, paramJsRuntime, paramInt));
      return;
    }
    Object localObject2 = new JSONObject();
    Object localObject3 = ((Map)localObject1).keySet().iterator();
    String str;
    if (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (((Integer)((Map)localObject1).get(str)).intValue() != 2) {
        break label356;
      }
    }
    label356:
    for (paramString2 = "accept";; paramString2 = "reject")
    {
      ((JSONObject)localObject2).put(str, paramString2);
      break;
      callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject2, paramInt);
      return;
    }
  }
  
  private void showOnceSubMsgReqDialog(String paramString1, String paramString2, String paramString3, JsRuntime paramJsRuntime, int paramInt, byte[] paramArrayOfByte)
  {
    if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
    {
      this.onceSubWebView = paramJsRuntime;
      this.onceSubCallbackId = paramInt;
      paramJsRuntime = this.uiHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramString1);
      localBundle.putString("key_setting_item", paramString2);
      localBundle.putString("key_params", paramString3);
      localBundle.putByteArray("key_once_sub_rsp_data", paramArrayOfByte);
      paramJsRuntime.setData(localBundle);
      paramJsRuntime.sendToTarget();
    }
  }
  
  public boolean apiAuthoritySilent()
  {
    return (this.appBrandRuntime != null) && (this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null) && ((this.appBrandRuntime.getApkgInfo().appConfig.config.isAppStoreMiniApp()) || (this.appBrandRuntime.getApkgInfo().appConfig.config.appMode.authoritySilent));
  }
  
  public void callbackJsEventCancel(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt) {}
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt) {}
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt) {}
  
  public void callbackJsEventOK(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt) {}
  
  public ActivityContext getActivityContext()
  {
    return this.activityContext;
  }
  
  public MiniAppInfo getAppInfo()
  {
    if ((this.appBrandRuntime != null) && (this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null)) {
      return this.appBrandRuntime.getApkgInfo().appConfig.config;
    }
    return null;
  }
  
  public int getCurInputId()
  {
    return curInputId;
  }
  
  @Nullable
  public EntryModel getEntryModel()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.appBrandRuntime != null)
    {
      localObject1 = localObject2;
      if (this.appBrandRuntime.getApkgInfo() != null)
      {
        localObject1 = localObject2;
        if (this.appBrandRuntime.getApkgInfo().appConfig != null)
        {
          localObject1 = localObject2;
          if (this.appBrandRuntime.getApkgInfo().appConfig.launchParam != null) {
            localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel;
          }
        }
      }
    }
    return localObject1;
  }
  
  @Nullable
  protected final IJsPlugin getEventHandler(@NonNull String paramString)
  {
    return (IJsPlugin)this.mPluginEventMap.get(paramString);
  }
  
  public String getPkgName()
  {
    return "";
  }
  
  public JsRuntime getServiceRuntime()
  {
    return null;
  }
  
  public WebviewContainer getWebviewContainer(JsRuntime paramJsRuntime)
  {
    if ((paramJsRuntime instanceof PageWebview))
    {
      AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId());
      paramJsRuntime = ((PageWebview)paramJsRuntime).getRouteUrl();
      if (localAbsAppBrandPage != null) {
        return localAbsAppBrandPage.getWebviewContainerByUrl(paramJsRuntime);
      }
    }
    else
    {
      return this.appBrandRuntime.getCurWebviewContainer();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("BaseJsPluginEngine", 2, "handleMessage what=" + paramMessage.what + ",isDestory=" + this.isDestory);
    }
    if ((this.isDestory) || (this.isPause)) {
      return false;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      localObject1 = this.jobQueue.iterator();
      if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
      {
        localObject2 = (String)paramMessage.obj;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("setting.appMsgSubscribed"))) {
          if ((((String)localObject2).equals("scope.camera")) && (getServiceRuntime() != null)) {
            getServiceRuntime().evaluateSubcribeJS("onCameraNeedAuthCancel", null, 0);
          }
        }
      }
      break;
    case 2: 
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          paramMessage = (BaseJsPluginEngine.NativeJobInfo)((Iterator)localObject1).next();
          if (((String)localObject2).equals(AuthorizeCenter.getScopeName(paramMessage.eventName, paramMessage.jsonParams)))
          {
            ((Iterator)localObject1).remove();
            callbackJsEventFail(paramMessage.jsRuntime, paramMessage.eventName, null, "auth deny", paramMessage.callbackId);
            continue;
            paramMessage = paramMessage.getData();
            localObject1 = paramMessage.getString("key_event_name", "");
            localObject3 = paramMessage.getString("key_params", "");
            if (!"getPhoneNumber".equals(localObject1)) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      label289:
      this.authDialog = new AuthDialog(this.activityContext, i);
      if (("subscribeOnceAppMsg".equals(localObject1)) || ("requestSubscribeSystemMessage".equals(localObject1))) {
        this.authDialog.setOnDismissListener(this.onceSubDismissListener);
      }
      String str1;
      String str2;
      String str3;
      String str4;
      for (;;)
      {
        this.authDialog.bindData(paramMessage);
        String str5 = AuthorizeCenter.getScopeName((String)localObject1, (String)localObject3);
        if (str5 == null) {
          break;
        }
        localObject2 = (String)AuthorizeCenter.scopeTitleMap.get(str5);
        str1 = (String)AuthorizeCenter.scopeDescMap.get(str5);
        str2 = (String)AuthorizeCenter.scopeReportMap.get(str5);
        localObject1 = (String)AuthorizeCenter.negativeButtonDesMap.get(str5);
        paramMessage = (Message)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramMessage = amtj.a(2131700160);
        }
        if (this.appBrandRuntime == null) {
          break;
        }
        localObject1 = this.appBrandRuntime.getApkgInfo();
        if (localObject1 == null) {
          break;
        }
        str3 = ((ApkgInfo)localObject1).iconUrl;
        str4 = ((ApkgInfo)localObject1).apkgName;
        if (!"scope.userInfo".equals(str5)) {
          break label547;
        }
        MiniAppCmdUtil.getInstance().getUserInfo(this.appBrandRuntime.appId, false, "en", new BaseJsPluginEngine.7(this, str3, str4, (String)localObject2, str1, str2));
        return false;
        if ("subscribeOnceAppMsg".equals(localObject1))
        {
          i = 3;
          break label289;
        }
        if (!"requestSubscribeSystemMessage".equals(localObject1)) {
          break label988;
        }
        i = 4;
        break label289;
        this.authDialog.setOnDismissListener(this.dismissListener);
      }
      label547:
      if ((this.authDialog == null) || (this.isPause)) {
        break;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject3).optJSONObject("getPhoneNumber");
        if ((localObject1 == null) || (!((JSONObject)localObject1).has("phoneLists"))) {
          break label724;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("phoneLists");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("BaseJsPluginEngine", 1, "get phoneNumberList error,", localThrowable);
          localIterator = null;
        }
      }
      localObject3 = new AuthDialog.AuthDialogResBuilder();
      ((AuthDialog.AuthDialogResBuilder)localObject3).setMiniAppIconUrl(str3).setMiniAppName(str4).setAuthTitle((String)localObject2).setAuthDesc(str1).setReportSubAction(str2).setMiniAppConfig(this.appBrandRuntime.getApkgInfo().appConfig).setLeftBtnText(paramMessage).setLeftBtnClickListener(new BaseJsPluginEngine.9(this)).setRightBtnText(amtj.a(2131700158)).setRightBtnClickListener(new BaseJsPluginEngine.8(this));
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        ((AuthDialog.AuthDialogResBuilder)localObject3).setPhoneNumberList((JSONArray)localObject1);
      }
      this.authDialog.show((AuthDialog.AuthDialogResBuilder)localObject3);
      return false;
      label724:
      Iterator localIterator = this.sysPermissionQueue.iterator();
      if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
      {
        paramMessage = (String)paramMessage.obj;
        if (TextUtils.isEmpty(paramMessage)) {
          break;
        }
        if ((paramMessage.equals("android.permission.CAMERA")) && (getServiceRuntime() != null)) {
          getServiceRuntime().evaluateSubcribeJS("onCameraNeedAuthCancel", null, 0);
        }
        while (localIterator.hasNext())
        {
          localObject2 = (BaseJsPluginEngine.NativeJobInfo)localIterator.next();
          if (paramMessage.equals(AuthorizeCenter.systemPermissionMap.get(((BaseJsPluginEngine.NativeJobInfo)localObject2).eventName)))
          {
            localIterator.remove();
            callbackJsEventFail(((BaseJsPluginEngine.NativeJobInfo)localObject2).jsRuntime, ((BaseJsPluginEngine.NativeJobInfo)localObject2).eventName, null, "auth deny", ((BaseJsPluginEngine.NativeJobInfo)localObject2).callbackId);
          }
        }
        break;
      }
      paramMessage = (BaseJsPluginEngine.NativeJobInfo)this.sysPermissionQueue.peek();
      if (paramMessage == null) {
        break;
      }
      this.jobQueue.remove(paramMessage);
      handleNativeRequest(paramMessage.eventName, paramMessage.jsonParams, paramMessage.jsRuntime, paramMessage.callbackId);
      return false;
      if ((((String)localObject2).equals("setting.appMsgSubscribed")) && (paramMessage.arg1 == 3)) {
        this.isSubAuthIgnore = true;
      }
      paramMessage = (BaseJsPluginEngine.NativeJobInfo)this.jobQueue.peek();
      if (paramMessage == null) {
        break;
      }
      this.jobQueue.remove(paramMessage);
      handleNativeRequestInner(paramMessage.eventName, paramMessage.jsonParams, paramMessage.jsRuntime, paramMessage.callbackId, true);
      return false;
      label988:
      i = 1;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramJsRuntime == null) || (this.isDestory))
    {
      QLog.w("BaseJsPluginEngine", 1, "handleNativeRequest fail eventName=" + paramString1 + ",webview=" + paramJsRuntime + ",callbackId=" + paramInt + ",isDestory=" + this.isDestory);
      return "";
    }
    String str2 = "";
    Object localObject;
    try
    {
      if ((this.secondApiMap == null) || (!this.secondApiMap.containsKey(paramString1)))
      {
        str1 = str2;
        if (!this.secondApiRightMap.containsKey(paramString1)) {}
      }
      else
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        str1 = str2;
        if (localJSONObject.has("api_name")) {
          str1 = localJSONObject.optString("api_name", "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        QLog.e("BaseJsPluginEngine", 1, "handleNativeRequest get apiName error.", localException);
        localObject = str2;
      }
      callbackJsEventFail(paramJsRuntime, paramString1, null, "no permission", paramInt);
      return "";
    }
    if ((!isMiniAppStore()) && (!isEventNameRight(paramString1, str1)))
    {
      QLog.e("BaseJsPluginEngine", 1, "eventname : " + paramString1 + "; apiName : " + str1 + " request failed.");
      if (paramString1.endsWith("Sync")) {
        return ApiUtil.wrapCallbackFail(paramString1, null, "no permission").toString();
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.appBrandRuntime != null)
      {
        localObject = this.appBrandRuntime.activity;
        if ((localObject == null) || (!(localObject instanceof BaseActivity))) {
          break label400;
        }
        localObject = (BaseActivity)localObject;
        label320:
        if (localObject != null)
        {
          str2 = AuthorizeCenter.getSystemPermission(paramString1, paramString2);
          if (StringUtil.isEmpty(str2)) {
            break label450;
          }
          if (((BaseActivity)localObject).checkSelfPermission(str2) != 0) {
            break label406;
          }
        }
      }
      label400:
      label406:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label412;
        }
        ((BaseActivity)localObject).requestPermissions(new BaseJsPluginEngine.1(this, paramString1, paramString2, paramJsRuntime, paramInt, str2, (BaseActivity)localObject), 1, new String[] { str2 });
        return "";
        localObject = null;
        break;
        localObject = null;
        break label320;
      }
      label412:
      QLog.d("BaseJsPluginEngine", 2, str2 + " has granted permission!!!");
      return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
      label450:
      return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
    }
    return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
  }
  
  public void init()
  {
    initDefaultBlackMap();
    initAuthWhiteList();
  }
  
  public boolean isMiniAppStore()
  {
    return (this.appBrandRuntime != null) && (this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config.isAppStoreMiniApp());
  }
  
  public void onAttachWindow(ActivityContext paramActivityContext)
  {
    this.activityContext = paramActivityContext;
  }
  
  public void onCreate()
  {
    assertInMainThread();
    this.authorizeCenter = this.appBrandRuntime.appInterface.getAuthorizeCenter(this.appBrandRuntime.appId);
    Object localObject1;
    if ((this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null))
    {
      if (this.firstApiMap == null) {
        this.firstApiMap = new HashMap();
      }
      localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.config.whiteList;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseJsPluginEngine", 2, "whiteList eventName : " + (String)localObject2);
            }
            this.firstApiMap.put(localObject2, Integer.valueOf(1));
          }
        }
      }
      localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.config.blackList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseJsPluginEngine", 2, "blackList eventName : " + (String)localObject2);
            }
            this.firstApiMap.put(localObject2, Integer.valueOf(0));
          }
        }
      }
      localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.config.secondApiRightInfoList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SecondApiRightInfo)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (this.secondApiRightMap.containsKey(((SecondApiRightInfo)localObject2).apiName))
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseJsPluginEngine", 2, "config apiName : " + ((SecondApiRightInfo)localObject2).apiName + ", secondName: " + ((SecondApiRightInfo)localObject2).secondName);
              }
              ((HashMap)this.secondApiRightMap.get(((SecondApiRightInfo)localObject2).apiName)).put(((SecondApiRightInfo)localObject2).secondName, Integer.valueOf(((SecondApiRightInfo)localObject2).right));
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseJsPluginEngine", 2, "init config apiName : " + ((SecondApiRightInfo)localObject2).apiName + ", secondName: " + ((SecondApiRightInfo)localObject2).secondName);
              }
              HashMap localHashMap = new HashMap();
              localHashMap.put(((SecondApiRightInfo)localObject2).secondName, Integer.valueOf(((SecondApiRightInfo)localObject2).right));
              this.secondApiRightMap.put(((SecondApiRightInfo)localObject2).apiName, localHashMap);
            }
          }
        }
      }
    }
    this.isPause = false;
    this.isDestory = false;
    if (!this.isCreated)
    {
      this.isCreated = true;
      localObject1 = this.mPluginList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IJsPlugin)((Iterator)localObject1).next()).onCreate(this);
      }
    }
  }
  
  public void onDestroy()
  {
    this.isPause = true;
    this.isDestory = true;
    this.isCreated = false;
    Iterator localIterator = this.mPluginList.iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onDestroy();
    }
    this.mPluginList.clear();
    this.mPluginEventMap.clear();
    if (this.firstApiMap != null) {
      this.firstApiMap.clear();
    }
    this.jobQueue.clear();
    removeAllMessage();
    if (this.authDialog != null)
    {
      this.authDialog.setOnDismissListener(null);
      this.authDialog.dismiss();
      this.authDialog = null;
    }
  }
  
  public void onPause()
  {
    this.isPause = true;
    Iterator localIterator = this.mPluginList.iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onPause();
    }
    removeAllMessage();
  }
  
  public void onResume()
  {
    this.isPause = false;
    Iterator localIterator = this.mPluginList.iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onResume();
    }
    this.uiHandler.obtainMessage(1).sendToTarget();
    this.uiHandler.obtainMessage(4).sendToTarget();
  }
  
  public void onceSubMsgCallbackFail(String paramString, JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramJsRuntime, paramString, paramJSONObject, paramInt);
  }
  
  public void onceSubMsgCallbackSuc(String paramString, JsRuntime paramJsRuntime, List<INTERFACE.StSubscribeMessage> paramList, int paramInt)
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
      QLog.e("BaseJsPluginEngine", 1, "onceSubMsgCallbackSuc get a Exception:", paramList);
      callbackJsEventOK(paramJsRuntime, paramString, localJSONObject, paramInt);
    }
  }
  
  public void onceSubMsgCallbackSuc(String paramString, JsRuntime paramJsRuntime, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, List<INTERFACE.StSubscribeMessage> paramList3, boolean paramBoolean, int paramInt)
  {
    int k = 0;
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    label90:
    Object localObject;
    label189:
    label200:
    label203:
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
            break label322;
          }
          paramList2 = "accept";
          localJSONObject.put(paramList3, paramList2);
          i += 1;
          continue;
          if (i >= paramList1.size()) {
            break label200;
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
        QLog.e("BaseJsPluginEngine", 1, "onceSubMsgCallbackSuc get a Exception:", paramList1);
      }
      callbackJsEventOK(paramJsRuntime, paramString, localJSONObject, paramInt);
      return;
      i = 0;
      j = k;
      if (i < paramList2.size())
      {
        paramList1 = (INTERFACE.StSubscribeMessage)paramList2.get(i);
        localObject = paramList1.templateId.get();
        if (paramList1.authState.get() != 2) {
          break label345;
        }
      }
    }
    label322:
    label345:
    for (paramList1 = "reject";; paramList1 = "accept")
    {
      localJSONObject.put((String)localObject, paramList1);
      i += 1;
      break label203;
      while (j < paramList3.size())
      {
        localJSONObject.put(((INTERFACE.StSubscribeMessage)paramList3.get(j)).templateId.get(), "reject");
        j += 1;
      }
      break label189;
      paramList2 = "reject";
      break;
      i = 0;
      break label90;
      i += 1;
      break label90;
    }
  }
  
  public void registerPlugin(@NonNull IJsPlugin paramIJsPlugin)
  {
    if (paramIJsPlugin == null) {}
    for (;;)
    {
      return;
      this.mPluginList.add(paramIJsPlugin);
      Iterator localIterator = paramIJsPlugin.supportedEvents().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.mPluginEventMap.containsKey(str)) {
          QLog.w("BaseJsPluginEngine", 1, "registerJsPlugin, conflict event:" + str);
        }
        this.mPluginEventMap.put(str, paramIJsPlugin);
      }
    }
  }
  
  public void registerPlugins(ArrayList<IJsPlugin> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      registerPlugin((IJsPlugin)paramArrayList.next());
    }
  }
  
  public void reqAuthorize(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    paramJsRuntime = new BaseJsPluginEngine.NativeJobInfo(this, paramString1, paramString2, paramJsRuntime, paramInt);
    this.jobQueue.offer(paramJsRuntime);
    if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
    {
      paramJsRuntime = this.uiHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramString1);
      localBundle.putString("key_params", paramString2);
      paramJsRuntime.setData(localBundle);
      paramJsRuntime.sendToTarget();
    }
  }
  
  public void reqGrantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, BaseJsPluginEngine.ReqGantApiPermissionCallback paramReqGantApiPermissionCallback)
  {
    this.mReqGantApiPermissionCallbackMap.put(Integer.valueOf(paramInt), paramReqGantApiPermissionCallback);
    reqGrantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt, false);
  }
  
  public void setAppBrandRuntime(BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.appBrandRuntime = paramBaseAppBrandRuntime;
  }
  
  public void setCurInputId(int paramInt)
  {
    curInputId = paramInt;
  }
  
  public void subscribeMsgCallbackFail(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt1);
      callbackJsEventFail(paramJsRuntime, paramString1, localJSONObject, paramString2, paramInt2);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("BaseJsPluginEngine", 1, "subscribeMsgCallbackFail exception:", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */