package com.tencent.ttpic.baseutils.bitmap;

public class BitmapUtils$Size
{
  public int height;
  public int width;
  
  public BitmapUtils$Size(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Size{width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.bitmap.BitmapUtils.Size
 * JD-Core Version:    0.7.0.1
 */