package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeUtilsKt
{
  @NotNull
  public static final TypeProjection asTypeProjection(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$asTypeProjection");
    return (TypeProjection)new TypeProjectionImpl(paramKotlinType);
  }
  
  public static final boolean canHaveUndefinedNullability(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "$this$canHaveUndefinedNullability");
    return ((paramUnwrappedType.getConstructor() instanceof NewTypeVariableConstructor)) || ((paramUnwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) || ((paramUnwrappedType instanceof NewCapturedType));
  }
  
  public static final boolean contains(@NotNull KotlinType paramKotlinType, @NotNull Function1<? super UnwrappedType, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$contains");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return TypeUtils.contains(paramKotlinType, paramFunction1);
  }
  
  public static final boolean containsTypeAliasParameters(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$containsTypeAliasParameters");
    return contains(paramKotlinType, (Function1)TypeUtilsKt.containsTypeAliasParameters.1.INSTANCE);
  }
  
  @NotNull
  public static final TypeProjection createProjection(@NotNull KotlinType paramKotlinType, @NotNull Variance paramVariance, @Nullable TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    Intrinsics.checkParameterIsNotNull(paramVariance, "projectionKind");
    if (paramTypeParameterDescriptor != null) {
      paramTypeParameterDescriptor = paramTypeParameterDescriptor.getVariance();
    } else {
      paramTypeParameterDescriptor = null;
    }
    Variance localVariance = paramVariance;
    if (paramTypeParameterDescriptor == paramVariance) {
      localVariance = Variance.INVARIANT;
    }
    return (TypeProjection)new TypeProjectionImpl(localVariance, paramKotlinType);
  }
  
  @NotNull
  public static final KotlinBuiltIns getBuiltIns(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$builtIns");
    paramKotlinType = paramKotlinType.getConstructor().getBuiltIns();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "constructor.builtIns");
    return paramKotlinType;
  }
  
  @NotNull
  public static final KotlinType getRepresentativeUpperBound(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterDescriptor, "$this$representativeUpperBound");
    Object localObject1 = paramTypeParameterDescriptor.getUpperBounds();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "upperBounds");
    boolean bool = ((Collection)localObject1).isEmpty();
    if ((_Assertions.ENABLED) && (!(bool ^ true)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Upper bounds should not be empty: ");
      ((StringBuilder)localObject1).append(paramTypeParameterDescriptor);
      throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
    }
    localObject1 = paramTypeParameterDescriptor.getUpperBounds();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "upperBounds");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject2;
    int i;
    do
    {
      bool = localIterator.hasNext();
      localObject1 = null;
      if (!bool) {
        break;
      }
      localObject2 = localIterator.next();
      ClassifierDescriptor localClassifierDescriptor = ((KotlinType)localObject2).getConstructor().getDeclarationDescriptor();
      if ((localClassifierDescriptor instanceof ClassDescriptor)) {
        localObject1 = localClassifierDescriptor;
      }
      localObject1 = (ClassDescriptor)localObject1;
      int j = 0;
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((ClassDescriptor)localObject1).getKind() != ClassKind.INTERFACE)
        {
          i = j;
          if (((ClassDescriptor)localObject1).getKind() != ClassKind.ANNOTATION_CLASS) {
            i = 1;
          }
        }
      }
    } while (i == 0);
    localObject1 = localObject2;
    break label230;
    localObject1 = null;
    label230:
    localObject1 = (KotlinType)localObject1;
    if (localObject1 != null) {
      return localObject1;
    }
    paramTypeParameterDescriptor = paramTypeParameterDescriptor.getUpperBounds();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeParameterDescriptor, "upperBounds");
    paramTypeParameterDescriptor = CollectionsKt.first(paramTypeParameterDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(paramTypeParameterDescriptor, "upperBounds.first()");
    return (KotlinType)paramTypeParameterDescriptor;
  }
  
  public static final boolean isSubtypeOf(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType1, "$this$isSubtypeOf");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "superType");
    return KotlinTypeChecker.DEFAULT.isSubtypeOf(paramKotlinType1, paramKotlinType2);
  }
  
  public static final boolean isTypeAliasParameter(@NotNull ClassifierDescriptor paramClassifierDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierDescriptor, "$this$isTypeAliasParameter");
    return ((paramClassifierDescriptor instanceof TypeParameterDescriptor)) && ((((TypeParameterDescriptor)paramClassifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor));
  }
  
  public static final boolean isTypeParameter(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isTypeParameter");
    return TypeUtils.isTypeParameter(paramKotlinType);
  }
  
  @NotNull
  public static final KotlinType makeNotNullable(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$makeNotNullable");
    paramKotlinType = TypeUtils.makeNotNullable(paramKotlinType);
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "TypeUtils.makeNotNullable(this)");
    return paramKotlinType;
  }
  
  @NotNull
  public static final KotlinType makeNullable(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$makeNullable");
    paramKotlinType = TypeUtils.makeNullable(paramKotlinType);
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "TypeUtils.makeNullable(this)");
    return paramKotlinType;
  }
  
  @NotNull
  public static final KotlinType replaceAnnotations(@NotNull KotlinType paramKotlinType, @NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$replaceAnnotations");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    if ((paramKotlinType.getAnnotations().isEmpty()) && (paramAnnotations.isEmpty())) {
      return paramKotlinType;
    }
    return (KotlinType)paramKotlinType.unwrap().replaceAnnotations(paramAnnotations);
  }
  
  @NotNull
  public static final KotlinType replaceArgumentsWithStarProjections(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$replaceArgumentsWithStarProjections");
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    Object localObject2;
    Object localObject1;
    if ((localUnwrappedType instanceof FlexibleType))
    {
      localObject2 = (FlexibleType)localUnwrappedType;
      localObject1 = ((FlexibleType)localObject2).getLowerBound();
      paramKotlinType = (KotlinType)localObject1;
      Object localObject3;
      if (!((SimpleType)localObject1).getConstructor().getParameters().isEmpty()) {
        if (((SimpleType)localObject1).getConstructor().getDeclarationDescriptor() == null)
        {
          paramKotlinType = (KotlinType)localObject1;
        }
        else
        {
          paramKotlinType = ((SimpleType)localObject1).getConstructor().getParameters();
          Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "constructor.parameters");
          localObject3 = (Iterable)paramKotlinType;
          paramKotlinType = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            paramKotlinType.add(new StarProjectionImpl((TypeParameterDescriptor)((Iterator)localObject3).next()));
          }
          paramKotlinType = TypeSubstitutionKt.replace$default((SimpleType)localObject1, (List)paramKotlinType, null, 2, null);
        }
      }
      localObject2 = ((FlexibleType)localObject2).getUpperBound();
      localObject1 = localObject2;
      if (!((SimpleType)localObject2).getConstructor().getParameters().isEmpty()) {
        if (((SimpleType)localObject2).getConstructor().getDeclarationDescriptor() == null)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = ((SimpleType)localObject2).getConstructor().getParameters();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.parameters");
          localObject3 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(new StarProjectionImpl((TypeParameterDescriptor)((Iterator)localObject3).next()));
          }
          localObject1 = TypeSubstitutionKt.replace$default((SimpleType)localObject2, (List)localObject1, null, 2, null);
        }
      }
      paramKotlinType = KotlinTypeFactory.flexibleType(paramKotlinType, (SimpleType)localObject1);
    }
    else
    {
      if (!(localUnwrappedType instanceof SimpleType)) {
        break label471;
      }
      localObject1 = (SimpleType)localUnwrappedType;
      paramKotlinType = (KotlinType)localObject1;
      if (!((SimpleType)localObject1).getConstructor().getParameters().isEmpty()) {
        if (((SimpleType)localObject1).getConstructor().getDeclarationDescriptor() == null)
        {
          paramKotlinType = (KotlinType)localObject1;
        }
        else
        {
          paramKotlinType = ((SimpleType)localObject1).getConstructor().getParameters();
          Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "constructor.parameters");
          localObject2 = (Iterable)paramKotlinType;
          paramKotlinType = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramKotlinType.add(new StarProjectionImpl((TypeParameterDescriptor)((Iterator)localObject2).next()));
          }
          paramKotlinType = TypeSubstitutionKt.replace$default((SimpleType)localObject1, (List)paramKotlinType, null, 2, null);
        }
      }
      paramKotlinType = (UnwrappedType)paramKotlinType;
    }
    return (KotlinType)TypeWithEnhancementKt.inheritEnhancement(paramKotlinType, (KotlinType)localUnwrappedType);
    label471:
    paramKotlinType = new NoWhenBranchMatchedException();
    for (;;)
    {
      throw paramKotlinType;
    }
  }
  
  public static final boolean requiresTypeAliasExpansion(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$requiresTypeAliasExpansion");
    return contains(paramKotlinType, (Function1)TypeUtilsKt.requiresTypeAliasExpansion.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt
 * JD-Core Version:    0.7.0.1
 */