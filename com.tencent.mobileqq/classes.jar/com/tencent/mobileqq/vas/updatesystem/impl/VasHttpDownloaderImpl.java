package com.tencent.mobileqq.vas.updatesystem.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;
import java.io.File;

public class VasHttpDownloaderImpl
  extends DownloadListener
  implements IHttpDownloader
{
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new VasHttpDownloaderImpl.2(this);
  private IDownloadListener jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener;
  
  private DownloadTask a(@NonNull DownloadInfoParams paramDownloadInfoParams)
  {
    DownloadTask localDownloadTask = new DownloadTask(paramDownloadInfoParams.mUrl, new File(paramDownloadInfoParams.mSavePath));
    localDownloadTask.f = "vas_update_system";
    localDownloadTask.e = true;
    localDownloadTask.p = true;
    localDownloadTask.r = true;
    localDownloadTask.q = true;
    localDownloadTask.j = true;
    localDownloadTask.n = false;
    localDownloadTask.s = false;
    localDownloadTask.a = paramDownloadInfoParams.mItemId;
    return localDownloadTask;
  }
  
  private DownloaderInterface a()
  {
    return ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(4);
  }
  
  private void a(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener)
  {
    if ((a() != null) && (paramDownloadInfoParams != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasUpdate_HttpImpl", 2, "onPreloadDownloadStart");
      }
      paramIDownloadListener = new VasHttpDownloaderImpl.1(this, paramDownloadInfoParams, paramIDownloadListener);
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
        localObject = (IPreDownloadController)localQQAppInterface.getRuntimeService(IPreDownloadController.class);
        paramIDownloadListener = new RunnableTask(localQQAppInterface, paramDownloadInfoParams.mUrl, paramIDownloadListener, 4000L);
        ((IPreDownloadController)localObject).requestPreDownload(10019, "vas", paramDownloadInfoParams.mItemId, 3, paramDownloadInfoParams.mUrl, paramDownloadInfoParams.mSavePath, 2, 0, true, paramIDownloadListener);
        return;
      }
      QLog.e("VasUpdate_HttpImpl", 1, "onPreloadDownloadStart app is not QQAppInterface");
      paramIDownloadListener.run();
      return;
    }
    QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null or params = null");
  }
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPreloadDownloadComplete url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" fileSize = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("VasUpdate_HttpImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((IPreDownloadController)((QQAppInterface)localObject).getRuntimeService(IPreDownloadController.class)).preDownloadSuccess(paramString, paramLong);
      return;
    }
    QLog.e("VasUpdate_HttpImpl", 1, "onPreloadDownloadComplete app is not QQAppInterface");
  }
  
  public void cancelDownload(String paramString)
  {
    if (a() == null)
    {
      QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null");
      return;
    }
    a().cancelTask(false, paramString);
  }
  
  public void startDownload(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener, Bundle paramBundle)
  {
    if ((a() != null) && (paramDownloadInfoParams != null))
    {
      this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener = paramIDownloadListener;
      if ((paramDownloadInfoParams.mFrom != null) && (paramDownloadInfoParams.mFrom.contains("silent_download")) && (paramBundle == null))
      {
        a(paramDownloadInfoParams, paramIDownloadListener);
        return;
      }
      paramIDownloadListener = new Bundle();
      paramIDownloadListener.putString("from", paramDownloadInfoParams.mFrom);
      a().startDownload(a(paramDownloadInfoParams), this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramIDownloadListener);
      return;
    }
    QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null  or params = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */