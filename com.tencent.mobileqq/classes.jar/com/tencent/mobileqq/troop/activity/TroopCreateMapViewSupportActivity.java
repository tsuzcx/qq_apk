package com.tencent.mobileqq.troop.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopCreateMapViewSupportActivity
  extends TroopCreateBaseActivity
{
  int jdField_a_of_type_Int = 0;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  AutoLocationMapView jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
  
  private void e()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent();
    localViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2131559870, null, true));
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131298049));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView = new AutoLocationMapView(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setId(2131373674);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView, new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131373674);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131376636);
    localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    AutoLocationMapView localAutoLocationMapView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onDestroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AutoLocationMapView localAutoLocationMapView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onPause();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AutoLocationMapView localAutoLocationMapView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onResume();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    AutoLocationMapView localAutoLocationMapView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onStop();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    AutoLocationMapView localAutoLocationMapView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onRestart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity
 * JD-Core Version:    0.7.0.1
 */