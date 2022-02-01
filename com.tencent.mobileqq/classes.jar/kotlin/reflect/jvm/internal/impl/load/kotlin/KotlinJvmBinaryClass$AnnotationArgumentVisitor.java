package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface KotlinJvmBinaryClass$AnnotationArgumentVisitor
{
  public abstract void visit(@Nullable Name paramName, @Nullable Object paramObject);
  
  @Nullable
  public abstract AnnotationArgumentVisitor visitAnnotation(@NotNull Name paramName, @NotNull ClassId paramClassId);
  
  @Nullable
  public abstract KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name paramName);
  
  public abstract void visitClassLiteral(@NotNull Name paramName, @NotNull ClassLiteralValue paramClassLiteralValue);
  
  public abstract void visitEnd();
  
  public abstract void visitEnum(@NotNull Name paramName1, @NotNull ClassId paramClassId, @NotNull Name paramName2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
 * JD-Core Version:    0.7.0.1
 */