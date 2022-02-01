package com.tencent.mobileqq.imaxad;

import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ImaxAdVideoPreloadManager$2
  implements TVK_SDKMgr.InstallListener
{
  ImaxAdVideoPreloadManager$2(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ImaxAdUtil.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    ImaxAdUtil.b("installSDK onInstalledSuccessed");
    ImaxAdVideoPreloadManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */