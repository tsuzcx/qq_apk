package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class TypeSystemCommonBackendContext$DefaultImpls
{
  public static boolean isMarkedNullable(TypeSystemCommonBackendContext paramTypeSystemCommonBackendContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isMarkedNullable");
    return ((paramKotlinTypeMarker instanceof SimpleTypeMarker)) && (paramTypeSystemCommonBackendContext.isMarkedNullable((SimpleTypeMarker)paramKotlinTypeMarker));
  }
  
  @NotNull
  public static KotlinTypeMarker makeNullable(TypeSystemCommonBackendContext paramTypeSystemCommonBackendContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$makeNullable");
    SimpleTypeMarker localSimpleTypeMarker = paramTypeSystemCommonBackendContext.asSimpleType(paramKotlinTypeMarker);
    KotlinTypeMarker localKotlinTypeMarker = paramKotlinTypeMarker;
    if (localSimpleTypeMarker != null)
    {
      paramTypeSystemCommonBackendContext = paramTypeSystemCommonBackendContext.withNullability(localSimpleTypeMarker, true);
      localKotlinTypeMarker = paramKotlinTypeMarker;
      if (paramTypeSystemCommonBackendContext != null) {
        localKotlinTypeMarker = (KotlinTypeMarker)paramTypeSystemCommonBackendContext;
      }
    }
    return localKotlinTypeMarker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */