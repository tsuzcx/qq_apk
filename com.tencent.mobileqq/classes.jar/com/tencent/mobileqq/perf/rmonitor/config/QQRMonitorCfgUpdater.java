package com.tencent.mobileqq.perf.rmonitor.config;

import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.perf.rmonitor.natmem.QQRMonitorNatMemCfgItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.base.config.IConfigUpdater;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.config.data.RMonitorConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import org.jetbrains.annotations.NotNull;

public class QQRMonitorCfgUpdater
  implements IConfigUpdater
{
  private void a(@NotNull RPluginConfig paramRPluginConfig)
  {
    if (QQRMonitorSDKManager.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRMonitorCfgUpdater", 2, "updateNatMemConfig");
      }
      QQRMonitorNatMemCfgItem localQQRMonitorNatMemCfgItem = QQRMonitorSDKManager.a.b;
      if (localQQRMonitorNatMemCfgItem != null)
      {
        paramRPluginConfig = (NatMemPluginConfig)paramRPluginConfig;
        if (localQQRMonitorNatMemCfgItem.b > 0.0D) {
          paramRPluginConfig.h = ((float)localQQRMonitorNatMemCfgItem.b);
        }
        paramRPluginConfig.a(localQQRMonitorNatMemCfgItem.c);
        if (localQQRMonitorNatMemCfgItem.d > 0) {
          paramRPluginConfig.a(localQQRMonitorNatMemCfgItem.d);
        }
        if (localQQRMonitorNatMemCfgItem.e > 0) {
          paramRPluginConfig.b(localQQRMonitorNatMemCfgItem.e);
        }
        if (localQQRMonitorNatMemCfgItem.f > 0L) {
          paramRPluginConfig.a(localQQRMonitorNatMemCfgItem.f);
        }
      }
    }
  }
  
  public void a(int paramInt, @NotNull RPluginConfig paramRPluginConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNatMemConfig, plugin = ");
      localStringBuilder.append(paramInt);
      QLog.d("QQRMonitorCfgUpdater", 2, localStringBuilder.toString());
    }
    if (paramInt == 154) {
      a(paramRPluginConfig);
    }
  }
  
  public void a(@NotNull RMonitorConfig paramRMonitorConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorCfgUpdater", 2, "updateConfig");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorCfgUpdater
 * JD-Core Version:    0.7.0.1
 */