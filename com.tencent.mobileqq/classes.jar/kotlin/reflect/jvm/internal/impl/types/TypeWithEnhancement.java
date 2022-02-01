package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

public abstract interface TypeWithEnhancement
{
  @NotNull
  public abstract KotlinType getEnhancement();
  
  @NotNull
  public abstract UnwrappedType getOrigin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
 * JD-Core Version:    0.7.0.1
 */