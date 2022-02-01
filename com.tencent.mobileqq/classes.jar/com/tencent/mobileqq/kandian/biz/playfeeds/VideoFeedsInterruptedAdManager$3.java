package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import org.json.JSONObject;

class VideoFeedsInterruptedAdManager$3
  implements View.OnClickListener
{
  VideoFeedsInterruptedAdManager$3(VideoFeedsInterruptedAdManager paramVideoFeedsInterruptedAdManager) {}
  
  public void onClick(View paramView)
  {
    if (VideoFeedsInterruptedAdManager.e(this.a) != null) {
      VideoFeedsInterruptedAdManager.e(this.a).a(VideoFeedsInterruptedAdManager.d(this.a));
    }
    VideoFeedsInterruptedAdManager.d(this.a).c.setVisibility(8);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", VideoFeedsInterruptedAdManager.c(this.a).getCurrentAccountUin());
      label67:
      PublicAccountReportUtils.a(null, null, "0X8009BF1", "0X8009BF1", 0, 0, "", "", "", VideoReporter.a(null, null, VideoFeedsInterruptedAdManager.d(this.a).az.c.b, VideoFeedsInterruptedAdManager.d(this.a).az.c.l, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsInterruptedAdManager.3
 * JD-Core Version:    0.7.0.1
 */