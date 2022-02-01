package com.tencent.rmonitor.base.reporter.pluginreport;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/pluginreport/IPluginReport;", "", "report", "", "obj", "setExtraData", "", "extraData", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IPluginReport
{
  public abstract void a(@Nullable Object paramObject);
  
  public abstract boolean b(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.pluginreport.IPluginReport
 * JD-Core Version:    0.7.0.1
 */