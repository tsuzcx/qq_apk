package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "invoke"}, k=3, mv={1, 1, 16})
final class KPackageImpl$Data$scope$2
  extends Lambda
  implements Function0<MemberScope>
{
  KPackageImpl$Data$scope$2(KPackageImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final MemberScope invoke()
  {
    ReflectKotlinClass localReflectKotlinClass = KPackageImpl.Data.access$getKotlinClass$p(this.this$0);
    if (localReflectKotlinClass != null) {
      return this.this$0.getModuleData().getPackagePartScopeCache().getPackagePartScope(localReflectKotlinClass);
    }
    return (MemberScope)MemberScope.Empty.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl.Data.scope.2
 * JD-Core Version:    0.7.0.1
 */