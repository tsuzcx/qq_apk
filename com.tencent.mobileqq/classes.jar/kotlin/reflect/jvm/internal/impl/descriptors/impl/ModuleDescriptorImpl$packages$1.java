package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class ModuleDescriptorImpl$packages$1
  extends Lambda
  implements Function1<FqName, LazyPackageViewDescriptorImpl>
{
  ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl paramModuleDescriptorImpl)
  {
    super(1);
  }
  
  @NotNull
  public final LazyPackageViewDescriptorImpl invoke(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    ModuleDescriptorImpl localModuleDescriptorImpl = this.this$0;
    return new LazyPackageViewDescriptorImpl(localModuleDescriptorImpl, paramFqName, ModuleDescriptorImpl.access$getStorageManager$p(localModuleDescriptorImpl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.packages.1
 * JD-Core Version:    0.7.0.1
 */