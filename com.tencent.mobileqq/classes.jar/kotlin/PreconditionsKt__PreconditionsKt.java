package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"check", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "error", "", "message", "require", "requireNotNull", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/PreconditionsKt")
class PreconditionsKt__PreconditionsKt
  extends PreconditionsKt__AssertionsJVMKt
{
  @InlineOnly
  private static final void check(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  @InlineOnly
  private static final void check(boolean paramBoolean, Function0<? extends Object> paramFunction0)
  {
    if (paramBoolean) {
      return;
    }
    throw ((Throwable)new IllegalStateException(paramFunction0.invoke().toString()));
  }
  
  @InlineOnly
  private static final <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw ((Throwable)new IllegalStateException("Required value was null.".toString()));
  }
  
  @InlineOnly
  private static final <T> T checkNotNull(T paramT, Function0<? extends Object> paramFunction0)
  {
    if (paramT != null) {
      return paramT;
    }
    throw ((Throwable)new IllegalStateException(paramFunction0.invoke().toString()));
  }
  
  @InlineOnly
  private static final Void error(Object paramObject)
  {
    throw ((Throwable)new IllegalStateException(paramObject.toString()));
  }
  
  @InlineOnly
  private static final void require(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  @InlineOnly
  private static final void require(boolean paramBoolean, Function0<? extends Object> paramFunction0)
  {
    if (paramBoolean) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException(paramFunction0.invoke().toString()));
  }
  
  @InlineOnly
  private static final <T> T requireNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw ((Throwable)new IllegalArgumentException("Required value was null.".toString()));
  }
  
  @InlineOnly
  private static final <T> T requireNotNull(T paramT, Function0<? extends Object> paramFunction0)
  {
    if (paramT != null) {
      return paramT;
    }
    throw ((Throwable)new IllegalArgumentException(paramFunction0.invoke().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.PreconditionsKt__PreconditionsKt
 * JD-Core Version:    0.7.0.1
 */