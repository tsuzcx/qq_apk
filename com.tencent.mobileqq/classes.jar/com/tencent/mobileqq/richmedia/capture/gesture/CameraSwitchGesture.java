package com.tencent.mobileqq.richmedia.capture.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

public class CameraSwitchGesture
  implements GLGestureListener
{
  int a;
  int b;
  CameraSwitchGesture.CameraSwitchGestureListener c;
  private final int d;
  private final int e;
  private MotionEvent f;
  private MotionEvent g;
  private final int h;
  private long i;
  
  public CameraSwitchGesture(Context paramContext, CameraSwitchGesture.CameraSwitchGestureListener paramCameraSwitchGestureListener)
  {
    this.c = paramCameraSwitchGestureListener;
    paramContext = ViewConfiguration.get(paramContext);
    this.d = ViewConfiguration.getDoubleTapTimeout();
    this.e = 1000;
    this.a = paramContext.getScaledDoubleTapSlop();
    int j = this.a;
    this.b = (j * j);
    this.h = paramContext.getScaledTouchSlop();
    this.i = 0L;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = (int)paramFloat3 - (int)paramFloat1;
    int k = (int)paramFloat4 - (int)paramFloat2;
    return j * j + k * k > this.h;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      if (Math.abs(System.currentTimeMillis() - this.i) < this.e) {
        return false;
      }
      if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > this.d) {
        return false;
      }
      if (a(paramMotionEvent1.getX(), paramMotionEvent1.getY(), paramMotionEvent2.getX(), paramMotionEvent2.getY())) {
        return false;
      }
      int j = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      int k = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
      bool1 = bool2;
      if (j * j + k * k < this.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int j = paramMotionEvent.getPointerCount();
    int k = paramMotionEvent.getAction() & 0xFF;
    AEQLog.a("GLGestureListener", "[gestureFix][CameraSwitchGesture]:onTouchEvent");
    if ((j == 1) && (!paramBoolean))
    {
      if (k != 0)
      {
        if (k != 1) {
          return false;
        }
        localMotionEvent = this.g;
        if (localMotionEvent != null) {
          localMotionEvent.recycle();
        }
        this.g = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
      if (a(this.f, this.g, paramMotionEvent))
      {
        AEQLog.a("GLGestureListener", "[gestureFix][CameraSwitchGesture]:camera double click");
        if (this.c != null)
        {
          this.i = System.currentTimeMillis();
          this.c.a();
          StoryReportor.a("camera_clkdouble", -1, 0, new String[0]);
          ((ICaptureReportUtil)QRoute.api(ICaptureReportUtil.class)).reportDoubleClickChangeCamera();
          if (QLog.isColorLevel()) {
            QLog.d("GLGestureListener", 2, new Object[] { "", "CameraSwitchGesture" });
          }
        }
      }
      MotionEvent localMotionEvent = this.f;
      if (localMotionEvent != null) {
        localMotionEvent.recycle();
      }
      this.f = MotionEvent.obtain(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture
 * JD-Core Version:    0.7.0.1
 */