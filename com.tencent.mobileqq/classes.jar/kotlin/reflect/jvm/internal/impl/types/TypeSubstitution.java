package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeSubstitution
{
  public static final TypeSubstitution.Companion Companion = new TypeSubstitution.Companion(null);
  @JvmField
  @NotNull
  public static final TypeSubstitution EMPTY = (TypeSubstitution)new TypeSubstitution.Companion.EMPTY.1();
  
  public boolean approximateCapturedTypes()
  {
    return false;
  }
  
  public boolean approximateContravariantCapturedTypes()
  {
    return false;
  }
  
  @NotNull
  public final TypeSubstitutor buildSubstitutor()
  {
    TypeSubstitutor localTypeSubstitutor = TypeSubstitutor.create(this);
    Intrinsics.checkExpressionValueIsNotNull(localTypeSubstitutor, "TypeSubstitutor.create(this)");
    return localTypeSubstitutor;
  }
  
  @NotNull
  public Annotations filterAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    return paramAnnotations;
  }
  
  @Nullable
  public abstract TypeProjection get(@NotNull KotlinType paramKotlinType);
  
  public boolean isEmpty()
  {
    return false;
  }
  
  @NotNull
  public KotlinType prepareTopLevelType(@NotNull KotlinType paramKotlinType, @NotNull Variance paramVariance)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "topLevelType");
    Intrinsics.checkParameterIsNotNull(paramVariance, "position");
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
 * JD-Core Version:    0.7.0.1
 */