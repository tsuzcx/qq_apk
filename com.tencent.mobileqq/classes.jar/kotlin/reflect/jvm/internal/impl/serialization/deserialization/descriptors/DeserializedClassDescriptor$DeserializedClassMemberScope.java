package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class DeserializedClassDescriptor$DeserializedClassMemberScope
  extends DeserializedMemberScope
{
  private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
  private final KotlinTypeRefiner kotlinTypeRefiner;
  private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
  
  public DeserializedClassDescriptor$DeserializedClassMemberScope(KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    super(localDeserializationContext, (Collection)localObject2, (Collection)localObject3, (Collection)localObject4, (Function0)new DeserializedClassDescriptor.DeserializedClassMemberScope.2.1((List)localCollection));
    this.kotlinTypeRefiner = localObject1;
    this.allDescriptors = getC().getStorageManager().createLazyValue((Function0)new DeserializedClassDescriptor.DeserializedClassMemberScope.allDescriptors.1(this));
    this.refinedSupertypes = getC().getStorageManager().createLazyValue((Function0)new DeserializedClassDescriptor.DeserializedClassMemberScope.refinedSupertypes.1(this));
  }
  
  private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name paramName, Collection<? extends D> paramCollection, Collection<D> paramCollection1)
  {
    ArrayList localArrayList = new ArrayList(paramCollection1);
    getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(paramName, paramCollection, (Collection)localArrayList, (ClassDescriptor)getClassDescriptor(), (OverridingStrategy)new DeserializedClassDescriptor.DeserializedClassMemberScope.generateFakeOverrides.1(paramCollection1));
  }
  
  private final DeserializedClassDescriptor getClassDescriptor()
  {
    return this.this$0;
  }
  
  protected void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> paramCollection, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "result");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    paramFunction1 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
    if (paramFunction1 != null) {
      paramFunction1 = paramFunction1.all();
    } else {
      paramFunction1 = null;
    }
    if (paramFunction1 == null) {
      paramFunction1 = (Collection)CollectionsKt.emptyList();
    }
    paramCollection.addAll(paramFunction1);
  }
  
  protected void computeNonDeclaredFunctions(@NotNull Name paramName, @NotNull Collection<SimpleFunctionDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramCollection, "functions");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Collection)this.refinedSupertypes.invoke()).iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((KotlinType)localIterator.next()).getMemberScope().getContributedFunctions(paramName, (LookupLocation)NoLookupLocation.FOR_ALREADY_TRACKED));
    }
    CollectionsKt.retainAll((Iterable)paramCollection, (Function1)new DeserializedClassDescriptor.DeserializedClassMemberScope.computeNonDeclaredFunctions.1(this));
    paramCollection.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(paramName, (ClassDescriptor)this.this$0));
    generateFakeOverrides(paramName, (Collection)localArrayList, paramCollection);
  }
  
  protected void computeNonDeclaredProperties(@NotNull Name paramName, @NotNull Collection<PropertyDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramCollection, "descriptors");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Collection)this.refinedSupertypes.invoke()).iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((KotlinType)localIterator.next()).getMemberScope().getContributedVariables(paramName, (LookupLocation)NoLookupLocation.FOR_ALREADY_TRACKED));
    }
    generateFakeOverrides(paramName, (Collection)localArrayList, paramCollection);
  }
  
  @NotNull
  protected ClassId createClassId(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    paramName = DeserializedClassDescriptor.access$getClassId$p(this.this$0).createNestedClassId(paramName);
    Intrinsics.checkExpressionValueIsNotNull(paramName, "classId.createNestedClassId(name)");
    return paramName;
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    Object localObject = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
    if (localObject != null)
    {
      localObject = ((DeserializedClassDescriptor.EnumEntryClassDescriptors)localObject).findEnumEntry(paramName);
      if (localObject != null) {
        return (ClassifierDescriptor)localObject;
      }
    }
    return super.getContributedClassifier(paramName, paramLookupLocation);
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
  
  @NotNull
  protected Set<Name> getNonDeclaredFunctionNames()
  {
    Object localObject = (Iterable)DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).getSupertypes();
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)((KotlinType)((Iterator)localObject).next()).getMemberScope().getFunctionNames());
    }
    ((LinkedHashSet)localCollection).addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames((ClassDescriptor)this.this$0));
    return (Set)localCollection;
  }
  
  @NotNull
  protected Set<Name> getNonDeclaredVariableNames()
  {
    Object localObject = (Iterable)DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).getSupertypes();
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)((KotlinType)((Iterator)localObject).next()).getMemberScope().getVariableNames());
    }
    return (Set)localCollection;
  }
  
  public void recordLookup(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    UtilsKt.record(getC().getComponents().getLookupTracker(), paramLookupLocation, (ClassDescriptor)getClassDescriptor(), paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope
 * JD-Core Version:    0.7.0.1
 */