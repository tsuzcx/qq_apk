package kotlin.reflect.jvm.internal.impl.renderer;

import org.jetbrains.annotations.NotNull;

public enum RenderingFormat
{
  static
  {
    RenderingFormat.PLAIN localPLAIN = new RenderingFormat.PLAIN("PLAIN", 0);
    PLAIN = localPLAIN;
    RenderingFormat.HTML localHTML = new RenderingFormat.HTML("HTML", 1);
    HTML = localHTML;
    $VALUES = new RenderingFormat[] { localPLAIN, localHTML };
  }
  
  private RenderingFormat() {}
  
  @NotNull
  public abstract String escape(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
 * JD-Core Version:    0.7.0.1
 */