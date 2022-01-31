package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajyc;
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
import bbjw;
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
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseJsPluginEngine<ActivityContext extends BaseActivity>
  implements Handler.Callback
{
  public static final int API_BLACK = 0;
  public static final int API_WHITE = 1;
  private static final String CONFIG_SPLIT = ",";
  public static final String TAG = "BaseJsPluginEngine";
  private static ArrayList<String> authWhiteList;
  private static volatile int curInputId = -1;
  private static String mCurWhiteListConfig;
  private final int AUTH_PASS = 3;
  private final int AUTH_REFUSE = 2;
  private final int AUTH_SUCC = 1;
  private final String KEY_EVENT_NAME = "key_event_name";
  private final String KEY_JOB_INFO = "key_job_info";
  private final String KEY_PARAMS = "key_params";
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
  private boolean isPause;
  public ConcurrentLinkedQueue<BaseJsPluginEngine.NativeJobInfo> jobQueue;
  private final HashMap<String, IJsPlugin> mPluginEventMap = new HashMap();
  private final ArrayList<IJsPlugin> mPluginList = new ArrayList();
  private HashMap<String, HashMap<String, Integer>> secondApiMap;
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
      this.dismissListener = new BaseJsPluginEngine.8(this);
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
    if (("getPhoneNumber".equals(paramString1)) && (TextUtils.isEmpty((CharSequence)AuthorizeCenter.scopeDescMap.get("scope.getPhoneNumber"))))
    {
      MiniAppCmdUtil.getInstance().getPhoneNumber(this.appBrandRuntime.appId, new BaseJsPluginEngine.2(this, paramString1, paramString2, paramJsRuntime, paramInt, paramBoolean));
      return "";
    }
    String str;
    if (i == 1) {
      if (!apiAuthoritySilent())
      {
        if (this.appBrandRuntime != null)
        {
          str = this.appBrandRuntime.appId;
          label122:
          if (!isAuthWhiteAppId(str)) {
            break label299;
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
    label299:
    label340:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest authFlag=" + i + ",eventName=" + paramString1 + ",callbackId=" + paramInt);
      }
      if (i == 2)
      {
        str = grantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt);
        paramJsRuntime = str;
        if (!AuthorizeCenter.isInScopeList(paramString1, paramString2)) {
          break;
        }
        paramJsRuntime = str;
        if (this.jobQueue.size() <= 0) {
          break;
        }
        this.uiHandler.obtainMessage(1).sendToTarget();
        return str;
        str = null;
        break label122;
        if (paramBoolean)
        {
          i = 2;
          continue;
        }
        if (!this.authorizeCenter.shouldAskEveryTime(paramString1, paramString2)) {
          break label340;
        }
        i = 1;
        continue;
      }
      reqGrantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt);
      return "";
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
    if ((this.secondApiMap != null) && (this.secondApiMap.containsKey(paramString1)))
    {
      if ((this.secondApiMap.get(paramString1) != null) && (((HashMap)this.secondApiMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((HashMap)this.secondApiMap.get(paramString1)).get(paramString2)).intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "true, second level whitelist: " + paramString1 + " " + paramString2);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, second level blacklist or not config: " + paramString1 + " " + paramString2);
      }
      return false;
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
  
  private void removeAllMessage()
  {
    this.uiHandler.removeMessages(1);
    this.uiHandler.removeMessages(2);
    this.uiHandler.removeMessages(3);
    this.uiHandler.removeMessages(4);
  }
  
  private void reportApiInvoke(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new BaseJsPluginEngine.4(this, paramString));
  }
  
  private void reqGrantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    boolean bool1;
    if (this.authorizeCenter.getAuthFlag(paramString1, paramString2) == 4)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest hasRefused=" + bool1 + ",isPause=" + this.isPause);
      }
      if ((bool1) && (!this.authorizeCenter.shouldAskEveryTime(paramString1, paramString2))) {
        break label268;
      }
      bool1 = true;
    }
    for (;;)
    {
      try
      {
        if (!"operateWXData".equals(paramString1)) {
          continue;
        }
        localObject = new JSONObject(paramString2).optJSONObject("data");
        String str = ((JSONObject)localObject).optString("api_name");
        if ((!"webapi_getuserinfo".equals(str)) && (!"getSubjectalterInfo".equals(str)))
        {
          bool2 = bool1;
          if (!"webapi_wxa_subscribe_biz".endsWith(str)) {}
        }
        else
        {
          bool2 = ((JSONObject)localObject).optBoolean("from_component");
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        label268:
        boolean bool3;
        QZLog.e("BaseJsPluginEngine", 2, new Object[] { Log.getStackTraceString(localThrowable) });
        boolean bool2 = bool1;
        continue;
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest callbackJsEventFail");
        callbackJsEventFail(paramJsRuntime, paramString1, null, "auth deny", paramInt);
        this.uiHandler.obtainMessage(1).sendToTarget();
      }
      if (!bool2) {
        continue;
      }
      paramJsRuntime = new BaseJsPluginEngine.NativeJobInfo(this, paramString1, paramString2, paramJsRuntime, paramInt);
      this.jobQueue.offer(paramJsRuntime);
      if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
      {
        paramJsRuntime = this.uiHandler.obtainMessage(2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_event_name", paramString1);
        ((Bundle)localObject).putString("key_params", paramString2);
        paramJsRuntime.setData((Bundle)localObject);
        paramJsRuntime.sendToTarget();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool2 = bool1;
      if ("authorize".equals(paramString1))
      {
        bool3 = "scope.userInfo".equals(((JSONArray)new JSONObject(paramString2).get("scope")).get(0));
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
    }
  }
  
  private void reqGrantSubscribeApiPermission(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    int i = this.authorizeCenter.getAuthFlag("subscribeAppMsg", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("BaseJsPluginEngine", 2, "reqGrantSubscribeApiPermission authFlag=" + i + ",isPause=" + this.isPause);
    }
    Object localObject;
    try
    {
      localObject = new JSONObject(paramString).opt("subscribe");
      if (!(localObject instanceof Boolean)) {
        break label300;
      }
      boolean bool = ((Boolean)localObject).booleanValue();
      localObject = new BaseJsPluginEngine.3(this, paramJsRuntime, paramInt);
      if (!bool) {
        break label282;
      }
      if (i == 1)
      {
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
        this.authorizeCenter.setAuthorize(AuthorizeCenter.getScopeName("subscribeAppMsg", paramString), true, (MiniAppCmdInterface)localObject);
        return;
      }
    }
    catch (JSONException paramString)
    {
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", null, ajyc.a(2131700999), paramInt);
      paramString.printStackTrace();
      return;
    }
    if (i == 4)
    {
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", null, "no permission", paramInt);
      return;
      label282:
      this.authorizeCenter.setAuthorize(AuthorizeCenter.getScopeName("subscribeAppMsg", paramString), false, (MiniAppCmdInterface)localObject);
      return;
      label300:
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", null, ajyc.a(2131700998), paramInt);
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
    if (QLog.isColorLevel()) {
      QLog.d("BaseJsPluginEngine", 2, "handleMessage what=" + paramMessage.what + ",isDestory=" + this.isDestory);
    }
    if ((this.isDestory) || (this.isPause)) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.authDialog == null)
      {
        this.authDialog = new AuthDialog(this.activityContext);
        this.authDialog.setOnDismissListener(this.dismissListener);
      }
      paramMessage = paramMessage.getData();
      this.authDialog.bindData(paramMessage);
      Object localObject1 = AuthorizeCenter.getScopeName(paramMessage.getString("key_event_name", ""), paramMessage.getString("key_params", ""));
      if (localObject1 != null)
      {
        Object localObject2 = (String)AuthorizeCenter.scopeTitleMap.get(localObject1);
        String str1 = (String)AuthorizeCenter.scopeDescMap.get(localObject1);
        paramMessage = (String)AuthorizeCenter.negativeButtonDesMap.get(localObject1);
        if (TextUtils.isEmpty(paramMessage)) {
          paramMessage = ajyc.a(2131701002);
        }
        Object localObject3;
        String str2;
        while (this.appBrandRuntime != null)
        {
          localObject3 = this.appBrandRuntime.getApkgInfo();
          if (localObject3 == null) {
            break;
          }
          str2 = ((ApkgInfo)localObject3).iconUrl;
          localObject3 = ((ApkgInfo)localObject3).apkgName;
          if (!"scope.userInfo".equals(localObject1)) {
            break label303;
          }
          MiniAppCmdUtil.getInstance().getUserInfo(this.appBrandRuntime.appId, false, "en", new BaseJsPluginEngine.5(this, str2, (String)localObject3, (String)localObject2, str1));
          break;
        }
        label303:
        if ((this.authDialog != null) && (!this.isPause))
        {
          this.authDialog.show(str2, (String)localObject3, (String)localObject2, null, null, str1, paramMessage, new BaseJsPluginEngine.6(this), ajyc.a(2131701000), new BaseJsPluginEngine.7(this));
          continue;
          localObject1 = this.sysPermissionQueue.iterator();
          if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
          {
            paramMessage = (String)paramMessage.obj;
            if (!TextUtils.isEmpty(paramMessage))
            {
              if (paramMessage.equals("android.permission.CAMERA")) {
                getServiceRuntime().evaluateSubcribeJS("onCameraNeedAuthCancel", null, 0);
              }
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (BaseJsPluginEngine.NativeJobInfo)((Iterator)localObject1).next();
                if (paramMessage.equals(AuthorizeCenter.systemPermissionMap.get(((BaseJsPluginEngine.NativeJobInfo)localObject2).eventName)))
                {
                  ((Iterator)localObject1).remove();
                  callbackJsEventFail((JsRuntime)((BaseJsPluginEngine.NativeJobInfo)localObject2).jsRuntimeRef.get(), ((BaseJsPluginEngine.NativeJobInfo)localObject2).eventName, null, "auth deny", ((BaseJsPluginEngine.NativeJobInfo)localObject2).callbackId);
                }
              }
            }
          }
          else
          {
            paramMessage = (BaseJsPluginEngine.NativeJobInfo)this.sysPermissionQueue.peek();
            if (paramMessage != null)
            {
              this.jobQueue.remove(paramMessage);
              handleNativeRequest(paramMessage.eventName, paramMessage.jsonParams, (JsRuntime)paramMessage.jsRuntimeRef.get(), paramMessage.callbackId);
              continue;
              localObject1 = this.jobQueue.iterator();
              if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
              {
                paramMessage = (String)paramMessage.obj;
                if (!TextUtils.isEmpty(paramMessage))
                {
                  if (paramMessage.equals("scope.camera")) {
                    getServiceRuntime().evaluateSubcribeJS("onCameraNeedAuthCancel", null, 0);
                  }
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (BaseJsPluginEngine.NativeJobInfo)((Iterator)localObject1).next();
                    if (paramMessage.equals(AuthorizeCenter.getScopeName(((BaseJsPluginEngine.NativeJobInfo)localObject2).eventName, ((BaseJsPluginEngine.NativeJobInfo)localObject2).jsonParams)))
                    {
                      ((Iterator)localObject1).remove();
                      callbackJsEventFail((JsRuntime)((BaseJsPluginEngine.NativeJobInfo)localObject2).jsRuntimeRef.get(), ((BaseJsPluginEngine.NativeJobInfo)localObject2).eventName, null, "auth deny", ((BaseJsPluginEngine.NativeJobInfo)localObject2).callbackId);
                    }
                  }
                }
              }
              paramMessage = (BaseJsPluginEngine.NativeJobInfo)this.jobQueue.peek();
              if (paramMessage != null)
              {
                this.jobQueue.remove(paramMessage);
                handleNativeRequestInner(paramMessage.eventName, paramMessage.jsonParams, (JsRuntime)paramMessage.jsRuntimeRef.get(), paramMessage.callbackId, true);
              }
            }
          }
        }
      }
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
    String str1 = str2;
    Object localObject;
    try
    {
      if (this.secondApiMap != null)
      {
        str1 = str2;
        if (this.secondApiMap.containsKey(paramString1))
        {
          JSONObject localJSONObject = new JSONObject(paramString2);
          str1 = str2;
          if (localJSONObject.has("api_name")) {
            str1 = localJSONObject.optString("api_name", "");
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
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
          break label386;
        }
        localObject = (BaseActivity)localObject;
        label307:
        if (localObject != null)
        {
          str2 = AuthorizeCenter.getSystemPermission(paramString1, paramString2);
          if (bbjw.a(str2)) {
            break label436;
          }
          if (((BaseActivity)localObject).checkSelfPermission(str2) != 0) {
            break label392;
          }
        }
      }
      label386:
      label392:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label398;
        }
        ((BaseActivity)localObject).requestPermissions(new BaseJsPluginEngine.1(this, paramString1, paramString2, paramJsRuntime, paramInt, str2, (BaseActivity)localObject), 1, new String[] { str2 });
        return "";
        localObject = null;
        break;
        localObject = null;
        break label307;
      }
      label398:
      QLog.d("BaseJsPluginEngine", 2, str2 + " has granted permission!!!");
      return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
      label436:
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
            if (this.secondApiMap.containsKey(((SecondApiRightInfo)localObject2).apiName))
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseJsPluginEngine", 2, "config apiName : " + ((SecondApiRightInfo)localObject2).apiName + ", secondName: " + ((SecondApiRightInfo)localObject2).secondName);
              }
              ((HashMap)this.secondApiMap.get(((SecondApiRightInfo)localObject2).apiName)).put(((SecondApiRightInfo)localObject2).secondName, Integer.valueOf(((SecondApiRightInfo)localObject2).right));
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseJsPluginEngine", 2, "init config apiName : " + ((SecondApiRightInfo)localObject2).apiName + ", secondName: " + ((SecondApiRightInfo)localObject2).secondName);
              }
              HashMap localHashMap = new HashMap();
              localHashMap.put(((SecondApiRightInfo)localObject2).secondName, Integer.valueOf(((SecondApiRightInfo)localObject2).right));
              this.secondApiMap.put(((SecondApiRightInfo)localObject2).apiName, localHashMap);
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
  
  public void setAppBrandRuntime(BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.appBrandRuntime = paramBaseAppBrandRuntime;
  }
  
  public void setCurInputId(int paramInt)
  {
    curInputId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */