package com.tencent.mobileqq.flashshow.list.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSReplyMessagePresenter$5
  implements View.OnClickListener
{
  FSReplyMessagePresenter$5(FSReplyMessagePresenter paramFSReplyMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.callOnClick();
    }
    FSFeedCommentInfo localFSFeedCommentInfo = FSReplyMessagePresenter.c(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tvTime getFeedCommentInfo is");
    boolean bool;
    if (localFSFeedCommentInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("FSReplyMessagePresenter", 1, localStringBuilder.toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSReplyMessagePresenter.5
 * JD-Core Version:    0.7.0.1
 */