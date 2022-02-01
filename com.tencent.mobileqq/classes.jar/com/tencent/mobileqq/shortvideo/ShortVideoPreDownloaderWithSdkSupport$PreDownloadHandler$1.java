package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.videoplatform.SDKInitListener;

class ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler$1
  implements SDKInitListener
{
  ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler$1(ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler paramPreDownloadHandler) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler.a(this.a);
    BaseSVReceiveOperator.a(this.a.b.a, ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler.1
 * JD-Core Version:    0.7.0.1
 */