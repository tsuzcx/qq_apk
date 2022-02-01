package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StarProjectionImplKt$starProjectionType$1
  extends TypeConstructorSubstitution
{
  StarProjectionImplKt$starProjectionType$1(List paramList) {}
  
  @Nullable
  public TypeProjection get(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "key");
    if (this.$typeParameters.contains(paramTypeConstructor))
    {
      paramTypeConstructor = paramTypeConstructor.getDeclarationDescriptor();
      if (paramTypeConstructor != null) {
        return TypeUtils.makeStarProjection((TypeParameterDescriptor)paramTypeConstructor);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt.starProjectionType.1
 * JD-Core Version:    0.7.0.1
 */