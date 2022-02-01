package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download;

import android.content.Context;
import android.os.Bundle;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface.DownLoaderComponentAdapter;
import com.tencent.falco.base.libapi.downloader.IDownLoaderListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class CustomDownloaService
  implements DownLoaderInterface
{
  private DownLoaderInterface.DownLoaderComponentAdapter jdField_a_of_type_ComTencentFalcoBaseLibapiDownloaderDownLoaderInterface$DownLoaderComponentAdapter;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  
  public void cancel(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(false, paramString);
  }
  
  public void clearEventOutput() {}
  
  public void init(DownLoaderInterface.DownLoaderComponentAdapter paramDownLoaderComponentAdapter)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDownloaderDownLoaderInterface$DownLoaderComponentAdapter = paramDownLoaderComponentAdapter;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = new DownloaderFactory(null).a(3);
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void pause(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramString).d();
  }
  
  public void resume(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramString).c();
  }
  
  public void start(String paramString1, String paramString2, int paramInt1, int paramInt2, IDownLoaderListener paramIDownLoaderListener)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDownloaderDownLoaderInterface$DownLoaderComponentAdapter.getLog().i("CustomDownloaService", "startDownload-----url = " + paramString1 + ", filePath = " + paramString2, new Object[0]);
    paramString2 = new DownloadTask(paramString1, new File(paramString2));
    paramString2.g = 3;
    paramString2.a = paramString1;
    paramString1 = new Bundle();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramString2, new CustomDownloaService.1(this, paramIDownLoaderListener), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download.CustomDownloaService
 * JD-Core Version:    0.7.0.1
 */