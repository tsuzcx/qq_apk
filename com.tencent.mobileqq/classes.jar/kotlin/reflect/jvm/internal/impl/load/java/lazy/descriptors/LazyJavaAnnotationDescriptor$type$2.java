package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class LazyJavaAnnotationDescriptor$type$2
  extends Lambda
  implements Function0<SimpleType>
{
  LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor paramLazyJavaAnnotationDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final SimpleType invoke()
  {
    FqName localFqName = this.this$0.getFqName();
    if (localFqName != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localFqName, "fqName ?: return@createL…fqName: $javaAnnotation\")");
      localObject = JavaToKotlinClassMap.mapJavaToKotlin$default(JavaToKotlinClassMap.INSTANCE, localFqName, LazyJavaAnnotationDescriptor.access$getC$p(this.this$0).getModule().getBuiltIns(), null, 4, null);
      if (localObject == null)
      {
        localObject = LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(this.this$0).resolve();
        if (localObject != null) {
          localObject = LazyJavaAnnotationDescriptor.access$getC$p(this.this$0).getComponents().getModuleClassResolver().resolveClass((JavaClass)localObject);
        } else {
          localObject = null;
        }
      }
      if (localObject == null) {
        localObject = LazyJavaAnnotationDescriptor.access$createTypeForMissingDependencies(this.this$0, localFqName);
      }
      return ((ClassDescriptor)localObject).getDefaultType();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No fqName: ");
    ((StringBuilder)localObject).append(LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(this.this$0));
    return ErrorUtils.createErrorType(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.type.2
 * JD-Core Version:    0.7.0.1
 */