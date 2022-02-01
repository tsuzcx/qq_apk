package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;

class NativeCommentTextView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView).a.commentId;
  
  NativeCommentTextView$1(NativeCommentTextView paramNativeCommentTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView) != null) && (NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView).a != null))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null)
      {
        if (!str.equals(NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView).a.commentId))
        {
          NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView, this.jdField_a_of_type_AndroidViewView);
          return;
        }
        int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
        NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView).setAlpha(i);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView));
        return;
      }
    }
    NativeCommentTextView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiNativeCommentTextView, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeCommentTextView.1
 * JD-Core Version:    0.7.0.1
 */