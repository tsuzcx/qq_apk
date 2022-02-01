package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

public class RoundedCornerImageViewNoPadding
  extends PressDarkImageView
{
  private Path e = new Path();
  private int f = Color.parseColor("#FFD5D5D5");
  private boolean g = false;
  private int h = 0;
  private boolean i = false;
  
  public RoundedCornerImageViewNoPadding(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundedCornerImageViewNoPadding(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedCornerImageViewNoPadding(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setLayerType(2, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      super.setLayerType(1, null);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = getWidth();
    int j = getHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, k, j);
    j = this.h;
    if (j <= 0) {
      j = k / 30;
    }
    if (!this.i)
    {
      this.e.reset();
      Path localPath = this.e;
      float f1 = j;
      localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CCW);
      this.e.setFillType(Path.FillType.EVEN_ODD);
      this.i = true;
    }
    paramCanvas.clipPath(this.e);
    super.draw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = false;
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt > 0)
    {
      this.h = paramInt;
      this.i = false;
      invalidate();
      return;
    }
    throw new IllegalArgumentException("should not be less than 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding
 * JD-Core Version:    0.7.0.1
 */