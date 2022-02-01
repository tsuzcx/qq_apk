package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface.DownLoaderComponentAdapter;
import com.tencent.falco.base.libapi.downloader.IDownLoaderListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.Map;

class CustomDownloaService$1
  extends DownloadListener
{
  CustomDownloaService$1(CustomDownloaService paramCustomDownloaService, IDownLoaderListener paramIDownLoaderListener) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    LogInterface localLogInterface = CustomDownloaService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDownloadCustomDownloaService).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCancel, DownloadCancel-----url = ");
    localStringBuilder.append(paramDownloadTask.c);
    localLogInterface.i("CustomDownloaService", localStringBuilder.toString(), new Object[0]);
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    LogInterface localLogInterface = CustomDownloaService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDownloadCustomDownloaService).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDone, DownloadSuccess-----url = ");
    localStringBuilder.append(paramDownloadTask.c);
    localStringBuilder.append(", filePath = ");
    localStringBuilder.append(((File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c)).getAbsolutePath());
    localLogInterface.i("CustomDownloaService", localStringBuilder.toString(), new Object[0]);
    super.onDone(paramDownloadTask);
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDownloaderIDownLoaderListener.onSuccess(paramDownloadTask.c, ((File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c)).getAbsolutePath());
  }
  
  public void onPause(DownloadTask paramDownloadTask)
  {
    LogInterface localLogInterface = CustomDownloaService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDownloadCustomDownloaService).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause, DownloadPause-----url = ");
    localStringBuilder.append(paramDownloadTask.c);
    localLogInterface.i("CustomDownloaService", localStringBuilder.toString(), new Object[0]);
    super.onPause(paramDownloadTask);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDownloaderIDownLoaderListener.onProgress(paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Long, (int)paramDownloadTask.jdField_a_of_type_Float, 0);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download.CustomDownloaService.1
 * JD-Core Version:    0.7.0.1
 */