package com.tencent.qqperf;

import mqq.app.MobileQQ;

public class QAPMIniter
{
  public static boolean a = false;
  
  public static int a()
  {
    int i = 0;
    if (MobileQQ.sProcessId == 2) {
      i = 14;
    }
    while (MobileQQ.sProcessId != 7) {
      return i;
    }
    return 19;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/tencent/qqperf/QAPMIniter:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 21	mqq/app/MobileQQ:sProcessId	I
    //   18: iconst_1
    //   19: if_icmpne +9 -> 28
    //   22: getstatic 28	com/tencent/qqperf/abfactor/AbFactorManger:a	[Ljava/lang/Class;
    //   25: invokestatic 34	com/tencent/qapmsdk/base/reporter/ab/AbProxy:setAbTypes	([Ljava/lang/Class;)V
    //   28: iconst_1
    //   29: putstatic 10	com/tencent/qqperf/QAPMIniter:a	Z
    //   32: getstatic 39	com/tencent/qapmsdk/QAPM:LevelInfo	I
    //   35: istore_0
    //   36: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +187 -> 226
    //   42: getstatic 48	com/tencent/qapmsdk/QAPM:LevelDebug	I
    //   45: istore_0
    //   46: iconst_2
    //   47: getstatic 21	mqq/app/MobileQQ:sProcessId	I
    //   50: if_icmpeq +179 -> 229
    //   53: bipush 8
    //   55: getstatic 21	mqq/app/MobileQQ:sProcessId	I
    //   58: if_icmpne +162 -> 220
    //   61: goto +168 -> 229
    //   64: invokestatic 53	com/tencent/qqperf/MagnifierSDK:a	()Ljava/lang/String;
    //   67: astore 4
    //   69: invokestatic 57	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   72: invokevirtual 63	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   75: invokestatic 57	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   78: invokevirtual 66	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   81: sipush 128
    //   84: invokevirtual 72	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   87: getfield 78	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   90: ldc 80
    //   92: invokevirtual 86	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   95: invokevirtual 89	java/lang/Object:toString	()Ljava/lang/String;
    //   98: astore_3
    //   99: bipush 109
    //   101: invokestatic 57	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   104: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   107: pop
    //   108: bipush 101
    //   110: aload_2
    //   111: invokestatic 96	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   114: pop
    //   115: bipush 103
    //   117: aload 4
    //   119: invokestatic 96	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   122: pop
    //   123: bipush 104
    //   125: aload_3
    //   126: invokestatic 96	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   129: pop
    //   130: bipush 105
    //   132: iload_0
    //   133: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   139: pop
    //   140: bipush 106
    //   142: ldc 104
    //   144: invokestatic 96	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   147: pop
    //   148: bipush 107
    //   150: ldc 106
    //   152: invokestatic 96	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   155: pop
    //   156: getstatic 112	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   159: new 114	com/tencent/qqperf/QAPMLogImpl
    //   162: dup
    //   163: iload_0
    //   164: invokespecial 117	com/tencent/qqperf/QAPMLogImpl:<init>	(I)V
    //   167: invokevirtual 121	com/tencent/qapmsdk/common/logger/Logger:setLogProxy	(Lcom/tencent/qapmsdk/common/logger/ILogProxy;)V
    //   170: ldc 123
    //   172: iconst_1
    //   173: new 125	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   180: ldc 128
    //   182: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_0
    //   186: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: goto -184 -> 11
    //   198: astore_2
    //   199: ldc 2
    //   201: monitorexit
    //   202: aload_2
    //   203: athrow
    //   204: astore_3
    //   205: ldc 123
    //   207: iconst_1
    //   208: ldc 142
    //   210: aload_3
    //   211: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: ldc 148
    //   216: astore_3
    //   217: goto -118 -> 99
    //   220: ldc 150
    //   222: astore_2
    //   223: goto -159 -> 64
    //   226: goto -180 -> 46
    //   229: ldc 152
    //   231: astore_2
    //   232: goto -168 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	151	0	i	int
    //   6	2	1	bool	boolean
    //   110	1	2	str1	java.lang.String
    //   198	5	2	localObject	Object
    //   222	10	2	str2	java.lang.String
    //   98	28	3	str3	java.lang.String
    //   204	7	3	localThrowable	java.lang.Throwable
    //   216	1	3	str4	java.lang.String
    //   67	51	4	str5	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   3	7	198	finally
    //   15	28	198	finally
    //   28	46	198	finally
    //   46	61	198	finally
    //   64	69	198	finally
    //   69	99	198	finally
    //   99	195	198	finally
    //   205	214	198	finally
    //   69	99	204	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.QAPMIniter
 * JD-Core Version:    0.7.0.1
 */