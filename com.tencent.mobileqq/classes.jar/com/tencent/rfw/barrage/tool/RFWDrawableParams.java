package com.tencent.rfw.barrage.tool;

public class RFWDrawableParams
{
  private String a;
  private String b;
  private int c;
  private float d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DrawableParams{mUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDefaultUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShape=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mCornerRadius=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWDrawableParams
 * JD-Core Version:    0.7.0.1
 */