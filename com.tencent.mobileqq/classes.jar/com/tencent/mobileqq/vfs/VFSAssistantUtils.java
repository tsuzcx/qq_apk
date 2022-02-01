package com.tencent.mobileqq.vfs;

import android.os.Environment;
import android.text.TextUtils;
import bhxq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VFSAssistantUtils
{
  private static final String TAG = "VFSAssistantUtils";
  private static volatile boolean hasDetectedMounted;
  private static boolean hasExternalStorage;
  
  public static String getCanonicalPath(String paramString)
  {
    return new File(paramString).getCanonicalPath();
  }
  
  public static String getSDKPrivatePath(String paramString)
  {
    if (!hasDetectedMounted) {}
    String str3;
    try
    {
      hasExternalStorage = "mounted".equals(Environment.getExternalStorageState());
      hasDetectedMounted = true;
      String str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        if (hasExternalStorage)
        {
          str3 = bhxq.a().a();
          if ((!paramString.startsWith("/")) && (paramString.indexOf(":") <= 0)) {
            break label149;
          }
          str1 = paramString;
          if (str3 != null)
          {
            str1 = paramString;
            if (!paramString.startsWith(str3))
            {
              str1 = paramString;
              if (paramString.startsWith(bhxq.a().b()))
              {
                String[] arrayOfString = paramString.split(bhxq.a().b());
                str1 = paramString;
                if (arrayOfString.length >= 2) {
                  str1 = str3 + arrayOfString[1];
                }
              }
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      label149:
      do
      {
        for (;;)
        {
          QLog.e("VFSAssistantUtils", 1, "getSDKPrivatePath is called!", localException);
        }
        String str2 = paramString;
      } while (str3 == null);
    }
    return str3 + File.separator + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.VFSAssistantUtils
 * JD-Core Version:    0.7.0.1
 */