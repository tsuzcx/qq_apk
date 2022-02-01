package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class FrameworkHandler$3$1
  implements Runnable
{
  FrameworkHandler$3$1(FrameworkHandler.3 param3) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("channel_id", this.a.a.a());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009414", "0X8009414", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("back_to_top_btn : click ; channelID : ");
      ((StringBuilder)localObject).append(this.a.a.a());
      QLog.d("FrameworkHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.3.1
 * JD-Core Version:    0.7.0.1
 */