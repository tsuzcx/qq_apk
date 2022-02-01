package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class DeserializedClassDescriptor$EnumEntryClassDescriptors
{
  private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
  private final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
  private final NotNullLazyValue<Set<Name>> enumMemberNames;
  
  public DeserializedClassDescriptor$EnumEntryClassDescriptors()
  {
    Object localObject2 = localObject1.getClassProto().getEnumEntryList();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "classProto.enumEntryList");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10)), 16));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      ProtoBuf.EnumEntry localEnumEntry = (ProtoBuf.EnumEntry)localObject4;
      NameResolver localNameResolver = this.this$0.getC().getNameResolver();
      Intrinsics.checkExpressionValueIsNotNull(localEnumEntry, "it");
      ((Map)localObject2).put(NameResolverUtilKt.getName(localNameResolver, localEnumEntry.getName()), localObject4);
    }
    this.enumEntryProtos = ((Map)localObject2);
    this.enumEntryByName = localObject1.getC().getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName.1(this));
    this.enumMemberNames = localObject1.getC().getStorageManager().createLazyValue((Function0)new DeserializedClassDescriptor.EnumEntryClassDescriptors.enumMemberNames.1(this));
  }
  
  private final Set<Name> computeEnumMemberNames()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.this$0.getTypeConstructor().getSupertypes().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(((KotlinType)((Iterator)localObject2).next()).getMemberScope(), null, null, 3, null).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (DeclarationDescriptor)((Iterator)localObject3).next();
        if (((localObject4 instanceof SimpleFunctionDescriptor)) || ((localObject4 instanceof PropertyDescriptor))) {
          ((HashSet)localObject1).add(((DeclarationDescriptor)localObject4).getName());
        }
      }
    }
    localObject2 = this.this$0.getClassProto().getFunctionList();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "classProto.functionList");
    localObject2 = ((Iterable)localObject2).iterator();
    NameResolver localNameResolver;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      localObject3 = (Collection)localObject1;
      localObject4 = (ProtoBuf.Function)localObject4;
      localNameResolver = this.this$0.getC().getNameResolver();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it");
      ((Collection)localObject3).add(NameResolverUtilKt.getName(localNameResolver, ((ProtoBuf.Function)localObject4).getName()));
    }
    localObject1 = (Collection)localObject1;
    localObject2 = (Set)localObject1;
    Object localObject3 = this.this$0.getClassProto().getPropertyList();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "classProto.propertyList");
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ProtoBuf.Property)((Iterator)localObject3).next();
      localNameResolver = this.this$0.getC().getNameResolver();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it");
      ((Collection)localObject1).add(NameResolverUtilKt.getName(localNameResolver, ((ProtoBuf.Property)localObject4).getName()));
    }
    return SetsKt.plus((Set)localObject2, (Iterable)localObject1);
  }
  
  @NotNull
  public final Collection<ClassDescriptor> all()
  {
    Object localObject = (Iterable)this.enumEntryProtos.keySet();
    Collection localCollection = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClassDescriptor localClassDescriptor = findEnumEntry((Name)((Iterator)localObject).next());
      if (localClassDescriptor != null) {
        localCollection.add(localClassDescriptor);
      }
    }
    return (Collection)localCollection;
  }
  
  @Nullable
  public final ClassDescriptor findEnumEntry(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return (ClassDescriptor)this.enumEntryByName.invoke(paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors
 * JD-Core Version:    0.7.0.1
 */