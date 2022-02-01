package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KMutableProperty2.Setter;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty2$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "invoke", "", "receiver1", "receiver2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KMutableProperty2Impl$Setter<D, E, R>
  extends KPropertyImpl.Setter<R>
  implements KMutableProperty2.Setter<D, E, R>
{
  @NotNull
  private final KMutableProperty2Impl<D, E, R> property;
  
  public KMutableProperty2Impl$Setter(@NotNull KMutableProperty2Impl<D, E, R> paramKMutableProperty2Impl)
  {
    this.property = paramKMutableProperty2Impl;
  }
  
  @NotNull
  public KMutableProperty2Impl<D, E, R> getProperty()
  {
    return this.property;
  }
  
  public void invoke(D paramD, E paramE, R paramR)
  {
    getProperty().set(paramD, paramE, paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty2Impl.Setter
 * JD-Core Version:    0.7.0.1
 */