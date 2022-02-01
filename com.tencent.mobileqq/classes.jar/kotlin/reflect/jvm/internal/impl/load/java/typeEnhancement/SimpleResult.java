package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class SimpleResult
  extends Result
{
  @NotNull
  private final SimpleType type;
  
  public SimpleResult(@NotNull SimpleType paramSimpleType, int paramInt, boolean paramBoolean)
  {
    super((KotlinType)paramSimpleType, paramInt, paramBoolean);
    this.type = paramSimpleType;
  }
  
  @NotNull
  public SimpleType getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult
 * JD-Core Version:    0.7.0.1
 */