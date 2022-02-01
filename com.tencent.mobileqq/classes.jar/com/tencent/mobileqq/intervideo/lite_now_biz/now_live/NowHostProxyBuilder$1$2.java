package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import java.io.File;

class NowHostProxyBuilder$1$2
  implements SdkInfoInterface
{
  NowHostProxyBuilder$1$2(NowHostProxyBuilder.1 param1) {}
  
  public boolean aekitResAsyncLoad()
  {
    return false;
  }
  
  public boolean disableExternalMiniCard()
  {
    return false;
  }
  
  public void floatWindowPermissionRequestResult(boolean paramBoolean) {}
  
  public boolean isBackgroundPlay()
  {
    return this.a.a();
  }
  
  public boolean isFloatWindowEnabled()
  {
    return true;
  }
  
  public boolean isFloatWindowShowWhenAppInBackground()
  {
    return true;
  }
  
  public boolean isFloatWindowShowWhenRoomFinish()
  {
    return false;
  }
  
  public boolean isTestEnv()
  {
    return new File(NowHostProxyBuilder.1.a(this.a), NowHostProxyBuilder.1.b(this.a)).exists();
  }
  
  public boolean isWebActivityShowFloatWindow()
  {
    return true;
  }
  
  public boolean stopPlayingWhenRoomActivityStop()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowHostProxyBuilder.1.2
 * JD-Core Version:    0.7.0.1
 */