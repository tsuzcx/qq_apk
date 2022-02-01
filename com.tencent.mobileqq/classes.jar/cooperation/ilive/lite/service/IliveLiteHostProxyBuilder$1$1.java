package cooperation.ilive.lite.service;

import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import java.io.File;

class IliveLiteHostProxyBuilder$1$1
  implements SdkInfoInterface
{
  IliveLiteHostProxyBuilder$1$1(IliveLiteHostProxyBuilder.1 param1) {}
  
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
    return new File(IliveLiteHostProxyBuilder.1.a(this.a), IliveLiteHostProxyBuilder.1.b(this.a)).exists();
  }
  
  public boolean isWebActivityShowFloatWindow()
  {
    return true;
  }
  
  public boolean stopPlayingWhenRoomActivityStop()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveLiteHostProxyBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */