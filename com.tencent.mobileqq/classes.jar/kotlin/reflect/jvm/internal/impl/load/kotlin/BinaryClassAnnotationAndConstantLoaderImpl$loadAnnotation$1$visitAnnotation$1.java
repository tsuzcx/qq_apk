package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitAnnotation$1
  implements KotlinJvmBinaryClass.AnnotationArgumentVisitor
{
  BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitAnnotation$1(KotlinJvmBinaryClass.AnnotationArgumentVisitor paramAnnotationArgumentVisitor, Name paramName, ArrayList paramArrayList)
  {
    this.$$delegate_0 = paramName;
  }
  
  public void visit(@Nullable Name paramName, @Nullable Object paramObject)
  {
    this.$$delegate_0.visit(paramName, paramObject);
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name paramName, @NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    return this.$$delegate_0.visitAnnotation(paramName, paramClassId);
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return this.$$delegate_0.visitArray(paramName);
  }
  
  public void visitClassLiteral(@NotNull Name paramName, @NotNull ClassLiteralValue paramClassLiteralValue)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramClassLiteralValue, "value");
    this.$$delegate_0.visitClassLiteral(paramName, paramClassLiteralValue);
  }
  
  public void visitEnd()
  {
    this.$visitor.visitEnd();
    ((Map)BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.access$getArguments$p(this.this$0)).put(this.$name, new AnnotationValue((AnnotationDescriptor)CollectionsKt.single((List)this.$list)));
  }
  
  public void visitEnum(@NotNull Name paramName1, @NotNull ClassId paramClassId, @NotNull Name paramName2)
  {
    Intrinsics.checkParameterIsNotNull(paramName1, "name");
    Intrinsics.checkParameterIsNotNull(paramClassId, "enumClassId");
    Intrinsics.checkParameterIsNotNull(paramName2, "enumEntryName");
    this.$$delegate_0.visitEnum(paramName1, paramClassId, paramName2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.visitAnnotation.1
 * JD-Core Version:    0.7.0.1
 */