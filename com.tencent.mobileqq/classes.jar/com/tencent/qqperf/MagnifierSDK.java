package com.tencent.qqperf;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.config.APMConfRoot;
import com.tencent.qqperf.config.APMConfig;
import com.tencent.qqperf.config.APMModuleConfig;
import com.tencent.qqperf.config.Config;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMBase;
import com.tencent.qqperf.monitor.base.IAPMDropFrame;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;
import com.tencent.qqperf.monitor.battery.QAPMBatteryWrapper;
import com.tencent.qqperf.monitor.bigbitmap.QAPMBigBitmapWrapper;
import com.tencent.qqperf.monitor.dropframe.QAPMDropFrameWrapper;
import com.tencent.qqperf.monitor.looper.QAPMLooperWrapper;
import com.tencent.qqperf.monitor.memory.QAPMCellingHprofWrapper;
import com.tencent.qqperf.monitor.memory.QAPMCellingValueWrapper;
import com.tencent.qqperf.monitor.memory.QAPMLeakWrapper;
import com.tencent.qqperf.monitor.resource.QAPMResourceWrapper;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;
import com.tencent.qqperf.repoter.DBHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class MagnifierSDK
{
  public static String a = "";
  public static long b;
  public static SharedPreferences c;
  public static SharedPreferences.Editor d;
  public static DBHandler e;
  public static MqqHandler f;
  public static Object g = new Object();
  private static MagnifierSDK j;
  public Config h = new Config();
  MemoryConfigs i = null;
  private APMConfig k = null;
  private APMConfRoot l = null;
  private IAPMModuleLeak m = new QAPMLeakWrapper();
  private IAPMModuleCelling n = new QAPMCellingHprofWrapper();
  private AbstractMagnifierItem o = new QAPMCellingValueWrapper();
  private IAPMDropFrame p = new QAPMDropFrameWrapper();
  private AbstractMagnifierItem q = new QAPMLooperWrapper();
  private QAPMResourceWrapper r = new QAPMResourceWrapper();
  private QAPMBatteryWrapper s = new QAPMBatteryWrapper();
  private QAPMBigBitmapWrapper t = new QAPMBigBitmapWrapper();
  private AtomicBoolean u = new AtomicBoolean(false);
  
  public static SharedPreferences a(Application paramApplication)
  {
    return paramApplication.getSharedPreferences("MagnifierSDK.QAPM", 4);
  }
  
  public static void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lifeCycle setUin ");
    localStringBuilder.append(paramLong);
    QLog.i("MagnifierSDK.QAPM", 1, localStringBuilder.toString());
    b = paramLong;
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  private void a(ArrayList<IAPMBase> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      IAPMBase localIAPMBase = (IAPMBase)localIterator.next();
      boolean bool = localIAPMBase.i();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lifecycle ");
      ((StringBuilder)localObject).append(localIAPMBase.a());
      ((StringBuilder)localObject).append(" canStart ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("MagnifierSDK.QAPM", 1, ((StringBuilder)localObject).toString());
      if (bool)
      {
        QAPMIniter.a();
        localObject = localIAPMBase.g();
        localIAPMBase.j();
        APMModuleConfig localAPMModuleConfig = localIAPMBase.f();
        ((DefaultPluginConfig)localObject).eventSampleRatio = localAPMModuleConfig.evenRatio;
        ((DefaultPluginConfig)localObject).threshold = localAPMModuleConfig.threshold;
        ((DefaultPluginConfig)localObject).maxReportNum = localAPMModuleConfig.maxReport;
        ((DefaultPluginConfig)localObject).stackDepth = localAPMModuleConfig.stackDepth;
        i1 |= ((DefaultPluginConfig)localObject).mode;
        localIAPMBase.h();
      }
    }
    if (i1 != 0) {
      QAPM.beginScene("SCENE_ALL", i1);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((IAPMBase)paramArrayList.next()).d();
    }
  }
  
  public static MagnifierSDK b()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new MagnifierSDK();
        }
      }
      finally {}
    }
    return j;
  }
  
  public static String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V 8.8.17.");
    localStringBuilder.append(ApkUtils.a(MobileQQ.getContext()));
    localStringBuilder.append(".r");
    localStringBuilder.append(AppSetting.i());
    return localStringBuilder.toString();
  }
  
  public static String m()
  {
    if ((2 != MobileQQ.sProcessId) && (8 != MobileQQ.sProcessId)) {
      return "1";
    }
    return "100";
  }
  
  public APMConfig a()
  {
    if (this.k == null) {
      synchronized (g)
      {
        if (this.k == null)
        {
          this.l = ((APMConfRoot)QConfigManager.b().b(255));
          if (this.l != null) {
            this.k = this.l.pub;
          }
          if (this.k == null) {
            this.k = new APMConfig();
          }
        }
      }
    }
    return this.k;
  }
  
  public void a(ILooperListener paramILooperListener)
  {
    if ((g() instanceof QAPMLooperWrapper)) {
      ((QAPMLooperWrapper)g()).a(paramILooperListener);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("beginScene:");
      localStringBuilder.append(paramString);
      QLog.i("MagnifierSDK.QAPM", 2, localStringBuilder.toString());
    }
    this.r.a(paramString);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("endScene:");
      localStringBuilder.append(paramString);
      QLog.i("MagnifierSDK.QAPM", 2, localStringBuilder.toString());
    }
    this.r.b(paramString);
  }
  
  public IAPMModuleLeak c()
  {
    return this.m;
  }
  
  public IAPMModuleCelling d()
  {
    return this.n;
  }
  
  public AbstractMagnifierItem e()
  {
    return this.o;
  }
  
  public IAPMDropFrame f()
  {
    return this.p;
  }
  
  public IAPMBase g()
  {
    return this.q;
  }
  
  public IAPMBase h()
  {
    return this.r;
  }
  
  public IAPMModuleBattery i()
  {
    return this.s;
  }
  
  public MemoryConfigs j()
  {
    try
    {
      if (this.i == null) {
        this.i = new MemoryConfigs();
      }
      MemoryConfigs localMemoryConfigs = this.i;
      return localMemoryConfigs;
    }
    finally {}
  }
  
  public void l()
  {
    if (this.u.compareAndSet(false, true))
    {
      f = ThreadManager.getSubThreadHandler();
      a = k();
      Object localObject = new MagnifierSDK.RunSDKRunnable(this, MobileQQ.getContext());
      f.post((Runnable)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startVersion = ");
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append(" gray=");
      ((StringBuilder)localObject).append(false);
      ((StringBuilder)localObject).append(" pub=");
      ((StringBuilder)localObject).append(true);
      QLog.i("MagnifierSDK.QAPM", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */