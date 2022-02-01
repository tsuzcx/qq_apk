package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyChannelActivity$6
  implements Runnable
{
  ReadInJoyChannelActivity$6(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("channel_id", this.this$0.getIntent().getIntExtra("channel_id", -1));
      PublicAccountReportUtils.a(null, "", "0X8009665", "0X8009665", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("back_to_top: { channelID : ");
      ((StringBuilder)localObject).append(this.this$0.getIntent().getIntExtra("channel_id", -1));
      ((StringBuilder)localObject).append(" , click_source : b2t_titlebar_blank }");
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity.6
 * JD-Core Version:    0.7.0.1
 */