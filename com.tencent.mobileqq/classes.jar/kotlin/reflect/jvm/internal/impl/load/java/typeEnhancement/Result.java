package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class Result
{
  private final int subtreeSize;
  @NotNull
  private final KotlinType type;
  private final boolean wereChanges;
  
  public Result(@NotNull KotlinType paramKotlinType, int paramInt, boolean paramBoolean)
  {
    this.type = paramKotlinType;
    this.subtreeSize = paramInt;
    this.wereChanges = paramBoolean;
  }
  
  public final int getSubtreeSize()
  {
    return this.subtreeSize;
  }
  
  @NotNull
  public KotlinType getType()
  {
    return this.type;
  }
  
  @Nullable
  public final KotlinType getTypeIfChanged()
  {
    KotlinType localKotlinType = getType();
    if (this.wereChanges) {
      return localKotlinType;
    }
    return null;
  }
  
  public final boolean getWereChanges()
  {
    return this.wereChanges;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.Result
 * JD-Core Version:    0.7.0.1
 */