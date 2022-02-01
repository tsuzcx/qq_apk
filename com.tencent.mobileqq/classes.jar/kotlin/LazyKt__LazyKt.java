package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"lazyOf", "Lkotlin/Lazy;", "T", "value", "(Ljava/lang/Object;)Lkotlin/Lazy;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/LazyKt")
class LazyKt__LazyKt
  extends LazyKt__LazyJVMKt
{
  @InlineOnly
  private static final <T> T getValue(@NotNull Lazy<? extends T> paramLazy, Object paramObject, KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramLazy, "$this$getValue");
    return paramLazy.getValue();
  }
  
  @NotNull
  public static final <T> Lazy<T> lazyOf(T paramT)
  {
    return (Lazy)new InitializedLazyImpl(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.LazyKt__LazyKt
 * JD-Core Version:    0.7.0.1
 */