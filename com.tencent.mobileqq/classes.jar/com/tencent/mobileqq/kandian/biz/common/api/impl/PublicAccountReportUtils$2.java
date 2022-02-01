package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.repo.daily.api.impl.DailyModeConfigHandlerSingleton;
import org.json.JSONObject;

final class PublicAccountReportUtils$2
  implements Runnable
{
  PublicAccountReportUtils$2(String paramString) {}
  
  public void run()
  {
    try
    {
      int j = new JSONObject(this.a).getInt("channel_id");
      int i = 2;
      if (DailyModeConfigHandlerSingleton.INSTANCE.isDaily(j)) {
        i = 0;
      }
      ReadinjoySPEventReport.i(i);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils.2
 * JD-Core Version:    0.7.0.1
 */