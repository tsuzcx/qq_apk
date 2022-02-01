package com.tencent.open.agent;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublicFragmentActivityForOpenSDK
  extends PublicFragmentActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    QLog.d("PublicFragmentActivityForOpenSDK", 1, "PublicFragmentActivityForOpenSDK->doOnBackPressed");
    super.doOnBackPressed();
    PublicBaseFragment localPublicBaseFragment = a();
    if ((localPublicBaseFragment instanceof OpenAuthorityFragment)) {
      ((OpenAuthorityFragment)localPublicBaseFragment).i();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("PublicFragmentActivityForOpenSDK", 1, "PublicFragmentActivityForOpenSDK->doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    QLog.d("PublicFragmentActivityForOpenSDK", 1, "PublicFragmentActivityForOpenSDK->doOnNewIntent");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.PublicFragmentActivityForOpenSDK
 * JD-Core Version:    0.7.0.1
 */