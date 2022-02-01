package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class CommentLinkItemView$1
  implements MiniAppLaunchListener
{
  CommentLinkItemView$1(CommentLinkItemView paramCommentLinkItemView) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("open mini app");
    paramBundle.append(paramBoolean);
    QLog.d("CommentLinkItemView", 2, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkItemView.1
 * JD-Core Version:    0.7.0.1
 */