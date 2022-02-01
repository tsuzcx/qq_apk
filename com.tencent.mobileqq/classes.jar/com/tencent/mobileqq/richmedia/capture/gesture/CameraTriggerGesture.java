package com.tencent.mobileqq.richmedia.capture.gesture;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.util.AEQLog;

public class CameraTriggerGesture
  implements GLGestureListener
{
  private int jdField_a_of_type_Int = 0;
  GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  
  public CameraTriggerGesture(GLSurfaceView paramGLSurfaceView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  public int onGetPriority()
  {
    return 1010;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramMotionEvent.getPointerCount() > 2) {
      return false;
    }
    AEQLog.a("GLGestureListener", "[gestureFix][CameraTriggerGesture]:onTouchEvent");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      do
      {
        return false;
      } while ((!(this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).hasTapEffect()));
      ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(), paramMotionEvent.getY() - this.jdField_a_of_type_Int);
      return true;
    } while ((!(this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof AECameraGLSurfaceView)) || (!((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).hasTapEffect()));
    ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setTapEvent(100, paramMotionEvent.getX(1) + paramMotionEvent.getRawX() - paramMotionEvent.getX(0), paramMotionEvent.getY(1) + paramMotionEvent.getRawY() - paramMotionEvent.getY(0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraTriggerGesture
 * JD-Core Version:    0.7.0.1
 */