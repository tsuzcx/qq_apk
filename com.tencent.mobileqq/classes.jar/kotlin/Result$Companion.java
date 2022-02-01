package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Result$Companion
{
  @InlineOnly
  private final <T> Object failure(Throwable paramThrowable)
  {
    return Result.constructor-impl(ResultKt.createFailure(paramThrowable));
  }
  
  @InlineOnly
  private final <T> Object success(T paramT)
  {
    return Result.constructor-impl(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.Result.Companion
 * JD-Core Version:    0.7.0.1
 */