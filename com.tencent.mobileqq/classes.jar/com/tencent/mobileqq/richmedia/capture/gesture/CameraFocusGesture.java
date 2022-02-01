package com.tencent.mobileqq.richmedia.capture.gesture;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class CameraFocusGesture
  implements GLGestureListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private CameraFocusView jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView;
  CameraFocusGesture.FocusGestureListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  
  public CameraFocusGesture(Context paramContext, CameraFocusGesture.FocusGestureListener paramFocusGestureListener)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_c_of_type_Int = 300;
    this.jdField_d_of_type_Int = paramContext.getScaledTouchSlop();
    this.jdField_a_of_type_Int = paramContext.getScaledDoubleTapSlop();
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener = paramFocusGestureListener;
  }
  
  private void a(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Float = paramMotionEvent.getX();
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
    } while ((a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float)) || (!a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long)));
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener.a(paramMotionEvent);
      return;
    }
    b(paramMotionEvent, paramGLSurfaceView);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)paramFloat3 - (int)paramFloat1;
    int j = (int)paramFloat4 - (int)paramFloat2;
    return i * i + j * j > this.jdField_d_of_type_Int * this.jdField_d_of_type_Int;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 < this.jdField_c_of_type_Int;
  }
  
  private boolean a(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    boolean bool = true;
    int[] arrayOfInt = new int[2];
    paramGLSurfaceView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramGLSurfaceView.getWidth();
    int m = paramGLSurfaceView.getHeight();
    if ((paramMotionEvent.getRawX() < i) || (paramMotionEvent.getRawX() > i + k) || (paramMotionEvent.getRawY() < j) || (paramMotionEvent.getRawY() > j + m)) {
      bool = false;
    }
    return bool;
  }
  
  private void b(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    if (((paramGLSurfaceView instanceof CameraCaptureView)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (((CameraCaptureView)paramGLSurfaceView).a() != 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      a((CameraCaptureView)paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX(1);
      this.jdField_b_of_type_Float = paramMotionEvent.getY(1);
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Float = paramMotionEvent.getX(1);
      this.jdField_d_of_type_Float = paramMotionEvent.getY(1);
    } while ((a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float)) || (!a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long)));
    paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener.a(paramMotionEvent);
    }
    for (;;)
    {
      paramMotionEvent.recycle();
      return;
      d(paramMotionEvent, paramGLSurfaceView);
    }
  }
  
  private void d(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    if (((paramGLSurfaceView instanceof CameraCaptureView)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (((CameraCaptureView)paramGLSurfaceView).a() != 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      a((CameraCaptureView)paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == true" });
      }
    }
    paramMotionEvent.recycle();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a();
    }
  }
  
  protected void a(CameraCaptureView paramCameraCaptureView, float paramFloat1, float paramFloat2)
  {
    paramCameraCaptureView.a(paramFloat1, paramFloat2);
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    GLSurfaceView localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
    if (!a(paramMotionEvent, localGLSurfaceView)) {}
    do
    {
      return false;
      if ((!paramBoolean) && (i == 1)) {
        a(paramMotionEvent, localGLSurfaceView);
      }
    } while ((!paramBoolean) || (i != 2));
    c(paramMotionEvent, localGLSurfaceView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture
 * JD-Core Version:    0.7.0.1
 */