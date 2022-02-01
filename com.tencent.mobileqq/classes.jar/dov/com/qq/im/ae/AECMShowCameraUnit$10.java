package dov.com.qq.im.ae;

import bmvk;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AEDetectorType;

public class AECMShowCameraUnit$10
  implements Runnable
{
  public AECMShowCameraUnit$10(bmvk parambmvk) {}
  
  public void run()
  {
    if (bmvk.a(this.this$0) != null) {
      bmvk.a(this.this$0).setAIParam(AEDetectorType.VOICE_RECOGNIZE.value, "extrawords", "triggerState");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.10
 * JD-Core Version:    0.7.0.1
 */