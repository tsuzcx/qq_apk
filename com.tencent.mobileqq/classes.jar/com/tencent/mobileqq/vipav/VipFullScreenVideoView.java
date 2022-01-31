package com.tencent.mobileqq.vipav;

import android.content.Context;
import android.util.AttributeSet;
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
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFullScreenVideoView
 * JD-Core Version:    0.7.0.1
 */