package com.tencent.mobileqq.flashshow.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class RoundCornerImageView
  extends URLImageView
{
  private Path a = new Path();
  private Paint b = new Paint();
  private int c = Color.parseColor("#FFD5D5D5");
  private int d;
  private boolean e = false;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private RectF j = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
  private float[] k;
  
  public RoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.f;
    float f1 = paramInt;
    float f2 = paramInt;
    paramInt = this.g;
    float f3 = paramInt;
    float f4 = paramInt;
    paramInt = this.i;
    float f5 = paramInt;
    float f6 = paramInt;
    paramInt = this.h;
    this.k = new float[] { f1, f2, f3, f4, f5, f6, paramInt, paramInt };
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
    if (this.a == null) {
      this.a = new Path();
    }
    this.a.reset();
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    this.j.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + m, getPaddingTop() + n);
    this.a.addRoundRect(this.j, this.k, Path.Direction.CW);
    this.a.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.a);
    super.draw(paramCanvas);
    if (this.e)
    {
      this.b.setColor(this.c);
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setAntiAlias(true);
      this.b.setFilterBitmap(true);
      this.b.setDither(true);
      int i1 = this.d;
      if (i1 != 0) {
        this.b.setStrokeWidth(i1);
      }
      float f1 = getPaddingLeft();
      float f2 = m / 2.0F;
      paramCanvas.drawCircle(f1 + f2, getPaddingTop() + n / 2.0F, f2 - this.d / 2.0F, this.b);
    }
  }
  
  public void setBorder(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0))
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramInt3;
      this.i = paramInt4;
      float[] arrayOfFloat = this.k;
      float f1 = paramInt1;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f1;
      f1 = paramInt2;
      arrayOfFloat[2] = f1;
      arrayOfFloat[3] = f1;
      f1 = paramInt4;
      arrayOfFloat[4] = f1;
      arrayOfFloat[5] = f1;
      f1 = paramInt3;
      arrayOfFloat[6] = f1;
      arrayOfFloat[7] = f1;
      return;
    }
    throw new IllegalArgumentException("should not be less than 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */