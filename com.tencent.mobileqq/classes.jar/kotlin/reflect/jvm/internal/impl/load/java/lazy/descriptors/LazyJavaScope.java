package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
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
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LazyJavaScope
  extends MemberScopeImpl
{
  @NotNull
  private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
  @NotNull
  private final LazyJavaResolverContext c;
  private final NotNullLazyValue classNamesLazy$delegate;
  private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
  private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
  @NotNull
  private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
  private final NotNullLazyValue functionNamesLazy$delegate;
  private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
  @Nullable
  private final LazyJavaScope mainScope;
  private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
  private final NotNullLazyValue propertyNamesLazy$delegate;
  
  public LazyJavaScope(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @Nullable LazyJavaScope paramLazyJavaScope)
  {
    this.c = paramLazyJavaResolverContext;
    this.mainScope = paramLazyJavaScope;
    this.allDescriptors = this.c.getStorageManager().createRecursionTolerantLazyValue((Function0)new LazyJavaScope.allDescriptors.1(this), kotlin.collections.CollectionsKt.emptyList());
    this.declaredMemberIndex = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaScope.declaredMemberIndex.1(this));
    this.declaredFunctions = this.c.getStorageManager().createMemoizedFunction((Function1)new LazyJavaScope.declaredFunctions.1(this));
    this.declaredField = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new LazyJavaScope.declaredField.1(this));
    this.functions = this.c.getStorageManager().createMemoizedFunction((Function1)new LazyJavaScope.functions.1(this));
    this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaScope.functionNamesLazy.2(this));
    this.propertyNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaScope.propertyNamesLazy.2(this));
    this.classNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaScope.classNamesLazy.2(this));
    this.properties = this.c.getStorageManager().createMemoizedFunction((Function1)new LazyJavaScope.properties.1(this));
  }
  
  private final PropertyDescriptorImpl createPropertyDescriptor(JavaField paramJavaField)
  {
    boolean bool = paramJavaField.isFinal();
    Annotations localAnnotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, (JavaAnnotationOwner)paramJavaField);
    paramJavaField = JavaPropertyDescriptor.create(getOwnerDescriptor(), localAnnotations, Modality.FINAL, paramJavaField.getVisibility(), bool ^ true, paramJavaField.getName(), (SourceElement)this.c.getComponents().getSourceElementFactory().source((JavaElement)paramJavaField), isFinalStatic(paramJavaField));
    Intrinsics.checkExpressionValueIsNotNull(paramJavaField, "JavaPropertyDescriptor.c…d.isFinalStatic\n        )");
    return (PropertyDescriptorImpl)paramJavaField;
  }
  
  private final Set<Name> getFunctionNamesLazy()
  {
    return (Set)StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
  }
  
  private final Set<Name> getPropertyNamesLazy()
  {
    return (Set)StorageKt.getValue(this.propertyNamesLazy$delegate, this, $$delegatedProperties[1]);
  }
  
  private final KotlinType getPropertyType(JavaField paramJavaField)
  {
    Object localObject = this.c.getTypeResolver();
    JavaType localJavaType = paramJavaField.getType();
    TypeUsage localTypeUsage = TypeUsage.COMMON;
    int j = 0;
    localObject = ((JavaTypeResolver)localObject).transformJavaType(localJavaType, JavaTypeResolverKt.toAttributes$default(localTypeUsage, false, null, 3, null));
    int i;
    if (!KotlinBuiltIns.isPrimitiveType((KotlinType)localObject))
    {
      i = j;
      if (!KotlinBuiltIns.isString((KotlinType)localObject)) {}
    }
    else
    {
      i = j;
      if (isFinalStatic(paramJavaField))
      {
        i = j;
        if (paramJavaField.getHasConstantNotNullInitializer()) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      paramJavaField = TypeUtils.makeNotNullable((KotlinType)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramJavaField, "TypeUtils.makeNotNullable(propertyType)");
      return paramJavaField;
    }
    return localObject;
  }
  
  private final boolean isFinalStatic(@NotNull JavaField paramJavaField)
  {
    return (paramJavaField.isFinal()) && (paramJavaField.isStatic());
  }
  
  private final PropertyDescriptor resolveProperty(JavaField paramJavaField)
  {
    Object localObject = createPropertyDescriptor(paramJavaField);
    ((PropertyDescriptorImpl)localObject).initialize(null, null, null, null);
    ((PropertyDescriptorImpl)localObject).setType(getPropertyType(paramJavaField), kotlin.collections.CollectionsKt.emptyList(), getDispatchReceiverParameter(), null);
    if (DescriptorUtils.shouldRecordInitializerForProperty((VariableDescriptor)localObject, ((PropertyDescriptorImpl)localObject).getType())) {
      ((PropertyDescriptorImpl)localObject).setCompileTimeInitializer(this.c.getStorageManager().createNullableLazyValue((Function0)new LazyJavaScope.resolveProperty.1(this, paramJavaField, (PropertyDescriptorImpl)localObject)));
    }
    JavaResolverCache localJavaResolverCache = this.c.getComponents().getJavaResolverCache();
    localObject = (PropertyDescriptor)localObject;
    localJavaResolverCache.recordField(paramJavaField, (PropertyDescriptor)localObject);
    return localObject;
  }
  
  @NotNull
  protected abstract Set<Name> computeClassNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1);
  
  @NotNull
  protected final List<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    NoLookupLocation localNoLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject;
    Name localName;
    if (paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()))
    {
      localObject = computeClassNames(paramDescriptorKindFilter, paramFunction1).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localName = (Name)((Iterator)localObject).next();
        if (((Boolean)paramFunction1.invoke(localName)).booleanValue()) {
          kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)localLinkedHashSet, getContributedClassifier(localName, (LookupLocation)localNoLookupLocation));
        }
      }
    }
    if ((paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) && (!paramDescriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)))
    {
      localObject = computeFunctionNames(paramDescriptorKindFilter, paramFunction1).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localName = (Name)((Iterator)localObject).next();
        if (((Boolean)paramFunction1.invoke(localName)).booleanValue()) {
          localLinkedHashSet.addAll(getContributedFunctions(localName, (LookupLocation)localNoLookupLocation));
        }
      }
    }
    if ((paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) && (!paramDescriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)))
    {
      paramDescriptorKindFilter = computePropertyNames(paramDescriptorKindFilter, paramFunction1).iterator();
      while (paramDescriptorKindFilter.hasNext())
      {
        localObject = (Name)paramDescriptorKindFilter.next();
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
          localLinkedHashSet.addAll(getContributedVariables((Name)localObject, (LookupLocation)localNoLookupLocation));
        }
      }
    }
    return kotlin.collections.CollectionsKt.toList((Iterable)localLinkedHashSet);
  }
  
  @NotNull
  protected abstract Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1);
  
  @NotNull
  protected abstract DeclaredMemberIndex computeMemberIndex();
  
  @NotNull
  protected final KotlinType computeMethodReturnType(@NotNull JavaMethod paramJavaMethod, @NotNull LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethod, "method");
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "c");
    boolean bool = paramJavaMethod.getContainingClass().isAnnotationType();
    JavaTypeAttributes localJavaTypeAttributes = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, bool, null, 2, null);
    return paramLazyJavaResolverContext.getTypeResolver().transformJavaType(paramJavaMethod.getReturnType(), localJavaTypeAttributes);
  }
  
  protected abstract void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> paramCollection, @NotNull Name paramName);
  
  protected abstract void computeNonDeclaredProperties(@NotNull Name paramName, @NotNull Collection<PropertyDescriptor> paramCollection);
  
  @NotNull
  protected abstract Set<Name> computePropertyNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1);
  
  @NotNull
  protected final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors()
  {
    return this.allDescriptors;
  }
  
  @NotNull
  protected final LazyJavaResolverContext getC()
  {
    return this.c;
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    return (Collection)this.allDescriptors.invoke();
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    if (!getFunctionNames().contains(paramName)) {
      return (Collection)kotlin.collections.CollectionsKt.emptyList();
    }
    return (Collection)this.functions.invoke(paramName);
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    if (!getVariableNames().contains(paramName)) {
      return (Collection)kotlin.collections.CollectionsKt.emptyList();
    }
    return (Collection)this.properties.invoke(paramName);
  }
  
  @NotNull
  protected final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex()
  {
    return this.declaredMemberIndex;
  }
  
  @Nullable
  protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    return getFunctionNamesLazy();
  }
  
  @Nullable
  protected final LazyJavaScope getMainScope()
  {
    return this.mainScope;
  }
  
  @NotNull
  protected abstract DeclarationDescriptor getOwnerDescriptor();
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    return getPropertyNamesLazy();
  }
  
  protected boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor paramJavaMethodDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethodDescriptor, "$this$isVisibleAsFunction");
    return true;
  }
  
  @NotNull
  protected abstract LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod paramJavaMethod, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull KotlinType paramKotlinType, @NotNull List<? extends ValueParameterDescriptor> paramList1);
  
  @NotNull
  protected final JavaMethodDescriptor resolveMethodToFunctionDescriptor(@NotNull JavaMethod paramJavaMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethod, "method");
    Object localObject1 = LazyJavaAnnotationsKt.resolveAnnotations(this.c, (JavaAnnotationOwner)paramJavaMethod);
    JavaMethodDescriptor localJavaMethodDescriptor = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), (Annotations)localObject1, paramJavaMethod.getName(), (SourceElement)this.c.getComponents().getSourceElementFactory().source((JavaElement)paramJavaMethod));
    Intrinsics.checkExpressionValueIsNotNull(localJavaMethodDescriptor, "JavaMethodDescriptor.cre….source(method)\n        )");
    LazyJavaResolverContext localLazyJavaResolverContext = ContextKt.childForMethod$default(this.c, (DeclarationDescriptor)localJavaMethodDescriptor, (JavaTypeParameterListOwner)paramJavaMethod, 0, 4, null);
    Object localObject2 = (Iterable)paramJavaMethod.getTypeParameters();
    localObject1 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (JavaTypeParameter)((Iterator)localObject2).next();
      localObject3 = localLazyJavaResolverContext.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)localObject3);
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localObject2 = resolveValueParameters(localLazyJavaResolverContext, (FunctionDescriptor)localJavaMethodDescriptor, paramJavaMethod.getValueParameters());
    Object localObject3 = resolveMethodSignature(paramJavaMethod, (List)localObject1, computeMethodReturnType(paramJavaMethod, localLazyJavaResolverContext), ((LazyJavaScope.ResolvedValueParameters)localObject2).getDescriptors());
    localObject1 = ((LazyJavaScope.MethodSignatureData)localObject3).getReceiverType();
    if (localObject1 != null) {
      localObject1 = DescriptorFactory.createExtensionReceiverParameterForCallable((CallableDescriptor)localJavaMethodDescriptor, (KotlinType)localObject1, Annotations.Companion.getEMPTY());
    } else {
      localObject1 = null;
    }
    ReceiverParameterDescriptor localReceiverParameterDescriptor = getDispatchReceiverParameter();
    List localList1 = ((LazyJavaScope.MethodSignatureData)localObject3).getTypeParameters();
    List localList2 = ((LazyJavaScope.MethodSignatureData)localObject3).getValueParameters();
    KotlinType localKotlinType = ((LazyJavaScope.MethodSignatureData)localObject3).getReturnType();
    Modality localModality = Modality.Companion.convertFromFlags(paramJavaMethod.isAbstract(), paramJavaMethod.isFinal() ^ true);
    Visibility localVisibility = paramJavaMethod.getVisibility();
    if (((LazyJavaScope.MethodSignatureData)localObject3).getReceiverType() != null) {
      paramJavaMethod = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, kotlin.collections.CollectionsKt.first(((LazyJavaScope.ResolvedValueParameters)localObject2).getDescriptors())));
    } else {
      paramJavaMethod = MapsKt.emptyMap();
    }
    localJavaMethodDescriptor.initialize((ReceiverParameterDescriptor)localObject1, localReceiverParameterDescriptor, localList1, localList2, localKotlinType, localModality, localVisibility, paramJavaMethod);
    localJavaMethodDescriptor.setParameterNamesStatus(((LazyJavaScope.MethodSignatureData)localObject3).getHasStableParameterNames(), ((LazyJavaScope.ResolvedValueParameters)localObject2).getHasSynthesizedNames());
    if ((((Collection)((LazyJavaScope.MethodSignatureData)localObject3).getErrors()).isEmpty() ^ true)) {
      localLazyJavaResolverContext.getComponents().getSignaturePropagator().reportSignatureErrors((CallableMemberDescriptor)localJavaMethodDescriptor, ((LazyJavaScope.MethodSignatureData)localObject3).getErrors());
    }
    return localJavaMethodDescriptor;
  }
  
  @NotNull
  protected final LazyJavaScope.ResolvedValueParameters resolveValueParameters(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull FunctionDescriptor paramFunctionDescriptor, @NotNull List<? extends JavaValueParameter> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "c");
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "function");
    Intrinsics.checkParameterIsNotNull(paramList, "jValueParameters");
    Set localSet = (Set)new LinkedHashSet();
    Object localObject1 = kotlin.collections.CollectionsKt.withIndex((Iterable)paramList);
    Collection localCollection = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      localObject1 = (IndexedValue)localIterator.next();
      int j = ((IndexedValue)localObject1).component1();
      JavaValueParameter localJavaValueParameter = (JavaValueParameter)((IndexedValue)localObject1).component2();
      Annotations localAnnotations = LazyJavaAnnotationsKt.resolveAnnotations(paramLazyJavaResolverContext, (JavaAnnotationOwner)localJavaValueParameter);
      JavaTypeAttributes localJavaTypeAttributes = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null);
      localObject1 = JvmAnnotationNames.PARAMETER_NAME_FQ_NAME;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME");
      localObject1 = localAnnotations.findAnnotation((FqName)localObject1);
      if (localObject1 != null)
      {
        localObject2 = DescriptorUtilsKt.firstArgument((AnnotationDescriptor)localObject1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof StringValue)) {
            localObject1 = null;
          }
          localObject1 = (StringValue)localObject1;
          if (localObject1 != null)
          {
            localObject1 = (String)((StringValue)localObject1).getValue();
            break label218;
          }
        }
      }
      localObject1 = null;
      label218:
      boolean bool3 = localJavaValueParameter.isVararg();
      boolean bool2 = true;
      if (bool3)
      {
        localObject3 = localJavaValueParameter.getType();
        localObject2 = localObject3;
        if (!(localObject3 instanceof JavaArrayType)) {
          localObject2 = null;
        }
        localObject2 = (JavaArrayType)localObject2;
        if (localObject2 != null)
        {
          localObject2 = paramLazyJavaResolverContext.getTypeResolver().transformArrayType((JavaArrayType)localObject2, localJavaTypeAttributes, true);
          localObject2 = TuplesKt.to(localObject2, paramLazyJavaResolverContext.getModule().getBuiltIns().getArrayElementType((KotlinType)localObject2));
        }
        else
        {
          paramLazyJavaResolverContext = new StringBuilder();
          paramLazyJavaResolverContext.append("Vararg parameter should be an array: ");
          paramLazyJavaResolverContext.append(localJavaValueParameter);
          throw ((Throwable)new AssertionError(paramLazyJavaResolverContext.toString()));
        }
      }
      else
      {
        localObject2 = TuplesKt.to(paramLazyJavaResolverContext.getTypeResolver().transformJavaType(localJavaValueParameter.getType(), localJavaTypeAttributes), null);
      }
      Object localObject3 = (KotlinType)((Pair)localObject2).component1();
      Object localObject2 = (KotlinType)((Pair)localObject2).component2();
      if ((Intrinsics.areEqual(paramFunctionDescriptor.getName().asString(), "equals")) && (paramList.size() == 1) && (Intrinsics.areEqual(paramLazyJavaResolverContext.getModule().getBuiltIns().getNullableAnyType(), localObject3)))
      {
        localObject1 = Name.identifier("other");
      }
      else
      {
        if (localObject1 != null)
        {
          int i;
          if (((CharSequence)localObject1).length() > 0) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i != 0) && (localSet.add(localObject1)))
          {
            localObject1 = Name.identifier((String)localObject1);
            break label566;
          }
        }
        localObject1 = localJavaValueParameter.getName();
        if (localObject1 == null) {
          bool1 = bool2;
        }
        if (localObject1 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append('p');
          ((StringBuilder)localObject1).append(j);
          localObject1 = Name.identifier(((StringBuilder)localObject1).toString());
        }
      }
      label566:
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "if (function.name.asStri…(\"p$index\")\n            }");
      localCollection.add(new ValueParameterDescriptorImpl((CallableDescriptor)paramFunctionDescriptor, null, j, localAnnotations, (Name)localObject1, (KotlinType)localObject3, false, false, false, (KotlinType)localObject2, (SourceElement)paramLazyJavaResolverContext.getComponents().getSourceElementFactory().source((JavaElement)localJavaValueParameter)));
    }
    return new LazyJavaScope.ResolvedValueParameters(kotlin.collections.CollectionsKt.toList((Iterable)localCollection), bool1);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Lazy scope for ");
    localStringBuilder.append(getOwnerDescriptor());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
 * JD-Core Version:    0.7.0.1
 */