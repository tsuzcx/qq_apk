package com.tencent.mobileqq.flashshow.widgets.comment;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class FSReplyItemView$1
  implements FSCommentPraiseLayout.OnClickHookListener
{
  FSReplyItemView$1(FSReplyItemView paramFSReplyItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (FSReplyItemView.a(this.a) != null)
    {
      FeedCloudMeta.StComment localStComment = FSReplyItemView.b(this.a);
      FeedCloudMeta.StReply localStReply = FSReplyItemView.c(this.a);
      OnCommentElementClickListener localOnCommentElementClickListener = FSReplyItemView.a(this.a);
      FSCommentPraiseLayout localFSCommentPraiseLayout = FSReplyItemView.d(this.a);
      int i;
      if (paramBoolean) {
        i = 14;
      } else {
        i = 15;
      }
      localOnCommentElementClickListener.a(localFSCommentPraiseLayout, i, FSReplyItemView.e(this.a), new Object[] { localStComment, localStReply });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSReplyItemView.1
 * JD-Core Version:    0.7.0.1
 */