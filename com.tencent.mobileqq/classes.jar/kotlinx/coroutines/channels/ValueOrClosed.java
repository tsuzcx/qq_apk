package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ValueOrClosed;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "closeCause", "", "closeCause$annotations", "()V", "getCloseCause-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "value", "value$annotations", "getValue-impl", "valueOrNull", "valueOrNull$annotations", "getValueOrNull-impl", "equals", "other", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Closed", "Companion", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public final class ValueOrClosed<T>
{
  public static final ValueOrClosed.Companion Companion = new ValueOrClosed.Companion(null);
  private final Object holder;
  
  @NotNull
  public static Object constructor-impl(@Nullable Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, @Nullable Object paramObject2)
  {
    return ((paramObject2 instanceof ValueOrClosed)) && (Intrinsics.areEqual(paramObject1, ((ValueOrClosed)paramObject2).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return Intrinsics.areEqual(paramObject1, paramObject2);
  }
  
  @Nullable
  public static final Throwable getCloseCause-impl(Object paramObject)
  {
    if ((paramObject instanceof ValueOrClosed.Closed)) {
      return ((ValueOrClosed.Closed)paramObject).cause;
    }
    throw ((Throwable)new IllegalStateException("Channel was not closed".toString()));
  }
  
  public static final T getValue-impl(Object paramObject)
  {
    if (!(paramObject instanceof ValueOrClosed.Closed)) {
      return paramObject;
    }
    throw ((Throwable)new IllegalStateException("Channel was closed".toString()));
  }
  
  @Nullable
  public static final T getValueOrNull-impl(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof ValueOrClosed.Closed)) {
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
  
  public static final boolean isClosed-impl(Object paramObject)
  {
    return paramObject instanceof ValueOrClosed.Closed;
  }
  
  @NotNull
  public static String toString-impl(Object paramObject)
  {
    if ((paramObject instanceof ValueOrClosed.Closed)) {
      return paramObject.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Value(");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.holder, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.holder);
  }
  
  @NotNull
  public String toString()
  {
    return toString-impl(this.holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ValueOrClosed
 * JD-Core Version:    0.7.0.1
 */