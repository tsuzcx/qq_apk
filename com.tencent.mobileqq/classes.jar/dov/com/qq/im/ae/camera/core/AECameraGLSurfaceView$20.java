package dov.com.qq.im.ae.camera.core;

import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager.IWatermarkDictCallback;
import java.util.Map;

class AECameraGLSurfaceView$20
  implements WatermarkDataManager.IWatermarkDictCallback
{
  AECameraGLSurfaceView$20(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onGetWatermarkDict(Map<String, String> paramMap)
  {
    this.this$0.queueEvent(new AECameraGLSurfaceView.20.1(this, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.20
 * JD-Core Version:    0.7.0.1
 */