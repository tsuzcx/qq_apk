package dov.com.qq.im.ptv;

import brkm;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

class LightWeightCaptureButtonLayout$DelayRefresh
  implements Runnable
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  
  LightWeightCaptureButtonLayout$DelayRefresh(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout, int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    float f2 = this.jdField_a_of_type_Float;
    float f1 = f2;
    if (f2 > 100.0F) {
      f1 = 100.0F;
    }
    f2 = f1;
    if (f1 < 0.0F) {
      f2 = 30.0F;
    }
    if (LightWeightCaptureButtonLayout.a(this.this$0)) {
      LightWeightCaptureButtonLayout.a(this.this$0).setSeed(System.nanoTime());
    }
    for (f1 = LightWeightCaptureButtonLayout.a(this.this$0).nextFloat();; f1 = f2 / 100.0F)
    {
      f2 = 2.0F + 28.0F * f1;
      this.this$0.a.setShadowStrokeWidth(brkm.a(f2));
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureLayout", 2, "onAudioFrames mIndex=" + this.jdField_a_of_type_Int + " volume=" + this.jdField_a_of_type_Float + " volumeSafe=" + f1 + " dipSize:" + f2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonLayout.DelayRefresh
 * JD-Core Version:    0.7.0.1
 */