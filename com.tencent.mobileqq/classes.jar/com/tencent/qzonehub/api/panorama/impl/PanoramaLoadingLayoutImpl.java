package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout;
import cooperation.qzone.panorama.widget.PanoramaLoadingLayout;

public class PanoramaLoadingLayoutImpl
  implements IPanoramaLoadingLayout
{
  public RelativeLayout getPanoramaLoadingLayout(Context paramContext)
  {
    return new PanoramaLoadingLayout(paramContext);
  }
  
  public boolean isPanoramaLoading()
  {
    return PanoramaLoadingLayout.isPanoramaLoading;
  }
  
  public void onRecycled(RelativeLayout paramRelativeLayout)
  {
    ((PanoramaLoadingLayout)paramRelativeLayout).onRecycled();
  }
  
  public void setPanoramaLoading(boolean paramBoolean)
  {
    PanoramaLoadingLayout.isPanoramaLoading = paramBoolean;
  }
  
  public void showLoading(RelativeLayout paramRelativeLayout, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((PanoramaLoadingLayout)paramRelativeLayout).showLoading(paramBoolean1, paramBoolean2);
  }
  
  public void startRotateAnimate(RelativeLayout paramRelativeLayout)
  {
    ((PanoramaLoadingLayout)paramRelativeLayout).startRotateAnimate();
  }
  
  public void stopRotateAnimate(RelativeLayout paramRelativeLayout)
  {
    ((PanoramaLoadingLayout)paramRelativeLayout).stopRotateAnimate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.impl.PanoramaLoadingLayoutImpl
 * JD-Core Version:    0.7.0.1
 */