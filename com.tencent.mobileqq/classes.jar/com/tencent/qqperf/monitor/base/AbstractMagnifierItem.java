package com.tencent.qqperf.monitor.base;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.config.APMConfig;
import com.tencent.qqperf.config.APMModuleConfig;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMagnifierItem
  implements IAPMBase
{
  APMModuleConfig jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig = null;
  private Boolean jdField_a_of_type_JavaLangBoolean = null;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public DefaultPluginConfig a()
  {
    return (DefaultPluginConfig)APMConfig.sPluginToQapmPluginConfigMap.get(a());
  }
  
  protected APMModuleConfig a()
  {
    APMModuleConfig localAPMModuleConfig = new APMModuleConfig();
    localAPMModuleConfig.userRatio = 0.0F;
    localAPMModuleConfig.evenRatio = 0.0F;
    localAPMModuleConfig.threshold = 100;
    localAPMModuleConfig.maxReport = 0;
    return localAPMModuleConfig;
  }
  
  public abstract String a();
  
  public void a() {}
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  protected boolean a()
  {
    return b().canOpenPlugin();
  }
  
  public APMModuleConfig b()
  {
    if (this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig == null)
    {
      Object localObject = MagnifierSDK.a().a();
      this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig = ((APMConfig)localObject).getSampleConfig(a());
      if (this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig == null) {
        this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig = a();
      }
      if ((((APMConfig)localObject).runVip) && (UnifiedMonitor.c()) && ((!QLog.isColorLevel()) || ((!"dropframe".equals(a())) && (!"leak".equals(a())))))
      {
        localObject = this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig;
        ((APMModuleConfig)localObject).evenRatio = 1.0F;
        ((APMModuleConfig)localObject).threshold = a().threshold;
        localObject = this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig;
        ((APMModuleConfig)localObject).userRatio = 1.0F;
        ((APMModuleConfig)localObject).maxReport = 2147483647;
        ((APMModuleConfig)localObject).stackDepth = 6;
      }
      a(this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMyConfig ");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig);
      QLog.i("MagnifierSDK.QAPM", 1, ((StringBuilder)localObject).toString());
    }
    return this.jdField_a_of_type_ComTencentQqperfConfigAPMModuleConfig;
  }
  
  public final boolean c()
  {
    this.jdField_a_of_type_Boolean = true;
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(a());
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public boolean o_()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.base.AbstractMagnifierItem
 * JD-Core Version:    0.7.0.1
 */