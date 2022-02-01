package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.beans.SneakyParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class RIJFrameworkReportManager$1
  implements Runnable
{
  RIJFrameworkReportManager$1(int paramInt, long paramLong) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = Aladdin.get(139);
      if (localObject != null)
      {
        localObject = ((AladdinConfig)localObject).getList("param_list");
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SneakyParams localSneakyParams = (SneakyParams)((Iterator)localObject).next();
            localJSONObject.put(localSneakyParams.getPackageName(), localSneakyParams.toString());
          }
        }
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009EB2", "0X8009EB2", 0, 0, String.valueOf(this.a), String.valueOf(this.b), "1", localJSONObject.toString(), false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJFrameworkReportManager", 2, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager.1
 * JD-Core Version:    0.7.0.1
 */