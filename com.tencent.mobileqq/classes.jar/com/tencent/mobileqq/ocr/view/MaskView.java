package com.tencent.mobileqq.ocr.view;

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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class MaskView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean = false;
  
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845786);
    this.jdField_a_of_type_Int = DisplayUtil.a(getContext(), 3.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i;
    int j;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    else
    {
      j = localDisplayMetrics.widthPixels;
      i = localDisplayMetrics.heightPixels;
    }
    int n = i - DisplayUtil.a(getContext(), 18.0F);
    int i1 = n * 424 / 680;
    int k = (i - n) / 2 + 0;
    int m = (j - i1) / 2 + 0;
    n += k;
    i1 += m;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(k, m, n, i1);
    int i2 = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(k + i2, m + i2, n - i2, i1 - i2);
    float f2 = this.jdField_b_of_type_AndroidGraphicsRect.left;
    float f1 = i;
    f2 = f2 * 1.0F / f1;
    float f3 = this.jdField_b_of_type_AndroidGraphicsRect.top;
    float f4 = j;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f2, f3 * 1.0F / f4, this.jdField_b_of_type_AndroidGraphicsRect.right * 1.0F / f1, this.jdField_b_of_type_AndroidGraphicsRect.bottom * 1.0F / f4);
    if (QLog.isColorLevel()) {
      QLog.d("MaskView", 2, new Object[] { "MaskView init mBoxRect:", this.jdField_a_of_type_AndroidGraphicsRect, " screenHeight: ", Integer.valueOf(j), " screenWidth: ", Integer.valueOf(i), "mPreviewRect:", this.jdField_b_of_type_AndroidGraphicsRect, "mPreviewRectF:", this.jdField_a_of_type_AndroidGraphicsRectF });
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
    } else {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(new Rect(0, 0, getWidth(), this.jdField_b_of_type_AndroidGraphicsRect.top), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(new Rect(0, this.jdField_b_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight()), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(new Rect(0, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.bottom), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(new Rect(this.jdField_b_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.top, getHeight(), this.jdField_b_of_type_AndroidGraphicsRect.bottom), this.jdField_a_of_type_AndroidGraphicsPaint);
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (this.jdField_b_of_type_Boolean))
    {
      localDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.MaskView
 * JD-Core Version:    0.7.0.1
 */