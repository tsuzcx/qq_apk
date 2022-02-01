package com.tencent.open.agent;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublicFragmentActivityForOpenSDK
  extends QPublicFragmentActivity
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnBackPressed hashCode=");
    ((StringBuilder)localObject).append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { ((StringBuilder)localObject).toString() });
    super.doOnBackPressed();
    localObject = getFragment();
    if ((localObject instanceof OpenAuthorityFragment)) {
      ((OpenAuthorityFragment)localObject).c();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnCreate hashCode=");
    localStringBuilder.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { localStringBuilder.toString() });
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnDestroy hashCode=");
    localStringBuilder.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { localStringBuilder.toString() });
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("doOnNewIntent hashCode=");
    paramIntent.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { paramIntent.toString() });
  }
  
  protected void doOnPause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnPause hashCode=");
    localStringBuilder.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { localStringBuilder.toString() });
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnResume hashCode=");
    localStringBuilder.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { localStringBuilder.toString() });
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnStart hashCode=");
    localStringBuilder.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { localStringBuilder.toString() });
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnStop hashCode=");
    localStringBuilder.append(hashCode());
    SSOLog.a("PublicFragmentActivityForOpenSDK", new Object[] { localStringBuilder.toString() });
    super.doOnStop();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.PublicFragmentActivityForOpenSDK
 * JD-Core Version:    0.7.0.1
 */