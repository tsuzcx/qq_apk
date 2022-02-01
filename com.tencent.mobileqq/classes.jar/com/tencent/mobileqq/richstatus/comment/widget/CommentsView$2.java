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
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentSpannableCommentMovementMethod.a())
    {
      if (CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView) != null) {
        CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView).a(this.jdField_a_of_type_Int, paramView);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView.2
 * JD-Core Version:    0.7.0.1
 */