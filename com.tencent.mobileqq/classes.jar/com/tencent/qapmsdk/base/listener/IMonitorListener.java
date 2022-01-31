package com.tencent.qapmsdk.base.listener;

import com.tencent.qapmsdk.base.meta.MonitorMeta;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IMonitorListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onMetaGet", "", "metaData", "Lcom/tencent/qapmsdk/base/meta/MonitorMeta;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IMonitorListener
  extends IBaseListener
{
  public abstract void onMetaGet(@NotNull MonitorMeta paramMonitorMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IMonitorListener
 * JD-Core Version:    0.7.0.1
 */