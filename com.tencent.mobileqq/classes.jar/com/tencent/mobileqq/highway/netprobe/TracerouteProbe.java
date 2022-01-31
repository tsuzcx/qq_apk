package com.tencent.mobileqq.highway.netprobe;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;

@SuppressLint({"DefaultLocale"})
public class TracerouteProbe
  extends ProbeItem
{
  public static final int DEFAULT_MAX_TTL = 30;
  public static final String PROBE_NAME = "Traceroute_Probe";
  private TracerouteProbe.TraceroutCallback cb;
  private String mHost = "";
  private String mIp;
  private int mMaxTTL = 30;
  private int mTimeout = 10;
  
  public TracerouteProbe()
  {
    this(30, null);
  }
  
  public TracerouteProbe(int paramInt)
  {
    this(paramInt, null);
  }
  
  public TracerouteProbe(int paramInt, TracerouteProbe.TraceroutCallback paramTraceroutCallback)
  {
    this.mMaxTTL = paramInt;
    this.cb = paramTraceroutCallback;
  }
  
  public TracerouteProbe(TracerouteProbe.TraceroutCallback paramTraceroutCallback)
  {
    this(30, paramTraceroutCallback);
  }
  
  private String getDestation()
  {
    if (TextUtils.isEmpty(this.mIp)) {
      return this.mHost;
    }
    return this.mIp;
  }
  
  private String parseDestIp(String paramString)
  {
    String str = "";
    if (paramString.contains("ping")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  private String parseRespIp(String paramString)
  {
    String str2 = "*";
    int i = paramString.indexOf("from");
    String str1 = str2;
    if (i >= 0)
    {
      int j = paramString.indexOf(" ", i + 5);
      str1 = str2;
      if (j > 0) {
        str1 = paramString.substring(i + 5, j);
      }
    }
    str1 = str1.trim();
    paramString = str1;
    if (str1.endsWith(":")) {
      paramString = str1.substring(0, str1.length() - 1).trim();
    }
    str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "*";
    }
    return str1;
  }
  
  /* Error */
  private String pingNode(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 104	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 106	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   10: ldc 109
    //   12: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 37	com/tencent/mobileqq/highway/netprobe/TracerouteProbe:mTimeout	I
    //   19: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 118
    //   24: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 78
    //   33: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 125	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   46: astore 4
    //   48: new 127	java/io/BufferedReader
    //   51: dup
    //   52: new 129	java/io/InputStreamReader
    //   55: dup
    //   56: aload 4
    //   58: invokevirtual 135	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   61: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   64: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore 5
    //   69: new 56	java/lang/String
    //   72: dup
    //   73: invokespecial 142	java/lang/String:<init>	()V
    //   76: pop
    //   77: ldc 31
    //   79: astore_1
    //   80: aload 5
    //   82: invokevirtual 145	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +27 -> 114
    //   90: new 106	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   97: aload_1
    //   98: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_3
    //   102: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore_3
    //   109: aload_3
    //   110: astore_1
    //   111: goto -31 -> 80
    //   114: aload 4
    //   116: invokevirtual 148	java/lang/Process:destroy	()V
    //   119: aload_1
    //   120: invokevirtual 151	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   123: areturn
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   129: goto -10 -> 119
    //   132: astore_3
    //   133: ldc 31
    //   135: astore_1
    //   136: aload_3
    //   137: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   140: aload 4
    //   142: invokevirtual 148	java/lang/Process:destroy	()V
    //   145: goto -26 -> 119
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   153: goto -34 -> 119
    //   156: astore_1
    //   157: aload 4
    //   159: invokevirtual 148	java/lang/Process:destroy	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_3
    //   165: aload_3
    //   166: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   169: goto -7 -> 162
    //   172: astore_3
    //   173: goto -37 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	TracerouteProbe
    //   0	176	1	paramString	String
    //   0	176	2	paramInt	int
    //   85	25	3	str	String
    //   124	2	3	localException1	Exception
    //   132	5	3	localException2	Exception
    //   148	2	3	localException3	Exception
    //   164	2	3	localException4	Exception
    //   172	1	3	localException5	Exception
    //   46	112	4	localProcess	java.lang.Process
    //   67	14	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   114	119	124	java/lang/Exception
    //   48	77	132	java/lang/Exception
    //   140	145	148	java/lang/Exception
    //   48	77	156	finally
    //   80	86	156	finally
    //   90	109	156	finally
    //   136	140	156	finally
    //   157	162	164	java/lang/Exception
    //   80	86	172	java/lang/Exception
    //   90	109	172	java/lang/Exception
  }
  
  public void doProbe()
  {
    this.mHost = this.mRequest.getIp();
    process();
  }
  
  public String getProbeName()
  {
    return "Traceroute_Probe";
  }
  
  public void logProgress(String paramString)
  {
    if (this.cb != null) {
      this.cb.progress(paramString);
    }
  }
  
  public void process()
  {
    String str1 = "Traceroute to " + this.mHost + ", " + this.mMaxTTL + " hops max, " + this.mTimeout + "s timeout";
    logProgress(str1 + "\n");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1).append("\n");
    this.mResult.success = false;
    str1 = "";
    int i = 0;
    String str2 = str1;
    if (i <= this.mMaxTTL) {
      str2 = str1;
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        str2 = str1;
        str3 = pingNode(getDestation(), i);
        str2 = str1;
        long l2 = SystemClock.elapsedRealtime();
        str2 = str1;
        String str4 = parseDestIp(str3);
        str2 = str1;
        if (TextUtils.isEmpty(this.mIp))
        {
          str2 = str1;
          if (!TextUtils.isEmpty(str4))
          {
            str2 = str1;
            this.mIp = str4;
          }
        }
        str2 = str1;
        str4 = parseRespIp(str3);
        str2 = str1;
        if (!"*".equals(str4))
        {
          str2 = str1;
          str1 = String.format("(%d) %s %5dms\n", new Object[] { Integer.valueOf(i), str4, Long.valueOf(l2 - l1) }).toString();
          str3 = str1;
          str2 = str1;
          logProgress(str3);
          str2 = str1;
          localStringBuilder.append(str3);
          str2 = str1;
          if (!this.mHost.equals(str4))
          {
            str2 = str1;
            str3 = str1;
            if (!this.mIp.equals(str4)) {}
          }
          else
          {
            str2 = str1;
            this.mResult.success = true;
            str2 = str1;
            if (!this.mResult.success) {
              break label566;
            }
            str1 = "Traceroute succ host: " + this.mHost + "(" + this.mIp + ") hops: " + i;
            this.mResult.appendResult(str1);
            logProgress(str1 + "\n");
            localStringBuilder.append(str1).append("\n");
            this.mResult.extra = localStringBuilder.toString();
          }
        }
        else
        {
          str2 = str1;
          str3 = String.format("(%d) %s \n", new Object[] { Integer.valueOf(i), str4 }).toString();
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = "traceroute error: " + localException.getMessage();
        this.mResult.errDesc = ((String)localObject);
        localStringBuilder.append((String)localObject).append("\n");
        String str3 = str2;
        i += 1;
        localObject = str3;
      }
      label566:
      Object localObject = "Traceroute fail host: " + this.mHost + "(" + this.mIp + ") hops: " + this.mMaxTTL;
      this.mResult.errDesc = str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.TracerouteProbe
 * JD-Core Version:    0.7.0.1
 */