package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KProperty0.Getter;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KProperty0Impl$Getter<R>
  extends KPropertyImpl.Getter<R>
  implements KProperty0.Getter<R>
{
  @NotNull
  private final KProperty0Impl<R> property;
  
  public KProperty0Impl$Getter(@NotNull KProperty0Impl<? extends R> paramKProperty0Impl)
  {
    this.property = paramKProperty0Impl;
  }
  
  @NotNull
  public KProperty0Impl<R> getProperty()
  {
    return this.property;
  }
  
  public R invoke()
  {
    return getProperty().get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty0Impl.Getter
 * JD-Core Version:    0.7.0.1
 */