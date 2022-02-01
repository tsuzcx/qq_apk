package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KProperty1Impl$_getter$1
  extends Lambda
  implements Function0<KProperty1Impl.Getter<T, ? extends R>>
{
  KProperty1Impl$_getter$1(KProperty1Impl paramKProperty1Impl)
  {
    super(0);
  }
  
  @NotNull
  public final KProperty1Impl.Getter<T, R> invoke()
  {
    return new KProperty1Impl.Getter(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty1Impl._getter.1
 * JD-Core Version:    0.7.0.1
 */