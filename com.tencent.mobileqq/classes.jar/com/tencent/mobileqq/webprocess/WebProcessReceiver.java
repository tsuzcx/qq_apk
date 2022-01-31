package com.tencent.mobileqq.webprocess;

import akqa;
import akwd;
import algd;
import alko;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.SystemClock;
import aprh;
import atfm;
import atfx;
import azri;
import beec;
import bejq;
import beju;
import bejx;
import belc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;
import qzy;
import rjp;

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
      beec.a(paramInt);
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
          String str3 = MobileQQ.getMobileQQ().getQQProcessName();
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
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getAction();
      if (localObject != null) {
        break label16;
      }
    }
    label16:
    label753:
    do
    {
      boolean bool1;
      do
      {
        do
        {
          do
          {
            boolean bool2;
            do
            {
              for (;;)
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("WebProcessReceiver", 2, "action=" + (String)localObject);
                }
                if ("com.tencent.mobileqq.webprocess.preload_web_process".equals(localObject))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession broadcast, start web process!");
                  }
                  jdField_a_of_type_Long = paramIntent.getLongExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
                  b = System.currentTimeMillis();
                  if (!aprh.a().a()) {
                    aprh.a().a().doBindService(paramContext.getApplicationContext());
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
                        algd.a();
                        if (!alko.a()) {
                          alko.a("WebProcessReceiver");
                        }
                        akqa.a().a();
                      }
                      ThreadManager.executeOnSubThread(new WebProcessReceiver.1(this));
                      if (200 == jdField_a_of_type_Int)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("WebProcessReceiver", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY == fromOfPreload");
                        }
                        new rjp(paramContext);
                        qzy.a();
                        new ListView(paramContext);
                      }
                      if (204 != jdField_a_of_type_Int) {
                        continue;
                      }
                      bejq.a().a(new beju(1));
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
                      beiy.r = true;
                    }
                  }
                }
              }
              if ("action_clear_cache".equals(localObject))
              {
                paramAppRuntime = WebAccelerateHelper.getSonicEngine();
                if (paramAppRuntime != null) {
                  paramAppRuntime.cleanCache();
                }
                a(paramContext);
                SwiftBrowserCookieMonster.d();
                paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                a("sp_sonic_white_list_config_" + paramAppRuntime, 4);
                a("local_html", 4);
                WebSoService.a().a();
                belc.a();
                return;
              }
              if ("action_reset_tbs".equals(localObject))
              {
                QbSdk.reset(paramContext.getApplicationContext());
                return;
              }
              if (!"action_download_tbs".equals(localObject)) {
                break;
              }
              paramContext = WebAccelerateHelper.getInstance().getTBSDpcParam();
              int j = 0;
              i = j;
              if (paramContext != null)
              {
                i = j;
                if (paramContext.charAt(0) == '1') {
                  i = 1;
                }
              }
              bool1 = paramIntent.getBooleanExtra("isDownloadForeground", false);
              bool2 = paramIntent.getBooleanExtra("fromMiniApp", false);
            } while (i == 0);
            ThreadManagerV2.executeOnSubThread(new WebProcessReceiver.2(this, bool1, paramAppRuntime, bool2));
            return;
            if (!"action_preload_sonic_session".equals(localObject)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("WebProcessReceiver", 2, "Receive preloadSonicSession sonic session");
            }
            paramAppRuntime = paramIntent.getParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data");
          } while ((paramAppRuntime == null) || (paramAppRuntime.size() <= 0));
          SonicPreloader.preload(paramAppRuntime);
          return;
          if (!"action_delete_sonic_templateinfo".equals(localObject)) {
            break label753;
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebProcessReceiver", 2, "Receive action delete sonic template");
          }
          paramAppRuntime = paramIntent.getStringArrayExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_sessionId");
          paramContext = paramIntent.getLongArrayExtra("com.tencent.mobileqq.webprocess.sonic_template_delete_updateTime");
          if ((paramAppRuntime == null) || (paramAppRuntime.length <= 0) || (paramContext == null) || (paramContext.length <= 0) || (paramAppRuntime.length != paramContext.length)) {
            break;
          }
          paramIntent = new HashMap();
          int i = 0;
          while (i < paramAppRuntime.length)
          {
            paramIntent.put(paramAppRuntime[i], Long.valueOf(paramContext[i]));
            i += 1;
          }
        } while (paramIntent.size() <= 0);
        ThreadManager.post(new WebProcessReceiver.3(this, paramIntent), 5, null, true);
        return;
        QLog.e("WebProcessReceiver", 1, "Receive action delete sonic template data error");
        return;
        if ("com.tencent.mobileqq.webprocess.stop_web_core_service".equals(localObject))
        {
          QLog.i("WebProcessReceiver", 1, "Receive action stop web core service");
          WebCoreService.b();
          return;
        }
        if (!"com.tencent.mobileqq.webprocess.release_tool_process".equals(localObject)) {
          break;
        }
        if (WebCoreService.a) {
          WebCoreService.b();
        }
        bool1 = bejx.a().a;
        QLog.i("WebProcessReceiver", 1, "Receive action release tool process, isInRealWorld:" + bool1);
      } while (bool1);
      System.exit(0);
      return;
      if (!"com.tencent.mobileqq.webprocess.launch_cmgame".equals(localObject)) {
        break label1384;
      }
      QLog.i("WebProcessReceiver", 1, "Receive action launch_cmgame.");
      if (!paramIntent.getBooleanExtra("action_apollo_cmshow_content_update", false)) {
        break;
      }
      paramAppRuntime = paramIntent.getStringExtra("key_content_update_zip_name");
      QLog.i("WebProcessReceiver", 1, "rscContent_CmShowRscCacheManager onReceive zipName:" + paramAppRuntime);
    } while (!"all_room3D".equals(paramAppRuntime));
    akqa.a().a();
    return;
    paramIntent = (CmGameStartChecker.StartCheckParam)paramIntent.getSerializableExtra("extra_startcheckparam");
    long l2;
    long l3;
    if ((paramIntent != null) && (paramIntent.statMap != null) && (paramIntent.statMap.containsKey("click_time")))
    {
      l2 = ((Long)paramIntent.statMap.get("click_time")).longValue();
      if (l2 > 0L)
      {
        l3 = SystemClock.uptimeMillis();
        if (!paramIntent.statMap.containsKey("game_process_on")) {
          break label1531;
        }
      }
    }
    label1358:
    label1379:
    label1384:
    label1531:
    for (long l1 = ((Long)paramIntent.statMap.get("game_process_on")).longValue();; l1 = 0L)
    {
      for (;;)
      {
        long l4 = l3 - l2;
        if (l4 > 0L)
        {
          paramContext = "cmgame_click_to_receive";
          paramIntent.statMap.put("game_process_receive_time", Long.valueOf(l3));
          if (l4 >= 20000L)
          {
            paramContext = "cmgame_click_to_receive_exception";
            paramIntent.statMap.clear();
          }
          localObject = new HashMap();
          ((HashMap)localObject).put("param_gameId", String.valueOf(paramIntent.gameId));
          ((HashMap)localObject).put("param_processOn", String.valueOf(l1));
          ((HashMap)localObject).put("param_src", String.valueOf(paramIntent.src));
          azri.a(paramAppRuntime.getApplication()).a(paramAppRuntime.getAccount(), paramContext, true, l4, 0L, (HashMap)localObject, "", false);
          QLog.d("CmGameStat", 1, new Object[] { paramContext, ", duration=", Long.valueOf(l4), ", receiveTime=", Long.valueOf(l3), ", clickTime=", Long.valueOf(l2), " [processOn=", Long.valueOf(l1), ", gameId=", Integer.valueOf(paramIntent.gameId), ", src=", Integer.valueOf(paramIntent.src), "]" });
        }
        while (paramIntent != null)
        {
          if (!paramIntent.mLoadingOnMainProcess) {
            break label1379;
          }
          if (ApolloGameUtil.a(paramIntent)) {
            break label1358;
          }
          akwd.a(paramIntent);
          return;
          paramIntent.statMap.clear();
          QLog.d("CmGameStat", 1, new Object[] { "receive, duration invalid, duration=", Long.valueOf(l4), ", receiveTime=", Long.valueOf(l3), ", clickTime=", Long.valueOf(l2) });
        }
        break;
        QLog.e("WebProcessReceiver", 1, new Object[] { "launch game but cancel params", paramIntent });
        return;
        akwd.a(paramIntent);
        return;
        if ("com.tencent.mobileqq.webprocess.cmgame_shortcut".equals(localObject))
        {
          if (paramContext == null) {
            break;
          }
          QQToast.a(paramContext, paramContext.getResources().getString(2131690151), 0).a();
          return;
        }
        if (("action_pre_download_plato".equals(localObject)) || (!"action_show_together_floating_windows".equals(localObject))) {
          break;
        }
        try
        {
          QIPCClientHelper.getInstance().register(atfx.a());
          paramAppRuntime = (WatchTogetherFloatingData)paramIntent.getSerializableExtra("com.tencent.mobileqq.webprocess.together.floating.data");
          if ((paramAppRuntime != null) && (atfm.b()))
          {
            atfm.a(BaseApplicationImpl.context, paramAppRuntime);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("WebProcessReceiver", 1, "handle ACTION_SHOW_TOGETHER_CONTROL_FLOATING_WINDOWS, data!=null");
            return;
          }
        }
        catch (Exception paramAppRuntime)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("WebProcessReceiver", 1, "register WatchTogetherClientIPCModule ipc module error.", paramAppRuntime);
            }
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebProcessReceiver", 1, "handle ACTION_SHOW_TOGETHER_CONTROL_FLOATING_WINDOWS, data!=null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */