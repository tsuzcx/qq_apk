package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class DebugStringsKt
{
  @NotNull
  public static final String getClassSimpleName(@NotNull Object paramObject)
  {
    return paramObject.getClass().getSimpleName();
  }
  
  @NotNull
  public static final String getHexAddress(@NotNull Object paramObject)
  {
    return Integer.toHexString(System.identityHashCode(paramObject));
  }
  
  @NotNull
  public static final String toDebugString(@NotNull Continuation<?> paramContinuation)
  {
    if ((paramContinuation instanceof DispatchedContinuation)) {
      return paramContinuation.toString();
    }
    Object localObject2;
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContinuation);
      ((StringBuilder)localObject1).append('@');
      ((StringBuilder)localObject1).append(getHexAddress(paramContinuation));
      localObject1 = Result.constructor-impl(((StringBuilder)localObject1).toString());
    }
    catch (Throwable localThrowable)
    {
      Result.Companion localCompanion = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
    }
    if (Result.exceptionOrNull-impl(localObject2) != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContinuation.getClass().getName());
      ((StringBuilder)localObject2).append('@');
      ((StringBuilder)localObject2).append(getHexAddress(paramContinuation));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DebugStringsKt
 * JD-Core Version:    0.7.0.1
 */