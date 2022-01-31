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
import bdcy;
import bdcz;
import bddd;
import bdde;
import bddj;
import bddk;
import bddm;
import bddr;
import bdds;
import bdel;
import bdfv;
import bdfx;
import bdfz;
import bdga;
import bdgg;
import bdhe;
import bdid;
import bdnw;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
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
  bdid authDialog;
  private DialogInterface.OnDismissListener dismissListener = new BaseJsPluginEngine.8(this);
  private Handler mHandler = new Handler(Looper.getMainLooper(), new BaseJsPluginEngine.7(this));
  protected bdcz mMiniAppContext;
  ConcurrentLinkedQueue<bdfz> scopePermissionQueue = new ConcurrentLinkedQueue();
  
  public BaseJsPluginEngine(Context paramContext)
  {
    initPermissionParser(paramContext);
  }
  
  private String checkRequestScopePermission(bdfz parambdfz)
  {
    String str1 = parambdfz.a;
    String str2 = parambdfz.b;
    if ("subscribeAppMsg".equals(str1)) {
      return reqGrantSubscribeApiPermission(parambdfz);
    }
    Object localObject = bddk.a().a("scope.getPhoneNumber");
    if (localObject != null) {}
    for (localObject = ((bddj)localObject).c; ("getPhoneNumber".equals(str1)) && (TextUtils.isEmpty((CharSequence)localObject)); localObject = "")
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPhoneNumber(getAppId(), new BaseJsPluginEngine.3(this, parambdfz));
      return "";
    }
    if (bddd.a(getAppId())) {}
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
      bdnw.a("JsPluginEngine[AuthGuard]", "checkRequestScopePermission granted=" + bool1 + ",eventName=" + str1);
      if (bool1)
      {
        if ("authorize".equals(parambdfz.a)) {
          return handleAuthorizeEvent(parambdfz);
        }
        return dispatchRequestEvent(parambdfz);
      }
      showRequestPermissionDialog(parambdfz, (String)localObject);
      return "";
    }
  }
  
  private bdfz createRequestEvent(String paramString1, String paramString2, bdcy parambdcy, int paramInt)
  {
    return new bdga().a(paramString1).b(paramString2).a(parambdcy).a(paramInt).a();
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
      return bddk.a().c(paramString1);
      paramString1 = paramString1 + "." + paramString2;
    }
  }
  
  private static String getRequestSystemPermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      paramString1 = extractScopeNameInJsonParams(paramString2);
      paramString1 = bddk.a().b(paramString1);
      return bddk.a().a(paramString1);
    }
    return bddk.a().a(paramString1);
  }
  
  private String handleAuthorizeEvent(bdfz parambdfz)
  {
    String str1 = getAppId();
    bdde localbdde = MiniAppEnv.g().getAuthSate(str1);
    String str2 = extractScopeNameInJsonParams(parambdfz.b);
    boolean bool;
    if ((localbdde != null) && (isScopePermissionValid(str2)))
    {
      bool = localbdde.a();
      if ((str2.startsWith("setting")) && (!bool)) {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(str1, new BaseJsPluginEngine.2(this, localbdde, str2, str1, parambdfz));
      }
    }
    for (;;)
    {
      return "";
      bool = localbdde.a(str2);
      if (bddd.a(str1)) {
        bool = true;
      }
      if (bool) {
        parambdfz.a();
      } else {
        sendShowAuthDialogMessage(parambdfz, str2);
      }
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
    return MiniAppEnv.g().getAuthSate(str).a(paramString);
  }
  
  private static boolean isScopePermissionValid(String paramString)
  {
    return bddk.a().a(paramString);
  }
  
  private void notifyScopePermissionQueue(Message paramMessage)
  {
    Iterator localIterator = this.scopePermissionQueue.iterator();
    if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
    {
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        if (paramMessage.equals("scope.camera")) {
          this.mMiniAppContext.a(bdfv.a("onCameraNeedAuthCancel", null, 0));
        }
        while (localIterator.hasNext())
        {
          bdfz localbdfz = (bdfz)localIterator.next();
          if (paramMessage.equals(getRequestScopePermission(localbdfz.a, localbdfz.b)))
          {
            localIterator.remove();
            localbdfz.a("auth deny");
          }
        }
      }
    }
    paramMessage = (bdfz)this.scopePermissionQueue.peek();
    if (paramMessage != null)
    {
      this.scopePermissionQueue.remove(paramMessage);
      dispatchRequestEvent(paramMessage);
    }
  }
  
  private void removeAllMessage()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
  }
  
  private String reqGrantSubscribeApiPermission(bdfz parambdfz)
  {
    return "";
  }
  
  private void sendShowAuthDialogMessage(bdfz parambdfz, String paramString)
  {
    this.scopePermissionQueue.offer(parambdfz);
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", parambdfz.a);
      localBundle.putString("key_params", parambdfz.b);
      localBundle.putString("key_scope_name", paramString);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  private void setScopePermissionAuthState(String paramString, boolean paramBoolean)
  {
    String str = getAppId();
    MiniAppEnv.g().getAuthSate(str).a(paramString, paramBoolean);
  }
  
  private boolean shouldAskEveryTime(String paramString)
  {
    String str = getAppId();
    return MiniAppEnv.g().getAuthSate(str).b(paramString);
  }
  
  private void showAuthDialog(Bundle paramBundle)
  {
    if (this.authDialog == null)
    {
      this.authDialog = new bdid(this.mMiniAppContext.a());
      this.authDialog.setOnDismissListener(this.dismissListener);
    }
    this.authDialog.a(paramBundle);
    paramBundle = paramBundle.getString("key_scope_name", "");
    Object localObject;
    if (paramBundle != null)
    {
      localObject = bddk.a().a(paramBundle);
      if (localObject != null) {
        break label99;
      }
      bdnw.d("JsPluginEngine[AuthGuard]", "Can NOT find scope permission: " + paramBundle);
    }
    label99:
    String str1;
    String str2;
    Context localContext;
    MiniAppProxy localMiniAppProxy;
    String str3;
    String str4;
    do
    {
      bdfx localbdfx;
      ChannelProxy localChannelProxy;
      do
      {
        return;
        str1 = ((bddj)localObject).b;
        str2 = ((bddj)localObject).c;
        localObject = ((bddj)localObject).d;
        localContext = this.mMiniAppContext.a();
        localbdfx = getApkgInfo();
        localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      } while (localbdfx == null);
      str3 = localbdfx.e;
      str4 = localbdfx.c;
      if ("scope.userInfo".equals(paramBundle))
      {
        localChannelProxy.getUserInfo(localbdfx.d, false, "en", new BaseJsPluginEngine.4(this, localMiniAppProxy, localContext, str3, str4, str1, str2));
        return;
      }
    } while (this.authDialog == null);
    this.authDialog.a(localMiniAppProxy.getDrawable(localContext, str3, 0, 0, null), str4, str1, null, null, str2, (String)localObject, new BaseJsPluginEngine.5(this), "允许", new BaseJsPluginEngine.6(this));
  }
  
  private void showRequestPermissionDialog(bdfz parambdfz, String paramString)
  {
    Object localObject = parambdfz.a;
    String str = parambdfz.b;
    boolean bool1;
    if (!isOpenDataEvent((String)localObject, str))
    {
      bool1 = isScopePermissionGranted(paramString);
      bdnw.a("JsPluginEngine[AuthGuard]", "handleNativeRequest hasRefused=" + bool1);
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
        bdnw.d("JsPluginEngine[AuthGuard]", Log.getStackTraceString(localThrowable));
        boolean bool2 = bool1;
        continue;
        bdnw.a("JsPluginEngine[AuthGuard]", "handleNativeRequest callbackJsEventFail");
        parambdfz.a("auth deny");
        this.mHandler.obtainMessage(1).sendToTarget();
      }
      if (!bool2) {
        continue;
      }
      sendShowAuthDialogMessage(parambdfz, paramString);
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
  
  public String checkAuthorization(bdfz parambdfz)
  {
    String str1 = parambdfz.a;
    String str2 = parambdfz.b;
    Object localObject;
    if (bddd.b(str1)) {
      localObject = extractApiNameInJsonParams(str2);
    }
    while (!bddd.a(str1, (String)localObject))
    {
      bdnw.d("JsPluginEngine[AuthGuard]", "eventname : " + str1 + "; apiName : " + (String)localObject + " request failed.");
      if (str1.endsWith("Sync"))
      {
        return bdgg.a(str1, null, "no permission").toString();
        localObject = "";
      }
      else
      {
        parambdfz.a("no permission");
        return "";
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.mMiniAppContext.a();
      String str3;
      if (localObject != null)
      {
        str3 = getRequestSystemPermission(str1, str2);
        if (bdhe.a(str3)) {
          break label223;
        }
        if (((Activity)localObject).checkSelfPermission(str3) != 0) {
          break label212;
        }
      }
      label212:
      for (int i = 1; i == 0; i = 0)
      {
        bdel.a().a(new BaseJsPluginEngine.1(this, str3, str1, str2, parambdfz));
        ((Activity)localObject).requestPermissions(new String[] { str3 }, 9527);
        return "";
      }
      return checkRequestScopePermission(parambdfz);
      label223:
      return checkRequestScopePermission(parambdfz);
    }
    return checkRequestScopePermission(parambdfz);
  }
  
  abstract String dispatchRequestEvent(bdfz parambdfz);
  
  protected bdfx getApkgInfo()
  {
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null)) {
      return (bdfx)this.mMiniAppContext.a().apkgInfo;
    }
    return null;
  }
  
  protected String getAppId()
  {
    if (getApkgInfo() != null) {
      return getApkgInfo().d;
    }
    return null;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, bdcy parambdcy, int paramInt)
  {
    if (this.mMiniAppContext == null) {
      return "";
    }
    return checkAuthorization(createRequestEvent(paramString1, paramString2, parambdcy, paramInt));
  }
  
  public void initPermissionParser(Context paramContext)
  {
    bddr localbddr = new bddr(paramContext);
    paramContext = new bdds(paramContext);
    bddk.a().a(new bddm[] { localbddr, paramContext });
  }
  
  public void onCreate(bdcz parambdcz)
  {
    this.mMiniAppContext = parambdcz;
    parambdcz = this.mMiniAppContext.a();
    if (parambdcz != null)
    {
      bddd.a(parambdcz.blackList, parambdcz.whiteList);
      bddd.a(parambdcz.secondApiRightInfoList);
    }
  }
  
  public void onDestroy()
  {
    bddd.a();
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
    removeAllMessage();
  }
  
  public void onResume()
  {
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void requestAuthorize(bdfz parambdfz)
  {
    this.scopePermissionQueue.offer(parambdfz);
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", parambdfz.a);
      localBundle.putString("key_params", parambdfz.b);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */