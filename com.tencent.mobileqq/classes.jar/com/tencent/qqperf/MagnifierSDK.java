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
  public static long a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentQqperfMagnifierSDK;
  public static DBHandler a;
  public static Object a;
  public static String a;
  public static MqqHandler a;
  private APMConfRoot jdField_a_of_type_ComTencentQqperfConfigAPMConfRoot = null;
  private APMConfig jdField_a_of_type_ComTencentQqperfConfigAPMConfig = null;
  public Config a;
  private AbstractMagnifierItem jdField_a_of_type_ComTencentQqperfMonitorBaseAbstractMagnifierItem = new QAPMCellingValueWrapper();
  private IAPMDropFrame jdField_a_of_type_ComTencentQqperfMonitorBaseIAPMDropFrame = new QAPMDropFrameWrapper();
  private IAPMModuleCelling jdField_a_of_type_ComTencentQqperfMonitorBaseIAPMModuleCelling = new QAPMCellingHprofWrapper();
  private IAPMModuleLeak jdField_a_of_type_ComTencentQqperfMonitorBaseIAPMModuleLeak = new QAPMLeakWrapper();
  private QAPMBatteryWrapper jdField_a_of_type_ComTencentQqperfMonitorBatteryQAPMBatteryWrapper = new QAPMBatteryWrapper();
  private QAPMBigBitmapWrapper jdField_a_of_type_ComTencentQqperfMonitorBigbitmapQAPMBigBitmapWrapper = new QAPMBigBitmapWrapper();
  private QAPMResourceWrapper jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper = new QAPMResourceWrapper();
  MemoryConfigs jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryConfigs = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AbstractMagnifierItem b = new QAPMLooperWrapper();
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_ComTencentQqperfMagnifierSDK = null;
    jdField_a_of_type_MqqOsMqqHandler = null;
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private MagnifierSDK()
  {
    this.jdField_a_of_type_ComTencentQqperfConfigConfig = new Config();
  }
  
  public static SharedPreferences a(Application paramApplication)
  {
    return paramApplication.getSharedPreferences("MagnifierSDK.QAPM", 4);
  }
  
  public static MagnifierSDK a()
  {
    if (jdField_a_of_type_ComTencentQqperfMagnifierSDK == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqperfMagnifierSDK == null) {
        jdField_a_of_type_ComTencentQqperfMagnifierSDK = new MagnifierSDK();
      }
      return jdField_a_of_type_ComTencentQqperfMagnifierSDK;
    }
    finally {}
  }
  
  public static String a()
  {
    return "V 8.5.5." + ApkUtils.a(MobileQQ.getContext()) + ".r" + AppSetting.g();
  }
  
  public static void a(long paramLong)
  {
    QLog.i("MagnifierSDK.QAPM", 1, "lifeCycle setUin " + paramLong);
    jdField_a_of_type_Long = paramLong;
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  private void a(ArrayList<IAPMBase> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      IAPMBase localIAPMBase = (IAPMBase)localIterator.next();
      boolean bool = localIAPMBase.d();
      QLog.i("MagnifierSDK.QAPM", 1, "lifecycle " + localIAPMBase.a() + " canStart " + bool);
      j = i;
      if (bool)
      {
        QAPMIniter.a();
        DefaultPluginConfig localDefaultPluginConfig = localIAPMBase.a();
        localIAPMBase.b();
        APMModuleConfig localAPMModuleConfig = localIAPMBase.b();
        localDefaultPluginConfig.eventSampleRatio = localAPMModuleConfig.evenRatio;
        localDefaultPluginConfig.threshold = localAPMModuleConfig.threshold;
        localDefaultPluginConfig.maxReportNum = localAPMModuleConfig.maxReport;
        localDefaultPluginConfig.stackDepth = localAPMModuleConfig.stackDepth;
        j = i | localDefaultPluginConfig.mode;
        localIAPMBase.c();
      }
    }
    if (i != 0) {
      QAPM.beginScene("SCENE_ALL", i);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((IAPMBase)paramArrayList.next()).a();
    }
  }
  
  public static String b()
  {
    if ((2 == MobileQQ.sProcessId) || (8 == MobileQQ.sProcessId)) {
      return "100";
    }
    return "1";
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig == null)
      {
        this.jdField_a_of_type_ComTencentQqperfConfigAPMConfRoot = ((APMConfRoot)QConfigManager.a().a(255));
        if (this.jdField_a_of_type_ComTencentQqperfConfigAPMConfRoot != null) {
          this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig = this.jdField_a_of_type_ComTencentQqperfConfigAPMConfRoot.pub;
        }
        if (this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig == null) {
          this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig = new APMConfig();
        }
      }
      return this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig;
    }
  }
  
  public AbstractMagnifierItem a()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorBaseAbstractMagnifierItem;
  }
  
  public IAPMBase a()
  {
    return this.b;
  }
  
  public IAPMDropFrame a()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorBaseIAPMDropFrame;
  }
  
  public IAPMModuleBattery a()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorBatteryQAPMBatteryWrapper;
  }
  
  public IAPMModuleCelling a()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorBaseIAPMModuleCelling;
  }
  
  public IAPMModuleLeak a()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorBaseIAPMModuleLeak;
  }
  
  public MemoryConfigs a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryConfigs == null) {
        this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryConfigs = new MemoryConfigs();
      }
      MemoryConfigs localMemoryConfigs = this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryConfigs;
      return localMemoryConfigs;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
      jdField_a_of_type_JavaLangString = a();
      MagnifierSDK.RunSDKRunnable localRunSDKRunnable = new MagnifierSDK.RunSDKRunnable(this, MobileQQ.getContext());
      jdField_a_of_type_MqqOsMqqHandler.post(localRunSDKRunnable);
      QLog.i("MagnifierSDK.QAPM", 1, "startVersion = " + jdField_a_of_type_JavaLangString + " gray=" + false + " pub=" + true);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "beginScene:" + paramString);
    }
    this.jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper.a(paramString);
  }
  
  public IAPMBase b()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "endScene:" + paramString);
    }
    this.jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper.b(paramString);
  }
  
  public IAPMBase c()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorBigbitmapQAPMBigBitmapWrapper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */