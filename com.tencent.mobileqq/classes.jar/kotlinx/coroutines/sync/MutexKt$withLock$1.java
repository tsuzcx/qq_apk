package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"withLock", "", "T", "Lkotlinx/coroutines/sync/Mutex;", "owner", "action", "Lkotlin/Function0;", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.sync.MutexKt", f="Mutex.kt", i={0, 0, 0}, l={110}, m="withLock", n={"$this$withLock", "owner", "action"}, s={"L$0", "L$1", "L$2"})
public final class MutexKt$withLock$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  
  public MutexKt$withLock$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return MutexKt.withLock(null, null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexKt.withLock.1
 * JD-Core Version:    0.7.0.1
 */