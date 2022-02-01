package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaPropertyInitializerEvaluator
{
  @Nullable
  public abstract ConstantValue<?> getInitializerConstant(@NotNull JavaField paramJavaField, @NotNull PropertyDescriptor paramPropertyDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
 * JD-Core Version:    0.7.0.1
 */