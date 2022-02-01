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
    if (!(paramObject instanceof CGSize)) {
      return false;
    }
    if ((((CGSize)paramObject).width == this.width) && (((CGSize)paramObject).height == this.height)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String toString()
  {
    return "[" + this.width + "," + this.height + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGSize
 * JD-Core Version:    0.7.0.1
 */