package com.tencent.mobileqq.richstatus.comment.widget;

import android.view.View;
import com.tencent.mobileqq.richstatus.comment.spannable.SpannableClickable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentsView$3
  extends SpannableClickable
{
  CommentsView$3(CommentsView paramCommentsView, int paramInt, String paramString)
  {
    super(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (CommentsView.c(this.b) != null) {
      CommentsView.c(this.b).a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView.3
 * JD-Core Version:    0.7.0.1
 */