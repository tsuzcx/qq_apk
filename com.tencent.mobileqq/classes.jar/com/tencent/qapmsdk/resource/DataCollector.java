package com.tencent.qapmsdk.resource;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.resource.NetworkCollector;
import com.tencent.qapmsdk.common.resource.StatCollector;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.resource.meta.NetFlow;
import com.tencent.qapmsdk.resource.meta.StatInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataCollector
{
  private static final String TAG = "QAPM_resource_DataCollector";
  private NetworkCollector networkCollector = new NetworkCollector();
  private StatCollector statCollector = new StatCollector();
  private int uid = 0;
  
  DataCollector()
  {
    initUid();
  }
  
  private void initUid()
  {
    try
    {
      if ((this.uid == 0) && (BaseInfo.app != null))
      {
        this.uid = BaseInfo.app.getPackageManager().getApplicationInfo(BaseInfo.app.getPackageName(), 0).uid;
        return;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_resource_DataCollector", localException);
    }
  }
  
  ArrayList<Double> collectAppCpuByTop(int paramInt)
  {
    double d1 = 0.0D;
    for (;;)
    {
      Object localObject5;
      Object localObject6;
      Object localObject7;
      try
      {
        Process localProcess = Runtime.getRuntime().exec(String.format("top -p %d -n 1", new Object[] { Integer.valueOf(paramInt) }));
        boolean bool = AndroidVersion.isO();
        double d4;
        if (bool)
        {
          d2 = d1;
          d3 = d1;
          d4 = d1;
          try
          {
            bool = localProcess.waitFor(600L, TimeUnit.MILLISECONDS);
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            d1 = d2;
            continue;
          }
          catch (IOException localIOException1)
          {
            d1 = d3;
            continue;
          }
          catch (InterruptedException localInterruptedException1)
          {
            d1 = d4;
            continue;
          }
        }
        else
        {
          localInterruptedException1.waitFor();
          bool = true;
        }
        if (!bool)
        {
          d2 = d1;
          d3 = d1;
          d4 = d1;
          localObject1 = new ArrayList(Arrays.asList(new Double[] { Double.valueOf(0.0D), Double.valueOf(0.0D) }));
          return localObject1;
        }
        localObject3 = ((Process)localObject1).getInputStream();
        Object localObject1 = FileUtil.readStream((InputStream)localObject3, 1024);
        ((InputStream)localObject3).close();
        Pattern localPattern1 = Pattern.compile("(\\d+)%user\\s+(\\d+)%nice\\s+(\\d+)%sys");
        Pattern localPattern2 = Pattern.compile(ResourceCollectorConstant.PID_REG);
        String[] arrayOfString = ((String)localObject1).split("\n");
        int i = arrayOfString.length;
        String str1 = "0";
        localObject4 = str1;
        localObject3 = localObject4;
        localObject1 = localObject3;
        Object localObject8 = localObject1;
        paramInt = 0;
        if (paramInt < i)
        {
          String str2 = arrayOfString[paramInt].trim();
          int j = str2.indexOf("%cpu");
          localObject5 = localObject4;
          localObject6 = localObject3;
          localObject7 = localObject1;
          if (j != -1)
          {
            str1 = str2.substring(0, j);
            Matcher localMatcher = localPattern1.matcher(str2);
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject7 = localObject1;
            if (!localMatcher.find()) {
              break label582;
            }
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject7 = localObject1;
            if (localMatcher.groupCount() != 3) {
              break label582;
            }
            localObject5 = localMatcher.group(1);
            localObject6 = localMatcher.group(2);
            localObject7 = localMatcher.group(3);
            break label582;
          }
          if (!localPattern2.matcher(str2).find()) {
            break label585;
          }
          localObject8 = str2.split("\\s+")[8];
          break label585;
        }
        if (Integer.valueOf(str1).intValue() != 0)
        {
          d1 = Double.valueOf((String)localObject4).doubleValue();
          d2 = Double.valueOf((String)localObject3).doubleValue();
          d3 = Double.valueOf((String)localObject1).doubleValue();
          d4 = Double.valueOf(str1).doubleValue();
          d1 = (d1 + d2 + d3) / d4;
          d2 = d1;
          d3 = d1;
          d4 = d1;
          double d5 = Double.valueOf((String)localObject8).doubleValue();
          d2 = d1;
          d3 = d1;
          d4 = d1;
          double d6 = Double.valueOf(str1).doubleValue();
          d3 = d5 / d6;
          d2 = d1;
          d1 = d3;
        }
        else
        {
          d1 = 0.0D;
          d2 = 0.0D;
        }
        d3 = d1;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        d1 = 0.0D;
        Logger.INSTANCE.exception("QAPM_resource_DataCollector", localNumberFormatException2);
      }
      catch (IOException localIOException2)
      {
        d1 = 0.0D;
        Logger.INSTANCE.exception("QAPM_resource_DataCollector", localIOException2);
      }
      catch (InterruptedException localInterruptedException2)
      {
        d1 = 0.0D;
        Logger.INSTANCE.exception("QAPM_resource_DataCollector", localInterruptedException2);
      }
      double d3 = 0.0D;
      double d2 = d1;
      return new ArrayList(Arrays.asList(new Double[] { Double.valueOf(d2), Double.valueOf(d3) }));
      label582:
      continue;
      label585:
      paramInt += 1;
      Object localObject4 = localObject5;
      Object localObject3 = localObject6;
      Object localObject2 = localObject7;
    }
  }
  
  @NonNull
  StatInfo collectStatInfo()
  {
    StatInfo localStatInfo = new StatInfo();
    try
    {
      long[] arrayOfLong = this.statCollector.getStatInfo();
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
      Logger.INSTANCE.exception("QAPM_resource_DataCollector", localException);
    }
    return localStatInfo;
  }
  
  long collectorCpuJiffices(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = 9223372036854775807L;
    }
    return paramLong1;
  }
  
  @NonNull
  NetFlow collectorNetFollow(boolean paramBoolean)
  {
    NetFlow localNetFlow = new NetFlow();
    initUid();
    if (this.uid == 0) {
      return localNetFlow;
    }
    try
    {
      long[] arrayOfLong = this.networkCollector.getTotalBytes();
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
        localNetFlow.rxBytes = TrafficStats.getUidRxBytes(this.uid);
        localNetFlow.rxPackets = TrafficStats.getUidRxPackets(this.uid);
        localNetFlow.txBytes = TrafficStats.getUidTxBytes(this.uid);
        localNetFlow.txPackets = TrafficStats.getUidTxPackets(this.uid);
        return localNetFlow;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_resource_DataCollector", localException);
    }
    return localNetFlow;
  }
  
  long collectorSysCpuJiffices(String[] paramArrayOfString)
  {
    long l2 = Long.parseLong(paramArrayOfString[2]) + Long.parseLong(paramArrayOfString[3]) + Long.parseLong(paramArrayOfString[4]) + Long.parseLong(paramArrayOfString[5]) + Long.parseLong(paramArrayOfString[6]) + Long.parseLong(paramArrayOfString[7]) + Long.parseLong(paramArrayOfString[8]);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 9223372036854775807L;
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.DataCollector
 * JD-Core Version:    0.7.0.1
 */