package com.tencent.qqperf.debug.tools;

public class ProcessUtil
{
  /* Error */
  public static java.lang.String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 17	java/io/BufferedReader
    //   5: dup
    //   6: new 19	java/io/InputStreamReader
    //   9: dup
    //   10: new 21	java/io/FileInputStream
    //   13: dup
    //   14: new 23	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   21: ldc 26
    //   23: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 36	android/os/Process:myPid	()I
    //   29: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 41
    //   34: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: ldc 50
    //   45: invokespecial 53	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   48: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_2
    //   52: new 23	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_2
    //   61: invokevirtual 59	java/io/BufferedReader:read	()I
    //   64: istore_1
    //   65: iload_1
    //   66: ifle +102 -> 168
    //   69: aload_3
    //   70: iload_1
    //   71: i2c
    //   72: invokevirtual 62	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -16 -> 60
    //   79: astore_3
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 65	java/io/BufferedReader:close	()V
    //   88: invokestatic 36	android/os/Process:myPid	()I
    //   91: istore_1
    //   92: aload_0
    //   93: ifnull +140 -> 233
    //   96: aload_0
    //   97: ldc 67
    //   99: invokevirtual 73	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   102: checkcast 75	android/app/ActivityManager
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 79	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +121 -> 233
    //   115: aload_2
    //   116: invokeinterface 84 1 0
    //   121: ifle +112 -> 233
    //   124: aload_0
    //   125: invokevirtual 79	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   128: invokeinterface 88 1 0
    //   133: astore_0
    //   134: aload_0
    //   135: invokeinterface 94 1 0
    //   140: ifeq +93 -> 233
    //   143: aload_0
    //   144: invokeinterface 98 1 0
    //   149: checkcast 100	android/app/ActivityManager$RunningAppProcessInfo
    //   152: astore_2
    //   153: aload_2
    //   154: getfield 104	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   157: iload_1
    //   158: if_icmpne -24 -> 134
    //   161: aload_2
    //   162: getfield 108	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   165: astore_3
    //   166: aload_3
    //   167: areturn
    //   168: aload_3
    //   169: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore_3
    //   173: aload_3
    //   174: astore_0
    //   175: aload_0
    //   176: astore_3
    //   177: aload_2
    //   178: ifnull -12 -> 166
    //   181: aload_2
    //   182: invokevirtual 65	java/io/BufferedReader:close	()V
    //   185: aload_0
    //   186: areturn
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   192: aload_0
    //   193: areturn
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   199: goto -111 -> 88
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 65	java/io/BufferedReader:close	()V
    //   213: aload_0
    //   214: athrow
    //   215: astore_2
    //   216: aload_2
    //   217: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   220: goto -7 -> 213
    //   223: astore_0
    //   224: goto -19 -> 205
    //   227: astore_2
    //   228: aload_3
    //   229: astore_2
    //   230: goto -150 -> 80
    //   233: ldc 113
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramContext	android.content.Context
    //   64	95	1	i	int
    //   51	131	2	localObject1	Object
    //   187	2	2	localIOException1	java.io.IOException
    //   194	2	2	localIOException2	java.io.IOException
    //   204	6	2	localObject2	Object
    //   215	2	2	localIOException3	java.io.IOException
    //   227	1	2	localException1	java.lang.Exception
    //   229	1	2	localObject3	Object
    //   1	69	3	localStringBuilder	java.lang.StringBuilder
    //   79	1	3	localException2	java.lang.Exception
    //   165	64	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	60	79	java/lang/Exception
    //   60	65	79	java/lang/Exception
    //   69	76	79	java/lang/Exception
    //   168	173	79	java/lang/Exception
    //   181	185	187	java/io/IOException
    //   84	88	194	java/io/IOException
    //   2	52	202	finally
    //   209	213	215	java/io/IOException
    //   52	60	223	finally
    //   60	65	223	finally
    //   69	76	223	finally
    //   168	173	223	finally
    //   2	52	227	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.tools.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */