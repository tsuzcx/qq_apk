package dov.com.qq.im.ae.camera.core;

import bann;
import bcgv;
import bcio;
import bnho;
import bnhq;

public class AECameraManager$8
  implements Runnable
{
  public AECameraManager$8(bnho parambnho, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bnho.a(this.this$0) == null) {
      return;
    }
    bcgv localbcgv = new bcgv();
    localbcgv.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    localbcgv.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    localbcgv.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbcgv.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbcgv.jdField_a_of_type_Alkl = bnho.a(this.this$0);
    localbcgv.c = bann.c(bnho.b(this.this$0));
    bnho.a(this.this$0).a(localbcgv, new bnhq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */