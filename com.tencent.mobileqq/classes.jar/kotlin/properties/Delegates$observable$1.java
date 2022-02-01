package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Delegates$observable$1
  extends ObservableProperty<T>
{
  public Delegates$observable$1(Function3 paramFunction3, Object paramObject1, Object paramObject2)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    this.$onChange.invoke(paramKProperty, paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.properties.Delegates.observable.1
 * JD-Core Version:    0.7.0.1
 */