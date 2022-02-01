package dov.com.qq.im.ae.camera.core;

import bbgg;
import bczn;
import bdbg;
import boiw;
import boiy;

public class AECameraManager$8
  implements Runnable
{
  public AECameraManager$8(boiw paramboiw, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (boiw.a(this.this$0) == null) {
      return;
    }
    bczn localbczn = new bczn();
    localbczn.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    localbczn.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    localbczn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbczn.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbczn.jdField_a_of_type_Alwd = boiw.a(this.this$0);
    localbczn.c = bbgg.c(boiw.b(this.this$0));
    boiw.a(this.this$0).a(localbczn, new boiy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */