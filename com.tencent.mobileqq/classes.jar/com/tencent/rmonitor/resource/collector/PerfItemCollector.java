package com.tencent.rmonitor.resource.collector;

import android.os.Handler;
import android.os.Process;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.device.device.DeviceMemory;
import com.tencent.rmonitor.resource.JvmTiProxy;
import com.tencent.rmonitor.resource.RunTimeEnv;
import com.tencent.rmonitor.resource.meta.GcInfo;
import com.tencent.rmonitor.resource.meta.NetFlow;
import com.tencent.rmonitor.resource.meta.PerfItem;
import com.tencent.rmonitor.resource.meta.StatInfo;
import com.tencent.rmonitor.resource.reflect.ReflectIoModule;
import java.util.ArrayList;
import java.util.Vector;

public class PerfItemCollector
  implements IPerfItemCollector, Runnable
{
  private static final int a = ;
  private static final long b = DeviceMemory.a(0L);
  private final Vector<PerfItem> c = new Vector(900);
  private final Vector<PerfItem> d = new Vector(60);
  private final ReflectIoModule e;
  private final DataCollector f;
  private final Handler g;
  private IPerfItemCollectorListener h;
  private volatile PerfItem i = null;
  private boolean j = false;
  
  public PerfItemCollector(ReflectIoModule paramReflectIoModule, DataCollector paramDataCollector)
  {
    this.e = paramReflectIoModule;
    this.f = paramDataCollector;
    this.g = new Handler(ThreadManager.e());
  }
  
  private void a(@NonNull PerfItem paramPerfItem)
  {
    IPerfItemCollectorListener localIPerfItemCollectorListener = this.h;
    if (localIPerfItemCollectorListener != null) {
      localIPerfItemCollectorListener.a(paramPerfItem);
    }
    double d1 = System.currentTimeMillis();
    Double.isNaN(d1);
    paramPerfItem.eventTime = (d1 / 1000.0D);
    c(paramPerfItem);
    if ((this.i != null) && (paramPerfItem.eventTime - this.i.eventTime < 5.0D))
    {
      this.i.eventTime = paramPerfItem.eventTime;
      d(paramPerfItem);
      if (!RunTimeEnv.a())
      {
        g(paramPerfItem);
        f(paramPerfItem);
        e(paramPerfItem);
      }
    }
    else
    {
      b(paramPerfItem);
    }
    localIPerfItemCollectorListener = this.h;
    if (localIPerfItemCollectorListener != null) {
      localIPerfItemCollectorListener.b(paramPerfItem);
    }
  }
  
  private void b(@NonNull PerfItem paramPerfItem)
  {
    this.i = new PerfItem();
    this.i.eventTime = paramPerfItem.eventTime;
    this.i.cpuJiffies = paramPerfItem.cpuJiffies;
    this.i.cpuSysJiffies = paramPerfItem.cpuSysJiffies;
    this.i.cpuSysUsedJiffies = paramPerfItem.cpuSysUsedJiffies;
    this.i.ioCount = 0L;
    this.i.ioBytes = 0L;
    paramPerfItem.cpuRate = 0.0D;
    paramPerfItem.sysCpuRate = 0.0D;
    paramPerfItem.netFlowPackets = 0L;
    paramPerfItem.netFlowReceiverBytes = 0L;
    paramPerfItem.netFlowSendBytes = 0L;
    paramPerfItem.ioCount = 0L;
    paramPerfItem.ioBytes = 0L;
    paramPerfItem.fps = 0L;
  }
  
  private void c(@NonNull PerfItem paramPerfItem)
  {
    StatInfo localStatInfo = this.f.a();
    long l1 = localStatInfo.cpuJiffies;
    long l2 = 9223372036854775807L;
    if (l1 > 0L) {
      l1 = localStatInfo.cpuJiffies;
    } else {
      l1 = 9223372036854775807L;
    }
    paramPerfItem.cpuJiffies = l1;
    if (localStatInfo.cpuSysJiffies > 0L) {
      l1 = localStatInfo.cpuSysJiffies;
    } else {
      l1 = 9223372036854775807L;
    }
    paramPerfItem.cpuSysJiffies = l1;
    if (localStatInfo.cpuSysUsedJiffies > 0L) {
      l1 = localStatInfo.cpuSysUsedJiffies;
    } else {
      l1 = 9223372036854775807L;
    }
    paramPerfItem.cpuSysUsedJiffies = l1;
    l1 = l2;
    if (b != 0L)
    {
      l1 = l2;
      if (localStatInfo.memory != 9223372036854775807L) {
        l1 = localStatInfo.memory * b;
      }
    }
    paramPerfItem.memory = l1;
    paramPerfItem.thread = localStatInfo.threadNum;
    paramPerfItem.temperature = TemperatureCollector.a();
  }
  
  private void d(@NonNull PerfItem paramPerfItem)
  {
    if (this.i != null)
    {
      if ((this.i.cpuJiffies != 9223372036854775807L) && (this.i.cpuSysJiffies != 9223372036854775807L) && (this.i.cpuSysUsedJiffies != 9223372036854775807L))
      {
        long l1 = paramPerfItem.cpuJiffies;
        long l2 = this.i.cpuJiffies;
        long l3 = paramPerfItem.cpuSysJiffies - this.i.cpuSysJiffies;
        long l4 = paramPerfItem.cpuSysUsedJiffies;
        long l5 = this.i.cpuSysUsedJiffies;
        if (l3 > 0L)
        {
          d2 = l1 - l2;
          Double.isNaN(d2);
          d1 = l3;
          Double.isNaN(d1);
          paramPerfItem.cpuRate = (d2 * 1.0D / d1);
          d2 = l4 - l5;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramPerfItem.sysCpuRate = (d2 * 1.0D / d1);
        }
        double d1 = paramPerfItem.cpuRate;
        double d2 = 0.0D;
        if (d1 > 0.0D) {
          d1 = paramPerfItem.cpuRate;
        } else {
          d1 = 0.0D;
        }
        paramPerfItem.cpuRate = d1;
        d1 = d2;
        if (paramPerfItem.sysCpuRate > 0.0D) {
          d1 = paramPerfItem.sysCpuRate;
        }
        paramPerfItem.sysCpuRate = d1;
      }
      else
      {
        ArrayList localArrayList = this.f.a(a);
        paramPerfItem.sysCpuRate = ((Double)localArrayList.get(0)).doubleValue();
        paramPerfItem.cpuRate = ((Double)localArrayList.get(1)).doubleValue();
      }
      this.i.cpuJiffies = paramPerfItem.cpuJiffies;
      this.i.cpuSysJiffies = paramPerfItem.cpuSysJiffies;
      this.i.cpuSysUsedJiffies = paramPerfItem.cpuSysUsedJiffies;
    }
  }
  
  private void e(@NonNull PerfItem paramPerfItem)
  {
    if ((this.i != null) && (JvmTiProxy.a().canUseJvmTi()))
    {
      GcInfo localGcInfo = this.f.b();
      paramPerfItem.gcCount = localGcInfo.gcTimes;
      paramPerfItem.gcDurationTime = localGcInfo.gcDuration;
    }
  }
  
  private void f(@NonNull PerfItem paramPerfItem)
  {
    if (this.i != null)
    {
      long[] arrayOfLong = this.e.a();
      if ((arrayOfLong != null) && (arrayOfLong.length == 2))
      {
        paramPerfItem.ioCount = (arrayOfLong[0] - this.i.ioCount);
        paramPerfItem.ioBytes = (arrayOfLong[1] - this.i.ioBytes);
        long l1 = paramPerfItem.ioCount;
        long l2 = 0L;
        if (l1 > 0L) {
          l1 = paramPerfItem.ioCount;
        } else {
          l1 = 0L;
        }
        paramPerfItem.ioCount = l1;
        l1 = l2;
        if (paramPerfItem.ioBytes > 0L) {
          l1 = paramPerfItem.ioBytes;
        }
        paramPerfItem.ioBytes = l1;
        this.i.ioCount = arrayOfLong[0];
        this.i.ioBytes = arrayOfLong[1];
      }
    }
  }
  
  private void g(@NonNull PerfItem paramPerfItem)
  {
    if (this.i != null)
    {
      NetFlow localNetFlow = this.f.a(true);
      long l1 = this.i.netFlowReceiverBytes;
      long l2 = 0L;
      if ((9223372036854775807L != l1) && (9223372036854775807L != this.i.netFlowSendBytes))
      {
        paramPerfItem.netFlowReceiverBytes = (localNetFlow.rxBytes - this.i.netFlowReceiverBytes);
        paramPerfItem.netFlowSendBytes = (localNetFlow.txBytes - this.i.netFlowSendBytes);
        if (paramPerfItem.netFlowReceiverBytes > 0L) {
          l1 = paramPerfItem.netFlowReceiverBytes;
        } else {
          l1 = 0L;
        }
        paramPerfItem.netFlowReceiverBytes = l1;
        if (paramPerfItem.netFlowSendBytes > 0L) {
          l1 = paramPerfItem.netFlowSendBytes;
        } else {
          l1 = 0L;
        }
        paramPerfItem.netFlowSendBytes = l1;
      }
      else
      {
        paramPerfItem.netFlowReceiverBytes = 0L;
        paramPerfItem.netFlowSendBytes = 0L;
      }
      if ((9223372036854775807L != localNetFlow.rxPackets) && (9223372036854775807L != localNetFlow.txPackets))
      {
        paramPerfItem.netFlowPackets = (localNetFlow.rxPackets + localNetFlow.txPackets - this.i.netFlowPackets);
        l1 = l2;
        if (paramPerfItem.netFlowPackets > 0L) {
          l1 = paramPerfItem.netFlowPackets;
        }
        paramPerfItem.netFlowPackets = l1;
        this.i.netFlowPackets = (localNetFlow.rxPackets + localNetFlow.txPackets);
      }
      else
      {
        paramPerfItem.netFlowPackets = 0L;
      }
      this.i.netFlowReceiverBytes = localNetFlow.rxBytes;
      this.i.netFlowSendBytes = localNetFlow.txBytes;
    }
  }
  
  private long h()
  {
    if (RunTimeEnv.a()) {
      return 5000L;
    }
    return 1000L;
  }
  
  private void h(PerfItem paramPerfItem)
  {
    if (this.d.size() > 60) {
      this.d.remove(0);
    }
    this.d.add(paramPerfItem);
  }
  
  public void a(IPerfItemCollectorListener paramIPerfItemCollectorListener)
  {
    this.h = paramIPerfItemCollectorListener;
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public void b()
  {
    if (!this.j)
    {
      this.j = true;
      if ((ConfigProxy.INSTANCE.getConfig().b("JVM_TI_OPEN")) && (!RunTimeEnv.a())) {
        JvmTiProxy.a().init();
      }
      this.g.post(this);
    }
  }
  
  public void c()
  {
    this.j = false;
    this.c.clear();
    this.g.removeCallbacks(this);
  }
  
  public void d()
  {
    Object localObject = new PerfItem();
    a((PerfItem)localObject);
    double d1 = System.currentTimeMillis();
    Double.isNaN(d1);
    ((PerfItem)localObject).eventTime = (d1 / 1000.0D);
    if (RunTimeEnv.c())
    {
      this.c.add(localObject);
      h((PerfItem)localObject);
      if (this.c.size() > 900)
      {
        localObject = this.h;
        if (localObject != null) {
          ((IPerfItemCollectorListener)localObject).b();
        }
      }
    }
  }
  
  public int e()
  {
    return this.c.size();
  }
  
  public Vector<PerfItem> f()
  {
    Vector localVector = (Vector)this.c.clone();
    this.c.clear();
    return localVector;
  }
  
  public Vector<PerfItem> g()
  {
    Vector localVector = (Vector)this.d.clone();
    this.d.clear();
    return localVector;
  }
  
  public void run()
  {
    d();
    if (this.j) {
      this.g.postDelayed(this, h());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.PerfItemCollector
 * JD-Core Version:    0.7.0.1
 */