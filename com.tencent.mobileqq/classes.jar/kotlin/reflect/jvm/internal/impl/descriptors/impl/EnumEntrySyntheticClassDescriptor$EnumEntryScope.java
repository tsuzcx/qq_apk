package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

class EnumEntrySyntheticClassDescriptor$EnumEntryScope
  extends MemberScopeImpl
{
  private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
  private final MemoizedFunctionToNotNull<Name, Collection<? extends SimpleFunctionDescriptor>> functions;
  private final MemoizedFunctionToNotNull<Name, Collection<? extends PropertyDescriptor>> properties;
  
  public EnumEntrySyntheticClassDescriptor$EnumEntryScope(EnumEntrySyntheticClassDescriptor paramEnumEntrySyntheticClassDescriptor, @NotNull StorageManager paramStorageManager)
  {
    this.functions = paramStorageManager.createMemoizedFunction(new EnumEntrySyntheticClassDescriptor.EnumEntryScope.1(this, paramEnumEntrySyntheticClassDescriptor));
    this.properties = paramStorageManager.createMemoizedFunction(new EnumEntrySyntheticClassDescriptor.EnumEntryScope.2(this, paramEnumEntrySyntheticClassDescriptor));
    this.allDescriptors = paramStorageManager.createLazyValue(new EnumEntrySyntheticClassDescriptor.EnumEntryScope.3(this, paramEnumEntrySyntheticClassDescriptor));
  }
  
  @NotNull
  private Collection<DeclarationDescriptor> computeAllDeclarations()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Set)EnumEntrySyntheticClassDescriptor.access$300(this.this$0).invoke()).iterator();
    while (localIterator.hasNext())
    {
      Name localName = (Name)localIterator.next();
      localHashSet.addAll(getContributedFunctions(localName, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
      localHashSet.addAll(getContributedVariables(localName, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
    }
    return localHashSet;
  }
  
  @NotNull
  private Collection<? extends SimpleFunctionDescriptor> computeFunctions(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(8);
    }
    return resolveFakeOverrides(paramName, getSupertypeScope().getContributedFunctions(paramName, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
  }
  
  @NotNull
  private Collection<? extends PropertyDescriptor> computeProperties(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(4);
    }
    return resolveFakeOverrides(paramName, getSupertypeScope().getContributedVariables(paramName, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
  }
  
  @NotNull
  private MemberScope getSupertypeScope()
  {
    MemberScope localMemberScope = ((KotlinType)this.this$0.getTypeConstructor().getSupertypes().iterator().next()).getMemberScope();
    if (localMemberScope == null) {
      $$$reportNull$$$0(9);
    }
    return localMemberScope;
  }
  
  @NotNull
  private <D extends CallableMemberDescriptor> Collection<? extends D> resolveFakeOverrides(@NotNull Name paramName, @NotNull Collection<? extends D> paramCollection)
  {
    if (paramName == null) {
      $$$reportNull$$$0(10);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(11);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    OverridingUtil.DEFAULT.generateOverridesInFunctionGroup(paramName, paramCollection, Collections.emptySet(), this.this$0, new EnumEntrySyntheticClassDescriptor.EnumEntryScope.4(this, localLinkedHashSet));
    return localLinkedHashSet;
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    if (paramDescriptorKindFilter == null) {
      $$$reportNull$$$0(13);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(14);
    }
    paramDescriptorKindFilter = (Collection)this.allDescriptors.invoke();
    if (paramDescriptorKindFilter == null) {
      $$$reportNull$$$0(15);
    }
    return paramDescriptorKindFilter;
  }
  
  @NotNull
  public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(5);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(6);
    }
    paramName = (Collection)this.functions.invoke(paramName);
    if (paramName == null) {
      $$$reportNull$$$0(7);
    }
    return paramName;
  }
  
  @NotNull
  public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(1);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(2);
    }
    paramName = (Collection)this.properties.invoke(paramName);
    if (paramName == null) {
      $$$reportNull$$$0(3);
    }
    return paramName;
  }
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    Set localSet = (Set)EnumEntrySyntheticClassDescriptor.access$300(this.this$0).invoke();
    if (localSet == null) {
      $$$reportNull$$$0(17);
    }
    return localSet;
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    Set localSet = (Set)EnumEntrySyntheticClassDescriptor.access$300(this.this$0).invoke();
    if (localSet == null) {
      $$$reportNull$$$0(19);
    }
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope
 * JD-Core Version:    0.7.0.1
 */