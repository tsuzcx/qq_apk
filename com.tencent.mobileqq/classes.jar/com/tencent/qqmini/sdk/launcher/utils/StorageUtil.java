package com.tencent.qqmini.sdk.launcher.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;

public class StorageUtil
{
  public static long getDirUsedSpace(String paramString)
  {
    long l1 = 0L;
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = l1;
    }
    do
    {
      return l2;
      paramString = new File(paramString);
      if (paramString.isFile()) {
        return paramString.length();
      }
      paramString = paramString.listFiles();
      l2 = l1;
    } while (paramString == null);
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      Object localObject = paramString[i];
      l2 = l1;
      if (localObject != null) {
        l2 = l1 + getDirUsedSpace(localObject.getAbsolutePath());
      }
      i += 1;
      l1 = l2;
    }
  }
  
  public static SharedPreferences getPreference()
  {
    return SharedPreferencesUtil.getPreference();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.StorageUtil
 * JD-Core Version:    0.7.0.1
 */