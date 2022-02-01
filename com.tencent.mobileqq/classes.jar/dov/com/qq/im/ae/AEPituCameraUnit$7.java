package dov.com.qq.im.ae;

import android.graphics.SurfaceTexture;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.util.AEQLog;

class AEPituCameraUnit$7
  implements AECameraGLSurfaceView.AEGLSurfaceListener
{
  AEPituCameraUnit$7(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onDrawFrameWithEffect(int paramInt, AEFilterManager paramAEFilterManager)
  {
    this.a.a(paramInt, paramAEFilterManager);
  }
  
  public void onFirstFrameDone()
  {
    AELaunchRecorder.a().a("onFirstFrameDone");
    this.a.a();
  }
  
  public void onOrientionChanged(int paramInt)
  {
    this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setActivityOrientation(paramInt);
  }
  
  public void onPreviewSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setFocusOperatorMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onPreviewSurfaceTextureCreate(SurfaceTexture paramSurfaceTexture)
  {
    this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    AEQLog.b(this.a.b, "onPreviewSurfaceTextureCreate---" + this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.a.t();
  }
  
  public void onPreviewSurfaceTextureRelease()
  {
    AEQLog.b(this.a.b, "onPreviewSurfaceTextureRelease---" + this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.7
 * JD-Core Version:    0.7.0.1
 */