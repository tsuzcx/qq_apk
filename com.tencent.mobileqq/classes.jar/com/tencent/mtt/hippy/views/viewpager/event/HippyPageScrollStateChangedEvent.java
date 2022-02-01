package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class HippyPageScrollStateChangedEvent
  extends HippyViewEvent
{
  public static final String EVENT_NAME = "onPageScrollStateChanged";
  private View mTarget;
  
  public HippyPageScrollStateChangedEvent(View paramView)
  {
    super("onPageScrollStateChanged");
    this.mTarget = paramView;
  }
  
  public void send(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("pageScrollState", paramString);
    super.send(this.mTarget, localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.event.HippyPageScrollStateChangedEvent
 * JD-Core Version:    0.7.0.1
 */