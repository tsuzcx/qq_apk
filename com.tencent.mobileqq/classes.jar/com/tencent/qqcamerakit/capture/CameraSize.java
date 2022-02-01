package com.tencent.qqcamerakit.capture;

public class CameraSize
{
  public int a;
  public int b;
  private double c;
  
  public CameraSize() {}
  
  public CameraSize(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.c = (d1 / d2);
  }
  
  public double a()
  {
    if (this.c == 0.0D)
    {
      double d1 = this.a;
      double d2 = this.b;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.c = (d1 / d2);
    }
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CameraSize)) {
      return false;
    }
    paramObject = (CameraSize)paramObject;
    return (this.a == paramObject.a) && (this.b == paramObject.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraSize[width = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", height = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scaleWH = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraSize
 * JD-Core Version:    0.7.0.1
 */