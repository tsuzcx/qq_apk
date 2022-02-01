package com.tencent.mobileqq.magicface.magicfaceaction;

import java.math.BigDecimal;

public class MagicfacebackText
{
  public String a;
  public String b;
  public String c;
  
  public String a(int paramInt, float paramFloat)
  {
    String str = this.c;
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      str = str.replaceFirst("%param%", localStringBuilder.toString());
      paramFloat = new BigDecimal(paramFloat).setScale(1, 4).floatValue();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramFloat);
      return str.replaceFirst("%param%", localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfacebackText
 * JD-Core Version:    0.7.0.1
 */