package com.tencent.mobileqq.qqlive.filter.download;

import androidx.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqlive.utils.QQLiveCaptureContext;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQLiveBaseDownloader
{
  public static QQLiveBaseDownloader a()
  {
    return QQLiveBaseDownloader.InstanceHolder.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, QQLiveBaseDownloader.DownloadListener paramDownloadListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[realDownload] url=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", saveName=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("QQLiveFilterDownloader", 4, ((StringBuilder)localObject).toString());
    localObject = QQLiveCaptureContext.a();
    if (localObject == null)
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
      QLog.e("QQLiveFilterDownloader", 4, "[realDownload] appInterface is null");
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new QQLiveBaseDownloader.InnerNetEngineDownloadListener(paramString1, paramString2, paramDownloadListener);
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(paramString2).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 60000L;
    try
    {
      ((IHttpEngineService)((AppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        paramString1.printStackTrace();
      }
      QLog.e("QQLiveFilterDownloader", 4, new Object[] { "[realDownload] get IHttpEngineService exception: ", paramString1.getMessage() });
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, QQLiveBaseDownloader.DownloadListener paramDownloadListener)
  {
    b(paramString1, paramString2, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveBaseDownloader
 * JD-Core Version:    0.7.0.1
 */