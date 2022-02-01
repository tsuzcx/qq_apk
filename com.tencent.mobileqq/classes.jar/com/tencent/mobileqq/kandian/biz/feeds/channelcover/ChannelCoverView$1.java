package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverView$1
  implements Runnable
{
  ChannelCoverView$1(ChannelCoverView paramChannelCoverView, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("is_followed", "1");
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      boolean bool = this.a.mIsTopic;
      String str2 = "0X8007BE6";
      String str1;
      if (bool) {
        str1 = "0X80088BB";
      } else {
        str1 = "0X8007BE6";
      }
      if (this.a.mIsTopic) {
        str2 = "0X80088BB";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", str1, str2, 0, 0, "1", "", "", VideoReporter.a(this.a.mChannelCoverId, localJSONObject), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.1
 * JD-Core Version:    0.7.0.1
 */