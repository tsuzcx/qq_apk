package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderInterface;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;

public class PreloadComDownloader
{
  private static volatile PreloadComDownloader jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
  
  public static PreloadComDownloader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader = new PreloadComDownloader();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadComDownloader;
  }
  
  private void a(Bundle paramBundle, DownloadListener paramDownloadListener, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, paramDownloadListener, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle)
  {
    if ((paramDownloadParam != null) && (!TextUtils.isEmpty(paramDownloadParam.url)))
    {
      if (TextUtils.isEmpty(paramDownloadParam.filePath)) {
        return;
      }
      if (paramDownloadParam.isPreDownload)
      {
        Object localObject = QWalletHelperImpl.getAppRuntime();
        if (localObject == null) {
          return;
        }
        localObject = (BaseQQAppInterface)localObject;
        paramDownloadListener = new PreloadComDownloader.1(this, paramDownloadListener);
        paramDownloadListener = new PreloadComDownloader.2(this, (BaseQQAppInterface)localObject, paramDownloadParam.url, paramBundle, paramDownloadListener, paramDownloadParam);
        ((IPreDownloadController)((BaseQQAppInterface)localObject).getRuntimeService(IPreDownloadController.class)).requestPreDownload(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, paramDownloadListener);
        return;
      }
      a(paramBundle, paramDownloadListener, paramDownloadParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader
 * JD-Core Version:    0.7.0.1
 */