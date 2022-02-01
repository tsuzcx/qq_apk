package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class PicReporter
{
  private static final Object a = "PicReporter";
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_network", String.valueOf(paramInt));
    localHashMap.put("param_limit", String.valueOf(paramLong));
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("param_network:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",param_limit:");
    localStringBuilder.append(paramLong);
    Logger.a(localObject, "reportOverFlow", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicPreDownOverFlow", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      Logger.a(a, "reportPicDownAutoLearn", "reportInfo == null");
      return;
    }
    if ((String)paramHashMap.get("xgPreDownCount") == null)
    {
      Logger.a(a, "reportPicDownAutoLearn", "no xg report data");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "actPicDownAutoLearn", false, 0L, 0L, paramHashMap, "");
    Logger.a(a, "reportPicDownAutoLearn", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReporter
 * JD-Core Version:    0.7.0.1
 */