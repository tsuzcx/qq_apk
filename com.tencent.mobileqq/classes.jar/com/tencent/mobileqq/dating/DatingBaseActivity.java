package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final boolean a;
  protected int a;
  protected QQProgressNotifier a;
  public boolean b = false;
  public boolean c = false;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.d;
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
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getTitleBarHeight();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.b = getIntent().getBooleanExtra("abp_flag", false);
    this.c = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.c) && (!this.b)) {
      setLeftViewName(2131690601);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.b) {
      overridePendingTransition(2130771990, 2130771991);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */