package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class HippyPageSelectedEvent
  extends HippyViewEvent
{
  public static final String EVENT_NAME = "onPageSelected";
  private final View mTarget;
  
  public HippyPageSelectedEvent(View paramView)
  {
    super("onPageSelected");
    this.mTarget = paramView;
  }
  
  public void send(int paramInt)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("position", paramInt);
    super.send(this.mTarget, localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.event.HippyPageSelectedEvent
 * JD-Core Version:    0.7.0.1
 */