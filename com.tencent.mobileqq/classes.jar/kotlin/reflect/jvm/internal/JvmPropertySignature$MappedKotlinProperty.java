package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmPropertySignature$MappedKotlinProperty
  extends JvmPropertySignature
{
  @NotNull
  private final JvmFunctionSignature.KotlinFunction getterSignature;
  @Nullable
  private final JvmFunctionSignature.KotlinFunction setterSignature;
  
  public JvmPropertySignature$MappedKotlinProperty(@NotNull JvmFunctionSignature.KotlinFunction paramKotlinFunction1, @Nullable JvmFunctionSignature.KotlinFunction paramKotlinFunction2)
  {
    super(null);
    this.getterSignature = paramKotlinFunction1;
    this.setterSignature = paramKotlinFunction2;
  }
  
  @NotNull
  public String asString()
  {
    return this.getterSignature.asString();
  }
  
  @NotNull
  public final JvmFunctionSignature.KotlinFunction getGetterSignature()
  {
    return this.getterSignature;
  }
  
  @Nullable
  public final JvmFunctionSignature.KotlinFunction getSetterSignature()
  {
    return this.setterSignature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty
 * JD-Core Version:    0.7.0.1
 */