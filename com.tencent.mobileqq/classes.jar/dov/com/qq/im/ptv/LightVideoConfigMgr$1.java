package dov.com.qq.im.ptv;

import java.util.concurrent.atomic.AtomicReference;

final class LightVideoConfigMgr$1
  implements Runnable
{
  LightVideoConfigMgr$1(String paramString) {}
  
  public void run()
  {
    LightVideoConfigMgr localLightVideoConfigMgr = LightVideoConfigMgr.a(this.a);
    if (localLightVideoConfigMgr != null) {
      LightVideoConfigMgr.a().getAndSet(localLightVideoConfigMgr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoConfigMgr.1
 * JD-Core Version:    0.7.0.1
 */