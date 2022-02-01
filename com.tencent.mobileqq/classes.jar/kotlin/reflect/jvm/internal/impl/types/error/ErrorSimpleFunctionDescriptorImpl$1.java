package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ErrorSimpleFunctionDescriptorImpl$1
  implements FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor>
{
  ErrorSimpleFunctionDescriptorImpl$1(ErrorSimpleFunctionDescriptorImpl paramErrorSimpleFunctionDescriptorImpl) {}
  
  @Nullable
  public SimpleFunctionDescriptor build()
  {
    return this.this$0;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations paramAnnotations)
  {
    if (paramAnnotations == null) {
      $$$reportNull$$$0(29);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean paramBoolean)
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor)
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDropOriginalInContainingParts()
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor)
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls()
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash()
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind paramKind)
  {
    if (paramKind == null) {
      $$$reportNull$$$0(6);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setModality(@NotNull Modality paramModality)
  {
    if (paramModality == null) {
      $$$reportNull$$$0(2);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setName(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(9);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOriginal(@Nullable CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOwner(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement()
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setReturnType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(19);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSignatureChange()
  {
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSubstitution(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(13);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(@NotNull List<TypeParameterDescriptor> paramList)
  {
    if (paramList == null) {
      $$$reportNull$$$0(17);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setValueParameters(@NotNull List<ValueParameterDescriptor> paramList)
  {
    if (paramList == null) {
      $$$reportNull$$$0(11);
    }
    return this;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setVisibility(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(4);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl.1
 * JD-Core Version:    0.7.0.1
 */