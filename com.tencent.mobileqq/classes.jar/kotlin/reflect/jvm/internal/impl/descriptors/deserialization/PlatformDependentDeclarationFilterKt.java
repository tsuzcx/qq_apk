package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class PlatformDependentDeclarationFilterKt
{
  @NotNull
  private static final FqName PLATFORM_DEPENDENT_ANNOTATION_FQ_NAME = new FqName("kotlin.internal.PlatformDependent");
  
  @NotNull
  public static final FqName getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME()
  {
    return PLATFORM_DEPENDENT_ANNOTATION_FQ_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt
 * JD-Core Version:    0.7.0.1
 */