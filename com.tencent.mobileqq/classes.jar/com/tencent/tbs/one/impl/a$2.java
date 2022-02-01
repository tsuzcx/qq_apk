package com.tencent.tbs.one.impl;

import com.tencent.tbs.one.impl.common.h.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.util.Map;

final class a$2
  implements h.a
{
  public final void a(String paramString, int paramInt, Map paramMap)
  {
    if ("TBSOneAction".equals(paramString))
    {
      StatisticReport.create(paramString, paramInt).report();
      return;
    }
    if ((paramInt != 201) && (paramInt != 209) && (paramInt != 214))
    {
      if (paramInt == 506) {
        return;
      }
      StatisticReport localStatisticReport = StatisticReport.create(paramString, paramInt);
      if (paramMap != null)
      {
        if (paramMap.containsKey("DEPS_VERSION_CODE")) {
          localStatisticReport.setDEPSCode(((Integer)paramMap.get("DEPS_VERSION_CODE")).intValue());
        }
        boolean bool = paramMap.containsKey("COMPONENT_NAME");
        Object localObject = "";
        if (bool) {
          paramString = (String)paramMap.get("COMPONENT_NAME");
        } else {
          paramString = "";
        }
        paramInt = -1;
        if (paramMap.containsKey("COMPONENT_VERSION_CODE")) {
          paramInt = ((Integer)paramMap.get("COMPONENT_VERSION_CODE")).intValue();
        }
        localStatisticReport.setComponent(paramString, paramInt);
        paramString = (String)localObject;
        if (paramMap.containsKey("DESCRIPTION")) {
          paramString = (String)paramMap.get("DESCRIPTION");
        }
        localObject = null;
        if (paramMap.containsKey("THROWABLE")) {
          localObject = (Throwable)paramMap.get("THROWABLE");
        }
        localStatisticReport.setDescription(paramString, (Throwable)localObject);
      }
      localStatisticReport.report();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.2
 * JD-Core Version:    0.7.0.1
 */