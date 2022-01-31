package com.tencent.mobileqq.statistics.battery;

import ailg;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BatteryLog
{
  private static long jdField_a_of_type_Long;
  private static Handler jdField_a_of_type_AndroidOsHandler = new ailg(ThreadManager.getFileThreadLooper());
  private static BufferedWriter jdField_a_of_type_JavaIoBufferedWriter;
  private static String jdField_a_of_type_JavaLangString;
  static ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static BufferedWriter jdField_b_of_type_JavaIoBufferedWriter;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  private static String d;
  
  static Pair a(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    if (d == null) {
      d = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/battery/";
    }
    Object localObject2 = new File(d);
    if (!((File)localObject2).exists()) {
      return null;
    }
    Object localObject1 = new ArrayList();
    int i;
    long l1;
    long l2;
    int j;
    try
    {
      localObject2 = ((File)localObject2).listFiles();
      int k = localObject2.length;
      i = 0;
      l1 = 0L;
      if (i < k) {
        localFile = localObject2[i];
      }
    }
    catch (Throwable localThrowable1)
    {
      File localFile;
      l1 = 0L;
      localObject1 = null;
    }
    try
    {
      if ((localFile.getName() == null) || (!localFile.getName().endsWith(".log"))) {
        break label363;
      }
      l2 = b(localFile);
      if ((l2 == -1L) || (l2 >= paramLong2) || (l2 <= paramLong1) || (localFile.length() <= paramLong3)) {
        break label363;
      }
      j = paramInt - 1;
      if (paramInt <= 0) {
        break label372;
      }
      ((List)localObject1).add(localFile.getAbsolutePath());
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localObject1 = null;
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject2 = d + paramLong2 + ".zip";
      if (FileUtils.a((List)localObject1, (String)localObject2)) {
        localObject1 = new File((String)localObject2);
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = ((File)localObject1).exists();
        paramLong1 = l1;
        localObject2 = localObject1;
        if (!bool)
        {
          localObject2 = null;
          paramLong1 = l1;
        }
        return new Pair(Long.valueOf(paramLong1), localObject2);
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      QLog.e("BatteryStats.Log", 1, "zip fail");
      localObject2 = null;
      paramLong1 = l1;
      continue;
      paramLong1 = l1;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("BatteryStats.Log", 2, "", localThrowable1);
        paramLong1 = l1;
        localObject2 = localObject1;
      }
    }
    label356:
    paramInt = j;
    for (;;)
    {
      label363:
      i += 1;
      break;
      label372:
      if (l2 <= l1) {
        break label356;
      }
      l1 = l2;
      paramInt = j;
    }
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = (StringBuilder)jdField_a_of_type_JavaLangThreadLocal.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder(1024);
      jdField_a_of_type_JavaLangThreadLocal.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.delete(0, localStringBuilder.length());
    return localStringBuilder;
  }
  
  static List a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (d == null) {
      d = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/battery/";
    }
    Object localObject = new File(d);
    if (!((File)localObject).exists())
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        File[] arrayOfFile = ((File)localObject).listFiles();
        int j = arrayOfFile.length;
        i = 0;
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfFile[i];
        if ((((File)localObject).getName() == null) || (!((File)localObject).getName().endsWith(".rpt"))) {
          break label204;
        }
        long l = b((File)localObject);
        if ((l == -1L) || (l >= paramLong2) || (l <= paramLong1) || (((File)localObject).length() <= paramLong3)) {
          break label204;
        }
        localArrayList.add(localObject);
      }
      catch (Exception localException)
      {
        localObject = localArrayList;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BatteryStats.Log", 2, "", localException);
      return localArrayList;
      label204:
      i += 1;
    }
  }
  
  static void a(long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.obtainMessage(1, Long.valueOf(paramLong)).sendToTarget();
  }
  
  static void a(String paramString, long paramLong)
  {
    c = paramString;
    jdField_a_of_type_Long = paramLong;
    jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  static void a(Object... paramVarArgs)
  {
    if (jdField_b_of_type_JavaIoBufferedWriter != null) {
      jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 1, 0, paramVarArgs).sendToTarget();
    }
  }
  
  private static long b(File paramFile)
  {
    paramFile = paramFile.getName();
    try
    {
      paramFile = paramFile.substring(paramFile.indexOf("_") + 1);
      if ((paramFile.endsWith(".log")) || (paramFile.endsWith(".zip")) || (paramFile.endsWith("rpt")))
      {
        long l = Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
        return l;
      }
    }
    catch (Exception paramFile) {}
    return -1L;
  }
  
  public static void b(Object... paramVarArgs)
  {
    if (jdField_a_of_type_JavaIoBufferedWriter != null) {
      jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, 0, paramVarArgs).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.battery.BatteryLog
 * JD-Core Version:    0.7.0.1
 */