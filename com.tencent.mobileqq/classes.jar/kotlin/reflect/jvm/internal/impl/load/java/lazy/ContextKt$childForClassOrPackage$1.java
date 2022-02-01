package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import org.jetbrains.annotations.Nullable;

final class ContextKt$childForClassOrPackage$1
  extends Lambda
  implements Function0<JavaTypeQualifiersByElementType>
{
  ContextKt$childForClassOrPackage$1(LazyJavaResolverContext paramLazyJavaResolverContext, ClassOrPackageFragmentDescriptor paramClassOrPackageFragmentDescriptor)
  {
    super(0);
  }
  
  @Nullable
  public final JavaTypeQualifiersByElementType invoke()
  {
    return ContextKt.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForClassOrPackage.1
 * JD-Core Version:    0.7.0.1
 */