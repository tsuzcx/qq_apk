package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SimpleData;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class SimpleUIManager
{
  protected static String a;
  
  public static void a(Context paramContext)
  {
    String str = d(paramContext);
    QLog.d("SimpleUIManager", 1, "start deleteSkinRootPath");
    if (str == null)
    {
      QLog.d("SimpleUIManager", 1, "deleteSkinRootPath, name is null");
      return;
    }
    paramContext = new ThemeLocator().a("1001").a(paramContext, "simpleSkin", str).g();
    if (!new File(paramContext).exists())
    {
      QLog.d("SimpleUIManager", 1, "deleteSkinRootPath, path not exit");
      return;
    }
    FileUtils.deleteDirectory(paramContext);
  }
  
  public static boolean a()
  {
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.startup.step.InitSkin");
      boolean bool = ((Boolean)localClass.getField("sInited").get(localClass)).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("SimpleUIManager", 1, "invoke init engine error : ", localException);
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    String str = f(paramContext);
    File localFile1 = new File(str);
    File localFile2 = localFile1.getParentFile();
    if (!localFile2.exists()) {
      localFile2.mkdirs();
    }
    if (localFile1.exists()) {
      localFile1.delete();
    }
    return FileUtils.copyAssetToFile(paramContext, paramString, str);
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = a(paramContext, paramString2);
    if (!bool)
    {
      QLog.d("SimpleUIManager", 1, new Object[] { "copyAssetResult : ", Boolean.valueOf(bool) });
      return false;
    }
    try
    {
      FileUtils.uncompressZip(f(paramContext), paramString1, false);
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.d("SimpleUIManager", 1, "uncompressZipEntry error : ", paramContext);
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    e(paramContext);
    return a;
  }
  
  public static void b()
  {
    if (MobileQQ.sProcessId == 1) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.startup.step.InitSkin");
      localClass.getMethod("startInitSkinEngine", new Class[0]).invoke(localClass, new Object[0]);
      QLog.d("SimpleUIManager", 1, "initSkinEngine success");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SimpleUIManager", 1, "invoke init engine error : ", localException);
    }
  }
  
  public static boolean c(Context paramContext)
  {
    e(paramContext);
    SimpleData localSimpleData = new SimpleData();
    localSimpleData.a = a;
    return SkinEngine.getInstances().switchToSimpleModel(paramContext, localSimpleData);
  }
  
  protected static String d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getAssets().list("simpleTheme");
      if (paramContext.length == 0)
      {
        QLog.d("SimpleUIManager", 1, "list length is 0");
        return null;
      }
      paramContext = paramContext[0].split("\\.");
      QLog.d("SimpleUIManager", 1, new Object[] { "getThemeZipMd5 : ", paramContext[0] });
      paramContext = paramContext[0];
      return paramContext;
    }
    catch (IOException paramContext)
    {
      QLog.d("SimpleUIManager", 1, "getThemeZipName error : ", paramContext);
    }
    return null;
  }
  
  private static void e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        String str1 = d(paramContext);
        if (str1 == null)
        {
          ThemeSwitcher.a("1000", "205", null);
          return;
        }
        String str2 = new ThemeLocator().a("1001").a(paramContext, "simpleSkin", str1).g();
        File localFile1 = new File(str2);
        a = str2;
        QLog.d("SimpleUIManager", 1, new Object[] { "unzipResZip, rootPath : ", str2 });
        if (!localFile1.exists())
        {
          QLog.d("SimpleUIManager", 1, "dest file not exit");
          str2 = new ThemeLocator().a("1001").a(paramContext, "simpleSkin", "tmpDir").g();
          File localFile2 = new File(str2);
          if (localFile2.exists()) {
            FileUtils.deleteDirectory(localFile2.getAbsolutePath());
          }
          localFile2.mkdirs();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("simpleTheme/");
          localStringBuilder.append(str1);
          localStringBuilder.append(".zip");
          if (!a(paramContext, str2, localStringBuilder.toString())) {
            break label287;
          }
          bool = localFile2.renameTo(localFile1);
          QLog.d("SimpleUIManager", 1, new Object[] { "rename result : ", Boolean.valueOf(bool) });
          if (!bool)
          {
            QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131916956), 0).show();
            ThemeSwitcher.a("1000", "205", null);
            if (localFile1.exists()) {
              FileUtils.deleteDirectory(localFile1.getAbsolutePath());
            }
          }
        }
        return;
      }
      finally {}
      label287:
      boolean bool = false;
    }
  }
  
  private static String f(Context paramContext)
  {
    Object localObject = new ThemeLocator();
    ((ThemeLocator)localObject).a("simpleSkin");
    paramContext = ((ThemeLocator)localObject).a(paramContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("theme3.zip");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.SimpleUIManager
 * JD-Core Version:    0.7.0.1
 */