package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ModalityKt
{
  public static final boolean isFinalClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$isFinalClass");
    return (paramClassDescriptor.getModality() == Modality.FINAL) && (paramClassDescriptor.getKind() != ClassKind.ENUM_CLASS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt
 * JD-Core Version:    0.7.0.1
 */