package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.Nullable;

public abstract interface SourceFile
{
  public static final SourceFile NO_SOURCE_FILE = new SourceFile.1();
  
  @Nullable
  public abstract String getName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.SourceFile
 * JD-Core Version:    0.7.0.1
 */