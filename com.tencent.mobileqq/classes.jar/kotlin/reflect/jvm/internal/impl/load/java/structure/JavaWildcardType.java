package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.Nullable;

public abstract interface JavaWildcardType
  extends JavaType
{
  @Nullable
  public abstract JavaType getBound();
  
  public abstract boolean isExtends();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
 * JD-Core Version:    0.7.0.1
 */