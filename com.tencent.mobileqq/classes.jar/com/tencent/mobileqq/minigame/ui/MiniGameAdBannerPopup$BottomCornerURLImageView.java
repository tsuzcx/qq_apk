package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.image.URLImageView;

class MiniGameAdBannerPopup$BottomCornerURLImageView
  extends URLImageView
{
  private float[] allRadius;
  private Path clippedPath;
  private RectF clippedRectF = new RectF();
  
  public MiniGameAdBannerPopup$BottomCornerURLImageView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext, null, 0);
  }
  
  public MiniGameAdBannerPopup$BottomCornerURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext, paramAttributeSet, 0);
  }
  
  public MiniGameAdBannerPopup$BottomCornerURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    float f = TypedValue.applyDimension(1, 6.0F, paramContext.getResources().getDisplayMetrics());
    this.clippedPath = new Path();
    this.allRadius = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f };
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    if (this.clippedPath != null)
    {
      this.clippedRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.clippedPath.reset();
      this.clippedPath.addRoundRect(this.clippedRectF, this.allRadius, Path.Direction.CCW);
      paramCanvas.clipPath(this.clippedPath);
    }
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.BottomCornerURLImageView
 * JD-Core Version:    0.7.0.1
 */