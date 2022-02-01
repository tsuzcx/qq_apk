package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface KotlinJvmBinaryClass
{
  @NotNull
  public abstract KotlinClassHeader getClassHeader();
  
  @NotNull
  public abstract ClassId getClassId();
  
  @NotNull
  public abstract String getLocation();
  
  public abstract void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor paramAnnotationVisitor, @Nullable byte[] paramArrayOfByte);
  
  public abstract void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor paramMemberVisitor, @Nullable byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
 * JD-Core Version:    0.7.0.1
 */