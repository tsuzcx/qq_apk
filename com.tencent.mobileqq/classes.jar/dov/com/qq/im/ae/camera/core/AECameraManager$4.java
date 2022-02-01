package dov.com.qq.im.ae.camera.core;

import boiw;
import boja;
import bpam;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(boiw paramboiw, int paramInt, boja paramboja) {}
  
  public void run()
  {
    bpam.b("AECameraManager", "[cameraManagerHandler] changeCamera " + this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 1))
    {
      bpam.d("AECameraManager", "[cameraManagerHandler] changeCamera invalid camera: " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boja.a(boiw.a(this.this$0), boiw.a(this.this$0));
      return;
    }
    if ((boiw.a(this.this$0) != this.jdField_a_of_type_Int) && (boiw.a(this.this$0)))
    {
      bpam.b("AECameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + boiw.a(this.this$0));
      boiw.a(this.this$0, false);
    }
    boiw.a(this.this$0, this.jdField_a_of_type_Int);
    boiw.a(this.this$0, this.jdField_a_of_type_Boja);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */