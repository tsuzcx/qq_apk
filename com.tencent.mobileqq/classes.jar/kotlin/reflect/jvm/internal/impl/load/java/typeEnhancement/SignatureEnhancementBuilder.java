package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancementBuilder
{
  private final Map<String, PredefinedFunctionEnhancementInfo> signatures = (Map)new LinkedHashMap();
  
  @NotNull
  public final Map<String, PredefinedFunctionEnhancementInfo> build()
  {
    return this.signatures;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder
 * JD-Core Version:    0.7.0.1
 */