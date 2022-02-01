package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<*>;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class UtilKt
{
  @NotNull
  private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");
  
  @Nullable
  public static final KCallableImpl<?> asKCallableImpl(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof KCallableImpl)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (KCallableImpl)localObject;
    if (localObject == null) {
      localObject = (KCallableImpl)asKFunctionImpl(paramObject);
    }
    if (localObject != null) {
      return localObject;
    }
    return (KCallableImpl)asKPropertyImpl(paramObject);
  }
  
  @Nullable
  public static final KFunctionImpl asKFunctionImpl(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof KFunctionImpl)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (KFunctionImpl)localObject;
    if (localObject != null) {
      return localObject;
    }
    localObject = paramObject;
    if (!(paramObject instanceof FunctionReference)) {
      localObject = null;
    }
    paramObject = (FunctionReference)localObject;
    if (paramObject != null) {
      paramObject = paramObject.compute();
    } else {
      paramObject = null;
    }
    localObject = paramObject;
    if (!(paramObject instanceof KFunctionImpl)) {
      localObject = null;
    }
    return (KFunctionImpl)localObject;
  }
  
  @Nullable
  public static final KPropertyImpl<?> asKPropertyImpl(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof KPropertyImpl)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (KPropertyImpl)localObject;
    if (localObject != null) {
      return localObject;
    }
    localObject = paramObject;
    if (!(paramObject instanceof PropertyReference)) {
      localObject = null;
    }
    paramObject = (PropertyReference)localObject;
    if (paramObject != null) {
      paramObject = paramObject.compute();
    } else {
      paramObject = null;
    }
    localObject = paramObject;
    if (!(paramObject instanceof KPropertyImpl)) {
      localObject = null;
    }
    return (KPropertyImpl)localObject;
  }
  
  @NotNull
  public static final List<Annotation> computeAnnotations(@NotNull Annotated paramAnnotated)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotated, "$this$computeAnnotations");
    paramAnnotated = (Iterable)paramAnnotated.getAnnotations();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramAnnotated.iterator();
    while (localIterator.hasNext())
    {
      paramAnnotated = (AnnotationDescriptor)localIterator.next();
      Object localObject2 = paramAnnotated.getSource();
      boolean bool = localObject2 instanceof ReflectAnnotationSource;
      Object localObject1 = null;
      if (bool)
      {
        paramAnnotated = ((ReflectAnnotationSource)localObject2).getAnnotation();
      }
      else if ((localObject2 instanceof RuntimeSourceElementFactory.RuntimeSourceElement))
      {
        localObject2 = ((RuntimeSourceElementFactory.RuntimeSourceElement)localObject2).getJavaElement();
        paramAnnotated = (Annotated)localObject2;
        if (!(localObject2 instanceof ReflectJavaAnnotation)) {
          paramAnnotated = null;
        }
        localObject2 = (ReflectJavaAnnotation)paramAnnotated;
        paramAnnotated = localObject1;
        if (localObject2 != null) {
          paramAnnotated = ((ReflectJavaAnnotation)localObject2).getAnnotation();
        }
      }
      else
      {
        paramAnnotated = toAnnotationInstance(paramAnnotated);
      }
      if (paramAnnotated != null) {
        localCollection.add(paramAnnotated);
      }
    }
    return (List)localCollection;
  }
  
  @Nullable
  public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(@NotNull Class<?> paramClass, @NotNull M paramM, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull BinaryVersion paramBinaryVersion, @NotNull Function2<? super MemberDeserializer, ? super M, ? extends D> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "moduleAnchor");
    Intrinsics.checkParameterIsNotNull(paramM, "proto");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "metadataVersion");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "createDescriptor");
    Object localObject = ModuleByClassLoaderKt.getOrCreateModule(paramClass);
    if ((paramM instanceof ProtoBuf.Function)) {}
    for (paramClass = ((ProtoBuf.Function)paramM).getTypeParameterList();; paramClass = ((ProtoBuf.Property)paramM).getTypeParameterList())
    {
      break;
      if (!(paramM instanceof ProtoBuf.Property)) {
        break label150;
      }
    }
    DeserializationComponents localDeserializationComponents = ((RuntimeModuleData)localObject).getDeserialization();
    localObject = (DeclarationDescriptor)((RuntimeModuleData)localObject).getModule();
    VersionRequirementTable localVersionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "typeParameters");
    return (CallableDescriptor)paramFunction2.invoke(new MemberDeserializer(new DeserializationContext(localDeserializationComponents, paramNameResolver, (DeclarationDescriptor)localObject, paramTypeTable, localVersionRequirementTable, paramBinaryVersion, null, null, paramClass)), paramM);
    label150:
    paramClass = new StringBuilder();
    paramClass.append("Unsupported message: ");
    paramClass.append(paramM);
    paramClass = (Throwable)new IllegalStateException(paramClass.toString().toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  @Nullable
  public static final ReceiverParameterDescriptor getInstanceReceiverParameter(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "$this$instanceReceiverParameter");
    if (paramCallableDescriptor.getDispatchReceiverParameter() != null)
    {
      paramCallableDescriptor = paramCallableDescriptor.getContainingDeclaration();
      if (paramCallableDescriptor != null) {
        return ((ClassDescriptor)paramCallableDescriptor).getThisAsReceiverParameter();
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
    return null;
  }
  
  @NotNull
  public static final FqName getJVM_STATIC()
  {
    return JVM_STATIC;
  }
  
  private static final Class<?> loadClass(ClassLoader paramClassLoader, String paramString1, String paramString2, int paramInt)
  {
    if (Intrinsics.areEqual(paramString1, "kotlin")) {
      switch (paramString2.hashCode())
      {
      default: 
        break;
      case 2104330525: 
        if (paramString2.equals("LongArray")) {
          return [J.class;
        }
        break;
      case 948852093: 
        if (paramString2.equals("FloatArray")) {
          return [F.class;
        }
        break;
      case 601811914: 
        if (paramString2.equals("IntArray")) {
          return [I.class;
        }
        break;
      case 63537721: 
        if (paramString2.equals("Array")) {
          return [Ljava.lang.Object.class;
        }
        break;
      case 22374632: 
        if (paramString2.equals("DoubleArray")) {
          return [D.class;
        }
        break;
      case -74930671: 
        if (paramString2.equals("ByteArray")) {
          return [B.class;
        }
        break;
      case -755911549: 
        if (paramString2.equals("CharArray")) {
          return [C.class;
        }
        break;
      case -763279523: 
        if (paramString2.equals("ShortArray")) {
          return [S.class;
        }
        break;
      case -901856463: 
        if (paramString2.equals("BooleanArray")) {
          return [Z.class;
        }
        break;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('.');
    localStringBuilder.append(StringsKt.replace$default(paramString2, '.', '$', false, 4, null));
    paramString2 = localStringBuilder.toString();
    paramString1 = paramString2;
    if (paramInt > 0)
    {
      paramString1 = new StringBuilder();
      paramString1.append(StringsKt.repeat((CharSequence)"[", paramInt));
      paramString1.append('L');
      paramString1.append(paramString2);
      paramString1.append(';');
      paramString1 = paramString1.toString();
    }
    return ReflectJavaClassFinderKt.tryLoadClass(paramClassLoader, paramString1);
  }
  
  private static final Class<?> loadClass(ClassLoader paramClassLoader, ClassId paramClassId, int paramInt)
  {
    Object localObject = JavaToKotlinClassMap.INSTANCE;
    FqNameUnsafe localFqNameUnsafe = paramClassId.asSingleFqName().toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(localFqNameUnsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
    localObject = ((JavaToKotlinClassMap)localObject).mapKotlinToJava(localFqNameUnsafe);
    if (localObject != null) {
      paramClassId = (ClassId)localObject;
    }
    localObject = paramClassId.getPackageFqName().asString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "javaClassId.packageFqName.asString()");
    paramClassId = paramClassId.getRelativeClassName().asString();
    Intrinsics.checkExpressionValueIsNotNull(paramClassId, "javaClassId.relativeClassName.asString()");
    return loadClass(paramClassLoader, (String)localObject, paramClassId, paramInt);
  }
  
  private static final Annotation toAnnotationInstance(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Object localObject1 = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
    if (localObject1 != null) {
      localObject1 = toJavaClass((ClassDescriptor)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof Class)) {
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      paramAnnotationDescriptor = (Iterable)paramAnnotationDescriptor.getAllValueArguments().entrySet();
      localObject1 = (Collection)new ArrayList();
      Iterator localIterator = paramAnnotationDescriptor.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (Map.Entry)localIterator.next();
        paramAnnotationDescriptor = (Name)((Map.Entry)localObject3).getKey();
        localObject3 = (ConstantValue)((Map.Entry)localObject3).getValue();
        ClassLoader localClassLoader = localObject2.getClassLoader();
        Intrinsics.checkExpressionValueIsNotNull(localClassLoader, "annotationClass.classLoader");
        localObject3 = toRuntimeValue((ConstantValue)localObject3, localClassLoader);
        if (localObject3 != null) {
          paramAnnotationDescriptor = TuplesKt.to(paramAnnotationDescriptor.asString(), localObject3);
        } else {
          paramAnnotationDescriptor = null;
        }
        if (paramAnnotationDescriptor != null) {
          ((Collection)localObject1).add(paramAnnotationDescriptor);
        }
      }
      return (Annotation)AnnotationConstructorCallerKt.createAnnotationInstance$default(localObject2, MapsKt.toMap((Iterable)localObject1), null, 4, null);
    }
    return null;
  }
  
  @Nullable
  public static final Class<?> toJavaClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$toJavaClass");
    Object localObject = paramClassDescriptor.getSource();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "source");
    if ((localObject instanceof KotlinJvmBinarySourceElement))
    {
      paramClassDescriptor = ((KotlinJvmBinarySourceElement)localObject).getBinaryClass();
      if (paramClassDescriptor != null) {
        return ((ReflectKotlinClass)paramClassDescriptor).getKlass();
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
    }
    if ((localObject instanceof RuntimeSourceElementFactory.RuntimeSourceElement))
    {
      paramClassDescriptor = ((RuntimeSourceElementFactory.RuntimeSourceElement)localObject).getJavaElement();
      if (paramClassDescriptor != null) {
        return ((ReflectJavaClass)paramClassDescriptor).getElement();
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
    }
    localObject = DescriptorUtilsKt.getClassId((ClassifierDescriptor)paramClassDescriptor);
    if (localObject != null) {
      return loadClass(ReflectClassUtilKt.getSafeClassLoader(paramClassDescriptor.getClass()), (ClassId)localObject, 0);
    }
    return null;
  }
  
  @Nullable
  public static final KVisibility toKVisibility(@NotNull Visibility paramVisibility)
  {
    Intrinsics.checkParameterIsNotNull(paramVisibility, "$this$toKVisibility");
    if (Intrinsics.areEqual(paramVisibility, Visibilities.PUBLIC)) {
      return KVisibility.PUBLIC;
    }
    if (Intrinsics.areEqual(paramVisibility, Visibilities.PROTECTED)) {
      return KVisibility.PROTECTED;
    }
    if (Intrinsics.areEqual(paramVisibility, Visibilities.INTERNAL)) {
      return KVisibility.INTERNAL;
    }
    if ((Intrinsics.areEqual(paramVisibility, Visibilities.PRIVATE)) || (Intrinsics.areEqual(paramVisibility, Visibilities.PRIVATE_TO_THIS))) {
      return KVisibility.PRIVATE;
    }
    return null;
  }
  
  private static final Object toRuntimeValue(@NotNull ConstantValue<?> paramConstantValue, ClassLoader paramClassLoader)
  {
    boolean bool = paramConstantValue instanceof AnnotationValue;
    Object localObject1 = null;
    if (bool) {
      return toAnnotationInstance((AnnotationDescriptor)((AnnotationValue)paramConstantValue).getValue());
    }
    if ((paramConstantValue instanceof ArrayValue))
    {
      localObject1 = (Iterable)((ArrayValue)paramConstantValue).getValue();
      paramConstantValue = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramConstantValue.add(toRuntimeValue((ConstantValue)((Iterator)localObject1).next(), paramClassLoader));
      }
      paramConstantValue = ((Collection)paramConstantValue).toArray(new Object[0]);
      if (paramConstantValue != null) {
        return paramConstantValue;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    if ((paramConstantValue instanceof EnumValue))
    {
      Object localObject2 = (Pair)((EnumValue)paramConstantValue).getValue();
      paramConstantValue = (ClassId)((Pair)localObject2).component1();
      localObject2 = (Name)((Pair)localObject2).component2();
      paramClassLoader = loadClass$default(paramClassLoader, paramConstantValue, 0, 4, null);
      paramConstantValue = (ConstantValue<?>)localObject1;
      if (paramClassLoader != null)
      {
        if (paramClassLoader != null) {
          return Util.getEnumConstantByName(paramClassLoader, ((Name)localObject2).asString());
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
      }
    }
    else if ((paramConstantValue instanceof KClassValue))
    {
      paramConstantValue = (KClassValue.Value)((KClassValue)paramConstantValue).getValue();
      if ((paramConstantValue instanceof KClassValue.Value.NormalClass))
      {
        paramConstantValue = (KClassValue.Value.NormalClass)paramConstantValue;
        return loadClass(paramClassLoader, paramConstantValue.getClassId(), paramConstantValue.getArrayDimensions());
      }
      if ((paramConstantValue instanceof KClassValue.Value.LocalClass))
      {
        paramClassLoader = ((KClassValue.Value.LocalClass)paramConstantValue).getType().getConstructor().getDeclarationDescriptor();
        paramConstantValue = paramClassLoader;
        if (!(paramClassLoader instanceof ClassDescriptor)) {
          paramConstantValue = null;
        }
        paramClassLoader = (ClassDescriptor)paramConstantValue;
        paramConstantValue = (ConstantValue<?>)localObject1;
        if (paramClassLoader != null) {
          return toJavaClass(paramClassLoader);
        }
      }
      else
      {
        throw new NoWhenBranchMatchedException();
      }
    }
    else
    {
      if ((paramConstantValue instanceof ErrorValue)) {
        return null;
      }
      if ((paramConstantValue instanceof NullValue)) {
        return null;
      }
      paramConstantValue = paramConstantValue.getValue();
    }
    return paramConstantValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.UtilKt
 * JD-Core Version:    0.7.0.1
 */