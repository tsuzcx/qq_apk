package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$CopyLinkAction
  extends ShareAction
{
  VideoShareHelper$CopyLinkAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 3;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramAbsBaseArticleInfo = VideoShareHelper.a(this.a);
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    paramAbsBaseArticleInfo.c(paramActionSheetItem.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.CopyLinkAction
 * JD-Core Version:    0.7.0.1
 */