package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.WebProcessReceiverInjectUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.PreloadIdleTask;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.util.IWebProcessReceiverInjector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;

public class WebProcessReceiver
  extends QQBroadcastReceiver
{
  public static int a = -1;
  public static long b;
  public static long c;
  private IWebProcessReceiverInjector d;
  
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessReceiver", 2, "Receive action delete sonic template");
    }
    String[] arrayOfString = paramIntent.getStringArrayExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_sessionId");
    paramIntent = paramIntent.getLongArrayExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_updateTime");
    if ((arrayOfString != null) && (arrayOfString.length > 0) && (paramIntent != null) && (paramIntent.length > 0) && (arrayOfString.length == paramIntent.length))
    {
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < arrayOfString.length)
      {
        localHashMap.put(arrayOfString[i], Long.valueOf(paramIntent[i]));
        i += 1;
      }
      if (localHashMap.size() > 0) {
        ThreadManager.post(new WebProcessReceiver.1(this, localHashMap), 5, null, true);
      }
    }
    else
    {
      QLog.e("WebProcessReceiver", 1, "Receive action delete sonic template data error");
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.waitAppRuntime(null).getApplication().getSharedPreferences(paramString, paramInt).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTION_CLEAR_CACHE!. so remove all key from SP: ");
    localStringBuilder.append(paramString);
    QLog.e("WebProcessReceiver", 1, localStringBuilder.toString());
    localEditor.clear().commit();
  }
  
  private void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    Object localObject = WebAccelerateHelper.getSonicEngine();
    if (localObject != null) {
      ((SonicEngine)localObject).cleanCache();
    }
    a(paramContext);
    SwiftBrowserCookieMonster.d();
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_sonic_white_list_config_");
    localStringBuilder.append((String)localObject);
    a(localStringBuilder.toString(), 4);
    a("local_html", 4);
    localObject = this.d;
    if (localObject != null) {
      ((IWebProcessReceiverInjector)localObject).a(paramAppRuntime, paramContext, paramIntent);
    }
  }
  
  private void a(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
    int i;
    if ((str != null) && (str.charAt(0) == '1')) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = paramIntent.getBooleanExtra("isDownloadForeground", false);
    boolean bool2 = paramIntent.getBooleanExtra("fromMiniApp", false);
    if (i != 0) {
      ThreadManagerV2.executeOnSubThread(new WebProcessReceiver.2(this, bool1, paramAppRuntime, bool2));
    }
  }
  
  private void b(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession broadcast, start web process!");
    }
    b = paramIntent.getLongExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    c = System.currentTimeMillis();
    try
    {
      a = paramIntent.getIntExtra("from", -1);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fromOfPreload is ");
      ((StringBuilder)localObject).append(a);
      QLog.d("WebProcessReceiver", 2, ((StringBuilder)localObject).toString());
    }
    if (204 == a) {
      SwiftBrowserIdleTaskHelper.a().a(new SwiftBrowserIdleTaskHelper.PreloadIdleTask(1));
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((IWebProcessReceiverInjector)localObject).a(paramAppRuntime, paramContext, paramIntent, a);
    }
  }
  
  protected void a(Context paramContext)
  {
    try
    {
      DtX5WebView localDtX5WebView = new DtX5WebView(paramContext);
      if (localDtX5WebView.getX5WebViewExtension() == null)
      {
        WebSettings localWebSettings = localDtX5WebView.getSettings();
        if (localWebSettings != null)
        {
          Object localObject2 = "";
          String str = MobileQQ.getMobileQQ().getQQProcessName();
          Object localObject1 = localObject2;
          if (str != null)
          {
            int i = str.lastIndexOf(':');
            localObject1 = localObject2;
            if (i > -1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("_");
              ((StringBuilder)localObject1).append(str.substring(i));
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("database");
          ((StringBuilder)localObject2).append((String)localObject1);
          localWebSettings.setDatabasePath(paramContext.getDir(((StringBuilder)localObject2).toString(), 0).getPath());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("appcache");
          ((StringBuilder)localObject2).append((String)localObject1);
          localWebSettings.setAppCachePath(paramContext.getDir(((StringBuilder)localObject2).toString(), 0).getPath());
        }
        localDtX5WebView.clearCache(true);
        localDtX5WebView.clearFormData();
        localDtX5WebView.clearSslPreferences();
        localDtX5WebView.clearHistory();
        localDtX5WebView.clearMatches();
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      else
      {
        QbSdk.clearAllWebViewCache(paramContext, true);
      }
      localDtX5WebView.destroy();
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "clear webview cache got exception:", paramContext);
      }
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      if (str == null) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("action=");
        ((StringBuilder)localObject).append(str);
        QLog.d("WebProcessReceiver", 2, ((StringBuilder)localObject).toString());
      }
      if (this.d == null) {
        this.d = WebProcessReceiverInjectUtil.a();
      }
      if ("com.tencent.mobileqq.webprocess.preload_web_process".equals(str))
      {
        b(paramAppRuntime, paramContext, paramIntent);
        return;
      }
      if ("action_clear_cache".equals(str))
      {
        a(paramAppRuntime, paramContext, paramIntent);
        return;
      }
      if ("action_reset_tbs".equals(str))
      {
        QbSdk.reset(paramContext.getApplicationContext());
        return;
      }
      if ("action_download_tbs".equals(str))
      {
        a(paramAppRuntime, paramIntent);
        return;
      }
      if ("action_preload_sonic_session".equals(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession sonic session");
        }
        paramAppRuntime = paramIntent.getParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data");
        if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0)) {
          ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).preload(paramAppRuntime);
        }
      }
      else
      {
        if ("action_delete_sonic_templateinfo".equals(str))
        {
          a(paramIntent);
          return;
        }
        if ("com.tencent.mobileqq.webprocess.stop_web_core_service".equals(str))
        {
          QLog.i("WebProcessReceiver", 1, "Receive action stop web core service");
          WebCoreService.b();
          return;
        }
        if ("com.tencent.mobileqq.webprocess.release_tool_process".equals(str))
        {
          if (WebCoreService.a) {
            WebCoreService.b();
          }
          boolean bool = SwiftWebAccelerator.a().b;
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("Receive action release tool process, isInRealWorld:");
          paramAppRuntime.append(bool);
          QLog.i("WebProcessReceiver", 1, paramAppRuntime.toString());
          if (!bool) {
            System.exit(0);
          }
        }
        else
        {
          localObject = this.d;
          if (localObject != null) {
            ((IWebProcessReceiverInjector)localObject).a(paramAppRuntime, paramContext, paramIntent, str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */