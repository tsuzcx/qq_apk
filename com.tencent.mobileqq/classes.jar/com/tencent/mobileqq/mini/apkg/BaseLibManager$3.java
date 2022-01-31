package com.tencent.mobileqq.mini.apkg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nav;

class BaseLibManager$3
  implements Downloader.DownloadListener
{
  BaseLibManager$3(BaseLibManager paramBaseLibManager, String paramString1, BaseLibManager.UpdateListener paramUpdateListener, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "ApkgManager--onDownloadCanceled:" + this.val$url);
    }
    if (this.val$listener != null)
    {
      this.val$listener.onUpdateResult(1101);
      return;
    }
    BaseLibManager.access$200(this.this$0, 1101);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "ApkgManager--onDownloadFailed:" + this.val$url);
    if (this.val$listener != null) {
      this.val$listener.onUpdateResult(1101);
    }
    for (;;)
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 617, null, null, null, 1101);
      MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, 4, null);
      return;
      BaseLibManager.access$200(this.this$0, 1101);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "ApkgManager--onDownloadSucceed:" + this.val$url);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, null, null, null, 0);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 6, null, null, null, 0);
    MiniProgramLpReportDC05325.reportApiReport(paramDownloadResult, 4, null);
    for (;;)
    {
      try
      {
        paramString = this.this$0.getBaseLibDir(this.val$url, this.val$version);
        paramDownloadResult = new File(paramString);
        if (this.this$0.isBaseLibDirValid(paramDownloadResult))
        {
          QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.val$version, this.val$oldVersion))
          {
            QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "update baselib local version from:" + this.val$oldVersion + " to:" + this.val$version);
            StorageUtil.getPreference().edit().putString("downloadUrl", this.val$url).commit();
            StorageUtil.getPreference().edit().putString("version", this.val$version).commit();
          }
          if (this.val$listener != null)
          {
            this.val$listener.onUpdateResult(0);
            return;
          }
          BaseLibManager.access$200(this.this$0, 0);
          continue;
        }
        int i;
        QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "ApkgManager--unZipFolder exception.", paramString);
        if (this.val$listener == null) {
          break label667;
        }
        this.val$listener.onUpdateResult(1103);
        return;
        if (paramDownloadResult.exists()) {
          FileUtils.delete(paramString, false);
        }
        paramDownloadResult.mkdir();
        i = nav.a(this.val$downloadZipPath, paramString);
        if (i != 0) {
          break label680;
        }
        bool = BaseLibManager.access$400(this.this$0, paramDownloadResult);
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 7, null, null, null, 0);
        if ((i == 0) && (bool))
        {
          QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "unZipFolder succeed.url:" + this.val$url + ",version:" + this.val$version);
          StorageUtil.getPreference().edit().putString("downloadUrl", this.val$url).commit();
          StorageUtil.getPreference().edit().putString("version", this.val$version).commit();
          if ((!TextUtils.isEmpty(this.val$oldUrl)) && (!TextUtils.isEmpty(this.val$oldVersion)) && (!TextUtils.equals(this.val$oldUrl, this.val$url)) && (!TextUtils.equals(this.val$oldVersion, this.val$version)))
          {
            QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "delete last path.");
            paramDownloadResult = this.this$0.getBaseLibDir(this.val$oldUrl, this.val$oldVersion);
            if (!paramDownloadResult.equals(paramString))
            {
              QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "delete last path. oldUrl : " + this.val$oldUrl + "; version : " + this.val$version);
              FileUtils.delete(paramDownloadResult, false);
            }
          }
          if (this.val$listener != null)
          {
            this.val$listener.onUpdateResult(0);
            return;
          }
          BaseLibManager.access$200(this.this$0, 0);
          continue;
        }
      }
      finally
      {
        FileUtils.delete(this.val$downloadZipPath, true);
      }
      FileUtils.delete(paramString, false);
      if (this.val$listener != null) {
        this.val$listener.onUpdateResult(1102);
      }
      for (;;)
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 618, null, null, null, 1102);
        break;
        BaseLibManager.access$200(this.this$0, 1102);
      }
      label667:
      BaseLibManager.access$200(this.this$0, 1103);
      continue;
      label680:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager.3
 * JD-Core Version:    0.7.0.1
 */