package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"callSuspendBy", "", "R", "Lkotlin/reflect/KCallable;", "args", "", "Lkotlin/reflect/KParameter;", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlin.reflect.full.KCallables", f="KCallables.kt", i={0, 0, 0}, l={73}, m="callSuspendBy", n={"$this$callSuspendBy", "args", "kCallable"}, s={"L$0", "L$1", "L$2"})
final class KCallables$callSuspendBy$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  
  KCallables$callSuspendBy$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return KCallables.callSuspendBy(null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KCallables.callSuspendBy.1
 * JD-Core Version:    0.7.0.1
 */