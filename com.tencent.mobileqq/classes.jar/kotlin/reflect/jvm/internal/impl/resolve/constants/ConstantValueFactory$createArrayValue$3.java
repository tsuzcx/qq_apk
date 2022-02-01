package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class ConstantValueFactory$createArrayValue$3
  extends Lambda
  implements Function1<ModuleDescriptor, SimpleType>
{
  ConstantValueFactory$createArrayValue$3(PrimitiveType paramPrimitiveType)
  {
    super(1);
  }
  
  @NotNull
  public final SimpleType invoke(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    paramModuleDescriptor = paramModuleDescriptor.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
    Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "module.builtIns.getPrimi…KotlinType(componentType)");
    return paramModuleDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.createArrayValue.3
 * JD-Core Version:    0.7.0.1
 */