package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;

public class ReceiverParameterDescriptorImpl
  extends AbstractReceiverParameterDescriptor
{
  private final DeclarationDescriptor containingDeclaration;
  private final ReceiverValue value;
  
  public ReceiverParameterDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull ReceiverValue paramReceiverValue, @NotNull Annotations paramAnnotations)
  {
    super(paramAnnotations);
    this.containingDeclaration = paramDeclarationDescriptor;
    this.value = paramReceiverValue;
  }
  
  @NotNull
  public DeclarationDescriptor getContainingDeclaration()
  {
    DeclarationDescriptor localDeclarationDescriptor = this.containingDeclaration;
    if (localDeclarationDescriptor == null) {
      $$$reportNull$$$0(4);
    }
    return localDeclarationDescriptor;
  }
  
  @NotNull
  public ReceiverValue getValue()
  {
    ReceiverValue localReceiverValue = this.value;
    if (localReceiverValue == null) {
      $$$reportNull$$$0(3);
    }
    return localReceiverValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */