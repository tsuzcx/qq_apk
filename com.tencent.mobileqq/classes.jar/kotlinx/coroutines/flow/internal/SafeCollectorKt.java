package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emitFun", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "", "emitFun$annotations", "()V", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class SafeCollectorKt
{
  private static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> emitFun = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(new SafeCollectorKt.emitFun.1(), 3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.SafeCollectorKt
 * JD-Core Version:    0.7.0.1
 */