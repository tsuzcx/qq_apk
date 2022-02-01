package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import org.jetbrains.annotations.Nullable;

public final class AnnotationDescriptor$DefaultImpls
{
  @Nullable
  public static FqName getFqName(AnnotationDescriptor paramAnnotationDescriptor)
  {
    ClassDescriptor localClassDescriptor = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
    Object localObject = null;
    paramAnnotationDescriptor = localObject;
    if (localClassDescriptor != null)
    {
      if (ErrorUtils.isError((DeclarationDescriptor)localClassDescriptor)) {
        localClassDescriptor = null;
      }
      paramAnnotationDescriptor = localObject;
      if (localClassDescriptor != null) {
        paramAnnotationDescriptor = DescriptorUtilsKt.fqNameOrNull((DeclarationDescriptor)localClassDescriptor);
      }
    }
    return paramAnnotationDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */