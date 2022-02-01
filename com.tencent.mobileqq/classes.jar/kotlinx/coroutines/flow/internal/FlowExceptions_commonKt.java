package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkIndexOverflow", "", "index", "checkOwnership", "", "Lkotlinx/coroutines/flow/internal/AbortFlowException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class FlowExceptions_commonKt
{
  @PublishedApi
  public static final int checkIndexOverflow(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw ((Throwable)new ArithmeticException("Index overflow has happened"));
  }
  
  public static final void checkOwnership(@NotNull AbortFlowException paramAbortFlowException, @NotNull FlowCollector<?> paramFlowCollector)
  {
    if (paramAbortFlowException.getOwner() == paramFlowCollector) {
      return;
    }
    throw ((Throwable)paramAbortFlowException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.FlowExceptions_commonKt
 * JD-Core Version:    0.7.0.1
 */