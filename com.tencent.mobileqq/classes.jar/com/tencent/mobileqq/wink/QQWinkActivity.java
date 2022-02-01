package com.tencent.mobileqq.wink;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQWinkActivity
  extends CompatPublicActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.QQWinkActivity
 * JD-Core Version:    0.7.0.1
 */