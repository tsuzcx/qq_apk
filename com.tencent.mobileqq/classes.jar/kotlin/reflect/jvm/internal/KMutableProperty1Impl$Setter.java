package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KMutableProperty1.Setter;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KMutableProperty1Impl$Setter<T, R>
  extends KPropertyImpl.Setter<R>
  implements KMutableProperty1.Setter<T, R>
{
  @NotNull
  private final KMutableProperty1Impl<T, R> property;
  
  public KMutableProperty1Impl$Setter(@NotNull KMutableProperty1Impl<T, R> paramKMutableProperty1Impl)
  {
    this.property = paramKMutableProperty1Impl;
  }
  
  @NotNull
  public KMutableProperty1Impl<T, R> getProperty()
  {
    return this.property;
  }
  
  public void invoke(T paramT, R paramR)
  {
    getProperty().set(paramT, paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty1Impl.Setter
 * JD-Core Version:    0.7.0.1
 */