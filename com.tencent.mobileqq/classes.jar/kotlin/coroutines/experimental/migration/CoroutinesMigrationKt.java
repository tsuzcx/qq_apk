package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toContinuation", "Lkotlin/coroutines/Continuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "toContinuationInterceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "toExperimentalContinuation", "toExperimentalContinuationInterceptor", "toExperimentalCoroutineContext", "toExperimentalSuspendFunction", "Lkotlin/Function3;", "T1", "T2", "R", "", "Lkotlin/Function2;", "Lkotlin/Function1;", "kotlin-stdlib-coroutines"}, k=2, mv={1, 1, 16})
public final class CoroutinesMigrationKt
{
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> kotlin.coroutines.Continuation<T> toContinuation(@NotNull kotlin.coroutines.experimental.Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "$this$toContinuation");
    if (!(paramContinuation instanceof ExperimentalContinuationMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuation;
    }
    Object localObject = (ExperimentalContinuationMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ExperimentalContinuationMigration)localObject).getContinuation();
      if (localObject != null) {
        return localObject;
      }
    }
    return (kotlin.coroutines.Continuation)new ContinuationMigration(paramContinuation);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final kotlin.coroutines.ContinuationInterceptor toContinuationInterceptor(@NotNull kotlin.coroutines.experimental.ContinuationInterceptor paramContinuationInterceptor)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuationInterceptor, "$this$toContinuationInterceptor");
    if (!(paramContinuationInterceptor instanceof ExperimentalContinuationInterceptorMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuationInterceptor;
    }
    Object localObject = (ExperimentalContinuationInterceptorMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ExperimentalContinuationInterceptorMigration)localObject).getInterceptor();
      if (localObject != null) {
        return localObject;
      }
    }
    return (kotlin.coroutines.ContinuationInterceptor)new ContinuationInterceptorMigration(paramContinuationInterceptor);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final kotlin.coroutines.CoroutineContext toCoroutineContext(@NotNull kotlin.coroutines.experimental.CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "$this$toCoroutineContext");
    kotlin.coroutines.experimental.ContinuationInterceptor localContinuationInterceptor = (kotlin.coroutines.experimental.ContinuationInterceptor)paramCoroutineContext.get((kotlin.coroutines.experimental.CoroutineContext.Key)kotlin.coroutines.experimental.ContinuationInterceptor.Key);
    ExperimentalContextMigration localExperimentalContextMigration = (ExperimentalContextMigration)paramCoroutineContext.get((kotlin.coroutines.experimental.CoroutineContext.Key)ExperimentalContextMigration.Key);
    kotlin.coroutines.experimental.CoroutineContext localCoroutineContext = paramCoroutineContext.minusKey((kotlin.coroutines.experimental.CoroutineContext.Key)kotlin.coroutines.experimental.ContinuationInterceptor.Key).minusKey((kotlin.coroutines.experimental.CoroutineContext.Key)ExperimentalContextMigration.Key);
    if (localExperimentalContextMigration != null)
    {
      paramCoroutineContext = localExperimentalContextMigration.getContext();
      if (paramCoroutineContext != null) {}
    }
    else
    {
      paramCoroutineContext = (kotlin.coroutines.CoroutineContext)kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
    }
    if (localCoroutineContext != kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE) {
      paramCoroutineContext = paramCoroutineContext.plus((kotlin.coroutines.CoroutineContext)new ContextMigration(localCoroutineContext));
    }
    if (localContinuationInterceptor == null) {
      return paramCoroutineContext;
    }
    return paramCoroutineContext.plus((kotlin.coroutines.CoroutineContext)toContinuationInterceptor(localContinuationInterceptor));
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> kotlin.coroutines.experimental.Continuation<T> toExperimentalContinuation(@NotNull kotlin.coroutines.Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "$this$toExperimentalContinuation");
    if (!(paramContinuation instanceof ContinuationMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuation;
    }
    Object localObject = (ContinuationMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ContinuationMigration)localObject).getContinuation();
      if (localObject != null) {
        return localObject;
      }
    }
    return (kotlin.coroutines.experimental.Continuation)new ExperimentalContinuationMigration(paramContinuation);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final kotlin.coroutines.experimental.ContinuationInterceptor toExperimentalContinuationInterceptor(@NotNull kotlin.coroutines.ContinuationInterceptor paramContinuationInterceptor)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuationInterceptor, "$this$toExperimentalContinuationInterceptor");
    if (!(paramContinuationInterceptor instanceof ContinuationInterceptorMigration)) {
      localObject = null;
    } else {
      localObject = paramContinuationInterceptor;
    }
    Object localObject = (ContinuationInterceptorMigration)localObject;
    if (localObject != null)
    {
      localObject = ((ContinuationInterceptorMigration)localObject).getInterceptor();
      if (localObject != null) {
        return localObject;
      }
    }
    return (kotlin.coroutines.experimental.ContinuationInterceptor)new ExperimentalContinuationInterceptorMigration(paramContinuationInterceptor);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final kotlin.coroutines.experimental.CoroutineContext toExperimentalCoroutineContext(@NotNull kotlin.coroutines.CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "$this$toExperimentalCoroutineContext");
    kotlin.coroutines.ContinuationInterceptor localContinuationInterceptor = (kotlin.coroutines.ContinuationInterceptor)paramCoroutineContext.get((kotlin.coroutines.CoroutineContext.Key)kotlin.coroutines.ContinuationInterceptor.Key);
    ContextMigration localContextMigration = (ContextMigration)paramCoroutineContext.get((kotlin.coroutines.CoroutineContext.Key)ContextMigration.Key);
    kotlin.coroutines.CoroutineContext localCoroutineContext = paramCoroutineContext.minusKey((kotlin.coroutines.CoroutineContext.Key)kotlin.coroutines.ContinuationInterceptor.Key).minusKey((kotlin.coroutines.CoroutineContext.Key)ContextMigration.Key);
    if (localContextMigration != null)
    {
      paramCoroutineContext = localContextMigration.getContext();
      if (paramCoroutineContext != null) {}
    }
    else
    {
      paramCoroutineContext = (kotlin.coroutines.experimental.CoroutineContext)kotlin.coroutines.experimental.EmptyCoroutineContext.INSTANCE;
    }
    if (localCoroutineContext != kotlin.coroutines.EmptyCoroutineContext.INSTANCE) {
      paramCoroutineContext = paramCoroutineContext.plus((kotlin.coroutines.experimental.CoroutineContext)new ExperimentalContextMigration(localCoroutineContext));
    }
    if (localContinuationInterceptor == null) {
      return paramCoroutineContext;
    }
    return paramCoroutineContext.plus((kotlin.coroutines.experimental.CoroutineContext)toExperimentalContinuationInterceptor(localContinuationInterceptor));
  }
  
  @NotNull
  public static final <R> Function1<kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(@NotNull Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "$this$toExperimentalSuspendFunction");
    return (Function1)new ExperimentalSuspendFunction0Migration(paramFunction1);
  }
  
  @NotNull
  public static final <T1, R> Function2<T1, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(@NotNull Function2<? super T1, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "$this$toExperimentalSuspendFunction");
    return (Function2)new ExperimentalSuspendFunction1Migration(paramFunction2);
  }
  
  @NotNull
  public static final <T1, T2, R> Function3<T1, T2, kotlin.coroutines.experimental.Continuation<? super R>, Object> toExperimentalSuspendFunction(@NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "$this$toExperimentalSuspendFunction");
    return (Function3)new ExperimentalSuspendFunction2Migration(paramFunction3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.CoroutinesMigrationKt
 * JD-Core Version:    0.7.0.1
 */