package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class DynamicType
  extends FlexibleType
  implements DynamicTypeMarker
{
  @NotNull
  private final Annotations annotations;
  
  public DynamicType(@NotNull KotlinBuiltIns paramKotlinBuiltIns, @NotNull Annotations paramAnnotations)
  {
    super(localSimpleType, paramKotlinBuiltIns);
    this.annotations = paramAnnotations;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  @NotNull
  public SimpleType getDelegate()
  {
    return getUpperBound();
  }
  
  public boolean isMarkedNullable()
  {
    return false;
  }
  
  @NotNull
  public DynamicType makeNullableAsSpecified(boolean paramBoolean)
  {
    return this;
  }
  
  @NotNull
  public DynamicType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this;
  }
  
  @NotNull
  public String render(@NotNull DescriptorRenderer paramDescriptorRenderer, @NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRenderer, "renderer");
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "options");
    return "dynamic";
  }
  
  @NotNull
  public DynamicType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new DynamicType(TypeUtilsKt.getBuiltIns((KotlinType)getDelegate()), paramAnnotations);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DynamicType
 * JD-Core Version:    0.7.0.1
 */