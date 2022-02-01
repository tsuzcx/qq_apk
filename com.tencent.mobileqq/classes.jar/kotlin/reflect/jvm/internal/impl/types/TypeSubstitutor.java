package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeSubstitutor
{
  public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
  @NotNull
  private final TypeSubstitution substitution;
  
  protected TypeSubstitutor(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    this.substitution = paramTypeSubstitution;
  }
  
  private static void assertRecursionDepth(int paramInt, TypeProjection paramTypeProjection, TypeSubstitution paramTypeSubstitution)
  {
    if (paramInt <= 100) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recursion too deep. Most likely infinite loop while substituting ");
    localStringBuilder.append(safeToString(paramTypeProjection));
    localStringBuilder.append("; substitution: ");
    localStringBuilder.append(safeToString(paramTypeSubstitution));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  @NotNull
  public static Variance combine(@NotNull Variance paramVariance, @NotNull TypeProjection paramTypeProjection)
  {
    if (paramVariance == null) {
      $$$reportNull$$$0(25);
    }
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(26);
    }
    if (paramTypeProjection.isStarProjection())
    {
      paramVariance = Variance.OUT_VARIANCE;
      if (paramVariance == null) {
        $$$reportNull$$$0(27);
      }
      return paramVariance;
    }
    return combine(paramVariance, paramTypeProjection.getProjectionKind());
  }
  
  @NotNull
  public static Variance combine(@NotNull Variance paramVariance1, @NotNull Variance paramVariance2)
  {
    if (paramVariance1 == null) {
      $$$reportNull$$$0(28);
    }
    if (paramVariance2 == null) {
      $$$reportNull$$$0(29);
    }
    if (paramVariance1 == Variance.INVARIANT)
    {
      if (paramVariance2 == null) {
        $$$reportNull$$$0(30);
      }
      return paramVariance2;
    }
    if (paramVariance2 == Variance.INVARIANT)
    {
      if (paramVariance1 == null) {
        $$$reportNull$$$0(31);
      }
      return paramVariance1;
    }
    if (paramVariance1 == paramVariance2)
    {
      if (paramVariance2 == null) {
        $$$reportNull$$$0(32);
      }
      return paramVariance2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Variance conflict: type parameter variance '");
    localStringBuilder.append(paramVariance1);
    localStringBuilder.append("' and ");
    localStringBuilder.append("projection kind '");
    localStringBuilder.append(paramVariance2);
    localStringBuilder.append("' cannot be combined");
    throw new AssertionError(localStringBuilder.toString());
  }
  
  private static TypeSubstitutor.VarianceConflictType conflictType(Variance paramVariance1, Variance paramVariance2)
  {
    if ((paramVariance1 == Variance.IN_VARIANCE) && (paramVariance2 == Variance.OUT_VARIANCE)) {
      return TypeSubstitutor.VarianceConflictType.OUT_IN_IN_POSITION;
    }
    if ((paramVariance1 == Variance.OUT_VARIANCE) && (paramVariance2 == Variance.IN_VARIANCE)) {
      return TypeSubstitutor.VarianceConflictType.IN_IN_OUT_POSITION;
    }
    return TypeSubstitutor.VarianceConflictType.NO_CONFLICT;
  }
  
  @NotNull
  public static TypeSubstitutor create(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(4);
    }
    return create(TypeConstructorSubstitution.create(paramKotlinType.getConstructor(), paramKotlinType.getArguments()));
  }
  
  @NotNull
  public static TypeSubstitutor create(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(0);
    }
    return new TypeSubstitutor(paramTypeSubstitution);
  }
  
  @NotNull
  public static TypeSubstitutor createChainedSubstitutor(@NotNull TypeSubstitution paramTypeSubstitution1, @NotNull TypeSubstitution paramTypeSubstitution2)
  {
    if (paramTypeSubstitution1 == null) {
      $$$reportNull$$$0(1);
    }
    if (paramTypeSubstitution2 == null) {
      $$$reportNull$$$0(2);
    }
    return create(DisjointKeysUnionTypeSubstitution.create(paramTypeSubstitution1, paramTypeSubstitution2));
  }
  
  @NotNull
  private static Annotations filterOutUnsafeVariance(@NotNull Annotations paramAnnotations)
  {
    if (paramAnnotations == null) {
      $$$reportNull$$$0(23);
    }
    if (!paramAnnotations.hasAnnotation(KotlinBuiltIns.FQ_NAMES.unsafeVariance))
    {
      if (paramAnnotations == null) {
        $$$reportNull$$$0(24);
      }
      return paramAnnotations;
    }
    return new FilteredAnnotations(paramAnnotations, new TypeSubstitutor.1());
  }
  
  private static String safeToString(Object paramObject)
  {
    try
    {
      paramObject = paramObject.toString();
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if (!ExceptionUtilsKt.isProcessCanceledException(paramObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Exception while computing toString(): ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      throw ((RuntimeException)paramObject);
    }
  }
  
  private TypeProjection substituteCompoundType(TypeProjection paramTypeProjection, int paramInt)
  {
    Object localObject1 = paramTypeProjection.getType();
    Variance localVariance = paramTypeProjection.getProjectionKind();
    if ((((KotlinType)localObject1).getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
      return paramTypeProjection;
    }
    paramTypeProjection = null;
    Object localObject2 = SpecialTypesKt.getAbbreviation((KotlinType)localObject1);
    if (localObject2 != null) {
      paramTypeProjection = substitute((KotlinType)localObject2, Variance.INVARIANT);
    }
    localObject2 = TypeSubstitutionKt.replace((KotlinType)localObject1, substituteTypeArguments(((KotlinType)localObject1).getConstructor().getParameters(), ((KotlinType)localObject1).getArguments(), paramInt), this.substitution.filterAnnotations(((KotlinType)localObject1).getAnnotations()));
    localObject1 = localObject2;
    if ((localObject2 instanceof SimpleType))
    {
      localObject1 = localObject2;
      if ((paramTypeProjection instanceof SimpleType)) {
        localObject1 = SpecialTypesKt.withAbbreviation((SimpleType)localObject2, (SimpleType)paramTypeProjection);
      }
    }
    return new TypeProjectionImpl(localVariance, (KotlinType)localObject1);
  }
  
  private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> paramList, List<TypeProjection> paramList1, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    int j = 0;
    while (i < paramList.size())
    {
      TypeParameterDescriptor localTypeParameterDescriptor = (TypeParameterDescriptor)paramList.get(i);
      TypeProjection localTypeProjection2 = (TypeProjection)paramList1.get(i);
      TypeProjection localTypeProjection1 = unsafeSubstitute(localTypeProjection2, paramInt + 1);
      int k = TypeSubstitutor.2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(localTypeParameterDescriptor.getVariance(), localTypeProjection1.getProjectionKind()).ordinal()];
      Object localObject;
      if ((k != 1) && (k != 2))
      {
        if (k != 3)
        {
          localObject = localTypeProjection1;
        }
        else
        {
          localObject = localTypeProjection1;
          if (localTypeParameterDescriptor.getVariance() != Variance.INVARIANT)
          {
            localObject = localTypeProjection1;
            if (!localTypeProjection1.isStarProjection()) {
              localObject = new TypeProjectionImpl(Variance.INVARIANT, localTypeProjection1.getType());
            }
          }
        }
      }
      else {
        localObject = TypeUtils.makeStarProjection(localTypeParameterDescriptor);
      }
      if (localObject != localTypeProjection2) {
        j = 1;
      }
      localArrayList.add(localObject);
      i += 1;
    }
    if (j == 0) {
      return paramList1;
    }
    return localArrayList;
  }
  
  @NotNull
  private TypeProjection unsafeSubstitute(@NotNull TypeProjection paramTypeProjection, int paramInt)
  {
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(16);
    }
    assertRecursionDepth(paramInt, paramTypeProjection, this.substitution);
    if (paramTypeProjection.isStarProjection())
    {
      if (paramTypeProjection == null) {
        $$$reportNull$$$0(17);
      }
      return paramTypeProjection;
    }
    KotlinType localKotlinType = paramTypeProjection.getType();
    Object localObject2;
    Object localObject1;
    if ((localKotlinType instanceof TypeWithEnhancement))
    {
      localObject2 = (TypeWithEnhancement)localKotlinType;
      localObject1 = ((TypeWithEnhancement)localObject2).getOrigin();
      localObject2 = ((TypeWithEnhancement)localObject2).getEnhancement();
      localObject1 = unsafeSubstitute(new TypeProjectionImpl(paramTypeProjection.getProjectionKind(), (KotlinType)localObject1), paramInt + 1);
      paramTypeProjection = substitute((KotlinType)localObject2, paramTypeProjection.getProjectionKind());
      paramTypeProjection = TypeWithEnhancementKt.wrapEnhancement(((TypeProjection)localObject1).getType().unwrap(), paramTypeProjection);
      return new TypeProjectionImpl(((TypeProjection)localObject1).getProjectionKind(), paramTypeProjection);
    }
    if ((!DynamicTypesKt.isDynamic(localKotlinType)) && (!(localKotlinType.unwrap() instanceof RawType)))
    {
      Object localObject3 = this.substitution.get(localKotlinType);
      localObject2 = paramTypeProjection.getProjectionKind();
      Object localObject4;
      if ((localObject3 == null) && (FlexibleTypesKt.isFlexible(localKotlinType)) && (!TypeCapabilitiesKt.isCustomTypeVariable(localKotlinType)))
      {
        localObject1 = FlexibleTypesKt.asFlexibleType(localKotlinType);
        localObject3 = new TypeProjectionImpl((Variance)localObject2, ((FlexibleType)localObject1).getLowerBound());
        paramInt += 1;
        localObject3 = unsafeSubstitute((TypeProjection)localObject3, paramInt);
        localObject2 = unsafeSubstitute(new TypeProjectionImpl((Variance)localObject2, ((FlexibleType)localObject1).getUpperBound()), paramInt);
        localObject4 = ((TypeProjection)localObject3).getProjectionKind();
        if ((((TypeProjection)localObject3).getType() == ((FlexibleType)localObject1).getLowerBound()) && (((TypeProjection)localObject2).getType() == ((FlexibleType)localObject1).getUpperBound()))
        {
          if (paramTypeProjection == null) {
            $$$reportNull$$$0(19);
          }
          return paramTypeProjection;
        }
        return new TypeProjectionImpl((Variance)localObject4, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(((TypeProjection)localObject3).getType()), TypeSubstitutionKt.asSimpleType(((TypeProjection)localObject2).getType())));
      }
      if ((!KotlinBuiltIns.isNothing(localKotlinType)) && (!KotlinTypeKt.isError(localKotlinType)))
      {
        if (localObject3 != null)
        {
          localObject4 = conflictType((Variance)localObject2, ((TypeProjection)localObject3).getProjectionKind());
          if (!CapturedTypeConstructorKt.isCaptured(localKotlinType))
          {
            paramInt = TypeSubstitutor.2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[localObject4.ordinal()];
            if (paramInt != 1)
            {
              if (paramInt == 2) {
                return new TypeProjectionImpl(Variance.OUT_VARIANCE, localKotlinType.getConstructor().getBuiltIns().getNullableAnyType());
              }
            }
            else {
              throw new TypeSubstitutor.SubstitutionException("Out-projection in in-position");
            }
          }
          paramTypeProjection = TypeCapabilitiesKt.getCustomTypeVariable(localKotlinType);
          if (((TypeProjection)localObject3).isStarProjection())
          {
            if (localObject3 == null) {
              $$$reportNull$$$0(21);
            }
            return localObject3;
          }
          if (paramTypeProjection != null) {
            paramTypeProjection = paramTypeProjection.substitutionResult(((TypeProjection)localObject3).getType());
          } else {
            paramTypeProjection = TypeUtils.makeNullableIfNeeded(((TypeProjection)localObject3).getType(), localKotlinType.isMarkedNullable());
          }
          localObject1 = paramTypeProjection;
          if (!localKotlinType.getAnnotations().isEmpty())
          {
            localObject1 = filterOutUnsafeVariance(this.substitution.filterAnnotations(localKotlinType.getAnnotations()));
            localObject1 = TypeUtilsKt.replaceAnnotations(paramTypeProjection, new CompositeAnnotations(new Annotations[] { paramTypeProjection.getAnnotations(), localObject1 }));
          }
          paramTypeProjection = (TypeProjection)localObject2;
          if (localObject4 == TypeSubstitutor.VarianceConflictType.NO_CONFLICT) {
            paramTypeProjection = combine((Variance)localObject2, ((TypeProjection)localObject3).getProjectionKind());
          }
          return new TypeProjectionImpl(paramTypeProjection, (KotlinType)localObject1);
        }
        paramTypeProjection = substituteCompoundType(paramTypeProjection, paramInt);
        if (paramTypeProjection == null) {
          $$$reportNull$$$0(22);
        }
        return paramTypeProjection;
      }
      if (paramTypeProjection == null) {
        $$$reportNull$$$0(20);
      }
      return paramTypeProjection;
    }
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(18);
    }
    return paramTypeProjection;
  }
  
  @NotNull
  public TypeSubstitution getSubstitution()
  {
    TypeSubstitution localTypeSubstitution = this.substitution;
    if (localTypeSubstitution == null) {
      $$$reportNull$$$0(6);
    }
    return localTypeSubstitution;
  }
  
  public boolean isEmpty()
  {
    return this.substitution.isEmpty();
  }
  
  @NotNull
  public KotlinType safeSubstitute(@NotNull KotlinType paramKotlinType, @NotNull Variance paramVariance)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(7);
    }
    if (paramVariance == null) {
      $$$reportNull$$$0(8);
    }
    if (isEmpty())
    {
      if (paramKotlinType == null) {
        $$$reportNull$$$0(9);
      }
      return paramKotlinType;
    }
    try
    {
      paramKotlinType = unsafeSubstitute(new TypeProjectionImpl(paramVariance, paramKotlinType), 0).getType();
      if (paramKotlinType == null) {
        $$$reportNull$$$0(10);
      }
      return paramKotlinType;
    }
    catch (TypeSubstitutor.SubstitutionException paramKotlinType)
    {
      paramKotlinType = ErrorUtils.createErrorType(paramKotlinType.getMessage());
      if (paramKotlinType == null) {
        $$$reportNull$$$0(11);
      }
    }
    return paramKotlinType;
  }
  
  @Nullable
  public KotlinType substitute(@NotNull KotlinType paramKotlinType, @NotNull Variance paramVariance)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(12);
    }
    if (paramVariance == null) {
      $$$reportNull$$$0(13);
    }
    paramKotlinType = substitute(new TypeProjectionImpl(paramVariance, getSubstitution().prepareTopLevelType(paramKotlinType, paramVariance)));
    if (paramKotlinType == null) {
      return null;
    }
    return paramKotlinType.getType();
  }
  
  @Nullable
  public TypeProjection substitute(@NotNull TypeProjection paramTypeProjection)
  {
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(14);
    }
    paramTypeProjection = substituteWithoutApproximation(paramTypeProjection);
    if ((!this.substitution.approximateCapturedTypes()) && (!this.substitution.approximateContravariantCapturedTypes())) {
      return paramTypeProjection;
    }
    return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(paramTypeProjection, this.substitution.approximateContravariantCapturedTypes());
  }
  
  @Nullable
  public TypeProjection substituteWithoutApproximation(@NotNull TypeProjection paramTypeProjection)
  {
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(15);
    }
    if (isEmpty()) {
      return paramTypeProjection;
    }
    try
    {
      paramTypeProjection = unsafeSubstitute(paramTypeProjection, 0);
      return paramTypeProjection;
    }
    catch (TypeSubstitutor.SubstitutionException paramTypeProjection)
    {
      label27:
      break label27;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor
 * JD-Core Version:    0.7.0.1
 */