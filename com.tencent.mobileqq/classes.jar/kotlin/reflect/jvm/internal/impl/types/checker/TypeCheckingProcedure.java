package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeCheckingProcedure
{
  private final TypeCheckingProcedureCallbacks constraints;
  
  public TypeCheckingProcedure(TypeCheckingProcedureCallbacks paramTypeCheckingProcedureCallbacks)
  {
    this.constraints = paramTypeCheckingProcedureCallbacks;
  }
  
  private boolean capture(@NotNull TypeProjection paramTypeProjection1, @NotNull TypeProjection paramTypeProjection2, @NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    if (paramTypeProjection1 == null) {
      $$$reportNull$$$0(19);
    }
    if (paramTypeProjection2 == null) {
      $$$reportNull$$$0(20);
    }
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(21);
    }
    if (paramTypeParameterDescriptor.getVariance() != Variance.INVARIANT) {
      return false;
    }
    if ((paramTypeProjection1.getProjectionKind() != Variance.INVARIANT) && (paramTypeProjection2.getProjectionKind() == Variance.INVARIANT)) {
      return this.constraints.capture(paramTypeProjection2.getType(), paramTypeProjection1);
    }
    return false;
  }
  
  private boolean checkSubtypeForTheSameConstructor(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(17);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(18);
    }
    Object localObject1 = paramKotlinType1.getConstructor();
    paramKotlinType1 = paramKotlinType1.getArguments();
    paramKotlinType2 = paramKotlinType2.getArguments();
    if (paramKotlinType1.size() != paramKotlinType2.size()) {
      return false;
    }
    localObject1 = ((TypeConstructor)localObject1).getParameters();
    int i = 0;
    for (;;)
    {
      int j = ((List)localObject1).size();
      int k = 1;
      if (i >= j) {
        break;
      }
      Object localObject2 = (TypeParameterDescriptor)((List)localObject1).get(i);
      TypeProjection localTypeProjection1 = (TypeProjection)paramKotlinType2.get(i);
      TypeProjection localTypeProjection2 = (TypeProjection)paramKotlinType1.get(i);
      if ((!localTypeProjection1.isStarProjection()) && (!capture(localTypeProjection2, localTypeProjection1, (TypeParameterDescriptor)localObject2)))
      {
        j = k;
        if (!KotlinTypeKt.isError(localTypeProjection2.getType())) {
          if (KotlinTypeKt.isError(localTypeProjection1.getType())) {
            j = k;
          } else {
            j = 0;
          }
        }
        if ((j == 0) && (((TypeParameterDescriptor)localObject2).getVariance() == Variance.INVARIANT) && (localTypeProjection2.getProjectionKind() == Variance.INVARIANT) && (localTypeProjection1.getProjectionKind() == Variance.INVARIANT))
        {
          if (!this.constraints.assertEqualTypes(localTypeProjection2.getType(), localTypeProjection1.getType(), this)) {
            return false;
          }
        }
        else
        {
          KotlinType localKotlinType1 = getOutType((TypeParameterDescriptor)localObject2, localTypeProjection1);
          KotlinType localKotlinType2 = getOutType((TypeParameterDescriptor)localObject2, localTypeProjection2);
          if (!this.constraints.assertSubtype(localKotlinType2, localKotlinType1, this)) {
            return false;
          }
          localKotlinType1 = getInType((TypeParameterDescriptor)localObject2, localTypeProjection1);
          localObject2 = getInType((TypeParameterDescriptor)localObject2, localTypeProjection2);
          if ((localTypeProjection1.getProjectionKind() != Variance.OUT_VARIANCE) && (!this.constraints.assertSubtype(localKotlinType1, (KotlinType)localObject2, this))) {
            return false;
          }
        }
      }
      i += 1;
    }
    return true;
  }
  
  @Nullable
  public static KotlinType findCorrespondingSupertype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(0);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(1);
    }
    return findCorrespondingSupertype(paramKotlinType1, paramKotlinType2, new TypeCheckerProcedureCallbacksImpl());
  }
  
  @Nullable
  public static KotlinType findCorrespondingSupertype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeCheckingProcedureCallbacks paramTypeCheckingProcedureCallbacks)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(2);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(3);
    }
    if (paramTypeCheckingProcedureCallbacks == null) {
      $$$reportNull$$$0(4);
    }
    return UtilsKt.findCorrespondingSupertype(paramKotlinType1, paramKotlinType2, paramTypeCheckingProcedureCallbacks);
  }
  
  public static TypeCheckingProcedure.EnrichedProjectionKind getEffectiveProjectionKind(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull TypeProjection paramTypeProjection)
  {
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(14);
    }
    paramTypeParameterDescriptor = paramTypeParameterDescriptor.getVariance();
    paramTypeProjection = paramTypeProjection.getProjectionKind();
    Object localObject2 = paramTypeParameterDescriptor;
    Object localObject1 = paramTypeProjection;
    if (paramTypeProjection == Variance.INVARIANT)
    {
      localObject1 = paramTypeParameterDescriptor;
      localObject2 = paramTypeProjection;
    }
    if ((localObject2 == Variance.IN_VARIANCE) && (localObject1 == Variance.OUT_VARIANCE)) {
      return TypeCheckingProcedure.EnrichedProjectionKind.STAR;
    }
    if ((localObject2 == Variance.OUT_VARIANCE) && (localObject1 == Variance.IN_VARIANCE)) {
      return TypeCheckingProcedure.EnrichedProjectionKind.STAR;
    }
    return TypeCheckingProcedure.EnrichedProjectionKind.fromVariance((Variance)localObject1);
  }
  
  @NotNull
  private static KotlinType getInType(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull TypeProjection paramTypeProjection)
  {
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(8);
    }
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(9);
    }
    int i;
    if ((paramTypeProjection.getProjectionKind() != Variance.OUT_VARIANCE) && (paramTypeParameterDescriptor.getVariance() != Variance.OUT_VARIANCE)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramTypeParameterDescriptor = DescriptorUtilsKt.getBuiltIns(paramTypeParameterDescriptor).getNothingType();
    } else {
      paramTypeParameterDescriptor = paramTypeProjection.getType();
    }
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(10);
    }
    return paramTypeParameterDescriptor;
  }
  
  @NotNull
  private static KotlinType getOutType(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull TypeProjection paramTypeProjection)
  {
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(6);
    }
    int i;
    if ((paramTypeProjection.getProjectionKind() != Variance.IN_VARIANCE) && (paramTypeParameterDescriptor.getVariance() != Variance.IN_VARIANCE)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramTypeParameterDescriptor = DescriptorUtilsKt.getBuiltIns(paramTypeParameterDescriptor).getNullableAnyType();
    } else {
      paramTypeParameterDescriptor = paramTypeProjection.getType();
    }
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    return paramTypeParameterDescriptor;
  }
  
  private boolean isSubtypeOfForRepresentatives(KotlinType paramKotlinType1, KotlinType paramKotlinType2)
  {
    if (!KotlinTypeKt.isError(paramKotlinType1))
    {
      if (KotlinTypeKt.isError(paramKotlinType2)) {
        return true;
      }
      if ((!paramKotlinType2.isMarkedNullable()) && (paramKotlinType1.isMarkedNullable())) {
        return false;
      }
      if (KotlinBuiltIns.isNothingOrNullableNothing(paramKotlinType1)) {
        return true;
      }
      KotlinType localKotlinType = findCorrespondingSupertype(paramKotlinType1, paramKotlinType2, this.constraints);
      if (localKotlinType == null) {
        return this.constraints.noCorrespondingSupertype(paramKotlinType1, paramKotlinType2);
      }
      if ((!paramKotlinType2.isMarkedNullable()) && (localKotlinType.isMarkedNullable())) {
        return false;
      }
      return checkSubtypeForTheSameConstructor(localKotlinType, paramKotlinType2);
    }
    return true;
  }
  
  public boolean equalTypes(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(11);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(12);
    }
    if (paramKotlinType1 == paramKotlinType2) {
      return true;
    }
    if (FlexibleTypesKt.isFlexible(paramKotlinType1))
    {
      if (FlexibleTypesKt.isFlexible(paramKotlinType2)) {
        return (!KotlinTypeKt.isError(paramKotlinType1)) && (!KotlinTypeKt.isError(paramKotlinType2)) && (isSubtypeOf(paramKotlinType1, paramKotlinType2)) && (isSubtypeOf(paramKotlinType2, paramKotlinType1));
      }
      return heterogeneousEquivalence(paramKotlinType2, paramKotlinType1);
    }
    if (FlexibleTypesKt.isFlexible(paramKotlinType2)) {
      return heterogeneousEquivalence(paramKotlinType1, paramKotlinType2);
    }
    if (paramKotlinType1.isMarkedNullable() != paramKotlinType2.isMarkedNullable()) {
      return false;
    }
    if (paramKotlinType1.isMarkedNullable()) {
      return this.constraints.assertEqualTypes(TypeUtils.makeNotNullable(paramKotlinType1), TypeUtils.makeNotNullable(paramKotlinType2), this);
    }
    TypeConstructor localTypeConstructor1 = paramKotlinType1.getConstructor();
    TypeConstructor localTypeConstructor2 = paramKotlinType2.getConstructor();
    if (!this.constraints.assertEqualTypeConstructors(localTypeConstructor1, localTypeConstructor2)) {
      return false;
    }
    paramKotlinType1 = paramKotlinType1.getArguments();
    paramKotlinType2 = paramKotlinType2.getArguments();
    if (paramKotlinType1.size() != paramKotlinType2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramKotlinType1.size())
    {
      TypeProjection localTypeProjection1 = (TypeProjection)paramKotlinType1.get(i);
      TypeProjection localTypeProjection2 = (TypeProjection)paramKotlinType2.get(i);
      if ((!localTypeProjection1.isStarProjection()) || (!localTypeProjection2.isStarProjection()))
      {
        TypeParameterDescriptor localTypeParameterDescriptor1 = (TypeParameterDescriptor)localTypeConstructor1.getParameters().get(i);
        TypeParameterDescriptor localTypeParameterDescriptor2 = (TypeParameterDescriptor)localTypeConstructor2.getParameters().get(i);
        if (!capture(localTypeProjection1, localTypeProjection2, localTypeParameterDescriptor1))
        {
          if (getEffectiveProjectionKind(localTypeParameterDescriptor1, localTypeProjection1) != getEffectiveProjectionKind(localTypeParameterDescriptor2, localTypeProjection2)) {
            return false;
          }
          if (!this.constraints.assertEqualTypes(localTypeProjection1.getType(), localTypeProjection2.getType(), this)) {
            return false;
          }
        }
      }
      i += 1;
    }
    return true;
  }
  
  protected boolean heterogeneousEquivalence(KotlinType paramKotlinType1, KotlinType paramKotlinType2)
  {
    return (isSubtypeOf(FlexibleTypesKt.asFlexibleType(paramKotlinType2).getLowerBound(), paramKotlinType1)) && (isSubtypeOf(paramKotlinType1, FlexibleTypesKt.asFlexibleType(paramKotlinType2).getUpperBound()));
  }
  
  public boolean isSubtypeOf(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(15);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(16);
    }
    if (TypeCapabilitiesKt.sameTypeConstructors(paramKotlinType1, paramKotlinType2)) {
      return (!paramKotlinType1.isMarkedNullable()) || (paramKotlinType2.isMarkedNullable());
    }
    KotlinType localKotlinType1 = TypeCapabilitiesKt.getSubtypeRepresentative(paramKotlinType1);
    KotlinType localKotlinType2 = TypeCapabilitiesKt.getSupertypeRepresentative(paramKotlinType2);
    if ((localKotlinType1 == paramKotlinType1) && (localKotlinType2 == paramKotlinType2)) {
      return isSubtypeOfForRepresentatives(paramKotlinType1, paramKotlinType2);
    }
    return isSubtypeOf(localKotlinType1, localKotlinType2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure
 * JD-Core Version:    0.7.0.1
 */