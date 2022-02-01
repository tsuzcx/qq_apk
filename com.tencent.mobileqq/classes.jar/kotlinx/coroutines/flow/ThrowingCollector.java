package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/ThrowingCollector;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "e", "", "(Ljava/lang/Throwable;)V", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ThrowingCollector
  implements FlowCollector<Object>
{
  private final Throwable e;
  
  public ThrowingCollector(@NotNull Throwable paramThrowable)
  {
    this.e = paramThrowable;
  }
  
  @Nullable
  public Object emit(@Nullable Object paramObject, @NotNull Continuation<? super Unit> paramContinuation)
  {
    throw this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.ThrowingCollector
 * JD-Core Version:    0.7.0.1
 */