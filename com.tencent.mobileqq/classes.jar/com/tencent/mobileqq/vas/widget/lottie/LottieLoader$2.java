package com.tencent.mobileqq.vas.widget.lottie;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class LottieLoader$2
  implements Downloader.DownloadListener
{
  LottieLoader$2(LottieLoader paramLottieLoader, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("diy data download fail url = ");
      paramDownloadResult.append(paramString);
      QLog.i("LottieLoader", 2, paramDownloadResult.toString());
    }
    paramDownloadResult = this.this$0;
    paramDownloadResult.mState = 2;
    paramDownloadResult.onDownloadFinish(false, paramString, this.val$filePath, this.val$folder);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("diy data download success url = ");
      paramDownloadResult.append(paramString);
      QLog.i("LottieLoader", 2, paramDownloadResult.toString());
    }
    this.this$0.onDownloadFinish(true, paramString, this.val$filePath, this.val$folder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.widget.lottie.LottieLoader.2
 * JD-Core Version:    0.7.0.1
 */