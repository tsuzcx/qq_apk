package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "p1", "Lkotlinx/coroutines/flow/FlowCollector;", "", "p2", "Lkotlin/ParameterName;", "name", "value", "invoke", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class SafeCollectorKt$emitFun$1
  extends FunctionReference
  implements SuspendFunction, Function3<FlowCollector<? super Object>, Object, Continuation<? super Unit>, Object>
{
  public final String getName() {}
  
  public final KDeclarationContainer getOwner() {}
  
  public final String getSignature() {}
  
  @Nullable
  public final Object invoke(@NotNull FlowCollector<Object> arg1, @Nullable Object arg2, @NotNull Continuation<? super Unit> arg3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.SafeCollectorKt.emitFun.1
 * JD-Core Version:    0.7.0.1
 */