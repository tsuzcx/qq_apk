package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaLiteralAnnotationArgument
  extends ReflectJavaAnnotationArgument
  implements JavaLiteralAnnotationArgument
{
  @NotNull
  private final Object value;
  
  public ReflectJavaLiteralAnnotationArgument(@Nullable Name paramName, @NotNull Object paramObject)
  {
    super(paramName);
    this.value = paramObject;
  }
  
  @NotNull
  public Object getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaLiteralAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */