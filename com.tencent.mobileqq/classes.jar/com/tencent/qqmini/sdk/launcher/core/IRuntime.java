package com.tencent.qqmini.sdk.launcher.core;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IRuntime
{
  public abstract boolean onBackPress();
  
  public abstract void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString);
  
  public abstract void onRuntimeAttachActivity(Activity paramActivity, ViewGroup paramViewGroup);
  
  public abstract void onRuntimeDestroy();
  
  public abstract void onRuntimeDetachActivity(Activity paramActivity);
  
  public abstract void onRuntimePause();
  
  public abstract void onRuntimeResume();
  
  public abstract void onRuntimeStart();
  
  public abstract void onRuntimeStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IRuntime
 * JD-Core Version:    0.7.0.1
 */