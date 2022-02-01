package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KProperty0Impl$delegateFieldValue$1
  extends Lambda
  implements Function0<Object>
{
  KProperty0Impl$delegateFieldValue$1(KProperty0Impl paramKProperty0Impl)
  {
    super(0);
  }
  
  @Nullable
  public final Object invoke()
  {
    KProperty0Impl localKProperty0Impl = this.this$0;
    return localKProperty0Impl.getDelegate(localKProperty0Impl.computeDelegateField(), this.this$0.getBoundReceiver());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty0Impl.delegateFieldValue.1
 * JD-Core Version:    0.7.0.1
 */