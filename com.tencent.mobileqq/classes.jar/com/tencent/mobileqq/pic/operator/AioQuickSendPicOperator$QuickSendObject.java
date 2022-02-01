package com.tencent.mobileqq.pic.operator;

public class AioQuickSendPicOperator$QuickSendObject
{
  public String a;
  public long b;
  public String c;
  public boolean d = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QuickSendObject{mOriginMD5='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOriginSize=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mThumbMD5='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mQuickSendFailed=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator.QuickSendObject
 * JD-Core Version:    0.7.0.1
 */