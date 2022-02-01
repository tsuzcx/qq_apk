package com.tencent.qqmini.miniapp.receiver;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessReceiver$2
  implements TbsListener
{
  WebProcessReceiver$2(WebProcessReceiver paramWebProcessReceiver, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  public void onDownloadFinish(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs download finish result=");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("TBS_update", ((StringBuilder)localObject).toString());
    if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122))
    {
      if (WebProcessReceiver.sTBSDownloading.compareAndSet(true, false))
      {
        QbSdk.setTbsListener(null);
        int i = this.val$sp.getInt("tbs_download_count", 0);
        long l1 = this.val$sp.getLong("tbs_download_cost", 0L);
        long l2 = System.currentTimeMillis();
        long l3 = this.val$start;
        localObject = this.val$sp.edit();
        ((SharedPreferences.Editor)localObject).putInt("tbs_download_count", i + 1);
        ((SharedPreferences.Editor)localObject).putLong("tbs_download_cost", l1 + (l2 - l3));
        ((SharedPreferences.Editor)localObject).commit();
        if (QMLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tbs download aborted:");
          ((StringBuilder)localObject).append(paramInt);
          QMLog.d("TBS_update", ((StringBuilder)localObject).toString());
        }
      }
      localObject = this.val$sp.edit();
      ((SharedPreferences.Editor)localObject).putInt("tbs_download_complete", paramInt);
      ((SharedPreferences.Editor)localObject).remove("tbs_downloading");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tbs download progress ");
      localStringBuilder.append(paramInt);
      QMLog.d("TBS_update", localStringBuilder.toString());
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs download install finish result=");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("TBS_update", ((StringBuilder)localObject).toString());
    if (paramInt == 200) {
      return;
    }
    if (WebProcessReceiver.sTBSDownloading.compareAndSet(true, false))
    {
      QbSdk.setTbsListener(null);
      long l1;
      if ((paramInt != 232) && (paramInt != 220))
      {
        int i = this.val$sp.getInt("tbs_download_count", 0);
        l1 = this.val$sp.getLong("tbs_download_cost", 0L);
        long l2 = System.currentTimeMillis();
        long l3 = this.val$start;
        localObject = this.val$sp.edit();
        ((SharedPreferences.Editor)localObject).putInt("tbs_download_count", i + 1);
        ((SharedPreferences.Editor)localObject).putLong("tbs_download_cost", l1 + (l2 - l3));
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tbs install error:");
        ((StringBuilder)localObject).append(paramInt);
        QMLog.d("TBS_update", ((StringBuilder)localObject).toString());
      }
      else
      {
        this.val$sp.getInt("tbs_download_count", 0);
        this.val$sp.getLong("tbs_download_cost", 0L);
        System.currentTimeMillis();
        l1 = this.val$start;
        localObject = this.val$sp.edit();
        ((SharedPreferences.Editor)localObject).remove("tbs_download_count");
        ((SharedPreferences.Editor)localObject).remove("tbs_download_cost");
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tbs install finished:");
        ((StringBuilder)localObject).append(paramInt);
        QMLog.d("TBS_update", ((StringBuilder)localObject).toString());
      }
      localObject = this.val$sp.edit();
      ((SharedPreferences.Editor)localObject).putInt("tbs_download_complete", paramInt);
      ((SharedPreferences.Editor)localObject).remove("tbs_downloading");
      ((SharedPreferences.Editor)localObject).remove("tbs_download_progress");
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.2
 * JD-Core Version:    0.7.0.1
 */