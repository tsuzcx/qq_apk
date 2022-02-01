package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TypeSystemCommonBackendContext
  extends TypeSystemContext
{
  @Nullable
  public abstract FqNameUnsafe getClassFqNameUnsafe(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  @Nullable
  public abstract PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  @Nullable
  public abstract PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  @NotNull
  public abstract KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker paramTypeParameterMarker);
  
  @Nullable
  public abstract KotlinTypeMarker getSubstitutedUnderlyingType(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @Nullable
  public abstract TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean hasAnnotation(@NotNull KotlinTypeMarker paramKotlinTypeMarker, @NotNull FqName paramFqName);
  
  public abstract boolean isInlineClass(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isMarkedNullable(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  public abstract boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  @NotNull
  public abstract KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
 * JD-Core Version:    0.7.0.1
 */