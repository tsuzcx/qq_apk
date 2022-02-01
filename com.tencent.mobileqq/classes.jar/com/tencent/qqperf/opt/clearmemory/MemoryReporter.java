package com.tencent.qqperf.opt.clearmemory;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMMemoryClearListener;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

public class MemoryReporter
  implements Handler.Callback
{
  public static int a;
  private static MemoryReporter jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryReporter;
  public static ArrayList<String> a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Vector<IAPMMemoryClearListener> jdField_a_of_type_JavaUtilVector = new Vector();
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private MemoryReporter()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = MagnifierSDK.a().a().d();
    a(MemoryClearManager.a());
  }
  
  public static MemoryReporter a()
  {
    if (jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryReporter == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryReporter == null) {
          jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryReporter = new MemoryReporter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryReporter;
  }
  
  private void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
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
  
  private void c()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    long l3 = (100 - MagnifierSDK.a().a().jdField_a_of_type_Int) * Runtime.getRuntime().maxMemory() / 100L;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump  calculateSharpMemory heapSize= ", Long.valueOf(l1 - l2) });
    }
    int i = jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (MagnifierSDK.a().a().jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
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
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramIAPMMemoryClearListener);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, ClearMemoryConfig paramClearMemoryConfig, int paramInt)
  {
    ClearMemoryConfig.MemoryLevelInfo localMemoryLevelInfo = paramClearMemoryConfig.a(paramInt);
    if ((localMemoryLevelInfo != null) && (paramLong1 >= localMemoryLevelInfo.jdField_a_of_type_Int * paramLong2 / 100L))
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
      paramClearMemoryConfig.jdField_a_of_type_Int = localMemoryLevelInfo.b;
      a(paramInt, localMemoryLevelInfo);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    jdField_a_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump setDumpReported = ", Integer.valueOf(jdField_a_of_type_Int) });
    }
  }
  
  public void b(IAPMMemoryClearListener paramIAPMMemoryClearListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.remove(paramIAPMMemoryClearListener);
      return;
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
        paramMessage = MagnifierSDK.a().a().jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig;
        MemoryClearManager.a().c();
        if (a(l1, l2, paramMessage, 1))
        {
          i = paramMessage.jdField_a_of_type_Int * 1000;
        }
        else
        {
          if (a(l1, l2, paramMessage, 2)) {}
          for (i = paramMessage.jdField_a_of_type_Int;; i = paramMessage.jdField_a_of_type_Int)
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
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        int j = i;
        if (!bool)
        {
          j = i;
          if (i >= 30000) {
            j = i * 2;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, j);
      }
    }
    c();
    MemoryClearManager.a().a(bool);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramMessage = this.jdField_a_of_type_AndroidOsHandler;
    if (bool) {
      l1 = 5000L;
    } else {
      l1 = 30000L;
    }
    paramMessage.sendEmptyMessageDelayed(1, l1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.MemoryReporter
 * JD-Core Version:    0.7.0.1
 */