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
    float f2 = 0.0F;
    int j = this.jdField_a_of_type_Int;
    int k = this.b;
    if ((j <= 0) || (k <= 0)) {
      return;
    }
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
      if (i != 0) {
        break;
      }
      if (ImageView.ScaleType.CENTER != this.jdField_a_of_type_AndroidWidgetImageView$ScaleType) {
        break label152;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      return;
    }
    label152:
    float f3;
    float f1;
    if (ImageView.ScaleType.CENTER_CROP == this.jdField_a_of_type_AndroidWidgetImageView$ScaleType)
    {
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
      }
      for (f1 = 0.0F;; f1 = (n - k * f3) * 0.5F)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        return;
        f3 = m / j;
      }
    }
    if (ImageView.ScaleType.CENTER_INSIDE == this.jdField_a_of_type_AndroidWidgetImageView$ScaleType)
    {
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
        return;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(m / j, n / k);
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
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
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
      if (paramBitmap == null) {
        break label63;
      }
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
    for (;;)
    {
      invalidate();
      return;
      label63:
      this.b = -1;
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      throw new NullPointerException();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != paramScaleType)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      this.jdField_a_of_type_AndroidGraphicsMatrix = null;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.FixedSizeBitmapView
 * JD-Core Version:    0.7.0.1
 */