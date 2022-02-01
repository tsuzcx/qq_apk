package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$SendToFriendShareAction
  extends ShareAction
{
  VideoShareHelper$SendToFriendShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    VideoShareHelper.a(this.a, paramAbsBaseArticleInfo, null, 0, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.SendToFriendShareAction
 * JD-Core Version:    0.7.0.1
 */