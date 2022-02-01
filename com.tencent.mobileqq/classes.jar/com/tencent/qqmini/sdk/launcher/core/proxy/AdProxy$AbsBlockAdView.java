package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;

public abstract class AdProxy$AbsBlockAdView
{
  public AdProxy$AbsBlockAdView(AdProxy paramAdProxy) {}
  
  public void clearBlockAdAnimation(AbsBlockAdView paramAbsBlockAdView) {}
  
  public abstract void destroy(Context paramContext);
  
  public ArrayList<String> getReportUrl()
  {
    return null;
  }
  
  public abstract View getView();
  
  public abstract void loadAD();
  
  public void showBlockAdAnimation(AbsBlockAdView paramAbsBlockAdView) {}
  
  public abstract View updateAdInfo(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
 * JD-Core Version:    0.7.0.1
 */