package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

final class AnnotatedSimpleType
  extends DelegatingSimpleTypeImpl
{
  @NotNull
  private final Annotations annotations;
  
  public AnnotatedSimpleType(@NotNull SimpleType paramSimpleType, @NotNull Annotations paramAnnotations)
  {
    super(paramSimpleType);
    this.annotations = paramAnnotations;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  @NotNull
  public AnnotatedSimpleType replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new AnnotatedSimpleType(paramSimpleType, getAnnotations());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AnnotatedSimpleType
 * JD-Core Version:    0.7.0.1
 */