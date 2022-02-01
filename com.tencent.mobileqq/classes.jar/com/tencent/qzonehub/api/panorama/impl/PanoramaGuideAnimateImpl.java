package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate;
import com.tencent.qzonehub.api.panorama.OnAnimateListener;
import cooperation.qzone.panorama.widget.PanoramaGuideAnimate;

public class PanoramaGuideAnimateImpl
  implements IPanoramaGuideAnimate
{
  public void addView(LinearLayout paramLinearLayout, int paramInt)
  {
    ((PanoramaGuideAnimate)paramLinearLayout).addView(paramInt);
  }
  
  public LinearLayout getPanoramaGuideAnimate(Context paramContext)
  {
    return new PanoramaGuideAnimate(paramContext);
  }
  
  public void setOnAnimateListener(LinearLayout paramLinearLayout, OnAnimateListener paramOnAnimateListener)
  {
    ((PanoramaGuideAnimate)paramLinearLayout).setOnAnimateListener(paramOnAnimateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.impl.PanoramaGuideAnimateImpl
 * JD-Core Version:    0.7.0.1
 */