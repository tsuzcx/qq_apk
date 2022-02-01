package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmFunctionSignature$JavaConstructor
  extends JvmFunctionSignature
{
  @NotNull
  private final Constructor<?> constructor;
  
  public JvmFunctionSignature$JavaConstructor(@NotNull Constructor<?> paramConstructor)
  {
    super(null);
    this.constructor = paramConstructor;
  }
  
  @NotNull
  public String asString()
  {
    Class[] arrayOfClass = this.constructor.getParameterTypes();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "constructor.parameterTypes");
    return ArraysKt.joinToString$default(arrayOfClass, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (Function1)JvmFunctionSignature.JavaConstructor.asString.1.INSTANCE, 24, null);
  }
  
  @NotNull
  public final Constructor<?> getConstructor()
  {
    return this.constructor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor
 * JD-Core Version:    0.7.0.1
 */