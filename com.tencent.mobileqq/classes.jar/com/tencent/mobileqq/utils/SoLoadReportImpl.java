package com.tencent.mobileqq.utils;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.commonsdk.soload.SoLoadReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class SoLoadReportImpl
  implements SoLoadReport
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  
  private HashMap<String, String> a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    localHashMap.put("deviceName", localStringBuilder.toString());
    localHashMap.put("time", a.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    paramString = new StringBuilder();
    paramString.append(paramLong);
    paramString.append("");
    localHashMap.put("costTime", paramString.toString());
    localHashMap.put("processName", MobileQQ.processName);
    return localHashMap;
  }
  
  private void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.fillFailCode(paramHashMap, paramInt);
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    if (paramBoolean)
    {
      localStatisticCollector.collectPerformance("", "loadSoNew", false, 0L, 0L, paramHashMap, "");
      return;
    }
    localStatisticCollector.collectPerformance("", "loadSoOld", false, 0L, 0L, paramHashMap, "");
  }
  
  public void report(int paramInt, String paramString, long paramLong)
  {
    Object localObject = a(paramString, paramLong);
    HashMap localHashMap = a(paramString, paramLong);
    int i = paramInt & 0x2;
    boolean bool;
    if ((i != 2) && ((paramInt & 0x40000) != 262144))
    {
      a(true, paramInt, (HashMap)localObject);
      bool = false;
    }
    else
    {
      a(true, 0, (HashMap)localObject);
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" result:");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(" code ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("SoLoadUtilNew", 1, ((StringBuilder)localObject).toString());
    if (i == 2)
    {
      if (((paramInt & 0x8000) != 32768) || ((paramInt & 0x1000) != 4096) || ((paramInt & 0x800) != 0))
      {
        i = paramInt;
        if ((paramInt & 0x200) != 512) {
          break label219;
        }
        i = paramInt;
        if ((paramInt & 0x40) != 0) {
          break label219;
        }
        i = paramInt;
        if ((paramInt & 0x8) != 0) {
          break label219;
        }
      }
    }
    else
    {
      i = paramInt;
      if ((paramInt & 0x40000) != 262144) {
        break label219;
      }
    }
    i = 0;
    label219:
    a(false, i, localHashMap);
  }
  
  public void reportThrowable(Throwable paramThrowable, String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramThrowable == null) {
      return;
    }
    if (!(paramThrowable instanceof UnsatisfiedLinkError)) {
      return;
    }
    paramThrowable = paramThrowable.getMessage();
    if (paramThrowable == null) {
      return;
    }
    if (paramThrowable.indexOf("too many libraries") < 0) {
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "SoCountLimit", false, 0L, 0L, a(paramString, 0L), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadReportImpl
 * JD-Core Version:    0.7.0.1
 */