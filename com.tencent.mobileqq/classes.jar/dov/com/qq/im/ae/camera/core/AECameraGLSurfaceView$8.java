package dov.com.qq.im.ae.camera.core;

import android.util.Log;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AECameraGLSurfaceView$8
  implements LightAssetListener
{
  AECameraGLSurfaceView$8(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    Log.d("AECameraGLSurfaceView", "OnAssetProcessing: " + paramHashMap);
    if (this.this$0.effectListener != null) {
      this.this$0.effectListener.onAssetProcessingData(paramHashMap);
    }
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    AEQLog.d("AECameraGLSurfaceView", "OnLoadAssetError: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.8
 * JD-Core Version:    0.7.0.1
 */