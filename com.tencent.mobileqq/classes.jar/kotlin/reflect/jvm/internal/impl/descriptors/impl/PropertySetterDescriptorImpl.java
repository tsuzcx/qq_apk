package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PropertySetterDescriptorImpl
  extends PropertyAccessorDescriptorImpl
  implements PropertySetterDescriptor
{
  @NotNull
  private final PropertySetterDescriptor original;
  private ValueParameterDescriptor parameter;
  
  public PropertySetterDescriptorImpl(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable PropertySetterDescriptor paramPropertySetterDescriptor, @NotNull SourceElement paramSourceElement)
  {
    super(paramModality, paramVisibility, paramPropertyDescriptor, paramAnnotations, Name.special(localStringBuilder.toString()), paramBoolean1, paramBoolean2, paramBoolean3, paramKind, paramSourceElement);
    if (paramPropertySetterDescriptor != null) {
      paramPropertyDescriptor = paramPropertySetterDescriptor;
    } else {
      paramPropertyDescriptor = this;
    }
    this.original = paramPropertyDescriptor;
  }
  
  public static ValueParameterDescriptorImpl createSetterParameter(@NotNull PropertySetterDescriptor paramPropertySetterDescriptor, @NotNull KotlinType paramKotlinType, @NotNull Annotations paramAnnotations)
  {
    if (paramPropertySetterDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    if (paramKotlinType == null) {
      $$$reportNull$$$0(8);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(9);
    }
    return new ValueParameterDescriptorImpl(paramPropertySetterDescriptor, null, 0, paramAnnotations, Name.special("<set-?>"), paramKotlinType, false, false, false, null, SourceElement.NO_SOURCE);
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitPropertySetterDescriptor(this, paramD);
  }
  
  @NotNull
  public PropertySetterDescriptor getOriginal()
  {
    PropertySetterDescriptor localPropertySetterDescriptor = this.original;
    if (localPropertySetterDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    return localPropertySetterDescriptor;
  }
  
  @NotNull
  public Collection<? extends PropertySetterDescriptor> getOverriddenDescriptors()
  {
    Collection localCollection = super.getOverriddenDescriptors(false);
    if (localCollection == null) {
      $$$reportNull$$$0(10);
    }
    return localCollection;
  }
  
  @NotNull
  public KotlinType getReturnType()
  {
    SimpleType localSimpleType = DescriptorUtilsKt.getBuiltIns(this).getUnitType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(12);
    }
    return localSimpleType;
  }
  
  @NotNull
  public List<ValueParameterDescriptor> getValueParameters()
  {
    Object localObject = this.parameter;
    if (localObject != null)
    {
      localObject = Collections.singletonList(localObject);
      if (localObject == null) {
        $$$reportNull$$$0(11);
      }
      return localObject;
    }
    throw new IllegalStateException();
  }
  
  public void initialize(@NotNull ValueParameterDescriptor paramValueParameterDescriptor)
  {
    if (paramValueParameterDescriptor == null) {
      $$$reportNull$$$0(6);
    }
    this.parameter = paramValueParameterDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */