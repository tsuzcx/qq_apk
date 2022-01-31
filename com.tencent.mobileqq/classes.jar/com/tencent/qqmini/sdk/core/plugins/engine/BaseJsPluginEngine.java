package com.tencent.qqmini.sdk.core.plugins.engine;

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
import bghn;
import bgho;
import bgil;
import bgjd;
import bgjw;
import bgkd;
import bgke;
import bgki;
import bglo;
import bgmn;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.auth.AuthFilterList;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.auth.PermissionInfo;
import com.tencent.qqmini.sdk.core.auth.PermissionManager;
import com.tencent.qqmini.sdk.core.auth.PermissionParser;
import com.tencent.qqmini.sdk.core.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.core.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseJsPluginEngine
  implements IJsPluginEngine
{
  private static final String EVENT_AUTHORIZE = "authorize";
  private static final String EVENT_OPERATE_WXDATA = "operateWXData";
  private static final String EVENT_SUBSCRIBE_APP_MSG = "subscribeAppMsg";
  private static final String KEY_EVENT_NAME = "key_event_name";
  private static final String KEY_PARAMS = "key_params";
  private static final String KEY_SCOPE_NAME = "key_scope_name";
  private static final String TAG = "JsPluginEngine[AuthGuard]";
  private static final int WHAT_NOTIFY_SCOPE_PERMISSION_QUEUE = 1;
  private static final int WHAT_SHOW_AUTH_DIALOG = 2;
  private final int SUBSCRIBE_CODE_FAIL_OTHER = -2;
  private final int SUBSCRIBE_CODE_REJECT = -1;
  private final int SUBSCRIBE_CODE_REJECT_FIRST = 0;
  private final int SUBSCRIBE_CODE_SUC = 1;
  bgmn authDialog;
  private DialogInterface.OnDismissListener dismissListener = new BaseJsPluginEngine.8(this);
  private boolean isFirstTimeRequestAuth;
  private Handler mHandler = new Handler(Looper.getMainLooper(), new BaseJsPluginEngine.7(this));
  protected bgho mMiniAppContext;
  ConcurrentLinkedQueue<bgkd> scopePermissionQueue = new ConcurrentLinkedQueue();
  
  public BaseJsPluginEngine(Context paramContext)
  {
    initPermissionParser(paramContext);
  }
  
  private String checkRequestScopePermission(bgkd parambgkd)
  {
    String str1 = parambgkd.a;
    String str2 = parambgkd.b;
    if ("subscribeAppMsg".equals(str1)) {
      return reqGrantSubscribeApiPermission(parambgkd);
    }
    Object localObject = PermissionManager.g().getScopePermission("scope.getPhoneNumber");
    if (localObject != null) {}
    for (localObject = ((PermissionInfo)localObject).description; ("getPhoneNumber".equals(str1)) && (TextUtils.isEmpty((CharSequence)localObject)); localObject = "")
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPhoneNumber(getAppId(), new BaseJsPluginEngine.3(this, parambgkd));
      return "";
    }
    localObject = getAppId();
    if ((AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.a())) || (AuthFilterList.isAppInWhiteList((String)localObject))) {
      setScopePermissionAuthState(getRequestScopePermission(str1, str2), true);
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (isOpenDataEvent(str1, str2)) {
          bool1 = true;
        }
      }
      localObject = getRequestScopePermission(str1, str2);
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (isScopePermissionGranted((String)localObject)) {
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (shouldAskEveryTime((String)localObject)) {
          bool1 = false;
        }
      }
      QMLog.d("JsPluginEngine[AuthGuard]", "checkRequestScopePermission granted=" + bool1 + ",eventName=" + str1);
      if (bool1)
      {
        if ("authorize".equals(parambgkd.a)) {
          return handleAuthorizeEvent(parambgkd);
        }
        return dispatchRequestEvent(parambgkd);
      }
      showRequestPermissionDialog(parambgkd, (String)localObject);
      return "";
    }
  }
  
  private bgkd createRequestEvent(String paramString1, String paramString2, bghn parambghn, int paramInt)
  {
    return new bgke().a(paramString1).b(paramString2).a(parambghn).a(paramInt).a();
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
  
  private static String getRequestScopePermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      String str = extractScopeNameInJsonParams(paramString2);
      if (isScopePermissionValid(str)) {
        return str;
      }
    }
    paramString2 = extractApiNameInJsonParams(paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return PermissionManager.g().getScopePermissionByEvent(paramString1);
      paramString1 = paramString1 + "." + paramString2;
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
  
  private String handleAuthorizeEvent(bgkd parambgkd)
  {
    for (;;)
    {
      try
      {
        str1 = getAppId();
        localAuthState = MiniAppEnv.g().getAuthSate(str1);
        str2 = extractScopeNameInJsonParams(parambgkd.b);
        if ((localAuthState == null) || (!isScopePermissionValid(str2))) {
          continue;
        }
        bool = localAuthState.isSynchronized();
        if ((!str2.startsWith("setting")) || (bool)) {
          continue;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(str1, new BaseJsPluginEngine.2(this, localAuthState, str2, str1, parambgkd));
      }
      catch (Throwable localThrowable)
      {
        String str1;
        AuthState localAuthState;
        String str2;
        boolean bool;
        QMLog.e("JsPluginEngine[AuthGuard]", localThrowable.getMessage(), localThrowable);
        parambgkd.b();
        continue;
        sendShowAuthDialogMessage(parambgkd, str2);
        continue;
        QMLog.w("JsPluginEngine[AuthGuard]", "handleAuthorizeEvent, authState is null or scope invalid, scope = " + str2);
        parambgkd.b();
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
      parambgkd.a();
    }
  }
  
  private static boolean isOpenDataEvent(String paramString1, String paramString2)
  {
    if ("operateWXData".equals(paramString1)) {
      try
      {
        paramString1 = new JSONObject(paramString2).optJSONObject("data").optString("api_name");
        if ((!"webapi_getuserinfo_opendata".equals(paramString1)) && (!"webapi_getadvert".equals(paramString1)) && (!"webapi_getwerunstep_history".equals(paramString1)) && (!"advert_tap".equals(paramString1)))
        {
          boolean bool = "webapi_getnavigatewxaappinfo".equals(paramString1);
          if (!bool) {}
        }
        else
        {
          return true;
        }
      }
      catch (Throwable paramString1) {}
    }
    return false;
  }
  
  private boolean isScopePermissionGranted(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    String str = getAppId();
    return MiniAppEnv.g().getAuthSate(str).isPermissionGranted(paramString);
  }
  
  private static boolean isScopePermissionValid(String paramString)
  {
    return PermissionManager.g().isScopePermissionValid(paramString);
  }
  
  private void notifyScopePermissionQueue(Message paramMessage)
  {
    Iterator localIterator = this.scopePermissionQueue.iterator();
    if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
    {
      paramMessage = (String)paramMessage.obj;
      if ((!TextUtils.isEmpty(paramMessage)) && (!paramMessage.equals("setting.appMsgSubscribed")))
      {
        if (paramMessage.equals("scope.camera")) {
          this.mMiniAppContext.a(bgil.a("onCameraNeedAuthCancel", null, 0));
        }
        while (localIterator.hasNext())
        {
          bgkd localbgkd = (bgkd)localIterator.next();
          if (paramMessage.equals(getRequestScopePermission(localbgkd.a, localbgkd.b)))
          {
            localIterator.remove();
            localbgkd.a("auth deny");
          }
        }
      }
    }
    paramMessage = (bgkd)this.scopePermissionQueue.peek();
    if (paramMessage != null)
    {
      this.scopePermissionQueue.remove(paramMessage);
      if ("subscribeAppMsg".equals(paramMessage.a)) {
        reqGrantSubscribeApiPermission(paramMessage);
      }
    }
    else
    {
      return;
    }
    dispatchRequestEvent(paramMessage);
  }
  
  private void removeAllMessage()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
  }
  
  private String reqGrantSubscribeApiPermission(bgkd parambgkd)
  {
    Object localObject2 = MiniAppEnv.g().getAuthSate(getAppId());
    Object localObject1 = getRequestScopePermission(parambgkd.a, parambgkd.b);
    if (QMLog.isColorLevel()) {
      QMLog.d("JsPluginEngine[AuthGuard]", "reqGrantSubscribeApiPermission scopePermission=" + (String)localObject1);
    }
    if (((AuthState)localObject2).getAuthFlag((String)localObject1) == 1)
    {
      this.isFirstTimeRequestAuth = true;
      this.scopePermissionQueue.offer(parambgkd);
      if ((this.authDialog == null) || (!this.authDialog.isShowing()))
      {
        localObject2 = this.mHandler.obtainMessage(2);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_event_name", parambgkd.a);
        localBundle.putString("key_params", parambgkd.b);
        localBundle.putString("key_scope_name", (String)localObject1);
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
        ((AuthState)localObject2).setAuthState((String)localObject1, true);
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 1);
          parambgkd.a((JSONObject)localObject1);
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
          parambgkd.a((JSONObject)localObject1, "no permission");
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
  
  private void sendShowAuthDialogMessage(bgkd parambgkd, String paramString)
  {
    this.scopePermissionQueue.offer(parambgkd);
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", parambgkd.a);
      localBundle.putString("key_params", parambgkd.b);
      localBundle.putString("key_scope_name", paramString);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
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
  
  private void showAuthDialog(Bundle paramBundle)
  {
    Object localObject1 = this.mMiniAppContext.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      QMLog.w("JsPluginEngine[AuthGuard]", "showAuthDialog(). Do nothing, activity is null or finishing");
    }
    Object localObject2;
    String str1;
    Context localContext;
    MiniAppProxy localMiniAppProxy;
    String str2;
    String str3;
    do
    {
      bgjw localbgjw;
      ChannelProxy localChannelProxy;
      do
      {
        do
        {
          return;
          if (this.authDialog == null)
          {
            this.authDialog = new bgmn((Context)localObject1);
            this.authDialog.setOnDismissListener(this.dismissListener);
          }
          this.authDialog.a(paramBundle);
          paramBundle = paramBundle.getString("key_scope_name", "");
        } while (paramBundle == null);
        localObject2 = PermissionManager.g().getScopePermission(paramBundle);
        if (localObject2 == null)
        {
          QMLog.e("JsPluginEngine[AuthGuard]", "Can NOT find scope permission: " + paramBundle);
          return;
        }
        localObject1 = ((PermissionInfo)localObject2).name;
        str1 = ((PermissionInfo)localObject2).description;
        localObject2 = ((PermissionInfo)localObject2).rejectDescription;
        localContext = this.mMiniAppContext.a();
        localbgjw = getApkgInfo();
        localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      } while (localbgjw == null);
      str2 = localbgjw.iconUrl;
      str3 = localbgjw.apkgName;
      if ("scope.userInfo".equals(paramBundle))
      {
        localChannelProxy.getUserInfo(localbgjw.appId, false, "en", new BaseJsPluginEngine.4(this, localMiniAppProxy, localContext, str2, str3, (String)localObject1, str1));
        return;
      }
    } while (this.authDialog == null);
    this.authDialog.a(localMiniAppProxy.getDrawable(localContext, str2, 0, 0, null), str3, (String)localObject1, null, null, str1, (String)localObject2, new BaseJsPluginEngine.5(this), "允许", new BaseJsPluginEngine.6(this));
  }
  
  private void showRequestPermissionDialog(bgkd parambgkd, String paramString)
  {
    Object localObject = parambgkd.a;
    String str = parambgkd.b;
    boolean bool1;
    if (!isOpenDataEvent((String)localObject, str))
    {
      bool1 = isScopePermissionGranted(paramString);
      QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest hasRefused=" + bool1);
      if ((bool1) && (!shouldAskEveryTime(paramString))) {
        break label167;
      }
      bool1 = true;
    }
    for (;;)
    {
      try
      {
        if (!"operateWXData".equals(localObject)) {
          continue;
        }
        localObject = new JSONObject(str).optJSONObject("data");
        str = ((JSONObject)localObject).optString("api_name");
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
        label167:
        boolean bool3;
        QMLog.e("JsPluginEngine[AuthGuard]", Log.getStackTraceString(localThrowable));
        boolean bool2 = bool1;
        continue;
        QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest callbackJsEventFail");
        parambgkd.a("auth deny");
        this.mHandler.obtainMessage(1).sendToTarget();
      }
      if (!bool2) {
        continue;
      }
      sendShowAuthDialogMessage(parambgkd, paramString);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool2 = bool1;
      if ("authorize".equals(localObject))
      {
        bool3 = "scope.userInfo".equals(extractScopeNameInJsonParams(str));
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
    }
  }
  
  public String checkAuthorization(bgkd parambgkd)
  {
    String str2 = parambgkd.a;
    String str3 = parambgkd.b;
    String str1;
    if (AuthFilterList.isEventInSecondaryApiList(str2)) {
      str1 = extractApiNameInJsonParams(str3);
    }
    while (!AuthFilterList.isEventNameRight(str2, str1))
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "eventname : " + str2 + "; apiName : " + str1 + " request failed.");
      if (str2.endsWith("Sync"))
      {
        return bgki.a(str2, null, "no permission").toString();
        str1 = "";
      }
      else
      {
        parambgkd.a("no permission");
        return "";
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      str1 = getRequestSystemPermission(str2, str3);
      if (!bglo.a(str1))
      {
        Activity localActivity = this.mMiniAppContext.a();
        if (localActivity == null)
        {
          QMLog.w("JsPluginEngine[AuthGuard]", "Activity is null. Ignore event " + str2);
          return "";
        }
        if (localActivity.checkSelfPermission(str1) == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          bgjd.a().a(new BaseJsPluginEngine.1(this, str1, str2, str3, parambgkd));
          localActivity.requestPermissions(new String[] { str1 }, 9527);
          return "";
        }
        return checkRequestScopePermission(parambgkd);
      }
      return checkRequestScopePermission(parambgkd);
    }
    return checkRequestScopePermission(parambgkd);
  }
  
  abstract String dispatchRequestEvent(bgkd parambgkd);
  
  protected bgjw getApkgInfo()
  {
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null)) {
      return (bgjw)this.mMiniAppContext.a().apkgInfo;
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
  
  public String handleNativeRequest(String paramString1, String paramString2, bghn parambghn, int paramInt)
  {
    if (this.mMiniAppContext == null) {
      return "";
    }
    return checkAuthorization(createRequestEvent(paramString1, paramString2, parambghn, paramInt));
  }
  
  public void initPermissionParser(Context paramContext)
  {
    LocalPermissionParser localLocalPermissionParser = new LocalPermissionParser(paramContext);
    paramContext = new RemotePermissionParser(paramContext);
    PermissionManager.g().startParse(new PermissionParser[] { localLocalPermissionParser, paramContext });
  }
  
  public void onCreate(bgho parambgho)
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onCreate");
    this.mMiniAppContext = parambgho;
    parambgho = this.mMiniAppContext.a();
    if (parambgho != null)
    {
      AuthFilterList.updateEventRemoteList(parambgho.blackList, parambgho.whiteList);
      AuthFilterList.updateEventSecondaryApiList(parambgho.secondApiRightInfoList);
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
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void requestAuthorize(bgkd parambgkd)
  {
    this.scopePermissionQueue.offer(parambgkd);
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", parambgkd.a);
      localBundle.putString("key_params", parambgkd.b);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */