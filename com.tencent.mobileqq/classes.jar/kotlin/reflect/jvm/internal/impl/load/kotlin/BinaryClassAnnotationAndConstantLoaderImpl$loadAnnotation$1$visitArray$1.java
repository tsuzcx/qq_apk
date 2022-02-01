package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1
  implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
{
  private final ArrayList<ConstantValue<?>> elements = new ArrayList();
  
  BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1(Name paramName) {}
  
  public void visit(@Nullable Object paramObject)
  {
    this.elements.add(BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.access$createConstant(this.this$0, this.$name, paramObject));
  }
  
  public void visitClassLiteral(@NotNull ClassLiteralValue paramClassLiteralValue)
  {
    Intrinsics.checkParameterIsNotNull(paramClassLiteralValue, "value");
    this.elements.add(new KClassValue(paramClassLiteralValue));
  }
  
  public void visitEnd()
  {
    Object localObject = DescriptorResolverUtils.getAnnotationParameterByName(this.$name, this.this$0.$annotationClass);
    if (localObject != null)
    {
      Map localMap = (Map)BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.access$getArguments$p(this.this$0);
      Name localName = this.$name;
      ConstantValueFactory localConstantValueFactory = ConstantValueFactory.INSTANCE;
      List localList = CollectionsKt.compact(this.elements);
      localObject = ((ValueParameterDescriptor)localObject).getType();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "parameter.type");
      localMap.put(localName, localConstantValueFactory.createArrayValue(localList, (KotlinType)localObject));
    }
  }
  
  public void visitEnum(@NotNull ClassId paramClassId, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "enumClassId");
    Intrinsics.checkParameterIsNotNull(paramName, "enumEntryName");
    this.elements.add(new EnumValue(paramClassId, paramName));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1.visitArray.1
 * JD-Core Version:    0.7.0.1
 */