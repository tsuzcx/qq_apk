package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassConstructorDescriptorImpl
  extends FunctionDescriptorImpl
  implements ClassConstructorDescriptor
{
  private static final Name NAME = Name.special("<init>");
  protected final boolean isPrimary;
  
  protected ClassConstructorDescriptorImpl(@NotNull ClassDescriptor paramClassDescriptor, @Nullable ConstructorDescriptor paramConstructorDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
  {
    super(paramClassDescriptor, paramConstructorDescriptor, paramAnnotations, NAME, paramKind, paramSourceElement);
    this.isPrimary = paramBoolean;
  }
  
  @NotNull
  public static ClassConstructorDescriptorImpl create(@NotNull ClassDescriptor paramClassDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull SourceElement paramSourceElement)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(4);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(5);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(6);
    }
    return new ClassConstructorDescriptorImpl(paramClassDescriptor, null, paramAnnotations, paramBoolean, CallableMemberDescriptor.Kind.DECLARATION, paramSourceElement);
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitConstructorDescriptor(this, paramD);
  }
  
  @Nullable
  public ReceiverParameterDescriptor calculateDispatchReceiverParameter()
  {
    Object localObject = getContainingDeclaration();
    if (((ClassDescriptor)localObject).isInner())
    {
      localObject = ((ClassDescriptor)localObject).getContainingDeclaration();
      if ((localObject instanceof ClassDescriptor)) {
        return ((ClassDescriptor)localObject).getThisAsReceiverParameter();
      }
    }
    return null;
  }
  
  @NotNull
  public ClassConstructorDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    paramDeclarationDescriptor = (ClassConstructorDescriptor)super.copy(paramDeclarationDescriptor, paramModality, paramVisibility, paramKind, paramBoolean);
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(25);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  protected ClassConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(21);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(22);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(23);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(24);
    }
    if ((paramKind != CallableMemberDescriptor.Kind.DECLARATION) && (paramKind != CallableMemberDescriptor.Kind.SYNTHESIZED))
    {
      paramFunctionDescriptor = new StringBuilder();
      paramFunctionDescriptor.append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
      paramFunctionDescriptor.append(this);
      paramFunctionDescriptor.append("\n");
      paramFunctionDescriptor.append("newOwner: ");
      paramFunctionDescriptor.append(paramDeclarationDescriptor);
      paramFunctionDescriptor.append("\n");
      paramFunctionDescriptor.append("kind: ");
      paramFunctionDescriptor.append(paramKind);
      throw new IllegalStateException(paramFunctionDescriptor.toString());
    }
    return new ClassConstructorDescriptorImpl((ClassDescriptor)paramDeclarationDescriptor, this, paramAnnotations, this.isPrimary, CallableMemberDescriptor.Kind.DECLARATION, paramSourceElement);
  }
  
  @NotNull
  public ClassDescriptor getConstructedClass()
  {
    ClassDescriptor localClassDescriptor = getContainingDeclaration();
    if (localClassDescriptor == null) {
      $$$reportNull$$$0(16);
    }
    return localClassDescriptor;
  }
  
  @NotNull
  public ClassDescriptor getContainingDeclaration()
  {
    ClassDescriptor localClassDescriptor = (ClassDescriptor)super.getContainingDeclaration();
    if (localClassDescriptor == null) {
      $$$reportNull$$$0(15);
    }
    return localClassDescriptor;
  }
  
  @NotNull
  public ClassConstructorDescriptor getOriginal()
  {
    ClassConstructorDescriptor localClassConstructorDescriptor = (ClassConstructorDescriptor)super.getOriginal();
    if (localClassConstructorDescriptor == null) {
      $$$reportNull$$$0(17);
    }
    return localClassConstructorDescriptor;
  }
  
  @NotNull
  public Collection<? extends FunctionDescriptor> getOverriddenDescriptors()
  {
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      $$$reportNull$$$0(19);
    }
    return localSet;
  }
  
  public ClassConstructorDescriptorImpl initialize(@NotNull List<ValueParameterDescriptor> paramList, @NotNull Visibility paramVisibility)
  {
    if (paramList == null) {
      $$$reportNull$$$0(13);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(14);
    }
    initialize(paramList, paramVisibility, getContainingDeclaration().getDeclaredTypeParameters());
    return this;
  }
  
  public ClassConstructorDescriptorImpl initialize(@NotNull List<ValueParameterDescriptor> paramList, @NotNull Visibility paramVisibility, @NotNull List<TypeParameterDescriptor> paramList1)
  {
    if (paramList == null) {
      $$$reportNull$$$0(10);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(11);
    }
    if (paramList1 == null) {
      $$$reportNull$$$0(12);
    }
    super.initialize(null, calculateDispatchReceiverParameter(), paramList1, paramList, null, Modality.FINAL, paramVisibility);
    return this;
  }
  
  public boolean isPrimary()
  {
    return this.isPrimary;
  }
  
  public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(20);
    }
  }
  
  @Nullable
  public ClassConstructorDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(18);
    }
    return (ClassConstructorDescriptor)super.substitute(paramTypeSubstitutor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */