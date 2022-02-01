package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.MD5;

public class CameraEmoConstant
{
  public static int a = 300;
  
  public static String a(String paramString)
  {
    if (StringUtil.a(paramString)) {
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
    if ((StringUtil.a(paramString1)) || (StringUtil.a(paramString2))) {
      return "";
    }
    paramString2 = MD5.a(paramString2);
    return AppConstants.SDCARD_IMG_CAMERA_EMO + paramString2 + paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoConstant
 * JD-Core Version:    0.7.0.1
 */