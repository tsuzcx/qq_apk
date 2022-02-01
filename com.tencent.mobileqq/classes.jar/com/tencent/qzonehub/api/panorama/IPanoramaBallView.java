package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ViewUtils;

@QAPI(process={"all"})
public abstract interface IPanoramaBallView
  extends QRouteApi
{
  public static final int HEIGHT = ViewUtils.dpToPx(32.0F);
  public static final int WIDTH = ViewUtils.dpToPx(32.0F);
  
  public abstract int getMoveDegreeX(View paramView);
  
  public abstract int getMoveDegreeY(View paramView);
  
  public abstract View getPanoramaBallView(Context paramContext);
  
  public abstract void setDegreeChange(View paramView, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  public abstract void setModeType(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.IPanoramaBallView
 * JD-Core Version:    0.7.0.1
 */