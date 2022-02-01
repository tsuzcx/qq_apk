package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy;

import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import java.io.File;

class KandianHostProxyBuilder$1$3
  implements SdkInfoInterface
{
  KandianHostProxyBuilder$1$3(KandianHostProxyBuilder.1 param1) {}
  
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
    return new File(KandianHostProxyBuilder.1.a(this.a), KandianHostProxyBuilder.1.b(this.a)).exists();
  }
  
  public boolean isWebActivityShowFloatWindow()
  {
    return false;
  }
  
  public boolean stopPlayingWhenRoomActivityStop()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy.KandianHostProxyBuilder.1.3
 * JD-Core Version:    0.7.0.1
 */