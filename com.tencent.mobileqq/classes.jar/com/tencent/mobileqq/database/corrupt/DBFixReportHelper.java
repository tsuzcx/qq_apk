package com.tencent.mobileqq.database.corrupt;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.dbfix.DBCheckResult;
import com.tencent.dbfix.DBFix;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class DBFixReportHelper
{
  private static final DBCheckResult a = new DBCheckResult();
  private static final HashMap<String, String> b = new HashMap();
  private static final HashMap<String, String> c = new HashMap();
  
  static void a()
  {
    try
    {
      b.clear();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      MobileQQ localMobileQQ = ((AppRuntime)localObject).getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localStringBuilder.append(".db");
      localObject = localMobileQQ.getDatabasePath(localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        return;
      }
      a((File)localObject, "");
      a("");
      b("");
      d();
      a((File)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("DBFixReportHelper", 1, localThrowable, new Object[0]);
    }
  }
  
  static void a(int paramInt)
  {
    try
    {
      a.clear();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      MobileQQ localMobileQQ = ((AppRuntime)localObject).getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localStringBuilder.append(".db");
      localObject = localMobileQQ.getDatabasePath(localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        return;
      }
      boolean bool = b((File)localObject);
      QLog.d("DBFixReportHelper", 1, new Object[] { "onDBFixStart needIntegrityCheck -> ", Boolean.valueOf(bool) });
      if (!bool) {
        return;
      }
      a(false, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("DBFixReportHelper", 1, localThrowable, new Object[0]);
    }
  }
  
  static void a(File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append("-mbu");
    paramFile = ((StringBuilder)localObject).toString();
    localObject = new File(paramFile);
    QLog.d("DBFixReportHelper", 1, new Object[] { "appendMasterSizeInfo master file path: ", paramFile });
    if (((File)localObject).exists())
    {
      long l = ((File)localObject).length();
      b.put("masterSize", String.valueOf(l));
    }
  }
  
  private static void a(File paramFile, String paramString)
  {
    long l = paramFile.length() / 1048576L;
    Object localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dbSize");
    ((StringBuilder)localObject2).append(paramString);
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), String.valueOf(l));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramFile);
    ((StringBuilder)localObject1).append("-wal");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new File((String)localObject1);
    QLog.d("DBFixReportHelper", 1, new Object[] { "appendDBSizeInfo wal file path: ", localObject1 });
    if (((File)localObject2).exists())
    {
      l = ((File)localObject2).length();
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("walSize");
      ((StringBuilder)localObject2).append(paramString);
      ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), String.valueOf(l));
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramFile);
    ((StringBuilder)localObject1).append("-shm");
    paramFile = ((StringBuilder)localObject1).toString();
    localObject1 = new File(paramFile);
    QLog.d("DBFixReportHelper", 1, new Object[] { "appendDBSizeInfo shm file path: ", paramFile });
    if (((File)localObject1).exists())
    {
      l = ((File)localObject1).length();
      paramFile = b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shmSize");
      ((StringBuilder)localObject1).append(paramString);
      paramFile.put(((StringBuilder)localObject1).toString(), String.valueOf(l));
    }
  }
  
  private static void a(String paramString)
  {
    Object localObject = DeviceInfoUtil.p();
    long l1 = localObject[0];
    long l2 = localObject[1];
    localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("romTotal");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(l1));
    localObject = b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("romAvailable");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(l2));
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramAppRuntime, "dbfixDeviceInfoReport", true, 0L, 0L, b, "");
    QLog.d("DBFixReportHelper", 1, new Object[] { "onDBFixConfirmDialogShow report info -> ", b });
  }
  
  private static void a(boolean paramBoolean, int paramInt)
  {
    int i = 2;
    QLog.d("DBFixReportHelper", 1, new Object[] { "doIntegrityCheck isFixDone -> ", Boolean.valueOf(paramBoolean), ", fixType -> ", Integer.valueOf(paramInt) });
    String str;
    if (paramBoolean) {
      str = "_";
    } else {
      str = "";
    }
    long l1 = a.checkStartTime;
    long l2 = a.checkCompleteTime;
    a.clear();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((AppRuntime)localObject1).getAccount());
    localStringBuilder.append(".db");
    localObject1 = ((MobileQQ)localObject2).getDatabasePath(localStringBuilder.toString());
    a.checkStartTime = System.currentTimeMillis();
    localObject2 = DBFix.getInstance().doIntegrityCheck(((File)localObject1).getAbsolutePath());
    QLog.d("DBFixReportHelper", 1, new Object[] { "doIntegrityCheck checkResult -> ", localObject2 });
    a.setResult((List)localObject2);
    a.checkCompleteTime = System.currentTimeMillis();
    long l3 = a.checkCompleteTime;
    long l4 = a.checkStartTime;
    localObject2 = c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("integrityCheckTime");
    localStringBuilder.append(str);
    ((HashMap)localObject2).put(localStringBuilder.toString(), String.valueOf(l3 - l4));
    if ((paramBoolean) && (l2 > 0L))
    {
      l3 = a.checkStartTime;
      c.put("fixTime", String.valueOf(l3 - l2));
      if (((File)localObject1).length() != 0L) {
        i = 1;
      }
      c.put("fixStatus", String.valueOf(i));
      l2 = a.checkCompleteTime;
      c.put("totalTime", String.valueOf(l2 - l1));
    }
    localObject1 = c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("fixType");
    ((StringBuilder)localObject2).append(str);
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), String.valueOf(paramInt));
    localObject1 = c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("corruptReasonCode");
    ((StringBuilder)localObject2).append(str);
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), String.valueOf(a.getCorruptReasonCode()));
    localObject1 = c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("corruptReasonDesc");
    ((StringBuilder)localObject2).append(str);
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), String.valueOf(a.buildDescription()));
  }
  
  static void b()
  {
    try
    {
      b.put("fixStatus", String.valueOf(0));
      a(BaseApplicationImpl.getApplication().getRuntime());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("DBFixReportHelper", 1, localThrowable, new Object[0]);
    }
  }
  
  static void b(int paramInt)
  {
    try
    {
      if (a.checkStartTime <= 0L) {
        return;
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      MobileQQ localMobileQQ = ((AppRuntime)localObject).getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localStringBuilder.append(".db");
      if (!localMobileQQ.getDatabasePath(localStringBuilder.toString()).exists()) {
        return;
      }
      a(true, paramInt);
      localObject = ((AppRuntime)localObject).getCurrentAccountUin();
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "dbfixIntegrityCheckInfoReport", true, 0L, 0L, c, "");
      QLog.d("DBFixReportHelper", 1, new Object[] { "doReportIntegrityCheckInfo report info -> ", c });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("DBFixReportHelper", 1, localThrowable, new Object[0]);
    }
  }
  
  private static void b(String paramString)
  {
    long l1 = DeviceInfoUtil.a() / 1048576L;
    long l2 = DeviceInfoUtil.r() / 1048576L;
    Object localObject = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    float f1;
    if ((localObject != null) && (localObject.length > 0)) {
      f1 = localObject[0].getTotalPss() / 1024.0F;
    } else {
      f1 = -1.0F;
    }
    float f2 = (float)Runtime.getRuntime().freeMemory() / 1048576.0F;
    float f3 = (float)Runtime.getRuntime().totalMemory() / 1048576.0F;
    float f4 = (float)Runtime.getRuntime().maxMemory() / 1048576.0F;
    localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ramTotal");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(l1));
    localObject = b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ramAvailable");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(l2));
    localObject = b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ramPssUsed");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(f1));
    localObject = b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ramFree");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(f2));
    localObject = b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ramAppTotal");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(f3));
    localObject = b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ramAppMax");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(f4));
  }
  
  private static boolean b(File paramFile)
  {
    boolean bool2 = paramFile.exists();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    long l = paramFile.length() / 1048576L;
    QLog.d("DBFixReportHelper", 1, new Object[] { "needIntegrityCheck dbLength -> ", Long.valueOf(l) });
    if (l <= 512L) {
      bool1 = true;
    }
    return bool1;
  }
  
  static void c()
  {
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        Object localObject = localAppRuntime.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localAppRuntime.getAccount());
        localStringBuilder.append(".db");
        localObject = ((MobileQQ)localObject).getDatabasePath(localStringBuilder.toString());
        if (!((File)localObject).exists()) {
          return;
        }
        if (((File)localObject).length() == 0L)
        {
          i = 2;
          b.put("fixStatus", String.valueOf(i));
          a((File)localObject, "_");
          a("_");
          b("_");
          a(localAppRuntime);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("DBFixReportHelper", 1, localThrowable, new Object[0]);
        return;
      }
      int i = 1;
    }
  }
  
  private static void d()
  {
    b.put("deviceVersion", String.valueOf(Build.VERSION.SDK_INT));
    b.put("deviceBrand", Build.BRAND);
    b.put("deviceModel", Build.MODEL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixReportHelper
 * JD-Core Version:    0.7.0.1
 */