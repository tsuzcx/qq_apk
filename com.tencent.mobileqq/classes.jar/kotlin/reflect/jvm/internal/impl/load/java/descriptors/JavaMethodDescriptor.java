package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaMethodDescriptor
  extends SimpleFunctionDescriptorImpl
  implements JavaCallableMemberDescriptor
{
  public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new JavaMethodDescriptor.1();
  private JavaMethodDescriptor.ParameterNamesStatus parameterNamesStatus = null;
  
  protected JavaMethodDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable SimpleFunctionDescriptor paramSimpleFunctionDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
  {
    super(paramDeclarationDescriptor, paramSimpleFunctionDescriptor, paramAnnotations, paramName, paramKind, paramSourceElement);
  }
  
  @NotNull
  public static JavaMethodDescriptor createJavaMethod(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(6);
    }
    if (paramName == null) {
      $$$reportNull$$$0(7);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(8);
    }
    return new JavaMethodDescriptor(paramDeclarationDescriptor, null, paramAnnotations, paramName, CallableMemberDescriptor.Kind.DECLARATION, paramSourceElement);
  }
  
  @NotNull
  protected JavaMethodDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(14);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(15);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(16);
    }
    paramFunctionDescriptor = (SimpleFunctionDescriptor)paramFunctionDescriptor;
    if (paramName == null) {
      paramName = getName();
    }
    paramDeclarationDescriptor = new JavaMethodDescriptor(paramDeclarationDescriptor, paramFunctionDescriptor, paramAnnotations, paramName, paramKind, paramSourceElement);
    paramDeclarationDescriptor.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public JavaMethodDescriptor enhance(@Nullable KotlinType paramKotlinType1, @NotNull List<ValueParameterData> paramList, @NotNull KotlinType paramKotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> paramPair)
  {
    if (paramList == null) {
      $$$reportNull$$$0(18);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(19);
    }
    paramList = UtilKt.copyValueParameters(paramList, getValueParameters(), this);
    if (paramKotlinType1 == null) {
      paramKotlinType1 = null;
    } else {
      paramKotlinType1 = DescriptorFactory.createExtensionReceiverParameterForCallable(this, paramKotlinType1, Annotations.Companion.getEMPTY());
    }
    paramKotlinType1 = (JavaMethodDescriptor)newCopyBuilder().setValueParameters(paramList).setReturnType(paramKotlinType2).setExtensionReceiverParameter(paramKotlinType1).setDropOriginalInContainingParts().setPreserveSourceElement().build();
    if (paramPair != null) {
      paramKotlinType1.putInUserDataMap((CallableDescriptor.UserDataKey)paramPair.getFirst(), paramPair.getSecond());
    }
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(20);
    }
    return paramKotlinType1;
  }
  
  public boolean hasStableParameterNames()
  {
    return this.parameterNamesStatus.isStable;
  }
  
  public boolean hasSynthesizedParameterNames()
  {
    return this.parameterNamesStatus.isSynthesized;
  }
  
  @NotNull
  public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor1, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull List<ValueParameterDescriptor> paramList1, @Nullable KotlinType paramKotlinType, @Nullable Modality paramModality, @NotNull Visibility paramVisibility, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> paramMap)
  {
    if (paramList == null) {
      $$$reportNull$$$0(9);
    }
    if (paramList1 == null) {
      $$$reportNull$$$0(10);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(11);
    }
    paramReceiverParameterDescriptor1 = super.initialize(paramReceiverParameterDescriptor1, paramReceiverParameterDescriptor2, paramList, paramList1, paramKotlinType, paramModality, paramVisibility, paramMap);
    setOperator(OperatorChecks.INSTANCE.check(paramReceiverParameterDescriptor1).isSuccess());
    if (paramReceiverParameterDescriptor1 == null) {
      $$$reportNull$$$0(12);
    }
    return paramReceiverParameterDescriptor1;
  }
  
  public void setParameterNamesStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.parameterNamesStatus = JavaMethodDescriptor.ParameterNamesStatus.get(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
 * JD-Core Version:    0.7.0.1
 */