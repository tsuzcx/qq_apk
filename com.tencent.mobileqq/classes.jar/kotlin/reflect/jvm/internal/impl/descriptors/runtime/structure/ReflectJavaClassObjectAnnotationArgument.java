package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassObjectAnnotationArgument
  extends ReflectJavaAnnotationArgument
  implements JavaClassObjectAnnotationArgument
{
  private final Class<?> klass;
  
  public ReflectJavaClassObjectAnnotationArgument(@Nullable Name paramName, @NotNull Class<?> paramClass)
  {
    super(paramName);
    this.klass = paramClass;
  }
  
  @NotNull
  public JavaType getReferencedType()
  {
    return (JavaType)ReflectJavaType.Factory.create((Type)this.klass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassObjectAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */