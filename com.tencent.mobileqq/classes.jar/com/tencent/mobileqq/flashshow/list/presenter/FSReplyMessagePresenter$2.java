package com.tencent.mobileqq.flashshow.list.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.helper.FSBindPhoneNumberHelper;
import com.tencent.mobileqq.flashshow.view.message.FSMessageReplyItemView.FSMessageReplyItemListener;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;

class FSReplyMessagePresenter$2
  implements FSMessageReplyItemView.FSMessageReplyItemListener
{
  FSReplyMessagePresenter$2(FSReplyMessagePresenter paramFSReplyMessagePresenter, Context paramContext) {}
  
  public void a(View paramView, FSFeedCommentInfo paramFSFeedCommentInfo)
  {
    if ((paramFSFeedCommentInfo != null) && (FSReplyMessagePresenter.a(this.b) != null))
    {
      if (!FSBindPhoneNumberHelper.a())
      {
        FSBindPhoneNumberHelper.a(this.a, 3);
        return;
      }
      FSCommentHelper.a().a((Activity)this.a, paramFSFeedCommentInfo, FSReplyMessagePresenter.a(this.b), FSReplyMessagePresenter.b(this.b), false);
      FSReplyMessagePresenter.a(this.b, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSReplyMessagePresenter.2
 * JD-Core Version:    0.7.0.1
 */