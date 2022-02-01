package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;

class NativeAwesomeCommentView$4
  implements View.OnClickListener
{
  NativeAwesomeCommentView$4(NativeAwesomeCommentView paramNativeAwesomeCommentView, AwesomeCommentInfo paramAwesomeCommentInfo) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.c(this.b))
    {
      NativeAwesomeCommentView.a(this.b, false);
      return;
    }
    if (this.a != null)
    {
      RIJJumpUtils.a(this.b.getContext(), this.a.n, this.a.e);
      AwesomeCommentInfo.a(NativeAwesomeCommentView.a(this.b).n, "0X8009B77", RIJBaseItemViewType.a(NativeAwesomeCommentView.a(this.b).n, 0), NativeAwesomeCommentView.getMaxLines());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView.4
 * JD-Core Version:    0.7.0.1
 */