package dov.com.qq.im.ae.camera.core;

import babd;
import bbss;
import bbuk;

class AECameraManager$8
  implements Runnable
{
  AECameraManager$8(AECameraManager paramAECameraManager, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (AECameraManager.access$300(this.this$0) == null) {
      return;
    }
    bbss localbbss = new bbss();
    localbbss.jdField_a_of_type_Float = this.val$x;
    localbbss.jdField_b_of_type_Float = this.val$y;
    localbbss.jdField_a_of_type_Int = this.val$surfaceWidth;
    localbbss.jdField_b_of_type_Int = this.val$surfaceHeight;
    localbbss.jdField_a_of_type_Aktu = AECameraManager.access$300(this.this$0);
    localbbss.c = babd.c(AECameraManager.access$1000(this.this$0));
    AECameraManager.access$800(this.this$0).a(localbbss, new AECameraManager.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */