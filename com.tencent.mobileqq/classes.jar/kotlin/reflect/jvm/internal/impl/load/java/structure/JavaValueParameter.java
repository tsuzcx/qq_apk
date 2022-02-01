package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaValueParameter
  extends JavaAnnotationOwner
{
  @Nullable
  public abstract Name getName();
  
  @NotNull
  public abstract JavaType getType();
  
  public abstract boolean isVararg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
 * JD-Core Version:    0.7.0.1
 */