package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface ThisClassReceiver
  extends ReceiverValue
{
  @NotNull
  public abstract ClassDescriptor getClassDescriptor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
 * JD-Core Version:    0.7.0.1
 */