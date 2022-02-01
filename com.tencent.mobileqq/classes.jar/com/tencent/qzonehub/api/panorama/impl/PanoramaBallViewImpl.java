package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.view.View;
import com.tencent.qzonehub.api.panorama.IPanoramaBallView;
import cooperation.qzone.panorama.widget.PanoramaBallView;

public class PanoramaBallViewImpl
  implements IPanoramaBallView
{
  public int getMoveDegreeX(View paramView)
  {
    return ((PanoramaBallView)paramView).getMoveDegreeX();
  }
  
  public int getMoveDegreeY(View paramView)
  {
    return ((PanoramaBallView)paramView).getMoveDegreeY();
  }
  
  public View getPanoramaBallView(Context paramContext)
  {
    return new PanoramaBallView(paramContext);
  }
  
  public void setDegreeChange(View paramView, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    ((PanoramaBallView)paramView).setDegreeChange(paramInt1, paramInt2, paramInt3, paramFloat);
  }
  
  public void setModeType(View paramView, int paramInt)
  {
    ((PanoramaBallView)paramView).setModeType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.impl.PanoramaBallViewImpl
 * JD-Core Version:    0.7.0.1
 */