package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class CoroutineContext$DefaultImpls
{
  @NotNull
  public static CoroutineContext plus(CoroutineContext paramCoroutineContext1, @NotNull CoroutineContext paramCoroutineContext2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext2, "context");
    if (paramCoroutineContext2 == EmptyCoroutineContext.INSTANCE) {
      return paramCoroutineContext1;
    }
    return (CoroutineContext)paramCoroutineContext2.fold(paramCoroutineContext1, (Function2)CoroutineContext.plus.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.experimental.CoroutineContext.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */