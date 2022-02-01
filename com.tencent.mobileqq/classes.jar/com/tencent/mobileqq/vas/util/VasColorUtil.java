package com.tencent.mobileqq.vas.util;

public class VasColorUtil
{
  public static int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(paramFloat * 255.0F))) << 24) + (paramInt & 0xFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasColorUtil
 * JD-Core Version:    0.7.0.1
 */