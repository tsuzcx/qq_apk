package com.tencent.mobileqq.richmedia.capture.gesture;

import android.view.MotionEvent;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class MovieFilterGesture
  implements GLGestureListener
{
  private static final String TAG = "MovieFilterGesture";
  private GLGestureProxy glGestureProxy;
  private long lastDownTime = 0L;
  private QQFilterRenderManager qqFilterRenderManager;
  
  public MovieFilterGesture(QQFilterRenderManager paramQQFilterRenderManager, GLGestureProxy paramGLGestureProxy)
  {
    this.qqFilterRenderManager = paramQQFilterRenderManager;
    this.glGestureProxy = paramGLGestureProxy;
  }
  
  public int onGetPriority()
  {
    return 1050;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if (i > 2) {
      if (SLog.isEnable()) {
        SLog.i("MovieFilterGesture", "two more point!");
      }
    }
    label50:
    float f2;
    float f1;
    label125:
    do
    {
      do
      {
        do
        {
          return false;
          if ((i == 2) && (paramBoolean))
          {
            i = 1;
            if (i == 0) {
              break label125;
            }
            f2 = GLGestureProxy.getInstance().getScreenCoordinateX(paramMotionEvent.getX(1));
          }
          for (f1 = GLGestureProxy.getInstance().getScreenCoordinateY(paramMotionEvent.getY(1));; f1 = paramMotionEvent.getY())
          {
            if (i == 0) {
              break label190;
            }
            switch (j)
            {
            default: 
              return false;
            case 5: 
              this.lastDownTime = System.currentTimeMillis();
              return false;
              i = 0;
              break label50;
              f2 = paramMotionEvent.getX();
            }
          }
        } while (System.currentTimeMillis() - this.lastDownTime >= 200L);
        this.qqFilterRenderManager.getBusinessOperation().setMovieEffectPoint(f2, f1, this.glGestureProxy.getWidth(), this.glGestureProxy.getHeight());
        this.lastDownTime = 0L;
        return true;
      } while (paramBoolean);
      switch (j)
      {
      default: 
        return false;
      case 0: 
        this.lastDownTime = System.currentTimeMillis();
        return false;
      }
    } while (System.currentTimeMillis() - this.lastDownTime >= 200L);
    label190:
    this.qqFilterRenderManager.getBusinessOperation().setMovieEffectPoint(f2, f1, this.glGestureProxy.getWidth(), this.glGestureProxy.getHeight());
    this.lastDownTime = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.MovieFilterGesture
 * JD-Core Version:    0.7.0.1
 */