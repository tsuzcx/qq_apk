package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class AnnotationValue
  extends ConstantValue<AnnotationDescriptor>
{
  public AnnotationValue(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    super(paramAnnotationDescriptor);
  }
  
  @NotNull
  public KotlinType getType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    return ((AnnotationDescriptor)getValue()).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue
 * JD-Core Version:    0.7.0.1
 */