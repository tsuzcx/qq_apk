package dov.com.qq.im.ae.camera.core;

import blnq;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public abstract interface AECameraGLSurfaceView$AEEffectListener
{
  public abstract void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onSelectFaceEffect(VideoMaterial paramVideoMaterial);
  
  public abstract void onSetFilterProcess(blnq paramblnq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEEffectListener
 * JD-Core Version:    0.7.0.1
 */