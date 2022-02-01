package dov.com.qq.im.ae.camera.core;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import java.util.HashMap;

public abstract interface AECameraGLSurfaceView$AEEffectListener
{
  public abstract void onAssetProcessingData(HashMap<String, String> paramHashMap);
  
  public abstract void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onHideNormalTip();
  
  public abstract void onHidePagTip();
  
  public abstract void onSelectFaceEffect(VideoMaterial paramVideoMaterial);
  
  public abstract void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex);
  
  public abstract void onShowNormalTip(String paramString1, String paramString2, int paramInt);
  
  public abstract void onShowPagTip(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
 * JD-Core Version:    0.7.0.1
 */