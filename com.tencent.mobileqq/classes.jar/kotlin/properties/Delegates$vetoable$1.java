package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$vetoable$1", "Lkotlin/properties/ObservableProperty;", "beforeChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Delegates$vetoable$1
  extends ObservableProperty<T>
{
  public Delegates$vetoable$1(Function3 paramFunction3, Object paramObject1, Object paramObject2)
  {
    super(paramObject2);
  }
  
  protected boolean beforeChange(@NotNull KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return ((Boolean)this.$onChange.invoke(paramKProperty, paramT1, paramT2)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.properties.Delegates.vetoable.1
 * JD-Core Version:    0.7.0.1
 */