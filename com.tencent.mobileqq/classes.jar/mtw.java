import java.net.URI;

public class mtw
{
  public static int a(String paramString)
  {
    return a(paramString, 1, 1000);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return -1;
      paramString = b(a(paramInt1, paramInt2, paramString));
    } while (paramString == null);
    try
    {
      paramInt1 = Math.round(Float.valueOf(paramString.substring(paramString.indexOf("min/avg/max/mdev") + 19).split("/")[1]).floatValue());
      return paramInt1;
    }
    catch (Exception paramString)
    {
      lba.f("SignalStrengthReport", "getAvgRTT e:" + paramString);
    }
    return -1;
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString)
  {
    return "/system/bin/ping -c " + paramInt1 + " -w " + paramInt2 + " " + paramString;
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = URI.create(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      lba.f("SignalStrengthReport", "getDomain e:" + paramString);
    }
    return null;
  }
  
  /* Error */
  private static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 109	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: aload_0
    //   6: invokevirtual 113	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   9: astore_1
    //   10: aload_1
    //   11: astore_0
    //   12: aload_1
    //   13: invokevirtual 119	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_1
    //   18: astore_0
    //   19: new 121	java/io/BufferedReader
    //   22: dup
    //   23: new 123	java/io/InputStreamReader
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 126	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore 4
    //   36: aload_1
    //   37: astore_0
    //   38: new 58	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   45: astore 5
    //   47: aload_1
    //   48: astore_0
    //   49: aload 4
    //   51: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull +67 -> 125
    //   61: aload_1
    //   62: astore_0
    //   63: aload 5
    //   65: aload 6
    //   67: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: astore_0
    //   73: aload 5
    //   75: ldc 134
    //   77: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: goto -34 -> 47
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 56
    //   89: new 58	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   96: ldc 136
    //   98: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 81	lba:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_3
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokevirtual 139	java/lang/Process:destroy	()V
    //   121: aload_3
    //   122: astore_0
    //   123: aload_0
    //   124: areturn
    //   125: aload_1
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 142	java/io/BufferedReader:close	()V
    //   132: aload_1
    //   133: astore_0
    //   134: aload_2
    //   135: invokevirtual 145	java/io/InputStream:close	()V
    //   138: aload_1
    //   139: astore_0
    //   140: aload 5
    //   142: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_2
    //   146: aload_2
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull -26 -> 123
    //   152: aload_1
    //   153: invokevirtual 139	java/lang/Process:destroy	()V
    //   156: aload_2
    //   157: areturn
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_0
    //   162: astore_1
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 139	java/lang/Process:destroy	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_1
    //   174: aload_0
    //   175: astore_2
    //   176: goto -13 -> 163
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: goto -97 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   9	163	1	localObject1	Object
    //   173	1	1	localObject2	Object
    //   181	1	1	localObject3	Object
    //   16	12	2	localInputStream	java.io.InputStream
    //   84	51	2	localThrowable1	java.lang.Throwable
    //   145	31	2	str1	String
    //   179	1	2	localThrowable2	java.lang.Throwable
    //   1	121	3	localObject4	Object
    //   34	94	4	localBufferedReader	java.io.BufferedReader
    //   45	96	5	localStringBuilder	java.lang.StringBuilder
    //   54	12	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   12	17	84	java/lang/Throwable
    //   19	36	84	java/lang/Throwable
    //   38	47	84	java/lang/Throwable
    //   49	56	84	java/lang/Throwable
    //   63	71	84	java/lang/Throwable
    //   73	81	84	java/lang/Throwable
    //   127	132	84	java/lang/Throwable
    //   134	138	84	java/lang/Throwable
    //   140	146	84	java/lang/Throwable
    //   2	10	158	finally
    //   12	17	173	finally
    //   19	36	173	finally
    //   38	47	173	finally
    //   49	56	173	finally
    //   63	71	173	finally
    //   73	81	173	finally
    //   87	111	173	finally
    //   127	132	173	finally
    //   134	138	173	finally
    //   140	146	173	finally
    //   2	10	179	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtw
 * JD-Core Version:    0.7.0.1
 */