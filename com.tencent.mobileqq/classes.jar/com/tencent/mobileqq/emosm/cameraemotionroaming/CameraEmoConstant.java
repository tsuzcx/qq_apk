package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.MD5;

public class CameraEmoConstant
{
  public static int a = 300;
  
  public static String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length > 2) {
      return paramString[1];
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!StringUtil.isEmpty(paramString1)) && (!StringUtil.isEmpty(paramString2)))
    {
      paramString2 = MD5.b(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_IMG_CAMERA_EMO);
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoConstant
 * JD-Core Version:    0.7.0.1
 */