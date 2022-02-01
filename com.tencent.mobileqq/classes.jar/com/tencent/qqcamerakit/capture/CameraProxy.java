package com.tencent.qqcamerakit.capture;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import com.tencent.qqcamerakit.common.Observer;

public class CameraProxy
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private CameraManager jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager;
  
  public CameraProxy(Context paramContext, Handler paramHandler)
  {
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager = new CameraManager(paramHandler, true);
  }
  
  public CameraProxy(Context paramContext, Handler paramHandler, boolean paramBoolean)
  {
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager = new CameraManager(paramHandler, paramBoolean);
  }
  
  public static Context a()
  {
    return jdField_a_of_type_AndroidContentContext;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramInt);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramActivity, paramBoolean);
  }
  
  public void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramMatrix, paramCameraAutoFocusCallBack, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramSurfaceTexture, paramCameraPreviewCallBack);
  }
  
  public void a(CameraSize paramCameraSize, int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramCameraSize, paramCameraSize, paramCameraSize, paramInt);
  }
  
  public void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramCameraSize1, paramCameraSize2, paramCameraSize3, paramInt);
  }
  
  public void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramCameraSize, paramBoolean, paramString, paramInt, paramPictureCallback);
  }
  
  public void a(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.b(paramInt);
  }
  
  public void b(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.b(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.b(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraManager.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraProxy
 * JD-Core Version:    0.7.0.1
 */