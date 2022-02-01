package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ReceiverParameterDescriptor
  extends ParameterDescriptor
{
  @NotNull
  public abstract ReceiverValue getValue();
  
  @Nullable
  public abstract ReceiverParameterDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */