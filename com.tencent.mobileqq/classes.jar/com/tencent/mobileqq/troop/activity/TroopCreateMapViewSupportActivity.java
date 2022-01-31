package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;

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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130969435, null, true));
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131558812));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView = new AutoLocationMapView(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setId(2131362012);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView, new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131362012);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131363244);
    localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onDestroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onPause();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onResume();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onStop();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onRestart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity
 * JD-Core Version:    0.7.0.1
 */