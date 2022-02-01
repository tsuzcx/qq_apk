package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

public final class RuntimeSourceElementFactory
  implements JavaSourceElementFactory
{
  public static final RuntimeSourceElementFactory INSTANCE = new RuntimeSourceElementFactory();
  
  @NotNull
  public JavaSourceElement source(@NotNull JavaElement paramJavaElement)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaElement, "javaElement");
    return (JavaSourceElement)new RuntimeSourceElementFactory.RuntimeSourceElement((ReflectJavaElement)paramJavaElement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory
 * JD-Core Version:    0.7.0.1
 */