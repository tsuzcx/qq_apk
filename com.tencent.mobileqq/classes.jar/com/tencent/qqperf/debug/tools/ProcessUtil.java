package com.tencent.qqperf.debug.tools;

public class ProcessUtil
{
  /* Error */
  public static java.lang.String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 17	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: ldc 20
    //   16: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: invokestatic 30	android/os/Process:myPid	()I
    //   24: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 35
    //   31: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: new 37	java/io/BufferedReader
    //   38: dup
    //   39: new 39	java/io/InputStreamReader
    //   42: dup
    //   43: new 41	java/io/FileInputStream
    //   46: dup
    //   47: aload_2
    //   48: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: ldc 50
    //   56: invokespecial 53	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   59: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_2
    //   63: new 17	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload_2
    //   72: invokevirtual 59	java/io/BufferedReader:read	()I
    //   75: istore_1
    //   76: iload_1
    //   77: ifle +13 -> 90
    //   80: aload_3
    //   81: iload_1
    //   82: i2c
    //   83: invokevirtual 62	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: goto -16 -> 71
    //   90: aload_3
    //   91: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: aload_2
    //   96: invokevirtual 65	java/io/BufferedReader:close	()V
    //   99: aload_3
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: areturn
    //   108: astore_0
    //   109: goto +9 -> 118
    //   112: goto +24 -> 136
    //   115: astore_0
    //   116: aload_3
    //   117: astore_2
    //   118: aload_2
    //   119: ifnull +15 -> 134
    //   122: aload_2
    //   123: invokevirtual 65	java/io/BufferedReader:close	()V
    //   126: goto +8 -> 134
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   134: aload_0
    //   135: athrow
    //   136: aload_2
    //   137: ifnull +15 -> 152
    //   140: aload_2
    //   141: invokevirtual 65	java/io/BufferedReader:close	()V
    //   144: goto +8 -> 152
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   152: invokestatic 30	android/os/Process:myPid	()I
    //   155: istore_1
    //   156: aload_0
    //   157: ifnull +73 -> 230
    //   160: aload_0
    //   161: ldc 70
    //   163: invokevirtual 76	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   166: checkcast 78	android/app/ActivityManager
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 82	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +54 -> 230
    //   179: aload_2
    //   180: invokeinterface 87 1 0
    //   185: ifle +45 -> 230
    //   188: aload_0
    //   189: invokevirtual 82	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   192: invokeinterface 91 1 0
    //   197: astore_0
    //   198: aload_0
    //   199: invokeinterface 97 1 0
    //   204: ifeq +26 -> 230
    //   207: aload_0
    //   208: invokeinterface 101 1 0
    //   213: checkcast 103	android/app/ActivityManager$RunningAppProcessInfo
    //   216: astore_2
    //   217: aload_2
    //   218: getfield 107	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   221: iload_1
    //   222: if_icmpne -24 -> 198
    //   225: aload_2
    //   226: getfield 111	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   229: areturn
    //   230: ldc 113
    //   232: areturn
    //   233: astore_2
    //   234: aload 4
    //   236: astore_2
    //   237: goto -101 -> 136
    //   240: astore_3
    //   241: goto -129 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	android.content.Context
    //   75	148	1	i	int
    //   12	111	2	localObject1	Object
    //   129	12	2	localIOException1	java.io.IOException
    //   147	2	2	localIOException2	java.io.IOException
    //   174	52	2	localObject2	Object
    //   233	1	2	localException1	java.lang.Exception
    //   236	1	2	localObject3	Object
    //   4	113	3	localObject4	Object
    //   240	1	3	localException2	java.lang.Exception
    //   1	234	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   95	99	101	java/io/IOException
    //   63	71	108	finally
    //   71	76	108	finally
    //   80	87	108	finally
    //   90	95	108	finally
    //   5	63	115	finally
    //   122	126	129	java/io/IOException
    //   140	144	147	java/io/IOException
    //   5	63	233	java/lang/Exception
    //   63	71	240	java/lang/Exception
    //   71	76	240	java/lang/Exception
    //   80	87	240	java/lang/Exception
    //   90	95	240	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.debug.tools.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */