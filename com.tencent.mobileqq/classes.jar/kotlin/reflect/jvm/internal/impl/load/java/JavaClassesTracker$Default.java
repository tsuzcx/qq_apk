package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class JavaClassesTracker$Default
  implements JavaClassesTracker
{
  public static final Default INSTANCE = new Default();
  
  public void reportClass(@NotNull JavaClassDescriptor paramJavaClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaClassDescriptor, "classDescriptor");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker.Default
 * JD-Core Version:    0.7.0.1
 */