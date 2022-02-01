package com.tencent.open.base.img;

public class ImageInfo
{
  public String a;
  public String b;
  public long c = 259200L;
  public long d;
  public long e;
  public String f;
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ImageInfo)paramObject;
    if (paramObject != null) {
      return paramObject.a.equals(this.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.img.ImageInfo
 * JD-Core Version:    0.7.0.1
 */