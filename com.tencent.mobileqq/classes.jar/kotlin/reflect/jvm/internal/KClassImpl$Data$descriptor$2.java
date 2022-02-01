package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$descriptor$2
  extends Lambda
  implements Function0<ClassDescriptor>
{
  KClassImpl$Data$descriptor$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final ClassDescriptor invoke()
  {
    Object localObject = KClassImpl.access$getClassId$p(this.this$0.this$0);
    RuntimeModuleData localRuntimeModuleData = ((KClassImpl.Data)this.this$0.this$0.getData().invoke()).getModuleData();
    if (((ClassId)localObject).isLocal()) {
      localObject = localRuntimeModuleData.getDeserialization().deserializeClass((ClassId)localObject);
    } else {
      localObject = FindClassInModuleKt.findClassAcrossModuleDependencies(localRuntimeModuleData.getModule(), (ClassId)localObject);
    }
    if (localObject != null) {
      return localObject;
    }
    KClassImpl.access$reportUnresolvedClass(this.this$0.this$0);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.descriptor.2
 * JD-Core Version:    0.7.0.1
 */