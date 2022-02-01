package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"withPermit", "", "T", "Lkotlinx/coroutines/sync/Semaphore;", "action", "Lkotlin/Function0;", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.sync.SemaphoreKt", f="Semaphore.kt", i={0, 0}, l={79}, m="withPermit", n={"$this$withPermit", "action"}, s={"L$0", "L$1"})
public final class SemaphoreKt$withPermit$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  int label;
  
  public SemaphoreKt$withPermit$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return SemaphoreKt.withPermit(null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.SemaphoreKt.withPermit.1
 * JD-Core Version:    0.7.0.1
 */