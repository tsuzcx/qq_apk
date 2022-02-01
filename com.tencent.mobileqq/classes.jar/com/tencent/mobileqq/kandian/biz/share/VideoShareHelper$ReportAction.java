package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class VideoShareHelper$ReportAction
  extends ShareAction
{
  VideoShareHelper$ReportAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    try
    {
      URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label19:
      break label19;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "encode url failed, because UTF-8 is unknown");
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.getSubscribeUin())) {
      paramAbsBaseArticleInfo.getSubscribeUin();
    } else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.thirdUin)) {
      paramString = paramAbsBaseArticleInfo.thirdUin;
    }
    paramString = new StringBuilder();
    paramString.append("https://web.kandian.qq.com/tpl/kdReport?pgyid=2021&type=content&rowkey=");
    paramString.append(paramAbsBaseArticleInfo.getInnerUniqueID());
    paramAbsBaseArticleInfo = paramString.toString();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("click jubao btn, reportUrl:");
      paramString.append(paramAbsBaseArticleInfo);
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, paramString.toString());
    }
    paramString = new Intent(VideoShareHelper.f(this.a), QQBrowserActivity.class);
    paramString.putExtra("url", paramAbsBaseArticleInfo);
    paramString.putExtra("hide_more_button", true);
    VideoShareHelper.f(this.a).startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportAction
 * JD-Core Version:    0.7.0.1
 */