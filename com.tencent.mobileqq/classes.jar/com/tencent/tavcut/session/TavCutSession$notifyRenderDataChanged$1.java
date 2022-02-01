package com.tencent.tavcut.session;

import com.tencent.tavcut.composition.dataprocessor.RenderDataManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.tavcut.session.TavCutSession$notifyRenderDataChanged$1", f="TavCutSession.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class TavCutSession$notifyRenderDataChanged$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  int label;
  private CoroutineScope p$;
  
  TavCutSession$notifyRenderDataChanged$1(TavCutSession paramTavCutSession, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.this$0, paramContinuation);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.label == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      paramObject = TavCutSession.b(this.this$0).c();
      if (paramObject != null)
      {
        Iterator localIterator = ((Iterable)TavCutSession.e(this.this$0)).iterator();
        while (localIterator.hasNext()) {
          ((ISessionListener)localIterator.next()).a(paramObject);
        }
      }
      return Unit.INSTANCE;
    }
    paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession.notifyRenderDataChanged.1
 * JD-Core Version:    0.7.0.1
 */