package dov.com.qq.im.ae.camera.core;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.IEditableWatermarkMaterialRecover;
import dov.com.qq.im.ae.util.AEQLog;

class AECameraGLSurfaceView$6
  implements AEFilterProcessTex.IEditableWatermarkMaterialRecover
{
  AECameraGLSurfaceView$6(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void recover(VideoMaterial paramVideoMaterial)
  {
    AEQLog.b("AECameraGLSurfaceView", "EditableWatermarkMaterialRecover recover---");
    AECameraGLSurfaceView.access$502(this.this$0, null);
    this.this$0.setMaterial(paramVideoMaterial.getDataPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */