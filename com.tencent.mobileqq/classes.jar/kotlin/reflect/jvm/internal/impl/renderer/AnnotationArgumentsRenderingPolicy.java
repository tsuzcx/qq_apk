package kotlin.reflect.jvm.internal.impl.renderer;

public enum AnnotationArgumentsRenderingPolicy
{
  private final boolean includeAnnotationArguments;
  private final boolean includeEmptyAnnotationArguments;
  
  static
  {
    AnnotationArgumentsRenderingPolicy localAnnotationArgumentsRenderingPolicy1 = new AnnotationArgumentsRenderingPolicy("NO_ARGUMENTS", 0, false, false, 3, null);
    NO_ARGUMENTS = localAnnotationArgumentsRenderingPolicy1;
    AnnotationArgumentsRenderingPolicy localAnnotationArgumentsRenderingPolicy2 = new AnnotationArgumentsRenderingPolicy("UNLESS_EMPTY", 1, true, false, 2, null);
    UNLESS_EMPTY = localAnnotationArgumentsRenderingPolicy2;
    AnnotationArgumentsRenderingPolicy localAnnotationArgumentsRenderingPolicy3 = new AnnotationArgumentsRenderingPolicy("ALWAYS_PARENTHESIZED", 2, true, true);
    ALWAYS_PARENTHESIZED = localAnnotationArgumentsRenderingPolicy3;
    $VALUES = new AnnotationArgumentsRenderingPolicy[] { localAnnotationArgumentsRenderingPolicy1, localAnnotationArgumentsRenderingPolicy2, localAnnotationArgumentsRenderingPolicy3 };
  }
  
  private AnnotationArgumentsRenderingPolicy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.includeAnnotationArguments = paramBoolean1;
    this.includeEmptyAnnotationArguments = paramBoolean2;
  }
  
  public final boolean getIncludeAnnotationArguments()
  {
    return this.includeAnnotationArguments;
  }
  
  public final boolean getIncludeEmptyAnnotationArguments()
  {
    return this.includeEmptyAnnotationArguments;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy
 * JD-Core Version:    0.7.0.1
 */