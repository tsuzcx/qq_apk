package com.tencent.qqmini.sdk.launcher.core.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public abstract interface ILifeCycle
{
  public abstract void onCreate(IMiniAppContext paramIMiniAppContext);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
 * JD-Core Version:    0.7.0.1
 */