package com.tencent.timi.game.databasecore.impl.notify;

import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/databasecore/impl/notify/BaseDbNotifyManager;", "T", "", "()V", "listenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/databasecore/impl/notify/DbNotifyListener;", "getListenerList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "tag", "", "bindListener", "", "listener", "isInListenerList", "", "ontifyUpdate", "data", "(Ljava/lang/Object;)V", "removeBindListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseDbNotifyManager<T>
{
  private final String a = "BaseDbNotifyManager";
  @NotNull
  private final CopyOnWriteArrayList<WeakReference<DbNotifyListener<T>>> b = new CopyOnWriteArrayList();
  
  private final boolean c(DbNotifyListener<T> paramDbNotifyListener)
  {
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext()) {
      if (Intrinsics.areEqual(paramDbNotifyListener, (DbNotifyListener)((WeakReference)localIterator.next()).get())) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(@NotNull DbNotifyListener<T> paramDbNotifyListener)
  {
    Intrinsics.checkParameterIsNotNull(paramDbNotifyListener, "listener");
    if (c(paramDbNotifyListener))
    {
      Logger.INSTANCE.i(new String[] { this.a, "bindListener already in list return " });
      return;
    }
    paramDbNotifyListener = new WeakReference(paramDbNotifyListener);
    Logger localLogger = Logger.INSTANCE;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindListener ");
    localStringBuilder.append(paramDbNotifyListener);
    localLogger.i(new String[] { str, localStringBuilder.toString() });
    this.b.add(paramDbNotifyListener);
  }
  
  public final void a(@Nullable T paramT)
  {
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext())
    {
      DbNotifyListener localDbNotifyListener = (DbNotifyListener)((WeakReference)localIterator.next()).get();
      if (localDbNotifyListener != null) {
        localDbNotifyListener.a(paramT);
      }
    }
  }
  
  public final void b(@NotNull DbNotifyListener<T> paramDbNotifyListener)
  {
    Intrinsics.checkParameterIsNotNull(paramDbNotifyListener, "listener");
    List localList = (List)new ArrayList();
    Object localObject1 = ((Iterable)this.b).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() == null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localList.add(localObject2);
      }
      else if (Intrinsics.areEqual(paramDbNotifyListener, (DbNotifyListener)((WeakReference)localObject2).get()))
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localList.add(localObject2);
      }
    }
    paramDbNotifyListener = Logger.INSTANCE;
    localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("removeBindListener ");
    ((StringBuilder)localObject2).append(localList);
    paramDbNotifyListener.i(new String[] { localObject1, ((StringBuilder)localObject2).toString() });
    if (localList.size() > 0) {
      this.b.removeAll((Collection)localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.notify.BaseDbNotifyManager
 * JD-Core Version:    0.7.0.1
 */