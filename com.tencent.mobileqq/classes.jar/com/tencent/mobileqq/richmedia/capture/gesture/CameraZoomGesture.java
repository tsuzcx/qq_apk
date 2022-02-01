package com.tencent.mobileqq.richmedia.capture.gesture;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import java.math.BigDecimal;

public class CameraZoomGesture
  implements GLGestureListener
{
  public float a;
  public GLSurfaceView a;
  CameraZoomGesture.ZoomGestureListener a;
  private float b;
  private float c;
  
  public CameraZoomGesture(CameraZoomGesture.ZoomGestureListener paramZoomGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener = paramZoomGestureListener;
  }
  
  protected void a(int paramInt)
  {
    GLSurfaceView localGLSurfaceView = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
    if ((localGLSurfaceView instanceof CameraCaptureView)) {
      ((CameraCaptureView)localGLSurfaceView).setZoom(paramInt);
    }
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    float f1;
    float f2;
    if ((i == 1) && (paramBoolean))
    {
      if (j != 0)
      {
        if (j != 2) {
          return false;
        }
        f1 = paramMotionEvent.getY();
        f2 = this.jdField_a_of_type_Float;
        if (f1 >= f2)
        {
          this.c = f2;
          return false;
        }
        i = new BigDecimal((this.c - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
        CameraZoomGesture.ZoomGestureListener localZoomGestureListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener;
        if (localZoomGestureListener != null) {
          localZoomGestureListener.a(i);
        } else if ((i != 0) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
          a(i);
        }
        this.c = paramMotionEvent.getY();
        return false;
      }
      this.c = this.jdField_a_of_type_Float;
      return false;
    }
    if ((i == 2) && (!paramBoolean))
    {
      SLog.a("CameraZoomGesture", "onTouchEvent %s", new Object[] { paramMotionEvent });
      float f4;
      float f3;
      if (i == 2)
      {
        f4 = paramMotionEvent.getX(0);
        f1 = paramMotionEvent.getY(0);
        f2 = paramMotionEvent.getX(1);
        f3 = paramMotionEvent.getY(1);
      }
      else
      {
        f4 = paramMotionEvent.getX(1);
        f1 = paramMotionEvent.getY(1);
        f2 = paramMotionEvent.getX(2);
        f3 = paramMotionEvent.getY(2);
      }
      if (j != 2)
      {
        if (j != 5) {
          return false;
        }
        this.b = TakeVideoUtils.a(f4, f1, f2, f3);
        return false;
      }
      f1 = TakeVideoUtils.a(f4, f1, f2, f3);
      i = new BigDecimal((f1 - this.b) / 20.0F).setScale(0, 4).intValue();
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.a(i);
        return true;
      }
      if ((i != 0) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null))
      {
        a(i);
        this.b = f1;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture
 * JD-Core Version:    0.7.0.1
 */