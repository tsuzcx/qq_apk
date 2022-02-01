package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KProperty1.Getter;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KProperty1Impl$Getter<T, R>
  extends KPropertyImpl.Getter<R>
  implements KProperty1.Getter<T, R>
{
  @NotNull
  private final KProperty1Impl<T, R> property;
  
  public KProperty1Impl$Getter(@NotNull KProperty1Impl<T, ? extends R> paramKProperty1Impl)
  {
    this.property = paramKProperty1Impl;
  }
  
  @NotNull
  public KProperty1Impl<T, R> getProperty()
  {
    return this.property;
  }
  
  public R invoke(T paramT)
  {
    return getProperty().get(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty1Impl.Getter
 * JD-Core Version:    0.7.0.1
 */