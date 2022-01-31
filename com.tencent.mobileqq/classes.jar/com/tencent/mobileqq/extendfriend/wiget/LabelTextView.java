package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import beog;
import beoh;

public class LabelTextView
  extends TextView
  implements beoh
{
  private int a;
  protected beog a;
  
  public LabelTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2147483647;
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2147483647;
    a();
  }
  
  public LabelTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2147483647;
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
    this.jdField_a_of_type_Beog = new beog();
    this.jdField_a_of_type_Beog.a(true);
    this.jdField_a_of_type_Beog.a(beog.c);
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Beog != null)
    {
      this.jdField_a_of_type_Beog.a(paramCanvas, this);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredWidth() < this.jdField_a_of_type_Int) {
      if (getVisibility() == 0) {
        setVisibility(8);
      }
    }
    while (getVisibility() == 0) {
      return;
    }
    setVisibility(0);
  }
  
  public void setMinWidthCheck(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.LabelTextView
 * JD-Core Version:    0.7.0.1
 */