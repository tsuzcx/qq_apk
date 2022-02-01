package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;

class ReadInJoyCommentLikeView$1
  implements View.OnClickListener
{
  ReadInJoyCommentLikeView$1(ReadInJoyCommentLikeView paramReadInJoyCommentLikeView) {}
  
  public void onClick(View paramView)
  {
    if (RIJAppSetting.e()) {
      return;
    }
    if (ReadInJoyCommentLikeView.a(this.a) != null)
    {
      if (ReadInJoyCommentLikeView.a(this.a).isLiked())
      {
        if (ReadInJoyCommentLikeView.a(this.a) != null) {
          ReadInJoyCommentLikeView.a(this.a).a(ReadInJoyCommentLikeView.a(this.a).commentId, 0, 0);
        }
      }
      else if (ReadInJoyCommentLikeView.a(this.a) != null) {
        ReadInJoyCommentLikeView.a(this.a).a(ReadInJoyCommentLikeView.a(this.a).commentId, 1, 0);
      }
      paramView = this.a;
      ReadInJoyCommentLikeView.a(paramView, ReadInJoyCommentLikeView.a(paramView));
      ReadInJoyCommentLikeView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentLikeView.1
 * JD-Core Version:    0.7.0.1
 */