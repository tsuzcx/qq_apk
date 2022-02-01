package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ChainedMemberScope
  implements MemberScope
{
  public static final ChainedMemberScope.Companion Companion = new ChainedMemberScope.Companion(null);
  @NotNull
  private final String debugName;
  private final List<MemberScope> scopes;
  
  public ChainedMemberScope(@NotNull String paramString, @NotNull List<? extends MemberScope> paramList)
  {
    this.debugName = paramString;
    this.scopes = paramList;
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    Object localObject2 = this.scopes;
    Object localObject1 = (ClassifierDescriptor)null;
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
    Object localObject = this.scopes;
    if (((List)localObject).isEmpty()) {
      return (Collection)SetsKt.emptySet();
    }
    Collection localCollection = (Collection)null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection = ScopeUtilsKt.concat(localCollection, ((MemberScope)((Iterator)localObject).next()).getContributedDescriptors(paramDescriptorKindFilter, paramFunction1));
    }
    if (localCollection != null) {
      return localCollection;
    }
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    Object localObject = this.scopes;
    if (((List)localObject).isEmpty()) {
      return (Collection)SetsKt.emptySet();
    }
    Collection localCollection = (Collection)null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection = ScopeUtilsKt.concat(localCollection, ((MemberScope)((Iterator)localObject).next()).getContributedFunctions(paramName, paramLookupLocation));
    }
    if (localCollection != null) {
      return localCollection;
    }
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    Object localObject = this.scopes;
    if (((List)localObject).isEmpty()) {
      return (Collection)SetsKt.emptySet();
    }
    Collection localCollection = (Collection)null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection = ScopeUtilsKt.concat(localCollection, ((MemberScope)((Iterator)localObject).next()).getContributedVariables(paramName, paramLookupLocation));
    }
    if (localCollection != null) {
      return localCollection;
    }
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    Object localObject = (Iterable)this.scopes;
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)((MemberScope)((Iterator)localObject).next()).getFunctionNames());
    }
    return (Set)localCollection;
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    Object localObject = (Iterable)this.scopes;
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)((MemberScope)((Iterator)localObject).next()).getVariableNames());
    }
    return (Set)localCollection;
  }
  
  @NotNull
  public String toString()
  {
    return this.debugName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope
 * JD-Core Version:    0.7.0.1
 */