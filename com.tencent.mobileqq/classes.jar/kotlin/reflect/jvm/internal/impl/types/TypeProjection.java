package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import org.jetbrains.annotations.NotNull;

public abstract interface TypeProjection
  extends TypeArgumentMarker
{
  @NotNull
  public abstract Variance getProjectionKind();
  
  @NotNull
  public abstract KotlinType getType();
  
  public abstract boolean isStarProjection();
  
  @NotNull
  public abstract TypeProjection refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeProjection
 * JD-Core Version:    0.7.0.1
 */