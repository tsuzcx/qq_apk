package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;

class CommentRichTextView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView).a.commentId;
  
  CommentRichTextView$2(CommentRichTextView paramCommentRichTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView) != null) && (CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView).a != null))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null)
      {
        if (!str.equals(CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView).a.commentId))
        {
          CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView, this.jdField_a_of_type_AndroidViewView);
          return;
        }
        int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
        CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView).setAlpha(i);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView));
        return;
      }
    }
    CommentRichTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiCommentRichTextView, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentRichTextView.2
 * JD-Core Version:    0.7.0.1
 */