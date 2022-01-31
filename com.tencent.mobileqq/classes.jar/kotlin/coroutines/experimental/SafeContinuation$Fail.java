package kotlin.coroutines.experimental;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/SafeContinuation$Fail;", "", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class SafeContinuation$Fail
{
  @NotNull
  private final Throwable exception;
  
  public SafeContinuation$Fail(@NotNull Throwable paramThrowable)
  {
    this.exception = paramThrowable;
  }
  
  @NotNull
  public final Throwable getException()
  {
    return this.exception;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.experimental.SafeContinuation.Fail
 * JD-Core Version:    0.7.0.1
 */