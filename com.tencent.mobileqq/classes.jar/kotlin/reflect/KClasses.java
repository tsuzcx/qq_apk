package kotlin.reflect;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cast", "T", "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="KClasses")
public final class KClasses
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @LowPriorityInOverloadResolution
  @NotNull
  public static final <T> T cast(@NotNull KClass<T> paramKClass, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$cast");
    if (paramKClass.isInstance(paramObject))
    {
      if (paramObject != null) {
        return paramObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    paramObject = new StringBuilder();
    paramObject.append("Value cannot be cast to ");
    paramObject.append(paramKClass.getQualifiedName());
    throw ((Throwable)new ClassCastException(paramObject.toString()));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @LowPriorityInOverloadResolution
  @Nullable
  public static final <T> T safeCast(@NotNull KClass<T> paramKClass, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$safeCast");
    if (paramKClass.isInstance(paramObject))
    {
      if (paramObject != null) {
        return paramObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KClasses
 * JD-Core Version:    0.7.0.1
 */