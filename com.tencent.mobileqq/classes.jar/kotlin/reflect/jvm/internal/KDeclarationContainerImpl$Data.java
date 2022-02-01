package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class KDeclarationContainerImpl$Data
{
  @NotNull
  private final ReflectProperties.LazySoftVal moduleData$delegate = ReflectProperties.lazySoft((Function0)new KDeclarationContainerImpl.Data.moduleData.2(this));
  
  @NotNull
  public final RuntimeModuleData getModuleData()
  {
    return (RuntimeModuleData)this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data
 * JD-Core Version:    0.7.0.1
 */