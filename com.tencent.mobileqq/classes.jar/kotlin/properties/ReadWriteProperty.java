package kotlin.properties;

import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/properties/ReadWriteProperty;", "R", "T", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface ReadWriteProperty<R, T>
{
  public abstract T getValue(R paramR, @NotNull KProperty<?> paramKProperty);
  
  public abstract void setValue(R paramR, @NotNull KProperty<?> paramKProperty, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.properties.ReadWriteProperty
 * JD-Core Version:    0.7.0.1
 */