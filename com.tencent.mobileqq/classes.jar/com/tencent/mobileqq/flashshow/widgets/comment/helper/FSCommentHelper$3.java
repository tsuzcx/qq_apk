package com.tencent.mobileqq.flashshow.widgets.comment.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class FSCommentHelper$3
  implements DialogInterface.OnShowListener
{
  FSCommentHelper$3(FSCommentHelper paramFSCommentHelper, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, FSCommentInputPopupWindow paramFSCommentInputPopupWindow) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = FSCommentHelper.a().a(this.a, this.b, this.c);
    FSCommentInputPopupWindow localFSCommentInputPopupWindow = this.d;
    localFSCommentInputPopupWindow.a(localFSCommentInputPopupWindow.c(paramDialogInterface));
    this.d.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.3
 * JD-Core Version:    0.7.0.1
 */