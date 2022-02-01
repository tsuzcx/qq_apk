package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1
  extends Lambda
  implements Function0<SimpleType>
{
  JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1(JvmBuiltInsSettings paramJvmBuiltInsSettings)
  {
    super(0);
  }
  
  @NotNull
  public final SimpleType invoke()
  {
    SimpleType localSimpleType = JvmBuiltInsSettings.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType();
    Intrinsics.checkExpressionValueIsNotNull(localSimpleType, "moduleDescriptor.builtIns.anyType");
    return localSimpleType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.createMockJavaIoSerializableType.superTypes.1
 * JD-Core Version:    0.7.0.1
 */