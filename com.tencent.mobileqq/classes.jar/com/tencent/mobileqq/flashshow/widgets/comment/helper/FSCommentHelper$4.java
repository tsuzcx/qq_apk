package com.tencent.mobileqq.flashshow.widgets.comment.helper;

import com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.OnDismissListener;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class FSCommentHelper$4
  implements FSBaseInputPopupWindow.OnDismissListener
{
  FSCommentHelper$4(FSCommentHelper paramFSCommentHelper, FSCommentInputPopupWindow paramFSCommentInputPopupWindow, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, FSCommentHelper.CommentInputListener paramCommentInputListener, int paramInt) {}
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((FSCommentInputPopupWindow)localObject).b("");
      FSCommentHelper.a().a(this.b, this.c, this.d, this.a.g());
      this.a.a("");
      this.a.b(this.g.a(null, null));
    }
    FSCommentHelper.b(this.g, null);
    FSCommentHelper.a(this.g, null);
    localObject = this.e;
    if (localObject != null) {
      ((FSCommentHelper.CommentInputListener)localObject).a(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.4
 * JD-Core Version:    0.7.0.1
 */