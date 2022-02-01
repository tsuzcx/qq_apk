package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface PlatformDependentDeclarationFilter
{
  public abstract boolean isFunctionAvailable(@NotNull ClassDescriptor paramClassDescriptor, @NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
 * JD-Core Version:    0.7.0.1
 */