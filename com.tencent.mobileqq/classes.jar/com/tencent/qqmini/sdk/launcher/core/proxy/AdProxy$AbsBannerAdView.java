package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.view.View;

public abstract class AdProxy$AbsBannerAdView
{
  public AdProxy$AbsBannerAdView(AdProxy paramAdProxy) {}
  
  public abstract void destroy(Context paramContext);
  
  public long getAdID()
  {
    return 0L;
  }
  
  public String getReportUrl()
  {
    return "";
  }
  
  public abstract View getView();
  
  public abstract void loadAD();
  
  public void onExposure() {}
  
  public void pause(Context paramContext) {}
  
  public void resume(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
 * JD-Core Version:    0.7.0.1
 */