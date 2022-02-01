package com.tencent.mobileqq.kandian.base.ktx;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/ktx/CacheLazy;", "T", "Lkotlin/Lazy;", "initializer", "Lkotlin/Function0;", "scope", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Ljava/lang/Object;", "checking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scoped", "value", "getValue", "()Ljava/lang/Object;", "compareAndUpdateCached", "", "isInitialized", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CacheLazy<T>
  implements Lazy<T>
{
  private volatile T a;
  private volatile Object b;
  private final AtomicBoolean c;
  private final Function0<T> d;
  private final Function0<Object> e;
  
  public CacheLazy(@NotNull Function0<? extends T> paramFunction0, @Nullable Function0<? extends Object> paramFunction01)
  {
    this.d = paramFunction0;
    this.e = paramFunction01;
    paramFunction0 = this.e;
    if (paramFunction0 != null) {
      paramFunction0 = paramFunction0.invoke();
    } else {
      paramFunction0 = null;
    }
    this.b = paramFunction0;
    this.c = new AtomicBoolean(false);
  }
  
  private final void a()
  {
    if (this.c.compareAndSet(false, true))
    {
      Object localObject2 = this.b;
      Object localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((Function0)localObject1).invoke();
      } else {
        localObject1 = null;
      }
      boolean bool = Intrinsics.areEqual(localObject2, localObject1);
      this.b = localObject1;
      if (!bool) {
        this.a = null;
      }
      this.c.set(false);
      return;
    }
    this.a = null;
  }
  
  public T getValue()
  {
    a();
    Object localObject2 = this.a;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.d.invoke();
      this.a = localObject1;
    }
    return localObject1;
  }
  
  public boolean isInitialized()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.CacheLazy
 * JD-Core Version:    0.7.0.1
 */