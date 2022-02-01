package dov.com.qq.im.ae;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;
import org.light.listener.IOnClickWatermarkListener;

class AEPituCameraUnit$9
  implements IOnClickWatermarkListener
{
  AEPituCameraUnit$9(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onClickWatermark()
  {
    AEQLog.a(this.a.b, "onClickWatermark");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.9
 * JD-Core Version:    0.7.0.1
 */