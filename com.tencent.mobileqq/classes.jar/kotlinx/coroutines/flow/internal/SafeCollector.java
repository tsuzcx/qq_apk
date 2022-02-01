package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class SafeCollector<T>
  extends ContinuationImpl
  implements FlowCollector<T>
{
  @JvmField
  @NotNull
  public final CoroutineContext collectContext;
  @JvmField
  public final int collectContextSize;
  @JvmField
  @NotNull
  public final FlowCollector<T> collector;
  private Continuation<? super Unit> completion;
  private CoroutineContext lastEmissionContext;
  
  public SafeCollector(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull CoroutineContext paramCoroutineContext)
  {
    super((Continuation)NoOpContinuation.INSTANCE, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
    this.collector = paramFlowCollector;
    this.collectContext = paramCoroutineContext;
    this.collectContextSize = ((Number)this.collectContext.fold(Integer.valueOf(0), (Function2)SafeCollector.collectContextSize.1.INSTANCE)).intValue();
  }
  
  private final void checkContext(CoroutineContext paramCoroutineContext1, CoroutineContext paramCoroutineContext2, T paramT)
  {
    if ((paramCoroutineContext2 instanceof DownstreamExceptionElement)) {
      exceptionTransparencyViolated((DownstreamExceptionElement)paramCoroutineContext2, paramT);
    }
    SafeCollector_commonKt.checkContext(this, paramCoroutineContext1);
    this.lastEmissionContext = paramCoroutineContext1;
  }
  
  private final Object emit(Continuation<? super Unit> paramContinuation, T paramT)
  {
    Object localObject = paramContinuation.getContext();
    CoroutineContext localCoroutineContext = this.lastEmissionContext;
    if (localCoroutineContext != localObject) {
      checkContext((CoroutineContext)localObject, localCoroutineContext, paramT);
    }
    this.completion = paramContinuation;
    paramContinuation = SafeCollectorKt.access$getEmitFun$p();
    localObject = this.collector;
    if (localObject != null) {
      return paramContinuation.invoke(localObject, paramT, (Continuation)this);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
  }
  
  private final void exceptionTransparencyViolated(DownstreamExceptionElement paramDownstreamExceptionElement, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
    localStringBuilder.append(paramDownstreamExceptionElement.e);
    localStringBuilder.append(", but then emission attempt of value '");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
    throw ((Throwable)new IllegalStateException(StringsKt.trimIndent(localStringBuilder.toString()).toString()));
  }
  
  @Nullable
  public Object emit(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    try
    {
      paramT = emit(paramContinuation, paramT);
      if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(paramContinuation);
      }
      if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramT;
      }
      return Unit.INSTANCE;
    }
    catch (Throwable paramT)
    {
      this.lastEmissionContext = ((CoroutineContext)new DownstreamExceptionElement(paramT));
      throw paramT;
    }
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    Object localObject = this.completion;
    if (localObject != null)
    {
      localObject = ((Continuation)localObject).getContext();
      if (localObject != null) {
        return localObject;
      }
    }
    return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  }
  
  @Nullable
  public Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject = Result.exceptionOrNull-impl(paramObject);
    if (localObject != null) {
      this.lastEmissionContext = ((CoroutineContext)new DownstreamExceptionElement((Throwable)localObject));
    }
    localObject = this.completion;
    if (localObject != null) {
      ((Continuation)localObject).resumeWith(paramObject);
    }
    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
  }
  
  public void releaseIntercepted()
  {
    super.releaseIntercepted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.SafeCollector
 * JD-Core Version:    0.7.0.1
 */