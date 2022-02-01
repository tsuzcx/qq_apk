package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$ReportVideoPlayFeedbackAction
  extends ShareAction
{
  VideoFeedsShareController$ReportVideoPlayFeedbackAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.l)) && (VideoFeedsShareController.b(this.a).v() != null))
    {
      PlayFeedbackHelper.a(VideoFeedsShareController.f(this.a), FeedsChannelDataHelper.a(paramVideoInfo), (VideoPlayerWrapper)VideoFeedsShareController.b(this.a).v().h, 2, 0);
      PlayFeedbackHelper.a(paramVideoInfo.l, 2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportVideoPlayFeedbackAction
 * JD-Core Version:    0.7.0.1
 */