package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeApproximationKt
{
  @NotNull
  public static final ApproximationBounds<KotlinType> approximateCapturedTypes(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    Object localObject1;
    Object localObject2;
    if (FlexibleTypesKt.isFlexible(paramKotlinType))
    {
      localObject1 = approximateCapturedTypes((KotlinType)FlexibleTypesKt.lowerIfFlexible(paramKotlinType));
      localObject2 = approximateCapturedTypes((KotlinType)FlexibleTypesKt.upperIfFlexible(paramKotlinType));
      return new ApproximationBounds(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible((KotlinType)((ApproximationBounds)localObject1).getLower()), FlexibleTypesKt.upperIfFlexible((KotlinType)((ApproximationBounds)localObject2).getLower())), paramKotlinType), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible((KotlinType)((ApproximationBounds)localObject1).getUpper()), FlexibleTypesKt.upperIfFlexible((KotlinType)((ApproximationBounds)localObject2).getUpper())), paramKotlinType));
    }
    Object localObject4 = paramKotlinType.getConstructor();
    Object localObject3;
    int i;
    if (CapturedTypeConstructorKt.isCaptured(paramKotlinType))
    {
      if (localObject4 != null)
      {
        localObject1 = ((CapturedTypeConstructor)localObject4).getProjection();
        localObject2 = new CapturedTypeApproximationKt.approximateCapturedTypes.1(paramKotlinType);
        localObject3 = ((TypeProjection)localObject1).getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "typeProjection.type");
        localObject3 = ((CapturedTypeApproximationKt.approximateCapturedTypes.1)localObject2).invoke((KotlinType)localObject3);
        localObject4 = ((TypeProjection)localObject1).getProjectionKind();
        i = CapturedTypeApproximationKt.WhenMappings.$EnumSwitchMapping$1[localObject4.ordinal()];
        if (i != 1)
        {
          if (i == 2)
          {
            paramKotlinType = TypeUtilsKt.getBuiltIns(paramKotlinType).getNothingType();
            Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "type.builtIns.nothingType");
            return new ApproximationBounds(((CapturedTypeApproximationKt.approximateCapturedTypes.1)localObject2).invoke((KotlinType)paramKotlinType), localObject3);
          }
          paramKotlinType = new StringBuilder();
          paramKotlinType.append("Only nontrivial projections should have been captured, not: ");
          paramKotlinType.append(localObject1);
          throw ((Throwable)new AssertionError(paramKotlinType.toString()));
        }
        paramKotlinType = TypeUtilsKt.getBuiltIns(paramKotlinType).getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "type.builtIns.nullableAnyType");
        return new ApproximationBounds(localObject3, paramKotlinType);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
    }
    if ((!paramKotlinType.getArguments().isEmpty()) && (paramKotlinType.getArguments().size() == ((TypeConstructor)localObject4).getParameters().size()))
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = (Iterable)paramKotlinType.getArguments();
      localObject4 = ((TypeConstructor)localObject4).getParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "typeConstructor.parameters");
      localObject3 = CollectionsKt.zip((Iterable)localObject3, (Iterable)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject5 = (Pair)((Iterator)localObject3).next();
        localObject4 = (TypeProjection)((Pair)localObject5).component1();
        localObject5 = (TypeParameterDescriptor)((Pair)localObject5).component2();
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "typeParameter");
        localObject5 = toTypeArgument((TypeProjection)localObject4, (TypeParameterDescriptor)localObject5);
        if (((TypeProjection)localObject4).isStarProjection())
        {
          ((ArrayList)localObject1).add(localObject5);
          ((ArrayList)localObject2).add(localObject5);
        }
        else
        {
          localObject5 = approximateProjection((TypeArgument)localObject5);
          localObject4 = (TypeArgument)((ApproximationBounds)localObject5).component1();
          localObject5 = (TypeArgument)((ApproximationBounds)localObject5).component2();
          ((ArrayList)localObject1).add(localObject4);
          ((ArrayList)localObject2).add(localObject5);
        }
      }
      localObject3 = (Iterable)localObject1;
      boolean bool = localObject3 instanceof Collection;
      int j = 0;
      if ((bool) && (((Collection)localObject3).isEmpty()))
      {
        i = j;
      }
      else
      {
        localObject3 = ((Iterable)localObject3).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!(((TypeArgument)((Iterator)localObject3).next()).isConsistent() ^ true));
        i = 1;
      }
      if (i != 0)
      {
        localObject1 = TypeUtilsKt.getBuiltIns(paramKotlinType).getNothingType();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "type.builtIns.nothingType");
        localObject1 = (KotlinType)localObject1;
      }
      else
      {
        localObject1 = replaceTypeArguments(paramKotlinType, (List)localObject1);
      }
      return new ApproximationBounds(localObject1, replaceTypeArguments(paramKotlinType, (List)localObject2));
    }
    return new ApproximationBounds(paramKotlinType, paramKotlinType);
  }
  
  @Nullable
  public static final TypeProjection approximateCapturedTypesIfNecessary(@Nullable TypeProjection paramTypeProjection, boolean paramBoolean)
  {
    if (paramTypeProjection == null) {
      return null;
    }
    if (paramTypeProjection.isStarProjection()) {
      return paramTypeProjection;
    }
    KotlinType localKotlinType = paramTypeProjection.getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "typeProjection.type");
    if (!TypeUtils.contains(localKotlinType, (Function1)CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary.1.INSTANCE)) {
      return paramTypeProjection;
    }
    Variance localVariance = paramTypeProjection.getProjectionKind();
    Intrinsics.checkExpressionValueIsNotNull(localVariance, "typeProjection.projectionKind");
    if (localVariance == Variance.OUT_VARIANCE) {
      return (TypeProjection)new TypeProjectionImpl(localVariance, (KotlinType)approximateCapturedTypes(localKotlinType).getUpper());
    }
    if (paramBoolean) {
      return (TypeProjection)new TypeProjectionImpl(localVariance, (KotlinType)approximateCapturedTypes(localKotlinType).getLower());
    }
    return substituteCapturedTypesWithProjections(paramTypeProjection);
  }
  
  private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument paramTypeArgument)
  {
    Object localObject1 = approximateCapturedTypes(paramTypeArgument.getInProjection());
    KotlinType localKotlinType1 = (KotlinType)((ApproximationBounds)localObject1).component1();
    localObject1 = (KotlinType)((ApproximationBounds)localObject1).component2();
    Object localObject2 = approximateCapturedTypes(paramTypeArgument.getOutProjection());
    KotlinType localKotlinType2 = (KotlinType)((ApproximationBounds)localObject2).component1();
    localObject2 = (KotlinType)((ApproximationBounds)localObject2).component2();
    return new ApproximationBounds(new TypeArgument(paramTypeArgument.getTypeParameter(), (KotlinType)localObject1, localKotlinType2), new TypeArgument(paramTypeArgument.getTypeParameter(), localKotlinType1, (KotlinType)localObject2));
  }
  
  private static final KotlinType replaceTypeArguments(@NotNull KotlinType paramKotlinType, List<TypeArgument> paramList)
  {
    int i;
    if (paramKotlinType.getArguments().size() == paramList.size()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramKotlinType = new StringBuilder();
      paramKotlinType.append("Incorrect type arguments ");
      paramKotlinType.append(paramList);
      throw ((Throwable)new AssertionError(paramKotlinType.toString()));
    }
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(toTypeProjection((TypeArgument)((Iterator)localObject).next()));
    }
    return TypeSubstitutionKt.replace$default(paramKotlinType, (List)paramList, null, 2, null);
  }
  
  private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection paramTypeProjection)
  {
    TypeSubstitutor localTypeSubstitutor = TypeSubstitutor.create((TypeSubstitution)new CapturedTypeApproximationKt.substituteCapturedTypesWithProjections.typeSubstitutor.1());
    Intrinsics.checkExpressionValueIsNotNull(localTypeSubstitutor, "TypeSubstitutor.create(o…ojection\n        }\n    })");
    return localTypeSubstitutor.substituteWithoutApproximation(paramTypeProjection);
  }
  
  private static final TypeArgument toTypeArgument(@NotNull TypeProjection paramTypeProjection, TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Object localObject = TypeSubstitutor.combine(paramTypeParameterDescriptor.getVariance(), paramTypeProjection);
    int i = CapturedTypeApproximationKt.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)paramTypeParameterDescriptor).getNothingType();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "typeParameter.builtIns.nothingType");
          localObject = (KotlinType)localObject;
          paramTypeProjection = paramTypeProjection.getType();
          Intrinsics.checkExpressionValueIsNotNull(paramTypeProjection, "type");
          return new TypeArgument(paramTypeParameterDescriptor, (KotlinType)localObject, paramTypeProjection);
        }
        throw new NoWhenBranchMatchedException();
      }
      paramTypeProjection = paramTypeProjection.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeProjection, "type");
      localObject = DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)paramTypeParameterDescriptor).getNullableAnyType();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "typeParameter.builtIns.nullableAnyType");
      return new TypeArgument(paramTypeParameterDescriptor, paramTypeProjection, (KotlinType)localObject);
    }
    localObject = paramTypeProjection.getType();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "type");
    paramTypeProjection = paramTypeProjection.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeProjection, "type");
    return new TypeArgument(paramTypeParameterDescriptor, (KotlinType)localObject, paramTypeProjection);
  }
  
  private static final TypeProjection toTypeProjection(@NotNull TypeArgument paramTypeArgument)
  {
    boolean bool = paramTypeArgument.isConsistent();
    if ((_Assertions.ENABLED) && (!bool))
    {
      localObject = DescriptorRenderer.Companion.withOptions((Function1)CapturedTypeApproximationKt.toTypeProjection.1.descriptorRenderer.1.INSTANCE);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Only consistent enhanced type projection can be converted to type projection, but ");
      localStringBuilder.append('[');
      localStringBuilder.append(((DescriptorRenderer)localObject).render((DeclarationDescriptor)paramTypeArgument.getTypeParameter()));
      localStringBuilder.append(": <");
      localStringBuilder.append(((DescriptorRenderer)localObject).renderType(paramTypeArgument.getInProjection()));
      localStringBuilder.append(", ");
      localStringBuilder.append(((DescriptorRenderer)localObject).renderType(paramTypeArgument.getOutProjection()));
      localStringBuilder.append(">]");
      localStringBuilder.append(" was found");
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    Object localObject = new CapturedTypeApproximationKt.toTypeProjection.2(paramTypeArgument);
    if (Intrinsics.areEqual(paramTypeArgument.getInProjection(), paramTypeArgument.getOutProjection())) {
      return (TypeProjection)new TypeProjectionImpl(paramTypeArgument.getInProjection());
    }
    if ((KotlinBuiltIns.isNothing(paramTypeArgument.getInProjection())) && (paramTypeArgument.getTypeParameter().getVariance() != Variance.IN_VARIANCE)) {
      return (TypeProjection)new TypeProjectionImpl(((CapturedTypeApproximationKt.toTypeProjection.2)localObject).invoke(Variance.OUT_VARIANCE), paramTypeArgument.getOutProjection());
    }
    if (KotlinBuiltIns.isNullableAny(paramTypeArgument.getOutProjection())) {
      return (TypeProjection)new TypeProjectionImpl(((CapturedTypeApproximationKt.toTypeProjection.2)localObject).invoke(Variance.IN_VARIANCE), paramTypeArgument.getInProjection());
    }
    return (TypeProjection)new TypeProjectionImpl(((CapturedTypeApproximationKt.toTypeProjection.2)localObject).invoke(Variance.OUT_VARIANCE), paramTypeArgument.getOutProjection());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt
 * JD-Core Version:    0.7.0.1
 */