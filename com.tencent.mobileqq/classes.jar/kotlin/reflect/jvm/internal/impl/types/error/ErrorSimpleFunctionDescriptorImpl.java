package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ErrorSimpleFunctionDescriptorImpl
  extends SimpleFunctionDescriptorImpl
{
  private final ErrorUtils.ErrorScope ownerScope;
  
  public ErrorSimpleFunctionDescriptorImpl(@NotNull ClassDescriptor paramClassDescriptor, @NotNull ErrorUtils.ErrorScope paramErrorScope)
  {
    super(paramClassDescriptor, null, Annotations.Companion.getEMPTY(), Name.special("<ERROR FUNCTION>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
    this.ownerScope = paramErrorScope;
  }
  
  @NotNull
  public SimpleFunctionDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    return this;
  }
  
  @NotNull
  protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(2);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(3);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(4);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(5);
    }
    return this;
  }
  
  public <V> V getUserData(CallableDescriptor.UserDataKey<V> paramUserDataKey)
  {
    return null;
  }
  
  public boolean isSuspend()
  {
    return false;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder()
  {
    return new ErrorSimpleFunctionDescriptorImpl.1(this);
  }
  
  public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */