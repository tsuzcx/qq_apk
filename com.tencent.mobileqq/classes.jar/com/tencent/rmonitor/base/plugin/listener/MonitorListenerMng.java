package com.tencent.rmonitor.base.plugin.listener;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/MonitorListenerMng;", "T", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "", "()V", "listenerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListenerList", "()Ljava/util/ArrayList;", "addListener", "", "listener", "(Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;)V", "getListener", "()Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "removeListener", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class MonitorListenerMng<T extends IBaseListener>
{
  @NotNull
  private final ArrayList<T> a = new ArrayList();
  
  @NotNull
  public final ArrayList<T> a()
  {
    return this.a;
  }
  
  public final void a(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "listener");
    if (!this.a.contains(paramT)) {
      this.a.add(paramT);
    }
  }
  
  @Nullable
  public final T b()
  {
    if (this.a.isEmpty()) {
      return null;
    }
    return (IBaseListener)CollectionsKt.last((List)this.a);
  }
  
  public final void b(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "listener");
    this.a.remove(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng
 * JD-Core Version:    0.7.0.1
 */