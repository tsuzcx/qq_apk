package com.tencent.xaction.drawable.partical;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/StormPartical$Point3D;", "", "x", "", "y", "vy", "z", "radius", "color", "dist", "(DDDDDDD)V", "getColor", "()D", "getDist", "setDist", "(D)V", "getRadius", "getVy", "setVy", "getX", "setX", "getY", "setY", "getZ", "setZ", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class StormPartical$Point3D
{
  private double a;
  private double b;
  private double c;
  private double d;
  private final double e;
  private final double f;
  private double g;
  
  public StormPartical$Point3D(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
    this.d = paramDouble4;
    this.e = paramDouble5;
    this.f = paramDouble6;
    this.g = paramDouble7;
  }
  
  public final double a()
  {
    return this.a;
  }
  
  public final void a(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public final double b()
  {
    return this.b;
  }
  
  public final double c()
  {
    return this.d;
  }
  
  public final double d()
  {
    return this.e;
  }
  
  public final double e()
  {
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Point3D))
      {
        paramObject = (Point3D)paramObject;
        if ((Double.compare(this.a, paramObject.a) == 0) && (Double.compare(this.b, paramObject.b) == 0) && (Double.compare(this.c, paramObject.c) == 0) && (Double.compare(this.d, paramObject.d) == 0) && (Double.compare(this.e, paramObject.e) == 0) && (Double.compare(this.f, paramObject.f) == 0) && (Double.compare(this.g, paramObject.g) == 0)) {}
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
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.d);
    int m = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.e);
    int n = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.f);
    int i1 = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.g);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Point3D(x=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", vy=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", z=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", radius=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", color=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", dist=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.StormPartical.Point3D
 * JD-Core Version:    0.7.0.1
 */