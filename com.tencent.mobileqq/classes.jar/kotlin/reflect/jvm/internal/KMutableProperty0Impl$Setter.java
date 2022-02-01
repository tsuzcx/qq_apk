package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KMutableProperty0.Setter;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "invoke", "", "value", "(Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KMutableProperty0Impl$Setter<R>
  extends KPropertyImpl.Setter<R>
  implements KMutableProperty0.Setter<R>
{
  @NotNull
  private final KMutableProperty0Impl<R> property;
  
  public KMutableProperty0Impl$Setter(@NotNull KMutableProperty0Impl<R> paramKMutableProperty0Impl)
  {
    this.property = paramKMutableProperty0Impl;
  }
  
  @NotNull
  public KMutableProperty0Impl<R> getProperty()
  {
    return this.property;
  }
  
  public void invoke(R paramR)
  {
    getProperty().set(paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty0Impl.Setter
 * JD-Core Version:    0.7.0.1
 */