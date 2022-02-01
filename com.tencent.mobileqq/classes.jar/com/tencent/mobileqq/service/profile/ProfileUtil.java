package com.tencent.mobileqq.service.profile;

public class ProfileUtil
{
  public static int a(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (paramInt & 0xFF00) >> 8;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return paramInt & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.profile.ProfileUtil
 * JD-Core Version:    0.7.0.1
 */