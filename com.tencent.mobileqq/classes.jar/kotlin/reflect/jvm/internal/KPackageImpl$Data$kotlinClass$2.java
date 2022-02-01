package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "invoke"}, k=3, mv={1, 1, 16})
final class KPackageImpl$Data$kotlinClass$2
  extends Lambda
  implements Function0<ReflectKotlinClass>
{
  KPackageImpl$Data$kotlinClass$2(KPackageImpl.Data paramData)
  {
    super(0);
  }
  
  @Nullable
  public final ReflectKotlinClass invoke()
  {
    return ReflectKotlinClass.Factory.create(this.this$0.this$0.getJClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl.Data.kotlinClass.2
 * JD-Core Version:    0.7.0.1
 */