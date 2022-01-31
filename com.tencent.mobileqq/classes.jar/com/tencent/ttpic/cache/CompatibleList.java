package com.tencent.ttpic.cache;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;

public class CompatibleList
{
  private static boolean isFoundProduct(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString2 == null) {}
    for (;;)
    {
      return false;
      paramString2 = paramString2.split("\\|");
      if (paramString2 == null) {
        return false;
      }
      int j = paramString2.length;
      while (i < j)
      {
        if (paramString2[i].equalsIgnoreCase(paramString1)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isFoundProductFeature(String paramString)
  {
    String str = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    Log.i("CompatibleList", "feature:" + str);
    return isFoundProduct(str, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.CompatibleList
 * JD-Core Version:    0.7.0.1
 */