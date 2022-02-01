package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeResolver
{
  private final LazyJavaResolverContext c;
  private final TypeParameterResolver typeParameterResolver;
  
  public JavaTypeResolver(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull TypeParameterResolver paramTypeParameterResolver)
  {
    this.c = paramLazyJavaResolverContext;
    this.typeParameterResolver = paramTypeParameterResolver;
  }
  
  private final boolean argumentsMakeSenseOnlyForMutableContainer(@NotNull JavaClassifierType paramJavaClassifierType, ClassDescriptor paramClassDescriptor)
  {
    boolean bool1 = JavaTypeResolver.argumentsMakeSenseOnlyForMutableContainer.1.INSTANCE.invoke((JavaType)CollectionsKt.lastOrNull(paramJavaClassifierType.getTypeArguments()));
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramJavaClassifierType = JavaToKotlinClassMap.INSTANCE.convertReadOnlyToMutable(paramClassDescriptor).getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramJavaClassifierType, "JavaToKotlinClassMap.con…         .typeConstructor");
    paramJavaClassifierType = paramJavaClassifierType.getParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramJavaClassifierType, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
    paramJavaClassifierType = (TypeParameterDescriptor)CollectionsKt.lastOrNull(paramJavaClassifierType);
    bool1 = bool2;
    if (paramJavaClassifierType != null)
    {
      paramJavaClassifierType = paramJavaClassifierType.getVariance();
      bool1 = bool2;
      if (paramJavaClassifierType != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramJavaClassifierType, "JavaToKotlinClassMap.con….variance ?: return false");
        bool1 = bool2;
        if (paramJavaClassifierType != Variance.OUT_VARIANCE) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final List<TypeProjection> computeArguments(JavaClassifierType paramJavaClassifierType, JavaTypeAttributes paramJavaTypeAttributes, TypeConstructor paramTypeConstructor)
  {
    boolean bool = paramJavaClassifierType.isRaw();
    if (!bool) {
      if (paramJavaClassifierType.getTypeArguments().isEmpty())
      {
        localObject1 = paramTypeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.parameters");
        if ((((Collection)localObject1).isEmpty() ^ true)) {}
      }
      else
      {
        i = 0;
        break label69;
      }
    }
    int i = 1;
    label69:
    Object localObject1 = paramTypeConstructor.getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.parameters");
    Object localObject2;
    Object localObject3;
    if (i != 0)
    {
      paramJavaClassifierType = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramJavaClassifierType, 10));
      localObject2 = paramJavaClassifierType.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TypeParameterDescriptor)((Iterator)localObject2).next();
        LazyWrappedType localLazyWrappedType = new LazyWrappedType(this.c.getStorageManager(), (Function0)new JavaTypeResolver.computeArguments..inlined.map.lambda.1((TypeParameterDescriptor)localObject3, this, paramJavaTypeAttributes, paramTypeConstructor, bool));
        RawSubstitution localRawSubstitution = RawSubstitution.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "parameter");
        if (bool) {
          paramJavaClassifierType = paramJavaTypeAttributes;
        } else {
          paramJavaClassifierType = paramJavaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
        }
        ((Collection)localObject1).add(localRawSubstitution.computeProjection((TypeParameterDescriptor)localObject3, paramJavaClassifierType, (KotlinType)localLazyWrappedType));
      }
      return CollectionsKt.toList((Iterable)localObject1);
    }
    if (((List)localObject1).size() != paramJavaClassifierType.getTypeArguments().size())
    {
      paramJavaTypeAttributes = (Iterable)localObject1;
      paramJavaClassifierType = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramJavaTypeAttributes, 10));
      paramJavaTypeAttributes = paramJavaTypeAttributes.iterator();
      while (paramJavaTypeAttributes.hasNext())
      {
        paramTypeConstructor = (TypeParameterDescriptor)paramJavaTypeAttributes.next();
        Intrinsics.checkExpressionValueIsNotNull(paramTypeConstructor, "p");
        paramJavaClassifierType.add(new TypeProjectionImpl((KotlinType)ErrorUtils.createErrorType(paramTypeConstructor.getName().asString())));
      }
      return CollectionsKt.toList((Iterable)paramJavaClassifierType);
    }
    paramJavaTypeAttributes = CollectionsKt.withIndex((Iterable)paramJavaClassifierType.getTypeArguments());
    paramJavaClassifierType = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramJavaTypeAttributes, 10));
    paramJavaTypeAttributes = paramJavaTypeAttributes.iterator();
    while (paramJavaTypeAttributes.hasNext())
    {
      paramTypeConstructor = (IndexedValue)paramJavaTypeAttributes.next();
      int j = paramTypeConstructor.component1();
      paramTypeConstructor = (JavaType)paramTypeConstructor.component2();
      if (j < ((List)localObject1).size()) {
        i = 1;
      } else {
        i = 0;
      }
      if ((_Assertions.ENABLED) && (i == 0))
      {
        paramJavaClassifierType = new StringBuilder();
        paramJavaClassifierType.append("Argument index should be less then type parameters count, but ");
        paramJavaClassifierType.append(j);
        paramJavaClassifierType.append(" > ");
        paramJavaClassifierType.append(((List)localObject1).size());
        throw ((Throwable)new AssertionError(paramJavaClassifierType.toString()));
      }
      localObject2 = (TypeParameterDescriptor)((List)localObject1).get(j);
      localObject3 = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "parameter");
      paramJavaClassifierType.add(transformToTypeProjection(paramTypeConstructor, (JavaTypeAttributes)localObject3, (TypeParameterDescriptor)localObject2));
    }
    return CollectionsKt.toList((Iterable)paramJavaClassifierType);
  }
  
  private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType paramJavaClassifierType, JavaTypeAttributes paramJavaTypeAttributes, SimpleType paramSimpleType)
  {
    Annotations localAnnotations;
    if (paramSimpleType != null)
    {
      localAnnotations = paramSimpleType.getAnnotations();
      if (localAnnotations != null) {}
    }
    else
    {
      localAnnotations = (Annotations)new LazyJavaAnnotations(this.c, (JavaAnnotationOwner)paramJavaClassifierType);
    }
    TypeConstructor localTypeConstructor2 = computeTypeConstructor(paramJavaClassifierType, paramJavaTypeAttributes);
    TypeConstructor localTypeConstructor1 = null;
    if (localTypeConstructor2 != null)
    {
      boolean bool = isNullable(paramJavaTypeAttributes);
      if (paramSimpleType != null) {
        localTypeConstructor1 = paramSimpleType.getConstructor();
      }
      if ((Intrinsics.areEqual(localTypeConstructor1, localTypeConstructor2)) && (!paramJavaClassifierType.isRaw()) && (bool)) {
        return paramSimpleType.makeNullableAsSpecified(true);
      }
      return KotlinTypeFactory.simpleType$default(localAnnotations, localTypeConstructor2, computeArguments(paramJavaClassifierType, paramJavaTypeAttributes, localTypeConstructor2), bool, null, 16, null);
    }
    return null;
  }
  
  private final TypeConstructor computeTypeConstructor(JavaClassifierType paramJavaClassifierType, JavaTypeAttributes paramJavaTypeAttributes)
  {
    JavaClassifier localJavaClassifier = paramJavaClassifierType.getClassifier();
    if (localJavaClassifier != null)
    {
      if ((localJavaClassifier instanceof JavaClass))
      {
        JavaClass localJavaClass = (JavaClass)localJavaClassifier;
        FqName localFqName = localJavaClass.getFqName();
        if (localFqName != null)
        {
          paramJavaTypeAttributes = mapKotlinClass(paramJavaClassifierType, paramJavaTypeAttributes, localFqName);
          if (paramJavaTypeAttributes == null) {
            paramJavaTypeAttributes = this.c.getComponents().getModuleClassResolver().resolveClass(localJavaClass);
          }
          if (paramJavaTypeAttributes != null)
          {
            paramJavaTypeAttributes = paramJavaTypeAttributes.getTypeConstructor();
            if (paramJavaTypeAttributes != null) {
              return paramJavaTypeAttributes;
            }
          }
          return createNotFoundClass(paramJavaClassifierType);
        }
        paramJavaClassifierType = new StringBuilder();
        paramJavaClassifierType.append("Class type should have a FQ name: ");
        paramJavaClassifierType.append(localJavaClassifier);
        throw ((Throwable)new AssertionError(paramJavaClassifierType.toString()));
      }
      if ((localJavaClassifier instanceof JavaTypeParameter))
      {
        paramJavaClassifierType = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter)localJavaClassifier);
        if (paramJavaClassifierType != null) {
          return paramJavaClassifierType.getTypeConstructor();
        }
        return null;
      }
      paramJavaClassifierType = new StringBuilder();
      paramJavaClassifierType.append("Unknown classifier kind: ");
      paramJavaClassifierType.append(localJavaClassifier);
      throw ((Throwable)new IllegalStateException(paramJavaClassifierType.toString()));
    }
    return createNotFoundClass(paramJavaClassifierType);
  }
  
  private final TypeConstructor createNotFoundClass(JavaClassifierType paramJavaClassifierType)
  {
    paramJavaClassifierType = ClassId.topLevel(new FqName(paramJavaClassifierType.getClassifierQualifiedName()));
    Intrinsics.checkExpressionValueIsNotNull(paramJavaClassifierType, "ClassId.topLevel(FqName(…classifierQualifiedName))");
    paramJavaClassifierType = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(paramJavaClassifierType, CollectionsKt.listOf(Integer.valueOf(0))).getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramJavaClassifierType, "c.components.deserialize…istOf(0)).typeConstructor");
    return paramJavaClassifierType;
  }
  
  private final boolean isConflictingArgumentFor(@NotNull Variance paramVariance, TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Variance localVariance1 = paramTypeParameterDescriptor.getVariance();
    Variance localVariance2 = Variance.INVARIANT;
    boolean bool = false;
    if (localVariance1 == localVariance2) {
      return false;
    }
    if (paramVariance != paramTypeParameterDescriptor.getVariance()) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean isNullable(@NotNull JavaTypeAttributes paramJavaTypeAttributes)
  {
    JavaTypeFlexibility localJavaTypeFlexibility1 = paramJavaTypeAttributes.getFlexibility();
    JavaTypeFlexibility localJavaTypeFlexibility2 = JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND;
    boolean bool2 = false;
    if (localJavaTypeFlexibility1 == localJavaTypeFlexibility2) {
      return false;
    }
    boolean bool1 = bool2;
    if (!paramJavaTypeAttributes.isForAnnotationParameter())
    {
      bool1 = bool2;
      if (paramJavaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final ClassDescriptor mapKotlinClass(JavaClassifierType paramJavaClassifierType, JavaTypeAttributes paramJavaTypeAttributes, FqName paramFqName)
  {
    if ((paramJavaTypeAttributes.isForAnnotationParameter()) && (Intrinsics.areEqual(paramFqName, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p()))) {
      return this.c.getComponents().getReflectionTypes().getKClass();
    }
    JavaToKotlinClassMap localJavaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
    paramFqName = JavaToKotlinClassMap.mapJavaToKotlin$default(localJavaToKotlinClassMap, paramFqName, this.c.getModule().getBuiltIns(), null, 4, null);
    if (paramFqName != null)
    {
      if ((localJavaToKotlinClassMap.isReadOnly(paramFqName)) && ((paramJavaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) || (paramJavaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) || (argumentsMakeSenseOnlyForMutableContainer(paramJavaClassifierType, paramFqName)))) {
        return localJavaToKotlinClassMap.convertReadOnlyToMutable(paramFqName);
      }
      return paramFqName;
    }
    return null;
  }
  
  private final KotlinType transformJavaClassifierType(JavaClassifierType paramJavaClassifierType, JavaTypeAttributes paramJavaTypeAttributes)
  {
    JavaTypeResolver.transformJavaClassifierType.1 local1 = new JavaTypeResolver.transformJavaClassifierType.1(paramJavaClassifierType);
    int i;
    if ((!paramJavaTypeAttributes.isForAnnotationParameter()) && (paramJavaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = paramJavaClassifierType.isRaw();
    if ((!bool) && (i == 0))
    {
      paramJavaClassifierType = computeSimpleJavaClassifierType(paramJavaClassifierType, paramJavaTypeAttributes, null);
      if (paramJavaClassifierType == null) {
        paramJavaClassifierType = local1.invoke();
      }
      return (KotlinType)paramJavaClassifierType;
    }
    SimpleType localSimpleType = computeSimpleJavaClassifierType(paramJavaClassifierType, paramJavaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
    if (localSimpleType != null)
    {
      paramJavaClassifierType = computeSimpleJavaClassifierType(paramJavaClassifierType, paramJavaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), localSimpleType);
      if (paramJavaClassifierType != null)
      {
        if (bool) {
          return (KotlinType)new RawTypeImpl(localSimpleType, paramJavaClassifierType);
        }
        return (KotlinType)KotlinTypeFactory.flexibleType(localSimpleType, paramJavaClassifierType);
      }
      return (KotlinType)local1.invoke();
    }
    return (KotlinType)local1.invoke();
  }
  
  private final TypeProjection transformToTypeProjection(JavaType paramJavaType, JavaTypeAttributes paramJavaTypeAttributes, TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    if ((paramJavaType instanceof JavaWildcardType))
    {
      paramJavaType = (JavaWildcardType)paramJavaType;
      JavaType localJavaType = paramJavaType.getBound();
      if (paramJavaType.isExtends()) {
        paramJavaType = Variance.OUT_VARIANCE;
      } else {
        paramJavaType = Variance.IN_VARIANCE;
      }
      if ((localJavaType != null) && (!isConflictingArgumentFor(paramJavaType, paramTypeParameterDescriptor))) {
        return TypeUtilsKt.createProjection(transformJavaType(localJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)), paramJavaType, paramTypeParameterDescriptor);
      }
      return JavaTypeResolverKt.makeStarProjection(paramTypeParameterDescriptor, paramJavaTypeAttributes);
    }
    return (TypeProjection)new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(paramJavaType, paramJavaTypeAttributes));
  }
  
  @NotNull
  public final KotlinType transformArrayType(@NotNull JavaArrayType paramJavaArrayType, @NotNull JavaTypeAttributes paramJavaTypeAttributes, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaArrayType, "arrayType");
    Intrinsics.checkParameterIsNotNull(paramJavaTypeAttributes, "attr");
    Object localObject = paramJavaArrayType.getComponentType();
    if (!(localObject instanceof JavaPrimitiveType)) {
      paramJavaArrayType = null;
    } else {
      paramJavaArrayType = (JavaArrayType)localObject;
    }
    paramJavaArrayType = (JavaPrimitiveType)paramJavaArrayType;
    if (paramJavaArrayType != null) {
      paramJavaArrayType = paramJavaArrayType.getType();
    } else {
      paramJavaArrayType = null;
    }
    if (paramJavaArrayType != null)
    {
      paramJavaArrayType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(paramJavaArrayType);
      Intrinsics.checkExpressionValueIsNotNull(paramJavaArrayType, "c.module.builtIns.getPri…KotlinType(primitiveType)");
      if (paramJavaTypeAttributes.isForAnnotationParameter()) {
        return (KotlinType)paramJavaArrayType;
      }
      return (KotlinType)KotlinTypeFactory.flexibleType(paramJavaArrayType, paramJavaArrayType.makeNullableAsSpecified(true));
    }
    localObject = transformJavaType((JavaType)localObject, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, paramJavaTypeAttributes.isForAnnotationParameter(), null, 2, null));
    if (paramJavaTypeAttributes.isForAnnotationParameter())
    {
      if (paramBoolean) {
        paramJavaArrayType = Variance.OUT_VARIANCE;
      } else {
        paramJavaArrayType = Variance.INVARIANT;
      }
      paramJavaArrayType = this.c.getModule().getBuiltIns().getArrayType(paramJavaArrayType, (KotlinType)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramJavaArrayType, "c.module.builtIns.getArr…ctionKind, componentType)");
      return (KotlinType)paramJavaArrayType;
    }
    paramJavaArrayType = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, (KotlinType)localObject);
    Intrinsics.checkExpressionValueIsNotNull(paramJavaArrayType, "c.module.builtIns.getArr…INVARIANT, componentType)");
    return (KotlinType)KotlinTypeFactory.flexibleType(paramJavaArrayType, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, (KotlinType)localObject).makeNullableAsSpecified(true));
  }
  
  @NotNull
  public final KotlinType transformJavaType(@Nullable JavaType paramJavaType, @NotNull JavaTypeAttributes paramJavaTypeAttributes)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaTypeAttributes, "attr");
    if ((paramJavaType instanceof JavaPrimitiveType))
    {
      paramJavaType = ((JavaPrimitiveType)paramJavaType).getType();
      if (paramJavaType != null) {
        paramJavaType = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(paramJavaType);
      } else {
        paramJavaType = this.c.getModule().getBuiltIns().getUnitType();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramJavaType, "if (primitiveType != nul….module.builtIns.unitType");
      return (KotlinType)paramJavaType;
    }
    if ((paramJavaType instanceof JavaClassifierType)) {
      return transformJavaClassifierType((JavaClassifierType)paramJavaType, paramJavaTypeAttributes);
    }
    if ((paramJavaType instanceof JavaArrayType)) {
      return transformArrayType$default(this, (JavaArrayType)paramJavaType, paramJavaTypeAttributes, false, 4, null);
    }
    if ((paramJavaType instanceof JavaWildcardType))
    {
      paramJavaType = ((JavaWildcardType)paramJavaType).getBound();
      if (paramJavaType != null)
      {
        paramJavaType = transformJavaType(paramJavaType, paramJavaTypeAttributes);
        if (paramJavaType != null) {
          return paramJavaType;
        }
      }
      paramJavaType = this.c.getModule().getBuiltIns().getDefaultBound();
      Intrinsics.checkExpressionValueIsNotNull(paramJavaType, "c.module.builtIns.defaultBound");
      return (KotlinType)paramJavaType;
    }
    if (paramJavaType == null)
    {
      paramJavaType = this.c.getModule().getBuiltIns().getDefaultBound();
      Intrinsics.checkExpressionValueIsNotNull(paramJavaType, "c.module.builtIns.defaultBound");
      return (KotlinType)paramJavaType;
    }
    paramJavaTypeAttributes = new StringBuilder();
    paramJavaTypeAttributes.append("Unsupported type: ");
    paramJavaTypeAttributes.append(paramJavaType);
    throw ((Throwable)new UnsupportedOperationException(paramJavaTypeAttributes.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver
 * JD-Core Version:    0.7.0.1
 */