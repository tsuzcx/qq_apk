package com.tencent.tav.coremedia;

public class CGSize
  implements Cloneable
{
  public static final CGSize CGSizeZero = new CGSize(0.0F, 0.0F);
  public float height;
  public float width;
  
  public CGSize()
  {
    this(1.0F, 1.0F);
  }
  
  public CGSize(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public CGSize clone()
  {
    return new CGSize(this.width, this.height);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof CGSize;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (CGSize)paramObject;
    bool1 = bool2;
    if (paramObject.width == this.width)
    {
      bool1 = bool2;
      if (paramObject.height == this.height) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.width);
    localStringBuilder.append(",");
    localStringBuilder.append(this.height);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGSize
 * JD-Core Version:    0.7.0.1
 */