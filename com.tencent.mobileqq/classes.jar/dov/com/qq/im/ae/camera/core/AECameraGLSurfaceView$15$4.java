package dov.com.qq.im.ae.camera.core;

import bnaz;
import bnrh;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$15$4
  implements Runnable
{
  AECameraGLSurfaceView$15$4(AECameraGLSurfaceView.15 param15, VideoMaterial paramVideoMaterial, bnaz parambnaz) {}
  
  public void run()
  {
    bnrh.d("AECameraGLSurfaceView", "[setVideoMaterial] update material" + this.val$videoMaterial.getId());
    this.val$aeFilterProcessTex.a(this.val$videoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.15.4
 * JD-Core Version:    0.7.0.1
 */