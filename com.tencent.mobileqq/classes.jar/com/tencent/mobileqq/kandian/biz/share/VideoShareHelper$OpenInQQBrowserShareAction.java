package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$OpenInQQBrowserShareAction
  extends ShareAction
{
  VideoShareHelper$OpenInQQBrowserShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramAbsBaseArticleInfo.qzoneShareUrl != null) && (paramAbsBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
    {
      VideoShareHelper.a(this.a).a(paramAbsBaseArticleInfo.qzoneShareUrl);
      return;
    }
    paramAbsBaseArticleInfo = VideoShareHelper.a(this.a);
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    paramAbsBaseArticleInfo.a(paramActionSheetItem.toString());
  }
  
  public int c()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.OpenInQQBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */