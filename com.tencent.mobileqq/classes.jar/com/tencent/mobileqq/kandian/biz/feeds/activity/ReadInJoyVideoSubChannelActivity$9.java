package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyVideoSubChannelActivity$9
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$9(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void run()
  {
    int i = ReadInJoyVideoSubChannelActivity.b(this.this$0);
    String str1 = "1";
    Object localObject;
    if (i == 6) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!this.a.mIsFollowed) {
          break label239;
        }
        localJSONObject.put("is_followed", str1);
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        boolean bool = this.a.mIsTopic;
        localObject = "0X8007BE6";
        if (bool) {
          str1 = "0X80088BB";
        } else {
          str1 = "0X8007BE6";
        }
        if (this.a.mIsTopic) {
          localObject = "0X80088BB";
        }
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", str1, (String)localObject, 0, 0, "2", "", "", VideoReporter.a(this.a.mChannelID, localJSONObject), false);
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
    } else if (ReadInJoyVideoSubChannelActivity.b(this.this$0) != 8) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (!this.a.mIsFollowed) {
          break label245;
        }
        ((JSONObject)localObject).put("is_followed", localJSONException1);
        ((JSONObject)localObject).put("channel_id", 409409);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80088BB", "0X80088BB", 0, 0, "3", "", "", VideoReporter.a(this.a.mChannelID, (JSONObject)localObject), false);
        return;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      return;
      label239:
      String str2 = "0";
      break;
      label245:
      str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.9
 * JD-Core Version:    0.7.0.1
 */