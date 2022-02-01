package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1
  implements KotlinJvmBinaryClass.AnnotationArgumentVisitor
{
  private final HashMap<Name, ConstantValue<?>> arguments = new HashMap();
  
  BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(ClassDescriptor paramClassDescriptor, List paramList, SourceElement paramSourceElement) {}
  
  private final ConstantValue<?> createConstant(Name paramName, Object paramObject)
  {
    paramObject = ConstantValueFactory.INSTANCE.createConstantValue(paramObject);
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = ErrorValue.Companion;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported annotation argument: ");
    localStringBuilder.append(paramName);
    return (ConstantValue)paramObject.create(localStringBuilder.toString());
  }
  
  public void visit(@Nullable Name paramName, @Nullable Object paramObject)
  {
    if (paramName != null) {
      ((Map)this.arguments).put(paramName, createConstant(paramName, paramObject));
    }
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name paramName, @NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    ArrayList localArrayList = new ArrayList();
    BinaryClassAnnotationAndConstantLoaderImpl localBinaryClassAnnotationAndConstantLoaderImpl = this.this$0;
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
    paramClassId = localBinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(paramClassId, localSourceElement, (List)localArrayList);
    if (paramClassId == null) {
      Intrinsics.throwNpe();
    }
    return (KotlinJvmBinaryClass.AnnotationArgumentVisitor)new BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.visitAnnotation.1(this, paramClassId, paramName, localArrayList);
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return (KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor)new BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.visitArray.1(this, paramName);
  }
  
  public void visitClassLiteral(@NotNull Name paramName, @NotNull ClassLiteralValue paramClassLiteralValue)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramClassLiteralValue, "value");
    ((Map)this.arguments).put(paramName, new KClassValue(paramClassLiteralValue));
  }
  
  public void visitEnd()
  {
    this.$result.add(new AnnotationDescriptorImpl((KotlinType)this.$annotationClass.getDefaultType(), (Map)this.arguments, this.$source));
  }
  
  public void visitEnum(@NotNull Name paramName1, @NotNull ClassId paramClassId, @NotNull Name paramName2)
  {
    Intrinsics.checkParameterIsNotNull(paramName1, "name");
    Intrinsics.checkParameterIsNotNull(paramClassId, "enumClassId");
    Intrinsics.checkParameterIsNotNull(paramName2, "enumEntryName");
    ((Map)this.arguments).put(paramName1, new EnumValue(paramClassId, paramName2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1
 * JD-Core Version:    0.7.0.1
 */