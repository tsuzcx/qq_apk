package com.tencent.mobileqq.dating;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bjbv;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final boolean a;
  protected int a;
  protected bjbv a;
  public boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.c;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getTitleBarHeight();
    this.jdField_a_of_type_Bjbv = new bjbv(this);
    this.b = getIntent().getBooleanExtra("abp_flag", false);
    this.c = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.c) && (!this.b)) {
      setLeftViewName(2131690384);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bjbv != null) {
      this.jdField_a_of_type_Bjbv.b();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.b) {
      overridePendingTransition(2130771988, 2130771989);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */