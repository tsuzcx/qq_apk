package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RenderingFormat$PLAIN
  extends RenderingFormat
{
  RenderingFormat$PLAIN()
  {
    super(str, i, null);
  }
  
  @NotNull
  public String escape(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
 * JD-Core Version:    0.7.0.1
 */