package com.tencent.mobileqq.shortvideo.mediadevice;

public class CameraControl$CustomSize
{
  public int a;
  public int b;
  private double c;
  
  public CameraControl$CustomSize() {}
  
  public CameraControl$CustomSize(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.c = (d1 / d2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CustomSize)) {
      return false;
    }
    paramObject = (CustomSize)paramObject;
    return (this.a == paramObject.a) && (this.b == paramObject.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomSize[width=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scaleWH='");
    localStringBuilder.append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize
 * JD-Core Version:    0.7.0.1
 */