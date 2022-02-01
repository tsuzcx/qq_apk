package com.tencent.rmonitor.base.config;

import com.tencent.rmonitor.base.config.data.RMonitorConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import org.jetbrains.annotations.NotNull;

public abstract interface IConfigUpdater
{
  public abstract void a(int paramInt, @NotNull RPluginConfig paramRPluginConfig);
  
  public abstract void a(@NotNull RMonitorConfig paramRMonitorConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.IConfigUpdater
 * JD-Core Version:    0.7.0.1
 */