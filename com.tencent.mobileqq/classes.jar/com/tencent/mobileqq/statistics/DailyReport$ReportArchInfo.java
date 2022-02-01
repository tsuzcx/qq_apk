package com.tencent.mobileqq.statistics;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DailyReport$ReportArchInfo
{
  public static String a()
  {
    try
    {
      Object localObject2 = new ArrayList(Arrays.asList(Build.SUPPORTED_ABIS));
      Collections.sort((List)localObject2);
      Object localObject1 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append('[');
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(']');
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReportArchInfo", 1, "[acquireHighestArch] ", localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DailyReport.ReportArchInfo
 * JD-Core Version:    0.7.0.1
 */