package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MethodSignatureMappingKt
{
  private static final void appendErasedType(@NotNull StringBuilder paramStringBuilder, KotlinType paramKotlinType)
  {
    paramStringBuilder.append(mapToJvmType(paramKotlinType));
  }
  
  @NotNull
  public static final String computeJvmDescriptor(@NotNull FunctionDescriptor paramFunctionDescriptor, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "$this$computeJvmDescriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean2)
    {
      if ((paramFunctionDescriptor instanceof ConstructorDescriptor))
      {
        localObject1 = "<init>";
      }
      else
      {
        localObject1 = paramFunctionDescriptor.getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "name.asString()");
      }
      localStringBuilder.append((String)localObject1);
    }
    localStringBuilder.append("(");
    Object localObject1 = paramFunctionDescriptor.getValueParameters().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ValueParameterDescriptor)((Iterator)localObject1).next();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "parameter");
      localObject2 = ((ValueParameterDescriptor)localObject2).getType();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "parameter.type");
      appendErasedType(localStringBuilder, (KotlinType)localObject2);
    }
    localStringBuilder.append(")");
    if (paramBoolean1) {
      if (TypeSignatureMappingKt.hasVoidReturnType((CallableDescriptor)paramFunctionDescriptor))
      {
        localStringBuilder.append("V");
      }
      else
      {
        paramFunctionDescriptor = paramFunctionDescriptor.getReturnType();
        if (paramFunctionDescriptor == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "returnType!!");
        appendErasedType(localStringBuilder, paramFunctionDescriptor);
      }
    }
    paramFunctionDescriptor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramFunctionDescriptor;
  }
  
  @Nullable
  public static final String computeJvmSignature(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "$this$computeJvmSignature");
    SignatureBuildingComponents localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    if (DescriptorUtils.isLocal((DeclarationDescriptor)paramCallableDescriptor)) {
      return null;
    }
    Object localObject2 = paramCallableDescriptor.getContainingDeclaration();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ClassDescriptor)) {
      localObject1 = null;
    }
    localObject2 = (ClassDescriptor)localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((ClassDescriptor)localObject2).getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "classDescriptor.name");
      if (((Name)localObject1).isSpecial()) {
        return null;
      }
      localObject1 = paramCallableDescriptor.getOriginal();
      paramCallableDescriptor = (CallableDescriptor)localObject1;
      if (!(localObject1 instanceof SimpleFunctionDescriptor)) {
        paramCallableDescriptor = null;
      }
      paramCallableDescriptor = (SimpleFunctionDescriptor)paramCallableDescriptor;
      if (paramCallableDescriptor != null) {
        return localSignatureBuildingComponents.signature((ClassDescriptor)localObject2, computeJvmDescriptor$default((FunctionDescriptor)paramCallableDescriptor, false, false, 3, null));
      }
    }
    return null;
  }
  
  public static final boolean forceSingleValueParameterBoxing(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "f");
    boolean bool1 = paramCallableDescriptor instanceof FunctionDescriptor;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    FunctionDescriptor localFunctionDescriptor = (FunctionDescriptor)paramCallableDescriptor;
    bool1 = bool2;
    if (localFunctionDescriptor.getValueParameters().size() == 1)
    {
      bool1 = bool2;
      if (!SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor)paramCallableDescriptor))
      {
        if ((Intrinsics.areEqual(localFunctionDescriptor.getName().asString(), "remove") ^ true)) {
          return false;
        }
        paramCallableDescriptor = localFunctionDescriptor.getOriginal();
        Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "f.original");
        paramCallableDescriptor = paramCallableDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "f.original.valueParameters");
        paramCallableDescriptor = CollectionsKt.single(paramCallableDescriptor);
        Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "f.original.valueParameters.single()");
        paramCallableDescriptor = ((ValueParameterDescriptor)paramCallableDescriptor).getType();
        Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "f.original.valueParameters.single().type");
        paramCallableDescriptor = mapToJvmType(paramCallableDescriptor);
        bool1 = paramCallableDescriptor instanceof JvmType.Primitive;
        Object localObject = null;
        if (!bool1) {
          paramCallableDescriptor = null;
        }
        JvmType.Primitive localPrimitive = (JvmType.Primitive)paramCallableDescriptor;
        paramCallableDescriptor = (CallableDescriptor)localObject;
        if (localPrimitive != null) {
          paramCallableDescriptor = localPrimitive.getJvmPrimitiveType();
        }
        if (paramCallableDescriptor != JvmPrimitiveType.INT) {
          return false;
        }
        paramCallableDescriptor = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(localFunctionDescriptor);
        bool1 = bool2;
        if (paramCallableDescriptor != null)
        {
          localObject = paramCallableDescriptor.getOriginal();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "overridden.original");
          localObject = ((FunctionDescriptor)localObject).getValueParameters();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "overridden.original.valueParameters");
          localObject = CollectionsKt.single((List)localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "overridden.original.valueParameters.single()");
          localObject = ((ValueParameterDescriptor)localObject).getType();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "overridden.original.valueParameters.single().type");
          localObject = mapToJvmType((KotlinType)localObject);
          paramCallableDescriptor = paramCallableDescriptor.getContainingDeclaration();
          Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "overridden.containingDeclaration");
          bool1 = bool2;
          if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(paramCallableDescriptor), KotlinBuiltIns.FQ_NAMES.mutableCollection.toUnsafe()))
          {
            bool1 = bool2;
            if ((localObject instanceof JvmType.Object))
            {
              bool1 = bool2;
              if (Intrinsics.areEqual(((JvmType.Object)localObject).getInternalName(), "java/lang/Object")) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  @NotNull
  public static final String getInternalName(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$internalName");
    Object localObject = JavaToKotlinClassMap.INSTANCE;
    FqNameUnsafe localFqNameUnsafe = DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)paramClassDescriptor).toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(localFqNameUnsafe, "fqNameSafe.toUnsafe()");
    localObject = ((JavaToKotlinClassMap)localObject).mapKotlinToJava(localFqNameUnsafe);
    if (localObject != null)
    {
      paramClassDescriptor = JvmClassName.byClassId((ClassId)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "JvmClassName.byClassId(it)");
      paramClassDescriptor = paramClassDescriptor.getInternalName();
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "JvmClassName.byClassId(it).internalName");
      return paramClassDescriptor;
    }
    return TypeSignatureMappingKt.computeInternalName$default(paramClassDescriptor, null, 2, null);
  }
  
  @NotNull
  public static final JvmType mapToJvmType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$mapToJvmType");
    return (JvmType)TypeSignatureMappingKt.mapType$default(paramKotlinType, (JvmTypeFactory)JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, (TypeMappingConfiguration)TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt
 * JD-Core Version:    0.7.0.1
 */