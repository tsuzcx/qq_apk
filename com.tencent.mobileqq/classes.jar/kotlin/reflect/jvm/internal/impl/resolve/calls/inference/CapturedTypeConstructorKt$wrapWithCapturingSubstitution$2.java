package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2
  extends DelegatedTypeSubstitution
{
  CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(TypeSubstitution paramTypeSubstitution1, boolean paramBoolean, TypeSubstitution paramTypeSubstitution2)
  {
    super(paramTypeSubstitution2);
  }
  
  public boolean approximateContravariantCapturedTypes()
  {
    return this.$needApproximation;
  }
  
  @Nullable
  public TypeProjection get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    TypeProjection localTypeProjection = super.get(paramKotlinType);
    Object localObject = null;
    if (localTypeProjection != null)
    {
      localObject = paramKotlinType.getConstructor().getDeclarationDescriptor();
      paramKotlinType = (KotlinType)localObject;
      if (!(localObject instanceof TypeParameterDescriptor)) {
        paramKotlinType = null;
      }
      localObject = CapturedTypeConstructorKt.access$createCapturedIfNeeded(localTypeProjection, (TypeParameterDescriptor)paramKotlinType);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.wrapWithCapturingSubstitution.2
 * JD-Core Version:    0.7.0.1
 */