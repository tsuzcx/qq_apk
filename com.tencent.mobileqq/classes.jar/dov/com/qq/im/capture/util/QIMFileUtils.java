package dov.com.qq.im.capture.util;

import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.os.Environment;
import anor;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import mqq.os.MqqHandler;

public class QIMFileUtils
{
  public static File a()
  {
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    if (i != 0) {
      return new File(AppConstants.aJ);
    }
    return BaseApplicationImpl.getApplication().getCacheDir();
  }
  
  public static String a(File paramFile, String paramString)
  {
    paramFile = new File(paramFile + File.separator + paramString);
    if (paramFile.exists())
    {
      paramFile = FileUtils.a(paramFile);
      if ((paramFile == null) || (paramFile.length <= 0)) {
        return null;
      }
      if (Build.VERSION.SDK_INT <= 8) {
        return new String(paramFile);
      }
      try
      {
        paramFile = new String(paramFile, "UTF-8");
        return paramFile;
      }
      catch (UnsupportedEncodingException paramFile)
      {
        if (QLog.isDevelopLevel()) {
          paramFile.printStackTrace();
        }
        return null;
      }
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str1 = "";
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getAssets().open(paramString);
        localObject1 = paramString;
        localObject2 = paramString;
        String str2 = Util.a(paramString);
        localObject1 = str2;
        localObject2 = localObject1;
      }
      catch (IOException paramString)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject1;
        paramString.printStackTrace();
        localObject2 = str1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          return "";
        }
        catch (Exception paramString)
        {
          localObject2 = str1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString.printStackTrace();
        return "";
      }
      finally
      {
        if (localObject2 == null) {
          break label113;
        }
      }
      try
      {
        paramString.close();
        localObject2 = localObject1;
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString.printStackTrace();
        return localObject1;
      }
    }
    return localObject2;
    try
    {
      ((InputStream)localObject2).close();
      label113:
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static void a(File paramFile, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new anor(paramFile, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.util.QIMFileUtils
 * JD-Core Version:    0.7.0.1
 */