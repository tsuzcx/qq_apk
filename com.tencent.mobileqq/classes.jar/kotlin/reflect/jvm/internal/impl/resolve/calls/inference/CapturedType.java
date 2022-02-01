package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class CapturedType
  extends SimpleType
  implements SubtypingRepresentatives, CapturedTypeMarker
{
  @NotNull
  private final Annotations annotations;
  @NotNull
  private final CapturedTypeConstructor constructor;
  private final boolean isMarkedNullable;
  @NotNull
  private final TypeProjection typeProjection;
  
  public CapturedType(@NotNull TypeProjection paramTypeProjection, @NotNull CapturedTypeConstructor paramCapturedTypeConstructor, boolean paramBoolean, @NotNull Annotations paramAnnotations)
  {
    this.typeProjection = paramTypeProjection;
    this.constructor = paramCapturedTypeConstructor;
    this.isMarkedNullable = paramBoolean;
    this.annotations = paramAnnotations;
  }
  
  private final KotlinType representative(Variance paramVariance, KotlinType paramKotlinType)
  {
    if (this.typeProjection.getProjectionKind() == paramVariance) {
      paramKotlinType = this.typeProjection.getType();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "if (typeProjection.proje…jection.type else default");
    return paramKotlinType;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public CapturedTypeConstructor getConstructor()
  {
    return this.constructor;
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    MemberScope localMemberScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    Intrinsics.checkExpressionValueIsNotNull(localMemberScope, "ErrorUtils.createErrorSc…solution\", true\n        )");
    return localMemberScope;
  }
  
  @NotNull
  public KotlinType getSubTypeRepresentative()
  {
    Variance localVariance = Variance.OUT_VARIANCE;
    SimpleType localSimpleType = TypeUtilsKt.getBuiltIns(this).getNullableAnyType();
    Intrinsics.checkExpressionValueIsNotNull(localSimpleType, "builtIns.nullableAnyType");
    return representative(localVariance, (KotlinType)localSimpleType);
  }
  
  @NotNull
  public KotlinType getSuperTypeRepresentative()
  {
    Variance localVariance = Variance.IN_VARIANCE;
    SimpleType localSimpleType = TypeUtilsKt.getBuiltIns(this).getNothingType();
    Intrinsics.checkExpressionValueIsNotNull(localSimpleType, "builtIns.nothingType");
    return representative(localVariance, (KotlinType)localSimpleType);
  }
  
  public boolean isMarkedNullable()
  {
    return this.isMarkedNullable;
  }
  
  @NotNull
  public CapturedType makeNullableAsSpecified(boolean paramBoolean)
  {
    if (paramBoolean == isMarkedNullable()) {
      return this;
    }
    return new CapturedType(this.typeProjection, getConstructor(), paramBoolean, getAnnotations());
  }
  
  @NotNull
  public CapturedType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    paramKotlinTypeRefiner = this.typeProjection.refine(paramKotlinTypeRefiner);
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinTypeRefiner, "typeProjection.refine(kotlinTypeRefiner)");
    return new CapturedType(paramKotlinTypeRefiner, getConstructor(), isMarkedNullable(), getAnnotations());
  }
  
  @NotNull
  public CapturedType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), paramAnnotations);
  }
  
  public boolean sameTypeConstructor(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    return getConstructor() == paramKotlinType.getConstructor();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Captured(");
    localStringBuilder.append(this.typeProjection);
    localStringBuilder.append(')');
    String str;
    if (isMarkedNullable()) {
      str = "?";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType
 * JD-Core Version:    0.7.0.1
 */