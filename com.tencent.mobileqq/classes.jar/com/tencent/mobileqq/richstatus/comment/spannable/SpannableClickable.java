package com.tencent.mobileqq.richstatus.comment.spannable;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View.OnClickListener;

public abstract class SpannableClickable
  extends ClickableSpan
  implements View.OnClickListener
{
  private int a;
  
  public SpannableClickable(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.a);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.spannable.SpannableClickable
 * JD-Core Version:    0.7.0.1
 */