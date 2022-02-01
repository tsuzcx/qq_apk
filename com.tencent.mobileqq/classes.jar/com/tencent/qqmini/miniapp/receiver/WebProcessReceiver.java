package com.tencent.qqmini.miniapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebProcessReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_DOWNLOAD_TBS = "action_download_tbs";
  public static final String TAG = "WebProcessReceiver";
  public static final AtomicBoolean sTBSDownloading = new AtomicBoolean(false);
  
  public void downloadTbs(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (sTBSDownloading.compareAndSet(false, true))
    {
      long l = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 4);
      QbSdk.setTbsListener(new WebProcessReceiver.2(this, (SharedPreferences)localObject, l));
      QMLog.d("TBS_update", "tbs start download");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("tbs_downloading", true);
      ((SharedPreferences.Editor)localObject).remove("tbs_download_complete");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
      TbsDownloader.startDownload(paramContext, paramBoolean2);
    }
    QMLog.d("TBS_update", "tbs has started downloading");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      if (str == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action=");
      localStringBuilder.append(str);
      QMLog.d("WebProcessReceiver", localStringBuilder.toString());
      if ("action_download_tbs".equals(str))
      {
        int i;
        if ("1|1".charAt(0) == '1') {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool1 = paramIntent.getBooleanExtra("isDownloadForeground", false);
        boolean bool2 = paramIntent.getBooleanExtra("fromMiniApp", false);
        if (i != 0) {
          ThreadManager.getSubThreadHandler().post(new WebProcessReceiver.1(this, paramContext, bool1, bool2));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.receiver.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */