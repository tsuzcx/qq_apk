package dov.com.qq.im.ae.camera.core;

import bbhm;
import bczn;
import bdbf;

class AECameraManager$8
  implements Runnable
{
  AECameraManager$8(AECameraManager paramAECameraManager, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (AECameraManager.access$300(this.this$0) == null) {
      return;
    }
    bczn localbczn = new bczn();
    localbczn.jdField_a_of_type_Float = this.val$x;
    localbczn.jdField_b_of_type_Float = this.val$y;
    localbczn.jdField_a_of_type_Int = this.val$surfaceWidth;
    localbczn.jdField_b_of_type_Int = this.val$surfaceHeight;
    localbczn.jdField_a_of_type_Alrq = AECameraManager.access$300(this.this$0);
    localbczn.c = bbhm.c(AECameraManager.access$1000(this.this$0));
    AECameraManager.access$800(this.this$0).a(localbczn, new AECameraManager.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */