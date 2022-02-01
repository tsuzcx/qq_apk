package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import org.jetbrains.annotations.NotNull;

class DescriptorFactory$DefaultClassConstructorDescriptor
  extends ClassConstructorDescriptorImpl
{
  public DescriptorFactory$DefaultClassConstructorDescriptor(@NotNull ClassDescriptor paramClassDescriptor, @NotNull SourceElement paramSourceElement)
  {
    super(paramClassDescriptor, null, Annotations.Companion.getEMPTY(), true, CallableMemberDescriptor.Kind.DECLARATION, paramSourceElement);
    initialize(Collections.emptyList(), DescriptorUtils.getDefaultConstructorVisibility(paramClassDescriptor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.DefaultClassConstructorDescriptor
 * JD-Core Version:    0.7.0.1
 */