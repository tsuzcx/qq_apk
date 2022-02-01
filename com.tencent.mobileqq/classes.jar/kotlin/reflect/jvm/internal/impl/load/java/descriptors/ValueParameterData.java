package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class ValueParameterData
{
  private final boolean hasDefaultValue;
  @NotNull
  private final KotlinType type;
  
  public ValueParameterData(@NotNull KotlinType paramKotlinType, boolean paramBoolean)
  {
    this.type = paramKotlinType;
    this.hasDefaultValue = paramBoolean;
  }
  
  public final boolean getHasDefaultValue()
  {
    return this.hasDefaultValue;
  }
  
  @NotNull
  public final KotlinType getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData
 * JD-Core Version:    0.7.0.1
 */