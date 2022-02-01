package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DelegatedTypeSubstitution
  extends TypeSubstitution
{
  @NotNull
  private final TypeSubstitution substitution;
  
  public DelegatedTypeSubstitution(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    this.substitution = paramTypeSubstitution;
  }
  
  public boolean approximateCapturedTypes()
  {
    return this.substitution.approximateCapturedTypes();
  }
  
  public boolean approximateContravariantCapturedTypes()
  {
    return this.substitution.approximateContravariantCapturedTypes();
  }
  
  @NotNull
  public Annotations filterAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    return this.substitution.filterAnnotations(paramAnnotations);
  }
  
  @Nullable
  public TypeProjection get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    return this.substitution.get(paramKotlinType);
  }
  
  public boolean isEmpty()
  {
    return this.substitution.isEmpty();
  }
  
  @NotNull
  public KotlinType prepareTopLevelType(@NotNull KotlinType paramKotlinType, @NotNull Variance paramVariance)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "topLevelType");
    Intrinsics.checkParameterIsNotNull(paramVariance, "position");
    return this.substitution.prepareTopLevelType(paramKotlinType, paramVariance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution
 * JD-Core Version:    0.7.0.1
 */