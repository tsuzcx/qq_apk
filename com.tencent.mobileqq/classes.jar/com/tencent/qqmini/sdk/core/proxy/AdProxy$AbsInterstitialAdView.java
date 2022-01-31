package com.tencent.qqmini.sdk.core.proxy;

import android.app.Activity;
import android.content.Intent;

public abstract class AdProxy$AbsInterstitialAdView
{
  public AdProxy$AbsInterstitialAdView(AdProxy paramAdProxy) {}
  
  public abstract void destroy();
  
  public abstract void loadAD();
  
  public void onClose(Activity paramActivity, int paramInt, Intent paramIntent) {}
  
  public abstract boolean show(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsInterstitialAdView
 * JD-Core Version:    0.7.0.1
 */