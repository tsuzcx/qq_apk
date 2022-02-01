package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExtensionReceiver
  extends AbstractReceiverValue
  implements ImplicitReceiver
{
  private final CallableDescriptor descriptor;
  
  public ExtensionReceiver(@NotNull CallableDescriptor paramCallableDescriptor, @NotNull KotlinType paramKotlinType, @Nullable ReceiverValue paramReceiverValue)
  {
    super(paramKotlinType, paramReceiverValue);
    this.descriptor = paramCallableDescriptor;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getType());
    localStringBuilder.append(": Ext {");
    localStringBuilder.append(this.descriptor);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver
 * JD-Core Version:    0.7.0.1
 */