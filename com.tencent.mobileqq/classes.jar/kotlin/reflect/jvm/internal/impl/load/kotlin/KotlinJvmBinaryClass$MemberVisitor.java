package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface KotlinJvmBinaryClass$MemberVisitor
{
  @Nullable
  public abstract KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull Name paramName, @NotNull String paramString, @Nullable Object paramObject);
  
  @Nullable
  public abstract KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull Name paramName, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
 * JD-Core Version:    0.7.0.1
 */