package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("is_followed", "1");
      PublicAccountReportUtils.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new VideoR5.Builder(VideoReporter.a(this.a.mChannelCoverId, localJSONObject)).O(i).b().a(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverSimpleAdapter.1
 * JD-Core Version:    0.7.0.1
 */