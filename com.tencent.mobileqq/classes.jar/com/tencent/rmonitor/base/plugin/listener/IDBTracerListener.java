package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.base.meta.DBMeta;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/IDBTracerListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onDBInfoPublish", "", "metas", "", "Lcom/tencent/rmonitor/base/meta/DBMeta;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IDBTracerListener
  extends IBaseListener
{
  public abstract void onDBInfoPublish(@NotNull List<DBMeta> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.IDBTracerListener
 * JD-Core Version:    0.7.0.1
 */