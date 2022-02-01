package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VideoFeedsGestureProgressView
  extends View
{
  private Paint a = new Paint();
  private float b = 0.0F;
  
  public VideoFeedsGestureProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsGestureProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsGestureProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.a.setColor(1711276032);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.a);
    this.a.setColor(-1);
    paramCanvas.drawRect(0.0F, getHeight() - getHeight() * this.b, getWidth(), getHeight(), this.a);
  }
  
  public void setProgress(float paramFloat)
  {
    this.b = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureProgressView
 * JD-Core Version:    0.7.0.1
 */