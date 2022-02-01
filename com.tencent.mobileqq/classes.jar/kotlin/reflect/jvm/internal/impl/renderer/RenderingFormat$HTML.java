package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class RenderingFormat$HTML
  extends RenderingFormat
{
  RenderingFormat$HTML()
  {
    super(str, i, null);
  }
  
  @NotNull
  public String escape(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return StringsKt.replace$default(StringsKt.replace$default(paramString, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
 * JD-Core Version:    0.7.0.1
 */