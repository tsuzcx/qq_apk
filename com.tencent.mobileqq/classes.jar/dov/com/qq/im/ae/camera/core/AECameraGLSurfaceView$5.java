package dov.com.qq.im.ae.camera.core;

import bnbc;
import bnrh;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AECameraGLSurfaceView$5
  implements bnbc
{
  AECameraGLSurfaceView$5(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void recover(VideoMaterial paramVideoMaterial)
  {
    bnrh.b("AECameraGLSurfaceView", "EditableWatermarkMaterialRecover recover---");
    AECameraGLSurfaceView.access$502(this.this$0, null);
    this.this$0.setMaterial(paramVideoMaterial.getDataPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */