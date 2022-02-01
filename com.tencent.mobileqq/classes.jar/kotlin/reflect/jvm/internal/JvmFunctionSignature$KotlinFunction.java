package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmFunctionSignature$KotlinFunction
  extends JvmFunctionSignature
{
  private final String _signature;
  @NotNull
  private final JvmMemberSignature.Method signature;
  
  public JvmFunctionSignature$KotlinFunction(@NotNull JvmMemberSignature.Method paramMethod)
  {
    super(null);
    this.signature = paramMethod;
    this._signature = this.signature.asString();
  }
  
  @NotNull
  public String asString()
  {
    return this._signature;
  }
  
  @NotNull
  public final String getMethodDesc()
  {
    return this.signature.getDesc();
  }
  
  @NotNull
  public final String getMethodName()
  {
    return this.signature.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction
 * JD-Core Version:    0.7.0.1
 */