package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public abstract class GivenFunctionsMemberScope
  extends MemberScopeImpl
{
  private final NotNullLazyValue allDescriptors$delegate;
  @NotNull
  private final ClassDescriptor containingClass;
  
  public GivenFunctionsMemberScope(@NotNull StorageManager paramStorageManager, @NotNull ClassDescriptor paramClassDescriptor)
  {
    this.containingClass = paramClassDescriptor;
    this.allDescriptors$delegate = paramStorageManager.createLazyValue((Function0)new GivenFunctionsMemberScope.allDescriptors.2(this));
  }
  
  private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> paramList)
  {
    ArrayList localArrayList = new ArrayList(3);
    Object localObject1 = this.containingClass.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "containingClass.typeConstructor");
    localObject1 = ((TypeConstructor)localObject1).getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "containingClass.typeConstructor.supertypes");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      kotlin.collections.CollectionsKt.addAll((Collection)localObject1, (Iterable)ResolutionScope.DefaultImpls.getContributedDescriptors$default(((KotlinType)((Iterator)localObject2).next()).getMemberScope(), null, null, 3, null));
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof CallableMemberDescriptor)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    Object localObject3 = (Map)new LinkedHashMap();
    Object localObject4 = ((Iterable)localObject1).iterator();
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      localObject6 = ((CallableMemberDescriptor)localObject5).getName();
      localObject2 = ((Map)localObject3).get(localObject6);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        ((Map)localObject3).put(localObject6, localObject1);
      }
      ((List)localObject1).add(localObject5);
    }
    localObject3 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      localObject4 = (Name)((Map.Entry)localObject1).getKey();
      localObject1 = (Iterable)((Map.Entry)localObject1).getValue();
      localObject5 = (Map)new LinkedHashMap();
      localObject6 = ((Iterable)localObject1).iterator();
      Object localObject7;
      Object localObject8;
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = ((Iterator)localObject6).next();
        localObject8 = Boolean.valueOf((CallableMemberDescriptor)localObject7 instanceof FunctionDescriptor);
        localObject2 = ((Map)localObject5).get(localObject8);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          ((Map)localObject5).put(localObject8, localObject1);
        }
        ((List)localObject1).add(localObject7);
      }
      localObject2 = ((Map)localObject5).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        boolean bool = ((Boolean)((Map.Entry)localObject1).getKey()).booleanValue();
        localObject1 = (List)((Map.Entry)localObject1).getValue();
        localObject5 = OverridingUtil.DEFAULT;
        localObject6 = (Collection)localObject1;
        if (bool)
        {
          localObject7 = (Iterable)paramList;
          localObject1 = (Collection)new ArrayList();
          localObject7 = ((Iterable)localObject7).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = ((Iterator)localObject7).next();
            if (Intrinsics.areEqual(((FunctionDescriptor)localObject8).getName(), localObject4)) {
              ((Collection)localObject1).add(localObject8);
            }
          }
          localObject1 = (List)localObject1;
        }
        else
        {
          localObject1 = kotlin.collections.CollectionsKt.emptyList();
        }
        ((OverridingUtil)localObject5).generateOverridesInFunctionGroup((Name)localObject4, (Collection)localObject6, (Collection)localObject1, this.containingClass, (OverridingStrategy)new GivenFunctionsMemberScope.createFakeOverrides.4(this, localArrayList));
      }
    }
    return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(localArrayList);
  }
  
  private final List<DeclarationDescriptor> getAllDescriptors()
  {
    return (List)StorageKt.getValue(this.allDescriptors$delegate, this, $$delegatedProperties[0]);
  }
  
  @NotNull
  protected abstract List<FunctionDescriptor> computeDeclaredFunctions();
  
  @NotNull
  protected final ClassDescriptor getContainingClass()
  {
    return this.containingClass;
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    if (!paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask())) {
      return (Collection)kotlin.collections.CollectionsKt.emptyList();
    }
    return (Collection)getAllDescriptors();
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    Object localObject1 = (Iterable)getAllDescriptors();
    paramLookupLocation = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof SimpleFunctionDescriptor)) {
        paramLookupLocation.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramLookupLocation;
    paramLookupLocation = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((SimpleFunctionDescriptor)localObject2).getName(), paramName)) {
        paramLookupLocation.add(localObject2);
      }
    }
    return (Collection)paramLookupLocation;
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    Object localObject1 = (Iterable)getAllDescriptors();
    paramLookupLocation = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof PropertyDescriptor)) {
        paramLookupLocation.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramLookupLocation;
    paramLookupLocation = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((PropertyDescriptor)localObject2).getName(), paramName)) {
        paramLookupLocation.add(localObject2);
      }
    }
    return (Collection)paramLookupLocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
 * JD-Core Version:    0.7.0.1
 */