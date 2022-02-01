package kotlin.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KMutableProperty0;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty0$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty0$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KMutableProperty0<R>
  extends KMutableProperty<R>, KProperty0<R>
{
  @NotNull
  public abstract KMutableProperty0.Setter<R> getSetter();
  
  public abstract void set(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.reflect.KMutableProperty0
 * JD-Core Version:    0.7.0.1
 */