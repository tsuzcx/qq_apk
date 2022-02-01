package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$SendToSpecialFriendShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToSpecialFriendShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 19;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.a.a(paramVideoInfo, paramActionSheetItem.uin, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
  
  public int b()
  {
    return 0;
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.SendToSpecialFriendShareAction
 * JD-Core Version:    0.7.0.1
 */