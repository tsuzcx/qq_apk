package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PlayerProgressBar
  extends View
{
  public int a = 1;
  public int b = 1;
  public int c = 1;
  private int d = -14342358;
  private int e = -15550475;
  private int f = -10066330;
  private int g;
  private Rect h = new Rect();
  private Paint i = new Paint();
  
  public PlayerProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public PlayerProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt)
  {
    int j = this.g;
    int k = this.c;
    if (j == k) {
      return paramInt;
    }
    j = paramInt * j / k;
    paramInt = j;
    if (j <= 0) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = this.a;
    if (paramInt1 == j) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / j;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {
      return;
    }
    int j = this.b;
    int k = this.a;
    if (j > k) {
      this.b = k;
    }
    k = super.getWidth();
    int m = super.getHeight();
    j = a(this.b, k);
    Rect localRect = this.h;
    localRect.top = 0;
    localRect.bottom = m;
    localRect.left = j;
    localRect.right = k;
    this.i.setColor(this.d);
    paramCanvas.drawRect(this.h, this.i);
    k = a(j);
    localRect = this.h;
    localRect.left = 0;
    localRect.right = k;
    this.i.setColor(this.e);
    paramCanvas.drawRect(this.h, this.i);
    if (k < j)
    {
      localRect = this.h;
      localRect.left = k;
      localRect.right = j;
      this.i.setColor(this.f);
      paramCanvas.drawRect(this.h, this.i);
    }
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.g = this.c;
    } else {
      this.g = paramInt;
    }
    super.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.PlayerProgressBar
 * JD-Core Version:    0.7.0.1
 */