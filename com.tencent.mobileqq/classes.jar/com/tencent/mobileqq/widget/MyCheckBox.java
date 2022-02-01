package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;

public class MyCheckBox
  extends CompoundButton
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public MyCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842860);
  }
  
  public MyCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      int k = getGravity() & 0x70;
      int j = localDrawable.getIntrinsicHeight();
      int i = 0;
      if (k != 16)
      {
        if (k == 80) {
          i = getHeight() - j;
        }
      }
      else {
        i = (getHeight() - j) / 2;
      }
      localDrawable.setBounds(getWidth() - localDrawable.getIntrinsicWidth(), i, getWidth(), i + j);
      localDrawable.draw(paramCanvas);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130850864);
      }
      if (isChecked())
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        f = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(getResources().getDimension(2131297110));
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
        paramCanvas.drawText(getResources().getString(2131718841), getWidth() - localDrawable.getIntrinsicWidth() * 2 / 3 - 2.0F * f, j / 2 + i + f * 4.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), i, null);
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-8814455);
      float f = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(getResources().getDimension(2131297110));
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(getResources().getString(2131718825), getWidth() - localDrawable.getIntrinsicWidth() / 3 + 2.0F * f, j / 2 + i + f * 4.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - localDrawable.getIntrinsicWidth(), i, null);
    }
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramDrawable.setCallback(this);
      paramDrawable.setState(getDrawableState());
      boolean bool;
      if (getVisibility() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramDrawable.setVisible(bool, false);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      setMinHeight(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
    refreshDrawableState();
  }
  
  public void setButtonGray(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(255);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(128);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MyCheckBox
 * JD-Core Version:    0.7.0.1
 */