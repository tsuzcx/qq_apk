package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface SimpleFunctionDescriptor
  extends FunctionDescriptor
{
  @NotNull
  public abstract FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor
 * JD-Core Version:    0.7.0.1
 */