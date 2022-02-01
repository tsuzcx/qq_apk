package kotlin.reflect.jvm.internal.impl.util;

public abstract class CheckResult
{
  private final boolean isSuccess;
  
  private CheckResult(boolean paramBoolean)
  {
    this.isSuccess = paramBoolean;
  }
  
  public final boolean isSuccess()
  {
    return this.isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.CheckResult
 * JD-Core Version:    0.7.0.1
 */