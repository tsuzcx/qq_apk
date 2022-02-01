package dov.com.qq.im.ae.camera.core;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.util.AEQLog;

class AECameraGLSurfaceView$17$6
  implements Runnable
{
  AECameraGLSurfaceView$17$6(AECameraGLSurfaceView.17 param17, VideoMaterial paramVideoMaterial, AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void run()
  {
    AEQLog.d("AECameraGLSurfaceView", "[setVideoMaterial] update material" + this.val$videoMaterial.getId());
    this.val$aeFilterProcessTex.a(this.val$videoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.17.6
 * JD-Core Version:    0.7.0.1
 */