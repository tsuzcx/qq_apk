package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GatewayUtil
{
  protected static int a(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    if (!e(paramContext)) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return c(paramContext);
    }
    if (Build.VERSION.SDK_INT >= 22) {
      return b(paramContext);
    }
    return d(paramContext);
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (paramContext == null)
    {
      QLog.e("GatewayReportUtil", 1, "reportLoginSimCardNum but context is null");
      return;
    }
    int i = a(paramContext);
    QLog.d("GatewayReportUtil", 1, new Object[] { "sim card num is ", Integer.valueOf(i) });
    paramContext = null;
    if (i == 0) {
      paramContext = "0X800B0A9";
    }
    for (;;)
    {
      break;
      if (i == 1) {
        paramContext = "0X800B0AB";
      } else if (i == 2) {
        paramContext = "0X800B0A1";
      }
    }
    if (paramContext != null) {
      ReportController.a(paramAppRuntime, "dc00898", "", "", paramContext, paramContext, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (paramContext == null)
    {
      QLog.e("GatewayReportUtil", 1, "reportSimCardNum but context is null");
      return;
    }
    int i = a(paramContext);
    QLog.d("GatewayReportUtil", 1, new Object[] { "sim card num is ", Integer.valueOf(i) });
    paramContext = null;
    if (i == 0) {
      paramContext = "0X800B0AA";
    }
    for (;;)
    {
      break;
      if (i == 1) {
        paramContext = "0X800B0AC";
      } else if (i == 2) {
        paramContext = "0X800B0A3";
      }
    }
    if (paramContext != null) {
      ReportController.a(paramAppRuntime, "dc00898", "", paramString, paramContext, paramContext, paramInt, 0, "", "", "", "");
    }
  }
  
  @RequiresApi(api=22)
  private static int b(Context paramContext)
  {
    try
    {
      SubscriptionManager localSubscriptionManager = (SubscriptionManager)paramContext.getSystemService("telephony_subscription_service");
      if (ActivityCompat.checkSelfPermission(paramContext, "android.permission.READ_PHONE_STATE") != 0)
      {
        QLog.e("GatewayReportUtil", 1, "getSimCardNumV22 no permission");
        return -1;
      }
      int i = localSubscriptionManager.getActiveSubscriptionInfoCount();
      return i;
    }
    catch (Exception paramContext)
    {
      QLog.e("GatewayReportUtil", 1, new Object[] { "getSimCardNumV22 error : ", paramContext.getMessage() });
    }
    return -1;
  }
  
  @RequiresApi(api=26)
  private static int c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      int j = 0;
      int k;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= 2) {
          break;
        }
        int m = paramContext.getSimState(j);
        k = i;
        if (m == 5) {
          k = i + 1;
        }
        j += 1;
      }
      return k;
    }
    catch (Exception paramContext)
    {
      k = -1;
      QLog.d("GatewayReportUtil", 1, new Object[] { "getSimCardNumV26 error : ", paramContext.getMessage() });
    }
  }
  
  /* Error */
  private static int d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: aload_0
    //   3: ldc 118
    //   5: invokevirtual 90	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8: checkcast 120	android/telephony/TelephonyManager
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 134	android/telephony/TelephonyManager:getSimState	()I
    //   16: istore_1
    //   17: iload_1
    //   18: iconst_5
    //   19: if_icmpne +8 -> 27
    //   22: iconst_1
    //   23: istore_1
    //   24: goto +5 -> 29
    //   27: iconst_0
    //   28: istore_1
    //   29: ldc 120
    //   31: ldc 135
    //   33: iconst_1
    //   34: anewarray 137	java/lang/Class
    //   37: dup
    //   38: iconst_0
    //   39: getstatic 141	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   42: aastore
    //   43: invokevirtual 145	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   46: aload_0
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: iconst_1
    //   54: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokevirtual 151	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 46	java/lang/Integer
    //   64: invokevirtual 154	java/lang/Integer:intValue	()I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_5
    //   70: if_icmpne +8 -> 78
    //   73: iload_2
    //   74: istore_1
    //   75: goto +3 -> 78
    //   78: iload_1
    //   79: ireturn
    //   80: astore_0
    //   81: goto +51 -> 132
    //   84: astore_0
    //   85: goto +86 -> 171
    //   88: astore_0
    //   89: goto +121 -> 210
    //   92: astore_0
    //   93: ldc 33
    //   95: iconst_1
    //   96: iconst_4
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc 156
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: iconst_m1
    //   108: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: ldc 158
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: aload_0
    //   120: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   127: iconst_m1
    //   128: ireturn
    //   129: astore_0
    //   130: iconst_0
    //   131: istore_1
    //   132: ldc 33
    //   134: iconst_1
    //   135: iconst_4
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc 160
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: iload_1
    //   147: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_2
    //   153: ldc 158
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: aload_0
    //   159: invokevirtual 161	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   162: aastore
    //   163: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   166: iload_1
    //   167: ireturn
    //   168: astore_0
    //   169: iconst_0
    //   170: istore_1
    //   171: ldc 33
    //   173: iconst_1
    //   174: iconst_4
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: ldc 163
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: iload_1
    //   186: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: ldc 158
    //   194: aastore
    //   195: dup
    //   196: iconst_3
    //   197: aload_0
    //   198: invokevirtual 164	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   205: iload_1
    //   206: ireturn
    //   207: astore_0
    //   208: iconst_0
    //   209: istore_1
    //   210: ldc 33
    //   212: iconst_1
    //   213: iconst_4
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: ldc 166
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: iload_1
    //   225: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_2
    //   231: ldc 158
    //   233: aastore
    //   234: dup
    //   235: iconst_3
    //   236: aload_0
    //   237: invokevirtual 167	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   244: iload_1
    //   245: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   16	229	1	i	int
    //   1	73	2	j	int
    //   67	4	3	k	int
    // Exception table:
    //   from	to	target	type
    //   29	68	80	java/lang/reflect/InvocationTargetException
    //   29	68	84	java/lang/IllegalAccessException
    //   29	68	88	java/lang/NoSuchMethodException
    //   2	17	92	java/lang/Exception
    //   29	68	92	java/lang/Exception
    //   2	17	129	java/lang/reflect/InvocationTargetException
    //   2	17	168	java/lang/IllegalAccessException
    //   2	17	207	java/lang/NoSuchMethodException
  }
  
  private static boolean e(Context paramContext)
  {
    int i = ((TelephonyManager)paramContext.getSystemService("phone")).getSimState();
    boolean bool;
    if ((i != 0) && (i != 1)) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("GatewayReportUtil", 1, new Object[] { "hasSimCard result : ", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GatewayUtil
 * JD-Core Version:    0.7.0.1
 */