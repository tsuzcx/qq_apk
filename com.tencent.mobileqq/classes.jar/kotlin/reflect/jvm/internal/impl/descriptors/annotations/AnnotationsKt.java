package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AnnotationsKt
{
  @NotNull
  public static final Annotations composeAnnotations(@NotNull Annotations paramAnnotations1, @NotNull Annotations paramAnnotations2)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations1, "first");
    Intrinsics.checkParameterIsNotNull(paramAnnotations2, "second");
    if (paramAnnotations1.isEmpty()) {
      return paramAnnotations2;
    }
    if (paramAnnotations2.isEmpty()) {
      return paramAnnotations1;
    }
    return (Annotations)new CompositeAnnotations(new Annotations[] { paramAnnotations1, paramAnnotations2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt
 * JD-Core Version:    0.7.0.1
 */