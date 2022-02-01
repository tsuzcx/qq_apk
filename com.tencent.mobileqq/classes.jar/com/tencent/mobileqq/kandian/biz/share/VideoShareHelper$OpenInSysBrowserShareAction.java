package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$OpenInSysBrowserShareAction
  extends ShareAction
{
  VideoShareHelper$OpenInSysBrowserShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    paramActionSheetItem = paramActionSheetItem.toString();
    paramString = paramActionSheetItem;
    if (paramAbsBaseArticleInfo.qzoneShareUrl != null)
    {
      paramString = paramActionSheetItem;
      if (paramAbsBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
        paramString = paramAbsBaseArticleInfo.qzoneShareUrl;
      }
    }
    paramAbsBaseArticleInfo = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramAbsBaseArticleInfo.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
    paramAbsBaseArticleInfo.putExtra("normal", true);
    try
    {
      VideoShareHelper.f(this.a).startActivity(paramAbsBaseArticleInfo);
      return;
    }
    catch (ActivityNotFoundException paramAbsBaseArticleInfo)
    {
      label115:
      break label115;
    }
    QRUtils.a(1, 2131892956);
  }
  
  public int c()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.OpenInSysBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */