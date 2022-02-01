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

public abstract interface JavaResolverCache
{
  public static final JavaResolverCache EMPTY = new JavaResolverCache.1();
  
  @Nullable
  public abstract ClassDescriptor getClassResolvedFromSource(@NotNull FqName paramFqName);
  
  public abstract void recordClass(@NotNull JavaClass paramJavaClass, @NotNull ClassDescriptor paramClassDescriptor);
  
  public abstract void recordConstructor(@NotNull JavaElement paramJavaElement, @NotNull ConstructorDescriptor paramConstructorDescriptor);
  
  public abstract void recordField(@NotNull JavaField paramJavaField, @NotNull PropertyDescriptor paramPropertyDescriptor);
  
  public abstract void recordMethod(@NotNull JavaMethod paramJavaMethod, @NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache
 * JD-Core Version:    0.7.0.1
 */