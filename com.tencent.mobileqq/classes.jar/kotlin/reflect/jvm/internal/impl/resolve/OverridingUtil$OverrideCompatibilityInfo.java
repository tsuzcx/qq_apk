package kotlin.reflect.jvm.internal.impl.resolve;

import org.jetbrains.annotations.NotNull;

public class OverridingUtil$OverrideCompatibilityInfo
{
  private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE, "SUCCESS");
  private final String debugMessage;
  private final OverridingUtil.OverrideCompatibilityInfo.Result overridable;
  
  public OverridingUtil$OverrideCompatibilityInfo(@NotNull OverridingUtil.OverrideCompatibilityInfo.Result paramResult, @NotNull String paramString)
  {
    this.overridable = paramResult;
    this.debugMessage = paramString;
  }
  
  @NotNull
  public static OverrideCompatibilityInfo conflict(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(2);
    }
    return new OverrideCompatibilityInfo(OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT, paramString);
  }
  
  @NotNull
  public static OverrideCompatibilityInfo incompatible(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(1);
    }
    return new OverrideCompatibilityInfo(OverridingUtil.OverrideCompatibilityInfo.Result.INCOMPATIBLE, paramString);
  }
  
  @NotNull
  public static OverrideCompatibilityInfo success()
  {
    OverrideCompatibilityInfo localOverrideCompatibilityInfo = SUCCESS;
    if (localOverrideCompatibilityInfo == null) {
      $$$reportNull$$$0(0);
    }
    return localOverrideCompatibilityInfo;
  }
  
  @NotNull
  public OverridingUtil.OverrideCompatibilityInfo.Result getResult()
  {
    OverridingUtil.OverrideCompatibilityInfo.Result localResult = this.overridable;
    if (localResult == null) {
      $$$reportNull$$$0(5);
    }
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo
 * JD-Core Version:    0.7.0.1
 */