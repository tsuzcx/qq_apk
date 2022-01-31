package com.tencent.mobileqq.webprocess;

import aktp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.widget.ListView;
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
  public static int a;
  public static long a;
  public static long b;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  private void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getRuntime().getApplication().getSharedPreferences(paramString, paramInt).edit();
    QLog.e("WebProcessReceiver", 1, "ACTION_CLEAR_CACHE!. so remove all key from SP: " + paramString);
    localEditor.clear().commit();
  }
  
  private void b(int paramInt)
  {
    try
    {
      PreloadService.a(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessReceiver", 2, "preloadData");
    }
    b(paramInt);
  }
  
  protected void a(Context paramContext)
  {
    try
    {
      WebView localWebView = new WebView(paramContext);
      if (localWebView.getX5WebViewExtension() == null)
      {
        WebSettings localWebSettings = localWebView.getSettings();
        if (localWebSettings != null)
        {
          String str2 = "";
          String str3 = MobileQQ.getMobileQQ().getProcessName();
          String str1 = str2;
          if (str3 != null)
          {
            int i = str3.lastIndexOf(':');
            str1 = str2;
            if (i > -1) {
              str1 = "_" + str3.substring(i);
            }
          }
          localWebSettings.setDatabasePath(paramContext.getDir("database" + str1, 0).getPath());
          localWebSettings.setAppCachePath(paramContext.getDir("appcache" + str1, 0).getPath());
        }
        localWebView.clearCache(true);
        localWebView.clearFormData();
        localWebView.clearSslPreferences();
        localWebView.clearHistory();
        localWebView.clearMatches();
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      for (;;)
      {
        localWebView.destroy();
        return;
        QbSdk.clearAllWebViewCache(paramContext, true);
      }
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
    int i = 1;
    int j = 0;
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (str != null) {
        break label22;
      }
    }
    for (;;)
    {
      return;
      label22:
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "action=" + str);
      }
      if ("com.tencent.mobileqq.webprocess.preload_web_process".equals(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession broadcast, start web process!");
        }
        jdField_a_of_type_Long = paramIntent.getLongExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
        b = System.currentTimeMillis();
        if (!WebIPCOperator.a().a()) {
          WebIPCOperator.a().a().doBindService(paramContext.getApplicationContext());
        }
        try
        {
          jdField_a_of_type_Int = paramIntent.getIntExtra("from", -1);
          if (QLog.isColorLevel()) {
            QLog.d("WebProcessReceiver", 2, "fromOfPreload is " + jdField_a_of_type_Int);
          }
          if (201 != jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("WebProcessReceiver", 2, "onReceive preloadData standard, fromType=" + jdField_a_of_type_Int);
            }
            a(jdField_a_of_type_Int);
            if (100 == jdField_a_of_type_Int)
            {
              if (QLog.isColorLevel()) {
                QLog.d("WebProcessReceiver", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_APOLLO == fromOfPreload");
              }
              ApolloWebDataHandler.a();
            }
            if (200 != jdField_a_of_type_Int) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("WebProcessReceiver", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY == fromOfPreload");
            }
            new VideoPluginInstall(paramContext);
            VideoAutoPlayController.a(paramContext);
            new ListView(paramContext);
          }
        }
        catch (Exception paramAppRuntime)
        {
          for (;;)
          {
            paramAppRuntime.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("WebProcessReceiver", 2, "onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY_HALF!");
            }
            WebCoreService.a();
            com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.n = true;
          }
        }
      }
    }
    if ("action_clear_cache".equals(str))
    {
      WebAccelerateHelper.getSonicEngine().cleanCache();
      a(paramContext);
      SwiftBrowserCookieMonster.d();
      paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      a("sp_sonic_white_list_config_" + paramAppRuntime, 4);
      a("local_html", 4);
      return;
    }
    if ("action_reset_tbs".equals(str))
    {
      QbSdk.reset(paramContext.getApplicationContext());
      return;
    }
    if ("action_download_tbs".equals(str))
    {
      paramIntent = WebAccelerateHelper.getInstance().getTBSDpcParam();
      if ((paramIntent == null) || (paramIntent.charAt(0) != '1')) {
        break label830;
      }
    }
    for (;;)
    {
      boolean bool = TbsDownloader.needDownload(paramContext, false);
      if ((i == 0) || (!bool) || (!(paramAppRuntime instanceof BrowserAppInterface))) {
        break;
      }
      ((BrowserAppInterface)paramAppRuntime).a(false);
      return;
      if ("action_preload_sonic_session".equals(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession sonic session");
        }
        paramAppRuntime = paramIntent.getParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data");
        if ((paramAppRuntime == null) || (paramAppRuntime.size() <= 0)) {
          break;
        }
        SonicPreloader.a(paramAppRuntime);
        return;
      }
      if ("action_delete_sonic_templateinfo".equals(str))
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
          if (paramIntent.size() <= 0) {
            break;
          }
          ThreadManager.post(new aktp(this, paramIntent), 5, null, true);
          return;
        }
        QLog.e("WebProcessReceiver", 1, "Receive action delete sonic template data error");
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
        bool = SwiftWebAccelerator.a().a;
        QLog.i("WebProcessReceiver", 1, "Receive action release tool process, isInRealWorld:" + bool);
        if (bool) {
          break;
        }
        System.exit(0);
        return;
      }
      if ("com.tencent.mobileqq.webprocess.launch_cmgame".equals(str))
      {
        QLog.i("WebProcessReceiver", 1, "Receive action launch_cmgame.");
        CmGameUtil.a((CmGameStartChecker.StartCheckParam)paramIntent.getSerializableExtra("extra_startcheckparam"));
        return;
      }
      if ((!"com.tencent.mobileqq.webprocess.cmgame_shortcut".equals(str)) || (paramContext == null)) {
        break;
      }
      QQToast.a(paramContext, paramContext.getResources().getString(2131438226), 0).a();
      return;
      label830:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */