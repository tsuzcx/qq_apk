package com.tencent.qqmini.sdk.core.plugins;

import begz;

public abstract interface ILifeCycle
{
  public abstract void onCreate(begz parambegz);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ILifeCycle
 * JD-Core Version:    0.7.0.1
 */