package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.NameAndTypeMemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DeserializedMemberScope
  extends MemberScopeImpl
{
  @NotNull
  private final DeserializationContext c;
  @NotNull
  private final NotNullLazyValue classNames$delegate;
  private final NotNullLazyValue functionNamesLazy$delegate;
  private final Map<Name, byte[]> functionProtosBytes;
  private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
  private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
  private final Map<Name, byte[]> propertyProtosBytes;
  private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
  private final Map<Name, byte[]> typeAliasBytes;
  private final NotNullLazyValue variableNamesLazy$delegate;
  
  protected DeserializedMemberScope(@NotNull DeserializationContext paramDeserializationContext, @NotNull Collection<ProtoBuf.Function> paramCollection, @NotNull Collection<ProtoBuf.Property> paramCollection1, @NotNull Collection<ProtoBuf.TypeAlias> paramCollection2, @NotNull Function0<? extends Collection<Name>> paramFunction0)
  {
    this.c = paramDeserializationContext;
    paramDeserializationContext = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramDeserializationContext.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramDeserializationContext = (MessageLite)localObject3;
      Name localName = NameResolverUtilKt.getName(access$getC$p(this).getNameResolver(), ((ProtoBuf.Function)paramDeserializationContext).getName());
      paramCollection = ((Map)localObject1).get(localName);
      paramDeserializationContext = paramCollection;
      if (paramCollection == null)
      {
        paramDeserializationContext = new ArrayList();
        ((Map)localObject1).put(localName, paramDeserializationContext);
      }
      ((List)paramDeserializationContext).add(localObject3);
    }
    this.functionProtosBytes = packToByteArray((Map)localObject1);
    paramDeserializationContext = (Iterable)paramCollection1;
    paramCollection1 = (Map)new LinkedHashMap();
    localObject1 = paramDeserializationContext.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramDeserializationContext = (MessageLite)localObject2;
      localObject3 = NameResolverUtilKt.getName(access$getC$p(this).getNameResolver(), ((ProtoBuf.Property)paramDeserializationContext).getName());
      paramCollection = paramCollection1.get(localObject3);
      paramDeserializationContext = paramCollection;
      if (paramCollection == null)
      {
        paramDeserializationContext = new ArrayList();
        paramCollection1.put(localObject3, paramDeserializationContext);
      }
      ((List)paramDeserializationContext).add(localObject2);
    }
    this.propertyProtosBytes = packToByteArray(paramCollection1);
    if (this.c.getComponents().getConfiguration().getTypeAliasesAllowed())
    {
      paramDeserializationContext = (Iterable)paramCollection2;
      paramCollection1 = (Map)new LinkedHashMap();
      paramCollection2 = paramDeserializationContext.iterator();
      while (paramCollection2.hasNext())
      {
        localObject1 = paramCollection2.next();
        paramDeserializationContext = (MessageLite)localObject1;
        localObject2 = NameResolverUtilKt.getName(access$getC$p(this).getNameResolver(), ((ProtoBuf.TypeAlias)paramDeserializationContext).getName());
        paramCollection = paramCollection1.get(localObject2);
        paramDeserializationContext = paramCollection;
        if (paramCollection == null)
        {
          paramDeserializationContext = new ArrayList();
          paramCollection1.put(localObject2, paramDeserializationContext);
        }
        ((List)paramDeserializationContext).add(localObject1);
      }
      paramDeserializationContext = packToByteArray(paramCollection1);
    }
    else
    {
      paramDeserializationContext = MapsKt.emptyMap();
    }
    this.typeAliasBytes = paramDeserializationContext;
    this.functions = this.c.getStorageManager().createMemoizedFunction((Function1)new DeserializedMemberScope.functions.1(this));
    this.properties = this.c.getStorageManager().createMemoizedFunction((Function1)new DeserializedMemberScope.properties.1(this));
    this.typeAliasByName = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new DeserializedMemberScope.typeAliasByName.1(this));
    this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new DeserializedMemberScope.functionNamesLazy.2(this));
    this.variableNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new DeserializedMemberScope.variableNamesLazy.2(this));
    this.classNames$delegate = this.c.getStorageManager().createLazyValue((Function0)new DeserializedMemberScope.classNames.2(paramFunction0));
  }
  
  private final void addFunctionsAndProperties(Collection<DeclarationDescriptor> paramCollection, DescriptorKindFilter paramDescriptorKindFilter, Function1<? super Name, Boolean> paramFunction1, LookupLocation paramLookupLocation)
  {
    Object localObject2;
    Object localObject1;
    if (paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()))
    {
      localObject2 = (Collection)getVariableNames();
      localObject1 = new ArrayList();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Name)((Iterator)localObject2).next();
        if (((Boolean)paramFunction1.invoke(localObject3)).booleanValue()) {
          ((ArrayList)localObject1).addAll(getContributedVariables((Name)localObject3, paramLookupLocation));
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      kotlin.collections.CollectionsKt.sortWith((List)localObject2, (Comparator)localObject3);
      paramCollection.addAll((Collection)localObject1);
    }
    if (paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()))
    {
      localObject1 = (Collection)getFunctionNames();
      paramDescriptorKindFilter = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Name)((Iterator)localObject1).next();
        if (((Boolean)paramFunction1.invoke(localObject2)).booleanValue()) {
          paramDescriptorKindFilter.addAll(getContributedFunctions((Name)localObject2, paramLookupLocation));
        }
      }
      paramFunction1 = (List)paramDescriptorKindFilter;
      paramLookupLocation = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(paramLookupLocation, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      kotlin.collections.CollectionsKt.sortWith(paramFunction1, (Comparator)paramLookupLocation);
      paramCollection.addAll((Collection)paramDescriptorKindFilter);
    }
  }
  
  private final Collection<SimpleFunctionDescriptor> computeFunctions(Name paramName)
  {
    Object localObject2 = this.functionProtosBytes;
    Object localObject1 = ProtoBuf.Function.PARSER;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ProtoBuf.Function.PARSER");
    localObject2 = (byte[])((Map)localObject2).get(paramName);
    if (localObject2 != null)
    {
      localObject1 = SequencesKt.toList(SequencesKt.generateSequence((Function0)new DeserializedMemberScope.computeDescriptors..inlined.let.lambda.1(new ByteArrayInputStream((byte[])localObject2), this, (Parser)localObject1)));
      if (localObject1 != null)
      {
        localObject1 = (Collection)localObject1;
        break label77;
      }
    }
    localObject1 = (Collection)kotlin.collections.CollectionsKt.emptyList();
    label77:
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ProtoBuf.Function localFunction = (ProtoBuf.Function)((Iterator)localObject2).next();
      MemberDeserializer localMemberDeserializer = this.c.getMemberDeserializer();
      Intrinsics.checkExpressionValueIsNotNull(localFunction, "it");
      ((Collection)localObject1).add(localMemberDeserializer.loadFunction(localFunction));
    }
    localObject1 = (ArrayList)localObject1;
    computeNonDeclaredFunctions(paramName, (Collection)localObject1);
    return (Collection)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact((ArrayList)localObject1);
  }
  
  private final Collection<PropertyDescriptor> computeProperties(Name paramName)
  {
    Object localObject2 = this.propertyProtosBytes;
    Object localObject1 = ProtoBuf.Property.PARSER;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ProtoBuf.Property.PARSER");
    localObject2 = (byte[])((Map)localObject2).get(paramName);
    if (localObject2 != null)
    {
      localObject1 = SequencesKt.toList(SequencesKt.generateSequence((Function0)new DeserializedMemberScope.computeDescriptors..inlined.let.lambda.3(new ByteArrayInputStream((byte[])localObject2), this, (Parser)localObject1)));
      if (localObject1 != null)
      {
        localObject1 = (Collection)localObject1;
        break label77;
      }
    }
    localObject1 = (Collection)kotlin.collections.CollectionsKt.emptyList();
    label77:
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ProtoBuf.Property localProperty = (ProtoBuf.Property)((Iterator)localObject2).next();
      MemberDeserializer localMemberDeserializer = this.c.getMemberDeserializer();
      Intrinsics.checkExpressionValueIsNotNull(localProperty, "it");
      ((Collection)localObject1).add(localMemberDeserializer.loadProperty(localProperty));
    }
    localObject1 = (ArrayList)localObject1;
    computeNonDeclaredProperties(paramName, (Collection)localObject1);
    return (Collection)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact((ArrayList)localObject1);
  }
  
  private final TypeAliasDescriptor createTypeAlias(Name paramName)
  {
    paramName = (byte[])this.typeAliasBytes.get(paramName);
    if (paramName != null)
    {
      paramName = ProtoBuf.TypeAlias.parseDelimitedFrom((InputStream)new ByteArrayInputStream(paramName), this.c.getComponents().getExtensionRegistryLite());
      if (paramName != null) {
        return this.c.getMemberDeserializer().loadTypeAlias(paramName);
      }
    }
    return null;
  }
  
  private final ClassDescriptor deserializeClass(Name paramName)
  {
    return this.c.getComponents().deserializeClass(createClassId(paramName));
  }
  
  private final Set<Name> getFunctionNamesLazy()
  {
    return (Set)StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
  }
  
  private final Set<Name> getTypeAliasNames()
  {
    return this.typeAliasBytes.keySet();
  }
  
  private final Set<Name> getVariableNamesLazy()
  {
    return (Set)StorageKt.getValue(this.variableNamesLazy$delegate, this, $$delegatedProperties[1]);
  }
  
  private final Map<Name, byte[]> packToByteArray(@NotNull Map<Name, ? extends Collection<? extends AbstractMessageLite>> paramMap)
  {
    Map localMap = (Map)new LinkedHashMap(MapsKt.mapCapacity(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject3 = (Iterable)((Map.Entry)localObject2).getValue();
      localObject2 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((AbstractMessageLite)((Iterator)localObject3).next()).writeDelimitedTo((OutputStream)localByteArrayOutputStream);
        ((Collection)localObject2).add(Unit.INSTANCE);
      }
      localObject2 = (List)localObject2;
      localMap.put(localObject1, localByteArrayOutputStream.toByteArray());
    }
    return localMap;
  }
  
  protected abstract void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> paramCollection, @NotNull Function1<? super Name, Boolean> paramFunction1);
  
  @NotNull
  protected final Collection<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    ArrayList localArrayList = new ArrayList(0);
    if (paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
      addEnumEntryDescriptors((Collection)localArrayList, paramFunction1);
    }
    Collection localCollection = (Collection)localArrayList;
    addFunctionsAndProperties(localCollection, paramDescriptorKindFilter, paramFunction1, paramLookupLocation);
    if (paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()))
    {
      paramLookupLocation = getClassNames$deserialization().iterator();
      while (paramLookupLocation.hasNext())
      {
        Name localName = (Name)paramLookupLocation.next();
        if (((Boolean)paramFunction1.invoke(localName)).booleanValue()) {
          kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(localCollection, deserializeClass(localName));
        }
      }
    }
    if (paramDescriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK()))
    {
      paramDescriptorKindFilter = getTypeAliasNames().iterator();
      while (paramDescriptorKindFilter.hasNext())
      {
        paramLookupLocation = (Name)paramDescriptorKindFilter.next();
        if (((Boolean)paramFunction1.invoke(paramLookupLocation)).booleanValue()) {
          kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(localCollection, this.typeAliasByName.invoke(paramLookupLocation));
        }
      }
    }
    return (Collection)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(localArrayList);
  }
  
  protected void computeNonDeclaredFunctions(@NotNull Name paramName, @NotNull Collection<SimpleFunctionDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramCollection, "functions");
  }
  
  protected void computeNonDeclaredProperties(@NotNull Name paramName, @NotNull Collection<PropertyDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramCollection, "descriptors");
  }
  
  @NotNull
  protected abstract ClassId createClassId(@NotNull Name paramName);
  
  @NotNull
  protected final DeserializationContext getC()
  {
    return this.c;
  }
  
  @NotNull
  public final Set<Name> getClassNames$deserialization()
  {
    return (Set)StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[2]);
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    if (hasClass(paramName)) {
      return (ClassifierDescriptor)deserializeClass(paramName);
    }
    if (getTypeAliasNames().contains(paramName)) {
      return (ClassifierDescriptor)this.typeAliasByName.invoke(paramName);
    }
    return null;
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
  public Set<Name> getFunctionNames()
  {
    return getFunctionNamesLazy();
  }
  
  @NotNull
  protected abstract Set<Name> getNonDeclaredFunctionNames();
  
  @NotNull
  protected abstract Set<Name> getNonDeclaredVariableNames();
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    return getVariableNamesLazy();
  }
  
  protected boolean hasClass(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return getClassNames$deserialization().contains(paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
 * JD-Core Version:    0.7.0.1
 */