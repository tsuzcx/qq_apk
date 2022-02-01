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
      URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label17:
      break label17;
    }
    VideoFeedsShareController.a(this.a, "encode url failed, because UTF-8 is unknown");
    if (!TextUtils.isEmpty(paramVideoInfo.q)) {
      paramString = paramVideoInfo.q;
    }
    paramInt = paramVideoInfo.a;
    paramString = new StringBuilder();
    paramString.append("https://web.kandian.qq.com/tpl/kdReport?pgyid=2021&type=content&rowkey=");
    paramString.append(paramVideoInfo.l);
    paramVideoInfo = paramString.toString();
    paramString = this.a;
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append("click jubao btn, reportUrl:");
    paramActionSheetItem.append(paramVideoInfo);
    VideoFeedsShareController.a(paramString, paramActionSheetItem.toString());
    VideoFeedsShareController.b(this.a).b(VideoFeedsShareController.c(this.a));
    paramString = new Intent(VideoFeedsShareController.f(this.a), QQBrowserActivity.class);
    paramString.putExtra("url", paramVideoInfo);
    paramString.putExtra("hide_more_button", true);
    VideoFeedsShareController.f(this.a).startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportAction
 * JD-Core Version:    0.7.0.1
 */