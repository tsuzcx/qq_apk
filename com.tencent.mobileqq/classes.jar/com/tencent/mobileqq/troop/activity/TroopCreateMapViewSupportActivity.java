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
  AutoLocationMapView d;
  RelativeLayout e;
  int f = 0;
  
  private void e()
  {
    ViewGroup localViewGroup = (ViewGroup)this.c.getParent();
    localViewGroup.removeView(this.c);
    this.e = ((RelativeLayout)getLayoutInflater().inflate(2131625913, null, true));
    this.f = ((int)getResources().getDimension(2131298725));
    this.d = new AutoLocationMapView(this);
    this.d.setId(2131441348);
    this.e.addView(this.d, new RelativeLayout.LayoutParams(-1, this.f));
    this.d.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131441348);
    this.e.addView(this.c, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131444897);
    localViewGroup.addView(this.e, localLayoutParams);
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
    AutoLocationMapView localAutoLocationMapView = this.d;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onDestroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AutoLocationMapView localAutoLocationMapView = this.d;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onPause();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AutoLocationMapView localAutoLocationMapView = this.d;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onResume();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    AutoLocationMapView localAutoLocationMapView = this.d;
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
    AutoLocationMapView localAutoLocationMapView = this.d;
    if (localAutoLocationMapView != null) {
      localAutoLocationMapView.onRestart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity
 * JD-Core Version:    0.7.0.1
 */