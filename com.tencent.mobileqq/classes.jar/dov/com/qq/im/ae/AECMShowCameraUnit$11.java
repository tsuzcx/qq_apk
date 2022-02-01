package dov.com.qq.im.ae;

import bmvk;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AEDetectorType;

public class AECMShowCameraUnit$11
  implements Runnable
{
  public AECMShowCameraUnit$11(bmvk parambmvk) {}
  
  public void run()
  {
    if (bmvk.a(this.this$0) != null) {
      bmvk.a(this.this$0).setAIParam(AEDetectorType.VOICE_RECOGNIZE.value, "extrawords", "shoot");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.11
 * JD-Core Version:    0.7.0.1
 */