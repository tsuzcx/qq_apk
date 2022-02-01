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
  public static long a = 0L;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  private static MagnifierSDK jdField_a_of_type_ComTencentQqperfMagnifierSDK;
  public static DBHandler a;
  public static Object a;
  public static String a = "";
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
    if (jdField_a_of_type_ComTencentQqperfMagnifierSDK == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfMagnifierSDK == null) {
          jdField_a_of_type_ComTencentQqperfMagnifierSDK = new MagnifierSDK();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfMagnifierSDK;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V 8.7.0.");
    localStringBuilder.append(ApkUtils.a(MobileQQ.getContext()));
    localStringBuilder.append(".r");
    localStringBuilder.append(AppSetting.g());
    return localStringBuilder.toString();
  }
  
  public static void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lifeCycle setUin ");
    localStringBuilder.append(paramLong);
    QLog.i("MagnifierSDK.QAPM", 1, localStringBuilder.toString());
    jdField_a_of_type_Long = paramLong;
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  private void a(ArrayList<IAPMBase> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      IAPMBase localIAPMBase = (IAPMBase)localIterator.next();
      boolean bool = localIAPMBase.d();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lifecycle ");
      ((StringBuilder)localObject).append(localIAPMBase.a());
      ((StringBuilder)localObject).append(" canStart ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("MagnifierSDK.QAPM", 1, ((StringBuilder)localObject).toString());
      if (bool)
      {
        QAPMIniter.a();
        localObject = localIAPMBase.a();
        localIAPMBase.b();
        APMModuleConfig localAPMModuleConfig = localIAPMBase.b();
        ((DefaultPluginConfig)localObject).eventSampleRatio = localAPMModuleConfig.evenRatio;
        ((DefaultPluginConfig)localObject).threshold = localAPMModuleConfig.threshold;
        ((DefaultPluginConfig)localObject).maxReportNum = localAPMModuleConfig.maxReport;
        ((DefaultPluginConfig)localObject).stackDepth = localAPMModuleConfig.stackDepth;
        i |= ((DefaultPluginConfig)localObject).mode;
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
    if ((2 != MobileQQ.sProcessId) && (8 != MobileQQ.sProcessId)) {
      return "1";
    }
    return "100";
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig == null) {
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
      }
    }
    return this.jdField_a_of_type_ComTencentQqperfConfigAPMConfig;
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
      Object localObject = new MagnifierSDK.RunSDKRunnable(this, MobileQQ.getContext());
      jdField_a_of_type_MqqOsMqqHandler.post((Runnable)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startVersion = ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" gray=");
      ((StringBuilder)localObject).append(false);
      ((StringBuilder)localObject).append(" pub=");
      ((StringBuilder)localObject).append(true);
      QLog.i("MagnifierSDK.QAPM", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(ILooperListener paramILooperListener)
  {
    if ((a() instanceof QAPMLooperWrapper)) {
      ((QAPMLooperWrapper)a()).a(paramILooperListener);
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
    this.jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper.a(paramString);
  }
  
  public IAPMBase b()
  {
    return this.jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper;
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
    this.jdField_a_of_type_ComTencentQqperfMonitorResourceQAPMResourceWrapper.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */