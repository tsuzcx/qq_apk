package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaForKotlinOverridePropertyDescriptor
  extends JavaPropertyDescriptor
{
  public JavaForKotlinOverridePropertyDescriptor(@NotNull ClassDescriptor paramClassDescriptor, @NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor1, @Nullable SimpleFunctionDescriptor paramSimpleFunctionDescriptor2, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramClassDescriptor, localAnnotations, localModality, localVisibility, bool, paramPropertyDescriptor.getName(), paramSimpleFunctionDescriptor1.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor
 * JD-Core Version:    0.7.0.1
 */