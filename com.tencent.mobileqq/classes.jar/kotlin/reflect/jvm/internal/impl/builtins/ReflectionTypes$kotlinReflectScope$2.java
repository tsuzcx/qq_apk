package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

final class ReflectionTypes$kotlinReflectScope$2
  extends Lambda
  implements Function0<MemberScope>
{
  ReflectionTypes$kotlinReflectScope$2(ModuleDescriptor paramModuleDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final MemberScope invoke()
  {
    return this.$module.getPackage(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME()).getMemberScope();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.kotlinReflectScope.2
 * JD-Core Version:    0.7.0.1
 */