package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.net.URL;

class VideoShareHelper$SendToSinaShareAction
  extends ShareAction
{
  VideoShareHelper$SendToSinaShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=4");
    paramActionSheetItem = paramActionSheetItem.toString();
    paramString = paramActionSheetItem;
    if (paramAbsBaseArticleInfo.qzoneShareUrl != null)
    {
      paramString = paramActionSheetItem;
      if (paramAbsBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
        paramString = paramAbsBaseArticleInfo.qzoneShareUrl;
      }
    }
    paramActionSheetItem = this.a;
    String str = paramAbsBaseArticleInfo.mTitle;
    if (paramAbsBaseArticleInfo.getVideoCoverURL() == null) {
      paramAbsBaseArticleInfo = "";
    } else {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getVideoCoverURL().getFile();
    }
    VideoShareHelper.a(paramActionSheetItem, str, "", paramString, paramAbsBaseArticleInfo);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.SendToSinaShareAction
 * JD-Core Version:    0.7.0.1
 */