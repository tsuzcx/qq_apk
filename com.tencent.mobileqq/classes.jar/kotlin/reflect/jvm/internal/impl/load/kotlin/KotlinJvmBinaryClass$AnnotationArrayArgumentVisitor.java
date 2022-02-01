package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface KotlinJvmBinaryClass$AnnotationArrayArgumentVisitor
{
  public abstract void visit(@Nullable Object paramObject);
  
  public abstract void visitClassLiteral(@NotNull ClassLiteralValue paramClassLiteralValue);
  
  public abstract void visitEnd();
  
  public abstract void visitEnum(@NotNull ClassId paramClassId, @NotNull Name paramName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
 * JD-Core Version:    0.7.0.1
 */