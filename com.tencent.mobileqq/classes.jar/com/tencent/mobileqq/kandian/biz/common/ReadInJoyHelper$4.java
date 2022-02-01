package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

final class ReadInJoyHelper$4
  implements Runnable
{
  ReadInJoyHelper$4(AppRuntime paramAppRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      ReadInJoyHelper.a(localJSONObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "0X8009662", "0X8009662", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("only kandian tab switch, report error:");
        localStringBuilder.append(localException.toString());
        QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.4
 * JD-Core Version:    0.7.0.1
 */