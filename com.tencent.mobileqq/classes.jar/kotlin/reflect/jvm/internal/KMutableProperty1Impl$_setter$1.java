package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KMutableProperty1Impl$_setter$1
  extends Lambda
  implements Function0<KMutableProperty1Impl.Setter<T, R>>
{
  KMutableProperty1Impl$_setter$1(KMutableProperty1Impl paramKMutableProperty1Impl)
  {
    super(0);
  }
  
  @NotNull
  public final KMutableProperty1Impl.Setter<T, R> invoke()
  {
    return new KMutableProperty1Impl.Setter(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty1Impl._setter.1
 * JD-Core Version:    0.7.0.1
 */