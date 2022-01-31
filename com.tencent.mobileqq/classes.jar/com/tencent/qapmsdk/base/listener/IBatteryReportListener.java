package com.tencent.qapmsdk.base.listener;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IBatteryReportListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onBeforeReport", "", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IBatteryReportListener
  extends IBaseListener
{
  @NotNull
  public abstract List<String> onBeforeReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IBatteryReportListener
 * JD-Core Version:    0.7.0.1
 */