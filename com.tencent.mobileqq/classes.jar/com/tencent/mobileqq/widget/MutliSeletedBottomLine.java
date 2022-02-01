package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class MutliSeletedBottomLine
  extends View
{
  private final float a = 0.2F;
  private final float b = 1.0F;
  private final float c = 2.0F;
  private final float d = 6.0F;
  private float e = 0.0F;
  private float f = 29.0F;
  private boolean g = false;
  private int h;
  private Paint i = new Paint();
  
  public MutliSeletedBottomLine(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    float f1 = paramInt;
    this.e = f1;
    this.f = DisplayUtil.a(paramContext, 29.0F);
    this.g = paramBoolean;
    this.h = ((int)(f1 / 8.0F));
  }
  
  @SuppressLint({"ResourceAsColor"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.i.setColor(getResources().getColor(2131165459));
    this.i.setAntiAlias(true);
    float f1;
    if (!this.g) {
      f1 = 0.2F;
    } else {
      f1 = 1.0F;
    }
    int j = 0;
    for (;;)
    {
      int k = this.h;
      if (j >= k) {
        break;
      }
      double d1;
      double d2;
      if (!this.g)
      {
        d1 = f1;
        d2 = j / k;
        Double.isNaN(d2);
        Double.isNaN(d1);
        d1 += d2 * 0.8D;
      }
      else
      {
        d1 = f1;
        d2 = j / k;
        Double.isNaN(d2);
        Double.isNaN(d1);
        d1 -= d2 * 0.8D;
      }
      float f2 = (float)d1;
      this.i.setAlpha((int)(f2 * 255.0F));
      paramCanvas.drawCircle(j * 8.0F + 2.0F, this.f / 2.0F, 2.0F, this.i);
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)this.e, getMeasuredHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutliSeletedBottomLine
 * JD-Core Version:    0.7.0.1
 */