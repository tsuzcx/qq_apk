package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty0;", "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function0;", "getter", "Lkotlin/reflect/KProperty0$Getter;", "getGetter", "()Lkotlin/reflect/KProperty0$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KProperty0<R>
  extends Function0<R>, KProperty<R>
{
  public abstract R get();
  
  @SinceKotlin(version="1.1")
  @Nullable
  public abstract Object getDelegate();
  
  @NotNull
  public abstract KProperty0.Getter<R> getGetter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.reflect.KProperty0
 * JD-Core Version:    0.7.0.1
 */