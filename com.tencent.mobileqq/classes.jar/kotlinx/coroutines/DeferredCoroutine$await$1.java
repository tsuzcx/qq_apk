package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.DeferredCoroutine", f="Builders.common.kt", i={0}, l={99}, m="await$suspendImpl", n={"this"}, s={"L$0"})
final class DeferredCoroutine$await$1
  extends ContinuationImpl
{
  Object L$0;
  int label;
  
  DeferredCoroutine$await$1(DeferredCoroutine paramDeferredCoroutine, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return DeferredCoroutine.await$suspendImpl(this.this$0, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DeferredCoroutine.await.1
 * JD-Core Version:    0.7.0.1
 */