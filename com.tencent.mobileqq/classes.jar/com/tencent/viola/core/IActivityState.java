package com.tencent.viola.core;

import android.content.Intent;

public abstract interface IActivityState
{
  public abstract boolean onActivityBack();
  
  @Deprecated
  public abstract void onActivityCreate();
  
  public abstract void onActivityDestroy();
  
  public abstract void onActivityPause();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onActivityResume();
  
  public abstract void onActivityStart();
  
  public abstract void onActivityStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.IActivityState
 * JD-Core Version:    0.7.0.1
 */