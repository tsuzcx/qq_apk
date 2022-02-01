package com.tencent.mobileqq.vas.updatesystem.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.ReportItemParams;
import com.tencent.vas.update.factory.api.IReportManager;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VasReportManagerImpl
  implements IReportManager
{
  public void a(ReportItemParams paramReportItemParams)
  {
    if (paramReportItemParams == null) {
      return;
    }
    paramReportItemParams.a += 100;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportDLEvent: bid = ");
      localStringBuilder.append(paramReportItemParams.b);
      localStringBuilder.append(" scid = ");
      localStringBuilder.append(paramReportItemParams.c);
      localStringBuilder.append(" dlFrom = ");
      localStringBuilder.append(paramReportItemParams.a);
      localStringBuilder.append(" bIncrement = ");
      localStringBuilder.append(paramReportItemParams.e);
      localStringBuilder.append(" errorCode = ");
      localStringBuilder.append(paramReportItemParams.f);
      localStringBuilder.append(" httpCode = ");
      localStringBuilder.append(paramReportItemParams.g);
      localStringBuilder.append(" errorMsg = ");
      localStringBuilder.append(paramReportItemParams.i);
      localStringBuilder.append(" count = ");
      localStringBuilder.append(paramReportItemParams.h);
      QLog.d("VasUpdate_ReportImpl", 2, localStringBuilder.toString());
    }
    if ((int)(Math.random() * 10000.0D) == 1) {
      b(paramReportItemParams);
    }
  }
  
  public void b(@NonNull ReportItemParams paramReportItemParams)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("from", String.valueOf(paramReportItemParams.a));
    localHashMap.put("bid", String.valueOf(paramReportItemParams.b));
    localHashMap.put("scid", String.valueOf(paramReportItemParams.c));
    localHashMap.put("md5", String.valueOf(paramReportItemParams.d));
    localHashMap.put("eventCode", String.valueOf(paramReportItemParams.f));
    localHashMap.put("httpCode", String.valueOf(paramReportItemParams.g));
    localHashMap.put("retry", String.valueOf(paramReportItemParams.h));
    localHashMap.put("errorMsg", String.valueOf(paramReportItemParams.i));
    if ((MobileQQ.sMobileQQ != null) && (MobileQQ.sMobileQQ.peekAppRuntime() != null)) {
      localHashMap.put("userId", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).getUpdateReportAppid(), false, 0L, -1L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasReportManagerImpl
 * JD-Core Version:    0.7.0.1
 */