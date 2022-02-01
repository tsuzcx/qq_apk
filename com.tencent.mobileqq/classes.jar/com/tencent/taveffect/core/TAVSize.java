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
    if ((paramObject == null) || (!(paramObject instanceof TAVSize))) {
      return false;
    }
    return (this.width == ((TAVSize)paramObject).width) && (this.height == ((TAVSize)paramObject).height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVSize
 * JD-Core Version:    0.7.0.1
 */