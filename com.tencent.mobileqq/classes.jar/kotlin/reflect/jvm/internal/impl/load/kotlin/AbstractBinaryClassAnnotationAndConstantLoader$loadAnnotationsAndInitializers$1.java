package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1
  implements KotlinJvmBinaryClass.MemberVisitor
{
  AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(HashMap paramHashMap1, HashMap paramHashMap2) {}
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull Name paramName, @NotNull String paramString, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    MemberSignature.Companion localCompanion = MemberSignature.Companion;
    paramName = paramName.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramName, "name.asString()");
    paramName = localCompanion.fromFieldNameAndDesc(paramName, paramString);
    if (paramObject != null)
    {
      paramString = this.this$0.loadConstant(paramString, paramObject);
      if (paramString != null) {
        ((Map)this.$propertyConstants).put(paramName, paramString);
      }
    }
    return (KotlinJvmBinaryClass.AnnotationVisitor)new AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1.MemberAnnotationVisitor(this, paramName);
  }
  
  @Nullable
  public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull Name paramName, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    MemberSignature.Companion localCompanion = MemberSignature.Companion;
    paramName = paramName.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramName, "name.asString()");
    return (KotlinJvmBinaryClass.MethodAnnotationVisitor)new AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1.AnnotationVisitorForMethod(this, localCompanion.fromMethodNameAndDesc(paramName, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1
 * JD-Core Version:    0.7.0.1
 */