package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaPrimitiveType
  extends JavaType
{
  @Nullable
  public abstract PrimitiveType getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType
 * JD-Core Version:    0.7.0.1
 */