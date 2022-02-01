package com.tencent.mobileqq.kandian.biz.follow;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyFollowActivity$1$1
  implements Runnable
{
  ReadInJoyFollowActivity$1$1(ReadInJoyFollowActivity.1 param1) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", 70);
      localJSONObject.put("click_source", "b2t_title_text");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009329", "0X8009329", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("IphoneTitleBarActivity", 2, "back_to_top: { channelID : 70 , click_source : b2t_title_text }");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyFollowActivity.1.1
 * JD-Core Version:    0.7.0.1
 */