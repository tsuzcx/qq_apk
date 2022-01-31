package com.tencent.mobileqq.richmedia.capture.gesture;

import ahko;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.sveffects.SLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GLGestureProxy
{
  public static String a;
  private int jdField_a_of_type_Int;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private View jdField_a_of_type_AndroidViewView;
  private List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GLGestureProxy";
  }
  
  public static final GLGestureProxy a()
  {
    return ahko.a();
  }
  
  public static String a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
      return "";
    case 1: 
      return "MotionEvent.ACTION_UP";
    case 0: 
      return "MotionEvent.ACTION_DOWN";
    case 2: 
      return "MotionEvent.ACTION_MOVE";
    case 6: 
      return "MotionEvent.ACTION_POINTER_UP";
    case 5: 
      return "MotionEvent.ACTION_POINTER_DOWN";
    }
    return "MotionEvent.ACTION_CANCEL";
  }
  
  public float a(float paramFloat)
  {
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    }
    for (float f = arrayOfInt[0] + paramFloat;; f = paramFloat)
    {
      if (SLog.a()) {
        SLog.d(jdField_a_of_type_JavaLangString, "getScreenCoordinateX x=" + paramFloat + " touchX=" + f);
      }
      return f;
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public GLSurfaceView a()
  {
    return this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
  }
  
  public MotionEvent a(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int[] arrayOfInt = new int[2];
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    }
    int m = paramMotionEvent.getAction();
    int j = (int)(arrayOfInt[0] + paramMotionEvent.getX(1));
    int k = (int)(arrayOfInt[1] + paramMotionEvent.getY(1));
    long l = SystemClock.uptimeMillis();
    switch (m & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      i = -1;
    }
    for (;;)
    {
      paramMotionEvent = MotionEvent.obtain(l, l, i, j, k, 0);
      if (SLog.a()) {
        SLog.b(jdField_a_of_type_JavaLangString, "getSingleFingerMotionEvent =" + paramMotionEvent.toString());
      }
      return paramMotionEvent;
      i = 0;
      continue;
      i = 2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
  }
  
  public void a(GLGestureListener paramGLGestureListener)
  {
    if (paramGLGestureListener == null) {
      return;
    }
    int k = paramGLGestureListener.a();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramGLGestureListener);
      return;
    }
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    int j = -1;
    while ((i < m) && (k >= ((GLGestureListener)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
    {
      j = i + 1;
      i += 1;
    }
    if (j == -1)
    {
      this.jdField_a_of_type_JavaUtilList.add(0, paramGLGestureListener);
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(j, paramGLGestureListener);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction();
    if (paramMotionEvent.getPointerCount() == 2) {}
    switch (i & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      bool = false;
    }
    return bool;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, GLSurfaceView paramGLSurfaceView)
  {
    if (SLog.a()) {
      SLog.b(jdField_a_of_type_JavaLangString, "MotionEvent pointCnt= " + paramMotionEvent.getPointerCount() + " action=" + a(paramMotionEvent) + " isRecording=" + paramBoolean);
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOpenglGLSurfaceView.getWidth();
      this.b = this.jdField_a_of_type_AndroidOpenglGLSurfaceView.getHeight();
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      if (((GLGestureListener)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramMotionEvent, paramBoolean)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean a(GLGestureListener paramGLGestureListener)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramGLGestureListener);
  }
  
  public float b(float paramFloat)
  {
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    }
    for (float f = arrayOfInt[1] + paramFloat;; f = paramFloat)
    {
      if (SLog.a()) {
        SLog.d(jdField_a_of_type_JavaLangString, "getScreenCoordinateY y=" + paramFloat + " touchY=" + f);
      }
      return f;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(GLGestureListener paramGLGestureListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramGLGestureListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramGLGestureListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy
 * JD-Core Version:    0.7.0.1
 */