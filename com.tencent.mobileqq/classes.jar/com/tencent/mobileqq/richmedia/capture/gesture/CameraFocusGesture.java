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
  int a;
  int b;
  CameraFocusGesture.FocusGestureListener c;
  private CameraFocusView d;
  private final int e;
  private long f;
  private long g;
  private final int h;
  private float i;
  private float j;
  private float k;
  private float l;
  
  public CameraFocusGesture(Context paramContext, CameraFocusGesture.FocusGestureListener paramFocusGestureListener)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.e = 300;
    this.h = paramContext.getScaledTouchSlop();
    this.a = paramContext.getScaledDoubleTapSlop();
    int m = this.a;
    this.b = (m * m);
    this.c = paramFocusGestureListener;
  }
  
  private void a(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m != 0)
    {
      if (m != 1) {
        return;
      }
      this.g = System.currentTimeMillis();
      this.k = paramMotionEvent.getX();
      this.l = paramMotionEvent.getY();
      if ((!a(this.i, this.j, this.k, this.l)) && (a(this.f, this.g)))
      {
        CameraFocusGesture.FocusGestureListener localFocusGestureListener = this.c;
        if (localFocusGestureListener != null)
        {
          localFocusGestureListener.a(paramMotionEvent);
          return;
        }
        b(paramMotionEvent, paramGLSurfaceView);
      }
    }
    else
    {
      this.f = System.currentTimeMillis();
      this.i = paramMotionEvent.getX();
      this.j = paramMotionEvent.getY();
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int m = (int)paramFloat3 - (int)paramFloat1;
    int n = (int)paramFloat4 - (int)paramFloat2;
    int i1 = this.h;
    return m * m + n * n > i1 * i1;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 < this.e;
  }
  
  private void b(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    if (((paramGLSurfaceView instanceof CameraCaptureView)) && (this.d != null))
    {
      paramGLSurfaceView = (CameraCaptureView)paramGLSurfaceView;
      if (paramGLSurfaceView.getSelectedCamera() != 1)
      {
        this.d.a(paramMotionEvent);
        a(paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (QLog.isColorLevel()) {
          QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
        }
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m != 5)
    {
      if (m != 6) {
        return;
      }
      this.g = System.currentTimeMillis();
      this.k = paramMotionEvent.getX(1);
      this.l = paramMotionEvent.getY(1);
      if ((!a(this.i, this.j, this.k, this.l)) && (a(this.f, this.g)))
      {
        paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
        CameraFocusGesture.FocusGestureListener localFocusGestureListener = this.c;
        if (localFocusGestureListener != null) {
          localFocusGestureListener.a(paramMotionEvent);
        } else {
          d(paramMotionEvent, paramGLSurfaceView);
        }
        paramMotionEvent.recycle();
      }
    }
    else
    {
      this.f = System.currentTimeMillis();
      this.i = paramMotionEvent.getX(1);
      this.j = paramMotionEvent.getY(1);
    }
  }
  
  private void d(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    if (((paramGLSurfaceView instanceof CameraCaptureView)) && (this.d != null))
    {
      paramGLSurfaceView = (CameraCaptureView)paramGLSurfaceView;
      if (paramGLSurfaceView.getSelectedCamera() != 1)
      {
        this.d.a(paramMotionEvent);
        a(paramGLSurfaceView, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (QLog.isColorLevel()) {
          QLog.d("GLGestureListener", 2, new Object[] { "", "CameraFocusGesture isRecording == true" });
        }
      }
    }
    paramMotionEvent.recycle();
  }
  
  private boolean e(MotionEvent paramMotionEvent, GLSurfaceView paramGLSurfaceView)
  {
    int[] arrayOfInt = new int[2];
    paramGLSurfaceView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = arrayOfInt[1];
    int i1 = paramGLSurfaceView.getWidth();
    int i2 = paramGLSurfaceView.getHeight();
    if ((paramMotionEvent.getRawX() >= m) && (paramMotionEvent.getRawX() <= m + i1) && (paramMotionEvent.getRawY() >= n)) {
      return paramMotionEvent.getRawY() <= n + i2;
    }
    return false;
  }
  
  public void a()
  {
    CameraFocusView localCameraFocusView = this.d;
    if (localCameraFocusView != null) {
      localCameraFocusView.a();
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
    int m = paramMotionEvent.getPointerCount();
    GLSurfaceView localGLSurfaceView = GLGestureProxy.getInstance().getGLSurfaceView();
    if (!e(paramMotionEvent, localGLSurfaceView)) {
      return false;
    }
    if ((!paramBoolean) && (m == 1)) {
      a(paramMotionEvent, localGLSurfaceView);
    }
    if ((paramBoolean) && (m == 2)) {
      c(paramMotionEvent, localGLSurfaceView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture
 * JD-Core Version:    0.7.0.1
 */