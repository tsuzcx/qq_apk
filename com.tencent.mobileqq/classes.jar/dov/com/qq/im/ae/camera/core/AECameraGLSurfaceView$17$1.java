package dov.com.qq.im.ae.camera.core;

import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;

class AECameraGLSurfaceView$17$1
  implements Runnable
{
  AECameraGLSurfaceView$17$1(AECameraGLSurfaceView.17 param17, AEFilterProcessTex paramAEFilterProcessTex) {}
  
  public void run()
  {
    this.val$aeFilterProcessTex.a(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.17.1
 * JD-Core Version:    0.7.0.1
 */