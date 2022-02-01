package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.javahook.TimeoutExceptionHooker;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static boolean jdField_a_of_type_Boolean = false;
  
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
      TimeoutExceptionHooker.a();
    }
  }
  
  /* Error */
  private static void c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 11	com/tencent/mobileqq/startup/step/InitHook:jdField_a_of_type_Boolean	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 11	com/tencent/mobileqq/startup/step/InitHook:jdField_a_of_type_Boolean	Z
    //   19: ldc 173
    //   21: ldc 175
    //   23: invokestatic 181	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   26: checkcast 175	com/tencent/mobileqq/dpc/api/IDPCApi
    //   29: getstatic 187	com/tencent/mobileqq/dpc/enumname/DPCNames:hook_switch	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   32: invokevirtual 190	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   35: ldc 192
    //   37: invokeinterface 195 3 0
    //   42: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifne +57 -> 102
    //   48: ldc 197
    //   50: iconst_1
    //   51: ldc 199
    //   53: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_0
    //   57: aconst_null
    //   58: ldc 206
    //   60: invokestatic 167	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   63: goto -52 -> 11
    //   66: astore_1
    //   67: iconst_0
    //   68: aload_1
    //   69: ldc 165
    //   71: invokestatic 167	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   74: invokestatic 97	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   77: invokestatic 103	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   80: aconst_null
    //   81: ldc 197
    //   83: iconst_1
    //   84: lconst_0
    //   85: lconst_0
    //   86: aconst_null
    //   87: ldc 49
    //   89: iconst_1
    //   90: invokevirtual 109	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   93: goto -82 -> 11
    //   96: astore_1
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: invokestatic 160	com/tencent/mobileqq/javahooksdk/JavaHookBridge:isSdkAvailable	()Z
    //   105: ifne +32 -> 137
    //   108: ldc 197
    //   110: iconst_1
    //   111: ldc 208
    //   113: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: iconst_0
    //   117: aconst_null
    //   118: ldc 209
    //   120: invokestatic 167	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   123: goto -112 -> 11
    //   126: astore_1
    //   127: iconst_0
    //   128: aload_1
    //   129: ldc 165
    //   131: invokestatic 167	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   134: goto -60 -> 74
    //   137: ldc 197
    //   139: iconst_1
    //   140: ldc 211
    //   142: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: invokestatic 216	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   148: invokevirtual 219	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/monitor/base/IAPMModuleBattery;
    //   151: invokeinterface 222 1 0
    //   156: getstatic 35	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   159: iconst_1
    //   160: if_icmpne -149 -> 11
    //   163: invokestatic 225	com/tencent/mobileqq/javahook/BitmapOOMHooker:a	()V
    //   166: invokestatic 228	com/tencent/mobileqq/javahook/BadTokenHooker:a	()V
    //   169: getstatic 35	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   172: iconst_1
    //   173: if_icmpne +3 -> 176
    //   176: iconst_1
    //   177: aconst_null
    //   178: iconst_0
    //   179: invokestatic 167	com/tencent/mobileqq/startup/step/InitHook:a	(ZLjava/lang/Throwable;I)V
    //   182: goto -108 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   66	3	1	localException	java.lang.Exception
    //   96	5	1	localObject	Object
    //   126	3	1	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   19	63	66	java/lang/Exception
    //   102	123	66	java/lang/Exception
    //   137	176	66	java/lang/Exception
    //   176	182	66	java/lang/Exception
    //   3	7	96	finally
    //   15	19	96	finally
    //   19	63	96	finally
    //   67	74	96	finally
    //   74	93	96	finally
    //   102	123	96	finally
    //   127	134	96	finally
    //   137	176	96	finally
    //   176	182	96	finally
    //   19	63	126	java/lang/Error
    //   102	123	126	java/lang/Error
    //   137	176	126	java/lang/Error
    //   176	182	126	java/lang/Error
  }
  
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      if (((IDPCApi)QRoute.api(IDPCApi.class)).getServerDataCurrentStateWithoutAccountManager() == 4) {
        c();
      }
    }
    for (;;)
    {
      b();
      return true;
      ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(new InitHook.MyDPCObserver(null));
      continue;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitHook
 * JD-Core Version:    0.7.0.1
 */