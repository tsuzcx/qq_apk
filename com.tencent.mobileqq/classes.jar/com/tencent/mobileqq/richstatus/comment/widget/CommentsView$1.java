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
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentSpannableCommentMovementMethod.a()) && (CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView) != null)) {
      CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView).a(this.jdField_a_of_type_Int, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView.1
 * JD-Core Version:    0.7.0.1
 */