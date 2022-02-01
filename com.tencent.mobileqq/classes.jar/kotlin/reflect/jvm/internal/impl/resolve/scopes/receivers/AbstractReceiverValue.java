package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractReceiverValue
  implements ReceiverValue
{
  private final ReceiverValue original;
  protected final KotlinType receiverType;
  
  public AbstractReceiverValue(@NotNull KotlinType paramKotlinType, @Nullable ReceiverValue paramReceiverValue)
  {
    this.receiverType = paramKotlinType;
    if (paramReceiverValue != null) {
      paramKotlinType = paramReceiverValue;
    } else {
      paramKotlinType = this;
    }
    this.original = paramKotlinType;
  }
  
  @NotNull
  public KotlinType getType()
  {
    KotlinType localKotlinType = this.receiverType;
    if (localKotlinType == null) {
      $$$reportNull$$$0(1);
    }
    return localKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.AbstractReceiverValue
 * JD-Core Version:    0.7.0.1
 */