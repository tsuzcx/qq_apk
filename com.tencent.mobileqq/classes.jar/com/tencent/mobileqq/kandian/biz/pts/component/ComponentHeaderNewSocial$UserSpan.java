package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;

public class ComponentHeaderNewSocial$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  protected long a;
  boolean b;
  private int d = -1;
  private TextPaint e;
  
  public ComponentHeaderNewSocial$UserSpan(ComponentHeaderNewSocial paramComponentHeaderNewSocial, long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.d = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    TextPaint localTextPaint = this.e;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    this.c.a(this.a);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.e = paramTextPaint;
    this.e.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.e;
    int i;
    if (this.b) {
      i = this.d;
    } else {
      i = -1;
    }
    paramTextPaint.bgColor = i;
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial.UserSpan
 * JD-Core Version:    0.7.0.1
 */