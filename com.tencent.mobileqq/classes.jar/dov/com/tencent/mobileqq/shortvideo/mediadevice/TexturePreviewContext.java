package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.SystemClock;
import android.util.Log;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;

@TargetApi(14)
public class TexturePreviewContext
  extends PreviewContext
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener
{
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  CameraState jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState = new CameraState();
  private int b;
  
  public TexturePreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    super(paramCameraProxy, paramInt1, paramInt2);
    NewFlowCameraReporter.a("TexturePreviewContext");
  }
  
  public void a()
  {
    b();
    if ((this.mCamera != null) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.c))
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.c = true;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.a = false;
      this.mCamera.b(false);
    }
  }
  
  public void b()
  {
    if ((this.mCamera != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.a)) {
      this.mCamera.b();
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.a = false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.b)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.c)
      {
        NewFlowCameraReporter.a("setup camera");
        this.mCamera.a();
        this.mCamera.a(0, this.jdField_a_of_type_Int, this.b);
        this.mCamera.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.mCamera.a(this, true);
      }
      NewFlowCameraReporter.a("start preview");
      NewFlowCameraReporter.c();
      this.mCamera.c();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.c = false;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    NewFlowCameraReporter.a("on texture available");
    if (BaseApplicationImpl.sShowTime > 0L)
    {
      NewFlowCameraReporter.d = SystemClock.uptimeMillis();
      long l1 = NewFlowCameraReporter.d;
      long l2 = BaseApplicationImpl.sShowTime;
      Log.i("AutoMonitor", "ActionLoginShow, cost=" + (l1 - l2));
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.b = true;
    if (FlowCameraMqqAction.a())
    {
      NewFlowCameraReporter.a("camera being used by av, return");
      return;
    }
    c();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    NewFlowCameraReporter.a("onSurfaceTextureDestroyed");
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.b = false;
    a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.b = true;
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceCameraState.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext
 * JD-Core Version:    0.7.0.1
 */