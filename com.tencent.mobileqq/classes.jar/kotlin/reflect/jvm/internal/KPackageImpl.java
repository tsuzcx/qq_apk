package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", "", "other", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "toString", "Data", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KPackageImpl
  extends KDeclarationContainerImpl
{
  private final ReflectProperties.LazyVal<KPackageImpl.Data> data;
  @NotNull
  private final Class<?> jClass;
  @Nullable
  private final String usageModuleName;
  
  public KPackageImpl(@NotNull Class<?> paramClass, @Nullable String paramString)
  {
    this.jClass = paramClass;
    this.usageModuleName = paramString;
    paramClass = ReflectProperties.lazy((Function0)new KPackageImpl.data.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "ReflectProperties.lazy { Data() }");
    this.data = paramClass;
  }
  
  private final MemberScope getScope()
  {
    return ((KPackageImpl.Data)this.data.invoke()).getScope();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof KPackageImpl)) && (Intrinsics.areEqual(getJClass(), ((KPackageImpl)paramObject).getJClass()));
  }
  
  @NotNull
  public Collection<ConstructorDescriptor> getConstructorDescriptors()
  {
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<FunctionDescriptor> getFunctions(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return getScope().getContributedFunctions(paramName, (LookupLocation)NoLookupLocation.FROM_REFLECTION);
  }
  
  @NotNull
  public Class<?> getJClass()
  {
    return this.jClass;
  }
  
  @Nullable
  public PropertyDescriptor getLocalProperty(int paramInt)
  {
    Object localObject3 = ((KPackageImpl.Data)this.data.invoke()).getMetadata();
    MessageLite localMessageLite = null;
    Object localObject1 = localMessageLite;
    if (localObject3 != null)
    {
      Object localObject4 = (JvmNameResolver)((Triple)localObject3).component1();
      Object localObject2 = (ProtoBuf.Package)((Triple)localObject3).component2();
      localObject3 = (JvmMetadataVersion)((Triple)localObject3).component3();
      localObject1 = (GeneratedMessageLite.ExtendableMessage)localObject2;
      Object localObject5 = JvmProtoBuf.packageLocalVariable;
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "JvmProtoBuf.packageLocalVariable");
      localObject5 = (ProtoBuf.Property)ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage)localObject1, (GeneratedMessageLite.GeneratedExtension)localObject5, paramInt);
      localObject1 = localMessageLite;
      if (localObject5 != null)
      {
        localObject1 = getJClass();
        localMessageLite = (MessageLite)localObject5;
        localObject4 = (NameResolver)localObject4;
        localObject2 = ((ProtoBuf.Package)localObject2).getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "packageProto.typeTable");
        localObject1 = (PropertyDescriptor)UtilKt.deserializeToDescriptor((Class)localObject1, localMessageLite, (NameResolver)localObject4, new TypeTable((ProtoBuf.TypeTable)localObject2), (BinaryVersion)localObject3, (Function2)KPackageImpl.getLocalProperty.1.1.1.INSTANCE);
      }
    }
    return localObject1;
  }
  
  @NotNull
  public Collection<KCallable<?>> getMembers()
  {
    return ((KPackageImpl.Data)this.data.invoke()).getMembers();
  }
  
  @NotNull
  protected Class<?> getMethodOwner()
  {
    Class localClass = ((KPackageImpl.Data)this.data.invoke()).getMultifileFacade();
    if (localClass != null) {
      return localClass;
    }
    return getJClass();
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getProperties(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return getScope().getContributedVariables(paramName, (LookupLocation)NoLookupLocation.FROM_REFLECTION);
  }
  
  public int hashCode()
  {
    return getJClass().hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file class ");
    localStringBuilder.append(ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl
 * JD-Core Version:    0.7.0.1
 */