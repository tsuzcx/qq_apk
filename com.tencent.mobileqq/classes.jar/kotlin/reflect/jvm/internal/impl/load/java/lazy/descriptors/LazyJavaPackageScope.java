package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageScope
  extends LazyJavaStaticScope
{
  private final MemoizedFunctionToNullable<LazyJavaPackageScope.FindClassRequest, ClassDescriptor> classes;
  private final JavaPackage jPackage;
  private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
  @NotNull
  private final LazyJavaPackageFragment ownerDescriptor;
  
  public LazyJavaPackageScope(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaPackage paramJavaPackage, @NotNull LazyJavaPackageFragment paramLazyJavaPackageFragment)
  {
    super(paramLazyJavaResolverContext);
    this.jPackage = paramJavaPackage;
    this.ownerDescriptor = paramLazyJavaPackageFragment;
    this.knownClassNamesInPackage = paramLazyJavaResolverContext.getStorageManager().createNullableLazyValue((Function0)new LazyJavaPackageScope.knownClassNamesInPackage.1(this, paramLazyJavaResolverContext));
    this.classes = paramLazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new LazyJavaPackageScope.classes.1(this, paramLazyJavaResolverContext));
  }
  
  private final ClassDescriptor findClassifier(Name paramName, JavaClass paramJavaClass)
  {
    if (!SpecialNames.isSafeIdentifier(paramName)) {
      return null;
    }
    Set localSet = (Set)this.knownClassNamesInPackage.invoke();
    if ((paramJavaClass == null) && (localSet != null) && (!localSet.contains(paramName.asString()))) {
      return null;
    }
    return (ClassDescriptor)this.classes.invoke(new LazyJavaPackageScope.FindClassRequest(paramName, paramJavaClass));
  }
  
  private final LazyJavaPackageScope.KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    if (paramKotlinJvmBinaryClass == null) {
      return (LazyJavaPackageScope.KotlinClassLookupResult)LazyJavaPackageScope.KotlinClassLookupResult.NotFound.INSTANCE;
    }
    if (paramKotlinJvmBinaryClass.getClassHeader().getKind() == KotlinClassHeader.Kind.CLASS)
    {
      paramKotlinJvmBinaryClass = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(paramKotlinJvmBinaryClass);
      if (paramKotlinJvmBinaryClass != null) {
        return (LazyJavaPackageScope.KotlinClassLookupResult)new LazyJavaPackageScope.KotlinClassLookupResult.Found(paramKotlinJvmBinaryClass);
      }
      return (LazyJavaPackageScope.KotlinClassLookupResult)LazyJavaPackageScope.KotlinClassLookupResult.NotFound.INSTANCE;
    }
    return (LazyJavaPackageScope.KotlinClassLookupResult)LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass.INSTANCE;
  }
  
  @NotNull
  protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    if (!paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
      return SetsKt.emptySet();
    }
    paramDescriptorKindFilter = (Set)this.knownClassNamesInPackage.invoke();
    if (paramDescriptorKindFilter != null)
    {
      paramFunction1 = (Iterable)paramDescriptorKindFilter;
      paramDescriptorKindFilter = (Collection)new HashSet();
      paramFunction1 = paramFunction1.iterator();
      while (paramFunction1.hasNext()) {
        paramDescriptorKindFilter.add(Name.identifier((String)paramFunction1.next()));
      }
      return (Set)paramDescriptorKindFilter;
    }
    paramDescriptorKindFilter = this.jPackage;
    if (paramFunction1 == null) {
      paramFunction1 = FunctionsKt.alwaysTrue();
    }
    paramDescriptorKindFilter = (Iterable)paramDescriptorKindFilter.getClasses(paramFunction1);
    paramFunction1 = (Collection)new LinkedHashSet();
    Iterator localIterator = paramDescriptorKindFilter.iterator();
    while (localIterator.hasNext())
    {
      paramDescriptorKindFilter = (JavaClass)localIterator.next();
      if (paramDescriptorKindFilter.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
        paramDescriptorKindFilter = null;
      } else {
        paramDescriptorKindFilter = paramDescriptorKindFilter.getName();
      }
      if (paramDescriptorKindFilter != null) {
        paramFunction1.add(paramDescriptorKindFilter);
      }
    }
    return (Set)paramFunction1;
  }
  
  @NotNull
  protected Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    return SetsKt.emptySet();
  }
  
  @NotNull
  protected DeclaredMemberIndex computeMemberIndex()
  {
    return (DeclaredMemberIndex)DeclaredMemberIndex.Empty.INSTANCE;
  }
  
  protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> paramCollection, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "result");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
  }
  
  @NotNull
  protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @Nullable Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    return SetsKt.emptySet();
  }
  
  @Nullable
  public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass paramJavaClass)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaClass, "javaClass");
    return findClassifier(paramJavaClass.getName(), paramJavaClass);
  }
  
  @Nullable
  public ClassDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return findClassifier(paramName, null);
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    if (!paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK() | DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
      return (Collection)CollectionsKt.emptyList();
    }
    Object localObject1 = (Iterable)getAllDescriptors().invoke();
    paramDescriptorKindFilter = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (DeclarationDescriptor)localObject2;
      if ((localObject3 instanceof ClassDescriptor))
      {
        localObject3 = ((ClassDescriptor)localObject3).getName();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.name");
        if (((Boolean)paramFunction1.invoke(localObject3)).booleanValue())
        {
          i = 1;
          break label152;
        }
      }
      int i = 0;
      label152:
      if (i != 0) {
        paramDescriptorKindFilter.add(localObject2);
      }
    }
    return (Collection)paramDescriptorKindFilter;
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  protected LazyJavaPackageFragment getOwnerDescriptor()
  {
    return this.ownerDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope
 * JD-Core Version:    0.7.0.1
 */