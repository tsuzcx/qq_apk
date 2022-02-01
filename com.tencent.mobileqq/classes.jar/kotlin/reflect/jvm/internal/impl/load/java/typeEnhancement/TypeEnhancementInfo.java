package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class TypeEnhancementInfo
{
  @NotNull
  private final Map<Integer, JavaTypeQualifiers> map;
  
  public TypeEnhancementInfo(@NotNull Map<Integer, JavaTypeQualifiers> paramMap)
  {
    this.map = paramMap;
  }
  
  @NotNull
  public final Map<Integer, JavaTypeQualifiers> getMap()
  {
    return this.map;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo
 * JD-Core Version:    0.7.0.1
 */