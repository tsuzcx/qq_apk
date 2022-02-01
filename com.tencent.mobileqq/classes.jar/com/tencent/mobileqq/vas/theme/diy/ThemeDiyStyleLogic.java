package com.tencent.mobileqq.vas.theme.diy;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ThemeDiyStyleLogic
{
  private static String a;
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("custom_background/");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append("custom_background/");
      str = paramString;
      if (paramString.startsWith(localStringBuilder.toString())) {
        str = VFSAssistantUtils.getSDKPrivatePath(paramString);
      }
    }
    return str;
  }
  
  private static void a()
  {
    ThreadManager.getFileThreadHandler().post(new ThemeDiyStyleLogic.1());
  }
  
  public static String b()
  {
    if (a == null)
    {
      String str = MobileQQ.getContext().getFilesDir().getAbsolutePath();
      StringBuilder localStringBuilder;
      if (str.endsWith(File.separator))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("custom_background/");
        a = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("custom_background/");
        a = localStringBuilder.toString();
      }
      a();
    }
    return a;
  }
  
  private static void b(File paramFile, List<File> paramList)
  {
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (localObject.isFile()) {
          paramList.add(localObject);
        } else if (localObject.isDirectory()) {
          b(localObject, paramList);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic
 * JD-Core Version:    0.7.0.1
 */