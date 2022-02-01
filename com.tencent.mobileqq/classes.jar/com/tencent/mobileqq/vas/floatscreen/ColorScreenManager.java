package com.tencent.mobileqq.vas.floatscreen;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.floatscr.IColorScreenManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ColorScreenManager
  extends VasManager<ColorScreenConfig>
  implements IColorScreenManager
{
  private AppInterface a;
  private Context b;
  
  public ColorScreenManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = paramAppInterface.getApp().getApplicationContext();
  }
  
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
      VasMonitorHandler.a(BaseApplicationImpl.getApplication().getRuntime(), "individual_v2_colorscreen_parse_fail", "1", "", Integer.toString(paramInt), null, null, 0.0F, 0.0F);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("errCode:1, id:");
      localStringBuilder1.append(paramInt);
      VasMonitorDT.a("individual_v2_colorscreen_parse_fail", localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
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
    ThreadManager.post(new ColorScreenManager.1(this, paramInt, paramCompleteListener), 5, null, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      i = a(paramString);
      if (i <= 0) {
        break label372;
      }
      localObject1 = null;
      if (paramInt != 0)
      {
        localObject1 = "downloadError";
        break label386;
      }
      Object localObject3 = a(i);
      localObject2 = new File((File)localObject3, "config.zip");
      if (!((File)localObject2).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("zipFileMissing ");
        ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
        localObject1 = ((StringBuilder)localObject1).toString();
        break label386;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject3).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("unzip");
      localObject3 = localStringBuilder.toString();
      try
      {
        FileUtils.uncompressZip(((File)localObject2).getAbsolutePath(), (String)localObject3, false);
      }
      catch (Throwable localThrowable)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uncompressFail ");
        ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
        localObject1 = ((StringBuilder)localObject1).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to unzip ");
        localStringBuilder.append(((File)localObject2).getAbsolutePath());
        QLog.e("ColorScreenManager", 1, localStringBuilder.toString(), localThrowable);
        break label389;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OutOfMemoryError ");
        ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
        localObject1 = ((StringBuilder)localObject1).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to unzip ");
        localStringBuilder.append(((File)localObject2).getAbsolutePath());
        QLog.e("ColorScreenManager", 1, localStringBuilder.toString(), localOutOfMemoryError);
        break label389;
      }
    }
    finally
    {
      label386:
      label389:
      for (;;)
      {
        int i;
        Object localObject1;
        Object localObject2;
        for (;;)
        {
          label372:
          throw paramString;
        }
      }
    }
    localObject2 = b(i);
    a(paramString, localObject2);
    if (localObject2 == null)
    {
      VasMonitorHandler.a(this.a, "individual_v2_colorscreen_download", String.valueOf(paramInt), (String)localObject1, Integer.toString(i), null, null, 0.0F, 0.0F);
      VasMonitorDT.a("individual_v2_colorscreen_download", String.valueOf(paramInt));
    }
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
 * Qualified Name:     com.tencent.mobileqq.vas.floatscreen.ColorScreenManager
 * JD-Core Version:    0.7.0.1
 */