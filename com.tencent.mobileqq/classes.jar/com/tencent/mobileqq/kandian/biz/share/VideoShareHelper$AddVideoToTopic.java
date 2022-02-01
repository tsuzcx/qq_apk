package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class VideoShareHelper$AddVideoToTopic
  extends ShareAction
{
  VideoShareHelper$AddVideoToTopic(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramAbsBaseArticleInfo = VideoShareHelper.a(this.a);
    if (paramAbsBaseArticleInfo != null)
    {
      RIJUgcUtils.b(VideoShareHelper.a(this.a), paramAbsBaseArticleInfo.innerUniqueID, 3);
      return;
    }
    QLog.e("Q.readinjoy.video.VideoShareHelper", 1, "add video to topic failed, mArticleInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.AddVideoToTopic
 * JD-Core Version:    0.7.0.1
 */