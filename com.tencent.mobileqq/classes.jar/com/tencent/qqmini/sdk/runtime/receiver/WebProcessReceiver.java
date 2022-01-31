package com.tencent.qqmini.sdk.runtime.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import bhdt;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebProcessReceiver
  extends BroadcastReceiver
{
  public static final AtomicBoolean a = new AtomicBoolean(false);
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = AppLoaderFactory.g().getContext();
    if (a.compareAndSet(false, true))
    {
      long l = System.currentTimeMillis();
      localObject = ((Context)localObject).getSharedPreferences(((Context)localObject).getPackageName() + "_preferences", 4);
      QbSdk.setTbsListener(new bhdt(this, (SharedPreferences)localObject, l));
      QMLog.d("TBS_update", "tbs start download");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("tbs_downloading", true);
      ((SharedPreferences.Editor)localObject).remove("tbs_download_complete");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
      TbsDownloader.startDownload(AppLoaderFactory.g().getContext(), paramBoolean2);
    }
    QMLog.d("TBS_update", "tbs has started downloading");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        break label14;
      }
    }
    label14:
    do
    {
      return;
      QMLog.d("WebProcessReceiver", "action=" + paramContext);
    } while (!"action_download_tbs".equals(paramContext));
    if (("1|1" != null) && ("1|1".charAt(0) == '1')) {}
    for (int i = 1;; i = 0)
    {
      boolean bool1 = paramIntent.getBooleanExtra("isDownloadForeground", false);
      boolean bool2 = paramIntent.getBooleanExtra("fromMiniApp", false);
      if (i == 0) {
        break;
      }
      ThreadManager.a().post(new WebProcessReceiver.1(this, bool1, bool2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.receiver.WebProcessReceiver
 * JD-Core Version:    0.7.0.1
 */