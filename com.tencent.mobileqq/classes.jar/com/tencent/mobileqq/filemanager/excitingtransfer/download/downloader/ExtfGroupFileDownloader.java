package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.troop.filemanager.download.ITroopFileDownloader;
import com.tencent.mobileqq.troop.filemanager.download.ITroopFileDownloaderSink;
import com.tencent.qphone.base.util.QLog;

public class ExtfGroupFileDownloader
  extends ExtfBaseFileDownloader
  implements ITroopFileDownloader
{
  protected ITroopFileDownloaderSink a;
  protected String b;
  
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
    return ExcitingTransferAdapter.a().b();
  }
  
  protected String a()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink != null)
    {
      Bundle localBundle = new Bundle();
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        localBundle.putInt("nSrvReturnCode", paramExcitingTransferDownloadCompletedInfo.mnSrvReturnCode);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink.a(true, a(), paramInt, "", "", localBundle);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink.a(paramLong2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a());
    }
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink.a(paramExcitingTransferDownloadCompletedInfo.mstrFileSavePath);
    }
  }
  
  public void a(ITroopFileDownloaderSink paramITroopFileDownloaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloaderSink = paramITroopFileDownloaderSink;
  }
  
  protected void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int b()
  {
    if (a() != null) {
      return a().muRetryTimes;
    }
    return 0;
  }
  
  protected String b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "Id[" + this.d + "] cancelTask");
    a();
  }
  
  public int d()
  {
    if (a() != null) {
      return a().muProxyType;
    }
    return 0;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfGroupFileDownloader
 * JD-Core Version:    0.7.0.1
 */