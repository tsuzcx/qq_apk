package com.tencent.qqperf.opt.clearmemory;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMMemoryClearListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

public class MemoryReporter
  implements Handler.Callback
{
  public static int a;
  public static ArrayList<String> c = new ArrayList();
  private static MemoryReporter d;
  public boolean b = false;
  private Handler e = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Vector<IAPMMemoryClearListener> f = new Vector();
  
  private MemoryReporter()
  {
    a(MemoryClearManager.b());
  }
  
  public static MemoryReporter a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new MemoryReporter();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((IAPMMemoryClearListener)localIterator.next()).a(paramInt, paramMemoryLevelInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramMemoryLevelInfo;
    }
  }
  
  private void d()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    long l3 = (100 - MagnifierSDK.b().j().d) * Runtime.getRuntime().maxMemory() / 100L;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump  calculateSharpMemory heapSize= ", Long.valueOf(l1 - l2) });
    }
    int i = a;
  }
  
  public void a(long paramLong)
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((IAPMMemoryClearListener)localIterator.next()).a(paramLong);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(IAPMMemoryClearListener paramIAPMMemoryClearListener)
  {
    synchronized (this.f)
    {
      this.f.add(paramIAPMMemoryClearListener);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, ClearMemoryConfig paramClearMemoryConfig, int paramInt)
  {
    ClearMemoryConfig.MemoryLevelInfo localMemoryLevelInfo = paramClearMemoryConfig.a(paramInt);
    if ((localMemoryLevelInfo != null) && (paramLong1 >= localMemoryLevelInfo.a * paramLong2 / 100L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNeedTrimMemory|maxHeap=");
        localStringBuilder.append(paramLong2 / 1024L / 1024L);
        localStringBuilder.append(",totalSize=");
        localStringBuilder.append(paramLong1 / 1024L / 84L);
        QLog.d("MemoryReporter", 2, localStringBuilder.toString());
      }
      paramClearMemoryConfig.c = localMemoryLevelInfo.b;
      a(paramInt, localMemoryLevelInfo);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (MagnifierSDK.b().j().h.b) {
      this.e.sendEmptyMessage(2);
    }
    if (this.b) {
      this.e.sendEmptyMessage(1);
    }
  }
  
  public void b(IAPMMemoryClearListener paramIAPMMemoryClearListener)
  {
    synchronized (this.f)
    {
      this.f.remove(paramIAPMMemoryClearListener);
      return;
    }
  }
  
  public void c()
  {
    a = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump setDumpReported = ", Integer.valueOf(a) });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if (Foreground.getResumeActivityCount() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    int i = paramMessage.what;
    long l1;
    if (i != 1)
    {
      if (i != 2) {}
      for (;;)
      {
        return true;
        l1 = Runtime.getRuntime().totalMemory();
        long l2 = Runtime.getRuntime().maxMemory();
        paramMessage = MagnifierSDK.b().j().h;
        MemoryClearManager.b().e();
        if (a(l1, l2, paramMessage, 1))
        {
          i = paramMessage.c * 1000;
        }
        else
        {
          if (a(l1, l2, paramMessage, 2)) {}
          for (i = paramMessage.c;; i = paramMessage.c)
          {
            i *= 1000;
            break label141;
            if (!a(l1, l2, paramMessage, 3)) {
              break;
            }
          }
          i = 30000;
        }
        label141:
        this.e.removeMessages(2);
        int j = i;
        if (!bool)
        {
          j = i;
          if (i >= 30000) {
            j = i * 2;
          }
        }
        this.e.sendEmptyMessageDelayed(2, j);
      }
    }
    d();
    MemoryClearManager.b().a(bool);
    this.e.removeMessages(1);
    paramMessage = this.e;
    if (bool) {
      l1 = 5000L;
    } else {
      l1 = 30000L;
    }
    paramMessage.sendEmptyMessageDelayed(1, l1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.MemoryReporter
 * JD-Core Version:    0.7.0.1
 */