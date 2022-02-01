package com.tencent.qqmini.sdk.launcher.core;

public abstract interface IAppPageRouter
{
  public abstract boolean navigateBack(int paramInt);
  
  public abstract void navigateTo(String paramString);
  
  public abstract void reLaunch(String paramString);
  
  public abstract void redirectTo(String paramString);
  
  public abstract void switchTab(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IAppPageRouter
 * JD-Core Version:    0.7.0.1
 */