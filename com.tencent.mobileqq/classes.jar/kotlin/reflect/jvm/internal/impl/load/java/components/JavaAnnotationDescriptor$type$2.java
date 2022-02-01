package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class JavaAnnotationDescriptor$type$2
  extends Lambda
  implements Function0<SimpleType>
{
  JavaAnnotationDescriptor$type$2(JavaAnnotationDescriptor paramJavaAnnotationDescriptor, LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(0);
  }
  
  @NotNull
  public final SimpleType invoke()
  {
    ClassDescriptor localClassDescriptor = this.$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName());
    Intrinsics.checkExpressionValueIsNotNull(localClassDescriptor, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
    return localClassDescriptor.getDefaultType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor.type.2
 * JD-Core Version:    0.7.0.1
 */