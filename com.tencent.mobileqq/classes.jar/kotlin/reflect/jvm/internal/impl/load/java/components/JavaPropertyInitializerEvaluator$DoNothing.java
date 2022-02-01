package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaPropertyInitializerEvaluator$DoNothing
  implements JavaPropertyInitializerEvaluator
{
  public static final DoNothing INSTANCE = new DoNothing();
  
  @Nullable
  public ConstantValue<?> getInitializerConstant(@NotNull JavaField paramJavaField, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaField, "field");
    Intrinsics.checkParameterIsNotNull(paramPropertyDescriptor, "descriptor");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator.DoNothing
 * JD-Core Version:    0.7.0.1
 */