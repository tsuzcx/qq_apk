package com.tencent.rmonitor.base.reporter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "", "onCached", "", "onFailure", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IReporter$ReportCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt1, @NotNull String paramString, int paramInt2);
  
  public abstract void t_(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.IReporter.ReportCallback
 * JD-Core Version:    0.7.0.1
 */