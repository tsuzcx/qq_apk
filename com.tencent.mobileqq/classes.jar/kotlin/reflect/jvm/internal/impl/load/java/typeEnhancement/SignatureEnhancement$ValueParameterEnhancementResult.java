package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancement$ValueParameterEnhancementResult
  extends SignatureEnhancement.PartEnhancementResult
{
  private final boolean hasDefaultValue;
  
  public SignatureEnhancement$ValueParameterEnhancementResult(@NotNull KotlinType paramKotlinType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramKotlinType, paramBoolean2, paramBoolean3);
    this.hasDefaultValue = paramBoolean1;
  }
  
  public final boolean getHasDefaultValue()
  {
    return this.hasDefaultValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.ValueParameterEnhancementResult
 * JD-Core Version:    0.7.0.1
 */