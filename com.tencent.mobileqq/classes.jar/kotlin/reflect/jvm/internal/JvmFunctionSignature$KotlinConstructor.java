package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmFunctionSignature$KotlinConstructor
  extends JvmFunctionSignature
{
  private final String _signature;
  @NotNull
  private final JvmMemberSignature.Method signature;
  
  public JvmFunctionSignature$KotlinConstructor(@NotNull JvmMemberSignature.Method paramMethod)
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
  public final String getConstructorDesc()
  {
    return this.signature.getDesc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor
 * JD-Core Version:    0.7.0.1
 */