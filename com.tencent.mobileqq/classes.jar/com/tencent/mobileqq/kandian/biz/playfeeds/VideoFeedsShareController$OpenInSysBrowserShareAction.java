package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$OpenInSysBrowserShareAction
  extends ShareAction
{
  VideoFeedsShareController$OpenInSysBrowserShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
    if ((paramVideoInfo.m != null) && (paramVideoInfo.m.contains("kandianshare.html5.qq.com")))
    {
      this.a.a.b(paramVideoInfo.m);
      return;
    }
    paramVideoInfo = this.a.a;
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    paramVideoInfo.b(paramActionSheetItem.toString());
  }
  
  public int c()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.OpenInSysBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */