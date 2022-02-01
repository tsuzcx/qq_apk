package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import org.jetbrains.annotations.Nullable;

final class LazyJavaPackageScope$knownClassNamesInPackage$1
  extends Lambda
  implements Function0<Set<? extends String>>
{
  LazyJavaPackageScope$knownClassNamesInPackage$1(LazyJavaPackageScope paramLazyJavaPackageScope, LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(0);
  }
  
  @Nullable
  public final Set<String> invoke()
  {
    return this.$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.getOwnerDescriptor().getFqName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.knownClassNamesInPackage.1
 * JD-Core Version:    0.7.0.1
 */