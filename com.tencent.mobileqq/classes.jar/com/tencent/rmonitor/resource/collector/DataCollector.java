package com.tencent.rmonitor.resource.collector;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.resource.JvmTiProxy;
import com.tencent.rmonitor.resource.meta.GcInfo;
import com.tencent.rmonitor.resource.meta.NetFlow;
import com.tencent.rmonitor.resource.meta.StatInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCollector
{
  private NetworkCollector a = new NetworkCollector();
  private StatCollector b = new StatCollector();
  private int c = 0;
  
  public DataCollector()
  {
    c();
  }
  
  private ArrayList<Double> a(String paramString)
  {
    Pattern localPattern1 = Pattern.compile("(\\d+)%user\\s+(\\d+)%nice\\s+(\\d+)%sys");
    Pattern localPattern2 = Pattern.compile(ResourceCollectorConstant.a);
    String[] arrayOfString = paramString.split("\n");
    int j = arrayOfString.length;
    Object localObject7 = "0";
    paramString = (String)localObject7;
    Object localObject1 = paramString;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    int i = 0;
    Object localObject5 = paramString;
    while (i < j)
    {
      String str2 = arrayOfString[i].trim();
      int k = str2.indexOf("%cpu");
      Object localObject6 = localObject5;
      Object localObject4 = localObject1;
      paramString = (String)localObject2;
      if (k != -1)
      {
        String str1 = str2.substring(0, k);
        Matcher localMatcher = localPattern1.matcher(str2);
        localObject7 = str1;
        localObject6 = localObject5;
        localObject4 = localObject1;
        paramString = (String)localObject2;
        if (localMatcher.find())
        {
          localObject7 = str1;
          localObject6 = localObject5;
          localObject4 = localObject1;
          paramString = (String)localObject2;
          if (localMatcher.groupCount() == 3)
          {
            localObject6 = localMatcher.group(1);
            localObject4 = localMatcher.group(2);
            paramString = localMatcher.group(3);
            localObject7 = str1;
          }
        }
      }
      if (localPattern2.matcher(str2).find()) {
        localObject3 = str2.split("\\s+")[8];
      }
      i += 1;
      localObject5 = localObject6;
      localObject1 = localObject4;
      localObject2 = paramString;
    }
    i = Integer.parseInt((String)localObject7);
    double d1 = 0.0D;
    double d2;
    if (i != 0)
    {
      d2 = Double.parseDouble((String)localObject7);
      d1 = (Double.parseDouble((String)localObject5) + Double.parseDouble((String)localObject1) + Double.parseDouble((String)localObject2)) / d2;
      d2 = Double.parseDouble((String)localObject3) / d2;
    }
    else
    {
      d2 = 0.0D;
    }
    return new ArrayList(Arrays.asList(new Double[] { Double.valueOf(d1), Double.valueOf(d2) }));
  }
  
  private void c()
  {
    try
    {
      Application localApplication = BaseInfo.app;
      if ((this.c == 0) && (localApplication != null))
      {
        this.c = localApplication.getPackageManager().getApplicationInfo(localApplication.getPackageName(), 0).uid;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localThrowable);
    }
  }
  
  @NonNull
  public NetFlow a(boolean paramBoolean)
  {
    NetFlow localNetFlow = new NetFlow();
    c();
    if (this.c == 0) {
      return localNetFlow;
    }
    try
    {
      long[] arrayOfLong = this.a.a();
      if (arrayOfLong != null)
      {
        localNetFlow.rxBytes = arrayOfLong[0];
        localNetFlow.rxPackets = arrayOfLong[1];
        localNetFlow.txBytes = arrayOfLong[2];
        localNetFlow.txPackets = arrayOfLong[3];
        return localNetFlow;
      }
      if (paramBoolean)
      {
        localNetFlow.rxBytes = TrafficStats.getUidRxBytes(this.c);
        localNetFlow.rxPackets = TrafficStats.getUidRxPackets(this.c);
        localNetFlow.txBytes = TrafficStats.getUidTxBytes(this.c);
        localNetFlow.txPackets = TrafficStats.getUidTxPackets(this.c);
        return localNetFlow;
      }
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localException);
    }
    return localNetFlow;
  }
  
  @NonNull
  public StatInfo a()
  {
    StatInfo localStatInfo = new StatInfo();
    try
    {
      long[] arrayOfLong = this.b.a();
      if (arrayOfLong != null)
      {
        localStatInfo.cpuSysJiffies = arrayOfLong[0];
        localStatInfo.cpuSysUsedJiffies = arrayOfLong[1];
        localStatInfo.cpuJiffies = arrayOfLong[2];
        localStatInfo.threadNum = arrayOfLong[3];
        localStatInfo.memory = arrayOfLong[4];
        return localStatInfo;
      }
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localException);
    }
    return localStatInfo;
  }
  
  public ArrayList<Double> a(int paramInt)
  {
    Object localObject6 = null;
    Object localObject5;
    try
    {
      Object localObject7 = Runtime.getRuntime().exec(String.format("top -p %d -n 1", new Object[] { Integer.valueOf(paramInt) }));
      boolean bool;
      if (AndroidVersion.e())
      {
        bool = ((Process)localObject7).waitFor(600L, TimeUnit.MILLISECONDS);
      }
      else
      {
        ((Process)localObject7).waitFor();
        bool = true;
      }
      Object localObject1 = localObject6;
      if (bool)
      {
        localObject1 = ((Process)localObject7).getInputStream();
        localObject7 = FileUtil.a((InputStream)localObject1, 1024);
        ((InputStream)localObject1).close();
        localObject1 = a((String)localObject7);
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localThrowable);
      Object localObject2 = localObject6;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localNumberFormatException);
      Object localObject3 = localObject6;
    }
    catch (IOException localIOException)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localIOException);
      Object localObject4 = localObject6;
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.b.a("RMonitor_resource_DataCollector", localInterruptedException);
      localObject5 = localObject6;
    }
    localObject6 = localObject5;
    if (localObject5 == null) {
      localObject6 = new ArrayList(Arrays.asList(new Double[] { Double.valueOf(0.0D), Double.valueOf(0.0D) }));
    }
    return localObject6;
  }
  
  public GcInfo b()
  {
    long[] arrayOfLong = JvmTiProxy.a().getGcInfo();
    GcInfo localGcInfo = new GcInfo();
    int j = arrayOfLong.length;
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      l += arrayOfLong[i];
      i += 1;
    }
    localGcInfo.gcDuration = l;
    localGcInfo.gcTimes = arrayOfLong.length;
    return localGcInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.DataCollector
 * JD-Core Version:    0.7.0.1
 */