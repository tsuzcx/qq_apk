package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty1;", "T", "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function1;", "getter", "Lkotlin/reflect/KProperty1$Getter;", "getGetter", "()Lkotlin/reflect/KProperty1$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KProperty1<T, R>
  extends Function1<T, R>, KProperty<R>
{
  public abstract R get(T paramT);
  
  @SinceKotlin(version="1.1")
  @Nullable
  public abstract Object getDelegate(T paramT);
  
  @NotNull
  public abstract KProperty1.Getter<T, R> getGetter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.reflect.KProperty1
 * JD-Core Version:    0.7.0.1
 */