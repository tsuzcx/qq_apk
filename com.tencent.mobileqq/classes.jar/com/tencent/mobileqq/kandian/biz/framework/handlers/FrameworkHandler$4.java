package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class FrameworkHandler$4
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("channel_id", this.this$0.c());
      PublicAccountReportUtils.a(null, "", "0X8009415", "0X8009415", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("back_to_top_btn : exposure ; channelID  : ");
      ((StringBuilder)localObject).append(this.this$0.c());
      QLog.d("FrameworkHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.4
 * JD-Core Version:    0.7.0.1
 */