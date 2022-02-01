package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PropertyAccessorDescriptorImpl
  extends DeclarationDescriptorNonRootImpl
  implements PropertyAccessorDescriptor
{
  private final PropertyDescriptor correspondingProperty;
  @Nullable
  private FunctionDescriptor initialSignatureDescriptor = null;
  private boolean isDefault;
  private final boolean isExternal;
  private final boolean isInline;
  private final CallableMemberDescriptor.Kind kind;
  private final Modality modality;
  private Visibility visibility;
  
  public PropertyAccessorDescriptorImpl(@NotNull Modality paramModality, @NotNull Visibility paramVisibility, @NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
  {
    super(paramPropertyDescriptor.getContainingDeclaration(), paramAnnotations, paramName, paramSourceElement);
    this.modality = paramModality;
    this.visibility = paramVisibility;
    this.correspondingProperty = paramPropertyDescriptor;
    this.isDefault = paramBoolean1;
    this.isExternal = paramBoolean2;
    this.isInline = paramBoolean3;
    this.kind = paramKind;
  }
  
  @NotNull
  public PropertyAccessorDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  @NotNull
  public PropertyDescriptor getCorrespondingProperty()
  {
    PropertyDescriptor localPropertyDescriptor = this.correspondingProperty;
    if (localPropertyDescriptor == null) {
      $$$reportNull$$$0(12);
    }
    return localPropertyDescriptor;
  }
  
  @Nullable
  public ReceiverParameterDescriptor getDispatchReceiverParameter()
  {
    return getCorrespondingProperty().getDispatchReceiverParameter();
  }
  
  @Nullable
  public ReceiverParameterDescriptor getExtensionReceiverParameter()
  {
    return getCorrespondingProperty().getExtensionReceiverParameter();
  }
  
  @Nullable
  public FunctionDescriptor getInitialSignatureDescriptor()
  {
    return this.initialSignatureDescriptor;
  }
  
  @NotNull
  public CallableMemberDescriptor.Kind getKind()
  {
    CallableMemberDescriptor.Kind localKind = this.kind;
    if (localKind == null) {
      $$$reportNull$$$0(6);
    }
    return localKind;
  }
  
  @NotNull
  public Modality getModality()
  {
    Modality localModality = this.modality;
    if (localModality == null) {
      $$$reportNull$$$0(9);
    }
    return localModality;
  }
  
  @NotNull
  public abstract PropertyAccessorDescriptor getOriginal();
  
  @NotNull
  protected Collection<PropertyAccessorDescriptor> getOverriddenDescriptors(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = getCorrespondingProperty().getOverriddenDescriptors().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (PropertyDescriptor)localIterator.next();
      if (paramBoolean) {
        localObject = ((PropertyDescriptor)localObject).getGetter();
      } else {
        localObject = ((PropertyDescriptor)localObject).getSetter();
      }
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getTypeParameters()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(8);
    }
    return localList;
  }
  
  @Nullable
  public <V> V getUserData(CallableDescriptor.UserDataKey<V> paramUserDataKey)
  {
    return null;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = this.visibility;
    if (localVisibility == null) {
      $$$reportNull$$$0(10);
    }
    return localVisibility;
  }
  
  public boolean hasSynthesizedParameterNames()
  {
    return false;
  }
  
  public boolean isActual()
  {
    return false;
  }
  
  public boolean isDefault()
  {
    return this.isDefault;
  }
  
  public boolean isExpect()
  {
    return false;
  }
  
  public boolean isExternal()
  {
    return this.isExternal;
  }
  
  public boolean isHiddenForResolutionEverywhereBesideSupercalls()
  {
    return false;
  }
  
  public boolean isHiddenToOvercomeSignatureClash()
  {
    return false;
  }
  
  public boolean isInfix()
  {
    return false;
  }
  
  public boolean isInline()
  {
    return this.isInline;
  }
  
  public boolean isOperator()
  {
    return false;
  }
  
  public boolean isSuspend()
  {
    return false;
  }
  
  public boolean isTailrec()
  {
    return false;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public void setDefault(boolean paramBoolean)
  {
    this.isDefault = paramBoolean;
  }
  
  public void setInitialSignatureDescriptor(@Nullable FunctionDescriptor paramFunctionDescriptor)
  {
    this.initialSignatureDescriptor = paramFunctionDescriptor;
  }
  
  public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(14);
    }
  }
  
  public void setVisibility(Visibility paramVisibility)
  {
    this.visibility = paramVisibility;
  }
  
  @NotNull
  public FunctionDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(7);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */