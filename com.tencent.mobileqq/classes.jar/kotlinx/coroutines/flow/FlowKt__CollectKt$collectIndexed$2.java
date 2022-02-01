package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "index", "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__CollectKt$collectIndexed$2
  implements FlowCollector<T>
{
  private int index;
  
  public FlowKt__CollectKt$collectIndexed$2(Function3 paramFunction3) {}
  
  @Nullable
  public Object emit(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    Function3 localFunction3 = this.$action;
    int i = this.index;
    this.index = (i + 1);
    if (i >= 0) {
      return localFunction3.invoke(Boxing.boxInt(i), paramT, paramContinuation);
    }
    throw ((Throwable)new ArithmeticException("Index overflow has happened"));
  }
  
  @Nullable
  public Object emit$$forInline(Object paramObject, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__CollectKt.collectIndexed.2.emit.1(this, paramContinuation);
    InlineMarker.mark(5);
    Function3 localFunction3 = this.$action;
    int i = this.index;
    this.index = (i + 1);
    if (i >= 0) {
      return localFunction3.invoke(Integer.valueOf(i), paramObject, paramContinuation);
    }
    throw ((Throwable)new ArithmeticException("Index overflow has happened"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__CollectKt.collectIndexed.2
 * JD-Core Version:    0.7.0.1
 */