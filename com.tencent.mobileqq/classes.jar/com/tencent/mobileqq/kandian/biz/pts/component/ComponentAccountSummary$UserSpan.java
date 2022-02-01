package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.Base64Util;

public class ComponentAccountSummary$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  protected String a;
  boolean b;
  private int d = -1;
  private TextPaint e;
  
  public ComponentAccountSummary$UserSpan(ComponentAccountSummary paramComponentAccountSummary, String paramString, int paramInt)
  {
    this.a = paramString;
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
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = this.c.a.a.k();
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.l);
    paramView.append(Base64Util.encodeToString(String.valueOf(this.a).getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(this.c.getContext(), paramView);
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
      i = 16119285;
    }
    paramTextPaint.bgColor = i;
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentAccountSummary.UserSpan
 * JD-Core Version:    0.7.0.1
 */