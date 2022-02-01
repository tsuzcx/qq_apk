package com.tencent.qapmsdk.base.listener;

import com.tencent.qapmsdk.base.meta.LooperMeta;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/ILooperListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onBeforeReport", "", "meta", "Lcom/tencent/qapmsdk/base/meta/LooperMeta;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface ILooperListener
  extends IBaseListener
{
  public abstract void onBeforeReport(@Nullable LooperMeta paramLooperMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.ILooperListener
 * JD-Core Version:    0.7.0.1
 */