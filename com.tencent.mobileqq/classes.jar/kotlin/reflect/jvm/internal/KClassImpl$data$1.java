package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$data$1
  extends Lambda
  implements Function0<KClassImpl<T>.Data>
{
  KClassImpl$data$1(KClassImpl paramKClassImpl)
  {
    super(0);
  }
  
  @NotNull
  public final KClassImpl<T>.Data invoke()
  {
    return new KClassImpl.Data(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.data.1
 * JD-Core Version:    0.7.0.1
 */