package com.tencent.mtt.hippy.uimanager;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;

public abstract class HippyGroupController<T extends ViewGroup,  extends HippyViewBase>
  extends HippyViewController<T>
{
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onInterceptPullUpEvent")
  public void setInterceptPullUp(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onInterceptPullUpEvent", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onInterceptTouchEvent")
  public void setInterceptTouch(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onInterceptTouchEvent", paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyGroupController
 * JD-Core Version:    0.7.0.1
 */