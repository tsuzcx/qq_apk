package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IReportManager;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class VasReportManagerImpl
  implements IReportManager
{
  public void reportDLEvent(int paramInt1, long paramLong, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    paramInt1 += 100;
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("reportDLEvent: bid = ");
      paramString3.append(paramLong);
      paramString3.append(" scid = ");
      paramString3.append(paramString1);
      paramString3.append(" dlFrom = ");
      paramString3.append(paramInt1);
      paramString3.append(" bIncrement = ");
      paramString3.append(paramBoolean);
      paramString3.append(" errorCode = ");
      paramString3.append(paramInt2);
      paramString3.append(" httpCode = ");
      paramString3.append(paramInt3);
      paramString3.append(" count = ");
      paramString3.append(paramInt4);
      QLog.d("VasUpdate_ReportImpl", 2, paramString3.toString());
    }
    if ((int)(Math.random() * 10000.0D) == 1)
    {
      paramString3 = new HashMap();
      paramString3.put("from", String.valueOf(paramInt1));
      paramString3.put("bid", String.valueOf(paramLong));
      paramString3.put("scid", String.valueOf(paramString1));
      paramString3.put("md5", String.valueOf(paramString2));
      paramString3.put("eventCode", String.valueOf(paramInt2));
      paramString3.put("httpCode", String.valueOf(paramInt3));
      paramString3.put("retry", String.valueOf(paramInt4));
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).getUpdateReportAppid(), false, 0L, -1L, paramString3, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasReportManagerImpl
 * JD-Core Version:    0.7.0.1
 */