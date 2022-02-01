package com.tencent.mobileqq.flashshow.widgets.comment.helper;

import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow.OnCommentPopupHeightChangeListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class FSCommentHelper$2
  implements FSCommentInputPopupWindow.OnCommentPopupHeightChangeListener
{
  FSCommentHelper$2(FSCommentHelper paramFSCommentHelper, FSFeedCommentInfo paramFSFeedCommentInfo) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a.id.get();
    QLog.d("FSC-FSCommentHelper", 1, new Object[] { "onCommentPopupHeightChange() keyboardHeight: ", Integer.valueOf(paramInt1), " | inputPanelHeight: ", Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.2
 * JD-Core Version:    0.7.0.1
 */