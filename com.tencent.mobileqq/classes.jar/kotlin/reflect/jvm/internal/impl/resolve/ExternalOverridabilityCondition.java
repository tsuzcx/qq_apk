package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ExternalOverridabilityCondition
{
  @NotNull
  public abstract ExternalOverridabilityCondition.Contract getContract();
  
  @NotNull
  public abstract ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, @Nullable ClassDescriptor paramClassDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
 * JD-Core Version:    0.7.0.1
 */