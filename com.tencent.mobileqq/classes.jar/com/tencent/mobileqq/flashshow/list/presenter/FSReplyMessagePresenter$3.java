package com.tencent.mobileqq.flashshow.list.presenter;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.list.adapter.FSMessageReplyAdapter;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.CommentInputListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class FSReplyMessagePresenter$3
  implements FSCommentHelper.CommentInputListener
{
  FSReplyMessagePresenter$3(FSReplyMessagePresenter paramFSReplyMessagePresenter) {}
  
  public void a(int paramInt) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFakeComment stComment");
    localStringBuilder.append(paramStComment.id.get());
    QLog.d("FSReplyMessagePresenter", 1, localStringBuilder.toString());
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addFakeReply stReply");
    ((StringBuilder)localObject).append(paramStReply.id.get());
    QLog.d("FSReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
    localObject = FSReplyMessagePresenter.c(this.a);
    if (localObject != null)
    {
      ((FSFeedCommentInfo)localObject).c = paramStReply;
      paramStReply = FSReplyMessagePresenter.d(this.a);
      if (!TextUtils.isEmpty(paramStReply))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFakeReplysKey");
        localStringBuilder.append(paramStReply);
        QLog.d("FSReplyMessagePresenter", 1, localStringBuilder.toString());
        paramStReply = FSCommentHelper.a().a(paramStReply, (FSFeedCommentInfo)localObject);
        FSReplyMessagePresenter.e(this.a).a(paramStReply);
        FSReplyMessagePresenter.e(this.a).notifyDataSetChanged();
      }
      else
      {
        QLog.d("FSReplyMessagePresenter", 1, "getFakeReplysKey error");
      }
      FSReplyMessagePresenter.a(this.a, (FSFeedCommentInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSReplyMessagePresenter.3
 * JD-Core Version:    0.7.0.1
 */