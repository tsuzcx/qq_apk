package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract interface KotlinTypeChecker
{
  public static final KotlinTypeChecker DEFAULT = NewKotlinTypeChecker.Companion.getDefault();
  
  public abstract boolean equalTypes(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2);
  
  public abstract boolean isSubtypeOf(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
 * JD-Core Version:    0.7.0.1
 */