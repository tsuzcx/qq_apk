package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "invoke"}, k=3, mv={1, 1, 16})
final class KDeclarationContainerImpl$Data$moduleData$2
  extends Lambda
  implements Function0<RuntimeModuleData>
{
  KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final RuntimeModuleData invoke()
  {
    return ModuleByClassLoaderKt.getOrCreateModule(this.this$0.this$0.getJClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data.moduleData.2
 * JD-Core Version:    0.7.0.1
 */