package com.tencent.qqperf.monitor.memory;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.memory.MemoryCeilingMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.config.APMModuleConfig;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMMemoryClearListener;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import com.tencent.qqperf.monitor.base.IDumpMemoryCallback;
import com.tencent.qqperf.opt.clearmemory.MemoryReporter;
import com.tencent.qqperf.opt.vm.HackVmImpl;
import com.tencent.theme.SkinEngine;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class QAPMCellingHprofWrapper
  extends AbstractMagnifierItem
  implements IAPMModuleCelling
{
  private SharedPreferences b = null;
  private long c = 0L;
  
  static void l()
  {
    if (QLog.getUIN_REPORTLOG_LEVEL() < 2) {
      QLog.setUIN_REPORTLOG_LEVEL(2);
    }
  }
  
  public DumpResult a(String paramString, IDumpMemoryCallback paramIDumpMemoryCallback)
  {
    return MemoryCeilingMonitor.dumpHprof(paramString, new QAPMCellingHprofWrapper.1(this, paramIDumpMemoryCallback));
  }
  
  public String a()
  {
    return "ceilinghprof";
  }
  
  public void a(DumpResult paramDumpResult)
  {
    MemoryCeilingMonitor.reportHprofFile(paramDumpResult);
  }
  
  public void a(IAPMMemoryClearListener paramIAPMMemoryClearListener)
  {
    MemoryReporter.a().a(paramIAPMMemoryClearListener);
  }
  
  public String b()
  {
    return f().getOldStrategy("0|1;15|1|0|1|1|0.00001|0.1|1;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|2|0|0.5|1|0.00001|0.1|1;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|3|0|0.25|0|0.00001|0.1|3;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|4|0|0.5|0|0.00001|0.1|4;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7");
  }
  
  public void b(IAPMMemoryClearListener paramIAPMMemoryClearListener)
  {
    MemoryReporter.a().b(paramIAPMMemoryClearListener);
  }
  
  public boolean c()
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("memory_reporter_");
    localStringBuilder.append(MobileQQ.sProcessId);
    this.b = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    this.c = this.b.getLong("sp_key_last_shot_time", 0L);
    if (Math.abs(System.currentTimeMillis() - this.c) >= 86400000L)
    {
      if (f().canOpenPlugin())
      {
        l();
        this.c = System.currentTimeMillis();
        this.b.edit().putLong("sp_key_last_shot_time", this.c).putBoolean("key_need_report", true).commit();
        return true;
      }
      return false;
    }
    l();
    return true;
  }
  
  public void d()
  {
    super.d();
    MemoryReporter.a().b();
  }
  
  public boolean e()
  {
    return MemoryReporter.a().b;
  }
  
  public void j()
  {
    QAPM.setProperty(111, new QAPMMemCellingListener());
  }
  
  public String k()
  {
    StringBuilder localStringBuilder = new StringBuilder("RAM Info:all=");
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = DeviceInfoUtil.a() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.r() / 1024L / 1024L;
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      float f2 = -1.0F;
      float f1 = f2;
      if (arrayOfMemoryInfo != null)
      {
        f1 = f2;
        if (arrayOfMemoryInfo.length > 0) {
          f1 = arrayOfMemoryInfo[0].getTotalPss() / 1024.0F;
        }
      }
      f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
      float f3 = (float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F;
      float f4 = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      long l3 = HackVmImpl.e / 1024L / 1024L;
      localStringBuilder.append(l1);
      localStringBuilder.append("M,avaiable:");
      localStringBuilder.append(l2);
      localStringBuilder.append("M used:");
      localStringBuilder.append(((DecimalFormat)localObject).format(f1));
      localStringBuilder.append("M freeMemory:");
      localStringBuilder.append(f2);
      localStringBuilder.append("M,appTotalMemory:");
      localStringBuilder.append(f3);
      localStringBuilder.append("M,orgMaxMemory:");
      localStringBuilder.append(l3);
      localStringBuilder.append("M,maxMemory:");
      localStringBuilder.append(f4);
      localStringBuilder.append("M, ImgCache:");
      localStringBuilder.append(GlobalImageCache.a.size() / 1024 / 1024);
      localStringBuilder.append("M,SkinCache:");
      localStringBuilder.append(SkinEngine.dumpDrawableCacheMemSize() / 1024L / 1024L);
      localStringBuilder.append("M,LeakMonitor=");
      localStringBuilder.append(MagnifierSDK.b().d().e());
      localObject = (ArrayList)MemoryReporter.c.clone();
      if (((ArrayList)localObject).size() > 0)
      {
        localStringBuilder.append(",Leaked=[");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append(",");
        }
        localStringBuilder.append("]");
      }
    }
    catch (Throwable localThrowable)
    {
      label436:
      break label436;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMCellingHprofWrapper
 * JD-Core Version:    0.7.0.1
 */