package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.TypeQualifierWithApplicability;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextKt
{
  private static final LazyJavaResolverContext child(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, DeclarationDescriptor paramDeclarationDescriptor, JavaTypeParameterListOwner paramJavaTypeParameterListOwner, int paramInt, Lazy<JavaTypeQualifiersByElementType> paramLazy)
  {
    JavaResolverComponents localJavaResolverComponents = paramLazyJavaResolverContext.getComponents();
    if (paramJavaTypeParameterListOwner != null) {
      paramLazyJavaResolverContext = (TypeParameterResolver)new LazyJavaTypeParameterResolver(paramLazyJavaResolverContext, paramDeclarationDescriptor, paramJavaTypeParameterListOwner, paramInt);
    } else {
      paramLazyJavaResolverContext = paramLazyJavaResolverContext.getTypeParameterResolver();
    }
    return new LazyJavaResolverContext(localJavaResolverComponents, paramLazyJavaResolverContext, paramLazy);
  }
  
  @NotNull
  public static final LazyJavaResolverContext child(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull TypeParameterResolver paramTypeParameterResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$child");
    Intrinsics.checkParameterIsNotNull(paramTypeParameterResolver, "typeParameterResolver");
    return new LazyJavaResolverContext(paramLazyJavaResolverContext.getComponents(), paramTypeParameterResolver, paramLazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
  }
  
  @NotNull
  public static final LazyJavaResolverContext childForClassOrPackage(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull ClassOrPackageFragmentDescriptor paramClassOrPackageFragmentDescriptor, @Nullable JavaTypeParameterListOwner paramJavaTypeParameterListOwner, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$childForClassOrPackage");
    Intrinsics.checkParameterIsNotNull(paramClassOrPackageFragmentDescriptor, "containingDeclaration");
    return child(paramLazyJavaResolverContext, (DeclarationDescriptor)paramClassOrPackageFragmentDescriptor, paramJavaTypeParameterListOwner, paramInt, LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)new ContextKt.childForClassOrPackage.1(paramLazyJavaResolverContext, paramClassOrPackageFragmentDescriptor)));
  }
  
  @NotNull
  public static final LazyJavaResolverContext childForMethod(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull JavaTypeParameterListOwner paramJavaTypeParameterListOwner, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$childForMethod");
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "containingDeclaration");
    Intrinsics.checkParameterIsNotNull(paramJavaTypeParameterListOwner, "typeParameterOwner");
    return child(paramLazyJavaResolverContext, paramDeclarationDescriptor, paramJavaTypeParameterListOwner, paramInt, paramLazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
  }
  
  @Nullable
  public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$computeNewDefaultTypeQualifiers");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "additionalAnnotations");
    if (paramLazyJavaResolverContext.getComponents().getAnnotationTypeQualifierResolver().getDisabled()) {
      return paramLazyJavaResolverContext.getDefaultTypeQualifiers();
    }
    Object localObject1 = (Iterable)paramAnnotations;
    paramAnnotations = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = extractDefaultNullabilityQualifier(paramLazyJavaResolverContext, (AnnotationDescriptor)((Iterator)localObject1).next());
      if (localObject2 != null) {
        paramAnnotations.add(localObject2);
      }
    }
    localObject1 = (List)paramAnnotations;
    if (((List)localObject1).isEmpty()) {
      return paramLazyJavaResolverContext.getDefaultTypeQualifiers();
    }
    paramAnnotations = paramLazyJavaResolverContext.getDefaultTypeQualifiers();
    if (paramAnnotations != null)
    {
      paramAnnotations = paramAnnotations.getNullabilityQualifiers();
      if (paramAnnotations != null)
      {
        paramAnnotations = new EnumMap(paramAnnotations);
        break label153;
      }
    }
    paramAnnotations = new EnumMap(AnnotationTypeQualifierResolver.QualifierApplicabilityType.class);
    label153:
    int i = 0;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (NullabilityQualifierWithApplicability)((Iterator)localObject1).next();
      localObject2 = ((NullabilityQualifierWithApplicability)localObject3).component1();
      localObject3 = ((NullabilityQualifierWithApplicability)localObject3).component2().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        AnnotationTypeQualifierResolver.QualifierApplicabilityType localQualifierApplicabilityType = (AnnotationTypeQualifierResolver.QualifierApplicabilityType)((Iterator)localObject3).next();
        ((Map)paramAnnotations).put(localQualifierApplicabilityType, localObject2);
        i = 1;
      }
    }
    if (i == 0) {
      return paramLazyJavaResolverContext.getDefaultTypeQualifiers();
    }
    return new JavaTypeQualifiersByElementType(paramAnnotations);
  }
  
  @NotNull
  public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$copyWithNewDefaultTypeQualifiers");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "additionalAnnotations");
    if (paramAnnotations.isEmpty()) {
      return paramLazyJavaResolverContext;
    }
    return new LazyJavaResolverContext(paramLazyJavaResolverContext.getComponents(), paramLazyJavaResolverContext.getTypeParameterResolver(), LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)new ContextKt.copyWithNewDefaultTypeQualifiers.1(paramLazyJavaResolverContext, paramAnnotations)));
  }
  
  private static final NullabilityQualifierWithApplicability extractDefaultNullabilityQualifier(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, AnnotationDescriptor paramAnnotationDescriptor)
  {
    AnnotationTypeQualifierResolver localAnnotationTypeQualifierResolver = paramLazyJavaResolverContext.getComponents().getAnnotationTypeQualifierResolver();
    Object localObject = localAnnotationTypeQualifierResolver.resolveQualifierBuiltInDefaultAnnotation(paramAnnotationDescriptor);
    if (localObject != null) {
      return localObject;
    }
    localObject = localAnnotationTypeQualifierResolver.resolveTypeQualifierDefaultAnnotation(paramAnnotationDescriptor);
    if (localObject != null)
    {
      AnnotationDescriptor localAnnotationDescriptor = ((AnnotationTypeQualifierResolver.TypeQualifierWithApplicability)localObject).component1();
      localObject = ((AnnotationTypeQualifierResolver.TypeQualifierWithApplicability)localObject).component2();
      paramAnnotationDescriptor = localAnnotationTypeQualifierResolver.resolveJsr305CustomState(paramAnnotationDescriptor);
      if (paramAnnotationDescriptor == null) {
        paramAnnotationDescriptor = localAnnotationTypeQualifierResolver.resolveJsr305AnnotationState(localAnnotationDescriptor);
      }
      if (paramAnnotationDescriptor.isIgnore()) {
        return null;
      }
      paramLazyJavaResolverContext = paramLazyJavaResolverContext.getComponents().getSignatureEnhancement().extractNullability(localAnnotationDescriptor);
      if (paramLazyJavaResolverContext != null)
      {
        paramLazyJavaResolverContext = NullabilityQualifierWithMigrationStatus.copy$default(paramLazyJavaResolverContext, null, paramAnnotationDescriptor.isWarning(), 1, null);
        if (paramLazyJavaResolverContext != null) {
          return new NullabilityQualifierWithApplicability(paramLazyJavaResolverContext, (Collection)localObject);
        }
      }
    }
    return null;
  }
  
  @NotNull
  public static final LazyJavaResolverContext replaceComponents(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaResolverComponents paramJavaResolverComponents)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$replaceComponents");
    Intrinsics.checkParameterIsNotNull(paramJavaResolverComponents, "components");
    return new LazyJavaResolverContext(paramJavaResolverComponents, paramLazyJavaResolverContext.getTypeParameterResolver(), paramLazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt
 * JD-Core Version:    0.7.0.1
 */