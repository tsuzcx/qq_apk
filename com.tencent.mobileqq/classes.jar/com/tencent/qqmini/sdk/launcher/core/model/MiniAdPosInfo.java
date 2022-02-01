package com.tencent.qqmini.sdk.launcher.core.model;

public class MiniAdPosInfo
{
  public int height;
  public int left;
  public int top;
  public int width;
  
  public MiniAdPosInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAdPosInfo{left=");
    localStringBuilder.append(this.left);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.top);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo
 * JD-Core Version:    0.7.0.1
 */