package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1
  extends Lambda
  implements Function1<ModuleDescriptor, KotlinType>
{
  public static final 1 INSTANCE = new 1();
  
  JavaAnnotationTargetMapper$mapJavaTargetArguments$1()
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    paramModuleDescriptor = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), paramModuleDescriptor.getBuiltIns().getBuiltInClassByFqName(KotlinBuiltIns.FQ_NAMES.target));
    if (paramModuleDescriptor != null)
    {
      paramModuleDescriptor = paramModuleDescriptor.getType();
      if (paramModuleDescriptor != null) {
        return paramModuleDescriptor;
      }
    }
    paramModuleDescriptor = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
    Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
    return (KotlinType)paramModuleDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.mapJavaTargetArguments.1
 * JD-Core Version:    0.7.0.1
 */