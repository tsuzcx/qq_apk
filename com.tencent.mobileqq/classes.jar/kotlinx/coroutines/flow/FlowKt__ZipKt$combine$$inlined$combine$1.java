package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2"}, k=1, mv={1, 1, 16})
public final class FlowKt__ZipKt$combine$$inlined$combine$1
  implements Flow<R>
{
  public FlowKt__ZipKt$combine$$inlined$combine$1(Flow[] paramArrayOfFlow, Function4 paramFunction4) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    paramFlowCollector = CombineKt.combineInternal(paramFlowCollector, this.$flows$inlined, (Function0)new FlowKt__ZipKt.combine..inlined.combine.1.2(this), (Function3)new FlowKt__ZipKt.combine..inlined.combine.1.3(null, this), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object collect$$forInline(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__ZipKt.combine..inlined.combine.1.1(this, paramContinuation);
    InlineMarker.mark(5);
    Flow[] arrayOfFlow = this.$flows$inlined;
    Function0 localFunction0 = (Function0)new FlowKt__ZipKt.combine..inlined.combine.1.2(this);
    Function3 localFunction3 = (Function3)new FlowKt__ZipKt.combine..inlined.combine.1.3(null, this);
    InlineMarker.mark(0);
    CombineKt.combineInternal(paramFlowCollector, arrayOfFlow, localFunction0, localFunction3, paramContinuation);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combine.1
 * JD-Core Version:    0.7.0.1
 */