package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$SendToPcAction
  extends ShareAction
{
  VideoShareHelper$SendToPcAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 2;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramAbsBaseArticleInfo = VideoShareHelper.j(this.a);
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    paramAbsBaseArticleInfo.d(paramActionSheetItem.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.SendToPcAction
 * JD-Core Version:    0.7.0.1
 */