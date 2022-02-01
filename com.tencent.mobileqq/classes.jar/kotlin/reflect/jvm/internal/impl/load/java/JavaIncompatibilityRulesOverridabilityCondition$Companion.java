package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class JavaIncompatibilityRulesOverridabilityCondition$Companion
{
  private final boolean isPrimitiveCompareTo(FunctionDescriptor paramFunctionDescriptor)
  {
    if (paramFunctionDescriptor.getValueParameters().size() != 1) {
      return false;
    }
    Object localObject2 = paramFunctionDescriptor.getContainingDeclaration();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ClassDescriptor)) {
      localObject1 = null;
    }
    localObject2 = (ClassDescriptor)localObject1;
    if (localObject2 != null)
    {
      paramFunctionDescriptor = paramFunctionDescriptor.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "f.valueParameters");
      paramFunctionDescriptor = CollectionsKt.single(paramFunctionDescriptor);
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "f.valueParameters.single()");
      localObject1 = ((ValueParameterDescriptor)paramFunctionDescriptor).getType().getConstructor().getDeclarationDescriptor();
      paramFunctionDescriptor = (FunctionDescriptor)localObject1;
      if (!(localObject1 instanceof ClassDescriptor)) {
        paramFunctionDescriptor = null;
      }
      paramFunctionDescriptor = (ClassDescriptor)paramFunctionDescriptor;
      if (paramFunctionDescriptor != null) {
        return (KotlinBuiltIns.isPrimitiveClass((ClassDescriptor)localObject2)) && (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)localObject2), DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)paramFunctionDescriptor)));
      }
    }
    return false;
  }
  
  private final JvmType mapValueParameterType(FunctionDescriptor paramFunctionDescriptor, ValueParameterDescriptor paramValueParameterDescriptor)
  {
    if ((!MethodSignatureMappingKt.forceSingleValueParameterBoxing((CallableDescriptor)paramFunctionDescriptor)) && (!((Companion)this).isPrimitiveCompareTo(paramFunctionDescriptor)))
    {
      paramFunctionDescriptor = paramValueParameterDescriptor.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "valueParameterDescriptor.type");
      return MethodSignatureMappingKt.mapToJvmType(paramFunctionDescriptor);
    }
    paramFunctionDescriptor = paramValueParameterDescriptor.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "valueParameterDescriptor.type");
    return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(paramFunctionDescriptor));
  }
  
  public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor1, "superDescriptor");
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor2, "subDescriptor");
    if ((paramCallableDescriptor2 instanceof JavaMethodDescriptor))
    {
      if (!(paramCallableDescriptor1 instanceof FunctionDescriptor)) {
        return false;
      }
      Object localObject1 = (JavaMethodDescriptor)paramCallableDescriptor2;
      int i = ((JavaMethodDescriptor)localObject1).getValueParameters().size();
      paramCallableDescriptor1 = (FunctionDescriptor)paramCallableDescriptor1;
      if (i == paramCallableDescriptor1.getValueParameters().size()) {
        i = 1;
      } else {
        i = 0;
      }
      if ((_Assertions.ENABLED) && (i == 0)) {
        throw ((Throwable)new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size"));
      }
      localObject1 = ((JavaMethodDescriptor)localObject1).getOriginal();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDescriptor.original");
      localObject1 = ((SimpleFunctionDescriptor)localObject1).getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDescriptor.original.valueParameters");
      localObject1 = (Iterable)localObject1;
      Object localObject2 = paramCallableDescriptor1.getOriginal();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "superDescriptor.original");
      localObject2 = ((FunctionDescriptor)localObject2).getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "superDescriptor.original.valueParameters");
      localObject1 = CollectionsKt.zip((Iterable)localObject1, (Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Pair)((Iterator)localObject1).next();
        localObject2 = (ValueParameterDescriptor)((Pair)localObject3).component1();
        localObject3 = (ValueParameterDescriptor)((Pair)localObject3).component2();
        Companion localCompanion = (Companion)this;
        FunctionDescriptor localFunctionDescriptor = (FunctionDescriptor)paramCallableDescriptor2;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "subParameter");
        boolean bool = localCompanion.mapValueParameterType(localFunctionDescriptor, (ValueParameterDescriptor)localObject2) instanceof JvmType.Primitive;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "superParameter");
        if (bool != localCompanion.mapValueParameterType(paramCallableDescriptor1, (ValueParameterDescriptor)localObject3) instanceof JvmType.Primitive) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion
 * JD-Core Version:    0.7.0.1
 */