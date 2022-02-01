package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

public abstract interface CustomTypeVariable
{
  public abstract boolean isTypeVariable();
  
  @NotNull
  public abstract KotlinType substitutionResult(@NotNull KotlinType paramKotlinType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
 * JD-Core Version:    0.7.0.1
 */