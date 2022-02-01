package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface PropertyAccessorDescriptor
  extends VariableAccessorDescriptor
{
  @NotNull
  public abstract PropertyDescriptor getCorrespondingProperty();
  
  public abstract boolean isDefault();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
 * JD-Core Version:    0.7.0.1
 */