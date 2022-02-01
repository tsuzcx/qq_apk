package com.tencent.mobileqq.flashshow.list.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.helper.FSBindPhoneNumberHelper;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSReplyMessagePresenter$4
  implements View.OnClickListener
{
  FSReplyMessagePresenter$4(FSReplyMessagePresenter paramFSReplyMessagePresenter, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.a instanceof Activity)) {
      if (!FSBindPhoneNumberHelper.a())
      {
        FSBindPhoneNumberHelper.a(this.a, 3);
      }
      else
      {
        FSFeedCommentInfo localFSFeedCommentInfo = FSReplyMessagePresenter.c(this.b);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startReply getFeedCommentInfo is");
        boolean bool;
        if (localFSFeedCommentInfo != null) {
          bool = true;
        } else {
          bool = false;
        }
        localStringBuilder.append(bool);
        QLog.d("FSReplyMessagePresenter", 1, localStringBuilder.toString());
        if (localFSFeedCommentInfo != null)
        {
          FSCommentHelper.a().a((Activity)this.a, localFSFeedCommentInfo, FSReplyMessagePresenter.a(this.b), FSReplyMessagePresenter.b(this.b), false);
          FSReplyMessagePresenter.a(this.b, paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSReplyMessagePresenter.4
 * JD-Core Version:    0.7.0.1
 */