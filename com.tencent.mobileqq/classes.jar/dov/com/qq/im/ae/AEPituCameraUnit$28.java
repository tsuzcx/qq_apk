package dov.com.qq.im.ae;

import dov.com.qq.im.ae.camera.ui.watermark.WatermarkOnlineUserManager;
import dov.com.qq.im.ae.util.AEQLog;
import org.light.listener.WatermarkDelegate;

class AEPituCameraUnit$28
  implements WatermarkDelegate
{
  AEPituCameraUnit$28(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public String getData(String paramString)
  {
    AEQLog.a(this.a.b, "watermark回调: getData:" + paramString);
    if (paramString.equalsIgnoreCase("watermark.qq.online"))
    {
      AEQLog.a(this.a.b, "watermark回调: getData,获取在线人数:" + WatermarkOnlineUserManager.a().a());
      return String.valueOf(WatermarkOnlineUserManager.a().a());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.28
 * JD-Core Version:    0.7.0.1
 */