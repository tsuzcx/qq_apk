package com.tencent.mobileqq.profilecard.base.framework;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;

public abstract interface IComponentLifecycle
{
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean onBackPressed();
  
  public abstract void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
 * JD-Core Version:    0.7.0.1
 */