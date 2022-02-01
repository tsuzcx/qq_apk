package com.tencent.taveffect.core;

public class TAVSize
  implements Cloneable
{
  public int height;
  public int width;
  
  public TAVSize()
  {
    this(0, 0);
  }
  
  public TAVSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public TAVSize clone()
  {
    return new TAVSize(this.width, this.height);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof TAVSize)) {
        return false;
      }
      int i = this.width;
      paramObject = (TAVSize)paramObject;
      bool1 = bool2;
      if (i == paramObject.width)
      {
        bool1 = bool2;
        if (this.height == paramObject.height) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVSize
 * JD-Core Version:    0.7.0.1
 */