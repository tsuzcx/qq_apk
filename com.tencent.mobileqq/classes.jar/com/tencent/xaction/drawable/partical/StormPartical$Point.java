package com.tencent.xaction.drawable.partical;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/StormPartical$Point;", "", "x", "", "y", "d", "(DDD)V", "getD", "()D", "setD", "(D)V", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class StormPartical$Point
{
  private double a;
  private double b;
  private double c;
  
  public StormPartical$Point(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
  }
  
  public final double a()
  {
    return this.a;
  }
  
  public final double b()
  {
    return this.b;
  }
  
  public final double c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Point))
      {
        paramObject = (Point)paramObject;
        if ((Double.compare(this.a, paramObject.a) == 0) && (Double.compare(this.b, paramObject.b) == 0) && (Double.compare(this.c, paramObject.c) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.a);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.c);
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Point(x=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", d=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.StormPartical.Point
 * JD-Core Version:    0.7.0.1
 */