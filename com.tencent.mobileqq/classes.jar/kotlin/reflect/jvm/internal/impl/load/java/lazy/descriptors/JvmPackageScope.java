package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmPackageScope
  implements MemberScope
{
  private final LazyJavaResolverContext c;
  @NotNull
  private final LazyJavaPackageScope javaScope;
  private final NotNullLazyValue kotlinScopes$delegate;
  private final LazyJavaPackageFragment packageFragment;
  
  public JvmPackageScope(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaPackage paramJavaPackage, @NotNull LazyJavaPackageFragment paramLazyJavaPackageFragment)
  {
    this.c = paramLazyJavaResolverContext;
    this.packageFragment = paramLazyJavaPackageFragment;
    this.javaScope = new LazyJavaPackageScope(this.c, paramJavaPackage, this.packageFragment);
    this.kotlinScopes$delegate = this.c.getStorageManager().createLazyValue((Function0)new JvmPackageScope.kotlinScopes.2(this));
  }
  
  private final List<MemberScope> getKotlinScopes()
  {
    return (List)StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    Object localObject1 = this.javaScope.getContributedClassifier(paramName, paramLookupLocation);
    if (localObject1 != null) {
      return (ClassifierDescriptor)localObject1;
    }
    Object localObject2 = getKotlinScopes();
    localObject1 = (ClassifierDescriptor)null;
    Iterator localIterator = ((List)localObject2).iterator();
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = ((MemberScope)localIterator.next()).getContributedClassifier(paramName, paramLookupLocation);
      if (localObject2 != null)
      {
        if ((!(localObject2 instanceof ClassifierDescriptorWithTypeParameters)) || (!((ClassifierDescriptorWithTypeParameters)localObject2).isExpect())) {
          break;
        }
        if (localObject1 == null) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    Object localObject1 = this.javaScope;
    Object localObject2 = getKotlinScopes();
    localObject1 = ((MemberScope)localObject1).getContributedDescriptors(paramDescriptorKindFilter, paramFunction1);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = ScopeUtilsKt.concat((Collection)localObject1, ((MemberScope)((Iterator)localObject2).next()).getContributedDescriptors(paramDescriptorKindFilter, paramFunction1));
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    Object localObject1 = this.javaScope;
    Object localObject2 = getKotlinScopes();
    localObject1 = ((MemberScope)localObject1).getContributedFunctions(paramName, paramLookupLocation);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = ScopeUtilsKt.concat((Collection)localObject1, ((MemberScope)((Iterator)localObject2).next()).getContributedFunctions(paramName, paramLookupLocation));
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    Object localObject1 = this.javaScope;
    Object localObject2 = getKotlinScopes();
    localObject1 = ((MemberScope)localObject1).getContributedVariables(paramName, paramLookupLocation);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = ScopeUtilsKt.concat((Collection)localObject1, ((MemberScope)((Iterator)localObject2).next()).getContributedVariables(paramName, paramLookupLocation));
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    Object localObject2 = (Iterable)getKotlinScopes();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      CollectionsKt.addAll((Collection)localObject1, (Iterable)((MemberScope)((Iterator)localObject2).next()).getFunctionNames());
    }
    localObject1 = (Set)localObject1;
    ((Set)localObject1).addAll((Collection)this.javaScope.getFunctionNames());
    return localObject1;
  }
  
  @NotNull
  public final LazyJavaPackageScope getJavaScope$descriptors_jvm()
  {
    return this.javaScope;
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    Object localObject2 = (Iterable)getKotlinScopes();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      CollectionsKt.addAll((Collection)localObject1, (Iterable)((MemberScope)((Iterator)localObject2).next()).getVariableNames());
    }
    localObject1 = (Set)localObject1;
    ((Set)localObject1).addAll((Collection)this.javaScope.getVariableNames());
    return localObject1;
  }
  
  public void recordLookup(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    UtilsKt.record(this.c.getComponents().getLookupTracker(), paramLookupLocation, (PackageFragmentDescriptor)this.packageFragment, paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope
 * JD-Core Version:    0.7.0.1
 */