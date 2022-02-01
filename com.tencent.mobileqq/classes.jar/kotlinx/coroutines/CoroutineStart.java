package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public enum CoroutineStart
{
  static
  {
    CoroutineStart localCoroutineStart1 = new CoroutineStart("DEFAULT", 0);
    DEFAULT = localCoroutineStart1;
    CoroutineStart localCoroutineStart2 = new CoroutineStart("LAZY", 1);
    LAZY = localCoroutineStart2;
    CoroutineStart localCoroutineStart3 = new CoroutineStart("ATOMIC", 2);
    ATOMIC = localCoroutineStart3;
    CoroutineStart localCoroutineStart4 = new CoroutineStart("UNDISPATCHED", 3);
    UNDISPATCHED = localCoroutineStart4;
    $VALUES = new CoroutineStart[] { localCoroutineStart1, localCoroutineStart2, localCoroutineStart3, localCoroutineStart4 };
  }
  
  private CoroutineStart() {}
  
  @InternalCoroutinesApi
  public final <T> void invoke(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    int i = CoroutineStart.WhenMappings.$EnumSwitchMapping$0[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return;
          }
          throw new NoWhenBranchMatchedException();
        }
        UndispatchedKt.startCoroutineUndispatched(paramFunction1, paramContinuation);
        return;
      }
      ContinuationKt.startCoroutine(paramFunction1, paramContinuation);
      return;
    }
    CancellableKt.startCoroutineCancellable(paramFunction1, paramContinuation);
  }
  
  @InternalCoroutinesApi
  public final <R, T> void invoke(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    int i = CoroutineStart.WhenMappings.$EnumSwitchMapping$1[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return;
          }
          throw new NoWhenBranchMatchedException();
        }
        UndispatchedKt.startCoroutineUndispatched(paramFunction2, paramR, paramContinuation);
        return;
      }
      ContinuationKt.startCoroutine(paramFunction2, paramR, paramContinuation);
      return;
    }
    CancellableKt.startCoroutineCancellable(paramFunction2, paramR, paramContinuation);
  }
  
  public final boolean isLazy()
  {
    return (CoroutineStart)this == LAZY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineStart
 * JD-Core Version:    0.7.0.1
 */