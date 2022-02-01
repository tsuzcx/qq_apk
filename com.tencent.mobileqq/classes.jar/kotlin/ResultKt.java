package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ResultKt
{
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Object createFailure(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    return new Result.Failure(paramThrowable);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T> R fold(@NotNull Object paramObject, Function1<? super T, ? extends R> paramFunction1, Function1<? super Throwable, ? extends R> paramFunction11)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramFunction1.invoke(paramObject);
    }
    return paramFunction11.invoke(localThrowable);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T extends R> R getOrDefault(@NotNull Object paramObject, R paramR)
  {
    if (Result.isFailure-impl(paramObject)) {
      return paramR;
    }
    return paramObject;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T extends R> R getOrElse(@NotNull Object paramObject, Function1<? super Throwable, ? extends R> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    return paramFunction1.invoke(localThrowable);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> T getOrThrow(@NotNull Object paramObject)
  {
    throwOnFailure(paramObject);
    return paramObject;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T> Object map(@NotNull Object paramObject, Function1<? super T, ? extends R> paramFunction1)
  {
    if (Result.isSuccess-impl(paramObject))
    {
      Result.Companion localCompanion = Result.Companion;
      return Result.constructor-impl(paramFunction1.invoke(paramObject));
    }
    return Result.constructor-impl(paramObject);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T> Object mapCatching(@NotNull Object paramObject, Function1<? super T, ? extends R> paramFunction1)
  {
    if (Result.isSuccess-impl(paramObject)) {
      try
      {
        Result.Companion localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramFunction1.invoke(paramObject));
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramFunction1 = Result.Companion;
        return Result.constructor-impl(createFailure(paramObject));
      }
    }
    return Result.constructor-impl(paramObject);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Object onFailure(@NotNull Object paramObject, Function1<? super Throwable, Unit> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable != null) {
      paramFunction1.invoke(localThrowable);
    }
    return paramObject;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Object onSuccess(@NotNull Object paramObject, Function1<? super T, Unit> paramFunction1)
  {
    if (Result.isSuccess-impl(paramObject)) {
      paramFunction1.invoke(paramObject);
    }
    return paramObject;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T extends R> Object recover(@NotNull Object paramObject, Function1<? super Throwable, ? extends R> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    paramObject = Result.Companion;
    return Result.constructor-impl(paramFunction1.invoke(localThrowable));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, T extends R> Object recoverCatching(@NotNull Object paramObject, Function1<? super Throwable, ? extends R> paramFunction1)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    try
    {
      paramObject = Result.Companion;
      paramObject = Result.constructor-impl(paramFunction1.invoke(localThrowable));
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        paramFunction1 = Result.Companion;
        paramObject = Result.constructor-impl(createFailure(paramObject));
      }
    }
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T, R> Object runCatching(T paramT, Function1<? super T, ? extends R> paramFunction1)
  {
    try
    {
      Result.Companion localCompanion = Result.Companion;
      paramT = Result.constructor-impl(paramFunction1.invoke(paramT));
      return paramT;
    }
    catch (Throwable paramT)
    {
      paramFunction1 = Result.Companion;
    }
    return Result.constructor-impl(createFailure(paramT));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> Object runCatching(Function0<? extends R> paramFunction0)
  {
    try
    {
      localCompanion = Result.Companion;
      paramFunction0 = Result.constructor-impl(paramFunction0.invoke());
      return paramFunction0;
    }
    catch (Throwable paramFunction0)
    {
      Result.Companion localCompanion = Result.Companion;
    }
    return Result.constructor-impl(createFailure(paramFunction0));
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  public static final void throwOnFailure(@NotNull Object paramObject)
  {
    if ((paramObject instanceof Result.Failure)) {
      throw ((Result.Failure)paramObject).exception;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ResultKt
 * JD-Core Version:    0.7.0.1
 */