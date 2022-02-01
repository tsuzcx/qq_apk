package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VideoFeedsAlphaMaskView
  extends View
{
  private Paint a = new Paint();
  private float b = 1.0F;
  
  public VideoFeedsAlphaMaskView(Context paramContext)
  {
    super(paramContext);
    this.a.setColor(-635823590);
  }
  
  public VideoFeedsAlphaMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setColor(-635823590);
  }
  
  public VideoFeedsAlphaMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setColor(-635823590);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.a.setAlpha((int)(this.b * 218.0F));
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.a);
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.b != paramFloat)
    {
      this.b = paramFloat;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView
 * JD-Core Version:    0.7.0.1
 */