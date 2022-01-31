package com.tencent.mobileqq.richmedia.capture.gesture;

import agwj;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class CameraFocusGesture
  implements GLGestureListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  public CameraFocusView a;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 1000;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  private final int e;
  private final int f;
  
  public CameraFocusGesture(CameraFocusView paramCameraFocusView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = paramCameraFocusView;
    paramCameraFocusView = ViewConfiguration.get(paramCameraFocusView.getContext());
    this.jdField_d_of_type_Int = 300;
    this.e = ViewConfiguration.getDoubleTapTimeout();
    this.f = paramCameraFocusView.getScaledTouchSlop();
    this.jdField_a_of_type_Int = paramCameraFocusView.getScaledDoubleTapSlop();
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler = new agwj(this);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)paramFloat3 - (int)paramFloat1;
    int j = (int)paramFloat4 - (int)paramFloat2;
    return i * i + j * j > this.f * this.f;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 < this.jdField_d_of_type_Int;
  }
  
  public int a()
  {
    return 0;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    GLSurfaceView localGLSurfaceView = GLGestureProxy.a().a();
    if ((!paramBoolean) && (i == 1)) {}
    switch (j)
    {
    default: 
      if ((paramBoolean) && (i == 2)) {
        switch (j)
        {
        }
      }
      break;
    }
    do
    {
      return false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      break;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Float = paramMotionEvent.getX();
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
      if ((a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float)) || (!a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long)) || (localGLSurfaceView == null) || (!(localGLSurfaceView instanceof CameraCaptureView)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView == null) || (((CameraCaptureView)localGLSurfaceView).a() == 1)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      ((CameraCaptureView)localGLSurfaceView).a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      break;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX(1);
      this.jdField_b_of_type_Float = paramMotionEvent.getY(1);
      return false;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Float = paramMotionEvent.getX(1);
      this.jdField_d_of_type_Float = paramMotionEvent.getY(1);
    } while ((a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float)) || (!a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long)));
    paramMotionEvent = GLGestureProxy.a().a(paramMotionEvent);
    if ((localGLSurfaceView != null) && ((localGLSurfaceView instanceof CameraCaptureView)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (((CameraCaptureView)localGLSurfaceView).a() != 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      ((CameraCaptureView)localGLSurfaceView).a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == true" });
      }
    }
    paramMotionEvent.recycle();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture
 * JD-Core Version:    0.7.0.1
 */