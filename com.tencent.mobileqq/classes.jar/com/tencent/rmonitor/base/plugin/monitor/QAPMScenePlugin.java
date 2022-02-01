package com.tencent.rmonitor.base.plugin.monitor;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/monitor/QAPMScenePlugin;", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "()V", "beginScene", "", "sceneName", "", "extraInfo", "endScene", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class QAPMScenePlugin
  extends QAPMMonitorPlugin
{
  public abstract void beginScene(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void endScene(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.monitor.QAPMScenePlugin
 * JD-Core Version:    0.7.0.1
 */