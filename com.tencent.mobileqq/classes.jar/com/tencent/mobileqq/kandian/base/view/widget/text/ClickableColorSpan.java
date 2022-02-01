package com.tencent.mobileqq.kandian.base.view.widget.text;

import android.support.annotation.ColorInt;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;

public class ClickableColorSpan
  extends ClickableSpan
{
  private final int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  
  public ClickableColorSpan(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void onClick(@NonNull View paramView)
  {
    View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.text.ClickableColorSpan
 * JD-Core Version:    0.7.0.1
 */