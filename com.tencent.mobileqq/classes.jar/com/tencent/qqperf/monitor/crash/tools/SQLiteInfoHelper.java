package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.StringBuilderPrinter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import mqq.app.MobileQQ;

public class SQLiteInfoHelper
{
  private static int a(int paramInt, Thread[] paramArrayOfThread1, Thread[] paramArrayOfThread2)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramInt; j = k)
    {
      Thread localThread = paramArrayOfThread1[i];
      k = j;
      if (a(localThread))
      {
        paramArrayOfThread2[j] = localThread;
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static Object a(Context paramContext, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass == null) {}
    try
    {
      localObject = Class.forName("android.app.ActivityThread");
      paramClass = ((Class)localObject).getMethod("currentActivityThread", new Class[0]);
      paramClass.setAccessible(true);
      localObject = paramClass.invoke(null, new Object[0]);
      paramClass = (Class<?>)localObject;
      if (localObject == null)
      {
        paramClass = (Class<?>)localObject;
        if (paramContext != null)
        {
          paramClass = paramContext.getClass().getField("mLoadedApk");
          paramClass.setAccessible(true);
          paramContext = paramClass.get(paramContext);
          paramClass = paramContext.getClass().getDeclaredField("mActivityThread");
          paramClass.setAccessible(true);
          paramClass = paramClass.get(paramContext);
        }
      }
      return paramClass;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static Object a(Object paramObject)
  {
    try
    {
      Object localObject1 = paramObject.getClass().getMethod("getApplicationThread", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      Object localObject2 = ((Method)localObject1).invoke(paramObject, new Object[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramObject.getClass().getDeclaredField("mAppThread");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramObject);
      }
      return localObject1;
    }
    catch (Throwable paramObject)
    {
      label58:
      break label58;
    }
    return null;
  }
  
  private static String a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Method localMethod = a(paramObject);
      localMethod.setAccessible(true);
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localMethod.invoke(paramObject, new Object[] { new PrintWriter(localByteArrayOutputStream), localMemoryInfo, Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true) });
      localStringBuilder.append(new String(localByteArrayOutputStream.toByteArray()));
      QLog.e("SQLiteInfoHelper", 1, new Object[] { "dumpMemInfo: ", localStringBuilder });
    }
    catch (Throwable paramObject)
    {
      QLog.e("SQLiteInfoHelper", 1, "dumpMemInfo: ", paramObject);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    localObject = new SimpleDateFormat("yy.MM.dd.HH").format(((Calendar)localObject).getTime());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.processName.replace(":", "_"));
    localStringBuilder.append(".dbInfo.");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".log");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(QLog.getLogPath());
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("dumpAllSQLiteDatabase ");
    localStringBuilder.append((String)localObject);
    QLog.d("SQLiteInfoHelper", 1, localStringBuilder.toString());
    FileUtils.writeFile(paramString.getBytes(), (String)localObject, true);
    return localObject;
  }
  
  @NonNull
  private static Method a(Object paramObject)
  {
    paramObject = paramObject.getClass().getDeclaredMethods();
    int j = paramObject.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramObject[i];
      if ((localMethod.getName().equals("dumpMemInfo")) && ((localMethod.getModifiers() & 0x2) != 0))
      {
        Class[] arrayOfClass = localMethod.getParameterTypes();
        QLog.e("SQLiteInfoHelper", 1, new Object[] { "getDumpMemInfoMethod: ", Arrays.toString(arrayOfClass) });
        if ((arrayOfClass != null) && (arrayOfClass.length != 0) && (PrintWriter.class.equals(arrayOfClass[0]))) {
          return localMethod;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private static Method a(Method[] paramArrayOfMethod)
  {
    int j = paramArrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramArrayOfMethod[i];
      if ("dumpAll".equals(localMethod.getName())) {
        return localMethod;
      }
      i += 1;
    }
    return null;
  }
  
  private static void a(int paramInt, Thread[] paramArrayOfThread, StringBuilder paramStringBuilder)
  {
    int i = 0;
    while (i < paramInt)
    {
      Thread localThread = paramArrayOfThread[i];
      paramStringBuilder.append(localThread.getName());
      paramStringBuilder.append(", id=");
      paramStringBuilder.append(localThread.getId());
      paramStringBuilder.append("\n");
      i += 1;
    }
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    Thread[] arrayOfThread = new Thread[Thread.activeCount()];
    a(paramStringBuilder, arrayOfThread, Thread.enumerate(arrayOfThread));
    b(paramStringBuilder);
    c(paramStringBuilder);
  }
  
  private static void a(StringBuilder paramStringBuilder, Thread[] paramArrayOfThread, int paramInt)
  {
    Thread[] arrayOfThread1 = new Thread[paramInt];
    int i = b(paramInt, paramArrayOfThread, arrayOfThread1);
    if (i <= 0) {
      return;
    }
    Thread[] arrayOfThread2 = new Thread[paramInt];
    paramInt = a(paramInt, paramArrayOfThread, arrayOfThread2);
    if (paramInt <= 0) {
      return;
    }
    paramStringBuilder.append("\nacquireConnectionThreads:\n");
    a(i, arrayOfThread1, paramStringBuilder);
    paramStringBuilder.append("\nexecuteConnectionThreads:\n");
    a(paramInt, arrayOfThread2, paramStringBuilder);
  }
  
  private static boolean a(Thread paramThread)
  {
    paramThread = paramThread.getStackTrace();
    int j = paramThread.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramThread[i];
      if (("android.database.sqlite.SQLiteConnection".equals(localObject.getClassName())) && (localObject.getMethodName().contains("xecute"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static int b(int paramInt, Thread[] paramArrayOfThread1, Thread[] paramArrayOfThread2)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramInt; j = k)
    {
      Thread localThread = paramArrayOfThread1[i];
      k = j;
      if (b(localThread))
      {
        paramArrayOfThread2[j] = localThread;
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private static void b(StringBuilder paramStringBuilder)
  {
    Object localObject = a(MobileQQ.sMobileQQ, null);
    if (localObject == null)
    {
      QLog.e("SQLiteInfoHelper", 1, "appendSQLiteMemInfo: activityThread == null");
      return;
    }
    localObject = a(localObject);
    if (localObject == null)
    {
      QLog.e("SQLiteInfoHelper", 1, "appendSQLiteMemInfo: applicationThread == null");
      return;
    }
    localObject = a(localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("SQLiteInfoHelper", 1, "appendSQLiteMemInfo: TextUtils.isEmpty(memInfo)");
      return;
    }
    paramStringBuilder.append("\nmeminfo");
    paramStringBuilder.append((String)localObject);
  }
  
  private static boolean b(Thread paramThread)
  {
    paramThread = paramThread.getStackTrace();
    int j = paramThread.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramThread[i];
      if (("android.database.sqlite.SQLiteConnectionPool".equals(localObject.getClassName())) && ("acquireConnection".equals(localObject.getMethodName()))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static void c(StringBuilder paramStringBuilder)
  {
    Object localObject = new StringBuilder();
    d((StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = a((String)localObject);
    paramStringBuilder.append("\ndbInfo path:");
    paramStringBuilder.append((String)localObject);
  }
  
  private static void d(StringBuilder paramStringBuilder)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 26) {
        return;
      }
      Method localMethod = a(Class.forName("android.database.sqlite.SQLiteDatabase").getDeclaredMethods());
      if ((!a) && (localMethod == null)) {
        throw new AssertionError();
      }
      Parameter[] arrayOfParameter = localMethod.getParameters();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpAllSQLiteDatabase ");
      localStringBuilder.append(Arrays.toString(arrayOfParameter));
      QLog.d("SQLiteInfoHelper", 1, localStringBuilder.toString());
      paramStringBuilder = new StringBuilderPrinter(paramStringBuilder);
      localMethod.setAccessible(true);
      if (arrayOfParameter.length == 2)
      {
        localMethod.invoke(null, new Object[] { paramStringBuilder, Boolean.valueOf(true) });
        return;
      }
      if (arrayOfParameter.length == 3)
      {
        localMethod.invoke(null, new Object[] { paramStringBuilder, Boolean.valueOf(true), Boolean.valueOf(false) });
        return;
      }
      QLog.e("SQLiteInfoHelper", 1, new Object[] { "dumpAllSQLiteDatabase illegal parameter ", localMethod.toString() });
      return;
    }
    catch (Throwable paramStringBuilder)
    {
      QLog.e("SQLiteInfoHelper", 1, "dumpAllSQLiteDatabase ", paramStringBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.SQLiteInfoHelper
 * JD-Core Version:    0.7.0.1
 */