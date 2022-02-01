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
  String a = CommentRichTextView.b(this.c).c.commentId;
  
  CommentRichTextView$2(CommentRichTextView paramCommentRichTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((CommentRichTextView.b(this.c) != null) && (CommentRichTextView.b(this.c).c != null))
    {
      String str = this.a;
      if (str != null)
      {
        if (!str.equals(CommentRichTextView.b(this.c).c.commentId))
        {
          CommentRichTextView.a(this.c, this.b);
          return;
        }
        int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
        CommentRichTextView.c(this.c).setAlpha(i);
        this.b.setBackgroundDrawable(CommentRichTextView.c(this.c));
        return;
      }
    }
    CommentRichTextView.a(this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentRichTextView.2
 * JD-Core Version:    0.7.0.1
 */