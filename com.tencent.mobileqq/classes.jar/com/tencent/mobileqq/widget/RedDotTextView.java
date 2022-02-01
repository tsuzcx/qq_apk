package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class RedDotTextView
  extends TextView
{
  private static String jdField_a_of_type_JavaLangString = "RedDotTextView";
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public RedDotTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    double d = this.jdField_a_of_type_Float * 9.0F;
    Double.isNaN(d);
    this.jdField_a_of_type_Int = ((int)(d + 0.5D));
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850766);
      }
      Object localObject = getText().toString();
      TextPaint localTextPaint = getPaint();
      localTextPaint.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.jdField_a_of_type_AndroidGraphicsRect);
      float f3 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      float f1 = Layout.getDesiredWidth((CharSequence)localObject, localTextPaint);
      int i = getWidth();
      int j = getHeight();
      float f4 = i / 2;
      float f5 = f1 / 2.0F;
      boolean bool = this.b;
      float f2 = 0.0F;
      if (bool) {
        f1 = this.jdField_a_of_type_Float * 2.0F;
      } else {
        f1 = 0.0F;
      }
      i = (int)(f4 + f5 - f1);
      f4 = j / 2;
      f3 /= 2.0F;
      f5 = this.jdField_a_of_type_Int;
      f1 = f2;
      if (this.b) {
        f1 = this.jdField_a_of_type_Float * 2.0F;
      }
      j = (int)(f4 - f3 - f5 + f1);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      int k = this.jdField_a_of_type_Int;
      ((Drawable)localObject).setBounds(i, j, i + k, k + j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean2;
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    a(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RedDotTextView
 * JD-Core Version:    0.7.0.1
 */