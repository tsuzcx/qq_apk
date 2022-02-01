package dov.com.qq.im.ae.util;

import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import java.io.File;

public class AEDownloader
{
  public static AEDownloader a()
  {
    return AEDownloader.InstanceHolder.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    AEQLog.b("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = CaptureContext.a();
    if (localAppInterface == null)
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.a(null);
      }
      AEQLog.d("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new AEDownloader.InnerDownloadListener(paramString1, paramString2, paramDownloadListener);
      localHttpNetReq.mReqUrl = paramString1;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(paramString2).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        AEQLog.a("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (paramDownloadListener == null);
    paramDownloadListener.a(null);
  }
  
  public void a(String paramString1, String paramString2, AEDownloader.DownloadListener paramDownloadListener)
  {
    b(paramString1, paramString2, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.util.AEDownloader
 * JD-Core Version:    0.7.0.1
 */