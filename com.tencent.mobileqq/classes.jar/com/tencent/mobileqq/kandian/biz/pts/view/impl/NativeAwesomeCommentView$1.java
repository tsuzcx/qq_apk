package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;

class NativeAwesomeCommentView$1
  extends ClickableSpan
{
  NativeAwesomeCommentView$1(NativeAwesomeCommentView paramNativeAwesomeCommentView) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.a(this.a) != null)
    {
      long l = NativeAwesomeCommentView.a(this.a).f;
      NativeAwesomeCommentView.a(this.a, true);
      paramView = new StringBuilder();
      paramView.append(l);
      paramView.append("");
      ReadInJoyCommentUtils.a(paramView.toString(), this.a.getContext());
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView.1
 * JD-Core Version:    0.7.0.1
 */