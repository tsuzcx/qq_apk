package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ConfessProgressView
  extends View
{
  private Paint a = new Paint();
  private float b = 0.0F;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public ConfessProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ConfessProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ConfessProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a.setColor(Color.argb(255, 252, 228, 80));
    this.a.setAntiAlias(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt1 < paramInt2))
    {
      int i = 80 / (paramInt2 - 1);
      int j = paramInt1 - 1;
      this.a.setColor(Color.argb(255, 252, 228 - i * j, 80));
      float f2 = this.c;
      float f1 = f2 / 15.0F;
      f2 /= 5.0F;
      if (paramInt1 == 1) {
        this.b = f1;
      } else {
        this.b = (f1 + (f2 - f1) / (paramInt2 - 2) * j);
      }
    }
    else
    {
      this.b = 0.0F;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.c / 2.0F + this.e, this.d / 2.0F * 1.08F + this.f, this.b, this.a);
  }
  
  public void setSize(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessProgressView
 * JD-Core Version:    0.7.0.1
 */