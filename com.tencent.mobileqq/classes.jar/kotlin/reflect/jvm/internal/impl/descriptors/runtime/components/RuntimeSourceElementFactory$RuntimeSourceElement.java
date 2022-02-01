package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import org.jetbrains.annotations.NotNull;

public final class RuntimeSourceElementFactory$RuntimeSourceElement
  implements JavaSourceElement
{
  @NotNull
  private final ReflectJavaElement javaElement;
  
  public RuntimeSourceElementFactory$RuntimeSourceElement(@NotNull ReflectJavaElement paramReflectJavaElement)
  {
    this.javaElement = paramReflectJavaElement;
  }
  
  @NotNull
  public SourceFile getContainingFile()
  {
    SourceFile localSourceFile = SourceFile.NO_SOURCE_FILE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceFile, "SourceFile.NO_SOURCE_FILE");
    return localSourceFile;
  }
  
  @NotNull
  public ReflectJavaElement getJavaElement()
  {
    return this.javaElement;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(getJavaElement().toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement
 * JD-Core Version:    0.7.0.1
 */