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
  private final int a;
  private View.OnClickListener b;
  
  public ClickableColorSpan(@ColorInt int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void onClick(@NonNull View paramView)
  {
    View.OnClickListener localOnClickListener = this.b;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.text.ClickableColorSpan
 * JD-Core Version:    0.7.0.1
 */