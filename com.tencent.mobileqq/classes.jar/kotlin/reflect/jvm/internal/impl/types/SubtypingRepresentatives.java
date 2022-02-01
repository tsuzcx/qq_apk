package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

public abstract interface SubtypingRepresentatives
{
  @NotNull
  public abstract KotlinType getSubTypeRepresentative();
  
  @NotNull
  public abstract KotlinType getSuperTypeRepresentative();
  
  public abstract boolean sameTypeConstructor(@NotNull KotlinType paramKotlinType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
 * JD-Core Version:    0.7.0.1
 */