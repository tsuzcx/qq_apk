package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class HippyPageItemExposureEvent
  extends HippyViewEvent
{
  public static final String EVENT_PAGER_ITEM_DID_APPEAR = "onDidAppear";
  public static final String EVENT_PAGER_ITEM_DID_DISAPPEAR = "onDidDisAppear";
  public static final String EVENT_PAGER_ITEM_WILL_APPEAR = "onWillAppear";
  public static final String EVENT_PAGER_ITEM_WILL_DISAPPEAR = "onWillDisAppear";
  
  public HippyPageItemExposureEvent(String paramString)
  {
    super(paramString);
  }
  
  public void send(View paramView, int paramInt)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("position", paramInt);
    super.send(paramView, localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.event.HippyPageItemExposureEvent
 * JD-Core Version:    0.7.0.1
 */