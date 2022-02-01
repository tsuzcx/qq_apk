package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ErrorValue$Companion
{
  @NotNull
  public final ErrorValue create(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    return (ErrorValue)new ErrorValue.ErrorValueWithMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion
 * JD-Core Version:    0.7.0.1
 */