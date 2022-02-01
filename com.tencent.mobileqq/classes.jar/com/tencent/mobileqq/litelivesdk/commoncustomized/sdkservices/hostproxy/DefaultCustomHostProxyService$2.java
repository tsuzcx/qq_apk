package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy;

import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import java.io.File;

class DefaultCustomHostProxyService$2
  implements SdkInfoInterface
{
  DefaultCustomHostProxyService$2(DefaultCustomHostProxyService paramDefaultCustomHostProxyService) {}
  
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
    return false;
  }
  
  public boolean isFloatWindowShowWhenAppInBackground()
  {
    return false;
  }
  
  public boolean isFloatWindowShowWhenRoomFinish()
  {
    return false;
  }
  
  public boolean isTestEnv()
  {
    return new File(this.a.b, this.a.c).exists();
  }
  
  public boolean isWebActivityShowFloatWindow()
  {
    return false;
  }
  
  public boolean stopPlayingWhenRoomActivityStop()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy.DefaultCustomHostProxyService.2
 * JD-Core Version:    0.7.0.1
 */