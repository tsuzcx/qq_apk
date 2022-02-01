package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$SendToSinaShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToSinaShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo.n != null) && (paramVideoInfo.n.contains("kandianshare.html5.qq.com")))
    {
      VideoFeedsShareController.a(this.a, paramVideoInfo.c, "", paramVideoInfo.n, paramVideoInfo.b);
      return;
    }
    paramActionSheetItem = this.a;
    String str = paramVideoInfo.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&sourcefrom=4");
    VideoFeedsShareController.a(paramActionSheetItem, str, "", localStringBuilder.toString(), paramVideoInfo.b);
  }
  
  public int b()
  {
    return 5;
  }
  
  public int c()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.SendToSinaShareAction
 * JD-Core Version:    0.7.0.1
 */