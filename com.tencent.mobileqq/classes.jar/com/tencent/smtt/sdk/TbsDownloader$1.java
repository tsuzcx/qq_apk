package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class TbsDownloader$1
  extends Handler
{
  TbsDownloader$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    boolean bool3 = true;
    int i;
    label71:
    boolean bool1;
    label81:
    Object localObject2;
    switch (paramMessage.what)
    {
    case 105: 
    case 106: 
    case 107: 
    default: 
      return;
    case 100: 
      if (paramMessage.arg1 == 1)
      {
        i = 1;
        if (paramMessage.arg2 != 1) {
          break label250;
        }
        bool1 = true;
        bool1 = TbsDownloader.a(true, false, false, bool1);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool1);
          localObject2 = "";
          localObject1 = localObject2;
          if (TbsDownloader.a() != null)
          {
            localObject1 = localObject2;
            if (TbsDownloader.a().getApplicationContext() != null)
            {
              localObject1 = localObject2;
              if (TbsDownloader.a().getApplicationContext().getApplicationInfo() != null) {
                localObject1 = TbsDownloader.a().getApplicationContext().getApplicationInfo().packageName;
              }
            }
          }
          if ((bool1) && (i == 0)) {
            break label255;
          }
          ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        }
      }
      while ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (bool1))
      {
        TbsDownloader.startDownload(TbsDownloader.a());
        return;
        i = 0;
        break label71;
        bool1 = false;
        break label81;
        if (("com.tencent.mm".equals(localObject1)) || ("com.tencent.mobileqq".equals(localObject1)))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + bool1);
          ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        }
      }
    case 101: 
    case 108: 
      Object localObject3;
      if (!TbsShareManager.isThirdPartyApp(TbsDownloader.a()))
      {
        localObject2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
        localObject2 = FileUtil.b(TbsDownloader.a(), false, (String)localObject2);
        if (localObject2 != null)
        {
          localObject3 = FileUtil.a(TbsDownloader.a(), (FileOutputStream)localObject2);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            QbSdk.m.onDownloadFinish(177);
            TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
            TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
            TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
          }
        }
        else if (FileUtil.a(TbsDownloader.a()))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
          TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
        }
      }
      else
      {
        localObject2 = null;
      }
      boolean bool2;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        localObject3 = TbsDownloadConfig.getInstance(TbsDownloader.a());
        if (108 != paramMessage.what) {
          break label600;
        }
        bool2 = true;
        if (!TbsDownloader.a(false, bool1, bool2, true)) {
          break label682;
        }
        if ((!bool1) || (!n.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
          break label606;
        }
        QbSdk.m.onDownloadFinish(122);
        ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", "------freeFileLock called :");
        FileUtil.a((FileLock)localObject1, (FileOutputStream)localObject2);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label518;
        if (((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
          localObject3 = TbsDownloader.b();
          if (108 == paramMessage.what) {}
          for (bool2 = bool3;; bool2 = false)
          {
            ((j)localObject3).b(bool1, bool2);
            break;
          }
        }
        QbSdk.m.onDownloadFinish(110);
        continue;
        QbSdk.m.onDownloadFinish(110);
      }
    case 102: 
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
      if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
      for (i = TbsShareManager.a(TbsDownloader.a(), false);; i = n.a().m(TbsDownloader.a()))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
        TbsDownloader.b().a(i);
        TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
        return;
      }
    case 104: 
      label250:
      label255:
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
      label518:
      label600:
      label606:
      TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
      label682:
      return;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
    if (paramMessage.arg1 == 0)
    {
      n.a().a((Context)paramMessage.obj, true);
      return;
    }
    n.a().a((Context)paramMessage.obj, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */