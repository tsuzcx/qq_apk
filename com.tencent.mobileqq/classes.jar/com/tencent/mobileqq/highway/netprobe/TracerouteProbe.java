package com.tencent.mobileqq.highway.netprobe;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SuppressLint({"DefaultLocale"})
public class TracerouteProbe
  extends ProbeItem
{
  public static final int DEFAULT_MAX_TTL = 30;
  public static final String PROBE_NAME = "Traceroute_Probe";
  private TraceroutCallback cb;
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
  
  public TracerouteProbe(int paramInt, TraceroutCallback paramTraceroutCallback)
  {
    this.mMaxTTL = paramInt;
    this.cb = paramTraceroutCallback;
  }
  
  public TracerouteProbe(TraceroutCallback paramTraceroutCallback)
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
  
  private String pingNode(String paramString, int paramInt)
    throws Exception
  {
    String str2 = "";
    Process localProcess = Runtime.getRuntime().exec("/system/bin/ping -c 1 -w " + this.mTimeout + " -t " + paramInt + " " + paramString);
    String str1 = str2;
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
        str1 = str2;
        new String();
        paramString = str2;
        str1 = paramString;
        str2 = localBufferedReader.readLine();
        if (str2 != null)
        {
          str1 = paramString;
          paramString = paramString + str2;
          continue;
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        paramString.printStackTrace();
        try
        {
          localProcess.destroy();
          paramString = localException1;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = localException1;
        }
        continue;
      }
      finally {}
      try
      {
        localProcess.destroy();
        return paramString.toLowerCase();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    try
    {
      localProcess.destroy();
      throw paramString;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
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
    Object localObject3 = "Traceroute to " + this.mHost + ", " + this.mMaxTTL + " hops max, " + this.mTimeout + "s timeout";
    Object localObject1 = "";
    logProgress((String)localObject3 + "\n");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject3).append("\n");
    this.mResult.success = false;
    int i = 0;
    localObject3 = localObject1;
    if (i <= this.mMaxTTL) {
      localObject3 = localObject1;
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        localObject3 = localObject1;
        localObject4 = pingNode(getDestation(), i);
        localObject3 = localObject1;
        long l2 = SystemClock.elapsedRealtime();
        localObject3 = localObject1;
        String str = parseDestIp((String)localObject4);
        localObject3 = localObject1;
        if (TextUtils.isEmpty(this.mIp))
        {
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(str))
          {
            localObject3 = localObject1;
            this.mIp = str;
          }
        }
        localObject3 = localObject1;
        str = parseRespIp((String)localObject4);
        localObject3 = localObject1;
        if (!"*".equals(str))
        {
          localObject3 = localObject1;
          localObject4 = String.format("(%d) %s %5dms\n", new Object[] { Integer.valueOf(i), str, Long.valueOf(l2 - l1) }).toString();
          localObject1 = localObject4;
          localObject3 = localObject1;
          logProgress((String)localObject4);
          localObject3 = localObject1;
          localStringBuilder.append((String)localObject4);
          localObject3 = localObject1;
          if (!this.mHost.equals(str))
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            if (!this.mIp.equals(str)) {}
          }
          else
          {
            localObject3 = localObject1;
            this.mResult.success = true;
            localObject3 = localObject1;
            if (!this.mResult.success) {
              break label566;
            }
            localObject1 = "Traceroute succ host: " + this.mHost + "(" + this.mIp + ") hops: " + i;
            this.mResult.appendResult((String)localObject1);
            logProgress((String)localObject1 + "\n");
            localStringBuilder.append((String)localObject1).append("\n");
            this.mResult.extra = localStringBuilder.toString();
          }
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = String.format("(%d) %s \n", new Object[] { Integer.valueOf(i), str }).toString();
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = "traceroute error: " + localException.getMessage();
        this.mResult.errDesc = ((String)localObject2);
        localStringBuilder.append((String)localObject2).append("\n");
        Object localObject4 = localObject3;
        i += 1;
        localObject2 = localObject4;
      }
      label566:
      Object localObject2 = "Traceroute fail host: " + this.mHost + "(" + this.mIp + ") hops: " + this.mMaxTTL;
      this.mResult.errDesc = ((String)localObject3);
    }
  }
  
  static abstract interface TraceroutCallback
  {
    public abstract void progress(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.TracerouteProbe
 * JD-Core Version:    0.7.0.1
 */