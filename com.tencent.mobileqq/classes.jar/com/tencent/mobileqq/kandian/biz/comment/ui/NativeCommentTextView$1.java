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
  String a = NativeCommentTextView.a(this.c).c.commentId;
  
  NativeCommentTextView$1(NativeCommentTextView paramNativeCommentTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((NativeCommentTextView.a(this.c) != null) && (NativeCommentTextView.a(this.c).c != null))
    {
      String str = this.a;
      if (str != null)
      {
        if (!str.equals(NativeCommentTextView.a(this.c).c.commentId))
        {
          NativeCommentTextView.a(this.c, this.b);
          return;
        }
        int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
        NativeCommentTextView.b(this.c).setAlpha(i);
        this.b.setBackgroundDrawable(NativeCommentTextView.b(this.c));
        return;
      }
    }
    NativeCommentTextView.a(this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeCommentTextView.1
 * JD-Core Version:    0.7.0.1
 */