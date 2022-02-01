package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public class TypeProjectionImpl
  extends TypeProjectionBase
{
  private final Variance projection;
  private final KotlinType type;
  
  public TypeProjectionImpl(@NotNull KotlinType paramKotlinType)
  {
    this(Variance.INVARIANT, paramKotlinType);
  }
  
  public TypeProjectionImpl(@NotNull Variance paramVariance, @NotNull KotlinType paramKotlinType)
  {
    this.projection = paramVariance;
    this.type = paramKotlinType;
  }
  
  @NotNull
  public Variance getProjectionKind()
  {
    Variance localVariance = this.projection;
    if (localVariance == null) {
      $$$reportNull$$$0(3);
    }
    return localVariance;
  }
  
  @NotNull
  public KotlinType getType()
  {
    KotlinType localKotlinType = this.type;
    if (localKotlinType == null) {
      $$$reportNull$$$0(4);
    }
    return localKotlinType;
  }
  
  public boolean isStarProjection()
  {
    return false;
  }
  
  @NotNull
  public TypeProjection refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(5);
    }
    return new TypeProjectionImpl(this.projection, paramKotlinTypeRefiner.refineType(this.type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
 * JD-Core Version:    0.7.0.1
 */