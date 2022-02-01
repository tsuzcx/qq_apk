package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import org.jetbrains.annotations.NotNull;

public class AnnotatedImpl
  implements Annotated
{
  private final Annotations annotations;
  
  public AnnotatedImpl(@NotNull Annotations paramAnnotations)
  {
    this.annotations = paramAnnotations;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    Annotations localAnnotations = this.annotations;
    if (localAnnotations == null) {
      $$$reportNull$$$0(1);
    }
    return localAnnotations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl
 * JD-Core Version:    0.7.0.1
 */