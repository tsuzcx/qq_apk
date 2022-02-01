package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FunctionDescriptorImpl$CopyConfiguration
  implements FunctionDescriptor.CopyBuilder<FunctionDescriptor>
{
  private Annotations additionalAnnotations = null;
  protected boolean copyOverrides = true;
  @Nullable
  protected ReceiverParameterDescriptor dispatchReceiverParameter = FunctionDescriptorImpl.access$000(this.this$0);
  protected boolean dropOriginalInContainingParts = false;
  private boolean isHiddenForResolutionEverywhereBesideSupercalls = this.this$0.isHiddenForResolutionEverywhereBesideSupercalls();
  private boolean isHiddenToOvercomeSignatureClash = this.this$0.isHiddenToOvercomeSignatureClash();
  protected boolean justForTypeSubstitution = false;
  @NotNull
  protected CallableMemberDescriptor.Kind kind;
  @Nullable
  protected Name name;
  @Nullable
  protected ReceiverParameterDescriptor newExtensionReceiverParameter;
  private Boolean newHasSynthesizedParameterNames = null;
  @NotNull
  protected Modality newModality;
  @NotNull
  protected DeclarationDescriptor newOwner;
  @NotNull
  protected KotlinType newReturnType;
  private List<TypeParameterDescriptor> newTypeParameters = null;
  @NotNull
  protected List<ValueParameterDescriptor> newValueParameterDescriptors;
  @NotNull
  protected Visibility newVisibility;
  @Nullable
  protected FunctionDescriptor original = null;
  protected boolean preserveSourceElement = false;
  protected boolean signatureChange = false;
  @NotNull
  protected TypeSubstitution substitution;
  private Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap = new LinkedHashMap();
  
  public FunctionDescriptorImpl$CopyConfiguration(TypeSubstitution paramTypeSubstitution, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull List<ValueParameterDescriptor> paramList, @NotNull ReceiverParameterDescriptor paramReceiverParameterDescriptor, @Nullable KotlinType paramKotlinType, @NotNull Name paramName)
  {
    this.substitution = paramDeclarationDescriptor;
    this.newOwner = paramModality;
    this.newModality = paramVisibility;
    this.newVisibility = paramKind;
    this.kind = paramList;
    this.newValueParameterDescriptors = paramReceiverParameterDescriptor;
    this.newExtensionReceiverParameter = paramKotlinType;
    this.newReturnType = paramName;
    Object localObject;
    this.name = localObject;
  }
  
  @Nullable
  public FunctionDescriptor build()
  {
    return this.this$0.doSubstitute(this);
  }
  
  @NotNull
  public CopyConfiguration setAdditionalAnnotations(@NotNull Annotations paramAnnotations)
  {
    if (paramAnnotations == null) {
      $$$reportNull$$$0(32);
    }
    this.additionalAnnotations = paramAnnotations;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setCopyOverrides(boolean paramBoolean)
  {
    this.copyOverrides = paramBoolean;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor)
  {
    this.dispatchReceiverParameter = paramReceiverParameterDescriptor;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setDropOriginalInContainingParts()
  {
    this.dropOriginalInContainingParts = true;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor)
  {
    this.newExtensionReceiverParameter = paramReceiverParameterDescriptor;
    return this;
  }
  
  public CopyConfiguration setHasSynthesizedParameterNames(boolean paramBoolean)
  {
    this.newHasSynthesizedParameterNames = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  @NotNull
  public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls()
  {
    this.isHiddenForResolutionEverywhereBesideSupercalls = true;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setHiddenToOvercomeSignatureClash()
  {
    this.isHiddenToOvercomeSignatureClash = true;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setJustForTypeSubstitution(boolean paramBoolean)
  {
    this.justForTypeSubstitution = paramBoolean;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind paramKind)
  {
    if (paramKind == null) {
      $$$reportNull$$$0(13);
    }
    this.kind = paramKind;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setModality(@NotNull Modality paramModality)
  {
    if (paramModality == null) {
      $$$reportNull$$$0(9);
    }
    this.newModality = paramModality;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setName(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(16);
    }
    this.name = paramName;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    this.original = ((FunctionDescriptor)paramCallableMemberDescriptor);
    return this;
  }
  
  @NotNull
  public CopyConfiguration setOwner(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    this.newOwner = paramDeclarationDescriptor;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setPreserveSourceElement()
  {
    this.preserveSourceElement = true;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setReturnType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(22);
    }
    this.newReturnType = paramKotlinType;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setSignatureChange()
  {
    this.signatureChange = true;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setSubstitution(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(34);
    }
    this.substitution = paramTypeSubstitution;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setTypeParameters(@NotNull List<TypeParameterDescriptor> paramList)
  {
    if (paramList == null) {
      $$$reportNull$$$0(20);
    }
    this.newTypeParameters = paramList;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setValueParameters(@NotNull List<ValueParameterDescriptor> paramList)
  {
    if (paramList == null) {
      $$$reportNull$$$0(18);
    }
    this.newValueParameterDescriptors = paramList;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setVisibility(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(11);
    }
    this.newVisibility = paramVisibility;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration
 * JD-Core Version:    0.7.0.1
 */