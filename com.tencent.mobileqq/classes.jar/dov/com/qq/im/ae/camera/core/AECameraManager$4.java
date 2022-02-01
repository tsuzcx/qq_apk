package dov.com.qq.im.ae.camera.core;

import bnho;
import bnhs;
import bnzb;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(bnho parambnho, int paramInt, bnhs parambnhs) {}
  
  public void run()
  {
    bnzb.b("AECameraManager", "[cameraManagerHandler] changeCamera " + this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 1))
    {
      bnzb.d("AECameraManager", "[cameraManagerHandler] changeCamera invalid camera: " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bnhs.a(bnho.a(this.this$0), bnho.a(this.this$0));
      return;
    }
    if ((bnho.a(this.this$0) != this.jdField_a_of_type_Int) && (bnho.a(this.this$0)))
    {
      bnzb.b("AECameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + bnho.a(this.this$0));
      bnho.a(this.this$0, false);
    }
    bnho.a(this.this$0, this.jdField_a_of_type_Int);
    bnho.a(this.this$0, this.jdField_a_of_type_Bnhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */