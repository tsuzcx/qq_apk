package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract interface SuperCallReceiverValue
  extends ReceiverValue
{
  @NotNull
  public abstract KotlinType getThisType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue
 * JD-Core Version:    0.7.0.1
 */