package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1
  implements KotlinJvmBinaryClass.AnnotationVisitor
{
  AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1(ArrayList paramArrayList) {}
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0, paramClassId, paramSourceElement, (List)this.$result);
  }
  
  public void visitEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadClassAnnotations.1
 * JD-Core Version:    0.7.0.1
 */