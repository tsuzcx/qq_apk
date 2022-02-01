package com.tencent.mobileqq.together.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

public class RoundRectView
  extends PressEffectImageView
{
  private int a;
  private int b;
  private int c;
  private int d = 0;
  private Paint e;
  
  public RoundRectView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundRectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.e = new Paint();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = new RectF(0.0F, 0.0F, this.b, this.c);
    this.e.setColor(this.d);
    int i = this.a;
    paramCanvas.drawRoundRect(localRectF, i, i, this.e);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if ((paramInt1 == this.b) && (paramInt2 == this.c)) {
      return;
    }
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void setAllRadius(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (this.a == i) {
      return;
    }
    this.a = i;
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.d == paramInt) {
      return;
    }
    this.d = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.RoundRectView
 * JD-Core Version:    0.7.0.1
 */