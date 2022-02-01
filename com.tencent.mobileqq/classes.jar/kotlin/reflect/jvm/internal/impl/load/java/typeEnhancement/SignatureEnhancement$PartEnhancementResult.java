package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

class SignatureEnhancement$PartEnhancementResult
{
  private final boolean containsFunctionN;
  @NotNull
  private final KotlinType type;
  private final boolean wereChanges;
  
  public SignatureEnhancement$PartEnhancementResult(@NotNull KotlinType paramKotlinType, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramKotlinType;
    this.wereChanges = paramBoolean1;
    this.containsFunctionN = paramBoolean2;
  }
  
  public final boolean getContainsFunctionN()
  {
    return this.containsFunctionN;
  }
  
  @NotNull
  public final KotlinType getType()
  {
    return this.type;
  }
  
  public final boolean getWereChanges()
  {
    return this.wereChanges;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.PartEnhancementResult
 * JD-Core Version:    0.7.0.1
 */