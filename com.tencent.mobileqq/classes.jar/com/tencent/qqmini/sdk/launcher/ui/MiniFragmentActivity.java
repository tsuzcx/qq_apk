package com.tencent.qqmini.sdk.launcher.ui;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.R.id;
import com.tencent.qqmini.sdk.launcher.R.layout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.AndroidOUIWrapperUtil;

public class MiniFragmentActivity
  extends FragmentActivity
{
  private static final String TAG = "MiniFragmentActivity";
  private MiniBaseFragment mFrag;
  
  private MiniBaseFragment createFragment()
  {
    try
    {
      Object localObject = (Class)getIntent().getSerializableExtra("public_fragment_class");
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniFragmentActivity", "creating fragment " + localObject);
      }
      if (localObject != null)
      {
        localObject = (MiniBaseFragment)((Class)localObject).newInstance();
        ((MiniBaseFragment)localObject).setArguments(getIntent().getExtras());
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("MiniFragmentActivity", "create fragment error", localException);
    }
    return null;
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
    this.mFrag = createFragment();
    setContentView(R.layout.mini_sdk_fragment_activity);
    if (this.mFrag == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(R.id.frag_container, this.mFrag);
    paramBundle.commit();
    return true;
  }
  
  public MiniBaseFragment getFragment()
  {
    return this.mFrag;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    MiniBaseFragment localMiniBaseFragment = getFragment();
    if (localMiniBaseFragment != null) {
      localMiniBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (this.mFrag != null) {
      this.mFrag.onBackPressed();
    }
    super.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      AndroidOUIWrapperUtil.fixOrientation(this);
    }
    requestWindowFeature(getIntent());
    super.onCreate(paramBundle);
    doOnCreate(paramBundle);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.mFrag != null) && (this.mFrag.onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    try
    {
      paramIntent.setExtrasClassLoader(getClassLoader());
      if (paramIntent.hasExtra("public_fragment_window_feature")) {
        requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QMLog.w("MiniFragmentActivity", "Failed to request window feature", paramIntent);
    }
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      super.setRequestedOrientation(paramInt);
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.mFrag != null) {
      str1 = str2 + "#" + this.mFrag.getClass().getName() + "@" + Integer.toHexString(this.mFrag.hashCode());
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (getIntent() == null);
      str1 = str2;
    } while (getIntent().getStringExtra("public_fragment_class") == null);
    return str2 + "#" + getIntent().getStringExtra("public_fragment_class");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity
 * JD-Core Version:    0.7.0.1
 */