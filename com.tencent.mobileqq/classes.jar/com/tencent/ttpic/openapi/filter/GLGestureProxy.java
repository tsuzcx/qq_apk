package com.tencent.ttpic.openapi.filter;

import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class GLGestureProxy
{
  public static final String TAG = "GLGestureProxy";
  private int height;
  private List<GLGestureListener> mGLGestureList = new CopyOnWriteArrayList();
  private GLSurfaceView mGLSurfaceView;
  private boolean mIsRecorder;
  private View mRecorderView;
  private int width;
  
  public static final GLGestureProxy getInstance()
  {
    return GLGestureProxy.GLGestureProxyHolder.access$100();
  }
  
  public static String getPointAction(MotionEvent paramMotionEvent)
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
  
  public void addListener(GLGestureListener paramGLGestureListener)
  {
    if (paramGLGestureListener == null) {
      return;
    }
    int k = paramGLGestureListener.onGetPriority();
    if (this.mGLGestureList.size() == 0)
    {
      this.mGLGestureList.add(paramGLGestureListener);
      return;
    }
    int m = this.mGLGestureList.size();
    int i = 0;
    int j = -1;
    while ((i < m) && (k >= ((GLGestureListener)this.mGLGestureList.get(i)).onGetPriority()))
    {
      j = i + 1;
      i += 1;
    }
    if (j == -1)
    {
      this.mGLGestureList.add(0, paramGLGestureListener);
      return;
    }
    this.mGLGestureList.add(j, paramGLGestureListener);
  }
  
  public boolean checkDownPointerInRecorderView(float paramFloat1, float paramFloat2)
  {
    if (this.mRecorderView != null)
    {
      int[] arrayOfInt = new int[2];
      this.mRecorderView.getLocationOnScreen(arrayOfInt);
      if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= arrayOfInt[0] + this.mRecorderView.getWidth()) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= arrayOfInt[1] + this.mRecorderView.getHeight())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean checkSecendFinger(MotionEvent paramMotionEvent)
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
  
  public GLSurfaceView getGLSurfaceView()
  {
    return this.mGLSurfaceView;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public View getRecordView()
  {
    return this.mRecorderView;
  }
  
  public float getScreenCoordinateX(float paramFloat)
  {
    float f = paramFloat;
    if (this.mIsRecorder)
    {
      f = paramFloat;
      if (this.mRecorderView != null)
      {
        int[] arrayOfInt = new int[2];
        this.mRecorderView.getLocationOnScreen(arrayOfInt);
        f = paramFloat + arrayOfInt[0];
      }
    }
    return f;
  }
  
  public float getScreenCoordinateY(float paramFloat)
  {
    float f = paramFloat;
    if (this.mIsRecorder)
    {
      f = paramFloat;
      if (this.mRecorderView != null)
      {
        int[] arrayOfInt = new int[2];
        this.mRecorderView.getLocationOnScreen(arrayOfInt);
        f = paramFloat + arrayOfInt[1];
      }
    }
    return f;
  }
  
  public MotionEvent getSecendFingerMotionEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int[] arrayOfInt = new int[2];
    if (this.mRecorderView != null) {
      this.mRecorderView.getLocationOnScreen(arrayOfInt);
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
      return MotionEvent.obtain(l, l, i, j, k, 0);
      i = 0;
      continue;
      i = 2;
    }
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean hasListener(GLGestureListener paramGLGestureListener)
  {
    return this.mGLGestureList.contains(paramGLGestureListener);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean, View paramView, GLSurfaceView paramGLSurfaceView)
  {
    this.mGLSurfaceView = paramGLSurfaceView;
    if (this.mGLSurfaceView != null)
    {
      this.width = this.mGLSurfaceView.getWidth();
      this.height = this.mGLSurfaceView.getHeight();
    }
    this.mRecorderView = paramView;
    this.mIsRecorder = paramBoolean;
    int i = this.mGLGestureList.size() - 1;
    while (i >= 0)
    {
      if (((GLGestureListener)this.mGLGestureList.get(i)).onTouchEvent(paramMotionEvent, paramBoolean)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void removeAllListener()
  {
    this.mGLGestureList.clear();
    this.mRecorderView = null;
    this.mGLSurfaceView = null;
  }
  
  public void removeListener(GLGestureListener paramGLGestureListener)
  {
    if (this.mGLGestureList.contains(paramGLGestureListener)) {
      this.mGLGestureList.remove(paramGLGestureListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GLGestureProxy
 * JD-Core Version:    0.7.0.1
 */