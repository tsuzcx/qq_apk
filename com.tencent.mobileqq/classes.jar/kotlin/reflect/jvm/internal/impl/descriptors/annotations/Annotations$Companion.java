package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class Annotations$Companion
{
  @NotNull
  private static final Annotations EMPTY = (Annotations)new Annotations.Companion.EMPTY.1();
  
  @NotNull
  public final Annotations create(@NotNull List<? extends AnnotationDescriptor> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "annotations");
    if (paramList.isEmpty()) {
      return EMPTY;
    }
    return (Annotations)new AnnotationsImpl(paramList);
  }
  
  @NotNull
  public final Annotations getEMPTY()
  {
    return EMPTY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
 * JD-Core Version:    0.7.0.1
 */