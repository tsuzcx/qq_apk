package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.FileOutputStream;

final class TbsDownloader$2
  extends Handler
{
  TbsDownloader$2(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool3 = true;
    boolean bool1;
    Object localObject1;
    if (i != 108)
    {
      if (i != 109) {}
      switch (i)
      {
      default: 
        return;
      case 104: 
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
        TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
        return;
      case 103: 
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
        if (paramMessage.arg1 == 0)
        {
          p.a().a((Context)paramMessage.obj, true);
          return;
        }
        p.a().a((Context)paramMessage.obj, false);
        return;
      case 102: 
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
        if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {
          i = TbsShareManager.a(TbsDownloader.a(), false);
        } else {
          i = p.a().n(TbsDownloader.a());
        }
        paramMessage = new StringBuilder();
        paramMessage.append("[TbsDownloader.handleMessage] localTbsVersion=");
        paramMessage.append(i);
        TbsLog.i("TbsDownload", paramMessage.toString());
        TbsDownloader.b().a(i);
        TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
        return;
      case 100: 
        if (paramMessage.arg1 == 1) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramMessage.arg2 == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool1 = TbsDownloader.a(true, false, false, bool1);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("needDownload-onNeedDownloadFinish needStartDownload=");
          ((StringBuilder)localObject1).append(bool1);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
          if ((TbsDownloader.a() != null) && (TbsDownloader.a().getApplicationContext() != null) && (TbsDownloader.a().getApplicationContext().getApplicationInfo() != null)) {
            localObject1 = TbsDownloader.a().getApplicationContext().getApplicationInfo().packageName;
          } else {
            localObject1 = "";
          }
          if ((bool1) && (i == 0))
          {
            if (("com.tencent.mm".equals(localObject1)) || ("com.tencent.mobileqq".equals(localObject1)))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ");
              ((StringBuilder)localObject1).append(bool1);
              TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
            }
          }
          else {
            ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
          }
        }
        if ((!TbsShareManager.isThirdPartyApp(TbsDownloader.a())) || (!bool1)) {
          break;
        }
        TbsDownloader.startDownload(TbsDownloader.a());
        return;
        if (TbsDownloader.b() == null) {
          break;
        }
        TbsDownloader.b().f();
        return;
      }
    }
    else
    {
      if ((Apn.getApnType(TbsDownloader.a()) != 3) && (!QbSdk.getDownloadWithoutWifi())) {
        paramMessage = "not wifi,no need send request";
      }
      Object localObject2;
      for (;;)
      {
        TbsLog.i("TbsDownload", paramMessage);
        return;
        bool1 = TbsShareManager.isThirdPartyApp(TbsDownloader.a());
        localObject2 = null;
        if (bool1) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tbs_download_lock_file");
        ((StringBuilder)localObject1).append(TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        ((StringBuilder)localObject1).append(".txt");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject1 = FileUtil.b(TbsDownloader.a(), false, (String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = FileUtil.a(TbsDownloader.a(), (FileOutputStream)localObject1);
          localObject2 = localObject3;
          if (localObject3 != null) {
            break label663;
          }
          QbSdk.m.onDownloadFinish(177);
          TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
          paramMessage = "MSG_START_DOWNLOAD_DECOUPLECORE return #1";
        }
        else
        {
          if (!FileUtil.a(TbsDownloader.a())) {
            break label663;
          }
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
          paramMessage = "MSG_START_DOWNLOAD_DECOUPLECORE return #2";
        }
      }
      localObject1 = null;
      label663:
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Object localObject3 = TbsDownloadConfig.getInstance(TbsDownloader.a());
      boolean bool2;
      if (108 == paramMessage.what) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool4 = TbsDownloader.a(false, bool1, bool2, true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needStartDownload is ");
      localStringBuilder.append(bool4);
      localStringBuilder.append(" forDecoupleCore is ");
      if (108 == paramMessage.what) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localStringBuilder.append(bool2);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("idownloadConfig.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) is ");
      localStringBuilder.append(((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false));
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      if (bool4)
      {
        if ((bool1) && (p.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0))))
        {
          TbsLog.i("TbsDownload", "in needStartDownload true #1");
          QbSdk.m.onDownloadFinish(122);
          ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
          break label968;
        }
        if (((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
          localObject3 = TbsDownloader.b();
          if (108 == paramMessage.what) {
            bool2 = bool3;
          } else {
            bool2 = false;
          }
          ((l)localObject3).b(bool1, bool2);
          break label968;
        }
      }
      QbSdk.m.onDownloadFinish(110);
      label968:
      TbsLog.i("TbsDownload", "------freeFileLock called :");
      FileUtil.a(localObject2, (FileOutputStream)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.2
 * JD-Core Version:    0.7.0.1
 */