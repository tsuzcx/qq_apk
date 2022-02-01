package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.AnnotationDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SignatureEnhancement
{
  private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
  private final Jsr305State jsr305State;
  
  public SignatureEnhancement(@NotNull AnnotationTypeQualifierResolver paramAnnotationTypeQualifierResolver, @NotNull Jsr305State paramJsr305State)
  {
    this.annotationTypeQualifierResolver = paramAnnotationTypeQualifierResolver;
    this.jsr305State = paramJsr305State;
  }
  
  private final <D extends CallableMemberDescriptor> D enhanceSignature(@NotNull D paramD, LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    if (!(paramD instanceof JavaCallableMemberDescriptor)) {
      return paramD;
    }
    JavaCallableMemberDescriptor localJavaCallableMemberDescriptor = (JavaCallableMemberDescriptor)paramD;
    if (localJavaCallableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE)
    {
      localObject1 = localJavaCallableMemberDescriptor.getOriginal();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "original");
      if (((CallableMemberDescriptor)localObject1).getOverriddenDescriptors().size() == 1) {
        return paramD;
      }
    }
    Object localObject4 = ContextKt.copyWithNewDefaultTypeQualifiers(paramLazyJavaResolverContext, paramD.getAnnotations());
    if ((paramD instanceof JavaPropertyDescriptor))
    {
      paramLazyJavaResolverContext = (JavaPropertyDescriptor)paramD;
      localObject1 = paramLazyJavaResolverContext.getGetter();
      if ((localObject1 != null) && (!((PropertyGetterDescriptorImpl)localObject1).isDefault()))
      {
        paramLazyJavaResolverContext = paramLazyJavaResolverContext.getGetter();
        if (paramLazyJavaResolverContext == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(paramLazyJavaResolverContext, "getter!!");
        paramLazyJavaResolverContext = (CallableMemberDescriptor)paramLazyJavaResolverContext;
        break label133;
      }
    }
    paramLazyJavaResolverContext = paramD;
    label133:
    if (localJavaCallableMemberDescriptor.getExtensionReceiverParameter() != null)
    {
      if (!(paramLazyJavaResolverContext instanceof FunctionDescriptor)) {
        localObject1 = null;
      } else {
        localObject1 = paramLazyJavaResolverContext;
      }
      localObject1 = (FunctionDescriptor)localObject1;
      if (localObject1 != null) {
        localObject1 = (ValueParameterDescriptor)((FunctionDescriptor)localObject1).getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
      } else {
        localObject1 = null;
      }
      localObject1 = SignatureEnhancement.SignatureParts.enhance$default(partsForValueParameter(paramD, (ValueParameterDescriptor)localObject1, (LazyJavaResolverContext)localObject4, (Function1)SignatureEnhancement.enhanceSignature.receiverTypeEnhancement.1.INSTANCE), null, 1, null);
    }
    else
    {
      localObject1 = null;
    }
    if (!(paramD instanceof JavaMethodDescriptor)) {
      localObject2 = null;
    } else {
      localObject2 = paramD;
    }
    Object localObject2 = (JavaMethodDescriptor)localObject2;
    if (localObject2 != null)
    {
      localObject3 = SignatureBuildingComponents.INSTANCE;
      localObject5 = ((JavaMethodDescriptor)localObject2).getContainingDeclaration();
      if (localObject5 != null)
      {
        localObject2 = ((SignatureBuildingComponents)localObject3).signature((ClassDescriptor)localObject5, MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)localObject2, false, false, 3, null));
        if (localObject2 != null)
        {
          localObject2 = (PredefinedFunctionEnhancementInfo)PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(localObject2);
          break label326;
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      }
    }
    localObject2 = null;
    label326:
    if (localObject2 != null)
    {
      if (((PredefinedFunctionEnhancementInfo)localObject2).getParametersInfo().size() == localJavaCallableMemberDescriptor.getValueParameters().size()) {
        i = 1;
      } else {
        i = 0;
      }
      if ((_Assertions.ENABLED) && (i == 0))
      {
        paramLazyJavaResolverContext = new StringBuilder();
        paramLazyJavaResolverContext.append("Predefined enhancement info for ");
        paramLazyJavaResolverContext.append(paramD);
        paramLazyJavaResolverContext.append(" has ");
        paramLazyJavaResolverContext.append(((PredefinedFunctionEnhancementInfo)localObject2).getParametersInfo().size());
        paramLazyJavaResolverContext.append(", but ");
        paramLazyJavaResolverContext.append(localJavaCallableMemberDescriptor.getValueParameters().size());
        paramLazyJavaResolverContext.append(" expected");
        throw ((Throwable)new AssertionError(paramLazyJavaResolverContext.toString()));
      }
    }
    Object localObject3 = paramLazyJavaResolverContext.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "annotationOwnerForMember.valueParameters");
    localObject3 = (Iterable)localObject3;
    Object localObject5 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    Iterator localIterator = ((Iterable)localObject3).iterator();
    while (localIterator.hasNext())
    {
      ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)localIterator.next();
      Object localObject6 = partsForValueParameter(paramD, localValueParameterDescriptor, (LazyJavaResolverContext)localObject4, (Function1)new SignatureEnhancement.enhanceSignature.valueParameterEnhancements.1.enhancementResult.1(localValueParameterDescriptor));
      if (localObject2 != null)
      {
        localObject3 = ((PredefinedFunctionEnhancementInfo)localObject2).getParametersInfo();
        if (localObject3 != null)
        {
          localObject3 = (TypeEnhancementInfo)CollectionsKt.getOrNull((List)localObject3, localValueParameterDescriptor.getIndex());
          break label600;
        }
      }
      localObject3 = null;
      label600:
      localObject6 = ((SignatureEnhancement.SignatureParts)localObject6).enhance((TypeEnhancementInfo)localObject3);
      if (((SignatureEnhancement.PartEnhancementResult)localObject6).getWereChanges())
      {
        localObject3 = ((SignatureEnhancement.PartEnhancementResult)localObject6).getType();
      }
      else
      {
        Intrinsics.checkExpressionValueIsNotNull(localValueParameterDescriptor, "p");
        localObject3 = localValueParameterDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "p.type");
      }
      Intrinsics.checkExpressionValueIsNotNull(localValueParameterDescriptor, "p");
      boolean bool2 = hasDefaultValueInAnnotation(localValueParameterDescriptor, (KotlinType)localObject3);
      boolean bool1;
      if ((!((SignatureEnhancement.PartEnhancementResult)localObject6).getWereChanges()) && (bool2 == localValueParameterDescriptor.declaresDefaultValue())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      ((Collection)localObject5).add(new SignatureEnhancement.ValueParameterEnhancementResult(((SignatureEnhancement.PartEnhancementResult)localObject6).getType(), bool2, bool1, ((SignatureEnhancement.PartEnhancementResult)localObject6).getContainsFunctionN()));
    }
    localObject3 = (List)localObject5;
    localObject5 = (Annotated)paramLazyJavaResolverContext;
    if (!(paramD instanceof PropertyDescriptor)) {
      paramLazyJavaResolverContext = null;
    } else {
      paramLazyJavaResolverContext = paramD;
    }
    paramLazyJavaResolverContext = (PropertyDescriptor)paramLazyJavaResolverContext;
    if ((paramLazyJavaResolverContext != null) && (JavaDescriptorUtilKt.isJavaField(paramLazyJavaResolverContext) == true)) {
      paramLazyJavaResolverContext = AnnotationTypeQualifierResolver.QualifierApplicabilityType.FIELD;
    } else {
      paramLazyJavaResolverContext = AnnotationTypeQualifierResolver.QualifierApplicabilityType.METHOD_RETURN_TYPE;
    }
    localObject4 = parts(paramD, (Annotated)localObject5, true, (LazyJavaResolverContext)localObject4, paramLazyJavaResolverContext, (Function1)SignatureEnhancement.enhanceSignature.returnTypeEnhancement.1.INSTANCE);
    if (localObject2 != null) {
      paramLazyJavaResolverContext = ((PredefinedFunctionEnhancementInfo)localObject2).getReturnTypeInfo();
    } else {
      paramLazyJavaResolverContext = null;
    }
    localObject2 = ((SignatureEnhancement.SignatureParts)localObject4).enhance(paramLazyJavaResolverContext);
    if (((localObject1 == null) || (((SignatureEnhancement.PartEnhancementResult)localObject1).getContainsFunctionN() != true)) && (!((SignatureEnhancement.PartEnhancementResult)localObject2).getContainsFunctionN()))
    {
      paramLazyJavaResolverContext = (Iterable)localObject3;
      if (((paramLazyJavaResolverContext instanceof Collection)) && (((Collection)paramLazyJavaResolverContext).isEmpty())) {}
      do
      {
        while (!paramLazyJavaResolverContext.hasNext())
        {
          i = 0;
          break;
          paramLazyJavaResolverContext = paramLazyJavaResolverContext.iterator();
        }
      } while (!((SignatureEnhancement.ValueParameterEnhancementResult)paramLazyJavaResolverContext.next()).getContainsFunctionN());
      i = 1;
      if (i == 0)
      {
        i = 0;
        break label931;
      }
    }
    int i = 1;
    label931:
    if (((localObject1 == null) || (((SignatureEnhancement.PartEnhancementResult)localObject1).getWereChanges() != true)) && (!((SignatureEnhancement.PartEnhancementResult)localObject2).getWereChanges()))
    {
      paramLazyJavaResolverContext = (Iterable)localObject3;
      if (((paramLazyJavaResolverContext instanceof Collection)) && (((Collection)paramLazyJavaResolverContext).isEmpty())) {}
      do
      {
        while (!paramLazyJavaResolverContext.hasNext())
        {
          j = 0;
          break;
          paramLazyJavaResolverContext = paramLazyJavaResolverContext.iterator();
        }
      } while (!((SignatureEnhancement.ValueParameterEnhancementResult)paramLazyJavaResolverContext.next()).getWereChanges());
      int j = 1;
      if ((j == 0) && (i == 0)) {
        return paramD;
      }
    }
    if (i != 0) {
      paramD = TuplesKt.to(DeprecationKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionN((DeclarationDescriptor)paramD));
    } else {
      paramD = null;
    }
    if (localObject1 != null) {
      paramLazyJavaResolverContext = ((SignatureEnhancement.PartEnhancementResult)localObject1).getType();
    } else {
      paramLazyJavaResolverContext = null;
    }
    localObject3 = (Iterable)localObject3;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SignatureEnhancement.ValueParameterEnhancementResult)((Iterator)localObject3).next();
      ((Collection)localObject1).add(new ValueParameterData(((SignatureEnhancement.ValueParameterEnhancementResult)localObject4).getType(), ((SignatureEnhancement.ValueParameterEnhancementResult)localObject4).getHasDefaultValue()));
    }
    paramD = localJavaCallableMemberDescriptor.enhance(paramLazyJavaResolverContext, (List)localObject1, ((SignatureEnhancement.PartEnhancementResult)localObject2).getType(), paramD);
    if (paramD != null) {
      return (CallableMemberDescriptor)paramD;
    }
    paramD = new TypeCastException("null cannot be cast to non-null type D");
    for (;;)
    {
      throw paramD;
    }
  }
  
  private final NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations(AnnotationDescriptor paramAnnotationDescriptor)
  {
    Object localObject1 = paramAnnotationDescriptor.getFqName();
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(localObject1)) {
        localObject1 = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
      } else if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(localObject1)) {
        localObject1 = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
      } else if (Intrinsics.areEqual(localObject1, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION())) {
        localObject1 = extractNullabilityTypeFromArgument(paramAnnotationDescriptor);
      } else if ((Intrinsics.areEqual(localObject1, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION())) && (this.jsr305State.getEnableCompatqualCheckerFrameworkAnnotations())) {
        localObject1 = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
      } else if ((Intrinsics.areEqual(localObject1, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION())) && (this.jsr305State.getEnableCompatqualCheckerFrameworkAnnotations())) {
        localObject1 = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
      } else if (Intrinsics.areEqual(localObject1, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
        localObject1 = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, true);
      } else if (Intrinsics.areEqual(localObject1, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
        localObject1 = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, true);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        if ((!((NullabilityQualifierWithMigrationStatus)localObject1).isForWarningOnly()) && ((paramAnnotationDescriptor instanceof PossiblyExternalAnnotationDescriptor)) && (((PossiblyExternalAnnotationDescriptor)paramAnnotationDescriptor).isIdeExternalAnnotation())) {
          return NullabilityQualifierWithMigrationStatus.copy$default((NullabilityQualifierWithMigrationStatus)localObject1, null, true, 1, null);
        }
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  private final NullabilityQualifierWithMigrationStatus extractNullabilityTypeFromArgument(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    ConstantValue localConstantValue = DescriptorUtilsKt.firstArgument(paramAnnotationDescriptor);
    paramAnnotationDescriptor = localConstantValue;
    if (!(localConstantValue instanceof EnumValue)) {
      paramAnnotationDescriptor = null;
    }
    paramAnnotationDescriptor = (EnumValue)paramAnnotationDescriptor;
    if (paramAnnotationDescriptor != null)
    {
      paramAnnotationDescriptor = paramAnnotationDescriptor.getEnumEntryName().asString();
      switch (paramAnnotationDescriptor.hashCode())
      {
      default: 
        break;
      case 1933739535: 
        if (paramAnnotationDescriptor.equals("ALWAYS")) {
          return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
        }
        break;
      case 433141802: 
        if (paramAnnotationDescriptor.equals("UNKNOWN")) {
          return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
        }
        break;
      case 74175084: 
      case 73135176: 
        if ((paramAnnotationDescriptor.equals("NEVER")) && ((goto 154) || (paramAnnotationDescriptor.equals("MAYBE")))) {
          return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        }
        break;
      }
      return null;
    }
    return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
  }
  
  private final boolean hasDefaultValueInAnnotation(@NotNull ValueParameterDescriptor paramValueParameterDescriptor, KotlinType paramKotlinType)
  {
    AnnotationDefaultValue localAnnotationDefaultValue = UtilKt.getDefaultValueFromAnnotation(paramValueParameterDescriptor);
    boolean bool;
    if ((localAnnotationDefaultValue instanceof StringDefaultValue))
    {
      if (UtilsKt.lexicalCastFrom(paramKotlinType, ((StringDefaultValue)localAnnotationDefaultValue).getValue()) != null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else if (Intrinsics.areEqual(localAnnotationDefaultValue, NullDefaultValue.INSTANCE))
    {
      bool = TypeUtils.acceptsNullable(paramKotlinType);
    }
    else
    {
      if (localAnnotationDefaultValue != null) {
        break label92;
      }
      bool = paramValueParameterDescriptor.declaresDefaultValue();
    }
    return (bool) && (paramValueParameterDescriptor.getOverriddenDescriptors().isEmpty());
    label92:
    throw new NoWhenBranchMatchedException();
  }
  
  private final SignatureEnhancement.SignatureParts parts(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, Annotated paramAnnotated, boolean paramBoolean, LazyJavaResolverContext paramLazyJavaResolverContext, AnnotationTypeQualifierResolver.QualifierApplicabilityType paramQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> paramFunction1)
  {
    KotlinType localKotlinType = (KotlinType)paramFunction1.invoke(paramCallableMemberDescriptor);
    Collection localCollection = paramCallableMemberDescriptor.getOverriddenDescriptors();
    Intrinsics.checkExpressionValueIsNotNull(localCollection, "this.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CallableMemberDescriptor localCallableMemberDescriptor = (CallableMemberDescriptor)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localCallableMemberDescriptor, "it");
      localCollection.add((KotlinType)paramFunction1.invoke(localCallableMemberDescriptor));
    }
    return new SignatureEnhancement.SignatureParts(this, paramAnnotated, localKotlinType, (Collection)localCollection, paramBoolean, ContextKt.copyWithNewDefaultTypeQualifiers(paramLazyJavaResolverContext, ((KotlinType)paramFunction1.invoke(paramCallableMemberDescriptor)).getAnnotations()), paramQualifierApplicabilityType);
  }
  
  private final SignatureEnhancement.SignatureParts partsForValueParameter(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, ValueParameterDescriptor paramValueParameterDescriptor, LazyJavaResolverContext paramLazyJavaResolverContext, Function1<? super CallableMemberDescriptor, ? extends KotlinType> paramFunction1)
  {
    Annotated localAnnotated = (Annotated)paramValueParameterDescriptor;
    if (paramValueParameterDescriptor != null)
    {
      paramValueParameterDescriptor = ContextKt.copyWithNewDefaultTypeQualifiers(paramLazyJavaResolverContext, paramValueParameterDescriptor.getAnnotations());
      if (paramValueParameterDescriptor != null) {}
    }
    else
    {
      paramValueParameterDescriptor = paramLazyJavaResolverContext;
    }
    return parts(paramCallableMemberDescriptor, localAnnotated, false, paramValueParameterDescriptor, AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER, paramFunction1);
  }
  
  @NotNull
  public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull Collection<? extends D> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "c");
    Intrinsics.checkParameterIsNotNull(paramCollection, "platformSignatures");
    Object localObject = (Iterable)paramCollection;
    paramCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramCollection.add(enhanceSignature((CallableMemberDescriptor)((Iterator)localObject).next(), paramLazyJavaResolverContext));
    }
    return (Collection)paramCollection;
  }
  
  @Nullable
  public final NullabilityQualifierWithMigrationStatus extractNullability(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotationDescriptor");
    Object localObject1 = extractNullabilityFromKnownAnnotations(paramAnnotationDescriptor);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject3 = this.annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(paramAnnotationDescriptor);
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      paramAnnotationDescriptor = this.annotationTypeQualifierResolver.resolveJsr305AnnotationState(paramAnnotationDescriptor);
      if (paramAnnotationDescriptor.isIgnore()) {
        return null;
      }
      localObject3 = extractNullabilityFromKnownAnnotations((AnnotationDescriptor)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = NullabilityQualifierWithMigrationStatus.copy$default((NullabilityQualifierWithMigrationStatus)localObject3, null, paramAnnotationDescriptor.isWarning(), 1, null);
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement
 * JD-Core Version:    0.7.0.1
 */