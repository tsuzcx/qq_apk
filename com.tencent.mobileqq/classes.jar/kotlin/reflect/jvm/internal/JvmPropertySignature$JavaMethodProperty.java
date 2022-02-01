package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmPropertySignature$JavaMethodProperty
  extends JvmPropertySignature
{
  @NotNull
  private final Method getterMethod;
  @Nullable
  private final Method setterMethod;
  
  public JvmPropertySignature$JavaMethodProperty(@NotNull Method paramMethod1, @Nullable Method paramMethod2)
  {
    super(null);
    this.getterMethod = paramMethod1;
    this.setterMethod = paramMethod2;
  }
  
  @NotNull
  public String asString()
  {
    return RuntimeTypeMapperKt.access$getSignature$p(this.getterMethod);
  }
  
  @NotNull
  public final Method getGetterMethod()
  {
    return this.getterMethod;
  }
  
  @Nullable
  public final Method getSetterMethod()
  {
    return this.setterMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty
 * JD-Core Version:    0.7.0.1
 */