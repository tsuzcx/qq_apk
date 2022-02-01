package com.tencent.qqcamerakit.capture;

public class CameraSize
{
  private double a;
  public int a;
  public int b;
  
  public CameraSize() {}
  
  public CameraSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.jdField_a_of_type_Double = (d1 / d2);
  }
  
  public double a()
  {
    if (this.jdField_a_of_type_Double == 0.0D)
    {
      double d1 = this.jdField_a_of_type_Int;
      double d2 = this.b;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.jdField_a_of_type_Double = (d1 / d2);
    }
    return this.jdField_a_of_type_Double;
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
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraSize[width = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", height = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scaleWH = ");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraSize
 * JD-Core Version:    0.7.0.1
 */