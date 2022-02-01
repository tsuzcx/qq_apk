package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPanoramaGuideAnimate
  extends QRouteApi
{
  public abstract void addView(LinearLayout paramLinearLayout, int paramInt);
  
  public abstract LinearLayout getPanoramaGuideAnimate(Context paramContext);
  
  public abstract void setOnAnimateListener(LinearLayout paramLinearLayout, OnAnimateListener paramOnAnimateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate
 * JD-Core Version:    0.7.0.1
 */