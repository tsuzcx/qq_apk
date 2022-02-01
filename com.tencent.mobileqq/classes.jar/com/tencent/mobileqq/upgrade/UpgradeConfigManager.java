package com.tencent.mobileqq.upgrade;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpgradeConfigManager
{
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        paramString1 = FileUtils.fileToBytes(new File(localFile, localStringBuilder.toString()));
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        paramString1 = null;
      }
      if (paramString1 != null)
      {
        if (paramString1.length <= 0) {
          return null;
        }
        if (Build.VERSION.SDK_INT <= 8) {
          return new String(paramString1);
        }
        try
        {
          paramString1 = new String(paramString1, "UTF-8");
          return paramString1;
        }
        catch (Exception paramString1)
        {
          if (QLog.isDevelopLevel()) {
            paramString1.printStackTrace();
          }
        }
      }
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      FileUtils.writeFile((String)localObject, localStringBuilder.toString(), paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeConfigManager", 2, "save Config to file finish.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("save Config to file failed，content is empty----");
      paramString2.append(paramString1);
      QLog.i("UpgradeConfigManager", 2, paramString2.toString());
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fileName=%s uin=%s", new Object[] { paramString1, paramString2 }));
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      localFile = new File(localFile, localStringBuilder.toString());
      if (localFile.exists()) {
        try
        {
          bool = localFile.delete();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fail! fileName=%s uin=%s", new Object[] { paramString1, paramString2 }), localException);
          }
        }
      }
    }
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fileName=%s uin=%s result=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) }));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeConfigManager
 * JD-Core Version:    0.7.0.1
 */