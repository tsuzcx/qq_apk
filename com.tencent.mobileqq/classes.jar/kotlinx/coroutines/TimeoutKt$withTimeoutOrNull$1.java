package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"withTimeoutOrNull", "", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "continuation"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.TimeoutKt", f="Timeout.kt", i={0, 0, 0}, l={54}, m="withTimeoutOrNull", n={"timeMillis", "block", "coroutine"}, s={"J$0", "L$0", "L$1"})
final class TimeoutKt$withTimeoutOrNull$1
  extends ContinuationImpl
{
  long J$0;
  Object L$0;
  Object L$1;
  int label;
  
  TimeoutKt$withTimeoutOrNull$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return TimeoutKt.withTimeoutOrNull(0L, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1
 * JD-Core Version:    0.7.0.1
 */