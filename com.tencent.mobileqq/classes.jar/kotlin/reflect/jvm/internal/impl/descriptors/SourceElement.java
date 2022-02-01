package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public abstract interface SourceElement
{
  public static final SourceElement NO_SOURCE = new SourceElement.1();
  
  @NotNull
  public abstract SourceFile getContainingFile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
 * JD-Core Version:    0.7.0.1
 */