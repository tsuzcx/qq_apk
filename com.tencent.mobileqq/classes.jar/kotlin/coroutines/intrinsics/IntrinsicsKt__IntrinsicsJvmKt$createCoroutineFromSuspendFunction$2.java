package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
  extends ContinuationImpl
{
  private int label;
  
  public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(Function1 paramFunction1, Continuation paramContinuation1, CoroutineContext paramCoroutineContext1, Continuation paramContinuation2, CoroutineContext paramCoroutineContext2)
  {
    super(paramContinuation2, paramCoroutineContext2);
  }
  
  @Nullable
  public Object invokeSuspend(@NotNull Object paramObject)
  {
    switch (this.label)
    {
    default: 
      throw ((Throwable)new IllegalStateException("This coroutine had already completed".toString()));
    case 0: 
      this.label = 1;
      ResultKt.throwOnFailure(paramObject);
      return this.$block.invoke(this);
    }
    this.label = 2;
    ResultKt.throwOnFailure(paramObject);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineFromSuspendFunction.2
 * JD-Core Version:    0.7.0.1
 */