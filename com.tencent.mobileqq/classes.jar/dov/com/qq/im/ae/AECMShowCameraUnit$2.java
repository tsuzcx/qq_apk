package dov.com.qq.im.ae;

import bmvk;
import bmvm;
import bnis;
import dov.com.qq.im.ae.cmshow.config.AECMShowConfig;

public class AECMShowCameraUnit$2
  implements Runnable
{
  public AECMShowCameraUnit$2(bmvk parambmvk) {}
  
  public void run()
  {
    bnis.a(AECMShowConfig.ESSENTIAL_RESOURCE_ID_LIST, new bmvm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */