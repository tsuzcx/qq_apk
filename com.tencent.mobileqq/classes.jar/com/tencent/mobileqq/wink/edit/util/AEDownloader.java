package com.tencent.mobileqq.wink.edit.util;

import android.support.annotation.WorkerThread;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.QQWinkEnvironment;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.io.File;
import mqq.app.AppRuntime;

public class AEDownloader
{
  public static AEDownloader a()
  {
    return AEDownloader.InstanceHolder.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realDownload---url=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", saveName=");
    ((StringBuilder)localObject).append(paramString2);
    WinkQLog.b("AEDownloader", ((StringBuilder)localObject).toString());
    if (QQWinkEnvironment.b() == null)
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
      WinkQLog.d("AEDownloader", "realDownload---FAIL appInterface is null");
      return;
    }
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new AEDownloader.InnerDownloadListener(paramString1, paramString2, paramDownloadListener);
    ((HttpNetReq)localObject).mReqUrl = paramString1;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = new File(paramString2).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject).mExcuteTimeLimit = 60000L;
    try
    {
      ((IHttpEngineService)QQWinkEnvironment.b().getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      WinkQLog.a("AEDownloader", "realDownload---exception: ", paramString1);
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    b(paramString1, paramString2, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.util.AEDownloader
 * JD-Core Version:    0.7.0.1
 */