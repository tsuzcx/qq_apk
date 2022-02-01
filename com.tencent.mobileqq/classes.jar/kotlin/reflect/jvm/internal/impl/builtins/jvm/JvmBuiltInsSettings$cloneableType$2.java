package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$cloneableType$2
  extends Lambda
  implements Function0<SimpleType>
{
  JvmBuiltInsSettings$cloneableType$2(JvmBuiltInsSettings paramJvmBuiltInsSettings, StorageManager paramStorageManager)
  {
    super(0);
  }
  
  @NotNull
  public final SimpleType invoke()
  {
    return FindClassInModuleKt.findNonGenericClassAcrossDependencies(JvmBuiltInsSettings.access$getOwnerModuleDescriptor$p(this.this$0), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses(this.$storageManager, JvmBuiltInsSettings.access$getOwnerModuleDescriptor$p(this.this$0))).getDefaultType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.cloneableType.2
 * JD-Core Version:    0.7.0.1
 */