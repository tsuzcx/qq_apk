package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import mqq.os.MqqHandler;

public class MiniAppCmdServlet
{
  public static final String CMD_ADD_FAVORITES_TO_QQ = "cmd_add_qq_favorites";
  public static final String CMD_CHANGE_ARK_SHARE_URL = "cmd_change_ark_share_url";
  public static final String CMD_DC_REPORT_LOG_KEY_DATA = "cmd_dc_report_log_key_data";
  public static final String CMD_EXIT_QQ = "cmd_exit_qq";
  public static final String CMD_NOTIFY_EVENT_INFO = "cmd_notify_event_info";
  public static final String CMD_ON_PRELOAD_GAME_BASELIB = "cmd_on_preload_game_baselib";
  public static final String CMD_REBIND_ENGINE_CHANNEL = "cmd_rebind_engine_channel";
  public static final String CMD_REBIND_ENGINE_CHANNEL_NEW = "cmd_rebind_engine_channel_new";
  public static final String CMD_UPDATE_APP_FOR_MINI_GAME = "cmd_update_app_for_mini_game";
  public static final String CMD_UPDATE_BASELIB = "cmd_update_baselib";
  public static final String CMD_UPDATE_PULL_DOWN_ENTRY_LIST = "cmd_update_pull_down_entry_list";
  public static final String CMD_UPDATE_TRITON_ENGINE = "cmd_update_triton_engine";
  public static final String CMD_UPLOAD_ARK_SHARE_IMAGE = "cmd_upload_ark_share_image";
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_BUNDLE_APP_TYPE = "bundle_key_app_type";
  public static final String KEY_BUNDLE_PRELOAD_GAME_BASELIB_VERSION = "bundle_key_preload_game_baselib_version";
  public static final String KEY_BUNDLE_PROCESS_NAME = "bundle_key_process_name";
  public static final String KEY_EVENT = "key_event";
  public static final String KEY_SCENE = "key_scene";
  public static final String KEY_TIMESTAMP = "key_timestamp";
  public static final String KEY_URI = "key_uri";
  public static final String KEY_VIA = "key_via";
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
  
  private void notifyEventInfo(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramString = paramBundle.getString("key_appid", "");
      int i = paramBundle.getInt("key_scene", 9999);
      String str1 = paramBundle.getString("key_via", "");
      String str2 = paramBundle.getString("key_event", "");
      long l = paramBundle.getLong("key_timestamp", 0L);
      MiniAppNotify.g.notify(paramString, i, str1, str2, l);
    }
  }
  
  public void onMiniAppCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendCmd cmd=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("MiniAppCmdServlet", 2, ((StringBuilder)localObject).toString());
    if ("cmd_exit_qq".equals(paramString))
    {
      Process.killProcess(Process.myPid());
      return;
    }
    if ("cmd_update_baselib".equals(paramString))
    {
      if (paramBundle != null) {
        paramBundle.getString("version");
      }
      BaseLibManager.g().forceUpdateBaseLib(new MiniAppCmdServlet.1(this, paramCmdCallback, paramString));
      return;
    }
    if ("cmd_upload_ark_share_image".equals(paramString))
    {
      if (paramBundle != null)
      {
        MiniArkShareAsyncManager.performUploadArkShareImage(paramBundle.getString("key_uri"), new MiniAppCmdServlet.2(this, paramCmdCallback, paramString));
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("onMiniAppCmd cmd = ");
      paramBundle.append(paramString);
      paramBundle.append(", bundle is null");
      QLog.e("MiniAppCmdServlet", 1, paramBundle.toString());
      return;
    }
    if ("cmd_dc_report_log_key_data".equals(paramString)) {
      return;
    }
    boolean bool = "cmd_rebind_engine_channel".equals(paramString);
    int i = 3;
    int j = -1;
    if (bool)
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("bundle_key_app_type", -1);
      }
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:");
      paramBundle.append(j);
      QLog.i("MiniAppCmdServlet", 1, paramBundle.toString());
      if ((j != 0) && (j != 1)) {
        return;
      }
      paramBundle = new Bundle();
      localObject = EngineManager.g();
      if (j == 1) {
        i = 2;
      }
      paramBundle.putParcelable("engineChannel", ((EngineManager)localObject).getChannelForType(i));
      if (paramCmdCallback == null) {
        return;
      }
      try
      {
        paramCmdCallback.onCmdResult(true, paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramCmdCallback = new StringBuilder();
        paramCmdCallback.append("cmd response exception. cmd=");
        paramCmdCallback.append(paramString);
        QLog.e("MiniAppCmdServlet", 1, paramCmdCallback.toString(), paramBundle);
        return;
      }
    }
    if ("cmd_rebind_engine_channel_new".equals(paramString))
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("bundle_key_app_type", -1);
      }
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:");
      paramBundle.append(j);
      QLog.i("MiniAppCmdServlet", 1, paramBundle.toString());
      if ((j != 0) && (j != 1)) {
        return;
      }
      localObject = new Bundle();
      ICommonManager localICommonManager = AppLoaderFactory.g().getCommonManager();
      paramBundle = null;
      if (localICommonManager != null)
      {
        if (j == 1) {
          i = 2;
        }
        paramBundle = localICommonManager.getChannelForType(i);
      }
      if (paramBundle != null) {
        ((Bundle)localObject).putParcelable("engineChannel", paramBundle);
      }
      if (paramCmdCallback == null) {
        return;
      }
      try
      {
        paramCmdCallback.onCmdResult(true, (Bundle)localObject);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramCmdCallback = new StringBuilder();
        paramCmdCallback.append("cmd response exception. cmd=");
        paramCmdCallback.append(paramString);
        QLog.e("MiniAppCmdServlet", 1, paramCmdCallback.toString(), paramBundle);
        return;
      }
    }
    if ("cmd_update_pull_down_entry_list".equals(paramString))
    {
      if (paramBundle != null)
      {
        MiniAppUtils.handlePullDownEntryListData(paramBundle, paramCmdCallback);
        ThreadManager.getSubThreadHandler().postDelayed(new MiniAppCmdServlet.3(this), 600L);
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("onMiniAppCmd cmd = ");
      paramBundle.append(paramString);
      paramBundle.append(", bundle is null");
      QLog.e("MiniAppCmdServlet", 1, paramBundle.toString());
      return;
    }
    if ("cmd_update_app_for_mini_game".equals(paramString)) {
      return;
    }
    if ("cmd_update_triton_engine".equals(paramString)) {
      return;
    }
    if ("cmd_notify_event_info".equals(paramString))
    {
      notifyEventInfo(paramString, paramBundle);
      return;
    }
    if ("cmd_change_ark_share_url".equals(paramString)) {
      MiniArkShareAsyncManager.performChangeArkShareImageUrl(paramBundle.getString("key_uri"), paramCmdCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppCmdServlet
 * JD-Core Version:    0.7.0.1
 */