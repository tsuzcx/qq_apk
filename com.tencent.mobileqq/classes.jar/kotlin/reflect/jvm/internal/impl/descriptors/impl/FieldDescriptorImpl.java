package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

public final class FieldDescriptorImpl
  extends AnnotatedImpl
  implements FieldDescriptor
{
  @NotNull
  private final PropertyDescriptor correspondingProperty;
  
  public FieldDescriptorImpl(@NotNull Annotations paramAnnotations, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramAnnotations);
    this.correspondingProperty = paramPropertyDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */