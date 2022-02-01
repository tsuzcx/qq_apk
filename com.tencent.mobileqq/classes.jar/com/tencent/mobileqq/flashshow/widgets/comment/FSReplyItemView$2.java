package com.tencent.mobileqq.flashshow.widgets.comment;

import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView.OnClickBoldTextListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class FSReplyItemView$2
  implements FSAsyncTextView.OnClickBoldTextListener
{
  FSReplyItemView$2(FSReplyItemView paramFSReplyItemView, FeedCloudMeta.StReply paramStReply) {}
  
  public void a()
  {
    FSReplyItemView.a(this.b, this.a.targetUser.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSReplyItemView.2
 * JD-Core Version:    0.7.0.1
 */