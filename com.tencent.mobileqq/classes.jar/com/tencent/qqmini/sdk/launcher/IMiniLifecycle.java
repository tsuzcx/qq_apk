package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

public abstract interface IMiniLifecycle
{
  public abstract void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup);
  
  public abstract void onDetachActivity(Activity paramActivity);
  
  public abstract void onIntentUpdate(Intent paramIntent);
  
  public abstract void onMiniPause();
  
  public abstract void onMiniResume();
  
  public abstract void onMiniStart();
  
  public abstract void onMiniStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.IMiniLifecycle
 * JD-Core Version:    0.7.0.1
 */