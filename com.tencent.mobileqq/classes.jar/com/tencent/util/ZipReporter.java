package com.tencent.util;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ZipReporter
{
  private static int a;
  
  public static int a()
  {
    if (a == 0) {
      a = 20;
    }
    return a;
  }
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(File paramFile, int paramInt)
  {
    if (paramFile == null)
    {
      QLog.e("ZipReporter", 1, "checkZipRegular, zip file is null");
      return;
    }
    if (!paramFile.exists())
    {
      QLog.e("ZipReporter", 1, "checkZipRegular, zip file is not exists");
      return;
    }
    if (paramFile.length() == 0L) {
      return;
    }
    ThreadManager.excute(new ZipReporter.1(paramFile, paramInt), 192, null, false);
  }
  
  private static void c(File paramFile, int paramInt)
  {
    try
    {
      long l1 = paramFile.length();
      long l2 = ZipUtils.getUncompressedFileSize(paramFile.getAbsolutePath());
      long l3 = l2 / l1;
      if (l3 < paramInt) {
        return;
      }
      HashMap localHashMap = new HashMap();
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((AppRuntime)localObject).getAccount();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("UnusualUin", localObject);
      }
      localHashMap.put("ZipSize", String.valueOf(l1));
      localHashMap.put("UnzipSize", String.valueOf(l2));
      localHashMap.put("ZipName", paramFile.getName());
      localHashMap.put("ZipCurrentTimes", String.valueOf(l3));
      localHashMap.put("ZipTargetTimes", String.valueOf(paramInt));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "UnUsualZipEvent", false, 0L, 0L, localHashMap, "");
      return;
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.d("ZipReporter", 1, "reportUnusualSizeZip OutOfMemoryError : ", paramFile);
      return;
    }
    catch (Exception paramFile)
    {
      QLog.d("ZipReporter", 1, "reportUnusualSizeZip error : ", paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.ZipReporter
 * JD-Core Version:    0.7.0.1
 */