package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaDescriptorResolver
{
  private final JavaResolverCache javaResolverCache;
  @NotNull
  private final LazyJavaPackageFragmentProvider packageFragmentProvider;
  
  public JavaDescriptorResolver(@NotNull LazyJavaPackageFragmentProvider paramLazyJavaPackageFragmentProvider, @NotNull JavaResolverCache paramJavaResolverCache)
  {
    this.packageFragmentProvider = paramLazyJavaPackageFragmentProvider;
    this.javaResolverCache = paramJavaResolverCache;
  }
  
  @NotNull
  public final LazyJavaPackageFragmentProvider getPackageFragmentProvider()
  {
    return this.packageFragmentProvider;
  }
  
  @Nullable
  public final ClassDescriptor resolveClass(@NotNull JavaClass paramJavaClass)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaClass, "javaClass");
    Object localObject2 = paramJavaClass.getFqName();
    if ((localObject2 != null) && (paramJavaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE)) {
      return this.javaResolverCache.getClassResolvedFromSource((FqName)localObject2);
    }
    Object localObject3 = paramJavaClass.getOuterClass();
    Object localObject1 = null;
    if (localObject3 != null)
    {
      localObject1 = resolveClass((JavaClass)localObject3);
      if (localObject1 != null) {
        localObject1 = ((ClassDescriptor)localObject1).getUnsubstitutedInnerClassesScope();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        paramJavaClass = ((MemberScope)localObject1).getContributedClassifier(paramJavaClass.getName(), (LookupLocation)NoLookupLocation.FROM_JAVA_LOADER);
      } else {
        paramJavaClass = null;
      }
      localObject1 = paramJavaClass;
      if (!(paramJavaClass instanceof ClassDescriptor)) {
        localObject1 = null;
      }
      return (ClassDescriptor)localObject1;
    }
    if (localObject2 == null) {
      return null;
    }
    localObject3 = this.packageFragmentProvider;
    localObject2 = ((FqName)localObject2).parent();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "fqName.parent()");
    localObject2 = (LazyJavaPackageFragment)CollectionsKt.firstOrNull(((LazyJavaPackageFragmentProvider)localObject3).getPackageFragments((FqName)localObject2));
    if (localObject2 != null) {
      localObject1 = ((LazyJavaPackageFragment)localObject2).findClassifierByJavaClass$descriptors_jvm(paramJavaClass);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver
 * JD-Core Version:    0.7.0.1
 */