package com.tencent.qqconnect.wtlogin;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.NewOpenAuthDevUgFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewOpenAuthDevUgActivity
  extends QBaseActivity
{
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
    Object localObject = getIntent();
    if (localObject == null)
    {
      finish();
      return true;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      finish();
      return true;
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = new FrameLayout(this);
    super.setContentView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramBundle.setId(2131431345);
    paramBundle = new NewOpenAuthDevUgFragment();
    paramBundle.setArguments((Bundle)localObject);
    getSupportFragmentManager().beginTransaction().add(2131431345, paramBundle).commit();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.NewOpenAuthDevUgActivity
 * JD-Core Version:    0.7.0.1
 */