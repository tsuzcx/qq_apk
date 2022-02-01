package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.troop.filemanager.download.ITroopFileDownloader;
import com.tencent.mobileqq.troop.filemanager.download.ITroopFileDownloaderSink;
import com.tencent.qphone.base.util.QLog;

public class ExtfGroupFileDownloader
  extends ExtfBaseFileDownloader
  implements ITroopFileDownloader
{
  protected ITroopFileDownloaderSink l;
  protected String m;
  
  public ExtfGroupFileDownloader(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, ExtfDownloadFileInfo paramExtfDownloadFileInfo)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, paramInt, paramExtfDownloadFileInfo);
  }
  
  public static ITroopFileDownloader a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, ExtfDownloadFileInfo paramExtfDownloadFileInfo)
  {
    if (paramExtfDownloadFileInfo == null)
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader strTmpFilePath is err");
      return null;
    }
    if (!paramExtfDownloadFileInfo.a())
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is err");
      return null;
    }
    paramQQAppInterface = new ExtfGroupFileDownloader(paramQQAppInterface, paramLong1, paramLong2, 1, paramExtfDownloadFileInfo);
    paramQQAppInterface.a(paramString);
    return paramQQAppInterface;
  }
  
  protected ExcitingTransferDownloadConfig a()
  {
    return ((IExcitingTransferAdapter)this.d.getRuntimeService(IExcitingTransferAdapter.class, "")).getGroupDownloadConfig();
  }
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    if (this.l != null)
    {
      Bundle localBundle = new Bundle();
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        localBundle.putInt("nSrvReturnCode", paramExcitingTransferDownloadCompletedInfo.mnSrvReturnCode);
      }
      this.l.a(true, h(), paramInt, "", "", localBundle);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    ITroopFileDownloaderSink localITroopFileDownloaderSink = this.l;
    if (localITroopFileDownloaderSink != null) {
      localITroopFileDownloaderSink.a(paramLong2, this.h.c());
    }
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramExcitingTransferDownloadCompletedInfo);
    ITroopFileDownloaderSink localITroopFileDownloaderSink = this.l;
    if (localITroopFileDownloaderSink != null) {
      localITroopFileDownloaderSink.a(paramExcitingTransferDownloadCompletedInfo.mstrFileSavePath);
    }
  }
  
  public void a(ITroopFileDownloaderSink paramITroopFileDownloaderSink)
  {
    this.l = paramITroopFileDownloaderSink;
  }
  
  protected void a(String paramString)
  {
    this.m = paramString;
  }
  
  protected String d()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  protected String e()
  {
    return this.m;
  }
  
  public void k()
  {
    this.a = false;
    b();
  }
  
  public void l()
  {
    if (this.a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("] cancelTask");
    QLog.i("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, localStringBuilder.toString());
    c();
  }
  
  public int m()
  {
    if (i() != null) {
      return i().muRetryTimes;
    }
    return 0;
  }
  
  public boolean n()
  {
    return false;
  }
  
  public String o()
  {
    return this.k;
  }
  
  public String p()
  {
    return this.k;
  }
  
  public int q()
  {
    return 0;
  }
  
  public int r()
  {
    if (i() != null) {
      return i().muProxyType;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfGroupFileDownloader
 * JD-Core Version:    0.7.0.1
 */