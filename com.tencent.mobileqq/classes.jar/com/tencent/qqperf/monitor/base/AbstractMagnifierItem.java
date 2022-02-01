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
  APMModuleConfig a = null;
  private volatile boolean b = false;
  private Boolean c = null;
  
  public abstract String a();
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  protected boolean c()
  {
    return f().canOpenPlugin();
  }
  
  public void d() {}
  
  protected APMModuleConfig dG_()
  {
    APMModuleConfig localAPMModuleConfig = new APMModuleConfig();
    localAPMModuleConfig.userRatio = 0.0F;
    localAPMModuleConfig.evenRatio = 0.0F;
    localAPMModuleConfig.threshold = 100;
    localAPMModuleConfig.maxReport = 0;
    return localAPMModuleConfig;
  }
  
  public boolean dH_()
  {
    return this.b;
  }
  
  public APMModuleConfig f()
  {
    if (this.a == null)
    {
      Object localObject = MagnifierSDK.b().a();
      this.a = ((APMConfig)localObject).getSampleConfig(a());
      if (this.a == null) {
        this.a = dG_();
      }
      if ((((APMConfig)localObject).runVip) && (UnifiedMonitor.g()) && ((!QLog.isColorLevel()) || ((!"dropframe".equals(a())) && (!"leak".equals(a())))))
      {
        localObject = this.a;
        ((APMModuleConfig)localObject).evenRatio = 1.0F;
        ((APMModuleConfig)localObject).threshold = g().threshold;
        localObject = this.a;
        ((APMModuleConfig)localObject).userRatio = 1.0F;
        ((APMModuleConfig)localObject).maxReport = 2147483647;
        ((APMModuleConfig)localObject).stackDepth = 6;
      }
      a(this.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMyConfig ");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("MagnifierSDK.QAPM", 1, ((StringBuilder)localObject).toString());
    }
    return this.a;
  }
  
  public DefaultPluginConfig g()
  {
    return (DefaultPluginConfig)APMConfig.sPluginToQapmPluginConfigMap.get(a());
  }
  
  public final boolean h()
  {
    this.b = true;
    return this.b;
  }
  
  public boolean i()
  {
    if (this.c == null) {
      this.c = Boolean.valueOf(c());
    }
    return this.c.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.base.AbstractMagnifierItem
 * JD-Core Version:    0.7.0.1
 */