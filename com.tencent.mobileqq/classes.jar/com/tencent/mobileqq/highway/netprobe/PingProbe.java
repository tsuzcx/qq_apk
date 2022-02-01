package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingProbe
  extends ProbeItem
{
  public static final int DEFAULT_PING_COUNT = 3;
  public static final int DEFAULT_PING_TIMEOUT = 10;
  private static final String PING_RESULT_REGEX = "(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*";
  public static String PROBE_NAME = "Ping_Probe";
  public static final int RESULT_CONN_BLOCKING = 2;
  public static final int RESULT_EXCEPTION = 1;
  
  /* Error */
  public static String execPing(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: iload_0
    //   10: ifle +45 -> 55
    //   13: new 40	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 43
    //   26: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: ldc 49
    //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: iload_0
    //   41: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 4
    //   47: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 5
    //   52: goto +35 -> 87
    //   55: new 40	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: ldc 43
    //   68: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: ldc 58
    //   76: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 4
    //   82: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 5
    //   87: aload 5
    //   89: astore 4
    //   91: iload_1
    //   92: ifle +42 -> 134
    //   95: new 40	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   102: astore 4
    //   104: aload 4
    //   106: aload 5
    //   108: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: ldc 60
    //   116: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 4
    //   122: iload_1
    //   123: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 4
    //   129: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: astore 5
    //   138: iload_2
    //   139: ifle +42 -> 181
    //   142: new 40	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   149: astore 5
    //   151: aload 5
    //   153: aload 4
    //   155: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 5
    //   161: ldc 62
    //   163: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 5
    //   169: iload_2
    //   170: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore 5
    //   181: new 40	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   188: astore 4
    //   190: aload 4
    //   192: aload 5
    //   194: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: ldc 64
    //   202: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 4
    //   208: aload_3
    //   209: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore_3
    //   219: invokestatic 70	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   222: aload_3
    //   223: invokevirtual 74	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 80	java/lang/Process:waitFor	()I
    //   231: istore_0
    //   232: new 82	java/io/BufferedReader
    //   235: dup
    //   236: new 84	java/io/InputStreamReader
    //   239: dup
    //   240: aload_3
    //   241: invokevirtual 88	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   244: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   247: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   250: astore 4
    //   252: aload_3
    //   253: astore 5
    //   255: aload 4
    //   257: astore 6
    //   259: new 40	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   266: astore 7
    //   268: aload_3
    //   269: astore 5
    //   271: aload 4
    //   273: astore 6
    //   275: aload 4
    //   277: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   280: astore 8
    //   282: aload 8
    //   284: ifnull +36 -> 320
    //   287: aload_3
    //   288: astore 5
    //   290: aload 4
    //   292: astore 6
    //   294: aload 7
    //   296: aload 8
    //   298: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_3
    //   303: astore 5
    //   305: aload 4
    //   307: astore 6
    //   309: aload 7
    //   311: ldc 99
    //   313: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: goto -49 -> 268
    //   320: aload_3
    //   321: astore 5
    //   323: aload 4
    //   325: astore 6
    //   327: aload 7
    //   329: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: astore 7
    //   334: iload_0
    //   335: ifeq +38 -> 373
    //   338: aload_3
    //   339: astore 5
    //   341: aload 4
    //   343: astore 6
    //   345: aload 7
    //   347: invokevirtual 104	java/lang/String:trim	()Ljava/lang/String;
    //   350: invokevirtual 107	java/lang/String:length	()I
    //   353: istore_0
    //   354: iload_0
    //   355: ifeq +6 -> 361
    //   358: goto +15 -> 373
    //   361: aload 4
    //   363: invokevirtual 110	java/io/BufferedReader:close	()V
    //   366: aload_3
    //   367: ifnull +107 -> 474
    //   370: goto +100 -> 470
    //   373: aload_3
    //   374: astore 5
    //   376: aload 4
    //   378: astore 6
    //   380: aload 7
    //   382: invokevirtual 104	java/lang/String:trim	()Ljava/lang/String;
    //   385: astore 7
    //   387: aload 4
    //   389: invokevirtual 110	java/io/BufferedReader:close	()V
    //   392: aload_3
    //   393: ifnull +7 -> 400
    //   396: aload_3
    //   397: invokevirtual 113	java/lang/Process:destroy	()V
    //   400: aload 7
    //   402: areturn
    //   403: astore 7
    //   405: goto +36 -> 441
    //   408: astore 4
    //   410: aconst_null
    //   411: astore 6
    //   413: goto +68 -> 481
    //   416: astore 7
    //   418: aconst_null
    //   419: astore 4
    //   421: goto +20 -> 441
    //   424: astore 4
    //   426: aconst_null
    //   427: astore_3
    //   428: aload_3
    //   429: astore 6
    //   431: goto +50 -> 481
    //   434: astore 7
    //   436: aconst_null
    //   437: astore_3
    //   438: aload_3
    //   439: astore 4
    //   441: aload_3
    //   442: astore 5
    //   444: aload 4
    //   446: astore 6
    //   448: aload 7
    //   450: invokevirtual 116	java/lang/Throwable:printStackTrace	()V
    //   453: aload 4
    //   455: ifnull +11 -> 466
    //   458: aload 4
    //   460: invokevirtual 110	java/io/BufferedReader:close	()V
    //   463: goto +3 -> 466
    //   466: aload_3
    //   467: ifnull +7 -> 474
    //   470: aload_3
    //   471: invokevirtual 113	java/lang/Process:destroy	()V
    //   474: aconst_null
    //   475: areturn
    //   476: astore 4
    //   478: aload 5
    //   480: astore_3
    //   481: aload 6
    //   483: ifnull +11 -> 494
    //   486: aload 6
    //   488: invokevirtual 110	java/io/BufferedReader:close	()V
    //   491: goto +3 -> 494
    //   494: aload_3
    //   495: ifnull +7 -> 502
    //   498: aload_3
    //   499: invokevirtual 113	java/lang/Process:destroy	()V
    //   502: goto +6 -> 508
    //   505: aload 4
    //   507: athrow
    //   508: goto -3 -> 505
    //   511: astore 4
    //   513: goto -147 -> 366
    //   516: astore 4
    //   518: goto -126 -> 392
    //   521: astore 4
    //   523: goto -57 -> 466
    //   526: astore 5
    //   528: goto -34 -> 494
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	paramInt1	int
    //   0	531	1	paramInt2	int
    //   0	531	2	paramInt3	int
    //   0	531	3	paramString	String
    //   20	368	4	localObject1	Object
    //   408	1	4	localObject2	Object
    //   419	1	4	localObject3	Object
    //   424	1	4	localObject4	Object
    //   439	20	4	str1	String
    //   476	30	4	localObject5	Object
    //   511	1	4	localException1	java.lang.Exception
    //   516	1	4	localException2	java.lang.Exception
    //   521	1	4	localException3	java.lang.Exception
    //   50	429	5	localObject6	Object
    //   526	1	5	localException4	java.lang.Exception
    //   257	230	6	localObject7	Object
    //   266	135	7	localObject8	Object
    //   403	1	7	localThrowable1	java.lang.Throwable
    //   416	1	7	localThrowable2	java.lang.Throwable
    //   434	15	7	localThrowable3	java.lang.Throwable
    //   280	17	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   259	268	403	java/lang/Throwable
    //   275	282	403	java/lang/Throwable
    //   294	302	403	java/lang/Throwable
    //   309	317	403	java/lang/Throwable
    //   327	334	403	java/lang/Throwable
    //   345	354	403	java/lang/Throwable
    //   380	387	403	java/lang/Throwable
    //   227	252	408	finally
    //   227	252	416	java/lang/Throwable
    //   219	227	424	finally
    //   219	227	434	java/lang/Throwable
    //   259	268	476	finally
    //   275	282	476	finally
    //   294	302	476	finally
    //   309	317	476	finally
    //   327	334	476	finally
    //   345	354	476	finally
    //   380	387	476	finally
    //   448	453	476	finally
    //   361	366	511	java/lang/Exception
    //   387	392	516	java/lang/Exception
    //   458	463	521	java/lang/Exception
    //   486	491	526	java/lang/Exception
  }
  
  public static String execPing(int paramInt1, int paramInt2, String paramString)
  {
    return execPing(paramInt1, paramInt2, -1, paramString);
  }
  
  public static String execPing(int paramInt, String paramString)
  {
    return execPing(3, paramInt, paramString);
  }
  
  public static String execPing(String paramString)
  {
    return execPing(3, 10, paramString);
  }
  
  public void doProbe()
  {
    Object localObject = execPing(this.mRequest.getIp());
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localObject = Pattern.compile("(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*").matcher((CharSequence)localObject);
      if ((((Matcher)localObject).find()) && (((Matcher)localObject).groupCount() == 3))
      {
        this.mResult.extra = ((Matcher)localObject).group();
        try
        {
          if (Integer.valueOf(((Matcher)localObject).group(2)).intValue() > 0)
          {
            this.mResult.success = true;
            this.mResult.appendResult(((Matcher)localObject).group());
            return;
          }
          this.mResult.success = false;
          this.mResult.errCode = 2;
          this.mResult.errDesc = ((Matcher)localObject).group();
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
          this.mResult.success = false;
          this.mResult.errCode = 1;
          this.mResult.errDesc = localNumberFormatException.toString();
        }
      }
      return;
    }
    this.mResult.success = false;
    this.mResult.errCode = 1;
    this.mResult.errDesc = "ping progress has exception!";
  }
  
  public String getProbeName()
  {
    return PROBE_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.PingProbe
 * JD-Core Version:    0.7.0.1
 */