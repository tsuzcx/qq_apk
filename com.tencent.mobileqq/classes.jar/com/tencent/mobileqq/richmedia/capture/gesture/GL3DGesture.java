package com.tencent.mobileqq.richmedia.capture.gesture;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.GameEventConsumer.MotionEventData;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.GameplayEngine;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class GL3DGesture
  implements GLGestureListener
{
  GameplayEngine jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialGameplayEngine = new GameplayEngine();
  private boolean jdField_a_of_type_Boolean = false;
  
  public int onGetPriority()
  {
    return 1040;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    paramMotionEvent = new GameEventConsumer.MotionEventData(paramMotionEvent);
    GLGestureProxy.getInstance().getGLSurfaceView().queueEvent(new GL3DGesture.1(this, paramMotionEvent));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.GL3DGesture
 * JD-Core Version:    0.7.0.1
 */