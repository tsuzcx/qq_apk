package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class ConstantValueFactory$createArrayValue$1
  extends Lambda
  implements Function1<ModuleDescriptor, KotlinType>
{
  ConstantValueFactory$createArrayValue$1(KotlinType paramKotlinType)
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "it");
    return this.$type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.createArrayValue.1
 * JD-Core Version:    0.7.0.1
 */