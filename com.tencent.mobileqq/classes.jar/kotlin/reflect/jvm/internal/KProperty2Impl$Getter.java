package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KProperty2.Getter;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KProperty2Impl$Getter<D, E, R>
  extends KPropertyImpl.Getter<R>
  implements KProperty2.Getter<D, E, R>
{
  @NotNull
  private final KProperty2Impl<D, E, R> property;
  
  public KProperty2Impl$Getter(@NotNull KProperty2Impl<D, E, ? extends R> paramKProperty2Impl)
  {
    this.property = paramKProperty2Impl;
  }
  
  @NotNull
  public KProperty2Impl<D, E, R> getProperty()
  {
    return this.property;
  }
  
  public R invoke(D paramD, E paramE)
  {
    return getProperty().get(paramD, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty2Impl.Getter
 * JD-Core Version:    0.7.0.1
 */