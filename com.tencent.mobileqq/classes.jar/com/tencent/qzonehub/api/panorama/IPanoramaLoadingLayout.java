package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPanoramaLoadingLayout
  extends QRouteApi
{
  public static final int ANIMATION_TIME = 300;
  
  public abstract RelativeLayout getPanoramaLoadingLayout(Context paramContext);
  
  public abstract boolean isPanoramaLoading();
  
  public abstract void onRecycled(RelativeLayout paramRelativeLayout);
  
  public abstract void setPanoramaLoading(boolean paramBoolean);
  
  public abstract void showLoading(RelativeLayout paramRelativeLayout, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void startRotateAnimate(RelativeLayout paramRelativeLayout);
  
  public abstract void stopRotateAnimate(RelativeLayout paramRelativeLayout);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
 * JD-Core Version:    0.7.0.1
 */