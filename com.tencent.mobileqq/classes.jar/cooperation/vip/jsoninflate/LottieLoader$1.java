package cooperation.vip.jsoninflate;

import com.tencent.TMG.utils.QLog;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class LottieLoader$1
  implements Downloader.DownloadListener
{
  LottieLoader$1(LottieLoader paramLottieLoader, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("diy data download fail url = ");
      paramDownloadResult.append(paramString);
      QLog.i("LottieLoader", 0, paramDownloadResult.toString());
    }
    LottieLoader.a(this.c, 2);
    LottieLoader.a(this.c, false, paramString, this.a, this.b);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("diy data download success url = ");
      paramDownloadResult.append(paramString);
      QLog.i("LottieLoader", 0, paramDownloadResult.toString());
    }
    LottieLoader.b(this.c, true, paramString, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.LottieLoader.1
 * JD-Core Version:    0.7.0.1
 */