package dov.com.qq.im.ptv;

import avre;
import bjoz;
import com.tencent.qphone.base.util.QLog;

public class LightWeightCameraCaptureUnit$6
  implements Runnable
{
  public LightWeightCameraCaptureUnit$6(bjoz parambjoz) {}
  
  public void run()
  {
    boolean bool = bjoz.a(this.this$0).a(250, -1, null);
    QLog.i("LightWeightCameraCaptureUnit", 1, "(NEW)LaunchActivity to mClient.sendToService success: " + bool);
    if (!bool) {
      throw new RuntimeException("mClient.sendToService false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.6
 * JD-Core Version:    0.7.0.1
 */