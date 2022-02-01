package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/properties/NotNullVar;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "()V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class NotNullVar<T>
  implements ReadWriteProperty<Object, T>
{
  private T value;
  
  @NotNull
  public T getValue(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramObject = this.value;
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = new StringBuilder();
    paramObject.append("Property ");
    paramObject.append(paramKProperty.getName());
    paramObject.append(" should be initialized before get.");
    throw ((Throwable)new IllegalStateException(paramObject.toString()));
  }
  
  public void setValue(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty, @NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    Intrinsics.checkParameterIsNotNull(paramT, "value");
    this.value = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.properties.NotNullVar
 * JD-Core Version:    0.7.0.1
 */