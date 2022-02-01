package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class KandianConfigServlet$2
  implements Runnable
{
  KandianConfigServlet$2(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject();
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).addExtraInfoInJson((JSONObject)localObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, this.a, this.a, 0, 0, this.b, this.c, null, ((JSONObject)localObject).toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportID:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" reportKDConfigFailed  isAll:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("  errorCode:");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("KandianConfigServlet", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportKDConfigFailed ecception:");
      localStringBuilder.append(localException.toString());
      QLog.d("KandianConfigServlet", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.KandianConfigServlet.2
 * JD-Core Version:    0.7.0.1
 */