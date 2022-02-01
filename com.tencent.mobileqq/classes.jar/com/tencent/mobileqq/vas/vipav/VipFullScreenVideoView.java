package com.tencent.mobileqq.vas.vipav;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.widget.VideoView;

public class VipFullScreenVideoView
  extends VideoView
{
  public VipFullScreenVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VipFullScreenVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VipFullScreenVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getHolder() != null) && (getHolder().getSurfaceFrame() != null))
    {
      int i = getHolder().getSurfaceFrame().width();
      int j = getHolder().getSurfaceFrame().height();
      if ((i > 0) && (j > 0) && (getHeight() > 0) && (getWidth() > 0))
      {
        float f1 = j / i;
        paramInt1 = getDefaultSize(getResources().getDisplayMetrics().widthPixels, paramInt1);
        paramInt2 = getDefaultSize(getResources().getDisplayMetrics().heightPixels, paramInt2);
        float f2 = paramInt2;
        float f3 = paramInt1;
        if (f1 < f2 / f3) {
          paramInt1 = (int)(f2 / f1);
        } else {
          paramInt2 = (int)(f3 * f1);
        }
        setMeasuredDimension(paramInt1, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView
 * JD-Core Version:    0.7.0.1
 */