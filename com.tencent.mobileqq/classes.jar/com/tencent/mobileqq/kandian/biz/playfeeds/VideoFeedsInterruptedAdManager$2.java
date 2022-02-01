package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class VideoFeedsInterruptedAdManager$2
  implements View.OnClickListener
{
  VideoFeedsInterruptedAdManager$2(VideoFeedsInterruptedAdManager paramVideoFeedsInterruptedAdManager) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsHelper.a(VideoFeedsInterruptedAdManager.a(this.a), VideoFeedsInterruptedAdManager.a(this.a).a);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", VideoFeedsInterruptedAdManager.a(this.a).getCurrentAccountUin());
      label45:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", VideoReporter.a(null, null, VideoFeedsInterruptedAdManager.a(this.a).a.a.a, VideoFeedsInterruptedAdManager.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsInterruptedAdManager.2
 * JD-Core Version:    0.7.0.1
 */