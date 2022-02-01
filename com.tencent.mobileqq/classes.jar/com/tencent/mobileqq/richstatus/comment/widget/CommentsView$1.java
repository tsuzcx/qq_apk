package com.tencent.mobileqq.richstatus.comment.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.comment.spannable.CommentMovementMethod;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentsView$1
  implements View.OnClickListener
{
  CommentsView$1(CommentsView paramCommentsView, CommentMovementMethod paramCommentMovementMethod, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a()) && (CommentsView.a(this.c) != null)) {
      CommentsView.a(this.c).a(this.b, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView.1
 * JD-Core Version:    0.7.0.1
 */