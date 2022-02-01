package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import com.tencent.qphone.base.util.QLog;

public class RedDotRadioButton
  extends RadioButton
{
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    double d = this.jdField_a_of_type_Float * 9.0F;
    Double.isNaN(d);
    this.jdField_a_of_type_Int = ((int)(d + 0.5D));
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    double d = this.jdField_a_of_type_Float * 9.0F;
    Double.isNaN(d);
    this.jdField_a_of_type_Int = ((int)(d + 0.5D));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850766);
    }
    invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        localObject = getPaint().getFontMetrics();
        float f1 = Layout.getDesiredWidth(getText(), getPaint());
        float f2 = ((Paint.FontMetrics)localObject).descent;
        float f3 = ((Paint.FontMetrics)localObject).ascent;
        int j = getWidth();
        int i = getHeight();
        int k = (int)Math.ceil(j / 2 + f1 / 2.0F - this.jdField_a_of_type_Float * 2.0F);
        j = (int)Math.ceil(i / 2 - (f2 - f3) / 2.0F - this.jdField_a_of_type_Int + this.jdField_a_of_type_Float * 4.0F);
        if (QLog.isColorLevel())
        {
          localObject = RedDotRadioButton.class.getSimpleName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reddot y:");
          localStringBuilder.append(j);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        i = j;
        if (j < 0) {
          i = 0;
        }
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        j = this.jdField_a_of_type_Int;
        ((Drawable)localObject).setBounds(k, i, k + j, j + i);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotRadioButton
 * JD-Core Version:    0.7.0.1
 */