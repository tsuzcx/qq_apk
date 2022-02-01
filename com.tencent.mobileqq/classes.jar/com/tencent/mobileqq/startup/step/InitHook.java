package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import ausr;
import bcar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InitHook
  extends Step
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static boolean jdField_a_of_type_Boolean;
  
  @TargetApi(9)
  private static void a(boolean paramBoolean, Throwable paramThrowable, int paramInt)
  {
    if (BaseApplicationImpl.sProcessId != 1) {}
    Object localObject2;
    Object localObject3;
    do
    {
      return;
      localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
      localObject2 = ((SharedPreferences)localObject1).getString("reportJavaHook", "");
      localObject3 = new Date();
      localObject3 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject3);
    } while (((String)localObject3).equals(localObject2));
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putString("reportJavaHook", (String)localObject3);
    if (Build.VERSION.SDK_INT > 8) {
      ((SharedPreferences.Editor)localObject1).apply();
    }
    while (paramBoolean)
    {
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "JavaHookSdkLoadSo", paramBoolean, 0L, 0L, null, "", true);
      return;
      ((SharedPreferences.Editor)localObject1).commit();
    }
    localObject1 = new HashMap();
    if (paramThrowable != null)
    {
      localObject2 = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter((Writer)localObject2));
      ((HashMap)localObject1).put("detail", localObject2.toString());
    }
    ((HashMap)localObject1).put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "JavaHookSdkLoadSo", paramBoolean, 0L, 0L, (HashMap)localObject1, "", true);
  }
  
  private static void b()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) {
          if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 2))
          {
            int i = BaseApplicationImpl.sProcessId;
            if (i != 7) {
              continue;
            }
          }
        }
        try
        {
          boolean bool = JavaHookBridge.isSdkAvailable();
          if (bool) {
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          a(false, localThrowable, 90001);
          continue;
        }
        return;
      }
      finally {}
      ausr.a();
    }
  }
  
  /* Error */
  private static void c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 171	com/tencent/mobileqq/startup/step/InitHook:jdField_a_of_type_Boolean	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 171	com/tencent/mobileqq/startup/step/InitHook:jdField_a_of_type_Boolean	Z
    //   19: ldc 173
    //   21: invokestatic 178	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   24: getstatic 184	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:hook_switch	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   27: invokevirtual 187	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   30: ldc 189
    //   32: invokevirtual 191	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +57 -> 95
    //   41: ldc 193
    //   43: iconst_1
    //   44: ldc 195
    //   46: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: iconst_0
    //   50: aconst_null
    //   51: ldc 202
    //   53: invokestatic 165	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   56: goto -45 -> 11
    //   59: astore_1
    //   60: iconst_0
    //   61: aload_1
    //   62: ldc 163
    //   64: invokestatic 165	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   67: invokestatic 95	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   70: invokestatic 101	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   73: aconst_null
    //   74: ldc 193
    //   76: iconst_1
    //   77: lconst_0
    //   78: lconst_0
    //   79: aconst_null
    //   80: ldc 47
    //   82: iconst_1
    //   83: invokevirtual 107	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   86: goto -75 -> 11
    //   89: astore_1
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    //   95: invokestatic 158	com/tencent/mobileqq/javahooksdk/JavaHookBridge:isSdkAvailable	()Z
    //   98: ifne +32 -> 130
    //   101: ldc 193
    //   103: iconst_1
    //   104: ldc 204
    //   106: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iconst_0
    //   110: aconst_null
    //   111: ldc 205
    //   113: invokestatic 165	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   116: goto -105 -> 11
    //   119: astore_1
    //   120: iconst_0
    //   121: aload_1
    //   122: ldc 163
    //   124: invokestatic 165	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   127: goto -60 -> 67
    //   130: ldc 193
    //   132: iconst_1
    //   133: ldc 207
    //   135: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: invokestatic 212	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   141: invokevirtual 215	com/tencent/mfsdk/MagnifierSDK:a	()Lachp;
    //   144: invokeinterface 218 1 0
    //   149: getstatic 33	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   152: iconst_1
    //   153: if_icmpne -142 -> 11
    //   156: invokestatic 221	ausm:a	()V
    //   159: invokestatic 224	ausj:a	()V
    //   162: getstatic 33	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   165: iconst_1
    //   166: if_icmpne +3 -> 169
    //   169: iconst_1
    //   170: aconst_null
    //   171: iconst_0
    //   172: invokestatic 165	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   175: goto -108 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   59	3	1	localException	java.lang.Exception
    //   89	5	1	localObject	Object
    //   119	3	1	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   19	56	59	java/lang/Exception
    //   95	116	59	java/lang/Exception
    //   130	169	59	java/lang/Exception
    //   169	175	59	java/lang/Exception
    //   3	7	89	finally
    //   15	19	89	finally
    //   19	56	89	finally
    //   60	67	89	finally
    //   67	86	89	finally
    //   95	116	89	finally
    //   120	127	89	finally
    //   130	169	89	finally
    //   169	175	89	finally
    //   19	56	119	java/lang/Error
    //   95	116	119	java/lang/Error
    //   130	169	119	java/lang/Error
    //   169	175	119	java/lang/Error
  }
  
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      if (DeviceProfileManager.b().a() == 4) {
        c();
      }
    }
    for (;;)
    {
      b();
      return true;
      DeviceProfileManager.a(new bcar(null));
      continue;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitHook
 * JD-Core Version:    0.7.0.1
 */