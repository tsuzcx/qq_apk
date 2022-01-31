package dov.com.qq.im.ptv;

import bbgu;
import bjpq;
import bjps;
import bjpt;
import bjrl;

public class LightWeightCameraCaptureUnit$10
  implements Runnable
{
  public LightWeightCameraCaptureUnit$10(bjpq parambjpq, String paramString) {}
  
  public void run()
  {
    bjps localbjps = new bjps(this);
    bjpt localbjpt = new bjpt(this);
    bbgu.showPermissionSettingDialog(this.this$0.a.a(), null, this.a, localbjps, localbjps, localbjpt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.10
 * JD-Core Version:    0.7.0.1
 */