package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.Nullable;

public abstract interface ReflectJavaAnnotationOwner
  extends JavaAnnotationOwner
{
  @Nullable
  public abstract AnnotatedElement getElement();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
 * JD-Core Version:    0.7.0.1
 */