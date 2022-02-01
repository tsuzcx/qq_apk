package com.tencent.qqmini.sdk.launcher.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
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
      if (QMLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("creating fragment ");
        localStringBuilder.append(localObject);
        QMLog.d("MiniFragmentActivity", localStringBuilder.toString());
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
  
  protected boolean doOnCreate(Bundle paramBundle)
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
    MiniBaseFragment localMiniBaseFragment = this.mFrag;
    if (localMiniBaseFragment != null) {
      localMiniBaseFragment.onBackPressed();
    }
    super.onBackPressed();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
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
    MiniBaseFragment localMiniBaseFragment = this.mFrag;
    if ((localMiniBaseFragment != null) && (localMiniBaseFragment.onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    try
    {
      paramIntent.setExtrasClassLoader(getClassLoader());
      if (paramIntent.hasExtra("public_fragment_window_feature"))
      {
        requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
        return;
      }
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
    String str = super.toString();
    if (this.mFrag != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(this.mFrag.getClass().getName());
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(Integer.toHexString(this.mFrag.hashCode()));
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (getIntent() != null)
    {
      localObject = str;
      if (getIntent().getStringExtra("public_fragment_class") != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(getIntent().getStringExtra("public_fragment_class"));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity
 * JD-Core Version:    0.7.0.1
 */