package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaClassesTracker
{
  public abstract void reportClass(@NotNull JavaClassDescriptor paramJavaClassDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
 * JD-Core Version:    0.7.0.1
 */