package com.tencent.rmonitor.base.plugin.monitor;

import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "", "()V", "pluginConfig", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "getPluginConfig", "()Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "setPluginConfig", "(Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;)V", "start", "", "stop", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class QAPMMonitorPlugin
{
  @Nullable
  private DefaultPluginConfig a;
  
  @Nullable
  public final DefaultPluginConfig a()
  {
    return this.a;
  }
  
  public final void a(@Nullable DefaultPluginConfig paramDefaultPluginConfig)
  {
    this.a = paramDefaultPluginConfig;
  }
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
 * JD-Core Version:    0.7.0.1
 */