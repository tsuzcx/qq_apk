package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltIns$settings$2$1
  extends Lambda
  implements Function0<ModuleDescriptor>
{
  JvmBuiltIns$settings$2$1(JvmBuiltIns.settings.2 param2)
  {
    super(0);
  }
  
  @NotNull
  public final ModuleDescriptor invoke()
  {
    ModuleDescriptor localModuleDescriptor = JvmBuiltIns.access$getOwnerModuleDescriptor$p(this.this$0.this$0);
    if (localModuleDescriptor != null) {
      return localModuleDescriptor;
    }
    throw ((Throwable)new AssertionError("JvmBuiltins has not been initialized properly"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.settings.2.1
 * JD-Core Version:    0.7.0.1
 */