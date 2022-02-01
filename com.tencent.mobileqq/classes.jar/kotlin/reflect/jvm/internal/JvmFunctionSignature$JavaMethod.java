package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmFunctionSignature$JavaMethod
  extends JvmFunctionSignature
{
  @NotNull
  private final Method method;
  
  public JvmFunctionSignature$JavaMethod(@NotNull Method paramMethod)
  {
    super(null);
    this.method = paramMethod;
  }
  
  @NotNull
  public String asString()
  {
    return RuntimeTypeMapperKt.access$getSignature$p(this.method);
  }
  
  @NotNull
  public final Method getMethod()
  {
    return this.method;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod
 * JD-Core Version:    0.7.0.1
 */