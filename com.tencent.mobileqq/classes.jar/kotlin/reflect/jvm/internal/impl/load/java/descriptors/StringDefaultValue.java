package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import org.jetbrains.annotations.NotNull;

public final class StringDefaultValue
  extends AnnotationDefaultValue
{
  @NotNull
  private final String value;
  
  public StringDefaultValue(@NotNull String paramString)
  {
    super(null);
    this.value = paramString;
  }
  
  @NotNull
  public final String getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue
 * JD-Core Version:    0.7.0.1
 */