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
  public static long a;
  public static long b;
  private IWebProcessReceiverInjector a;
  
  private void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.waitAppRuntime(null).getApplication().getSharedPreferences(paramString, paramInt).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTION_CLEAR_CACHE!. so remove all key from SP: ");
    localStringBuilder.append(paramString);
    QLog.e("WebProcessReceiver", 1, localStringBuilder.toString());
    localEditor.clear().commit();
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
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("action=");
        ((StringBuilder)localObject2).append(str);
        QLog.d("WebProcessReceiver", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUtilIWebProcessReceiverInjector == null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUtilIWebProcessReceiverInjector = WebProcessReceiverInjectUtil.a();
      }
      boolean bool1 = "com.tencent.mobileqq.webprocess.preload_web_process".equals(str);
      int i = 1;
      Object localObject1;
      if (bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession broadcast, start web process!");
        }
        jdField_a_of_type_Long = paramIntent.getLongExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
        b = System.currentTimeMillis();
        try
        {
          jdField_a_of_type_Int = paramIntent.getIntExtra("from", -1);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("fromOfPreload is ");
          ((StringBuilder)localObject1).append(jdField_a_of_type_Int);
          QLog.d("WebProcessReceiver", 2, ((StringBuilder)localObject1).toString());
        }
        if (204 == jdField_a_of_type_Int) {
          SwiftBrowserIdleTaskHelper.a().a(new SwiftBrowserIdleTaskHelper.PreloadIdleTask(1));
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewUtilIWebProcessReceiverInjector;
        if (localObject1 != null) {
          ((IWebProcessReceiverInjector)localObject1).a(paramAppRuntime, paramContext, paramIntent, jdField_a_of_type_Int);
        }
      }
      else if ("action_clear_cache".equals(localObject1))
      {
        localObject1 = WebAccelerateHelper.getSonicEngine();
        if (localObject1 != null) {
          ((SonicEngine)localObject1).cleanCache();
        }
        a(paramContext);
        SwiftBrowserCookieMonster.d();
        localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sp_sonic_white_list_config_");
        ((StringBuilder)localObject2).append((String)localObject1);
        a(((StringBuilder)localObject2).toString(), 4);
        a("local_html", 4);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewUtilIWebProcessReceiverInjector;
        if (localObject1 != null) {
          ((IWebProcessReceiverInjector)localObject1).a(paramAppRuntime, paramContext, paramIntent);
        }
      }
      else
      {
        if ("action_reset_tbs".equals(localObject1))
        {
          QbSdk.reset(paramContext.getApplicationContext());
          return;
        }
        bool1 = "action_download_tbs".equals(localObject1);
        int j = 0;
        if (bool1)
        {
          paramContext = WebAccelerateHelper.getInstance().getTBSDpcParam();
          if ((paramContext == null) || (paramContext.charAt(0) != '1')) {
            i = 0;
          }
          bool1 = paramIntent.getBooleanExtra("isDownloadForeground", false);
          boolean bool2 = paramIntent.getBooleanExtra("fromMiniApp", false);
          if (i != 0) {
            ThreadManagerV2.executeOnSubThread(new WebProcessReceiver.1(this, bool1, paramAppRuntime, bool2));
          }
        }
        else if ("action_preload_sonic_session".equals(localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession sonic session");
          }
          paramAppRuntime = paramIntent.getParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data");
          if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0)) {
            ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).preload(paramAppRuntime);
          }
        }
        else if ("action_delete_sonic_templateinfo".equals(localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebProcessReceiver", 2, "Receive action delete sonic template");
          }
          paramAppRuntime = paramIntent.getStringArrayExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_sessionId");
          paramContext = paramIntent.getLongArrayExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_updateTime");
          if ((paramAppRuntime != null) && (paramAppRuntime.length > 0) && (paramContext != null) && (paramContext.length > 0) && (paramAppRuntime.length == paramContext.length))
          {
            paramIntent = new HashMap();
            i = j;
            while (i < paramAppRuntime.length)
            {
              paramIntent.put(paramAppRuntime[i], Long.valueOf(paramContext[i]));
              i += 1;
            }
            if (paramIntent.size() > 0) {
              ThreadManager.post(new WebProcessReceiver.2(this, paramIntent), 5, null, true);
            }
          }
          else
          {
            QLog.e("WebProcessReceiver", 1, "Receive action delete sonic template data error");
          }
        }
        else
        {
          if ("com.tencent.mobileqq.webprocess.stop_web_core_service".equals(localObject1))
          {
            QLog.i("WebProcessReceiver", 1, "Receive action stop web core service");
            WebCoreService.b();
            return;
          }
          if ("com.tencent.mobileqq.webprocess.release_tool_process".equals(localObject1))
          {
            if (WebCoreService.a) {
              WebCoreService.b();
            }
            bool1 = SwiftWebAccelerator.a().a;
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("Receive action release tool process, isInRealWorld:");
            paramAppRuntime.append(bool1);
            QLog.i("WebProcessReceiver", 1, paramAppRuntime.toString());
            if (!bool1) {
              System.exit(0);
            }
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewUtilIWebProcessReceiverInjector;
            if (localObject2 != null) {
              ((IWebProcessReceiverInjector)localObject2).a(paramAppRuntime, paramContext, paramIntent, (String)localObject1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */