package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

final class PublicAccountReportUtilsImpl$2
  implements Runnable
{
  PublicAccountReportUtilsImpl$2(String paramString) {}
  
  public void run()
  {
    try
    {
      int j = new JSONObject(this.a).getInt("channel_id");
      int i = 2;
      if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(j)) {
        i = 0;
      }
      ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportDau(i);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtilsImpl.2
 * JD-Core Version:    0.7.0.1
 */