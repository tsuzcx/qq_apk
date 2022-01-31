package com.tencent.mobileqq.richmedia.capture.gesture;

import ahpd;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.GameEventConsumer.MotionEventData;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.GameplayEngine;

public class GL3DGesture
  implements GLGestureListener
{
  public GameplayEngine a = new GameplayEngine();
  
  public int a()
  {
    return 1040;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    paramMotionEvent = new GameEventConsumer.MotionEventData(paramMotionEvent);
    GLGestureProxy.a().a().queueEvent(new ahpd(this, paramMotionEvent));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.GL3DGesture
 * JD-Core Version:    0.7.0.1
 */