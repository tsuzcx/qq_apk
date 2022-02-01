package com.tencent.mobileqq.kandian.base.view.widget;

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

public class LeftRedDotRadioButton
  extends RadioButton
{
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public LeftRedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LeftRedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    double d = this.jdField_a_of_type_Float * 9.0F;
    Double.isNaN(d);
    this.jdField_a_of_type_Int = ((int)(d + 0.5D));
  }
  
  public LeftRedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
        Layout.getDesiredWidth(getText(), getPaint());
        float f1 = ((Paint.FontMetrics)localObject).descent;
        float f2 = ((Paint.FontMetrics)localObject).ascent;
        getWidth();
        int j = (int)Math.ceil(getHeight() / 2 - (f1 - f2) / 2.0F - this.jdField_a_of_type_Int + this.jdField_a_of_type_Float * 4.0F);
        if (QLog.isColorLevel())
        {
          localObject = LeftRedDotRadioButton.class.getSimpleName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reddot y:");
          localStringBuilder.append(j);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        int i = j;
        if (j < 0) {
          i = 0;
        }
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        j = this.jdField_a_of_type_Int;
        ((Drawable)localObject).setBounds(0, i, 0 + j, j + i);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.LeftRedDotRadioButton
 * JD-Core Version:    0.7.0.1
 */