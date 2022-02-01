package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KMutableProperty0Impl$_setter$1
  extends Lambda
  implements Function0<KMutableProperty0Impl.Setter<R>>
{
  KMutableProperty0Impl$_setter$1(KMutableProperty0Impl paramKMutableProperty0Impl)
  {
    super(0);
  }
  
  @NotNull
  public final KMutableProperty0Impl.Setter<R> invoke()
  {
    return new KMutableProperty0Impl.Setter(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty0Impl._setter.1
 * JD-Core Version:    0.7.0.1
 */