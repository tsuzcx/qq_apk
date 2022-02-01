package com.tencent.mobileqq.vfs;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VFSAssistantUtils
{
  private static final String TAG = "VFSAssistantUtils";
  private static volatile boolean hasDetectedMounted = false;
  private static boolean hasExternalStorage = false;
  
  public static String getCanonicalPath(String paramString)
  {
    return new File(paramString).getCanonicalPath();
  }
  
  public static String getSDKPrivatePath(String paramString)
  {
    if (!hasDetectedMounted) {
      try
      {
        hasExternalStorage = "mounted".equals(Environment.getExternalStorageState());
        hasDetectedMounted = true;
      }
      catch (Exception localException)
      {
        QLog.e("VFSAssistantUtils", 1, "getSDKPrivatePath is called!", localException);
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (hasExternalStorage))
    {
      String str = VFSRegisterProxy.a().a();
      Object localObject;
      if ((!paramString.startsWith("/")) && (paramString.indexOf(":") <= 0))
      {
        if (str != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(paramString);
          return ((StringBuilder)localObject).toString();
        }
      }
      else if ((str != null) && (!paramString.startsWith(str)) && (paramString.startsWith(VFSRegisterProxy.a().b())))
      {
        localObject = paramString.split(VFSRegisterProxy.a().b());
        if (localObject.length >= 2)
        {
          paramString = new StringBuilder();
          paramString.append(str);
          paramString.append(localObject[1]);
          return paramString.toString();
        }
        if (paramString.equals(VFSRegisterProxy.a().b())) {
          return str;
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.VFSAssistantUtils
 * JD-Core Version:    0.7.0.1
 */