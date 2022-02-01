package com.tencent.qqmini.sdk.server;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.manager.EngineManager;
import com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

public class MiniAppCmdServlet
{
  private static final String TAG = "MiniAppCmdServlet";
  private static MiniAppCmdServlet instance;
  private static byte[] lock = new byte[0];
  
  public static MiniAppCmdServlet g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new MiniAppCmdServlet();
        }
      }
    }
    return instance;
  }
  
  private void launchReport(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
      paramString = (MiniAppInfo)paramBundle.getParcelable("app_config");
      paramMiniCmdCallback = paramBundle.getString("sub_action");
      String str1 = paramBundle.getString("path");
      String str2 = paramBundle.getString("reserves");
      String str3 = paramBundle.getString("reserves2");
      SDKMiniProgramLpReportDC04239.report(paramString, paramBundle.getString("app_type"), str1, paramBundle.getString("action_type"), paramMiniCmdCallback, str2, str3, null, null, null, null);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void launchReport2(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(MiniAppReportManager2.class.getClassLoader());
      paramString = (MiniAppInfo)paramBundle.getParcelable("app_config");
      paramMiniCmdCallback = paramBundle.getString("sub_action");
      String str = paramBundle.getString("path");
      MiniAppReportManager2.reportPageView(paramMiniCmdCallback, paramBundle.getString("reserves"), str, paramString);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onMiniAppCmd cmd = ");
    paramBundle.append(paramString);
    paramBundle.append(", bundle is null");
    QMLog.e("MiniAppCmdServlet", paramBundle.toString());
  }
  
  private void notifyEventInfo(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (paramBundle != null)
    {
      paramString = paramBundle.getString("key_appid", "");
      int i = paramBundle.getInt("key_scene", 9999);
      paramMiniCmdCallback = paramBundle.getString("key_via", "");
      String str = paramBundle.getString("key_event", "");
      long l = paramBundle.getLong("key_timestamp", 0L);
      ((IMiniAppNotifyProxy)ProxyManager.get(IMiniAppNotifyProxy.class)).report(paramString, i, paramMiniCmdCallback, str, l);
    }
  }
  
  private void onUpdateV8rt(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    paramString = WnsConfig.getConfig("qqminiapp", "mini_app_v8_rt_url", "{ \"url\":\"https://down.qq.com/miniapp/libtv8rt_202008101130.so\",\"size\":535136, \"url64\":\"https://d3g.qq.com/sngapp/app/update/20210601154157_4983/VD1Vg6kzck5I0UmQ6W6dPA==_libtv8rt.so\",\"size64\":1733496}");
    paramBundle = new StringBuilder();
    paramBundle.append("urlJson:");
    paramBundle.append(paramString);
    QMLog.i("MiniAppCmdServlet", paramBundle.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramString);
        if (QUAUtil.isAbi64())
        {
          paramString = "url64";
          String str = paramBundle.getString(paramString);
          if (!QUAUtil.isAbi64()) {
            break label205;
          }
          paramString = "size64";
          int i = paramBundle.getInt(paramString);
          if ((!TextUtils.isEmpty(str)) && (i != 0))
          {
            paramString = MiniSDKConst.getMiniAppV8rtPath();
            ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str, null, paramString, 60, new MiniAppCmdServlet.2(this, paramMiniCmdCallback));
            return;
          }
          paramString = new StringBuilder();
          paramString.append("url is");
          paramString.append(str);
          paramString.append("  size:");
          paramString.append(i);
          QMLog.e("MiniAppCmdServlet", paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        QMLog.e("MiniAppCmdServlet", "parse v8rt_url failed", paramString);
        return;
      }
      paramString = "url";
      continue;
      label205:
      paramString = "size";
    }
  }
  
  private void preloadGameBaseLib(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (paramBundle != null)
    {
      paramString = paramBundle.getString("bundle_key_process_name", null);
      paramBundle = paramBundle.getString("bundle_key_preload_game_baselib_version", null);
      MiniServer.g().getLaunchManagerService().onPreloadBaseLib(paramString, paramBundle);
    }
  }
  
  private void rebindEngineChannel(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    int i = -1;
    if (paramBundle != null) {
      i = paramBundle.getInt("bundle_key_app_type", -1);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:");
    paramBundle.append(i);
    QMLog.i("MiniAppCmdServlet", paramBundle.toString());
    if ((i == 0) || (i == 1))
    {
      paramBundle = new Bundle();
      EngineManager localEngineManager = EngineManager.g();
      if (i == 1) {
        i = 2;
      } else {
        i = 3;
      }
      paramBundle.putParcelable("engineChannel", localEngineManager.getChannelForType(i));
      if (paramMiniCmdCallback != null) {
        try
        {
          paramMiniCmdCallback.onCmdResult(true, paramBundle);
          return;
        }
        catch (RemoteException paramBundle)
        {
          paramMiniCmdCallback = new StringBuilder();
          paramMiniCmdCallback.append("cmd response exception. cmd=");
          paramMiniCmdCallback.append(paramString);
          QMLog.e("MiniAppCmdServlet", paramMiniCmdCallback.toString(), paramBundle);
        }
      }
    }
  }
  
  private void rebindEngineChannelNew(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    int i = -1;
    if (paramBundle != null) {
      i = paramBundle.getInt("bundle_key_app_type", -1);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:");
    paramBundle.append(i);
    QMLog.i("MiniAppCmdServlet", paramBundle.toString());
    if ((i == 0) || (i == 1))
    {
      paramBundle = new Bundle();
      EngineManager localEngineManager = EngineManager.g();
      if (i == 1) {
        i = 2;
      } else {
        i = 3;
      }
      paramBundle.putParcelable("engineChannel", localEngineManager.getChannelForType(i));
      if (paramMiniCmdCallback != null) {
        try
        {
          paramMiniCmdCallback.onCmdResult(true, paramBundle);
          return;
        }
        catch (RemoteException paramBundle)
        {
          paramMiniCmdCallback = new StringBuilder();
          paramMiniCmdCallback.append("cmd response exception. cmd=");
          paramMiniCmdCallback.append(paramString);
          QMLog.e("MiniAppCmdServlet", paramMiniCmdCallback.toString(), paramBundle);
        }
      }
    }
  }
  
  private void recordDuration(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
      SDKMiniProgramLpReportDC04239.recordDuration((MiniAppInfo)paramBundle.getParcelable("app_config"), paramBundle.getLong("add_duration_ms"));
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void updateAppForMiniGame(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    paramString = new StringBuilder();
    paramString.append("handleUpdateAppForMiniGame() called with: bundle = [");
    paramString.append(paramBundle);
    paramString.append("]");
    QMLog.d("MiniAppCmdServlet", paramString.toString());
    if (paramBundle == null) {
      return;
    }
    paramString = (MiniAppInfo)paramBundle.getParcelable("key_app_info");
    if ((paramString != null) && (AppLoaderFactory.g().getContext() != null) && ((AppLoaderFactory.g().getContext() instanceof Activity)))
    {
      MiniServer.g().getLaunchManagerService().stopMiniApp(paramString);
      MiniServer.g().getLaunchManagerService().startMiniApp((Activity)AppLoaderFactory.g().getContext(), paramString, null, null);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("handleUpdateAppForMiniGame miniAppInfo = ");
    paramBundle.append(paramString);
    paramBundle.append(" activity = ");
    paramBundle.append(AppLoaderFactory.g().getContext());
    QMLog.e("MiniAppCmdServlet", paramBundle.toString());
  }
  
  private void updateBaseLib(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    BaseLibManager.g().forceUpdateBaseLib(new MiniAppCmdServlet.1(this, paramMiniCmdCallback, paramString));
  }
  
  public void onMiniAppCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendCmd cmd=");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("MiniAppCmdServlet", ((StringBuilder)localObject).toString());
    if ("cmd_exit_qq".equals(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CMD_EXIT_QQ pid=");
      ((StringBuilder)localObject).append(Process.myPid());
      QMLog.i("MiniAppCmdServlet", ((StringBuilder)localObject).toString());
      Process.killProcess(Process.myPid());
    }
    else if ("cmd_update_baselib".equals(paramString))
    {
      updateBaseLib(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_upload_ark_share_image".equals(paramString))
    {
      if (paramBundle == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMiniAppCmd cmd = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", bundle is null");
        QMLog.e("MiniAppCmdServlet", ((StringBuilder)localObject).toString());
      }
    }
    else if ("cmd_share_ark_async_message".equals(paramString))
    {
      if (paramBundle == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMiniAppCmd cmd = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", bundle is null");
        QMLog.e("MiniAppCmdServlet", ((StringBuilder)localObject).toString());
      }
    }
    else if ("cmd_add_qq_favorites".equals(paramString))
    {
      FavoritesJsPlugin.addFavoritesBundle(paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_dc_report_log_key_data".equals(paramString))
    {
      MiniProgramLpReportDC04902.reportToServer(paramBundle);
    }
    else if ("cmd_rebind_engine_channel".equals(paramString))
    {
      rebindEngineChannel(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_rebind_engine_channel_new".equals(paramString))
    {
      rebindEngineChannelNew(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_update_pull_down_entry_list".equals(paramString))
    {
      if (paramBundle == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMiniAppCmd cmd = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", bundle is null");
        QMLog.e("MiniAppCmdServlet", ((StringBuilder)localObject).toString());
      }
    }
    else if ("launch_report".equals(paramString))
    {
      launchReport(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("launch_report2".equals(paramString))
    {
      launchReport2(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("record_duration".equals(paramString))
    {
      recordDuration(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_update_app_for_mini_game".equals(paramString))
    {
      updateAppForMiniGame(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_on_preload_game_baselib".equals(paramString))
    {
      preloadGameBaseLib(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_notify_event_info".equals(paramString))
    {
      notifyEventInfo(paramString, paramBundle, paramMiniCmdCallback);
    }
    else if ("cmd_update_v8rt".equals(paramString))
    {
      onUpdateV8rt(paramString, paramBundle, paramMiniCmdCallback);
    }
    localObject = (CmdProxy)ProxyManager.get(CmdProxy.class);
    if (localObject != null) {
      ((CmdProxy)localObject).handleMiniAppCmd(paramString, paramBundle, paramMiniCmdCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.MiniAppCmdServlet
 * JD-Core Version:    0.7.0.1
 */