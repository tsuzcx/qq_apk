package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public final class Modality$Companion
{
  @NotNull
  public final Modality convertFromFlags(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return Modality.ABSTRACT;
    }
    if (paramBoolean2) {
      return Modality.OPEN;
    }
    return Modality.FINAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion
 * JD-Core Version:    0.7.0.1
 */