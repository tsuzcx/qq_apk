package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class JavaResolverCache$1
  implements JavaResolverCache
{
  @Nullable
  public ClassDescriptor getClassResolvedFromSource(@NotNull FqName paramFqName)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(0);
    }
    return null;
  }
  
  public void recordClass(@NotNull JavaClass paramJavaClass, @NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramJavaClass == null) {
      $$$reportNull$$$0(7);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(8);
    }
  }
  
  public void recordConstructor(@NotNull JavaElement paramJavaElement, @NotNull ConstructorDescriptor paramConstructorDescriptor)
  {
    if (paramJavaElement == null) {
      $$$reportNull$$$0(3);
    }
    if (paramConstructorDescriptor == null) {
      $$$reportNull$$$0(4);
    }
  }
  
  public void recordField(@NotNull JavaField paramJavaField, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    if (paramJavaField == null) {
      $$$reportNull$$$0(5);
    }
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(6);
    }
  }
  
  public void recordMethod(@NotNull JavaMethod paramJavaMethod, @NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    if (paramJavaMethod == null) {
      $$$reportNull$$$0(1);
    }
    if (paramSimpleFunctionDescriptor == null) {
      $$$reportNull$$$0(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.1
 * JD-Core Version:    0.7.0.1
 */