package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

public abstract interface JavaField
  extends JavaMember
{
  public abstract boolean getHasConstantNotNullInitializer();
  
  @NotNull
  public abstract JavaType getType();
  
  public abstract boolean isEnumEntry();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
 * JD-Core Version:    0.7.0.1
 */