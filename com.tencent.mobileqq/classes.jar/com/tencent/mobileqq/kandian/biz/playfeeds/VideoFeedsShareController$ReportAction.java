package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class VideoFeedsShareController$ReportAction
  extends ShareAction
{
  VideoFeedsShareController$ReportAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label17:
      StringBuilder localStringBuilder;
      break label17;
    }
    VideoFeedsShareController.a(this.a, "encode url failed, because UTF-8 is unknown");
    paramString = null;
    if (!TextUtils.isEmpty(paramVideoInfo.j)) {
      paramActionSheetItem = paramVideoInfo.j;
    } else {
      paramActionSheetItem = "0";
    }
    paramInt = 0;
    if (paramVideoInfo.a == 6) {
      paramInt = 1;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://post.mp.qq.com/jubao/index?_wv=3&puin=");
    localStringBuilder.append(paramActionSheetItem);
    localStringBuilder.append("&uin_type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&url=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&type=4&key=");
    localStringBuilder.append(paramVideoInfo.g);
    paramVideoInfo = localStringBuilder.toString();
    paramString = this.a;
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append("click jubao btn, reportUrl:");
    paramActionSheetItem.append(paramVideoInfo);
    VideoFeedsShareController.a(paramString, paramActionSheetItem.toString());
    VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
    paramString = new Intent(VideoFeedsShareController.a(this.a), QQBrowserActivity.class);
    paramString.putExtra("url", paramVideoInfo);
    paramString.putExtra("hide_more_button", true);
    VideoFeedsShareController.a(this.a).startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportAction
 * JD-Core Version:    0.7.0.1
 */