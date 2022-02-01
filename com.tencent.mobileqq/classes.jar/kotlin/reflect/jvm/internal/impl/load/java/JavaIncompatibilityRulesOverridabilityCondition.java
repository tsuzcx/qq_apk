package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaIncompatibilityRulesOverridabilityCondition
  implements ExternalOverridabilityCondition
{
  public static final JavaIncompatibilityRulesOverridabilityCondition.Companion Companion = new JavaIncompatibilityRulesOverridabilityCondition.Companion(null);
  
  private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor paramCallableDescriptor1, CallableDescriptor paramCallableDescriptor2, ClassDescriptor paramClassDescriptor)
  {
    if (((paramCallableDescriptor1 instanceof CallableMemberDescriptor)) && ((paramCallableDescriptor2 instanceof FunctionDescriptor)))
    {
      if (KotlinBuiltIns.isBuiltIn((DeclarationDescriptor)paramCallableDescriptor2)) {
        return false;
      }
      Object localObject = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
      FunctionDescriptor localFunctionDescriptor = (FunctionDescriptor)paramCallableDescriptor2;
      paramCallableDescriptor2 = localFunctionDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor2, "subDescriptor.name");
      if (!((BuiltinMethodsWithSpecialGenericSignature)localObject).getSameAsBuiltinMethodWithErasedValueParameters(paramCallableDescriptor2))
      {
        paramCallableDescriptor2 = BuiltinMethodsWithDifferentJvmName.INSTANCE;
        localObject = localFunctionDescriptor.getName();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "subDescriptor.name");
        if (!paramCallableDescriptor2.getSameAsRenamedInJvmBuiltin((Name)localObject)) {
          return false;
        }
      }
      localObject = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor)paramCallableDescriptor1);
      boolean bool1 = localFunctionDescriptor.isHiddenToOvercomeSignatureClash();
      boolean bool2 = paramCallableDescriptor1 instanceof FunctionDescriptor;
      if (!bool2) {
        paramCallableDescriptor2 = null;
      } else {
        paramCallableDescriptor2 = paramCallableDescriptor1;
      }
      paramCallableDescriptor2 = (FunctionDescriptor)paramCallableDescriptor2;
      int i;
      if ((paramCallableDescriptor2 != null) && (bool1 == paramCallableDescriptor2.isHiddenToOvercomeSignatureClash())) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i != 0) && ((localObject == null) || (!localFunctionDescriptor.isHiddenToOvercomeSignatureClash()))) {
        return true;
      }
      if ((paramClassDescriptor instanceof JavaClassDescriptor))
      {
        if (localFunctionDescriptor.getInitialSignatureDescriptor() != null) {
          return false;
        }
        if (localObject != null)
        {
          if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(paramClassDescriptor, (CallableDescriptor)localObject)) {
            return false;
          }
          if (((localObject instanceof FunctionDescriptor)) && (bool2) && (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)localObject) != null))
          {
            paramCallableDescriptor2 = MethodSignatureMappingKt.computeJvmDescriptor$default(localFunctionDescriptor, false, false, 2, null);
            paramCallableDescriptor1 = ((FunctionDescriptor)paramCallableDescriptor1).getOriginal();
            Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor1, "superDescriptor.original");
            if (Intrinsics.areEqual(paramCallableDescriptor2, MethodSignatureMappingKt.computeJvmDescriptor$default(paramCallableDescriptor1, false, false, 2, null))) {
              return false;
            }
          }
          return true;
        }
      }
    }
    return false;
  }
  
  @NotNull
  public ExternalOverridabilityCondition.Contract getContract()
  {
    return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
  }
  
  @NotNull
  public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, @Nullable ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor1, "superDescriptor");
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor2, "subDescriptor");
    if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(paramCallableDescriptor1, paramCallableDescriptor2, paramClassDescriptor)) {
      return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    }
    if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(paramCallableDescriptor1, paramCallableDescriptor2)) {
      return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    }
    return ExternalOverridabilityCondition.Result.UNKNOWN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition
 * JD-Core Version:    0.7.0.1
 */