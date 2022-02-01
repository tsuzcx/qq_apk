package com.tencent.ttpic.openapi.manager;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFaceBeautyBase;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Map;

public class FaceBeautyManager
{
  private static Map<String, Class> faceBeautys = new HashMap();
  
  public static AEFaceBeautyBase getFaceBeautyInstance(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (AEFaceBeautyBase)((Class)faceBeautys.get(paramString)).newInstance();
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  public static boolean registerFaceBeauty(String paramString, Class paramClass)
  {
    if (faceBeautys == null) {
      faceBeautys = new HashMap();
    }
    faceBeautys.put(paramString, paramClass);
    return true;
  }
  
  public static void removeFaceBeauty(String paramString)
  {
    if ((faceBeautys != null) && (paramString != null)) {
      faceBeautys.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FaceBeautyManager
 * JD-Core Version:    0.7.0.1
 */