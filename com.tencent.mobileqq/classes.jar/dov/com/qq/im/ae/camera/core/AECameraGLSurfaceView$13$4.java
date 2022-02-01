package dov.com.qq.im.ae.camera.core;

import blnq;
import bmbx;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$13$4
  implements Runnable
{
  AECameraGLSurfaceView$13$4(AECameraGLSurfaceView.13 param13, VideoMaterial paramVideoMaterial, blnq paramblnq) {}
  
  public void run()
  {
    bmbx.d("AECameraGLSurfaceView", "[setVideoMaterial] update material" + this.val$videoMaterial.getId());
    this.val$aeFilterProcessTex.a(this.val$videoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.13.4
 * JD-Core Version:    0.7.0.1
 */