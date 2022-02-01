package dov.com.qq.im.ae.camera.core;

import alxc;
import android.graphics.SurfaceTexture;
import boiw;
import bpam;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(boiw paramboiw, SurfaceTexture paramSurfaceTexture, alxc paramalxc) {}
  
  public void run()
  {
    if (!boiw.a(this.this$0))
    {
      bpam.d("AECameraManager", "startCameraPreview EXIT: camera NOT created");
      return;
    }
    if (boiw.b(this.this$0))
    {
      bpam.d("AECameraManager", "startCameraPreview EXIT: camera is already previewing");
      return;
    }
    boiw.a(this.this$0, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.jdField_a_of_type_Alxc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */