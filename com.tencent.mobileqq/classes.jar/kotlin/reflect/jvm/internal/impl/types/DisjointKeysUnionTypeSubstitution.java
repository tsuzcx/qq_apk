package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DisjointKeysUnionTypeSubstitution
  extends TypeSubstitution
{
  public static final DisjointKeysUnionTypeSubstitution.Companion Companion = new DisjointKeysUnionTypeSubstitution.Companion(null);
  private final TypeSubstitution first;
  private final TypeSubstitution second;
  
  private DisjointKeysUnionTypeSubstitution(TypeSubstitution paramTypeSubstitution1, TypeSubstitution paramTypeSubstitution2)
  {
    this.first = paramTypeSubstitution1;
    this.second = paramTypeSubstitution2;
  }
  
  @JvmStatic
  @NotNull
  public static final TypeSubstitution create(@NotNull TypeSubstitution paramTypeSubstitution1, @NotNull TypeSubstitution paramTypeSubstitution2)
  {
    return Companion.create(paramTypeSubstitution1, paramTypeSubstitution2);
  }
  
  public boolean approximateCapturedTypes()
  {
    return (this.first.approximateCapturedTypes()) || (this.second.approximateCapturedTypes());
  }
  
  public boolean approximateContravariantCapturedTypes()
  {
    return (this.first.approximateContravariantCapturedTypes()) || (this.second.approximateContravariantCapturedTypes());
  }
  
  @NotNull
  public Annotations filterAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    return this.second.filterAnnotations(this.first.filterAnnotations(paramAnnotations));
  }
  
  @Nullable
  public TypeProjection get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    TypeProjection localTypeProjection = this.first.get(paramKotlinType);
    if (localTypeProjection != null) {
      return localTypeProjection;
    }
    return this.second.get(paramKotlinType);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  @NotNull
  public KotlinType prepareTopLevelType(@NotNull KotlinType paramKotlinType, @NotNull Variance paramVariance)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "topLevelType");
    Intrinsics.checkParameterIsNotNull(paramVariance, "position");
    return this.second.prepareTopLevelType(this.first.prepareTopLevelType(paramKotlinType, paramVariance), paramVariance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution
 * JD-Core Version:    0.7.0.1
 */