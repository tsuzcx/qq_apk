package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import blqj;
import blqk;

public class LabelTextView
  extends TextView
  implements blqk
{
  private int jdField_a_of_type_Int = 2147483647;
  protected blqj a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public LabelTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setMaxLines(1);
    setGravity(17);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Blqj = new blqj();
    this.jdField_a_of_type_Blqj.a(true);
    this.jdField_a_of_type_Blqj.a(blqj.c);
  }
  
  public void a_(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.b) && (this.jdField_a_of_type_Blqj != null))
    {
      this.jdField_a_of_type_Blqj.a(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      if (getMeasuredWidth() >= this.jdField_a_of_type_Int) {
        break label38;
      }
      if (getVisibility() == 0) {
        setVisibility(8);
      }
    }
    label38:
    while (getVisibility() == 0) {
      return;
    }
    setVisibility(0);
  }
  
  public void setMinWidthCheck(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void setParam(int paramInt1, int paramInt2, float paramFloat)
  {
    setTextColor(paramInt2);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setCornerRadius(paramFloat);
    setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.LabelTextView
 * JD-Core Version:    0.7.0.1
 */