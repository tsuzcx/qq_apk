package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;

public class PreloadComDownloader
{
  private static volatile PreloadComDownloader jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  
  private PreloadComDownloader()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(null);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
    }
  }
  
  public static PreloadComDownloader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader == null) {
        jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader = new PreloadComDownloader();
      }
      return jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, DownloadListener paramDownloadListener, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, paramDownloadListener, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url)) || (TextUtils.isEmpty(paramDownloadParam.filePath))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      if (!paramDownloadParam.isPreDownload) {
        break;
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localQQAppInterface == null);
    paramDownloadListener = new PreloadComDownloader.1(this, paramDownloadListener);
    paramDownloadListener = new PreloadComDownloader.2(this, localQQAppInterface, paramDownloadParam.url, paramBundle, paramDownloadListener, paramDownloadParam);
    ((PreDownloadController)localQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, paramDownloadListener);
    return;
    a(paramBundle, paramDownloadListener, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader
 * JD-Core Version:    0.7.0.1
 */