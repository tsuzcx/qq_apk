package com.tencent.mobileqq.kandian.biz.share;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import cooperation.qzone.QZoneShareManager;
import java.net.URL;
import java.util.ArrayList;

class VideoShareHelper$SendToQzoneShareAction
  extends ShareAction
{
  VideoShareHelper$SendToQzoneShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putString("title", paramAbsBaseArticleInfo.mTitle);
    paramActionSheetItem.putString("desc", paramAbsBaseArticleInfo.mSummary);
    if ((paramAbsBaseArticleInfo.qzoneShareUrl != null) && (paramAbsBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
    {
      paramActionSheetItem.putString("detail_url", paramAbsBaseArticleInfo.qzoneShareUrl);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&sourcefrom=1");
      paramActionSheetItem.putString("detail_url", localStringBuilder.toString());
    }
    paramString = new ArrayList(1);
    if (paramAbsBaseArticleInfo.getVideoCoverURL() == null) {
      paramAbsBaseArticleInfo = null;
    } else {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getVideoCoverURL().getFile();
    }
    paramString.add(paramAbsBaseArticleInfo);
    paramActionSheetItem.putStringArrayList("image_url", paramString);
    paramActionSheetItem.putLong("req_share_id", 0L);
    QZoneShareManager.jumpToQzoneShare(VideoShareHelper.a(this.a), VideoShareHelper.a(this.a), paramActionSheetItem, null, 19202);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.SendToQzoneShareAction
 * JD-Core Version:    0.7.0.1
 */