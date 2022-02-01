package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class BoxShadow
  extends FrameLayout
{
  RectF a;
  Paint b = new Paint();
  int c;
  int d;
  int e;
  private int f;
  private int g;
  
  public BoxShadow(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BoxShadow(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.d = paramInt2;
    this.e = paramInt1;
    this.c = paramInt3;
    this.b.setColor(this.c);
    this.b.setStyle(Paint.Style.FILL);
    paramInt1 = (int)(paramInt1 * 0.5F);
    this.b.setMaskFilter(new BlurMaskFilter(paramInt1, BlurMaskFilter.Blur.NORMAL));
    setLayerType(1, null);
  }
  
  public BoxShadow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BoxShadow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    RectF localRectF = this.a;
    if (localRectF != null)
    {
      int i = this.d;
      paramCanvas.drawRoundRect(localRectF, i, i, this.b);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.a == null) || (this.f != getMeasuredWidth()) || (this.g != getMeasuredHeight()))
    {
      paramInt1 = (int)(this.e * 0.5F);
      float f1 = paramInt1;
      this.a = new RectF(f1, f1, getMeasuredWidth() - paramInt1, getMeasuredHeight() - 1.15F * f1);
      this.f = getMeasuredWidth();
      this.g = getMeasuredHeight();
    }
  }
  
  public void setShadowColor(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      this.b.setColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BoxShadow
 * JD-Core Version:    0.7.0.1
 */