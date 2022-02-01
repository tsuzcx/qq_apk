package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;

public class NativeUsersCommentsView$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  boolean a;
  private int b;
  private TextPaint c;
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    TextPaint localTextPaint = this.c;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.c = paramTextPaint;
    this.c.setColor(Color.parseColor("#FF4D7CAF"));
    paramTextPaint = this.c;
    int i;
    if (this.a) {
      i = 860716207;
    } else {
      i = this.b;
    }
    paramTextPaint.bgColor = i;
    this.c.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeUsersCommentsView.UserSpan
 * JD-Core Version:    0.7.0.1
 */