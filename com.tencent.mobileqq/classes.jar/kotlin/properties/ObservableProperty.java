package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class ObservableProperty<T>
  implements ReadWriteProperty<Object, T>
{
  private T value;
  
  public ObservableProperty(T paramT)
  {
    this.value = paramT;
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
  }
  
  protected boolean beforeChange(@NotNull KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return true;
  }
  
  public T getValue(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return this.value;
  }
  
  public void setValue(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramObject = this.value;
    if (!beforeChange(paramKProperty, paramObject, paramT)) {
      return;
    }
    this.value = paramT;
    afterChange(paramKProperty, paramObject, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.properties.ObservableProperty
 * JD-Core Version:    0.7.0.1
 */