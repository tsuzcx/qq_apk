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
  private Drawable a;
  private Paint b = new Paint();
  private Bitmap c = null;
  
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
    if (this.a != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.a.setState(arrayOfInt);
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
    Drawable localDrawable = this.a;
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
      if (this.c == null) {
        this.c = BitmapFactory.decodeResource(getResources(), 2130852715);
      }
      if (isChecked())
      {
        this.b.setColor(-1);
        f = getResources().getDisplayMetrics().density;
        this.b.setTextSize(getResources().getDimension(2131297491));
        this.b.setAntiAlias(true);
        this.b.setTextAlign(Paint.Align.CENTER);
        paramCanvas.drawText(getResources().getString(2131916373), getWidth() - localDrawable.getIntrinsicWidth() * 2 / 3 - 2.0F * f, j / 2 + i + f * 4.0F, this.b);
        paramCanvas.drawBitmap(this.c, getWidth() - this.c.getWidth(), i, null);
        return;
      }
      this.b.setColor(-8814455);
      float f = getResources().getDisplayMetrics().density;
      this.b.setTextSize(getResources().getDimension(2131297491));
      this.b.setAntiAlias(true);
      this.b.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(getResources().getString(2131916333), getWidth() - localDrawable.getIntrinsicWidth() / 3 + 2.0F * f, j / 2 + i + f * 4.0F, this.b);
      paramCanvas.drawBitmap(this.c, getWidth() - localDrawable.getIntrinsicWidth(), i, null);
    }
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      Drawable localDrawable = this.a;
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.a);
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
      this.a = paramDrawable;
      setMinHeight(this.a.getIntrinsicHeight());
    }
    refreshDrawableState();
  }
  
  public void setButtonGray(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setAlpha(255);
      return;
    }
    this.a.setAlpha(128);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MyCheckBox
 * JD-Core Version:    0.7.0.1
 */