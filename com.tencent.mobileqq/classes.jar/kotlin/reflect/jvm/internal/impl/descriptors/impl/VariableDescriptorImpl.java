package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class VariableDescriptorImpl
  extends DeclarationDescriptorNonRootImpl
  implements VariableDescriptor
{
  protected KotlinType outType;
  
  public VariableDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @Nullable KotlinType paramKotlinType, @NotNull SourceElement paramSourceElement)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, paramSourceElement);
    this.outType = paramKotlinType;
  }
  
  public ReceiverParameterDescriptor getDispatchReceiverParameter()
  {
    return null;
  }
  
  public ReceiverParameterDescriptor getExtensionReceiverParameter()
  {
    return null;
  }
  
  @NotNull
  public VariableDescriptor getOriginal()
  {
    VariableDescriptor localVariableDescriptor = (VariableDescriptor)super.getOriginal();
    if (localVariableDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    return localVariableDescriptor;
  }
  
  @NotNull
  public Collection<? extends CallableDescriptor> getOverriddenDescriptors()
  {
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      $$$reportNull$$$0(7);
    }
    return localSet;
  }
  
  @NotNull
  public KotlinType getReturnType()
  {
    KotlinType localKotlinType = getType();
    if (localKotlinType == null) {
      $$$reportNull$$$0(9);
    }
    return localKotlinType;
  }
  
  @NotNull
  public KotlinType getType()
  {
    KotlinType localKotlinType = this.outType;
    if (localKotlinType == null) {
      $$$reportNull$$$0(4);
    }
    return localKotlinType;
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
  public List<ValueParameterDescriptor> getValueParameters()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(6);
    }
    return localList;
  }
  
  public boolean hasSynthesizedParameterNames()
  {
    return false;
  }
  
  public boolean isConst()
  {
    return false;
  }
  
  public void setOutType(KotlinType paramKotlinType)
  {
    this.outType = paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */