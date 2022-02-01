package com.tencent.mobileqq.gamecenter.web;

import Override;
import ampj;
import android.content.res.Configuration;
import android.view.MotionEvent;
import aprd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQGamePubActivity
  extends PublicFragmentActivityForTool
{
  static
  {
    aprd.a(true);
    aprd.a();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public AppInterface getAppInterface()
  {
    return ampj.a();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGamePubActivity
 * JD-Core Version:    0.7.0.1
 */