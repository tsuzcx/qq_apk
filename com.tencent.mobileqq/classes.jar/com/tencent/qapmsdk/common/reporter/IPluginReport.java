package com.tencent.qapmsdk.common.reporter;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/IPluginReport;", "", "doReport", "", "obj", "setExtraData", "", "extraData", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface IPluginReport
{
  public abstract boolean doReport(@Nullable Object paramObject);
  
  public abstract void setExtraData(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.reporter.IPluginReport
 * JD-Core Version:    0.7.0.1
 */