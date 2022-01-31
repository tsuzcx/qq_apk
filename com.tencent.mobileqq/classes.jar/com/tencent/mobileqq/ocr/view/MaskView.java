package com.tencent.mobileqq.ocr.view;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class MaskView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean;
  
  public MaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845149);
    this.jdField_a_of_type_Int = aekt.a(3.0F, getResources());
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int j;
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      j = localDisplayMetrics.widthPixels;
      i = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      int k = j - aekt.a(18.0F, getResources());
      int m = k * 424 / 680;
      int n = (j - k) / 2 + 0;
      int i1 = (i - m) / 2 + 0;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(n, i1, n + k, i1 + m);
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_Int + n, this.jdField_a_of_type_Int + i1, k + n - this.jdField_a_of_type_Int, m + i1 - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_b_of_type_AndroidGraphicsRect.left * 1.0F / j, this.jdField_b_of_type_AndroidGraphicsRect.top * 1.0F / i, this.jdField_b_of_type_AndroidGraphicsRect.right * 1.0F / j, this.jdField_b_of_type_AndroidGraphicsRect.bottom * 1.0F / i);
      if (QLog.isColorLevel()) {
        QLog.d("MaskView", 2, new Object[] { "MaskView init mBoxRect:", this.jdField_a_of_type_AndroidGraphicsRect, " screenHeight: ", Integer.valueOf(i), " screenWidth: ", Integer.valueOf(j), "mPreviewRect:", this.jdField_b_of_type_AndroidGraphicsRect, "mPreviewRectF:", this.jdField_a_of_type_AndroidGraphicsRectF });
      }
      return;
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
  }
  
  public Rect a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(new Rect(0, 0, getWidth(), this.jdField_b_of_type_AndroidGraphicsRect.top), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(new Rect(0, this.jdField_b_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight()), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(new Rect(0, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.bottom), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(new Rect(this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.top, getHeight(), this.jdField_b_of_type_AndroidGraphicsRect.bottom), this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  public void setIsDisplayRect(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setModel(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    invalidate();
  }
  
  public void setPreviewDrawable(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.MaskView
 * JD-Core Version:    0.7.0.1
 */