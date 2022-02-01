package com.tencent.mobileqq.nearby.picbrowser;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import aycr;
import aycs;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NearbyProfilePicBrowserActivity
  extends PicBrowserActivity
{
  boolean a;
  
  public NearbyProfilePicBrowserActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("intent_param_show_del_pic_and_set_head", false);
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Aawb = new aycs(this);; this.jdField_a_of_type_Aawb = new aycr(this)) {
      return super.doOnCreate(paramBundle);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */