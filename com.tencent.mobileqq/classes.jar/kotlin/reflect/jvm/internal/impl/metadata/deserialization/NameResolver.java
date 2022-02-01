package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import org.jetbrains.annotations.NotNull;

public abstract interface NameResolver
{
  @NotNull
  public abstract String getQualifiedClassName(int paramInt);
  
  @NotNull
  public abstract String getString(int paramInt);
  
  public abstract boolean isLocalClassName(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
 * JD-Core Version:    0.7.0.1
 */