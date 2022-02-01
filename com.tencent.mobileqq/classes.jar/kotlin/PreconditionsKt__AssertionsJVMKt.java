package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/PreconditionsKt")
class PreconditionsKt__AssertionsJVMKt
{
  @InlineOnly
  private static final void jdMethod_assert(boolean paramBoolean)
  {
    if ((_Assertions.ENABLED) && (!paramBoolean)) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
  }
  
  @InlineOnly
  private static final void jdMethod_assert(boolean paramBoolean, Function0<? extends Object> paramFunction0)
  {
    if ((_Assertions.ENABLED) && (!paramBoolean)) {
      throw ((Throwable)new AssertionError(paramFunction0.invoke()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.PreconditionsKt__AssertionsJVMKt
 * JD-Core Version:    0.7.0.1
 */