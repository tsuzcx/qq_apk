package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$ReportVideoPlayFeedbackAction
  extends ShareAction
{
  VideoShareHelper$ReportVideoPlayFeedbackAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    PlayFeedbackHelper.a(VideoShareHelper.a(this.a), paramAbsBaseArticleInfo, VideoShareHelper.a(this.a).a(paramAbsBaseArticleInfo.getInnerUniqueID()), 0, 1);
    PlayFeedbackHelper.a(paramAbsBaseArticleInfo.getInnerUniqueID(), 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportVideoPlayFeedbackAction
 * JD-Core Version:    0.7.0.1
 */