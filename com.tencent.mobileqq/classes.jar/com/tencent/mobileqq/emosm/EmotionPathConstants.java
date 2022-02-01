package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.AppConstants;

public class EmotionPathConstants
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/QQ_Images/");
    a = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmotionPathConstants
 * JD-Core Version:    0.7.0.1
 */