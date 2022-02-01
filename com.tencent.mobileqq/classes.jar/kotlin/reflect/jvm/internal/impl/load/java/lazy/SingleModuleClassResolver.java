package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SingleModuleClassResolver
  implements ModuleClassResolver
{
  @NotNull
  public JavaDescriptorResolver resolver;
  
  @Nullable
  public ClassDescriptor resolveClass(@NotNull JavaClass paramJavaClass)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaClass, "javaClass");
    JavaDescriptorResolver localJavaDescriptorResolver = this.resolver;
    if (localJavaDescriptorResolver == null) {
      Intrinsics.throwUninitializedPropertyAccessException("resolver");
    }
    return localJavaDescriptorResolver.resolveClass(paramJavaClass);
  }
  
  public final void setResolver(@NotNull JavaDescriptorResolver paramJavaDescriptorResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaDescriptorResolver, "<set-?>");
    this.resolver = paramJavaDescriptorResolver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver
 * JD-Core Version:    0.7.0.1
 */