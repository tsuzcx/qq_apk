package com.tencent.ttpic.cache;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class CompatibleList
{
  private static boolean isFoundProduct(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    paramString2 = paramString2.split("\\|");
    if (paramString2 == null) {
      return false;
    }
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      if (paramString2[i].equalsIgnoreCase(paramString1)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isFoundProductFeature(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feature:");
    localStringBuilder.append((String)localObject);
    LogUtils.i("CompatibleList", localStringBuilder.toString());
    return isFoundProduct((String)localObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.cache.CompatibleList
 * JD-Core Version:    0.7.0.1
 */