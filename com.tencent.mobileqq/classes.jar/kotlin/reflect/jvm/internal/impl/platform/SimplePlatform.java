package kotlin.reflect.jvm.internal.impl.platform;

import org.jetbrains.annotations.NotNull;

public abstract class SimplePlatform
{
  @NotNull
  private final String platformName;
  
  @NotNull
  public String toString()
  {
    return this.platformName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.platform.SimplePlatform
 * JD-Core Version:    0.7.0.1
 */