package org.light.bean;

public class SizeI
{
  public int height;
  public int width;
  
  public SizeI() {}
  
  public SizeI(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
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
      paramObject = (SizeI)paramObject;
      return (this.width == paramObject.width) && (this.height == paramObject.height);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width = ");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height = ");
    localStringBuilder.append(this.height);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.SizeI
 * JD-Core Version:    0.7.0.1
 */