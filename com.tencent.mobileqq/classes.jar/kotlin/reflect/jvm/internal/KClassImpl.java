package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KClassImpl<T>
  extends KDeclarationContainerImpl
  implements KClass<T>, KClassifierImpl
{
  @NotNull
  private final ReflectProperties.LazyVal<KClassImpl<T>.Data> data;
  @NotNull
  private final Class<T> jClass;
  
  public KClassImpl(@NotNull Class<T> paramClass)
  {
    this.jClass = paramClass;
    paramClass = ReflectProperties.lazy((Function0)new KClassImpl.data.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "ReflectProperties.lazy { Data() }");
    this.data = paramClass;
  }
  
  private final ClassId getClassId()
  {
    return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
  }
  
  private final Void reportUnresolvedClass()
  {
    Object localObject = ReflectKotlinClass.Factory.create(getJClass());
    if (localObject != null)
    {
      localObject = ((ReflectKotlinClass)localObject).getClassHeader();
      if (localObject != null)
      {
        localObject = ((KotlinClassHeader)localObject).getKind();
        break label34;
      }
    }
    localObject = null;
    label34:
    if (localObject != null) {
      switch (KClassImpl.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      default: 
        throw new NoWhenBranchMatchedException();
      case 5: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown class: ");
        localStringBuilder.append(getJClass());
        localStringBuilder.append(" (kind = ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(')');
        throw ((Throwable)new KotlinReflectionInternalError(localStringBuilder.toString()));
      case 4: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ");
        ((StringBuilder)localObject).append("library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
        ((StringBuilder)localObject).append(getJClass());
        throw ((Throwable)new UnsupportedOperationException(((StringBuilder)localObject).toString()));
      case 1: 
      case 2: 
      case 3: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Packages and file facades are not yet supported in Kotlin reflection. ");
        ((StringBuilder)localObject).append("Meanwhile please use Java reflection to inspect this class: ");
        ((StringBuilder)localObject).append(getJClass());
        throw ((Throwable)new UnsupportedOperationException(((StringBuilder)localObject).toString()));
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unresolved class: ");
    ((StringBuilder)localObject).append(getJClass());
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof KClassImpl)) && (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass)paramObject)));
  }
  
  @NotNull
  public List<Annotation> getAnnotations()
  {
    return ((KClassImpl.Data)this.data.invoke()).getAnnotations();
  }
  
  @NotNull
  public Collection<ConstructorDescriptor> getConstructorDescriptors()
  {
    Object localObject = getDescriptor();
    if ((((ClassDescriptor)localObject).getKind() != ClassKind.INTERFACE) && (((ClassDescriptor)localObject).getKind() != ClassKind.OBJECT))
    {
      localObject = ((ClassDescriptor)localObject).getConstructors();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "descriptor.constructors");
      return localObject;
    }
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<KFunction<T>> getConstructors()
  {
    return ((KClassImpl.Data)this.data.invoke()).getConstructors();
  }
  
  @NotNull
  public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData()
  {
    return this.data;
  }
  
  @NotNull
  public ClassDescriptor getDescriptor()
  {
    return ((KClassImpl.Data)this.data.invoke()).getDescriptor();
  }
  
  @NotNull
  public Collection<FunctionDescriptor> getFunctions(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return (Collection)CollectionsKt.plus(getMemberScope$kotlin_reflection().getContributedFunctions(paramName, (LookupLocation)NoLookupLocation.FROM_REFLECTION), (Iterable)getStaticScope$kotlin_reflection().getContributedFunctions(paramName, (LookupLocation)NoLookupLocation.FROM_REFLECTION));
  }
  
  @NotNull
  public Class<T> getJClass()
  {
    return this.jClass;
  }
  
  @Nullable
  public PropertyDescriptor getLocalProperty(int paramInt)
  {
    if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls"))
    {
      localObject1 = getJClass().getDeclaringClass();
      if ((localObject1 != null) && (((Class)localObject1).isInterface()))
      {
        localObject1 = JvmClassMappingKt.getKotlinClass((Class)localObject1);
        if (localObject1 != null) {
          return ((KClassImpl)localObject1).getLocalProperty(paramInt);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
      }
    }
    Object localObject1 = getDescriptor();
    boolean bool = localObject1 instanceof DeserializedClassDescriptor;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    DeserializedClassDescriptor localDeserializedClassDescriptor = (DeserializedClassDescriptor)localObject1;
    localObject1 = localObject2;
    if (localDeserializedClassDescriptor != null)
    {
      localObject1 = (GeneratedMessageLite.ExtendableMessage)localDeserializedClassDescriptor.getClassProto();
      Object localObject3 = JvmProtoBuf.classLocalVariable;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "JvmProtoBuf.classLocalVariable");
      localObject3 = (ProtoBuf.Property)ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage)localObject1, (GeneratedMessageLite.GeneratedExtension)localObject3, paramInt);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (PropertyDescriptor)UtilKt.deserializeToDescriptor(getJClass(), (MessageLite)localObject3, localDeserializedClassDescriptor.getC().getNameResolver(), localDeserializedClassDescriptor.getC().getTypeTable(), localDeserializedClassDescriptor.getMetadataVersion(), (Function2)KClassImpl.getLocalProperty.2.1.1.INSTANCE);
      }
    }
    return localObject1;
  }
  
  @NotNull
  public final MemberScope getMemberScope$kotlin_reflection()
  {
    return getDescriptor().getDefaultType().getMemberScope();
  }
  
  @NotNull
  public Collection<KCallable<?>> getMembers()
  {
    return ((KClassImpl.Data)this.data.invoke()).getAllMembers();
  }
  
  @NotNull
  public Collection<KClass<?>> getNestedClasses()
  {
    return ((KClassImpl.Data)this.data.invoke()).getNestedClasses();
  }
  
  @Nullable
  public T getObjectInstance()
  {
    return ((KClassImpl.Data)this.data.invoke()).getObjectInstance();
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getProperties(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return (Collection)CollectionsKt.plus(getMemberScope$kotlin_reflection().getContributedVariables(paramName, (LookupLocation)NoLookupLocation.FROM_REFLECTION), (Iterable)getStaticScope$kotlin_reflection().getContributedVariables(paramName, (LookupLocation)NoLookupLocation.FROM_REFLECTION));
  }
  
  @Nullable
  public String getQualifiedName()
  {
    return ((KClassImpl.Data)this.data.invoke()).getQualifiedName();
  }
  
  @NotNull
  public List<KClass<? extends T>> getSealedSubclasses()
  {
    return ((KClassImpl.Data)this.data.invoke()).getSealedSubclasses();
  }
  
  @Nullable
  public String getSimpleName()
  {
    return ((KClassImpl.Data)this.data.invoke()).getSimpleName();
  }
  
  @NotNull
  public final MemberScope getStaticScope$kotlin_reflection()
  {
    MemberScope localMemberScope = getDescriptor().getStaticScope();
    Intrinsics.checkExpressionValueIsNotNull(localMemberScope, "descriptor.staticScope");
    return localMemberScope;
  }
  
  @NotNull
  public List<KType> getSupertypes()
  {
    return ((KClassImpl.Data)this.data.invoke()).getSupertypes();
  }
  
  @NotNull
  public List<KTypeParameter> getTypeParameters()
  {
    return ((KClassImpl.Data)this.data.invoke()).getTypeParameters();
  }
  
  @Nullable
  public KVisibility getVisibility()
  {
    Visibility localVisibility = getDescriptor().getVisibility();
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "descriptor.visibility");
    return UtilKt.toKVisibility(localVisibility);
  }
  
  public int hashCode()
  {
    return JvmClassMappingKt.getJavaObjectType(this).hashCode();
  }
  
  public boolean isAbstract()
  {
    return getDescriptor().getModality() == Modality.ABSTRACT;
  }
  
  public boolean isCompanion()
  {
    return getDescriptor().isCompanionObject();
  }
  
  public boolean isData()
  {
    return getDescriptor().isData();
  }
  
  public boolean isFinal()
  {
    return getDescriptor().getModality() == Modality.FINAL;
  }
  
  public boolean isInner()
  {
    return getDescriptor().isInner();
  }
  
  public boolean isInstance(@Nullable Object paramObject)
  {
    Object localObject = ReflectClassUtilKt.getFunctionClassArity(getJClass());
    if (localObject != null) {
      return TypeIntrinsics.isFunctionOfArity(paramObject, ((Number)localObject).intValue());
    }
    localObject = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
    if (localObject == null) {
      localObject = getJClass();
    }
    return ((Class)localObject).isInstance(paramObject);
  }
  
  public boolean isOpen()
  {
    return getDescriptor().getModality() == Modality.OPEN;
  }
  
  public boolean isSealed()
  {
    return getDescriptor().getModality() == Modality.SEALED;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("class ");
    Object localObject2 = getClassId();
    Object localObject1 = ((ClassId)localObject2).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "classId.packageFqName");
    if (((FqName)localObject1).isRoot())
    {
      localObject1 = "";
    }
    else
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(((FqName)localObject1).asString());
      localStringBuilder2.append(".");
      localObject1 = localStringBuilder2.toString();
    }
    localObject2 = ((ClassId)localObject2).getRelativeClassName().asString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "classId.relativeClassName.asString()");
    localObject2 = StringsKt.replace$default((String)localObject2, '.', '$', false, 4, null);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append((String)localObject1);
    localStringBuilder2.append((String)localObject2);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl
 * JD-Core Version:    0.7.0.1
 */