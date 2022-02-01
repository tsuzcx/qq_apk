package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1
  extends Lambda
  implements Function1<ModuleDescriptor, SimpleType>
{
  AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(KotlinBuiltIns paramKotlinBuiltIns)
  {
    super(1);
  }
  
  @NotNull
  public final SimpleType invoke(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    paramModuleDescriptor = paramModuleDescriptor.getBuiltIns().getArrayType(Variance.INVARIANT, (KotlinType)this.$this_createDeprecatedAnnotation.getStringType());
    Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "module.builtIns.getArray…ce.INVARIANT, stringType)");
    return paramModuleDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt.createDeprecatedAnnotation.replaceWithAnnotation.1
 * JD-Core Version:    0.7.0.1
 */