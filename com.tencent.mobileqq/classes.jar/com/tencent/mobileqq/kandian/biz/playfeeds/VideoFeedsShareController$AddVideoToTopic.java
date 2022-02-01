package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShareController$AddVideoToTopic
  extends ShareAction
{
  VideoFeedsShareController$AddVideoToTopic(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null)
    {
      RIJUgcUtils.b(VideoFeedsShareController.a(this.a), paramVideoInfo.g, 1);
      return;
    }
    QLog.e("VideoFeedsShareController", 1, "add to topic failed, mPlayingVideoInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.AddVideoToTopic
 * JD-Core Version:    0.7.0.1
 */