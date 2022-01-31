package com.tencent.qqmini.sdk.core.proxy;

public abstract interface AdProxy$IRewardVideoAdListener
{
  public abstract void onADClick();
  
  public abstract void onADClose();
  
  public abstract void onADExpose();
  
  public abstract void onADLoad();
  
  public abstract void onADShow();
  
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onReward();
  
  public abstract void onVideoCached();
  
  public abstract void onVideoComplete();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener
 * JD-Core Version:    0.7.0.1
 */