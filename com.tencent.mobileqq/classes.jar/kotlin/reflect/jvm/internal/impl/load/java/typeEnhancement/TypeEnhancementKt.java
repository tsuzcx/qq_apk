package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeEnhancementKt
{
  private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
  private static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS;
  
  static
  {
    FqName localFqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(localFqName);
    localFqName = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
    ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(localFqName);
  }
  
  private static final Annotations compositeAnnotationsOrSingle(@NotNull List<? extends Annotations> paramList)
  {
    int i = paramList.size();
    if (i != 0)
    {
      if (i != 1) {
        return (Annotations)new CompositeAnnotations(CollectionsKt.toList((Iterable)paramList));
      }
      return (Annotations)CollectionsKt.single(paramList);
    }
    throw ((Throwable)new IllegalStateException("At least one Annotations object expected".toString()));
  }
  
  @Nullable
  public static final KotlinType enhance(@NotNull KotlinType paramKotlinType, @NotNull Function1<? super Integer, JavaTypeQualifiers> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$enhance");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "qualifiers");
    return enhancePossiblyFlexible(paramKotlinType.unwrap(), paramFunction1, 0).getTypeIfChanged();
  }
  
  private static final SimpleResult enhanceInflexible(@NotNull SimpleType paramSimpleType, Function1<? super Integer, JavaTypeQualifiers> paramFunction1, int paramInt, TypeComponentPosition paramTypeComponentPosition)
  {
    if ((!shouldEnhance(paramTypeComponentPosition)) && (paramSimpleType.getArguments().isEmpty())) {
      return new SimpleResult(paramSimpleType, 1, false);
    }
    Object localObject1 = paramSimpleType.getConstructor().getDeclarationDescriptor();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.declarationD…pleResult(this, 1, false)");
      JavaTypeQualifiers localJavaTypeQualifiers = (JavaTypeQualifiers)paramFunction1.invoke(Integer.valueOf(paramInt));
      localObject1 = enhanceMutability((ClassifierDescriptor)localObject1, localJavaTypeQualifiers, paramTypeComponentPosition);
      ClassifierDescriptor localClassifierDescriptor = (ClassifierDescriptor)((EnhancementResult)localObject1).component1();
      Annotations localAnnotations = ((EnhancementResult)localObject1).component2();
      TypeConstructor localTypeConstructor = localClassifierDescriptor.getTypeConstructor();
      Intrinsics.checkExpressionValueIsNotNull(localTypeConstructor, "enhancedClassifier.typeConstructor");
      int i;
      if (localAnnotations != null) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = (Iterable)paramSimpleType.getArguments();
      Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      int k = paramInt + 1;
      int m = 0;
      int j = i;
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (m < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject1 = (TypeProjection)localObject1;
        if (((TypeProjection)localObject1).isStarProjection())
        {
          i = k + 1;
          localObject1 = localClassifierDescriptor.getTypeConstructor();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "enhancedClassifier.typeConstructor");
          localObject1 = TypeUtils.makeStarProjection((TypeParameterDescriptor)((TypeConstructor)localObject1).getParameters().get(m));
        }
        else
        {
          Object localObject2 = enhancePossiblyFlexible(((TypeProjection)localObject1).getType().unwrap(), paramFunction1, k);
          if ((j == 0) && (!((Result)localObject2).getWereChanges())) {
            j = 0;
          } else {
            j = 1;
          }
          i = k + ((Result)localObject2).getSubtreeSize();
          localObject2 = ((Result)localObject2).getType();
          localObject1 = ((TypeProjection)localObject1).getProjectionKind();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "arg.projectionKind");
          localObject1 = TypeUtilsKt.createProjection((KotlinType)localObject2, (Variance)localObject1, (TypeParameterDescriptor)localTypeConstructor.getParameters().get(m));
        }
        localCollection.add(localObject1);
        m += 1;
        k = i;
      }
      paramFunction1 = (List)localCollection;
      paramTypeComponentPosition = getEnhancedNullability((KotlinType)paramSimpleType, localJavaTypeQualifiers, paramTypeComponentPosition);
      boolean bool = ((Boolean)paramTypeComponentPosition.component1()).booleanValue();
      localObject1 = paramTypeComponentPosition.component2();
      if ((j == 0) && (localObject1 == null)) {
        i = 0;
      } else {
        i = 1;
      }
      j = k - paramInt;
      if (i == 0) {
        return new SimpleResult(paramSimpleType, j, false);
      }
      paramTypeComponentPosition = KotlinTypeFactory.simpleType$default(compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull(new Annotations[] { paramSimpleType.getAnnotations(), localAnnotations, localObject1 })), localTypeConstructor, paramFunction1, bool, null, 16, null);
      paramFunction1 = paramTypeComponentPosition;
      if (localJavaTypeQualifiers.isNotNullTypeParameter()) {
        paramFunction1 = (SimpleType)new NotNullTypeParameter(paramTypeComponentPosition);
      }
      if ((localObject1 != null) && (localJavaTypeQualifiers.isNullabilityQualifierForWarning())) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        paramSimpleType = TypeWithEnhancementKt.wrapEnhancement((UnwrappedType)paramSimpleType, (KotlinType)paramFunction1);
      } else {
        paramSimpleType = (UnwrappedType)paramFunction1;
      }
      if (paramSimpleType != null) {
        return new SimpleResult((SimpleType)paramSimpleType, j, true);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    return new SimpleResult(paramSimpleType, 1, false);
  }
  
  private static final EnhancementResult<ClassifierDescriptor> enhanceMutability(@NotNull ClassifierDescriptor paramClassifierDescriptor, JavaTypeQualifiers paramJavaTypeQualifiers, TypeComponentPosition paramTypeComponentPosition)
  {
    if (!shouldEnhance(paramTypeComponentPosition)) {
      return noChange(paramClassifierDescriptor);
    }
    if (!(paramClassifierDescriptor instanceof ClassDescriptor)) {
      return noChange(paramClassifierDescriptor);
    }
    JavaToKotlinClassMap localJavaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
    paramJavaTypeQualifiers = paramJavaTypeQualifiers.getMutability();
    if (paramJavaTypeQualifiers != null)
    {
      int i = TypeEnhancementKt.WhenMappings.$EnumSwitchMapping$0[paramJavaTypeQualifiers.ordinal()];
      if (i != 1)
      {
        if ((i == 2) && (paramTypeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER))
        {
          paramJavaTypeQualifiers = (ClassDescriptor)paramClassifierDescriptor;
          if (localJavaToKotlinClassMap.isReadOnly(paramJavaTypeQualifiers)) {
            return enhancedMutability(localJavaToKotlinClassMap.convertReadOnlyToMutable(paramJavaTypeQualifiers));
          }
        }
      }
      else if (paramTypeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER)
      {
        paramJavaTypeQualifiers = (ClassDescriptor)paramClassifierDescriptor;
        if (localJavaToKotlinClassMap.isMutable(paramJavaTypeQualifiers)) {
          return enhancedMutability(localJavaToKotlinClassMap.convertMutableToReadOnly(paramJavaTypeQualifiers));
        }
      }
    }
    return noChange(paramClassifierDescriptor);
  }
  
  private static final Result enhancePossiblyFlexible(@NotNull UnwrappedType paramUnwrappedType, Function1<? super Integer, JavaTypeQualifiers> paramFunction1, int paramInt)
  {
    Object localObject = (KotlinType)paramUnwrappedType;
    boolean bool2 = KotlinTypeKt.isError((KotlinType)localObject);
    boolean bool1 = false;
    if (bool2) {
      return new Result((KotlinType)localObject, 1, false);
    }
    if ((paramUnwrappedType instanceof FlexibleType))
    {
      FlexibleType localFlexibleType = (FlexibleType)paramUnwrappedType;
      localObject = enhanceInflexible(localFlexibleType.getLowerBound(), paramFunction1, paramInt, TypeComponentPosition.FLEXIBLE_LOWER);
      SimpleResult localSimpleResult = enhanceInflexible(localFlexibleType.getUpperBound(), paramFunction1, paramInt, TypeComponentPosition.FLEXIBLE_UPPER);
      if (((SimpleResult)localObject).getSubtreeSize() == localSimpleResult.getSubtreeSize()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((_Assertions.ENABLED) && (paramInt == 0))
      {
        paramUnwrappedType = new StringBuilder();
        paramUnwrappedType.append("Different tree sizes of bounds: ");
        paramUnwrappedType.append("lower = (");
        paramUnwrappedType.append(localFlexibleType.getLowerBound());
        paramUnwrappedType.append(", ");
        paramUnwrappedType.append(((SimpleResult)localObject).getSubtreeSize());
        paramUnwrappedType.append("), ");
        paramUnwrappedType.append("upper = (");
        paramUnwrappedType.append(localFlexibleType.getUpperBound());
        paramUnwrappedType.append(", ");
        paramUnwrappedType.append(localSimpleResult.getSubtreeSize());
        paramUnwrappedType.append(')');
        throw ((Throwable)new AssertionError(paramUnwrappedType.toString()));
      }
      if ((((SimpleResult)localObject).getWereChanges()) || (localSimpleResult.getWereChanges())) {
        bool1 = true;
      }
      paramFunction1 = TypeWithEnhancementKt.getEnhancement((KotlinType)((SimpleResult)localObject).getType());
      if (paramFunction1 == null) {
        paramFunction1 = TypeWithEnhancementKt.getEnhancement((KotlinType)localSimpleResult.getType());
      }
      if (bool1)
      {
        if ((paramUnwrappedType instanceof RawTypeImpl)) {
          paramUnwrappedType = (UnwrappedType)new RawTypeImpl(((SimpleResult)localObject).getType(), localSimpleResult.getType());
        } else {
          paramUnwrappedType = KotlinTypeFactory.flexibleType(((SimpleResult)localObject).getType(), localSimpleResult.getType());
        }
        paramUnwrappedType = TypeWithEnhancementKt.wrapEnhancement(paramUnwrappedType, paramFunction1);
      }
      return new Result((KotlinType)paramUnwrappedType, ((SimpleResult)localObject).getSubtreeSize(), bool1);
    }
    if ((paramUnwrappedType instanceof SimpleType)) {
      return (Result)enhanceInflexible((SimpleType)paramUnwrappedType, paramFunction1, paramInt, TypeComponentPosition.INFLEXIBLE);
    }
    throw new NoWhenBranchMatchedException();
  }
  
  private static final <T> EnhancementResult<T> enhancedMutability(T paramT)
  {
    return new EnhancementResult(paramT, (Annotations)ENHANCED_MUTABILITY_ANNOTATIONS);
  }
  
  private static final <T> EnhancementResult<T> enhancedNullability(T paramT)
  {
    return new EnhancementResult(paramT, (Annotations)ENHANCED_NULLABILITY_ANNOTATIONS);
  }
  
  private static final EnhancementResult<Boolean> getEnhancedNullability(@NotNull KotlinType paramKotlinType, JavaTypeQualifiers paramJavaTypeQualifiers, TypeComponentPosition paramTypeComponentPosition)
  {
    if (!shouldEnhance(paramTypeComponentPosition)) {
      return noChange(Boolean.valueOf(paramKotlinType.isMarkedNullable()));
    }
    paramJavaTypeQualifiers = paramJavaTypeQualifiers.getNullability();
    if (paramJavaTypeQualifiers != null)
    {
      int i = TypeEnhancementKt.WhenMappings.$EnumSwitchMapping$1[paramJavaTypeQualifiers.ordinal()];
      if (i == 1) {
        break label68;
      }
      if (i == 2) {}
    }
    else
    {
      return noChange(Boolean.valueOf(paramKotlinType.isMarkedNullable()));
    }
    return enhancedNullability(Boolean.valueOf(false));
    label68:
    return enhancedNullability(Boolean.valueOf(true));
  }
  
  public static final boolean hasEnhancedNullability(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$hasEnhancedNullability");
    return hasEnhancedNullability((TypeSystemCommonBackendContext)SimpleClassicTypeSystemContext.INSTANCE, (KotlinTypeMarker)paramKotlinType);
  }
  
  public static final boolean hasEnhancedNullability(@NotNull TypeSystemCommonBackendContext paramTypeSystemCommonBackendContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSystemCommonBackendContext, "$this$hasEnhancedNullability");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    FqName localFqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    return paramTypeSystemCommonBackendContext.hasAnnotation(paramKotlinTypeMarker, localFqName);
  }
  
  private static final <T> EnhancementResult<T> noChange(T paramT)
  {
    return new EnhancementResult(paramT, null);
  }
  
  public static final boolean shouldEnhance(@NotNull TypeComponentPosition paramTypeComponentPosition)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeComponentPosition, "$this$shouldEnhance");
    return paramTypeComponentPosition != TypeComponentPosition.INFLEXIBLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt
 * JD-Core Version:    0.7.0.1
 */