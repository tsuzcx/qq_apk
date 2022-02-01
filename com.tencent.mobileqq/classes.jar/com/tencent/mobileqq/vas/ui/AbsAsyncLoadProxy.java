package com.tencent.mobileqq.vas.ui;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "T", "", "()V", "value", "currentObject", "getCurrentObject", "()Ljava/lang/Object;", "setCurrentObject", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "failedBuilder", "Lkotlin/Function0;", "getFailedBuilder", "()Lkotlin/jvm/functions/Function0;", "sucessedBuilder", "getSucessedBuilder", "build", "", "loader", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "doFailedBuilder", "doSucessedBuilder", "loadAndRefresh", "onCurrentObjectChanged", "onLoadFailed", "onLoadSucceed", "onPostLoaderTask", "block", "Loader", "LoaderCallback", "MyLoaderCallback", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract class AbsAsyncLoadProxy<T>
{
  @Nullable
  private T a;
  
  private final void a(T paramT)
  {
    if ((Intrinsics.areEqual(paramT, this.a) ^ true))
    {
      this.a = paramT;
      a();
    }
  }
  
  private final void b(AbsAsyncLoadProxy.Loader paramLoader)
  {
    AbsAsyncLoadProxy.MyLoaderCallback localMyLoaderCallback = new AbsAsyncLoadProxy.MyLoaderCallback(new WeakReference(this));
    if (!paramLoader.a())
    {
      paramLoader.a((AbsAsyncLoadProxy.LoaderCallback)localMyLoaderCallback);
      return;
    }
    localMyLoaderCallback.a();
  }
  
  private final void g()
  {
    Object localObject = f();
    if (localObject != null) {
      a(localObject);
    }
    if (this.a == null) {
      a(e());
    }
  }
  
  private final void h()
  {
    if (this.a == null) {
      a(e());
    }
  }
  
  protected abstract void a();
  
  public final void a(@NotNull AbsAsyncLoadProxy.Loader paramLoader)
  {
    Intrinsics.checkParameterIsNotNull(paramLoader, "loader");
    if (!paramLoader.a()) {
      h();
    }
    if (paramLoader.a())
    {
      b(paramLoader);
      return;
    }
    a((Function0)new AbsAsyncLoadProxy.build.1(this, paramLoader));
  }
  
  protected abstract void a(@NotNull Function0<Unit> paramFunction0);
  
  @Nullable
  public final T b()
  {
    return this.a;
  }
  
  @NotNull
  public abstract Function0<T> c();
  
  @NotNull
  public abstract Function0<T> d();
  
  @Nullable
  public final T e()
  {
    try
    {
      Object localObject = c().invoke();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  @Nullable
  public final T f()
  {
    try
    {
      Object localObject = d().invoke();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy
 * JD-Core Version:    0.7.0.1
 */