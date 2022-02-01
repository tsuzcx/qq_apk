package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.List;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageFragmentProvider
  implements PackageFragmentProvider
{
  private final LazyJavaResolverContext c;
  private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;
  
  public LazyJavaPackageFragmentProvider(@NotNull JavaResolverComponents paramJavaResolverComponents)
  {
    this.c = new LazyJavaResolverContext(paramJavaResolverComponents, (TypeParameterResolver)TypeParameterResolver.EMPTY.INSTANCE, LazyKt.lazyOf(null));
    this.packageFragments = this.c.getStorageManager().createCacheWithNotNullValues();
  }
  
  private final LazyJavaPackageFragment getPackageFragment(FqName paramFqName)
  {
    JavaPackage localJavaPackage = this.c.getComponents().getFinder().findPackage(paramFqName);
    if (localJavaPackage != null) {
      return (LazyJavaPackageFragment)this.packageFragments.computeIfAbsent(paramFqName, (Function0)new LazyJavaPackageFragmentProvider.getPackageFragment.1(this, localJavaPackage));
    }
    return null;
  }
  
  @NotNull
  public List<LazyJavaPackageFragment> getPackageFragments(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return CollectionsKt.listOfNotNull(getPackageFragment(paramFqName));
  }
  
  @NotNull
  public List<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    paramFqName = getPackageFragment(paramFqName);
    if (paramFqName != null) {
      paramFqName = paramFqName.getSubPackageFqNames$descriptors_jvm();
    } else {
      paramFqName = null;
    }
    if (paramFqName != null) {
      return paramFqName;
    }
    return CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider
 * JD-Core Version:    0.7.0.1
 */