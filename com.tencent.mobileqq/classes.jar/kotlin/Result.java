package kotlin;

import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public final class Result<T>
  implements Serializable
{
  public static final Result.Companion Companion = new Result.Companion(null);
  @Nullable
  private final Object value;
  
  @PublishedApi
  @NotNull
  public static Object constructor-impl(@Nullable Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, @Nullable Object paramObject2)
  {
    return ((paramObject2 instanceof Result)) && (Intrinsics.areEqual(paramObject1, ((Result)paramObject2).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return Intrinsics.areEqual(paramObject1, paramObject2);
  }
  
  @Nullable
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof Result.Failure)) {
      return ((Result.Failure)paramObject).exception;
    }
    return null;
  }
  
  @InlineOnly
  private static final T getOrNull-impl(Object paramObject)
  {
    Object localObject = paramObject;
    if (isFailure-impl(paramObject)) {
      localObject = null;
    }
    return localObject;
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof Result.Failure;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return !(paramObject instanceof Result.Failure);
  }
  
  @NotNull
  public static String toString-impl(Object paramObject)
  {
    if ((paramObject instanceof Result.Failure)) {
      return paramObject.toString();
    }
    return "Success(" + paramObject + ')';
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.value, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.value);
  }
  
  @NotNull
  public String toString()
  {
    return toString-impl(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.Result
 * JD-Core Version:    0.7.0.1
 */