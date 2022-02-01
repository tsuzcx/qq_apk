package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function1<-Lkotlin.reflect.jvm.internal.impl.name.Name;+Ljava.util.Collection<+Lkotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;>;>;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.PropagatedSignature;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassMemberScope
  extends LazyJavaScope
{
  @NotNull
  private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
  private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
  private final JavaClass jClass;
  private final NotNullLazyValue<Set<Name>> nestedClassIndex;
  private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;
  @NotNull
  private final ClassDescriptor ownerDescriptor;
  private final boolean skipRefinement;
  
  public LazyJavaClassMemberScope(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull ClassDescriptor paramClassDescriptor, @NotNull JavaClass paramJavaClass, boolean paramBoolean, @Nullable LazyJavaClassMemberScope paramLazyJavaClassMemberScope)
  {
    super(paramLazyJavaResolverContext, (LazyJavaScope)paramLazyJavaClassMemberScope);
    this.ownerDescriptor = paramClassDescriptor;
    this.jClass = paramJavaClass;
    this.skipRefinement = paramBoolean;
    this.constructors = paramLazyJavaResolverContext.getStorageManager().createLazyValue((Function0)new LazyJavaClassMemberScope.constructors.1(this, paramLazyJavaResolverContext));
    this.nestedClassIndex = paramLazyJavaResolverContext.getStorageManager().createLazyValue((Function0)new LazyJavaClassMemberScope.nestedClassIndex.1(this));
    this.enumEntryIndex = paramLazyJavaResolverContext.getStorageManager().createLazyValue((Function0)new LazyJavaClassMemberScope.enumEntryIndex.1(this));
    this.nestedClasses = paramLazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new LazyJavaClassMemberScope.nestedClasses.1(this, paramLazyJavaResolverContext));
  }
  
  private final void addAnnotationValueParameter(@NotNull List<ValueParameterDescriptor> paramList, ConstructorDescriptor paramConstructorDescriptor, int paramInt, JavaMethod paramJavaMethod, KotlinType paramKotlinType1, KotlinType paramKotlinType2)
  {
    CallableDescriptor localCallableDescriptor = (CallableDescriptor)paramConstructorDescriptor;
    Annotations localAnnotations = Annotations.Companion.getEMPTY();
    Name localName = paramJavaMethod.getName();
    paramKotlinType1 = TypeUtils.makeNotNullable(paramKotlinType1);
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType1, "TypeUtils.makeNotNullable(returnType)");
    boolean bool = paramJavaMethod.getHasAnnotationParameterDefaultValue();
    if (paramKotlinType2 != null) {
      paramConstructorDescriptor = TypeUtils.makeNotNullable(paramKotlinType2);
    } else {
      paramConstructorDescriptor = null;
    }
    paramList.add(new ValueParameterDescriptorImpl(localCallableDescriptor, null, paramInt, localAnnotations, localName, paramKotlinType1, bool, false, false, paramConstructorDescriptor, (SourceElement)getC().getComponents().getSourceElementFactory().source((JavaElement)paramJavaMethod)));
  }
  
  private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> paramCollection, Name paramName, Collection<? extends SimpleFunctionDescriptor> paramCollection1, boolean paramBoolean)
  {
    paramName = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(paramName, paramCollection1, paramCollection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
    Intrinsics.checkExpressionValueIsNotNull(paramName, "resolveOverridesForNonSt….overridingUtil\n        )");
    if (!paramBoolean)
    {
      paramCollection.addAll(paramName);
      return;
    }
    paramName = (Iterable)paramName;
    List localList = kotlin.collections.CollectionsKt.plus(paramCollection, paramName);
    Collection localCollection = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(paramName, 10));
    Iterator localIterator = paramName.iterator();
    while (localIterator.hasNext())
    {
      paramCollection1 = (SimpleFunctionDescriptor)localIterator.next();
      SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor)paramCollection1);
      paramName = paramCollection1;
      if (localSimpleFunctionDescriptor != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramCollection1, "resolvedOverride");
        paramName = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(paramCollection1, (CallableDescriptor)localSimpleFunctionDescriptor, (Collection)localList);
      }
      localCollection.add(paramName);
    }
    paramCollection.addAll((Collection)localCollection);
  }
  
  private final void addOverriddenSpecialMethods(Name paramName, Collection<? extends SimpleFunctionDescriptor> paramCollection1, Collection<? extends SimpleFunctionDescriptor> paramCollection2, Collection<SimpleFunctionDescriptor> paramCollection, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext())
    {
      SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)paramCollection2.next();
      kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(paramCollection, obtainOverrideForBuiltinWithDifferentJvmName(localSimpleFunctionDescriptor, paramFunction1, paramName, paramCollection1));
      kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(paramCollection, obtainOverrideForBuiltInWithErasedValueParametersInJava(localSimpleFunctionDescriptor, paramFunction1, paramCollection1));
      kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(paramCollection, obtainOverrideForSuspend(localSimpleFunctionDescriptor, paramFunction1));
    }
  }
  
  private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> paramSet, Collection<PropertyDescriptor> paramCollection, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      JavaPropertyDescriptor localJavaPropertyDescriptor = createPropertyDescriptorByMethods((PropertyDescriptor)paramSet.next(), paramFunction1);
      if (localJavaPropertyDescriptor != null) {
        paramCollection.add(localJavaPropertyDescriptor);
      }
    }
  }
  
  private final void computeAnnotationProperties(Name paramName, Collection<PropertyDescriptor> paramCollection)
  {
    paramName = (JavaMethod)kotlin.collections.CollectionsKt.singleOrNull((Iterable)((DeclaredMemberIndex)getDeclaredMemberIndex().invoke()).findMethodsByName(paramName));
    if (paramName != null) {
      paramCollection.add(createPropertyDescriptorWithDefaultGetter$default(this, paramName, null, Modality.FINAL, 2, null));
    }
  }
  
  private final Collection<KotlinType> computeSupertypes()
  {
    if (this.skipRefinement)
    {
      Object localObject = getOwnerDescriptor().getTypeConstructor();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ownerDescriptor.typeConstructor");
      localObject = ((TypeConstructor)localObject).getSupertypes();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ownerDescriptor.typeConstructor.supertypes");
      return localObject;
    }
    return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
  }
  
  private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl paramClassConstructorDescriptorImpl)
  {
    Object localObject1 = this.jClass.getMethods();
    ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
    JavaTypeAttributes localJavaTypeAttributes = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, true, null, 2, null);
    Object localObject3 = (Iterable)localObject1;
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (Intrinsics.areEqual(((JavaMethod)localObject4).getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
        ((ArrayList)localObject1).add(localObject4);
      } else {
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    localObject2 = new Pair(localObject1, localObject2);
    localObject1 = (List)((Pair)localObject2).component1();
    localObject2 = (List)((Pair)localObject2).component2();
    int i = ((List)localObject1).size();
    int j = 0;
    if (i <= 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramClassConstructorDescriptorImpl = new StringBuilder();
      paramClassConstructorDescriptorImpl.append("There can't be more than one method named 'value' in annotation class: ");
      paramClassConstructorDescriptorImpl.append(this.jClass);
      throw ((Throwable)new AssertionError(paramClassConstructorDescriptorImpl.toString()));
    }
    localObject3 = (JavaMethod)kotlin.collections.CollectionsKt.firstOrNull((List)localObject1);
    if (localObject3 != null)
    {
      localObject4 = ((JavaMethod)localObject3).getReturnType();
      if ((localObject4 instanceof JavaArrayType))
      {
        localObject1 = getC().getTypeResolver();
        localObject4 = (JavaArrayType)localObject4;
        localObject1 = new Pair(((JavaTypeResolver)localObject1).transformArrayType((JavaArrayType)localObject4, localJavaTypeAttributes, true), getC().getTypeResolver().transformJavaType(((JavaArrayType)localObject4).getComponentType(), localJavaTypeAttributes));
      }
      else
      {
        localObject1 = new Pair(getC().getTypeResolver().transformJavaType((JavaType)localObject4, localJavaTypeAttributes), null);
      }
      localObject4 = (KotlinType)((Pair)localObject1).component1();
      localObject1 = (KotlinType)((Pair)localObject1).component2();
      addAnnotationValueParameter((List)localArrayList, (ConstructorDescriptor)paramClassConstructorDescriptorImpl, 0, (JavaMethod)localObject3, (KotlinType)localObject4, (KotlinType)localObject1);
    }
    if (localObject3 != null) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (JavaMethod)((Iterator)localObject1).next();
      localObject3 = getC().getTypeResolver().transformJavaType(((JavaMethod)localObject2).getReturnType(), localJavaTypeAttributes);
      addAnnotationValueParameter((List)localArrayList, (ConstructorDescriptor)paramClassConstructorDescriptorImpl, j + i, (JavaMethod)localObject2, (KotlinType)localObject3, null);
      j += 1;
    }
    return (List)localArrayList;
  }
  
  private final ClassConstructorDescriptor createDefaultConstructor()
  {
    boolean bool = this.jClass.isAnnotationType();
    if (((this.jClass.isInterface()) || (!this.jClass.hasDefaultConstructor())) && (!bool)) {
      return null;
    }
    ClassDescriptor localClassDescriptor = getOwnerDescriptor();
    JavaClassConstructorDescriptor localJavaClassConstructorDescriptor = JavaClassConstructorDescriptor.createJavaConstructor(localClassDescriptor, Annotations.Companion.getEMPTY(), true, (SourceElement)getC().getComponents().getSourceElementFactory().source((JavaElement)this.jClass));
    Intrinsics.checkExpressionValueIsNotNull(localJavaClassConstructorDescriptor, "JavaClassConstructorDesc….source(jClass)\n        )");
    List localList;
    if (bool) {
      localList = createAnnotationConstructorParameters((ClassConstructorDescriptorImpl)localJavaClassConstructorDescriptor);
    } else {
      localList = Collections.emptyList();
    }
    localJavaClassConstructorDescriptor.setHasSynthesizedParameterNames(false);
    localJavaClassConstructorDescriptor.initialize(localList, getConstructorVisibility(localClassDescriptor));
    localJavaClassConstructorDescriptor.setHasStableParameterNames(true);
    localJavaClassConstructorDescriptor.setReturnType((KotlinType)localClassDescriptor.getDefaultType());
    getC().getComponents().getJavaResolverCache().recordConstructor((JavaElement)this.jClass, (ConstructorDescriptor)localJavaClassConstructorDescriptor);
    return (ClassConstructorDescriptor)localJavaClassConstructorDescriptor;
  }
  
  private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor, CallableDescriptor paramCallableDescriptor, Collection<? extends SimpleFunctionDescriptor> paramCollection)
  {
    paramCollection = (Iterable)paramCollection;
    boolean bool = paramCollection instanceof Collection;
    int j = 1;
    int i;
    if ((bool) && (((Collection)paramCollection).isEmpty()))
    {
      i = j;
    }
    else
    {
      paramCollection = paramCollection.iterator();
      do
      {
        i = j;
        if (!paramCollection.hasNext()) {
          break;
        }
        SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)paramCollection.next();
        if (((Intrinsics.areEqual(paramSimpleFunctionDescriptor, localSimpleFunctionDescriptor) ^ true)) && (localSimpleFunctionDescriptor.getInitialSignatureDescriptor() == null) && (doesOverride((CallableDescriptor)localSimpleFunctionDescriptor, paramCallableDescriptor))) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i == 0);
      i = 0;
    }
    if (i != 0) {
      return paramSimpleFunctionDescriptor;
    }
    paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
    if (paramSimpleFunctionDescriptor == null) {
      Intrinsics.throwNpe();
    }
    return (SimpleFunctionDescriptor)paramSimpleFunctionDescriptor;
  }
  
  private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor paramFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    Object localObject1 = paramFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "overridden.name");
    Object localObject2 = ((Iterable)paramFunction1.invoke(localObject1)).iterator();
    do
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      localObject1 = null;
      if (!bool) {
        break;
      }
      paramFunction1 = ((Iterator)localObject2).next();
    } while (!hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor)paramFunction1, paramFunctionDescriptor));
    break label74;
    paramFunction1 = null;
    label74:
    localObject2 = (SimpleFunctionDescriptor)paramFunction1;
    paramFunction1 = (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)localObject1;
    if (localObject2 != null)
    {
      paramFunction1 = ((SimpleFunctionDescriptor)localObject2).newCopyBuilder();
      localObject1 = paramFunctionDescriptor.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "overridden.valueParameters");
      Object localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)((Iterator)localObject3).next();
        Intrinsics.checkExpressionValueIsNotNull(localValueParameterDescriptor, "it");
        KotlinType localKotlinType = localValueParameterDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "it.type");
        ((Collection)localObject1).add(new ValueParameterData(localKotlinType, localValueParameterDescriptor.declaresDefaultValue()));
      }
      localObject1 = (Collection)localObject1;
      localObject2 = ((SimpleFunctionDescriptor)localObject2).getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "override.valueParameters");
      paramFunction1.setValueParameters(UtilKt.copyValueParameters((Collection)localObject1, (Collection)localObject2, (CallableDescriptor)paramFunctionDescriptor));
      paramFunction1.setSignatureChange();
      paramFunction1.setPreserveSourceElement();
      paramFunction1 = (SimpleFunctionDescriptor)paramFunction1.build();
    }
    return paramFunction1;
  }
  
  private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor paramPropertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    boolean bool = doesClassOverridesProperty(paramPropertyDescriptor, paramFunction1);
    StringBuilder localStringBuilder = null;
    JavaForKotlinOverridePropertyDescriptor localJavaForKotlinOverridePropertyDescriptor = null;
    if (!bool) {
      return null;
    }
    SimpleFunctionDescriptor localSimpleFunctionDescriptor = findGetterOverride(paramPropertyDescriptor, paramFunction1);
    if (localSimpleFunctionDescriptor == null) {
      Intrinsics.throwNpe();
    }
    if (paramPropertyDescriptor.isVar())
    {
      localObject = findSetterOverride(paramPropertyDescriptor, paramFunction1);
      paramFunction1 = (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)localObject;
      if (localObject == null)
      {
        Intrinsics.throwNpe();
        paramFunction1 = (Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>>)localObject;
      }
    }
    else
    {
      paramFunction1 = null;
    }
    int j = 1;
    int i = j;
    if (paramFunction1 != null) {
      if (paramFunction1.getModality() == localSimpleFunctionDescriptor.getModality()) {
        i = j;
      } else {
        i = 0;
      }
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Different accessors modalities when creating overrides for ");
      localStringBuilder.append(paramPropertyDescriptor);
      localStringBuilder.append(" in ");
      localStringBuilder.append(getOwnerDescriptor());
      localStringBuilder.append("for getter is ");
      localStringBuilder.append(localSimpleFunctionDescriptor.getModality());
      localStringBuilder.append(", but for setter is ");
      paramPropertyDescriptor = localJavaForKotlinOverridePropertyDescriptor;
      if (paramFunction1 != null) {
        paramPropertyDescriptor = paramFunction1.getModality();
      }
      localStringBuilder.append(paramPropertyDescriptor);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    localJavaForKotlinOverridePropertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), localSimpleFunctionDescriptor, paramFunction1, paramPropertyDescriptor);
    paramPropertyDescriptor = localSimpleFunctionDescriptor.getReturnType();
    if (paramPropertyDescriptor == null) {
      Intrinsics.throwNpe();
    }
    localJavaForKotlinOverridePropertyDescriptor.setType(paramPropertyDescriptor, kotlin.collections.CollectionsKt.emptyList(), getDispatchReceiverParameter(), null);
    PropertyDescriptor localPropertyDescriptor = (PropertyDescriptor)localJavaForKotlinOverridePropertyDescriptor;
    Object localObject = DescriptorFactory.createGetter(localPropertyDescriptor, localSimpleFunctionDescriptor.getAnnotations(), false, false, false, localSimpleFunctionDescriptor.getSource());
    ((PropertyGetterDescriptorImpl)localObject).setInitialSignatureDescriptor((FunctionDescriptor)localSimpleFunctionDescriptor);
    ((PropertyGetterDescriptorImpl)localObject).initialize(localJavaForKotlinOverridePropertyDescriptor.getType());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "DescriptorFactory.create…escriptor.type)\n        }");
    paramPropertyDescriptor = localStringBuilder;
    if (paramFunction1 != null)
    {
      paramPropertyDescriptor = paramFunction1.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "setterMethod.valueParameters");
      paramPropertyDescriptor = (ValueParameterDescriptor)kotlin.collections.CollectionsKt.firstOrNull(paramPropertyDescriptor);
      if (paramPropertyDescriptor != null)
      {
        paramPropertyDescriptor = DescriptorFactory.createSetter(localPropertyDescriptor, paramFunction1.getAnnotations(), paramPropertyDescriptor.getAnnotations(), false, false, false, paramFunction1.getVisibility(), paramFunction1.getSource());
        paramPropertyDescriptor.setInitialSignatureDescriptor((FunctionDescriptor)paramFunction1);
      }
      else
      {
        paramPropertyDescriptor = new StringBuilder();
        paramPropertyDescriptor.append("No parameter found for ");
        paramPropertyDescriptor.append(paramFunction1);
        throw ((Throwable)new AssertionError(paramPropertyDescriptor.toString()));
      }
    }
    localJavaForKotlinOverridePropertyDescriptor.initialize((PropertyGetterDescriptorImpl)localObject, (PropertySetterDescriptor)paramPropertyDescriptor);
    return (JavaPropertyDescriptor)localJavaForKotlinOverridePropertyDescriptor;
  }
  
  private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod paramJavaMethod, KotlinType paramKotlinType, Modality paramModality)
  {
    Object localObject = LazyJavaAnnotationsKt.resolveAnnotations(getC(), (JavaAnnotationOwner)paramJavaMethod);
    paramModality = JavaPropertyDescriptor.create((DeclarationDescriptor)getOwnerDescriptor(), (Annotations)localObject, paramModality, paramJavaMethod.getVisibility(), false, paramJavaMethod.getName(), (SourceElement)getC().getComponents().getSourceElementFactory().source((JavaElement)paramJavaMethod), false);
    Intrinsics.checkExpressionValueIsNotNull(paramModality, "JavaPropertyDescriptor.c…inal = */ false\n        )");
    localObject = DescriptorFactory.createDefaultGetter((PropertyDescriptor)paramModality, Annotations.Companion.getEMPTY());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
    paramModality.initialize((PropertyGetterDescriptorImpl)localObject, null);
    if (paramKotlinType == null) {
      paramKotlinType = computeMethodReturnType(paramJavaMethod, ContextKt.childForMethod$default(getC(), (DeclarationDescriptor)paramModality, (JavaTypeParameterListOwner)paramJavaMethod, 0, 4, null));
    }
    paramModality.setType(paramKotlinType, kotlin.collections.CollectionsKt.emptyList(), getDispatchReceiverParameter(), null);
    ((PropertyGetterDescriptorImpl)localObject).initialize(paramKotlinType);
    return paramModality;
  }
  
  private final SimpleFunctionDescriptor createRenamedCopy(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor, Name paramName)
  {
    paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.newCopyBuilder();
    paramSimpleFunctionDescriptor.setName(paramName);
    paramSimpleFunctionDescriptor.setSignatureChange();
    paramSimpleFunctionDescriptor.setPreserveSourceElement();
    paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.build();
    if (paramSimpleFunctionDescriptor == null) {
      Intrinsics.throwNpe();
    }
    return (SimpleFunctionDescriptor)paramSimpleFunctionDescriptor;
  }
  
  private final SimpleFunctionDescriptor createSuspendView(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Object localObject1 = paramSimpleFunctionDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "valueParameters");
    Object localObject2 = (ValueParameterDescriptor)kotlin.collections.CollectionsKt.lastOrNull((List)localObject1);
    if (localObject2 != null)
    {
      localObject1 = ((ValueParameterDescriptor)localObject2).getType().getConstructor().getDeclarationDescriptor();
      if (localObject1 != null)
      {
        localObject1 = DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)localObject1);
        if (localObject1 != null)
        {
          if (!((FqNameUnsafe)localObject1).isSafe()) {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject1 = ((FqNameUnsafe)localObject1).toSafe();
            break label83;
          }
        }
      }
      localObject1 = null;
      label83:
      if (SuspendFunctionTypesKt.isContinuation((FqName)localObject1, getC().getComponents().getSettings().isReleaseCoroutines())) {
        localObject1 = localObject2;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject2 = paramSimpleFunctionDescriptor.newCopyBuilder();
        paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(paramSimpleFunctionDescriptor, "valueParameters");
        paramSimpleFunctionDescriptor = (SimpleFunctionDescriptor)((FunctionDescriptor.CopyBuilder)localObject2).setValueParameters(kotlin.collections.CollectionsKt.dropLast(paramSimpleFunctionDescriptor, 1)).setReturnType(((TypeProjection)((ValueParameterDescriptor)localObject1).getType().getArguments().get(0)).getType()).build();
        localObject1 = (SimpleFunctionDescriptorImpl)paramSimpleFunctionDescriptor;
        if (localObject1 != null) {
          ((SimpleFunctionDescriptorImpl)localObject1).setSuspend(true);
        }
        return paramSimpleFunctionDescriptor;
      }
    }
    return null;
  }
  
  private final boolean doesClassOverridesProperty(PropertyDescriptor paramPropertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    boolean bool1 = JavaDescriptorUtilKt.isJavaField(paramPropertyDescriptor);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    SimpleFunctionDescriptor localSimpleFunctionDescriptor = findGetterOverride(paramPropertyDescriptor, paramFunction1);
    paramFunction1 = findSetterOverride(paramPropertyDescriptor, paramFunction1);
    if (localSimpleFunctionDescriptor == null) {
      return false;
    }
    if (!paramPropertyDescriptor.isVar()) {
      return true;
    }
    bool1 = bool2;
    if (paramFunction1 != null)
    {
      bool1 = bool2;
      if (paramFunction1.getModality() == localSimpleFunctionDescriptor.getModality()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final boolean doesOverride(@NotNull CallableDescriptor paramCallableDescriptor1, CallableDescriptor paramCallableDescriptor2)
  {
    Object localObject = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(paramCallableDescriptor2, paramCallableDescriptor1, true);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
    localObject = ((OverridingUtil.OverrideCompatibilityInfo)localObject).getResult();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "OverridingUtil.DEFAULT.i…iptor, this, true).result");
    return (localObject == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) && (!JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(paramCallableDescriptor2, paramCallableDescriptor1));
  }
  
  private final boolean doesOverrideRenamedBuiltins(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Object localObject1 = BuiltinMethodsWithDifferentJvmName.INSTANCE;
    Object localObject2 = paramSimpleFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "name");
    localObject1 = (Iterable)((BuiltinMethodsWithDifferentJvmName)localObject1).getBuiltinFunctionNamesByJvmName((Name)localObject2);
    boolean bool1 = localObject1 instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject1).isEmpty())) {
      return false;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (Name)((Iterator)localObject1).next();
      Object localObject4 = (Iterable)getFunctionsFromSupertypes((Name)localObject2);
      Object localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((CallableMemberDescriptor)localObject5)) {
          ((Collection)localObject3).add(localObject5);
        }
      }
      localObject3 = (List)localObject3;
      if (((List)localObject3).isEmpty()) {}
      do
      {
        while (!((Iterator)localObject3).hasNext())
        {
          do
          {
            i = 0;
            break;
            localObject2 = createRenamedCopy(paramSimpleFunctionDescriptor, (Name)localObject2);
            localObject3 = (Iterable)localObject3;
          } while (((localObject3 instanceof Collection)) && (((Collection)localObject3).isEmpty()));
          localObject3 = ((Iterable)localObject3).iterator();
        }
      } while (!doesOverrideRenamedDescriptor((SimpleFunctionDescriptor)((Iterator)localObject3).next(), (FunctionDescriptor)localObject2));
      i = 1;
    } while (i == 0);
    bool1 = true;
    return bool1;
  }
  
  private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor paramSimpleFunctionDescriptor, FunctionDescriptor paramFunctionDescriptor)
  {
    FunctionDescriptor localFunctionDescriptor = paramFunctionDescriptor;
    if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(paramSimpleFunctionDescriptor)) {
      localFunctionDescriptor = paramFunctionDescriptor.getOriginal();
    }
    Intrinsics.checkExpressionValueIsNotNull(localFunctionDescriptor, "if (superDescriptor.isRe…iginal else subDescriptor");
    return doesOverride((CallableDescriptor)localFunctionDescriptor, (CallableDescriptor)paramSimpleFunctionDescriptor);
  }
  
  private final boolean doesOverrideSuspendFunction(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    SimpleFunctionDescriptor localSimpleFunctionDescriptor1 = createSuspendView(paramSimpleFunctionDescriptor);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSimpleFunctionDescriptor1 != null)
    {
      paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(paramSimpleFunctionDescriptor, "name");
      paramSimpleFunctionDescriptor = (Iterable)getFunctionsFromSupertypes(paramSimpleFunctionDescriptor);
      if (((paramSimpleFunctionDescriptor instanceof Collection)) && (((Collection)paramSimpleFunctionDescriptor).isEmpty())) {
        return false;
      }
      paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.iterator();
      int i;
      do
      {
        bool1 = bool2;
        if (!paramSimpleFunctionDescriptor.hasNext()) {
          break;
        }
        SimpleFunctionDescriptor localSimpleFunctionDescriptor2 = (SimpleFunctionDescriptor)paramSimpleFunctionDescriptor.next();
        if ((localSimpleFunctionDescriptor2.isSuspend()) && (doesOverride((CallableDescriptor)localSimpleFunctionDescriptor1, (CallableDescriptor)localSimpleFunctionDescriptor2))) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i == 0);
      bool1 = true;
    }
    return bool1;
  }
  
  private final SimpleFunctionDescriptor findGetterByName(@NotNull PropertyDescriptor paramPropertyDescriptor, String paramString, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    paramString = Name.identifier(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Name.identifier(getterName)");
    Iterator localIterator = ((Iterable)paramFunction1.invoke(paramString)).iterator();
    do
    {
      boolean bool = localIterator.hasNext();
      paramString = null;
      paramFunction1 = null;
      if (!bool) {
        break;
      }
      SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)localIterator.next();
      if (localSimpleFunctionDescriptor.getValueParameters().size() != 0)
      {
        paramString = paramFunction1;
      }
      else
      {
        paramString = KotlinTypeChecker.DEFAULT;
        KotlinType localKotlinType = localSimpleFunctionDescriptor.getReturnType();
        if (localKotlinType != null) {
          bool = paramString.isSubtypeOf(localKotlinType, paramPropertyDescriptor.getType());
        } else {
          bool = false;
        }
        paramString = paramFunction1;
        if (bool) {
          paramString = localSimpleFunctionDescriptor;
        }
      }
    } while (paramString == null);
    return paramString;
  }
  
  private final SimpleFunctionDescriptor findGetterOverride(@NotNull PropertyDescriptor paramPropertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    Object localObject = paramPropertyDescriptor.getGetter();
    String str = null;
    if (localObject != null) {
      localObject = (PropertyGetterDescriptor)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName((CallableMemberDescriptor)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      str = BuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName((CallableMemberDescriptor)localObject);
    }
    if ((str != null) && (!SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), (CallableDescriptor)localObject))) {
      return findGetterByName(paramPropertyDescriptor, str, paramFunction1);
    }
    localObject = JvmAbi.getterName(paramPropertyDescriptor.getName().asString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "JvmAbi.getterName(name.asString())");
    return findGetterByName(paramPropertyDescriptor, (String)localObject, paramFunction1);
  }
  
  private final SimpleFunctionDescriptor findSetterOverride(@NotNull PropertyDescriptor paramPropertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    Name localName = Name.identifier(JvmAbi.setterName(paramPropertyDescriptor.getName().asString()));
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(JvmAbi.s…terName(name.asString()))");
    Iterator localIterator = ((Iterable)paramFunction1.invoke(localName)).iterator();
    do
    {
      boolean bool = localIterator.hasNext();
      paramFunction1 = null;
      localName = null;
      if (!bool) {
        break;
      }
      SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)localIterator.next();
      if (localSimpleFunctionDescriptor.getValueParameters().size() != 1)
      {
        paramFunction1 = localName;
      }
      else
      {
        Object localObject1 = localSimpleFunctionDescriptor.getReturnType();
        paramFunction1 = localName;
        if (localObject1 != null) {
          if (!KotlinBuiltIns.isUnit((KotlinType)localObject1))
          {
            paramFunction1 = localName;
          }
          else
          {
            localObject1 = KotlinTypeChecker.DEFAULT;
            paramFunction1 = localSimpleFunctionDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "descriptor.valueParameters");
            Object localObject2 = kotlin.collections.CollectionsKt.single(paramFunction1);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "descriptor.valueParameters.single()");
            paramFunction1 = localName;
            if (((KotlinTypeChecker)localObject1).equalTypes(((ValueParameterDescriptor)localObject2).getType(), paramPropertyDescriptor.getType())) {
              paramFunction1 = localSimpleFunctionDescriptor;
            }
          }
        }
      }
    } while (paramFunction1 == null);
    return paramFunction1;
  }
  
  private final Visibility getConstructorVisibility(ClassDescriptor paramClassDescriptor)
  {
    Visibility localVisibility = paramClassDescriptor.getVisibility();
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "classDescriptor.visibility");
    paramClassDescriptor = localVisibility;
    if (Intrinsics.areEqual(localVisibility, JavaVisibilities.PROTECTED_STATIC_VISIBILITY))
    {
      paramClassDescriptor = JavaVisibilities.PROTECTED_AND_PACKAGE;
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "JavaVisibilities.PROTECTED_AND_PACKAGE");
    }
    return paramClassDescriptor;
  }
  
  private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name paramName)
  {
    Object localObject = (Iterable)computeSupertypes();
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      kotlin.collections.CollectionsKt.addAll(localCollection, (Iterable)((KotlinType)((Iterator)localObject).next()).getMemberScope().getContributedFunctions(paramName, (LookupLocation)NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }
    return (Set)localCollection;
  }
  
  private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name paramName)
  {
    Object localObject1 = (Iterable)computeSupertypes();
    Collection localCollection1 = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Iterable)((KotlinType)((Iterator)localObject1).next()).getMemberScope().getContributedVariables(paramName, (LookupLocation)NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
      Collection localCollection2 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection2.add((PropertyDescriptor)((Iterator)localObject2).next());
      }
      kotlin.collections.CollectionsKt.addAll(localCollection1, (Iterable)localCollection2);
    }
    return kotlin.collections.CollectionsKt.toSet((Iterable)localCollection1);
  }
  
  private final boolean hasSameJvmDescriptorButDoesNotOverride(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor, FunctionDescriptor paramFunctionDescriptor)
  {
    Object localObject = (FunctionDescriptor)paramSimpleFunctionDescriptor;
    boolean bool2 = false;
    localObject = MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)localObject, false, false, 2, null);
    FunctionDescriptor localFunctionDescriptor = paramFunctionDescriptor.getOriginal();
    Intrinsics.checkExpressionValueIsNotNull(localFunctionDescriptor, "builtinWithErasedParameters.original");
    boolean bool1 = bool2;
    if (Intrinsics.areEqual(localObject, MethodSignatureMappingKt.computeJvmDescriptor$default(localFunctionDescriptor, false, false, 2, null)))
    {
      bool1 = bool2;
      if (!doesOverride((CallableDescriptor)paramSimpleFunctionDescriptor, (CallableDescriptor)paramFunctionDescriptor)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final boolean isVisibleAsFunctionInCurrentClass(SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Object localObject1 = paramSimpleFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "function.name");
    localObject1 = (Iterable)PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName((Name)localObject1);
    if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {}
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        i = 0;
        break;
        localObject1 = ((Iterable)localObject1).iterator();
      }
      Object localObject2 = (Iterable)getPropertiesFromSupertypes((Name)((Iterator)localObject1).next());
      if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject2).hasNext())
        {
          i = 0;
          break;
          localObject2 = ((Iterable)localObject2).iterator();
        }
        PropertyDescriptor localPropertyDescriptor = (PropertyDescriptor)((Iterator)localObject2).next();
        if ((doesClassOverridesProperty(localPropertyDescriptor, (Function1)new LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass..inlined.any.lambda.1(this, paramSimpleFunctionDescriptor))) && ((localPropertyDescriptor.isVar()) || (!JvmAbi.isSetterName(paramSimpleFunctionDescriptor.getName().asString())))) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i == 0);
      i = 1;
    } while (i == 0);
    int i = 1;
    if (i != 0) {
      return false;
    }
    return (!doesOverrideRenamedBuiltins(paramSimpleFunctionDescriptor)) && (!shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(paramSimpleFunctionDescriptor)) && (!doesOverrideSuspendFunction(paramSimpleFunctionDescriptor));
  }
  
  private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor paramSimpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1, Collection<? extends SimpleFunctionDescriptor> paramCollection)
  {
    FunctionDescriptor localFunctionDescriptor = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)paramSimpleFunctionDescriptor);
    Object localObject = null;
    paramSimpleFunctionDescriptor = localObject;
    if (localFunctionDescriptor != null)
    {
      paramFunction1 = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(localFunctionDescriptor, paramFunction1);
      paramSimpleFunctionDescriptor = localObject;
      if (paramFunction1 != null)
      {
        if (!((LazyJavaClassMemberScope)this).isVisibleAsFunctionInCurrentClass(paramFunction1)) {
          paramFunction1 = null;
        }
        paramSimpleFunctionDescriptor = localObject;
        if (paramFunction1 != null) {
          paramSimpleFunctionDescriptor = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(paramFunction1, (CallableDescriptor)localFunctionDescriptor, paramCollection);
        }
      }
    }
    return paramSimpleFunctionDescriptor;
  }
  
  private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor paramSimpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1, Name paramName, Collection<? extends SimpleFunctionDescriptor> paramCollection)
  {
    paramSimpleFunctionDescriptor = (SimpleFunctionDescriptor)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName((CallableMemberDescriptor)paramSimpleFunctionDescriptor);
    if (paramSimpleFunctionDescriptor != null)
    {
      Object localObject = SpecialBuiltinMembers.getJvmMethodNameIfSpecial((CallableMemberDescriptor)paramSimpleFunctionDescriptor);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = Name.identifier((String)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Name.identifier(nameInJava)");
      paramFunction1 = ((Collection)paramFunction1.invoke(localObject)).iterator();
      while (paramFunction1.hasNext())
      {
        localObject = createRenamedCopy((SimpleFunctionDescriptor)paramFunction1.next(), paramName);
        if (doesOverrideRenamedDescriptor(paramSimpleFunctionDescriptor, (FunctionDescriptor)localObject)) {
          return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden((SimpleFunctionDescriptor)localObject, (CallableDescriptor)paramSimpleFunctionDescriptor, paramCollection);
        }
      }
    }
    return null;
  }
  
  private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor paramSimpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    if (!paramSimpleFunctionDescriptor.isSuspend()) {
      return null;
    }
    Object localObject = paramSimpleFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "descriptor.name");
    localObject = ((Iterable)paramFunction1.invoke(localObject)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramFunction1 = createSuspendView((SimpleFunctionDescriptor)((Iterator)localObject).next());
      if ((paramFunction1 == null) || (!doesOverride((CallableDescriptor)paramFunction1, (CallableDescriptor)paramSimpleFunctionDescriptor))) {
        paramFunction1 = null;
      }
      if (paramFunction1 != null) {
        return paramFunction1;
      }
    }
    return null;
  }
  
  private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor paramJavaConstructor)
  {
    ClassDescriptor localClassDescriptor = getOwnerDescriptor();
    Object localObject1 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), (JavaAnnotationOwner)paramJavaConstructor);
    Object localObject2 = getC().getComponents().getSourceElementFactory();
    JavaElement localJavaElement = (JavaElement)paramJavaConstructor;
    localObject1 = JavaClassConstructorDescriptor.createJavaConstructor(localClassDescriptor, (Annotations)localObject1, false, (SourceElement)((JavaSourceElementFactory)localObject2).source(localJavaElement));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "JavaClassConstructorDesc…ce(constructor)\n        )");
    localObject2 = ContextKt.childForMethod(getC(), (DeclarationDescriptor)localObject1, (JavaTypeParameterListOwner)paramJavaConstructor, localClassDescriptor.getDeclaredTypeParameters().size());
    LazyJavaScope.ResolvedValueParameters localResolvedValueParameters = resolveValueParameters((LazyJavaResolverContext)localObject2, (FunctionDescriptor)localObject1, paramJavaConstructor.getValueParameters());
    Object localObject3 = localClassDescriptor.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "classDescriptor.declaredTypeParameters");
    localObject3 = (Collection)localObject3;
    Object localObject4 = (Iterable)paramJavaConstructor.getTypeParameters();
    Collection localCollection = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (JavaTypeParameter)((Iterator)localObject4).next();
      localObject5 = ((LazyJavaResolverContext)localObject2).getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)localObject5);
      if (localObject5 == null) {
        Intrinsics.throwNpe();
      }
      localCollection.add(localObject5);
    }
    localObject3 = kotlin.collections.CollectionsKt.plus((Collection)localObject3, (Iterable)localCollection);
    ((JavaClassConstructorDescriptor)localObject1).initialize(localResolvedValueParameters.getDescriptors(), paramJavaConstructor.getVisibility(), (List)localObject3);
    ((JavaClassConstructorDescriptor)localObject1).setHasStableParameterNames(false);
    ((JavaClassConstructorDescriptor)localObject1).setHasSynthesizedParameterNames(localResolvedValueParameters.getHasSynthesizedNames());
    ((JavaClassConstructorDescriptor)localObject1).setReturnType((KotlinType)localClassDescriptor.getDefaultType());
    ((LazyJavaResolverContext)localObject2).getComponents().getJavaResolverCache().recordConstructor(localJavaElement, (ConstructorDescriptor)localObject1);
    return localObject1;
  }
  
  private final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name paramName)
  {
    Object localObject = (Iterable)((DeclaredMemberIndex)getDeclaredMemberIndex().invoke()).findMethodsByName(paramName);
    paramName = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramName.add(resolveMethodToFunctionDescriptor((JavaMethod)((Iterator)localObject).next()));
    }
    return (Collection)paramName;
  }
  
  private final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name paramName)
  {
    Object localObject1 = (Iterable)getFunctionsFromSupertypes(paramName);
    paramName = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)localObject2;
      int i;
      if ((!SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((CallableMemberDescriptor)localSimpleFunctionDescriptor)) && (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)localSimpleFunctionDescriptor) == null)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        paramName.add(localObject2);
      }
    }
    return (Collection)paramName;
  }
  
  private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Object localObject1 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
    Object localObject2 = paramSimpleFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "name");
    boolean bool1 = ((BuiltinMethodsWithSpecialGenericSignature)localObject1).getSameAsBuiltinMethodWithErasedValueParameters((Name)localObject2);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    localObject1 = paramSimpleFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "name");
    localObject2 = (Iterable)getFunctionsFromSupertypes((Name)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FunctionDescriptor localFunctionDescriptor = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)((Iterator)localObject2).next());
      if (localFunctionDescriptor != null) {
        ((Collection)localObject1).add(localFunctionDescriptor);
      }
    }
    localObject1 = (Iterable)localObject1;
    if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
      return false;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!hasSameJvmDescriptorButDoesNotOverride(paramSimpleFunctionDescriptor, (FunctionDescriptor)((Iterator)localObject1).next()));
    bool1 = true;
    return bool1;
  }
  
  @NotNull
  protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    return SetsKt.plus((Set)this.nestedClassIndex.invoke(), (Iterable)((Map)this.enumEntryIndex.invoke()).keySet());
  }
  
  @NotNull
  protected HashSet<Name> computeFunctionNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Object localObject1 = getOwnerDescriptor().getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ownerDescriptor.typeConstructor");
    localObject1 = ((TypeConstructor)localObject1).getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ownerDescriptor.typeConstructor.supertypes");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new HashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      kotlin.collections.CollectionsKt.addAll((Collection)localObject1, (Iterable)((KotlinType)((Iterator)localObject2).next()).getMemberScope().getFunctionNames());
    }
    localObject1 = (HashSet)localObject1;
    ((HashSet)localObject1).addAll((Collection)((DeclaredMemberIndex)getDeclaredMemberIndex().invoke()).getMethodNames());
    ((HashSet)localObject1).addAll((Collection)computeClassNames(paramDescriptorKindFilter, paramFunction1));
    return localObject1;
  }
  
  @NotNull
  protected ClassDeclaredMemberIndex computeMemberIndex()
  {
    return new ClassDeclaredMemberIndex(this.jClass, (Function1)LazyJavaClassMemberScope.computeMemberIndex.1.INSTANCE);
  }
  
  protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> paramCollection, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "result");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Object localObject2 = getFunctionsFromSupertypes(paramName);
    if ((!BuiltinMethodsWithDifferentJvmName.INSTANCE.getSameAsRenamedInJvmBuiltin(paramName)) && (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(paramName)))
    {
      localObject1 = (Iterable)localObject2;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject3).hasNext())
        {
          i = 1;
          break;
          localObject3 = ((Iterable)localObject1).iterator();
        }
      } while (!((FunctionDescriptor)((Iterator)localObject3).next()).isSuspend());
      int i = 0;
      if (i != 0)
      {
        localObject2 = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((Iterator)localObject1).next();
          if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor)localObject3)) {
            ((Collection)localObject2).add(localObject3);
          }
        }
        addFunctionFromSupertypes(paramCollection, paramName, (Collection)localObject2, false);
        return;
      }
    }
    Object localObject1 = SmartSet.Companion.create();
    Object localObject3 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(paramName, (Collection)localObject2, (Collection)kotlin.collections.CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resolveOverridesForNonSt….overridingUtil\n        )");
    Object localObject4 = (LazyJavaClassMemberScope)this;
    addOverriddenSpecialMethods(paramName, paramCollection, (Collection)localObject3, paramCollection, (Function1)new LazyJavaClassMemberScope.computeNonDeclaredFunctions.3((LazyJavaClassMemberScope)localObject4));
    addOverriddenSpecialMethods(paramName, paramCollection, (Collection)localObject3, (Collection)localObject1, (Function1)new LazyJavaClassMemberScope.computeNonDeclaredFunctions.4((LazyJavaClassMemberScope)localObject4));
    localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor)localObject4)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    addFunctionFromSupertypes(paramCollection, paramName, (Collection)kotlin.collections.CollectionsKt.plus((Collection)localObject2, (Iterable)localObject1), true);
  }
  
  protected void computeNonDeclaredProperties(@NotNull Name paramName, @NotNull Collection<PropertyDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramCollection, "result");
    if (this.jClass.isAnnotationType()) {
      computeAnnotationProperties(paramName, paramCollection);
    }
    Set localSet = getPropertiesFromSupertypes(paramName);
    if (localSet.isEmpty()) {
      return;
    }
    SmartSet localSmartSet = SmartSet.Companion.create();
    addPropertyOverrideByMethod(localSet, paramCollection, (Function1)new LazyJavaClassMemberScope.computeNonDeclaredProperties.1(this));
    addPropertyOverrideByMethod(localSet, (Collection)localSmartSet, (Function1)new LazyJavaClassMemberScope.computeNonDeclaredProperties.2(this));
    paramName = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(paramName, (Collection)SetsKt.plus(localSet, (Iterable)localSmartSet), paramCollection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
    Intrinsics.checkExpressionValueIsNotNull(paramName, "resolveOverridesForNonSt…rridingUtil\n            )");
    paramCollection.addAll(paramName);
  }
  
  @NotNull
  protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    if (this.jClass.isAnnotationType()) {
      return getFunctionNames();
    }
    paramDescriptorKindFilter = new LinkedHashSet((Collection)((DeclaredMemberIndex)getDeclaredMemberIndex().invoke()).getFieldNames());
    paramFunction1 = getOwnerDescriptor().getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "ownerDescriptor.typeConstructor");
    paramFunction1 = paramFunction1.getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "ownerDescriptor.typeConstructor.supertypes");
    paramFunction1 = ((Iterable)paramFunction1).iterator();
    while (paramFunction1.hasNext())
    {
      Iterable localIterable = (Iterable)((KotlinType)paramFunction1.next()).getMemberScope().getVariableNames();
      kotlin.collections.CollectionsKt.addAll((Collection)paramDescriptorKindFilter, localIterable);
    }
    return (Set)paramDescriptorKindFilter;
  }
  
  @NotNull
  public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm()
  {
    return this.constructors;
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    paramLookupLocation = (LazyJavaClassMemberScope)getMainScope();
    if (paramLookupLocation != null)
    {
      paramLookupLocation = paramLookupLocation.nestedClasses;
      if (paramLookupLocation != null)
      {
        paramLookupLocation = (ClassDescriptorBase)paramLookupLocation.invoke(paramName);
        if (paramLookupLocation != null) {
          return (ClassifierDescriptor)paramLookupLocation;
        }
      }
    }
    return (ClassifierDescriptor)this.nestedClasses.invoke(paramName);
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    return super.getContributedFunctions(paramName, paramLookupLocation);
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    return super.getContributedVariables(paramName, paramLookupLocation);
  }
  
  @Nullable
  protected ReceiverParameterDescriptor getDispatchReceiverParameter()
  {
    return DescriptorUtils.getDispatchReceiverParameterIfNeeded((DeclarationDescriptor)getOwnerDescriptor());
  }
  
  @NotNull
  protected ClassDescriptor getOwnerDescriptor()
  {
    return this.ownerDescriptor;
  }
  
  protected boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor paramJavaMethodDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethodDescriptor, "$this$isVisibleAsFunction");
    if (this.jClass.isAnnotationType()) {
      return false;
    }
    return isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor)paramJavaMethodDescriptor);
  }
  
  public void recordLookup(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    UtilsKt.record(getC().getComponents().getLookupTracker(), paramLookupLocation, getOwnerDescriptor(), paramName);
  }
  
  @NotNull
  protected LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod paramJavaMethod, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull KotlinType paramKotlinType, @NotNull List<? extends ValueParameterDescriptor> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethod, "method");
    Intrinsics.checkParameterIsNotNull(paramList, "methodTypeParameters");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "returnType");
    Intrinsics.checkParameterIsNotNull(paramList1, "valueParameters");
    Object localObject = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(paramJavaMethod, getOwnerDescriptor(), paramKotlinType, null, paramList1, paramList);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "c.components.signaturePr…dTypeParameters\n        )");
    paramJavaMethod = ((SignaturePropagator.PropagatedSignature)localObject).getReturnType();
    Intrinsics.checkExpressionValueIsNotNull(paramJavaMethod, "propagated.returnType");
    paramList = ((SignaturePropagator.PropagatedSignature)localObject).getReceiverType();
    paramKotlinType = ((SignaturePropagator.PropagatedSignature)localObject).getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "propagated.valueParameters");
    paramList1 = ((SignaturePropagator.PropagatedSignature)localObject).getTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramList1, "propagated.typeParameters");
    boolean bool = ((SignaturePropagator.PropagatedSignature)localObject).hasStableParameterNames();
    localObject = ((SignaturePropagator.PropagatedSignature)localObject).getErrors();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "propagated.errors");
    return new LazyJavaScope.MethodSignatureData(paramJavaMethod, paramList, paramKotlinType, paramList1, bool, (List)localObject);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Lazy Java member scope for ");
    localStringBuilder.append(this.jClass.getFqName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope
 * JD-Core Version:    0.7.0.1
 */