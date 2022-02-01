package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;

public class FixedSizeBitmapView
  extends View
{
  private Bitmap a;
  private Drawable b;
  private int c = -1;
  private int d = -1;
  private ImageView.ScaleType e;
  private Paint f = new Paint();
  private Matrix g;
  private Rect h = new Rect(0, 0, 0, 0);
  
  public FixedSizeBitmapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedSizeBitmapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f.setAntiAlias(true);
    this.e = ImageView.ScaleType.FIT_XY;
  }
  
  private void a()
  {
    int j = this.c;
    int k = this.d;
    if (j > 0)
    {
      if (k <= 0) {
        return;
      }
      int m = getWidth() - getPaddingLeft() - getPaddingRight();
      int n = getHeight() - getPaddingTop() - getPaddingBottom();
      int i;
      if (((j >= 0) && (m != j)) || ((k >= 0) && (n != k))) {
        i = 0;
      } else {
        i = 1;
      }
      this.g = new Matrix();
      if (i != 0) {
        return;
      }
      if (ImageView.ScaleType.CENTER == this.e)
      {
        this.g.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
        return;
      }
      float f3;
      float f1;
      float f2;
      if (ImageView.ScaleType.CENTER_CROP == this.e)
      {
        f3 = 0.0F;
        if (j * n > m * k)
        {
          f1 = n / k;
          f3 = (m - j * f1) * 0.5F;
          f2 = 0.0F;
        }
        else
        {
          f1 = m / j;
          f2 = (n - k * f1) * 0.5F;
        }
        this.g.setScale(f1, f1);
        this.g.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        return;
      }
      if (ImageView.ScaleType.CENTER_INSIDE == this.e)
      {
        if ((j <= m) && (k <= n)) {
          f1 = 1.0F;
        } else {
          f1 = Math.min(m / j, n / k);
        }
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.g.setScale(f1, f1);
        this.g.postTranslate(f2, f3);
        return;
      }
      this.g.setScale(m / j, n / k);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == null) {
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.g == null) {
      a();
    }
    paramCanvas.drawBitmap(this.a, this.g, this.f);
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, 0, getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
      this.b.draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void setForgroundDrawable(Drawable paramDrawable)
  {
    if (this.b != paramDrawable)
    {
      this.b = paramDrawable;
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.a != paramBitmap)
    {
      if (paramBitmap != null)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        this.a = paramBitmap;
        if ((this.c != i) || (this.d != j))
        {
          this.c = i;
          this.d = j;
          this.g = null;
        }
      }
      else
      {
        this.d = -1;
        this.c = -1;
      }
      invalidate();
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != null)
    {
      if (this.e != paramScaleType)
      {
        this.e = paramScaleType;
        this.g = null;
        invalidate();
      }
      return;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FixedSizeBitmapView
 * JD-Core Version:    0.7.0.1
 */