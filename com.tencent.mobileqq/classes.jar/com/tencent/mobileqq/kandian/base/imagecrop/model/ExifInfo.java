package com.tencent.mobileqq.kandian.base.imagecrop.model;

public class ExifInfo
{
  private int a;
  private int b;
  private int c;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ExifInfo)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      if (this.b != paramObject.b) {
        return false;
      }
      return this.c == paramObject.c;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a * 31 + this.b) * 31 + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.model.ExifInfo
 * JD-Core Version:    0.7.0.1
 */