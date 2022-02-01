package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyVideoSubChannelActivity$9
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$9(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void run()
  {
    int i = ReadInJoyVideoSubChannelActivity.e(this.this$0);
    String str1 = "1";
    Object localObject;
    if (i == 6) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!this.a.mIsFollowed) {
          break label214;
        }
        localJSONObject.put("is_followed", str1);
        boolean bool = this.a.mIsTopic;
        if (bool) {
          str1 = "0X80088BB";
        } else {
          str1 = "0X8007BE6";
        }
        if (!this.a.mIsTopic) {
          break label220;
        }
        localObject = "0X80088BB";
        label86:
        PublicAccountReportUtils.a(null, "", str1, (String)localObject, 0, 0, "2", "", "", VideoReporter.a(this.a.mChannelID, localJSONObject), false);
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
    } else if (ReadInJoyVideoSubChannelActivity.e(this.this$0) != 8) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (!this.a.mIsFollowed) {
          break label227;
        }
        ((JSONObject)localObject).put("is_followed", localJSONException1);
        ((JSONObject)localObject).put("channel_id", 409409);
        PublicAccountReportUtils.a(null, "", "0X80088BB", "0X80088BB", 0, 0, "3", "", "", VideoReporter.a(this.a.mChannelID, (JSONObject)localObject), false);
        return;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      return;
      label214:
      String str2 = "0";
      break;
      label220:
      localObject = "0X8007BE6";
      break label86;
      label227:
      str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.9
 * JD-Core Version:    0.7.0.1
 */