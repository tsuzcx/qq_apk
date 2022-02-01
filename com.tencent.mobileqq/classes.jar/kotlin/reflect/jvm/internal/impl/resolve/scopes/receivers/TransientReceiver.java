package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TransientReceiver
  extends AbstractReceiverValue
{
  public TransientReceiver(@NotNull KotlinType paramKotlinType)
  {
    this(paramKotlinType, null);
  }
  
  private TransientReceiver(@NotNull KotlinType paramKotlinType, @Nullable ReceiverValue paramReceiverValue)
  {
    super(paramKotlinType, paramReceiverValue);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{Transient} : ");
    localStringBuilder.append(getType());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.TransientReceiver
 * JD-Core Version:    0.7.0.1
 */