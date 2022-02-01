package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  ChannelCoverSimpleAdapter$1(ChannelCoverSimpleAdapter paramChannelCoverSimpleAdapter, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    int j = 0;
    int i = j;
    try
    {
      if (ChannelCoverSimpleAdapter.a(this.this$0) != null)
      {
        i = j;
        if ((ChannelCoverSimpleAdapter.a(this.this$0) instanceof Activity))
        {
          i = j;
          if (((Activity)ChannelCoverSimpleAdapter.a(this.this$0)).getIntent() != null) {
            i = ((Activity)ChannelCoverSimpleAdapter.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          }
        }
      }
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("is_followed", "1");
      localObject = new VideoR5.Builder(VideoReporter.a(this.a.mChannelCoverId, (JSONObject)localObject)).N(i).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", (String)localObject, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverSimpleAdapter.1
 * JD-Core Version:    0.7.0.1
 */