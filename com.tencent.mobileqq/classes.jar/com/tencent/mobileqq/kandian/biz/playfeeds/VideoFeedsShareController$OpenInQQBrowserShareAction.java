package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$OpenInQQBrowserShareAction
  extends ShareAction
{
  VideoFeedsShareController$OpenInQQBrowserShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.b(this.a).b(VideoFeedsShareController.c(this.a));
    if ((paramVideoInfo.z != null) && (paramVideoInfo.z.contains("kandianshare.html5.qq.com")))
    {
      this.a.a.a(paramVideoInfo.z);
      return;
    }
    paramVideoInfo = this.a.a;
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    paramVideoInfo.a(paramActionSheetItem.toString());
  }
  
  public int c()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.OpenInQQBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */