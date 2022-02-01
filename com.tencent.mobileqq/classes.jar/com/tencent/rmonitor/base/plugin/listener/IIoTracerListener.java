package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.base.meta.CloseableLeakMeta;
import com.tencent.rmonitor.base.meta.IOMeta;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/IIoTracerListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onCloseableLeakPublish", "", "meta", "Lcom/tencent/rmonitor/base/meta/CloseableLeakMeta;", "onIOInfoPublish", "metas", "", "Lcom/tencent/rmonitor/base/meta/IOMeta;", "onIOStart", "fd", "", "path", "", "time", "", "onIOStop", "ioMeta", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IIoTracerListener
  extends IBaseListener
{
  public abstract void onCloseableLeakPublish(@NotNull CloseableLeakMeta paramCloseableLeakMeta);
  
  public abstract void onIOInfoPublish(@NotNull List<IOMeta> paramList);
  
  public abstract void onIOStart(int paramInt, @NotNull String paramString, long paramLong);
  
  public abstract void onIOStop(int paramInt, @NotNull String paramString, long paramLong, @NotNull IOMeta paramIOMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.IIoTracerListener
 * JD-Core Version:    0.7.0.1
 */