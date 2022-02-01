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
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
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
    int j;
    int i;
    if (localDrawable != null)
    {
      int k = getGravity();
      j = localDrawable.getIntrinsicHeight();
      i = 0;
      switch (k & 0x70)
      {
      }
    }
    for (;;)
    {
      localDrawable.setBounds(getWidth() - localDrawable.getIntrinsicWidth(), i, getWidth(), i + j);
      localDrawable.draw(paramCanvas);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130850490);
      }
      if (!isChecked()) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      f = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(getResources().getDimension(2131297051));
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(getResources().getString(2131717972), getWidth() - localDrawable.getIntrinsicWidth() * 2 / 3 - 2.0F * f, f * 4.0F + (j / 2 + i), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), i, null);
      return;
      i = getHeight() - j;
      continue;
      i = (getHeight() - j) / 2;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-8814455);
    float f = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(getResources().getDimension(2131297051));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(getResources().getString(2131717957), getWidth() - localDrawable.getIntrinsicWidth() / 3 + 2.0F * f, f * 4.0F + (j / 2 + i), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - localDrawable.getIntrinsicWidth(), i, null);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
        unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramDrawable.setCallback(this);
      paramDrawable.setState(getDrawableState());
      if (getVisibility() != 0) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      setMinHeight(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      refreshDrawableState();
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MyCheckBox
 * JD-Core Version:    0.7.0.1
 */