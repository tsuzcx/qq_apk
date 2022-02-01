package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class HippyPageScrollEvent
  extends HippyViewEvent
{
  public static final String EVENT_NAME = "onPageScroll";
  private View mTarget;
  
  public HippyPageScrollEvent(View paramView)
  {
    super("onPageScroll");
    this.mTarget = paramView;
  }
  
  public void send(int paramInt, float paramFloat)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("position", paramInt);
    localHippyMap.pushDouble("offset", paramFloat);
    super.send(this.mTarget, localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollEvent
 * JD-Core Version:    0.7.0.1
 */