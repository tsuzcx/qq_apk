package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorFactory
{
  @NotNull
  public static PropertyGetterDescriptorImpl createDefaultGetter(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(14);
    }
    return createGetter(paramPropertyDescriptor, paramAnnotations, true, false, false);
  }
  
  @NotNull
  public static PropertySetterDescriptorImpl createDefaultSetter(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations1, @NotNull Annotations paramAnnotations2)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    if (paramAnnotations1 == null) {
      $$$reportNull$$$0(1);
    }
    if (paramAnnotations2 == null) {
      $$$reportNull$$$0(2);
    }
    return createSetter(paramPropertyDescriptor, paramAnnotations1, paramAnnotations2, true, false, false, paramPropertyDescriptor.getSource());
  }
  
  @NotNull
  public static SimpleFunctionDescriptor createEnumValueOfMethod(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(24);
    }
    SimpleFunctionDescriptorImpl localSimpleFunctionDescriptorImpl = SimpleFunctionDescriptorImpl.create(paramClassDescriptor, Annotations.Companion.getEMPTY(), DescriptorUtils.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, paramClassDescriptor.getSource());
    ValueParameterDescriptorImpl localValueParameterDescriptorImpl = new ValueParameterDescriptorImpl(localSimpleFunctionDescriptorImpl, null, 0, Annotations.Companion.getEMPTY(), Name.identifier("value"), DescriptorUtilsKt.getBuiltIns(paramClassDescriptor).getStringType(), false, false, false, null, paramClassDescriptor.getSource());
    paramClassDescriptor = localSimpleFunctionDescriptorImpl.initialize(null, null, Collections.emptyList(), Collections.singletonList(localValueParameterDescriptorImpl), paramClassDescriptor.getDefaultType(), Modality.FINAL, Visibilities.PUBLIC);
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(25);
    }
    return paramClassDescriptor;
  }
  
  @NotNull
  public static SimpleFunctionDescriptor createEnumValuesMethod(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(22);
    }
    paramClassDescriptor = SimpleFunctionDescriptorImpl.create(paramClassDescriptor, Annotations.Companion.getEMPTY(), DescriptorUtils.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, paramClassDescriptor.getSource()).initialize(null, null, Collections.emptyList(), Collections.emptyList(), DescriptorUtilsKt.getBuiltIns(paramClassDescriptor).getArrayType(Variance.INVARIANT, paramClassDescriptor.getDefaultType()), Modality.FINAL, Visibilities.PUBLIC);
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(23);
    }
    return paramClassDescriptor;
  }
  
  @Nullable
  public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(@NotNull CallableDescriptor paramCallableDescriptor, @Nullable KotlinType paramKotlinType, @NotNull Annotations paramAnnotations)
  {
    if (paramCallableDescriptor == null) {
      $$$reportNull$$$0(29);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(30);
    }
    if (paramKotlinType == null) {
      return null;
    }
    return new ReceiverParameterDescriptorImpl(paramCallableDescriptor, new ExtensionReceiver(paramCallableDescriptor, paramKotlinType, null), paramAnnotations);
  }
  
  @NotNull
  public static PropertyGetterDescriptorImpl createGetter(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(15);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(16);
    }
    return createGetter(paramPropertyDescriptor, paramAnnotations, paramBoolean1, paramBoolean2, paramBoolean3, paramPropertyDescriptor.getSource());
  }
  
  @NotNull
  public static PropertyGetterDescriptorImpl createGetter(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull SourceElement paramSourceElement)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(17);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(18);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(19);
    }
    return new PropertyGetterDescriptorImpl(paramPropertyDescriptor, paramAnnotations, paramPropertyDescriptor.getModality(), paramPropertyDescriptor.getVisibility(), paramBoolean1, paramBoolean2, paramBoolean3, CallableMemberDescriptor.Kind.DECLARATION, null, paramSourceElement);
  }
  
  @NotNull
  public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(@NotNull ClassDescriptor paramClassDescriptor, @NotNull SourceElement paramSourceElement)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(20);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(21);
    }
    return new DescriptorFactory.DefaultClassConstructorDescriptor(paramClassDescriptor, paramSourceElement);
  }
  
  @NotNull
  public static PropertySetterDescriptorImpl createSetter(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations1, @NotNull Annotations paramAnnotations2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull SourceElement paramSourceElement)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    if (paramAnnotations1 == null) {
      $$$reportNull$$$0(4);
    }
    if (paramAnnotations2 == null) {
      $$$reportNull$$$0(5);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(6);
    }
    return createSetter(paramPropertyDescriptor, paramAnnotations1, paramAnnotations2, paramBoolean1, paramBoolean2, paramBoolean3, paramPropertyDescriptor.getVisibility(), paramSourceElement);
  }
  
  @NotNull
  public static PropertySetterDescriptorImpl createSetter(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations1, @NotNull Annotations paramAnnotations2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull Visibility paramVisibility, @NotNull SourceElement paramSourceElement)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    if (paramAnnotations1 == null) {
      $$$reportNull$$$0(8);
    }
    if (paramAnnotations2 == null) {
      $$$reportNull$$$0(9);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(10);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(11);
    }
    paramAnnotations1 = new PropertySetterDescriptorImpl(paramPropertyDescriptor, paramAnnotations1, paramPropertyDescriptor.getModality(), paramVisibility, paramBoolean1, paramBoolean2, paramBoolean3, CallableMemberDescriptor.Kind.DECLARATION, null, paramSourceElement);
    paramAnnotations1.initialize(PropertySetterDescriptorImpl.createSetterParameter(paramAnnotations1, paramPropertyDescriptor.getType(), paramAnnotations2));
    return paramAnnotations1;
  }
  
  private static boolean isEnumSpecialMethod(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    if (paramFunctionDescriptor == null) {
      $$$reportNull$$$0(28);
    }
    return (paramFunctionDescriptor.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED) && (DescriptorUtils.isEnumClass(paramFunctionDescriptor.getContainingDeclaration()));
  }
  
  public static boolean isEnumValueOfMethod(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    if (paramFunctionDescriptor == null) {
      $$$reportNull$$$0(27);
    }
    return (paramFunctionDescriptor.getName().equals(DescriptorUtils.ENUM_VALUE_OF)) && (isEnumSpecialMethod(paramFunctionDescriptor));
  }
  
  public static boolean isEnumValuesMethod(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    if (paramFunctionDescriptor == null) {
      $$$reportNull$$$0(26);
    }
    return (paramFunctionDescriptor.getName().equals(DescriptorUtils.ENUM_VALUES)) && (isEnumSpecialMethod(paramFunctionDescriptor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory
 * JD-Core Version:    0.7.0.1
 */