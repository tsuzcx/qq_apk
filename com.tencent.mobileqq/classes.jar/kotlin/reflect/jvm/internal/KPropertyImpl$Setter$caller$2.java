package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KPropertyImpl$Setter$caller$2
  extends Lambda
  implements Function0<Caller<?>>
{
  KPropertyImpl$Setter$caller$2(KPropertyImpl.Setter paramSetter)
  {
    super(0);
  }
  
  @NotNull
  public final Caller<?> invoke()
  {
    return KPropertyImplKt.access$computeCallerForAccessor(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl.Setter.caller.2
 * JD-Core Version:    0.7.0.1
 */