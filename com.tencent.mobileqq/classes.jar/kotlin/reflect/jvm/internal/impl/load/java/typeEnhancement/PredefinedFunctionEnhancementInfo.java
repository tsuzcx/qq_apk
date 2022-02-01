package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PredefinedFunctionEnhancementInfo
{
  @NotNull
  private final List<TypeEnhancementInfo> parametersInfo;
  @Nullable
  private final TypeEnhancementInfo returnTypeInfo;
  
  public PredefinedFunctionEnhancementInfo()
  {
    this(null, null, 3, null);
  }
  
  public PredefinedFunctionEnhancementInfo(@Nullable TypeEnhancementInfo paramTypeEnhancementInfo, @NotNull List<TypeEnhancementInfo> paramList)
  {
    this.returnTypeInfo = paramTypeEnhancementInfo;
    this.parametersInfo = paramList;
  }
  
  @NotNull
  public final List<TypeEnhancementInfo> getParametersInfo()
  {
    return this.parametersInfo;
  }
  
  @Nullable
  public final TypeEnhancementInfo getReturnTypeInfo()
  {
    return this.returnTypeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo
 * JD-Core Version:    0.7.0.1
 */