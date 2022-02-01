package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class PackageFragmentProviderImpl$getSubPackagesOf$2
  extends Lambda
  implements Function1<FqName, Boolean>
{
  PackageFragmentProviderImpl$getSubPackagesOf$2(FqName paramFqName)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "it");
    return (!paramFqName.isRoot()) && (Intrinsics.areEqual(paramFqName.parent(), this.$fqName));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl.getSubPackagesOf.2
 * JD-Core Version:    0.7.0.1
 */