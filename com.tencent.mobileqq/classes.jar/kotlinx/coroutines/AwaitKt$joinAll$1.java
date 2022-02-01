package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"joinAll", "", "jobs", "", "Lkotlinx/coroutines/Job;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.AwaitKt", f="Await.kt", i={0, 0, 0, 0}, l={47}, m="joinAll", n={"jobs", "$this$forEach$iv", "element$iv", "it"}, s={"L$0", "L$1", "L$3", "L$4"})
final class AwaitKt$joinAll$1
  extends ContinuationImpl
{
  int I$0;
  int I$1;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  
  AwaitKt$joinAll$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return AwaitKt.joinAll(null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.AwaitKt.joinAll.1
 * JD-Core Version:    0.7.0.1
 */