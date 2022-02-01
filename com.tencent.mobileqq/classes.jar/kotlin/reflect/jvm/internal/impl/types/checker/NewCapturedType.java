package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedType
  extends SimpleType
  implements CapturedTypeMarker
{
  @NotNull
  private final Annotations annotations;
  @NotNull
  private final CaptureStatus captureStatus;
  @NotNull
  private final NewCapturedTypeConstructor constructor;
  private final boolean isMarkedNullable;
  @Nullable
  private final UnwrappedType lowerType;
  
  public NewCapturedType(@NotNull CaptureStatus paramCaptureStatus, @Nullable UnwrappedType paramUnwrappedType, @NotNull TypeProjection paramTypeProjection, @NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    this(paramCaptureStatus, new NewCapturedTypeConstructor(paramTypeProjection, null, null, paramTypeParameterDescriptor, 6, null), paramUnwrappedType, null, false, 24, null);
  }
  
  public NewCapturedType(@NotNull CaptureStatus paramCaptureStatus, @NotNull NewCapturedTypeConstructor paramNewCapturedTypeConstructor, @Nullable UnwrappedType paramUnwrappedType, @NotNull Annotations paramAnnotations, boolean paramBoolean)
  {
    this.captureStatus = paramCaptureStatus;
    this.constructor = paramNewCapturedTypeConstructor;
    this.lowerType = paramUnwrappedType;
    this.annotations = paramAnnotations;
    this.isMarkedNullable = paramBoolean;
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
  public NewCapturedTypeConstructor getConstructor()
  {
    return this.constructor;
  }
  
  @Nullable
  public final UnwrappedType getLowerType()
  {
    return this.lowerType;
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    MemberScope localMemberScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
    Intrinsics.checkExpressionValueIsNotNull(localMemberScope, "ErrorUtils.createErrorSc…on captured type!\", true)");
    return localMemberScope;
  }
  
  public boolean isMarkedNullable()
  {
    return this.isMarkedNullable;
  }
  
  @NotNull
  public NewCapturedType makeNullableAsSpecified(boolean paramBoolean)
  {
    return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAnnotations(), paramBoolean);
  }
  
  @NotNull
  public NewCapturedType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    CaptureStatus localCaptureStatus = this.captureStatus;
    NewCapturedTypeConstructor localNewCapturedTypeConstructor = getConstructor().refine(paramKotlinTypeRefiner);
    UnwrappedType localUnwrappedType = this.lowerType;
    if (localUnwrappedType != null) {
      paramKotlinTypeRefiner = paramKotlinTypeRefiner.refineType((KotlinType)localUnwrappedType).unwrap();
    } else {
      paramKotlinTypeRefiner = null;
    }
    return new NewCapturedType(localCaptureStatus, localNewCapturedTypeConstructor, paramKotlinTypeRefiner, getAnnotations(), isMarkedNullable());
  }
  
  @NotNull
  public NewCapturedType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, paramAnnotations, isMarkedNullable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
 * JD-Core Version:    0.7.0.1
 */