package com.tencent.mobileqq.richmedia.capture.gesture;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class CameraProviderViewGesture
  implements GLGestureListener
{
  protected ProviderContainerView a;
  protected QIMProviderContainerView a;
  
  public CameraProviderViewGesture(ProviderContainerView paramProviderContainerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView = paramProviderContainerView;
  }
  
  public CameraProviderViewGesture(QIMProviderContainerView paramQIMProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = paramQIMProviderContainerView;
  }
  
  public int a()
  {
    return 1060;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean)) {
      switch (j & 0xFF)
      {
      }
    }
    for (;;)
    {
      return false;
      GLSurfaceView localGLSurfaceView = GLGestureProxy.a().a();
      if ((localGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) && (paramMotionEvent.getY() < localGLSurfaceView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.getHeight())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.e();
      }
      if ((localGLSurfaceView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (paramMotionEvent.getY() < localGLSurfaceView.getHeight() - this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.getHeight())) {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraProviderViewGesture
 * JD-Core Version:    0.7.0.1
 */