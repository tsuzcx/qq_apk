package kotlin.reflect.jvm.internal.impl.types;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class FlexibleTypeWithEnhancement
  extends FlexibleType
  implements TypeWithEnhancement
{
  @NotNull
  private final KotlinType enhancement;
  @NotNull
  private final FlexibleType origin;
  
  public FlexibleTypeWithEnhancement(@NotNull FlexibleType paramFlexibleType, @NotNull KotlinType paramKotlinType)
  {
    super(paramFlexibleType.getLowerBound(), paramFlexibleType.getUpperBound());
    this.origin = paramFlexibleType;
    this.enhancement = paramKotlinType;
  }
  
  @NotNull
  public SimpleType getDelegate()
  {
    return getOrigin().getDelegate();
  }
  
  @NotNull
  public KotlinType getEnhancement()
  {
    return this.enhancement;
  }
  
  @NotNull
  public FlexibleType getOrigin()
  {
    return this.origin;
  }
  
  @NotNull
  public UnwrappedType makeNullableAsSpecified(boolean paramBoolean)
  {
    return TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(paramBoolean), (KotlinType)getEnhancement().unwrap().makeNullableAsSpecified(paramBoolean));
  }
  
  @NotNull
  public FlexibleTypeWithEnhancement refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    KotlinType localKotlinType = paramKotlinTypeRefiner.refineType((KotlinType)getOrigin());
    if (localKotlinType != null) {
      return new FlexibleTypeWithEnhancement((FlexibleType)localKotlinType, paramKotlinTypeRefiner.refineType(getEnhancement()));
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
  }
  
  @NotNull
  public String render(@NotNull DescriptorRenderer paramDescriptorRenderer, @NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRenderer, "renderer");
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "options");
    if (paramDescriptorRendererOptions.getEnhancedTypes()) {
      return paramDescriptorRenderer.renderType(getEnhancement());
    }
    return getOrigin().render(paramDescriptorRenderer, paramDescriptorRendererOptions);
  }
  
  @NotNull
  public UnwrappedType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAnnotations(paramAnnotations), getEnhancement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement
 * JD-Core Version:    0.7.0.1
 */