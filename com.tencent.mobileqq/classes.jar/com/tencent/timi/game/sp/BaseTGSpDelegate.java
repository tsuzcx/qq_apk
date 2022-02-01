package com.tencent.timi.game.sp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/sp/BaseTGSpDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "saveTag", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "field", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "saveValue", "", "value", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseTGSpDelegate<T>
  implements ReadWriteProperty<Object, T>
{
  private T a;
  private final String b;
  private final T c;
  
  public abstract T a(@NotNull String paramString, T paramT);
  
  public abstract void b(@NotNull String paramString, T paramT);
  
  public T getValue(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramObject = this.a;
    if (paramObject != null) {
      return paramObject;
    }
    return a(this.b, this.c);
  }
  
  public void setValue(@Nullable Object paramObject, @NotNull KProperty<?> paramKProperty, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    this.a = paramT;
    b(this.b, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.BaseTGSpDelegate
 * JD-Core Version:    0.7.0.1
 */