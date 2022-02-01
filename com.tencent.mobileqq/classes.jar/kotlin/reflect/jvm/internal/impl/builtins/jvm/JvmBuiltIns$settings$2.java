package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltIns$settings$2
  extends Lambda
  implements Function0<JvmBuiltInsSettings>
{
  JvmBuiltIns$settings$2(JvmBuiltIns paramJvmBuiltIns, StorageManager paramStorageManager)
  {
    super(0);
  }
  
  @NotNull
  public final JvmBuiltInsSettings invoke()
  {
    ModuleDescriptorImpl localModuleDescriptorImpl = this.this$0.getBuiltInsModule();
    Intrinsics.checkExpressionValueIsNotNull(localModuleDescriptorImpl, "builtInsModule");
    return new JvmBuiltInsSettings((ModuleDescriptor)localModuleDescriptorImpl, this.$storageManager, (Function0)new JvmBuiltIns.settings.2.1(this), (Function0)new JvmBuiltIns.settings.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.settings.2
 * JD-Core Version:    0.7.0.1
 */