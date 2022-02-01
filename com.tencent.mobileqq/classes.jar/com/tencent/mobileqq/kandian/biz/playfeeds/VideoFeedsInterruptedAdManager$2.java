package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import org.json.JSONObject;

class VideoFeedsInterruptedAdManager$2
  implements View.OnClickListener
{
  VideoFeedsInterruptedAdManager$2(VideoFeedsInterruptedAdManager paramVideoFeedsInterruptedAdManager) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsHelper.a(VideoFeedsInterruptedAdManager.a(this.a), VideoFeedsInterruptedAdManager.b(this.a).k);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", VideoFeedsInterruptedAdManager.c(this.a).getCurrentAccountUin());
      label45:
      PublicAccountReportUtils.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", VideoReporter.a(null, null, VideoFeedsInterruptedAdManager.d(this.a).az.c.b, VideoFeedsInterruptedAdManager.d(this.a).az.c.l, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsInterruptedAdManager.2
 * JD-Core Version:    0.7.0.1
 */