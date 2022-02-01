package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class RuntimeTypeMapper
{
  public static final RuntimeTypeMapper INSTANCE = new RuntimeTypeMapper();
  private static final ClassId JAVA_LANG_VOID;
  
  static
  {
    ClassId localClassId = ClassId.topLevel(new FqName("java.lang.Void"));
    Intrinsics.checkExpressionValueIsNotNull(localClassId, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
    JAVA_LANG_VOID = localClassId;
  }
  
  private final PrimitiveType getPrimitiveType(@NotNull Class<?> paramClass)
  {
    if (paramClass.isPrimitive())
    {
      paramClass = JvmPrimitiveType.get(paramClass.getSimpleName());
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "JvmPrimitiveType.get(simpleName)");
      return paramClass.getPrimitiveType();
    }
    return null;
  }
  
  private final boolean isKnownBuiltInFunction(FunctionDescriptor paramFunctionDescriptor)
  {
    if (!DescriptorFactory.isEnumValueOfMethod(paramFunctionDescriptor))
    {
      if (DescriptorFactory.isEnumValuesMethod(paramFunctionDescriptor)) {
        return true;
      }
      return (Intrinsics.areEqual(paramFunctionDescriptor.getName(), CloneableClassScope.Companion.getCLONE_NAME())) && (paramFunctionDescriptor.getValueParameters().isEmpty());
    }
    return true;
  }
  
  private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor paramFunctionDescriptor)
  {
    return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName((CallableMemberDescriptor)paramFunctionDescriptor), MethodSignatureMappingKt.computeJvmDescriptor$default(paramFunctionDescriptor, false, false, 1, null)));
  }
  
  private final String mapName(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    String str = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(paramCallableMemberDescriptor);
    if (str != null) {
      return str;
    }
    if ((paramCallableMemberDescriptor instanceof PropertyGetterDescriptor)) {
      paramCallableMemberDescriptor = JvmAbi.getterName(DescriptorUtilsKt.getPropertyIfAccessor(paramCallableMemberDescriptor).getName().asString());
    }
    for (;;)
    {
      break;
      if ((paramCallableMemberDescriptor instanceof PropertySetterDescriptor)) {
        paramCallableMemberDescriptor = JvmAbi.setterName(DescriptorUtilsKt.getPropertyIfAccessor(paramCallableMemberDescriptor).getName().asString());
      } else {
        paramCallableMemberDescriptor = paramCallableMemberDescriptor.getName().asString();
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "when (descriptor) {\n    …name.asString()\n        }");
    return paramCallableMemberDescriptor;
  }
  
  @NotNull
  public final ClassId mapJvmClassToKotlinClassId(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    if (paramClass.isArray())
    {
      paramClass = paramClass.getComponentType();
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "klass.componentType");
      paramClass = getPrimitiveType(paramClass);
      if (paramClass != null) {
        return new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, paramClass.getArrayTypeName());
      }
      paramClass = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.array.toSafe());
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      return paramClass;
    }
    if (Intrinsics.areEqual(paramClass, Void.TYPE)) {
      return JAVA_LANG_VOID;
    }
    Object localObject = getPrimitiveType(paramClass);
    if (localObject != null) {
      return new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, ((PrimitiveType)localObject).getTypeName());
    }
    paramClass = ReflectClassUtilKt.getClassId(paramClass);
    if (!paramClass.isLocal())
    {
      localObject = JavaToKotlinClassMap.INSTANCE;
      FqName localFqName = paramClass.asSingleFqName();
      Intrinsics.checkExpressionValueIsNotNull(localFqName, "classId.asSingleFqName()");
      localObject = ((JavaToKotlinClassMap)localObject).mapJavaToKotlin(localFqName);
      if (localObject != null) {
        return localObject;
      }
    }
    return paramClass;
  }
  
  @NotNull
  public final JvmPropertySignature mapPropertySignature(@NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertyDescriptor, "possiblyOverriddenProperty");
    paramPropertyDescriptor = DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)paramPropertyDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
    Object localObject3 = ((PropertyDescriptor)paramPropertyDescriptor).getOriginal();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "DescriptorUtils.unwrapFa…rriddenProperty).original");
    boolean bool = localObject3 instanceof DeserializedPropertyDescriptor;
    paramPropertyDescriptor = null;
    Object localObject2 = null;
    Object localObject4;
    if (bool)
    {
      localObject1 = (DeserializedPropertyDescriptor)localObject3;
      localObject2 = ((DeserializedPropertyDescriptor)localObject1).getProto();
      localObject4 = (GeneratedMessageLite.ExtendableMessage)localObject2;
      GeneratedMessageLite.GeneratedExtension localGeneratedExtension = JvmProtoBuf.propertySignature;
      Intrinsics.checkExpressionValueIsNotNull(localGeneratedExtension, "JvmProtoBuf.propertySignature");
      localObject4 = (JvmProtoBuf.JvmPropertySignature)ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage)localObject4, localGeneratedExtension);
      if (localObject4 != null) {
        return (JvmPropertySignature)new JvmPropertySignature.KotlinProperty((PropertyDescriptor)localObject3, (ProtoBuf.Property)localObject2, (JvmProtoBuf.JvmPropertySignature)localObject4, ((DeserializedPropertyDescriptor)localObject1).getNameResolver(), ((DeserializedPropertyDescriptor)localObject1).getTypeTable());
      }
    }
    else if ((localObject3 instanceof JavaPropertyDescriptor))
    {
      localObject1 = ((JavaPropertyDescriptor)localObject3).getSource();
      paramPropertyDescriptor = (PropertyDescriptor)localObject1;
      if (!(localObject1 instanceof JavaSourceElement)) {
        paramPropertyDescriptor = null;
      }
      paramPropertyDescriptor = (JavaSourceElement)paramPropertyDescriptor;
      if (paramPropertyDescriptor != null) {
        paramPropertyDescriptor = paramPropertyDescriptor.getJavaElement();
      } else {
        paramPropertyDescriptor = null;
      }
      if ((paramPropertyDescriptor instanceof ReflectJavaField)) {
        return (JvmPropertySignature)new JvmPropertySignature.JavaField(((ReflectJavaField)paramPropertyDescriptor).getMember());
      }
      if ((paramPropertyDescriptor instanceof ReflectJavaMethod))
      {
        localObject4 = ((ReflectJavaMethod)paramPropertyDescriptor).getMember();
        paramPropertyDescriptor = ((PropertyDescriptor)localObject3).getSetter();
        if (paramPropertyDescriptor != null) {
          paramPropertyDescriptor = paramPropertyDescriptor.getSource();
        } else {
          paramPropertyDescriptor = null;
        }
        localObject1 = paramPropertyDescriptor;
        if (!(paramPropertyDescriptor instanceof JavaSourceElement)) {
          localObject1 = null;
        }
        paramPropertyDescriptor = (JavaSourceElement)localObject1;
        if (paramPropertyDescriptor != null) {
          paramPropertyDescriptor = paramPropertyDescriptor.getJavaElement();
        } else {
          paramPropertyDescriptor = null;
        }
        localObject1 = paramPropertyDescriptor;
        if (!(paramPropertyDescriptor instanceof ReflectJavaMethod)) {
          localObject1 = null;
        }
        localObject1 = (ReflectJavaMethod)localObject1;
        paramPropertyDescriptor = (PropertyDescriptor)localObject2;
        if (localObject1 != null) {
          paramPropertyDescriptor = ((ReflectJavaMethod)localObject1).getMember();
        }
        return (JvmPropertySignature)new JvmPropertySignature.JavaMethodProperty((Method)localObject4, paramPropertyDescriptor);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Incorrect resolution sequence for Java field ");
      ((StringBuilder)localObject1).append(localObject3);
      ((StringBuilder)localObject1).append(" (source = ");
      ((StringBuilder)localObject1).append(paramPropertyDescriptor);
      ((StringBuilder)localObject1).append(')');
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
    }
    Object localObject1 = ((PropertyDescriptor)localObject3).getGetter();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = (FunctionDescriptor)localObject1;
    localObject1 = (RuntimeTypeMapper)this;
    localObject2 = ((RuntimeTypeMapper)localObject1).mapJvmFunctionSignature((FunctionDescriptor)localObject2);
    localObject3 = ((PropertyDescriptor)localObject3).getSetter();
    if (localObject3 != null) {
      paramPropertyDescriptor = ((RuntimeTypeMapper)localObject1).mapJvmFunctionSignature((FunctionDescriptor)localObject3);
    }
    return (JvmPropertySignature)new JvmPropertySignature.MappedKotlinProperty((JvmFunctionSignature.KotlinFunction)localObject2, paramPropertyDescriptor);
  }
  
  @NotNull
  public final JvmFunctionSignature mapSignature(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "possiblySubstitutedFunction");
    Object localObject1 = DescriptorUtils.unwrapFakeOverride((CallableMemberDescriptor)paramFunctionDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
    FunctionDescriptor localFunctionDescriptor = ((FunctionDescriptor)localObject1).getOriginal();
    Intrinsics.checkExpressionValueIsNotNull(localFunctionDescriptor, "DescriptorUtils.unwrapFa…titutedFunction).original");
    Object localObject2;
    if ((localFunctionDescriptor instanceof DeserializedCallableMemberDescriptor))
    {
      localObject1 = (DeserializedCallableMemberDescriptor)localFunctionDescriptor;
      localObject2 = ((DeserializedCallableMemberDescriptor)localObject1).getProto();
      if ((localObject2 instanceof ProtoBuf.Function))
      {
        JvmMemberSignature.Method localMethod = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function)localObject2, ((DeserializedCallableMemberDescriptor)localObject1).getNameResolver(), ((DeserializedCallableMemberDescriptor)localObject1).getTypeTable());
        if (localMethod != null) {
          return (JvmFunctionSignature)new JvmFunctionSignature.KotlinFunction(localMethod);
        }
      }
      if ((localObject2 instanceof ProtoBuf.Constructor))
      {
        localObject1 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor)localObject2, ((DeserializedCallableMemberDescriptor)localObject1).getNameResolver(), ((DeserializedCallableMemberDescriptor)localObject1).getTypeTable());
        if (localObject1 != null)
        {
          paramFunctionDescriptor = paramFunctionDescriptor.getContainingDeclaration();
          Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "possiblySubstitutedFunction.containingDeclaration");
          if (InlineClassesUtilsKt.isInlineClass(paramFunctionDescriptor)) {
            return (JvmFunctionSignature)new JvmFunctionSignature.KotlinFunction((JvmMemberSignature.Method)localObject1);
          }
          return (JvmFunctionSignature)new JvmFunctionSignature.KotlinConstructor((JvmMemberSignature.Method)localObject1);
        }
      }
      return (JvmFunctionSignature)mapJvmFunctionSignature(localFunctionDescriptor);
    }
    boolean bool = localFunctionDescriptor instanceof JavaMethodDescriptor;
    localObject1 = null;
    if (bool)
    {
      localObject1 = ((JavaMethodDescriptor)localFunctionDescriptor).getSource();
      paramFunctionDescriptor = (FunctionDescriptor)localObject1;
      if (!(localObject1 instanceof JavaSourceElement)) {
        paramFunctionDescriptor = null;
      }
      paramFunctionDescriptor = (JavaSourceElement)paramFunctionDescriptor;
      if (paramFunctionDescriptor != null) {
        paramFunctionDescriptor = paramFunctionDescriptor.getJavaElement();
      } else {
        paramFunctionDescriptor = null;
      }
      localObject1 = paramFunctionDescriptor;
      if (!(paramFunctionDescriptor instanceof ReflectJavaMethod)) {
        localObject1 = null;
      }
      paramFunctionDescriptor = (ReflectJavaMethod)localObject1;
      if (paramFunctionDescriptor != null)
      {
        paramFunctionDescriptor = paramFunctionDescriptor.getMember();
        if (paramFunctionDescriptor != null) {
          return (JvmFunctionSignature)new JvmFunctionSignature.JavaMethod(paramFunctionDescriptor);
        }
      }
      paramFunctionDescriptor = new StringBuilder();
      paramFunctionDescriptor.append("Incorrect resolution sequence for Java method ");
      paramFunctionDescriptor.append(localFunctionDescriptor);
      throw ((Throwable)new KotlinReflectionInternalError(paramFunctionDescriptor.toString()));
    }
    if ((localFunctionDescriptor instanceof JavaClassConstructorDescriptor))
    {
      localObject2 = ((JavaClassConstructorDescriptor)localFunctionDescriptor).getSource();
      paramFunctionDescriptor = (FunctionDescriptor)localObject2;
      if (!(localObject2 instanceof JavaSourceElement)) {
        paramFunctionDescriptor = null;
      }
      localObject2 = (JavaSourceElement)paramFunctionDescriptor;
      paramFunctionDescriptor = (FunctionDescriptor)localObject1;
      if (localObject2 != null) {
        paramFunctionDescriptor = ((JavaSourceElement)localObject2).getJavaElement();
      }
      if ((paramFunctionDescriptor instanceof ReflectJavaConstructor)) {
        return (JvmFunctionSignature)new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor)paramFunctionDescriptor).getMember());
      }
      if ((paramFunctionDescriptor instanceof ReflectJavaClass))
      {
        localObject1 = (ReflectJavaClass)paramFunctionDescriptor;
        if (((ReflectJavaClass)localObject1).isAnnotationType()) {
          return (JvmFunctionSignature)new JvmFunctionSignature.FakeJavaAnnotationConstructor(((ReflectJavaClass)localObject1).getElement());
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Incorrect resolution sequence for Java constructor ");
      ((StringBuilder)localObject1).append(localFunctionDescriptor);
      ((StringBuilder)localObject1).append(" (");
      ((StringBuilder)localObject1).append(paramFunctionDescriptor);
      ((StringBuilder)localObject1).append(')');
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
    }
    if (isKnownBuiltInFunction(localFunctionDescriptor)) {
      return (JvmFunctionSignature)mapJvmFunctionSignature(localFunctionDescriptor);
    }
    paramFunctionDescriptor = new StringBuilder();
    paramFunctionDescriptor.append("Unknown origin of ");
    paramFunctionDescriptor.append(localFunctionDescriptor);
    paramFunctionDescriptor.append(" (");
    paramFunctionDescriptor.append(localFunctionDescriptor.getClass());
    paramFunctionDescriptor.append(')');
    throw ((Throwable)new KotlinReflectionInternalError(paramFunctionDescriptor.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.RuntimeTypeMapper
 * JD-Core Version:    0.7.0.1
 */