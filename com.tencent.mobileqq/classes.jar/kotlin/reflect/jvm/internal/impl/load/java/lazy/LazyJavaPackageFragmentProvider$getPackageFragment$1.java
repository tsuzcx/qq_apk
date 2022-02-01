package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;

final class LazyJavaPackageFragmentProvider$getPackageFragment$1
  extends Lambda
  implements Function0<LazyJavaPackageFragment>
{
  LazyJavaPackageFragmentProvider$getPackageFragment$1(LazyJavaPackageFragmentProvider paramLazyJavaPackageFragmentProvider, JavaPackage paramJavaPackage)
  {
    super(0);
  }
  
  @NotNull
  public final LazyJavaPackageFragment invoke()
  {
    return new LazyJavaPackageFragment(LazyJavaPackageFragmentProvider.access$getC$p(this.this$0), this.$jPackage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider.getPackageFragment.1
 * JD-Core Version:    0.7.0.1
 */