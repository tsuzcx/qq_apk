package kotlin.reflect.jvm.internal.impl.util;

import org.jetbrains.annotations.NotNull;

public final class CheckResult$IllegalSignature
  extends CheckResult
{
  @NotNull
  private final String error;
  
  public CheckResult$IllegalSignature(@NotNull String paramString)
  {
    super(false, null);
    this.error = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.CheckResult.IllegalSignature
 * JD-Core Version:    0.7.0.1
 */