package kotlin.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KMutableProperty;", "R", "Lkotlin/reflect/KProperty;", "setter", "Lkotlin/reflect/KMutableProperty$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty$Setter;", "Setter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KMutableProperty<R>
  extends KProperty<R>
{
  @NotNull
  public abstract KMutableProperty.Setter<R> getSetter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KMutableProperty
 * JD-Core Version:    0.7.0.1
 */