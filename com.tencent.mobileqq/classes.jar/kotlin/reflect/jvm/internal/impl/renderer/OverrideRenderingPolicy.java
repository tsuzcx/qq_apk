package kotlin.reflect.jvm.internal.impl.renderer;

public enum OverrideRenderingPolicy
{
  static
  {
    OverrideRenderingPolicy localOverrideRenderingPolicy1 = new OverrideRenderingPolicy("RENDER_OVERRIDE", 0);
    RENDER_OVERRIDE = localOverrideRenderingPolicy1;
    OverrideRenderingPolicy localOverrideRenderingPolicy2 = new OverrideRenderingPolicy("RENDER_OPEN", 1);
    RENDER_OPEN = localOverrideRenderingPolicy2;
    OverrideRenderingPolicy localOverrideRenderingPolicy3 = new OverrideRenderingPolicy("RENDER_OPEN_OVERRIDE", 2);
    RENDER_OPEN_OVERRIDE = localOverrideRenderingPolicy3;
    $VALUES = new OverrideRenderingPolicy[] { localOverrideRenderingPolicy1, localOverrideRenderingPolicy2, localOverrideRenderingPolicy3 };
  }
  
  private OverrideRenderingPolicy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy
 * JD-Core Version:    0.7.0.1
 */