package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PropertyGetterDescriptorImpl
  extends PropertyAccessorDescriptorImpl
  implements PropertyGetterDescriptor
{
  @NotNull
  private final PropertyGetterDescriptor original;
  private KotlinType returnType;
  
  public PropertyGetterDescriptorImpl(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable PropertyGetterDescriptor paramPropertyGetterDescriptor, @NotNull SourceElement paramSourceElement)
  {
    super(paramModality, paramVisibility, paramPropertyDescriptor, paramAnnotations, Name.special(localStringBuilder.toString()), paramBoolean1, paramBoolean2, paramBoolean3, paramKind, paramSourceElement);
    if (paramPropertyGetterDescriptor != null) {
      paramPropertyDescriptor = paramPropertyGetterDescriptor;
    } else {
      paramPropertyDescriptor = this;
    }
    this.original = paramPropertyDescriptor;
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitPropertyGetterDescriptor(this, paramD);
  }
  
  @NotNull
  public PropertyGetterDescriptor getOriginal()
  {
    PropertyGetterDescriptor localPropertyGetterDescriptor = this.original;
    if (localPropertyGetterDescriptor == null) {
      $$$reportNull$$$0(8);
    }
    return localPropertyGetterDescriptor;
  }
  
  @NotNull
  public Collection<? extends PropertyGetterDescriptor> getOverriddenDescriptors()
  {
    Collection localCollection = super.getOverriddenDescriptors(true);
    if (localCollection == null) {
      $$$reportNull$$$0(6);
    }
    return localCollection;
  }
  
  public KotlinType getReturnType()
  {
    return this.returnType;
  }
  
  @NotNull
  public List<ValueParameterDescriptor> getValueParameters()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(7);
    }
    return localList;
  }
  
  public void initialize(KotlinType paramKotlinType)
  {
    KotlinType localKotlinType = paramKotlinType;
    if (paramKotlinType == null) {
      localKotlinType = getCorrespondingProperty().getType();
    }
    this.returnType = localKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */