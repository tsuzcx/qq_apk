package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class PackageFragmentProviderImpl$getSubPackagesOf$1
  extends Lambda
  implements Function1<PackageFragmentDescriptor, FqName>
{
  public static final 1 INSTANCE = new 1();
  
  PackageFragmentProviderImpl$getSubPackagesOf$1()
  {
    super(1);
  }
  
  @NotNull
  public final FqName invoke(@NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramPackageFragmentDescriptor, "it");
    return paramPackageFragmentDescriptor.getFqName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl.getSubPackagesOf.1
 * JD-Core Version:    0.7.0.1
 */