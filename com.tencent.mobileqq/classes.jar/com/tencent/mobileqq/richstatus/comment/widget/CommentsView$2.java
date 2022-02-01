package com.tencent.mobileqq.richstatus.comment.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.richstatus.comment.spannable.CommentMovementMethod;

class CommentsView$2
  implements View.OnLongClickListener
{
  CommentsView$2(CommentsView paramCommentsView, CommentMovementMethod paramCommentMovementMethod, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a())
    {
      if (CommentsView.b(this.c) != null) {
        CommentsView.b(this.c).a(this.b, paramView);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView.2
 * JD-Core Version:    0.7.0.1
 */