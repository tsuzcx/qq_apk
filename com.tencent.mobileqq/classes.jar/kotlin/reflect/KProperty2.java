package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty2;", "D", "E", "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function2;", "getter", "Lkotlin/reflect/KProperty2$Getter;", "getGetter", "()Lkotlin/reflect/KProperty2$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KProperty2<D, E, R>
  extends Function2<D, E, R>, KProperty<R>
{
  public abstract R get(D paramD, E paramE);
  
  @SinceKotlin(version="1.1")
  @Nullable
  public abstract Object getDelegate(D paramD, E paramE);
  
  @NotNull
  public abstract KProperty2.Getter<D, E, R> getGetter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KProperty2
 * JD-Core Version:    0.7.0.1
 */