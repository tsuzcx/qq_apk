package com.tencent.mobileqq.vas.floatscreen;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.floatscr.IColorScreenManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ColorScreenManagerImpl
  extends VasManager<ColorScreenConfig>
  implements IColorScreenManager
{
  private AppRuntime a = MobileQQ.sMobileQQ.waitAppRuntime(null);
  private Context b = this.a.getApp().getApplicationContext();
  
  private File a()
  {
    File localFile = new File(this.b.getFilesDir(), "color_screen");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  private ColorScreenConfig b(int paramInt)
  {
    try
    {
      Object localObject3 = new File(a(paramInt), "unzip");
      if (!((File)localObject3).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorScreenManager", 1, "getLocalConfig unzipDir not exist");
        }
        return null;
      }
      File localFile = new File((File)localObject3, "config.json");
      Object localObject2 = new File((File)localObject3, "fullscreen.json");
      if (!localFile.exists())
      {
        QLog.e("ColorScreenManager", 1, "configFile do not exists.");
      }
      else if (!((File)localObject2).exists())
      {
        QLog.e("ColorScreenManager", 1, "animFile do not exists.");
      }
      else
      {
        ColorScreenConfig localColorScreenConfig = new ColorScreenConfig();
        localColorScreenConfig.a = ((File)localObject2).getAbsolutePath();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((File)localObject3).getAbsolutePath());
        localStringBuilder2.append(File.separator);
        localStringBuilder2.append("images");
        localColorScreenConfig.b = localStringBuilder2.toString();
        try
        {
          localObject3 = new JSONObject(FileUtils.readFileContent(localFile));
          localColorScreenConfig.c = (((JSONObject)localObject3).optInt("repeatCount", localColorScreenConfig.c) - 1);
          localColorScreenConfig.d = ((JSONObject)localObject3).optLong("eastInTime", localColorScreenConfig.d);
          localColorScreenConfig.e = ((JSONObject)localObject3).optLong("eastOutTime", localColorScreenConfig.e);
          if (QLog.isColorLevel())
          {
            long l = IOUtil.getCRC32Value((File)localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getLocalConfig crc32: ");
            ((StringBuilder)localObject2).append(Long.toHexString(l));
            QLog.d("ColorScreenManager", 1, ((StringBuilder)localObject2).toString());
          }
          return localColorScreenConfig;
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("failed read config of ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.e("ColorScreenManager", 1, ((StringBuilder)localObject2).toString(), localException);
        }
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("colorScreen.android.");
      localStringBuilder1.append(paramInt);
      c(localStringBuilder1.toString());
      return null;
    }
    finally {}
  }
  
  private void c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("colorScreen.android.");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.a.getRuntimeService(IVasQuickUpdateService.class, "");
    if (localIVasQuickUpdateService != null) {
      localIVasQuickUpdateService.downloadItem(22L, (String)localObject, "ColorScreenManager");
    }
  }
  
  public int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\.");
      if (arrayOfString.length >= 3) {
        try
        {
          int i = Integer.parseInt(arrayOfString[2]);
          return i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    Throwable localThrowable = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getColorScreenId failed from ");
    localStringBuilder.append(paramString);
    QLog.e("ColorScreenManager", 1, localStringBuilder.toString(), localThrowable);
    return 0;
  }
  
  public File a(int paramInt)
  {
    File localFile = new File(a(), Integer.toString(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void a(int paramInt, VasManager.CompleteListener<ColorScreenConfig> paramCompleteListener)
  {
    ThreadManager.post(new ColorScreenManagerImpl.1(this, paramInt, paramCompleteListener), 5, null, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      int i = a(paramString);
      if (i > 0)
      {
        if (paramInt == 0)
        {
          Object localObject = a(i);
          File localFile = new File((File)localObject, "config.zip");
          if (!localFile.exists())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("zipFileMissing ");
            ((StringBuilder)localObject).append(localFile.getAbsolutePath());
            ((StringBuilder)localObject).toString();
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((File)localObject).getAbsolutePath());
            localStringBuilder.append(File.separator);
            localStringBuilder.append("unzip");
            localObject = localStringBuilder.toString();
            try
            {
              FileUtils.uncompressZip(localFile.getAbsolutePath(), (String)localObject, false);
            }
            catch (Throwable localThrowable)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("uncompressFail ");
              localStringBuilder.append(localFile.getAbsolutePath());
              localStringBuilder.toString();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("failed to unzip ");
              localStringBuilder.append(localFile.getAbsolutePath());
              QLog.e("ColorScreenManager", 1, localStringBuilder.toString(), localThrowable);
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("OutOfMemoryError ");
              localStringBuilder.append(localFile.getAbsolutePath());
              localStringBuilder.toString();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("failed to unzip ");
              localStringBuilder.append(localFile.getAbsolutePath());
              QLog.e("ColorScreenManager", 1, localStringBuilder.toString(), localOutOfMemoryError);
            }
          }
        }
        a(paramString, b(i));
      }
      return;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    int i = a(paramString);
    if (i > 0) {
      return new File(a(i), "config.zip").exists();
    }
    return false;
  }
  
  public void c(String paramString)
  {
    VasUpdateUtil.a(new File(a(), Integer.toString(a(paramString))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.floatscreen.ColorScreenManagerImpl
 * JD-Core Version:    0.7.0.1
 */