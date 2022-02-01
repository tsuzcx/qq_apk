package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/StandardKt")
class StandardKt__SynchronizedKt
  extends StandardKt__StandardKt
{
  @InlineOnly
  private static final <R> R jdMethod_synchronized(Object paramObject, Function0<? extends R> paramFunction0)
  {
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      InlineMarker.finallyEnd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.StandardKt__SynchronizedKt
 * JD-Core Version:    0.7.0.1
 */