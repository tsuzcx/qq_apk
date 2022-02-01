package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaAnnotationArgument
  implements JavaAnnotationArgument
{
  public static final ReflectJavaAnnotationArgument.Factory Factory = new ReflectJavaAnnotationArgument.Factory(null);
  @Nullable
  private final Name name;
  
  public ReflectJavaAnnotationArgument(@Nullable Name paramName)
  {
    this.name = paramName;
  }
  
  @Nullable
  public Name getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */