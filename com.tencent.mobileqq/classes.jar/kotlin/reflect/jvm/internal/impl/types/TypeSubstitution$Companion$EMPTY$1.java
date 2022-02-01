package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSubstitution$Companion$EMPTY$1
  extends TypeSubstitution
{
  @Nullable
  public Void get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    return null;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    return "Empty TypeSubstitution";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.Companion.EMPTY.1
 * JD-Core Version:    0.7.0.1
 */