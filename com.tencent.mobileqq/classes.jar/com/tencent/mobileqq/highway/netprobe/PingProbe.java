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
    //   1: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: aconst_null
    //   8: astore 4
    //   10: aload 4
    //   12: areturn
    //   13: iload_0
    //   14: ifle +247 -> 261
    //   17: new 42	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   24: ldc 45
    //   26: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 51
    //   31: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_0
    //   35: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: aload 5
    //   45: astore 4
    //   47: iload_1
    //   48: ifle +29 -> 77
    //   51: new 42	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   58: aload 5
    //   60: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 60
    //   65: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_1
    //   69: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: astore 5
    //   81: iload_2
    //   82: ifle +29 -> 111
    //   85: new 42	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   92: aload 4
    //   94: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 62
    //   99: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_2
    //   103: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 5
    //   111: new 42	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   118: aload 5
    //   120: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 64
    //   125: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_3
    //   129: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_3
    //   136: invokestatic 70	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   139: aload_3
    //   140: invokevirtual 74	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   143: astore_3
    //   144: aload_3
    //   145: invokevirtual 80	java/lang/Process:waitFor	()I
    //   148: istore_0
    //   149: new 82	java/io/BufferedReader
    //   152: dup
    //   153: new 84	java/io/InputStreamReader
    //   156: dup
    //   157: aload_3
    //   158: invokevirtual 88	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   161: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   164: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   167: astore 4
    //   169: aload_3
    //   170: astore 6
    //   172: aload 4
    //   174: astore 5
    //   176: new 42	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   183: astore 7
    //   185: aload_3
    //   186: astore 6
    //   188: aload 4
    //   190: astore 5
    //   192: aload 4
    //   194: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   197: astore 8
    //   199: aload 8
    //   201: ifnull +85 -> 286
    //   204: aload_3
    //   205: astore 6
    //   207: aload 4
    //   209: astore 5
    //   211: aload 7
    //   213: aload 8
    //   215: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 99
    //   220: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: goto -39 -> 185
    //   227: astore 7
    //   229: aload_3
    //   230: astore 6
    //   232: aload 4
    //   234: astore 5
    //   236: aload 7
    //   238: invokevirtual 102	java/lang/Throwable:printStackTrace	()V
    //   241: aload 4
    //   243: ifnull +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 105	java/io/BufferedReader:close	()V
    //   251: aload_3
    //   252: ifnull +7 -> 259
    //   255: aload_3
    //   256: invokevirtual 108	java/lang/Process:destroy	()V
    //   259: aconst_null
    //   260: areturn
    //   261: new 42	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   268: ldc 45
    //   270: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 110
    //   275: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore 5
    //   283: goto -240 -> 43
    //   286: aload_3
    //   287: astore 6
    //   289: aload 4
    //   291: astore 5
    //   293: aload 7
    //   295: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: astore 7
    //   300: iload_0
    //   301: ifeq +21 -> 322
    //   304: aload_3
    //   305: astore 6
    //   307: aload 4
    //   309: astore 5
    //   311: aload 7
    //   313: invokevirtual 115	java/lang/String:trim	()Ljava/lang/String;
    //   316: invokevirtual 118	java/lang/String:length	()I
    //   319: ifeq +46 -> 365
    //   322: aload_3
    //   323: astore 6
    //   325: aload 4
    //   327: astore 5
    //   329: aload 7
    //   331: invokevirtual 115	java/lang/String:trim	()Ljava/lang/String;
    //   334: astore 7
    //   336: aload 7
    //   338: astore 5
    //   340: aload 4
    //   342: ifnull +8 -> 350
    //   345: aload 4
    //   347: invokevirtual 105	java/io/BufferedReader:close	()V
    //   350: aload 5
    //   352: astore 4
    //   354: aload_3
    //   355: ifnull -345 -> 10
    //   358: aload_3
    //   359: invokevirtual 108	java/lang/Process:destroy	()V
    //   362: aload 5
    //   364: areturn
    //   365: aload 4
    //   367: ifnull +8 -> 375
    //   370: aload 4
    //   372: invokevirtual 105	java/io/BufferedReader:close	()V
    //   375: aload_3
    //   376: ifnull -117 -> 259
    //   379: aload_3
    //   380: invokevirtual 108	java/lang/Process:destroy	()V
    //   383: goto -124 -> 259
    //   386: astore 4
    //   388: aconst_null
    //   389: astore_3
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 5
    //   395: ifnull +8 -> 403
    //   398: aload 5
    //   400: invokevirtual 105	java/io/BufferedReader:close	()V
    //   403: aload_3
    //   404: ifnull +7 -> 411
    //   407: aload_3
    //   408: invokevirtual 108	java/lang/Process:destroy	()V
    //   411: aload 4
    //   413: athrow
    //   414: astore 4
    //   416: goto -66 -> 350
    //   419: astore 4
    //   421: goto -46 -> 375
    //   424: astore 4
    //   426: goto -175 -> 251
    //   429: astore 5
    //   431: goto -28 -> 403
    //   434: astore 4
    //   436: aconst_null
    //   437: astore 5
    //   439: goto -46 -> 393
    //   442: astore 4
    //   444: aload 6
    //   446: astore_3
    //   447: goto -54 -> 393
    //   450: astore 7
    //   452: aconst_null
    //   453: astore_3
    //   454: aconst_null
    //   455: astore 4
    //   457: goto -228 -> 229
    //   460: astore 7
    //   462: aconst_null
    //   463: astore 4
    //   465: goto -236 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramInt1	int
    //   0	468	1	paramInt2	int
    //   0	468	2	paramInt3	int
    //   0	468	3	paramString	String
    //   8	363	4	localObject1	Object
    //   386	26	4	localObject2	Object
    //   414	1	4	localException1	java.lang.Exception
    //   419	1	4	localException2	java.lang.Exception
    //   424	1	4	localException3	java.lang.Exception
    //   434	1	4	localObject3	Object
    //   442	1	4	localObject4	Object
    //   455	9	4	localObject5	Object
    //   41	358	5	localObject6	Object
    //   429	1	5	localException4	java.lang.Exception
    //   437	1	5	localObject7	Object
    //   170	275	6	str1	String
    //   183	29	7	localStringBuilder	java.lang.StringBuilder
    //   227	67	7	localThrowable1	java.lang.Throwable
    //   298	39	7	str2	String
    //   450	1	7	localThrowable2	java.lang.Throwable
    //   460	1	7	localThrowable3	java.lang.Throwable
    //   197	17	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   176	185	227	java/lang/Throwable
    //   192	199	227	java/lang/Throwable
    //   211	224	227	java/lang/Throwable
    //   293	300	227	java/lang/Throwable
    //   311	322	227	java/lang/Throwable
    //   329	336	227	java/lang/Throwable
    //   136	144	386	finally
    //   345	350	414	java/lang/Exception
    //   370	375	419	java/lang/Exception
    //   246	251	424	java/lang/Exception
    //   398	403	429	java/lang/Exception
    //   144	169	434	finally
    //   176	185	442	finally
    //   192	199	442	finally
    //   211	224	442	finally
    //   236	241	442	finally
    //   293	300	442	finally
    //   311	322	442	finally
    //   329	336	442	finally
    //   136	144	450	java/lang/Throwable
    //   144	169	460	java/lang/Throwable
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
    if ((localObject == null) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.mResult.success = false;
      this.mResult.errCode = 1;
      this.mResult.errDesc = "ping progress has exception!";
    }
    do
    {
      return;
      localObject = Pattern.compile("(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*").matcher((CharSequence)localObject);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() != 3));
    this.mResult.extra = ((Matcher)localObject).group();
    try
    {
      if (Integer.valueOf(((Matcher)localObject).group(2)).intValue() > 0)
      {
        this.mResult.success = true;
        this.mResult.appendResult(((Matcher)localObject).group());
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      this.mResult.success = false;
      this.mResult.errCode = 1;
      this.mResult.errDesc = localNumberFormatException.toString();
      return;
    }
    this.mResult.success = false;
    this.mResult.errCode = 2;
    this.mResult.errDesc = localNumberFormatException.group();
  }
  
  public String getProbeName()
  {
    return PROBE_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.PingProbe
 * JD-Core Version:    0.7.0.1
 */