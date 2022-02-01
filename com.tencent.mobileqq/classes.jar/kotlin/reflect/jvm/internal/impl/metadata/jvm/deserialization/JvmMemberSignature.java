package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.jetbrains.annotations.NotNull;

public abstract class JvmMemberSignature
{
  @NotNull
  public abstract String asString();
  
  @NotNull
  public abstract String getDesc();
  
  @NotNull
  public abstract String getName();
  
  @NotNull
  public final String toString()
  {
    return asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
 * JD-Core Version:    0.7.0.1
 */