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
      paramActionSheetItem = URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label20:
      StringBuilder localStringBuilder;
      break label20;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "encode url failed, because UTF-8 is unknown");
    }
    paramActionSheetItem = null;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.getSubscribeUin())) {
      paramString = paramAbsBaseArticleInfo.getSubscribeUin();
    } else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.thirdUin)) {
      paramString = paramAbsBaseArticleInfo.thirdUin;
    } else {
      paramString = "0";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://post.mp.qq.com/jubao/index?_wv=3&puin=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&uin_type=0&url=");
    localStringBuilder.append(paramActionSheetItem);
    localStringBuilder.append("&type=4&key=");
    localStringBuilder.append(paramAbsBaseArticleInfo.getInnerUniqueID());
    paramAbsBaseArticleInfo = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("click jubao btn, reportUrl:");
      paramString.append(paramAbsBaseArticleInfo);
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, paramString.toString());
    }
    paramString = new Intent(VideoShareHelper.a(this.a), QQBrowserActivity.class);
    paramString.putExtra("url", paramAbsBaseArticleInfo);
    paramString.putExtra("hide_more_button", true);
    VideoShareHelper.a(this.a).startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportAction
 * JD-Core Version:    0.7.0.1
 */