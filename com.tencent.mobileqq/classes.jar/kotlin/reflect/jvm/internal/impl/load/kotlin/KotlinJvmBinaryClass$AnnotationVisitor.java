package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface KotlinJvmBinaryClass$AnnotationVisitor
{
  @Nullable
  public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement);
  
  public abstract void visitEnd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
 * JD-Core Version:    0.7.0.1
 */