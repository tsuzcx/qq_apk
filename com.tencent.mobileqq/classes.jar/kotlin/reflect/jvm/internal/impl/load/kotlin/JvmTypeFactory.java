package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;

public abstract interface JvmTypeFactory<T>
{
  @NotNull
  public abstract T boxType(@NotNull T paramT);
  
  @NotNull
  public abstract T createFromString(@NotNull String paramString);
  
  @NotNull
  public abstract T createObjectType(@NotNull String paramString);
  
  @NotNull
  public abstract T getJavaLangClassType();
  
  @NotNull
  public abstract String toString(@NotNull T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
 * JD-Core Version:    0.7.0.1
 */