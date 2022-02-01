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
  private String mIp = null;
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
    if (paramString.contains("ping")) {
      return paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return "";
  }
  
  private String parseRespIp(String paramString)
  {
    int i = paramString.indexOf("from");
    if (i >= 0)
    {
      i += 5;
      int j = paramString.indexOf(" ", i);
      if (j > 0)
      {
        paramString = paramString.substring(i, j);
        break label40;
      }
    }
    paramString = "*";
    label40:
    String str = paramString.trim();
    paramString = str;
    if (str.endsWith(":")) {
      paramString = str.substring(0, str.length() - 1).trim();
    }
    str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*";
    }
    return str;
  }
  
  /* Error */
  private String pingNode(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 31
    //   2: astore 4
    //   4: invokestatic 104	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7: astore_3
    //   8: new 106	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc 109
    //   21: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: aload_0
    //   28: getfield 39	com/tencent/mobileqq/highway/netprobe/TracerouteProbe:mTimeout	I
    //   31: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 5
    //   37: ldc 118
    //   39: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: iload_2
    //   46: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: ldc 76
    //   54: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 5
    //   60: aload_1
    //   61: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: aload 5
    //   68: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 125	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   74: astore 5
    //   76: aload 4
    //   78: astore_3
    //   79: new 127	java/io/BufferedReader
    //   82: dup
    //   83: new 129	java/io/InputStreamReader
    //   86: dup
    //   87: aload 5
    //   89: invokevirtual 135	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   92: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   95: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore 6
    //   100: aload 4
    //   102: astore_3
    //   103: new 56	java/lang/String
    //   106: dup
    //   107: invokespecial 142	java/lang/String:<init>	()V
    //   110: pop
    //   111: aload 4
    //   113: astore_1
    //   114: aload_1
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 145	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore 4
    //   123: aload 4
    //   125: ifnull +44 -> 169
    //   128: aload_1
    //   129: astore_3
    //   130: new 106	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload_1
    //   140: astore_3
    //   141: aload 7
    //   143: aload_1
    //   144: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: astore_3
    //   150: aload 7
    //   152: aload 4
    //   154: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: astore_3
    //   160: aload 7
    //   162: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: goto -52 -> 114
    //   169: aload_1
    //   170: astore 4
    //   172: aload 5
    //   174: invokevirtual 148	java/lang/Process:destroy	()V
    //   177: goto +33 -> 210
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   185: aload 4
    //   187: astore_1
    //   188: goto +22 -> 210
    //   191: astore_1
    //   192: goto +23 -> 215
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   200: aload_3
    //   201: astore 4
    //   203: aload 5
    //   205: invokevirtual 148	java/lang/Process:destroy	()V
    //   208: aload_3
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 154	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   214: areturn
    //   215: aload 5
    //   217: invokevirtual 148	java/lang/Process:destroy	()V
    //   220: goto +8 -> 228
    //   223: astore_3
    //   224: aload_3
    //   225: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   228: goto +5 -> 233
    //   231: aload_1
    //   232: athrow
    //   233: goto -2 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	TracerouteProbe
    //   0	236	1	paramString	String
    //   0	236	2	paramInt	int
    //   7	202	3	localObject1	Object
    //   223	2	3	localException	Exception
    //   2	200	4	localObject2	Object
    //   15	201	5	localObject3	Object
    //   98	19	6	localBufferedReader	java.io.BufferedReader
    //   137	24	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   172	177	180	java/lang/Exception
    //   203	208	180	java/lang/Exception
    //   79	100	191	finally
    //   103	111	191	finally
    //   116	123	191	finally
    //   130	139	191	finally
    //   141	148	191	finally
    //   150	158	191	finally
    //   160	166	191	finally
    //   196	200	191	finally
    //   79	100	195	java/lang/Exception
    //   103	111	195	java/lang/Exception
    //   116	123	195	java/lang/Exception
    //   130	139	195	java/lang/Exception
    //   141	148	195	java/lang/Exception
    //   150	158	195	java/lang/Exception
    //   160	166	195	java/lang/Exception
    //   215	220	223	java/lang/Exception
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
    TracerouteProbe.TraceroutCallback localTraceroutCallback = this.cb;
    if (localTraceroutCallback != null) {
      localTraceroutCallback.progress(paramString);
    }
  }
  
  public void process()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Traceroute to ");
    ((StringBuilder)localObject1).append(this.mHost);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(this.mMaxTTL);
    ((StringBuilder)localObject1).append(" hops max, ");
    ((StringBuilder)localObject1).append(this.mTimeout);
    ((StringBuilder)localObject1).append("s timeout");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("\n");
    logProgress(((StringBuilder)localObject2).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("\n");
    this.mResult.success = false;
    localObject1 = "";
    int i = 0;
    localObject2 = localObject1;
    Object localObject3;
    if (i <= this.mMaxTTL)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        localObject2 = pingNode(getDestation(), i);
        long l2 = SystemClock.elapsedRealtime();
        localObject4 = parseDestIp((String)localObject2);
        if ((TextUtils.isEmpty(this.mIp)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
          this.mIp = ((String)localObject4);
        }
        localObject4 = parseRespIp((String)localObject2);
        if (!"*".equals(localObject4))
        {
          localObject2 = String.format("(%d) %s %5dms\n", new Object[] { Integer.valueOf(i), localObject4, Long.valueOf(l2 - l1) }).toString();
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = String.format("(%d) %s \n", new Object[] { Integer.valueOf(i), localObject4 }).toString();
        }
        try
        {
          logProgress((String)localObject2);
          localStringBuilder.append((String)localObject2);
          if (!this.mHost.equals(localObject4)) {
            if (!this.mIp.equals(localObject4)) {
              break label669;
            }
          }
          this.mResult.success = true;
          localObject2 = localObject1;
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2) {}
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("traceroute error: ");
      ((StringBuilder)localObject4).append(localException2.getMessage());
      localObject3 = ((StringBuilder)localObject4).toString();
      this.mResult.errDesc = ((String)localObject3);
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("\n");
    }
    label669:
    for (;;)
    {
      i += 1;
      break;
      if (this.mResult.success)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Traceroute succ host: ");
        ((StringBuilder)localObject1).append(this.mHost);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(this.mIp);
        ((StringBuilder)localObject1).append(") hops: ");
        ((StringBuilder)localObject1).append(i);
        localObject1 = ((StringBuilder)localObject1).toString();
        this.mResult.appendResult((String)localObject1);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Traceroute fail host: ");
        ((StringBuilder)localObject1).append(this.mHost);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(this.mIp);
        ((StringBuilder)localObject1).append(") hops: ");
        ((StringBuilder)localObject1).append(this.mMaxTTL);
        localObject1 = ((StringBuilder)localObject1).toString();
        this.mResult.errDesc = ((String)localObject3);
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("\n");
      logProgress(((StringBuilder)localObject3).toString());
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\n");
      this.mResult.extra = localStringBuilder.toString();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.TracerouteProbe
 * JD-Core Version:    0.7.0.1
 */