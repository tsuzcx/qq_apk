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
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private int b = -1;
  
  public FixedSizeBitmapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedSizeBitmapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_XY;
  }
  
  private void a()
  {
    int j = this.jdField_a_of_type_Int;
    int k = this.b;
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
      this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
      if (i != 0) {
        return;
      }
      if (ImageView.ScaleType.CENTER == this.jdField_a_of_type_AndroidWidgetImageView$ScaleType)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
        return;
      }
      float f3;
      float f1;
      float f2;
      if (ImageView.ScaleType.CENTER_CROP == this.jdField_a_of_type_AndroidWidgetImageView$ScaleType)
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
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        return;
      }
      if (ImageView.ScaleType.CENTER_INSIDE == this.jdField_a_of_type_AndroidWidgetImageView$ScaleType)
      {
        if ((j <= m) && (k <= n)) {
          f1 = 1.0F;
        } else {
          f1 = Math.min(m / j, n / k);
        }
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(m / j, n / k);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
      a();
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, 0, getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void setForgroundDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != paramBitmap)
    {
      if (paramBitmap != null)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        if ((this.jdField_a_of_type_Int != i) || (this.b != j))
        {
          this.jdField_a_of_type_Int = i;
          this.b = j;
          this.jdField_a_of_type_AndroidGraphicsMatrix = null;
        }
      }
      else
      {
        this.b = -1;
        this.jdField_a_of_type_Int = -1;
      }
      invalidate();
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != paramScaleType)
      {
        this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
        this.jdField_a_of_type_AndroidGraphicsMatrix = null;
        invalidate();
      }
      return;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.FixedSizeBitmapView
 * JD-Core Version:    0.7.0.1
 */