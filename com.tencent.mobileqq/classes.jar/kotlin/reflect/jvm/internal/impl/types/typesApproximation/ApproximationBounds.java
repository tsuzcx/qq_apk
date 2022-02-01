package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ApproximationBounds<T>
{
  private final T lower;
  private final T upper;
  
  public ApproximationBounds(T paramT1, T paramT2)
  {
    this.lower = paramT1;
    this.upper = paramT2;
  }
  
  public final T component1()
  {
    return this.lower;
  }
  
  public final T component2()
  {
    return this.upper;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ApproximationBounds))
      {
        paramObject = (ApproximationBounds)paramObject;
        if ((Intrinsics.areEqual(this.lower, paramObject.lower)) && (Intrinsics.areEqual(this.upper, paramObject.upper))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final T getLower()
  {
    return this.lower;
  }
  
  public final T getUpper()
  {
    return this.upper;
  }
  
  public int hashCode()
  {
    Object localObject = this.lower;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.upper;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApproximationBounds(lower=");
    localStringBuilder.append(this.lower);
    localStringBuilder.append(", upper=");
    localStringBuilder.append(this.upper);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
 * JD-Core Version:    0.7.0.1
 */