package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverView$1
  implements Runnable
{
  ChannelCoverView$1(ChannelCoverView paramChannelCoverView, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("is_followed", "1");
        boolean bool = this.a.mIsTopic;
        String str1;
        if (bool) {
          str1 = "0X80088BB";
        } else {
          str1 = "0X8007BE6";
        }
        if (this.a.mIsTopic)
        {
          str2 = "0X80088BB";
          PublicAccountReportUtils.a(null, "", str1, str2, 0, 0, "1", "", "", VideoReporter.a(this.a.mChannelCoverId, localJSONObject), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      String str2 = "0X8007BE6";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.1
 * JD-Core Version:    0.7.0.1
 */