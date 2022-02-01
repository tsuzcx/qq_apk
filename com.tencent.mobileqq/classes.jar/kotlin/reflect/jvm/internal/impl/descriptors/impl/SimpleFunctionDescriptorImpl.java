package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleFunctionDescriptorImpl
  extends FunctionDescriptorImpl
  implements SimpleFunctionDescriptor
{
  protected SimpleFunctionDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable SimpleFunctionDescriptor paramSimpleFunctionDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
  {
    super(paramDeclarationDescriptor, paramSimpleFunctionDescriptor, paramAnnotations, paramName, paramKind, paramSourceElement);
  }
  
  @NotNull
  public static SimpleFunctionDescriptorImpl create(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
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
    if (paramKind == null) {
      $$$reportNull$$$0(8);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(9);
    }
    return new SimpleFunctionDescriptorImpl(paramDeclarationDescriptor, null, paramAnnotations, paramName, paramKind, paramSourceElement);
  }
  
  @NotNull
  public SimpleFunctionDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    paramDeclarationDescriptor = (SimpleFunctionDescriptor)super.copy(paramDeclarationDescriptor, paramModality, paramVisibility, paramKind, paramBoolean);
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(23);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(19);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(20);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(21);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(22);
    }
    paramFunctionDescriptor = (SimpleFunctionDescriptor)paramFunctionDescriptor;
    if (paramName == null) {
      paramName = getName();
    }
    return new SimpleFunctionDescriptorImpl(paramDeclarationDescriptor, paramFunctionDescriptor, paramAnnotations, paramName, paramKind, paramSourceElement);
  }
  
  @NotNull
  public SimpleFunctionDescriptor getOriginal()
  {
    SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)super.getOriginal();
    if (localSimpleFunctionDescriptor == null) {
      $$$reportNull$$$0(18);
    }
    return localSimpleFunctionDescriptor;
  }
  
  @NotNull
  public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor1, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull List<ValueParameterDescriptor> paramList1, @Nullable KotlinType paramKotlinType, @Nullable Modality paramModality, @NotNull Visibility paramVisibility)
  {
    if (paramList == null) {
      $$$reportNull$$$0(10);
    }
    if (paramList1 == null) {
      $$$reportNull$$$0(11);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(12);
    }
    paramReceiverParameterDescriptor1 = initialize(paramReceiverParameterDescriptor1, paramReceiverParameterDescriptor2, paramList, paramList1, paramKotlinType, paramModality, paramVisibility, null);
    if (paramReceiverParameterDescriptor1 == null) {
      $$$reportNull$$$0(13);
    }
    return paramReceiverParameterDescriptor1;
  }
  
  @NotNull
  public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor1, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull List<ValueParameterDescriptor> paramList1, @Nullable KotlinType paramKotlinType, @Nullable Modality paramModality, @NotNull Visibility paramVisibility, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> paramMap)
  {
    if (paramList == null) {
      $$$reportNull$$$0(14);
    }
    if (paramList1 == null) {
      $$$reportNull$$$0(15);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(16);
    }
    super.initialize(paramReceiverParameterDescriptor1, paramReceiverParameterDescriptor2, paramList, paramList1, paramKotlinType, paramModality, paramVisibility);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.userDataMap = new LinkedHashMap(paramMap);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder()
  {
    FunctionDescriptor.CopyBuilder localCopyBuilder = super.newCopyBuilder();
    if (localCopyBuilder == null) {
      $$$reportNull$$$0(24);
    }
    return localCopyBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */