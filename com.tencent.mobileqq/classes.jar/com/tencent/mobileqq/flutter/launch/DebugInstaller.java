package com.tencent.mobileqq.flutter.launch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import io.flutter.util.PathUtils;
import java.io.File;

public class DebugInstaller
{
  private static final String a;
  private static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qflutter");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qflutter");
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean b()
  {
    if (FileUtil.d(a))
    {
      int i = FileUtils.copyDirectory(a, b, false, true, true);
      if (i == 0)
      {
        QLog.d("QFlutter.launcher", 4, String.format("checkDebugInstall copy result: %s", new Object[] { Integer.valueOf(i) }));
        localObject1 = new File(b).listFiles();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          QLog.d("QFlutter.launcher", 4, String.format("path: %s, time: %s, size: %s byte", new Object[] { localObject2.getAbsolutePath(), Long.valueOf(localObject2.lastModified()), Long.valueOf(localObject2.length()) }));
          i += 1;
        }
        c();
        localObject1 = QFlutterLauncher.InstallResult.a(b, true);
        QFlutterLauncher.a().a((QFlutterLauncher.InstallResult)localObject1);
        return true;
      }
    }
    Object localObject1 = QFlutterLauncher.InstallResult.a(b, false);
    QFlutterLauncher.a().a((QFlutterLauncher.InstallResult)localObject1);
    return false;
  }
  
  private static void c()
  {
    String str1 = PathUtils.getDataDirectory(BaseApplicationImpl.getContext());
    Object localObject = new File(str1);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).list(new DebugInstaller.1());
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str2 = localObject[i];
        File localFile = new File(str1, str2);
        FileUtil.a(localFile);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearTimestamp: ");
        localStringBuilder.append(str2);
        localStringBuilder.append(", ");
        localStringBuilder.append(localFile.getAbsolutePath());
        QLog.d("QFlutter.launcher", 4, localStringBuilder.toString());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.DebugInstaller
 * JD-Core Version:    0.7.0.1
 */