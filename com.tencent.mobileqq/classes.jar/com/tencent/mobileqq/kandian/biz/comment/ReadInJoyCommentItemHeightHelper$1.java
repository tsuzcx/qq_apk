package com.tencent.mobileqq.kandian.biz.comment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyCommentItemHeightHelper$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyCommentItemHeightHelper$1(ReadInJoyCommentItemHeightHelper paramReadInJoyCommentItemHeightHelper, int paramInt, View paramView) {}
  
  public void onGlobalLayout()
  {
    ReadInJoyCommentItemHeightHelper.a(this.c, this.a, this.b.getHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" position : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("   height:");
    localStringBuilder.append(this.b.getHeight());
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentItemHeightHelper.1
 * JD-Core Version:    0.7.0.1
 */