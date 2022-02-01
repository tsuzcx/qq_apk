package com.tencent.qqmini.sdk.launcher.core.proxy;

public abstract interface AdProxy$IBlockAdListener
{
  public abstract void onADClicked();
  
  public abstract void onADClosed();
  
  public abstract void onADExposure();
  
  public abstract void onADReceive(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onNoAD(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener
 * JD-Core Version:    0.7.0.1
 */