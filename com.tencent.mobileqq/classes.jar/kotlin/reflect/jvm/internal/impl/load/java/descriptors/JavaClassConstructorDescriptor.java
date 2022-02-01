package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaClassConstructorDescriptor
  extends ClassConstructorDescriptorImpl
  implements JavaCallableMemberDescriptor
{
  private Boolean hasStableParameterNames = null;
  private Boolean hasSynthesizedParameterNames = null;
  
  protected JavaClassConstructorDescriptor(@NotNull ClassDescriptor paramClassDescriptor, @Nullable JavaClassConstructorDescriptor paramJavaClassConstructorDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
  {
    super(paramClassDescriptor, paramJavaClassConstructorDescriptor, paramAnnotations, paramBoolean, paramKind, paramSourceElement);
  }
  
  @NotNull
  public static JavaClassConstructorDescriptor createJavaConstructor(@NotNull ClassDescriptor paramClassDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull SourceElement paramSourceElement)
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
    return new JavaClassConstructorDescriptor(paramClassDescriptor, null, paramAnnotations, paramBoolean, CallableMemberDescriptor.Kind.DECLARATION, paramSourceElement);
  }
  
  @NotNull
  protected JavaClassConstructorDescriptor createDescriptor(@NotNull ClassDescriptor paramClassDescriptor, @Nullable JavaClassConstructorDescriptor paramJavaClassConstructorDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement, @NotNull Annotations paramAnnotations)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(12);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(13);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(14);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(15);
    }
    return new JavaClassConstructorDescriptor(paramClassDescriptor, paramJavaClassConstructorDescriptor, paramAnnotations, this.isPrimary, paramKind, paramSourceElement);
  }
  
  @NotNull
  protected JavaClassConstructorDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(8);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(9);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(10);
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
    paramDeclarationDescriptor = createDescriptor((ClassDescriptor)paramDeclarationDescriptor, (JavaClassConstructorDescriptor)paramFunctionDescriptor, paramKind, paramSourceElement, paramAnnotations);
    paramDeclarationDescriptor.setHasStableParameterNames(hasStableParameterNames());
    paramDeclarationDescriptor.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(11);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public JavaClassConstructorDescriptor enhance(@Nullable KotlinType paramKotlinType1, @NotNull List<ValueParameterData> paramList, @NotNull KotlinType paramKotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> paramPair)
  {
    if (paramList == null) {
      $$$reportNull$$$0(16);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(17);
    }
    JavaClassConstructorDescriptor localJavaClassConstructorDescriptor = createSubstitutedCopy(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
    if (paramKotlinType1 == null) {
      paramKotlinType1 = null;
    } else {
      paramKotlinType1 = DescriptorFactory.createExtensionReceiverParameterForCallable(localJavaClassConstructorDescriptor, paramKotlinType1, Annotations.Companion.getEMPTY());
    }
    localJavaClassConstructorDescriptor.initialize(paramKotlinType1, getDispatchReceiverParameter(), getTypeParameters(), UtilKt.copyValueParameters(paramList, getValueParameters(), localJavaClassConstructorDescriptor), paramKotlinType2, getModality(), getVisibility());
    if (paramPair != null) {
      localJavaClassConstructorDescriptor.putInUserDataMap((CallableDescriptor.UserDataKey)paramPair.getFirst(), paramPair.getSecond());
    }
    if (localJavaClassConstructorDescriptor == null) {
      $$$reportNull$$$0(18);
    }
    return localJavaClassConstructorDescriptor;
  }
  
  public boolean hasStableParameterNames()
  {
    return this.hasStableParameterNames.booleanValue();
  }
  
  public boolean hasSynthesizedParameterNames()
  {
    return this.hasSynthesizedParameterNames.booleanValue();
  }
  
  public void setHasStableParameterNames(boolean paramBoolean)
  {
    this.hasStableParameterNames = Boolean.valueOf(paramBoolean);
  }
  
  public void setHasSynthesizedParameterNames(boolean paramBoolean)
  {
    this.hasSynthesizedParameterNames = Boolean.valueOf(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor
 * JD-Core Version:    0.7.0.1
 */