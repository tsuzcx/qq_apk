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
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                return "";
              }
              return "MotionEvent.ACTION_POINTER_UP";
            }
            return "MotionEvent.ACTION_POINTER_DOWN";
          }
          return "MotionEvent.ACTION_CANCEL";
        }
        return "MotionEvent.ACTION_MOVE";
      }
      return "MotionEvent.ACTION_UP";
    }
    return "MotionEvent.ACTION_DOWN";
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
      i = j;
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
    View localView = this.mRecorderView;
    if (localView != null)
    {
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= arrayOfInt[0] + this.mRecorderView.getWidth()) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= arrayOfInt[1] + this.mRecorderView.getHeight())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean checkSecendFinger(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    int j = paramMotionEvent.getPointerCount();
    boolean bool2 = true;
    boolean bool1;
    if (j == 2)
    {
      bool1 = bool2;
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 5)
        {
          bool1 = bool2;
          if (i == 6) {}
        }
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
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
      View localView = this.mRecorderView;
      f = paramFloat;
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
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
      View localView = this.mRecorderView;
      f = paramFloat;
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        f = paramFloat + arrayOfInt[1];
      }
    }
    return f;
  }
  
  public MotionEvent getSecendFingerMotionEvent(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    View localView = this.mRecorderView;
    if (localView != null) {
      localView.getLocationOnScreen(arrayOfInt);
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    int j = (int)(arrayOfInt[0] + paramMotionEvent.getX(1));
    int k = (int)(arrayOfInt[1] + paramMotionEvent.getY(1));
    long l = SystemClock.uptimeMillis();
    if (i != 2)
    {
      if (i != 5)
      {
        if (i != 6) {
          i = -1;
        } else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
    else {
      i = 2;
    }
    return MotionEvent.obtain(l, l, i, j, k, 0);
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
    paramGLSurfaceView = this.mGLSurfaceView;
    if (paramGLSurfaceView != null)
    {
      this.width = paramGLSurfaceView.getWidth();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GLGestureProxy
 * JD-Core Version:    0.7.0.1
 */