package com.tencent.qqmini.sdk.core.proxy;

public abstract interface AdProxy$IBannerAdListener
{
  public abstract void onADClicked();
  
  public abstract void onADCloseOverlay();
  
  public abstract void onADClosed();
  
  public abstract void onADExposure();
  
  public abstract void onADLeftApplication();
  
  public abstract void onADOpenOverlay();
  
  public abstract void onADReceive();
  
  public abstract void onNoAD(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.AdProxy.IBannerAdListener
 * JD-Core Version:    0.7.0.1
 */