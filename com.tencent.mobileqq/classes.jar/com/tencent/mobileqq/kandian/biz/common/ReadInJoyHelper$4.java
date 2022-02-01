package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
      PublicAccountReportUtils.a(null, this.a.getAccount(), "0X8009662", "0X8009662", 0, 0, String.valueOf(this.b), String.valueOf(this.c), "", localJSONObject.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.4
 * JD-Core Version:    0.7.0.1
 */