package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaPrimitiveType
  extends ReflectJavaType
  implements JavaPrimitiveType
{
  @NotNull
  private final Class<?> reflectType;
  
  public ReflectJavaPrimitiveType(@NotNull Class<?> paramClass)
  {
    this.reflectType = paramClass;
  }
  
  @NotNull
  protected Class<?> getReflectType()
  {
    return this.reflectType;
  }
  
  @Nullable
  public PrimitiveType getType()
  {
    if (Intrinsics.areEqual(getReflectType(), Void.TYPE)) {
      return null;
    }
    JvmPrimitiveType localJvmPrimitiveType = JvmPrimitiveType.get(getReflectType().getName());
    Intrinsics.checkExpressionValueIsNotNull(localJvmPrimitiveType, "JvmPrimitiveType.get(reflectType.name)");
    return localJvmPrimitiveType.getPrimitiveType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPrimitiveType
 * JD-Core Version:    0.7.0.1
 */