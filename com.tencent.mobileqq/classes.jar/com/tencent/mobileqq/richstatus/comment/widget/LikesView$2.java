package com.tencent.mobileqq.richstatus.comment.widget;

import android.view.View;
import com.tencent.mobileqq.richstatus.comment.spannable.SpannableClickable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LikesView$2
  extends SpannableClickable
{
  LikesView$2(LikesView paramLikesView, int paramInt, String paramString)
  {
    super(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (LikesView.a(this.b) != null) {
      LikesView.a(this.b).a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.LikesView.2
 * JD-Core Version:    0.7.0.1
 */