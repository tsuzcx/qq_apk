package com.tencent.mobileqq.kandian.base.view.widget.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class PressedSpan
  extends ClickableSpan
  implements ClickableSpanPressed, ISpan
{
  boolean a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private TextPaint e;
  private View.OnClickListener f;
  
  public PressedSpan(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    TextPaint localTextPaint = this.e;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.f;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(paramView);
      return;
    }
    paramView.callOnClick();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.e = paramTextPaint;
    this.e.setColor(this.d);
    paramTextPaint = this.e;
    int i;
    if (this.a) {
      i = this.c;
    } else {
      i = this.b;
    }
    paramTextPaint.bgColor = i;
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan
 * JD-Core Version:    0.7.0.1
 */