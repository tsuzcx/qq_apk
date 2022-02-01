package com.tencent.ttpic.cache;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class CompatibleList
{
  private static boolean isFoundProduct(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return false;
      paramString2 = paramString2.split("\\|");
      if (paramString2 != null)
      {
        int j = paramString2.length;
        int i = 0;
        while (i < j)
        {
          if (paramString2[i].equalsIgnoreCase(paramString1)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isFoundProductFeature(String paramString)
  {
    String str = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    LogUtils.i("CompatibleList", "feature:" + str);
    return isFoundProduct(str, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.cache.CompatibleList
 * JD-Core Version:    0.7.0.1
 */