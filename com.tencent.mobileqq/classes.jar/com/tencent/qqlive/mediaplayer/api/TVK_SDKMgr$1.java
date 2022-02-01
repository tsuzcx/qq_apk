package com.tencent.qqlive.mediaplayer.api;

import com.tencent.qqlive.mediaplayer.sdkupdate.d;

final class TVK_SDKMgr$1
  implements TVK_SDKMgr.InstallListener
{
  public void onInstallProgress(float paramFloat)
  {
    TVK_SDKMgr.a(paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    TVK_SDKMgr.a(paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    if (TVK_SDKMgr.a(TVK_SDKMgr.a()))
    {
      TVK_SDKMgr.b();
      if (TVK_SDKMgr.getProxyFactory() == null)
      {
        d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "loadDexFile succeed, but factory is null");
        TVK_SDKMgr.a(105);
        return;
      }
      d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "onInstalledSuccessed... ");
      TVK_SDKMgr.c();
      return;
    }
    d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "loadDexFile failed");
    TVK_SDKMgr.a(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.1
 * JD-Core Version:    0.7.0.1
 */