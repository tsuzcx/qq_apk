package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"callSuspend", "", "R", "Lkotlin/reflect/KCallable;", "args", "", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.reflect.full.KCallables", f="KCallables.kt", i={0, 0}, l={55}, m="callSuspend", n={"$this$callSuspend", "args"}, s={"L$0", "L$1"})
final class KCallables$callSuspend$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  int label;
  
  KCallables$callSuspend$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return KCallables.callSuspend(null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KCallables.callSuspend.1
 * JD-Core Version:    0.7.0.1
 */