package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ModuleClassResolver
{
  @Nullable
  public abstract ClassDescriptor resolveClass(@NotNull JavaClass paramJavaClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
 * JD-Core Version:    0.7.0.1
 */