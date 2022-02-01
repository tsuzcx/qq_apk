package dov.com.qq.im.ae.camera.core;

import allk;
import android.graphics.SurfaceTexture;
import bnho;
import bnzb;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(bnho parambnho, SurfaceTexture paramSurfaceTexture, allk paramallk) {}
  
  public void run()
  {
    if (!bnho.a(this.this$0))
    {
      bnzb.d("AECameraManager", "startCameraPreview EXIT: camera NOT created");
      return;
    }
    if (bnho.b(this.this$0))
    {
      bnzb.d("AECameraManager", "startCameraPreview EXIT: camera is already previewing");
      return;
    }
    bnho.a(this.this$0, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.jdField_a_of_type_Allk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */