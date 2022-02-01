package kotlin.reflect.jvm.internal.impl.types.checker;

import org.jetbrains.annotations.NotNull;

public final class NewKotlinTypeChecker$Companion
{
  @NotNull
  private static final NewKotlinTypeCheckerImpl Default = new NewKotlinTypeCheckerImpl((KotlinTypeRefiner)KotlinTypeRefiner.Default.INSTANCE);
  
  @NotNull
  public final NewKotlinTypeCheckerImpl getDefault()
  {
    return Default;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion
 * JD-Core Version:    0.7.0.1
 */